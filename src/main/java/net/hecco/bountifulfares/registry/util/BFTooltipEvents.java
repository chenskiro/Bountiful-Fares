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
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;


import java.util.List;

@EventBusSubscriber(modid = BountifulFares.MOD_ID)
public class BFTooltipEvents {

    @SubscribeEvent
    public static void addTooltipsToVanillaItems(ItemTooltipEvent event) {
        if (BountifulFares.CONFIG.effectTooltips) {
            Item item = event.getItemStack().getItem();
            List<Component> tooltip = event.getToolTip();
            if (item == Items.MILK_BUCKET) {
                tooltip.add(CommonComponents.EMPTY);
                tooltip.add(Component.translatable("tooltip.bountifulfares.when_drunk").withStyle(ChatFormatting.GRAY));
                tooltip.add(Component.translatable("tooltip.bountifulfares.removes_all_effects").withStyle(ChatFormatting.BLUE));
            } else if (item == Items.HONEY_BOTTLE) {
                tooltip.add(CommonComponents.EMPTY);
                tooltip.add(Component.translatable("tooltip.bountifulfares.removes").withStyle(ChatFormatting.GRAY));
                tooltip.add(Component.translatable(new MobEffectInstance(MobEffects.POISON).getDescriptionId().formatted(MobEffects.POISON.value().getCategory().getTooltipFormatting())).withStyle(ChatFormatting.RED));
            }
        }
    }
}
