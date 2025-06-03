package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.ChatFormatting;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import java.util.List;

public class MeadBottleItem extends LiquidBottleItem {
    public MeadBottleItem(Properties settings) {
        super(settings);
    }
    public MeadBottleItem(List<MobEffectInstance> effects, Properties settings) {
        super(settings);
        this.effects = effects;
    }
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        super.finishUsingItem(stack, world, user);
        if (user.getEffect(MobEffects.POISON) != null) {
            user.removeEffect(MobEffects.POISON);
        }
        return stack;
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        if (BountifulFares.CONFIG.effectTooltips) {
            tooltip.add(CommonComponents.EMPTY);
            tooltip.add(Component.translatable("tooltip.bountifulfares.removes").withStyle(ChatFormatting.GRAY));
            tooltip.add(Component.translatable(new MobEffectInstance(MobEffects.POISON).getDescriptionId().formatted(MobEffects.POISON.value().getCategory().getFormatting())).formatted(ChatFormatting.RED));
        }
    }
}
