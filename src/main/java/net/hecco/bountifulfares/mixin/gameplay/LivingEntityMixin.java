package net.hecco.bountifulfares.mixin.gameplay;

import com.google.common.collect.Maps;
import net.hecco.bountifulfares.registry.content.BFEffects;
import net.hecco.bountifulfares.registry.tags.BFEffectTags;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Shadow
    private boolean effectsDirty;

    @Shadow
    public abstract boolean removeEffect(MobEffect pEffect);

    @Shadow
    @Final
    private Map<MobEffect, MobEffectInstance> activeEffects;

    @Shadow
    public abstract boolean addEffect(MobEffectInstance pEffectInstance, @Nullable Entity pEntity);

    @Shadow
    public abstract boolean addEffect(MobEffectInstance pEffectInstance);

    @Shadow
    protected abstract void onEffectUpdated(MobEffectInstance pEffectInstance, boolean pForced, @Nullable Entity pEntity);

    @Inject(method = "addEffect(Lnet/minecraft/world/effect/MobEffectInstance;Lnet/minecraft/world/entity/Entity;)Z", at = @At("HEAD"))
    private void bountifulfares_acidicApply(MobEffectInstance effect, @Nullable Entity source, CallbackInfoReturnable<Boolean> cir) {
        if (effect.getEffect() == BFEffects.STUPOR) {
            Iterator<Map.Entry<MobEffect, MobEffectInstance>> iterator = this.activeEffects.entrySet().iterator();
            ArrayList<MobEffectInstance> removedEffects = new ArrayList<>();
            while (iterator.hasNext()) {
                Map.Entry<MobEffect, MobEffectInstance> entry = iterator.next();
                if (entry.getKey() != BFEffects.STUPOR) {
                    Optional<Holder<MobEffect>> optionalHolder = ForgeRegistries.MOB_EFFECTS.getHolder(entry.getKey());
                    if (optionalHolder.isPresent() && !optionalHolder.get().is(BFEffectTags.STUPOR_BLACKLIST)) {
                        removedEffects.add(entry.getValue());
                    }
                }
            }

            for (MobEffectInstance instance : removedEffects) {
                this.removeEffect(instance.getEffect());
                this.effectsDirty = true;
            }
        } else if (!this.activeEffects.containsKey(BFEffects.ACIDIC) && effect.getEffect() == BFEffects.ACIDIC) {
            int acidicAmplifier = effect.getAmplifier();
            Iterator<Map.Entry<MobEffect, MobEffectInstance>> iterator = this.activeEffects.entrySet().iterator();
            ArrayList<MobEffectInstance> newEffects = new ArrayList<>();
            while (iterator.hasNext()) {
                Map.Entry<MobEffect, MobEffectInstance> entry = iterator.next();
                if (entry.getKey() != BFEffects.ACIDIC) {
                    Optional<Holder<MobEffect>> optionalHolder = ForgeRegistries.MOB_EFFECTS.getHolder(entry.getKey());
                    if (optionalHolder.isPresent() && !optionalHolder.get().is(BFEffectTags.ACIDIC_BLACKLIST)) {
                        int amplifier = Math.min(entry.getValue().getAmplifier() + acidicAmplifier + 1, 255);
                        newEffects.add(new MobEffectInstance(entry.getKey(), entry.getValue().getDuration(), amplifier, entry.getValue().isAmbient(), entry.getValue().isVisible(), entry.getValue().showIcon()));
                    }
                }
            }

            for (MobEffectInstance instance : newEffects) {
                this.removeEffect(instance.getEffect());
                this.addEffect(instance);
                this.onEffectUpdated(instance, true, null);
            }
        } else if (this.activeEffects.containsKey(BFEffects.ACIDIC) && effect.getEffect() == BFEffects.ACIDIC && this.activeEffects.get(BFEffects.ACIDIC).getAmplifier() < effect.getAmplifier()) {
            int acidicAmplifier = effect.getAmplifier();
            Iterator<Map.Entry<MobEffect, MobEffectInstance>> iterator = this.activeEffects.entrySet().iterator();
            ArrayList<MobEffectInstance> newEffects = new ArrayList<>();
            while (iterator.hasNext()) {
                Map.Entry<MobEffect, MobEffectInstance> entry = iterator.next();
                if (entry.getKey() != BFEffects.ACIDIC) {
                    Optional<Holder<MobEffect>> optionalHolder = ForgeRegistries.MOB_EFFECTS.getHolder(entry.getKey());
                    if (optionalHolder.isPresent() && !optionalHolder.get().is(BFEffectTags.ACIDIC_BLACKLIST)) {
                        int amplifier = Math.min((entry.getValue().getAmplifier() - (this.activeEffects.get(BFEffects.ACIDIC).getAmplifier() * 2)) + acidicAmplifier, 255);
                        newEffects.add(new MobEffectInstance(entry.getKey(), entry.getValue().getDuration(), amplifier, entry.getValue().isAmbient(), entry.getValue().isVisible(), entry.getValue().showIcon()));
                    }
                }
            }
            this.activeEffects.remove(BFEffects.ACIDIC);
            for (MobEffectInstance instance : newEffects) {
                this.removeEffect(instance.getEffect());
                this.addEffect(instance);
                this.onEffectUpdated(instance, true, null);
            }
        }
    }

