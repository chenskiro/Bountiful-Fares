package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import java.util.List;

public class EffectFoodItem extends Item {
    public final List<MobEffectInstance> effects;
    public EffectFoodItem(List<MobEffectInstance> effects, Properties settings) {
        super(settings);
        this.effects = effects;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipType type) {
        super.appendHoverText(stack, context, tooltip, type);
        if (effects != null && !effects.isEmpty() && BountifulFares.CONFIG.effectTooltips) {
            PotionContentsComponent.buildTooltip(effects, tooltip::add, 1.0F, context.getUpdateTickRate());
        }
    }
}
