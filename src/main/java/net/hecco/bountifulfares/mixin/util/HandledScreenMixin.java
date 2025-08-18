package net.hecco.bountifulfares.mixin.util;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(AbstractContainerScreen.class)
public interface HandledScreenMixin {
    // todo not sure
    @Accessor("imageHeight") int bf_getY();
}
