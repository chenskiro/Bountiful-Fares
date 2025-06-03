package net.hecco.bountifulfares.mixin.gameplay;

import com.google.common.collect.Maps;
import net.hecco.bountifulfares.registry.content.BFEffects;
import net.hecco.bountifulfares.registry.tags.BFEffectTags;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;
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

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Shadow
    private final Map<Holder<MobEffect>, MobEffectInstance> activeStatusEffects = Maps.newHashMap();
    @Shadow
    public final boolean addStatusEffect(MobEffectInstance effect) {
        return true;
    }
    @Shadow
    public boolean removeStatusEffect(Holder<MobEffect> effect) {
        return true;
    }

    @Shadow
    protected void onStatusEffectRemoved(MobEffectInstance effect){}

    @Shadow protected abstract void onStatusEffectUpgraded(MobEffectInstance effect, boolean reapplyEffect, @Nullable Entity source);

    @Shadow private boolean effectsChanged;

    @Inject(method = "addStatusEffect(Lnet/minecraft/entity/effect/StatusEffectInstance;Lnet/minecraft/entity/Entity;)Z", at = @At("HEAD"))
    private void bountifulfares_acidicApply(MobEffectInstance effect, @Nullable Entity source, CallbackInfoReturnable<Boolean> cir) {
        if (effect.getEffect() == BFEffects.STUPOR) {
            Iterator<Map.Entry<Holder<MobEffect>, MobEffectInstance>> iterator = this.activeStatusEffects.entrySet().iterator();
            ArrayList<MobEffectInstance> removedEffects = new ArrayList<>();
            while (iterator.hasNext()) {
                Map.Entry<Holder<MobEffect>, MobEffectInstance> entry = iterator.next();
                if (entry.getKey() != BFEffects.STUPOR && !entry.getKey().is(BFEffectTags.STUPOR_BLACKLIST)) {
                    removedEffects.add(entry.getValue());
                }
            }

            for (MobEffectInstance instance : removedEffects) {
                this.removeStatusEffect(instance.getEffect());
                this.effectsChanged = true;
            }
        } else if (!this.activeStatusEffects.containsKey(BFEffects.ACIDIC) && effect.getEffect() == BFEffects.ACIDIC) {
            int acidicAmplifier = effect.getAmplifier();
            Iterator<Map.Entry<Holder<MobEffect>, MobEffectInstance>> iterator = this.activeStatusEffects.entrySet().iterator();
            ArrayList<MobEffectInstance> newEffects = new ArrayList<>();
            while (iterator.hasNext()) {
                Map.Entry<Holder<MobEffect>, MobEffectInstance> entry = iterator.next();
                if (entry.getKey() != BFEffects.ACIDIC && !entry.getKey().is(BFEffectTags.ACIDIC_BLACKLIST)) {
                    int amplifier = Math.min(entry.getValue().getAmplifier() + acidicAmplifier + 1, 255);
                    newEffects.add(new MobEffectInstance(entry.getKey(), entry.getValue().getDuration(), amplifier, entry.getValue().isAmbient(), entry.getValue().isVisible(), entry.getValue().showIcon()));
                }
            }

            for (MobEffectInstance instance : newEffects) {
                this.removeStatusEffect(instance.getEffect());
                this.addStatusEffect(instance);
                this.onStatusEffectUpgraded(instance, true, null);
            }
        } else if (this.activeStatusEffects.containsKey(BFEffects.ACIDIC) && effect.getEffect() == BFEffects.ACIDIC && this.activeStatusEffects.get(BFEffects.ACIDIC).getAmplifier() < effect.getAmplifier()) {
            int acidicAmplifier = effect.getAmplifier();
            Iterator<Map.Entry<Holder<MobEffect>, MobEffectInstance>> iterator = this.activeStatusEffects.entrySet().iterator();
            ArrayList<MobEffectInstance> newEffects = new ArrayList<>();
            while (iterator.hasNext()) {
                Map.Entry<Holder<MobEffect>, MobEffectInstance> entry = iterator.next();
                if (entry.getKey() != BFEffects.ACIDIC && !entry.getKey().is(BFEffectTags.ACIDIC_BLACKLIST)) {
                    int amplifier = Math.min((entry.getValue().getAmplifier() - (this.activeStatusEffects.get(BFEffects.ACIDIC).getAmplifier() * 2)) + acidicAmplifier, 255);
                    newEffects.add(new MobEffectInstance(entry.getKey(), entry.getValue().getDuration(), amplifier, entry.getValue().isAmbient(), entry.getValue().isVisible(), entry.getValue().showIcon()));
                }
            }
            this.activeStatusEffects.remove(BFEffects.ACIDIC);
            for (MobEffectInstance instance : newEffects) {
                this.removeStatusEffect(instance.getEffect());
                this.addStatusEffect(instance);
                this.onStatusEffectUpgraded(instance, true, null);
            }
        }
    }

