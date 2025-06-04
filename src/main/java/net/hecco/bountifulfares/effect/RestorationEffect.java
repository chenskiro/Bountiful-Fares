package net.hecco.bountifulfares.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.player.Player;

public class RestorationEffect extends MobEffect {
    private float regenMax;
    public RestorationEffect(MobEffectCategory category, int color) {
        super(category, color);
        this.regenMax = 0;
    }

    // @Override
    // public void onApplied(LivingEntity entity, int amplifier) {
    //     float health = entity.getHealth();
    //     float maxHealth = entity.getMaxHealth();
    //     regenMax = health;
    //     super.addAttributeModifiers(entity, amplifier);
    // }

    public void addAttributeModifiers(LivingEntity entity, AttributeMap pAttributeMap, int pAmplifier) {
        float health = entity.getHealth();
        float maxHealth = entity.getMaxHealth();
        regenMax = health;
        super.addAttributeModifiers(entity, pAttributeMap, pAmplifier);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        float health = entity.getHealth();
        float maxHealth = entity.getMaxHealth();
        if (health < regenMax && health < maxHealth) {
            entity.heal(0.1f * (amplifier + 1));
        }
        super.applyEffectTick(entity, amplifier);
    }

    // @Override
    // public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
    //     float health = entity.getHealth();
    //     float maxHealth = entity.getMaxHealth();
    //     if (health < regenMax && health < maxHealth) {
    //         entity.heal(0.1f * (amplifier + 1));
    //     }
    //     super.applyEffectTick(entity, amplifier);
    //     return true;
    // }


    @Override
    public void removeAttributeModifiers(LivingEntity pLivingEntity, AttributeMap pAttributeMap, int pAmplifier) {
        regenMax = 0;
        super.removeAttributeModifiers(pLivingEntity, pAttributeMap, pAmplifier);
    }

    // @Override
    // public void onRemoved(AttributeMap attributeContainer) {
    //     regenMax = 0;
    //     super.removeAttributeModifiers(attributeContainer);
    // }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
