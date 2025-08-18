package net.hecco.bountifulfares.mixin.util;

import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(PotionBrewing.class)
public interface BrewingRecipeRegistryMixin {
    @Invoker("addMix")
    static void addMix(Holder<Potion> input, Item reagent, Holder<Potion> result) {
    }

    // @Inject(method = "bootStrap", at = @At("TAIL"))
    // private static void registerDefaults(CallbackInfo ci) {

    // }
}