//    @Inject(method = "onStatusEffectUpgraded", at = @At("HEAD"))
//    private void bountifulfares_acidicUpgrade(StatusEffectInstance effect, boolean reapplyEffect, @Nullable Entity source, CallbackInfo ci) {
//        if (reapplyEffect && effect.getEffectType() == BFEffects.ACIDIC && this.activeStatusEffects.get(BFEffects.ACIDIC).getAmplifier() != effect.getAmplifier()) {
//            int acidicAmplifier = effect.getAmplifier();
//            Iterator<Map.Entry<RegistryEntry<StatusEffect>, StatusEffectInstance>> iterator = this.activeStatusEffects.entrySet().iterator();
//            ArrayList<StatusEffectInstance> newEffects = new ArrayList<>();
//            while (iterator.hasNext()) {
//                Map.Entry<RegistryEntry<StatusEffect>, StatusEffectInstance> entry = iterator.next();
//                if (entry.getKey() != BFEffects.ACIDIC && !entry.getKey().isIn(BFEffectTags.ACIDIC_BLACKLIST)) {
//                    int amplifier = Math.min(entry.getValue().getAmplifier() - this.activeStatusEffects.get(BFEffects.ACIDIC).getAmplifier() + acidicAmplifier, 255);
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

        @ModifyVariable(method = "addStatusEffect(Lnet/minecraft/entity/effect/StatusEffectInstance;Lnet/minecraft/entity/Entity;)Z", at = @At("HEAD"), argsOnly = true)
    private MobEffectInstance bountifulfares_ifAcidicPresent(MobEffectInstance effect) {
         if (activeStatusEffects.containsKey(BFEffects.ACIDIC)) {
            if (effect.getEffect() != BFEffects.ACIDIC && !effect.getEffect().isIn(BFEffectTags.ACIDIC_BLACKLIST)) {
                int amplifier = Math.min(effect.getAmplifier() + activeStatusEffects.get(BFEffects.ACIDIC).getAmplifier() + 1, 255);
                return new MobEffectInstance(effect.getEffect(), effect.getDuration(), amplifier, effect.isAmbient(), effect.isVisible(), effect.showIcon());
            }
        }
        return effect;
    }
    @Inject(method = "onStatusEffectRemoved", at = @At("HEAD"))
    private void bountifulfares_acidicRemove(MobEffectInstance effect, CallbackInfo ci) {
        if (effect.getEffect() == BFEffects.ACIDIC && !this.activeStatusEffects.containsKey(BFEffects.ACIDIC)) {
            int acidicAmplifier = effect.getAmplifier();
            Iterator<Map.Entry<Holder<MobEffect>, MobEffectInstance>> iterator = this.activeStatusEffects.entrySet().iterator();
            ArrayList<MobEffectInstance> newEffects = new ArrayList<>();
            while (iterator.hasNext()) {
                Map.Entry<Holder<MobEffect>, MobEffectInstance> entry = iterator.next();
                if (entry.getKey() != BFEffects.ACIDIC && !entry.getKey().is(BFEffectTags.ACIDIC_BLACKLIST)) {
                    int amplifier = Math.max(entry.getValue().getAmplifier() - acidicAmplifier - 1, 0);
                    newEffects.add(new MobEffectInstance(entry.getKey(), entry.getValue().getDuration(), amplifier, entry.getValue().isAmbient(), entry.getValue().isVisible(), entry.getValue().showIcon()));
                }
            }

            for (MobEffectInstance instance : newEffects) {
                this.removeStatusEffect(instance.getEffect());
                this.addStatusEffect(instance);
                this.onStatusEffectUpgraded(instance, true, null);
            }
        }
    }

    @Inject(method = "addStatusEffect(Lnet/minecraft/entity/effect/StatusEffectInstance;Lnet/minecraft/entity/Entity;)Z", at = @At("HEAD"), cancellable = true)
    private void bountifulfares_stupor(MobEffectInstance effect, @Nullable Entity source, CallbackInfoReturnable<Boolean> cir) {
        if (activeStatusEffects.containsKey(BFEffects.STUPOR)) {
            if (effect.getEffect() != BFEffects.STUPOR && !effect.getEffect().isIn(BFEffectTags.STUPOR_BLACKLIST)) {
                cir.setReturnValue(false);
                cir.cancel();
            }
        }
    }
}
