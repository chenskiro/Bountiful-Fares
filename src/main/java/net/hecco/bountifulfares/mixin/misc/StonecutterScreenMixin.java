package net.hecco.bountifulfares.mixin.misc;

import net.hecco.bountifulfares.item.custom.ArtisanBrushItem;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.StonecutterScreen;

import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.StonecutterMenu;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(StonecutterScreen.class)
public abstract class StonecutterScreenMixin extends AbstractContainerScreen<StonecutterMenu> {

    public StonecutterScreenMixin(StonecutterMenu handler, Inventory inventory, Component title) {
        super(handler, inventory, title);
    }

    @ModifyArg(method = "renderRecipes", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;renderItem(Lnet/minecraft/world/item/ItemStack;II)V"))
    public ItemStack bountifulfares$renderRecipeIcons(ItemStack itemStack) {
        // note to Hecco: you can change this if statement to your liking, maybe have a list of all ceramic block items instead
        // because this currently will apply to ANY dyeable item put into stonecutter that has recipes
        // not that it is a bad thing, just saying...
        // if you DO change it, also check out StonecutterScreenHandlerMixin
        if (this.menu.getSlot(0).getItem().has(DataComponents.DYED_COLOR)) {
            itemStack.set(DataComponents.DYED_COLOR, this.menu.getSlot(0).getItem().get(DataComponents.DYED_COLOR));
        }
        return itemStack;
    }
}