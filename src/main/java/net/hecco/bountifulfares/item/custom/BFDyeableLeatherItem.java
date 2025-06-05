package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.block.entity.CeramicDishBlockEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.ItemStack;

public interface BFDyeableLeatherItem extends DyeableLeatherItem {
    int DEFAULT_LEATHER_COLOR = CeramicDishBlockEntity.DEFAULT_COLOR;

    @Override
    default int getColor(ItemStack pStack) {
        CompoundTag compoundtag = pStack.getTagElement("display");
        return compoundtag != null && compoundtag.contains("color", Tag.TAG_ANY_NUMERIC) ?
                compoundtag.getInt("color") : DEFAULT_LEATHER_COLOR;
    }

    static boolean hasColorStatic(ItemStack stack) {
        return stack.getItem() instanceof BFDyeableLeatherItem bfDyeableLeatherItem && bfDyeableLeatherItem.hasCustomColor(stack);
    }

    static int getColorStatic(ItemStack stack) {
        return stack.getItem() instanceof BFDyeableLeatherItem bfDyeableLeatherItem?
                bfDyeableLeatherItem.getColor(stack):DEFAULT_LEATHER_COLOR;
    }
}
