package net.hecco.bountifulfares.registry.util;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import java.util.List;

public class BFTooltipEvents {
    public static void addTooltipsToVanillaItems(ItemStack itemStack, Item.TooltipContext tooltipContext, TooltipType tooltipType, List<Component> tooltip) {
        if (BountifulFares.CONFIG.effectTooltips) {
            if (itemStack.getItem() == Items.MILK_BUCKET) {
                tooltip.add(CommonComponents.EMPTY);
                tooltip.add(Component.translatable("tooltip.bountifulfares.when_drunk").withStyle(ChatFormatting.GRAY));
                tooltip.add(Component.translatable("tooltip.bountifulfares.removes_all_effects").withStyle(ChatFormatting.BLUE));
            } else if (itemStack.getItem() == Items.HONEY_BOTTLE) {
                tooltip.add(CommonComponents.EMPTY);
                tooltip.add(Component.translatable("tooltip.bountifulfares.removes").withStyle(ChatFormatting.GRAY));
                tooltip.add(Component.translatable(new MobEffectInstance(MobEffects.POISON).getDescriptionId().formatted(MobEffects.POISON.value().getCategory().getFormatting())).formatted(ChatFormatting.RED));
            }
        }
    }
}