//    @Inject(method = "onStatusEffectUpgraded", at = @At("HEAD"))
//    private void bountifulfares_acidicUpgrade(StatusEffectInstance effect, boolean reapplyEffect, @Nullable Entity source, CallbackInfo ci) {
//        if (reapplyEffect && effect.getEffectType() == BFEffects.ACIDIC && this.activeEffects.get(BFEffects.ACIDIC).getAmplifier() != effect.getAmplifier()) {
//            int acidicAmplifier = effect.getAmplifier();
//            Iterator<Map.Entry<RegistryEntry<StatusEffect>, StatusEffectInstance>> iterator = this.activeEffects.entrySet().iterator();
//            ArrayList<StatusEffectInstance> newEffects = new ArrayList<>();
//            while (iterator.hasNext()) {
//                Map.Entry<RegistryEntry<StatusEffect>, StatusEffectInstance> entry = iterator.next();
//                if (entry.getKey() != BFEffects.ACIDIC && !entry.getKey().isIn(BFEffectTags.ACIDIC_BLACKLIST)) {
//                    int amplifier = Math.min(entry.getValue().getAmplifier() - this.activeEffects.get(BFEffects.ACIDIC).getAmplifier() + acidicAmplifier, 255);
//                    newEffects.add(new StatusEffectInstance(entry.getKey(), entry.getValue().getDuration(), amplifier, entry.getValue().isAmbient(), entry.getValue().shouldShowParticles(), entry.getValue().shouldShowIcon()));
//                }
//            }
//
//            for (StatusEffectInstance instance : newEffects) {
//                this.removeStatusEffect(instance.getEffectType());
//                this.addStatusEffect(instance);
//                this.onStatusEffectUpgraded(instance, true, null);
//            }
//        }
//    }

    @ModifyVariable(method = "addEffect(Lnet/minecraft/world/effect/MobEffectInstance;Lnet/minecraft/world/entity/Entity;)Z", at = @At("HEAD"), argsOnly = true)
    private MobEffectInstance bountifulfares_ifAcidicPresent(MobEffectInstance effect) {
        MobEffect effectEffect = effect.getEffect();
        if (effectEffect != BFEffects.ACIDIC && activeEffects.containsKey(BFEffects.ACIDIC)) {
            Optional<Holder<MobEffect>> optionalHolder = ForgeRegistries.MOB_EFFECTS.getHolder(effectEffect);
            if (optionalHolder.isPresent() && !optionalHolder.get().is(BFEffectTags.ACIDIC_BLACKLIST)) {
                int amplifier = Math.min(effect.getAmplifier() + activeEffects.get(BFEffects.ACIDIC).getAmplifier() + 1, 255);
                return new MobEffectInstance(effectEffect, effect.getDuration(), amplifier, effect.isAmbient(), effect.isVisible(), effect.showIcon());
            }
        }
        return effect;
    }

    @Inject(method = "onEffectRemoved", at = @At("HEAD"))
    private void bountifulfares_acidicRemove(MobEffectInstance effect, CallbackInfo ci) {
        if (effect.getEffect() == BFEffects.ACIDIC && !this.activeEffects.containsKey(BFEffects.ACIDIC)) {
            int acidicAmplifier = effect.getAmplifier();
            Iterator<Map.Entry<MobEffect, MobEffectInstance>> iterator = this.activeEffects.entrySet().iterator();
            ArrayList<MobEffectInstance> newEffects = new ArrayList<>();
            while (iterator.hasNext()) {
                Map.Entry<MobEffect, MobEffectInstance> entry = iterator.next();
                if (entry.getKey() != BFEffects.ACIDIC) {
                    Optional<Holder<MobEffect>> optionalHolder = ForgeRegistries.MOB_EFFECTS.getHolder(entry.getKey());
                    if (optionalHolder.isPresent() && !optionalHolder.get().is(BFEffectTags.ACIDIC_BLACKLIST)) {
                        int amplifier = Math.max(entry.getValue().getAmplifier() - acidicAmplifier - 1, 0);
                        newEffects.add(new MobEffectInstance(entry.getKey(), entry.getValue().getDuration(), amplifier, entry.getValue().isAmbient(), entry.getValue().isVisible(), entry.getValue().showIcon()));
                    }
                }
            }

            for (MobEffectInstance instance : newEffects) {
                this.removeEffect(instance.getEffect());
                this.addEffect(instance);
                this.onEffectUpdated(instance, true, null);
            }
        }
    }

    @Inject(method = "addEffect(Lnet/minecraft/world/effect/MobEffectInstance;Lnet/minecraft/world/entity/Entity;)Z", at = @At("HEAD"), cancellable = true)
    private void bountifulfares_stupor(MobEffectInstance effect, @Nullable Entity source, CallbackInfoReturnable<Boolean> cir) {
        MobEffect effectEffect = effect.getEffect();
        if (effectEffect != BFEffects.STUPOR && activeEffects.containsKey(BFEffects.STUPOR)) {
            Optional<Holder<MobEffect>> optionalHolder = ForgeRegistries.MOB_EFFECTS.getHolder(effectEffect);
            if (optionalHolder.isPresent() && !optionalHolder.get().is(BFEffectTags.STUPOR_BLACKLIST)) {
                cir.setReturnValue(false);
                cir.cancel();
            }
        }
    }
}
