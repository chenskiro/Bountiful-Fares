package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import java.util.List;

public class ItemWithInfo extends Item {
    public ItemWithInfo(Properties settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipType type) {
        //        if (BountifulFares.CONFIG.isEnableItemGuideTooltips()) {
//            if (Screen.hasShiftDown()) {
//                writeInfo(tooltip);
//            } else {
//                tooltip.add(Text.literal("§8Hold Shift for More Info..."));
//            }
//        }
        super.appendHoverText(stack, context, tooltip, type);
    }

    public void writeInfo(List<Component> tooltip) {
        if (this == BFBlocks.FERMENTATION_VESSEL.asItem()) {
            tooltip.add(Component.literal("§7"+"Can be used to ferment ingredients"));
            tooltip.add(Component.literal("§7"+"into new ones."));
            tooltip.add(Component.literal("§7"+"Fill the vessel with a Water Bottle"));
            tooltip.add(Component.literal("§7"+"and an item to ferment something."));
        }
    }
}
