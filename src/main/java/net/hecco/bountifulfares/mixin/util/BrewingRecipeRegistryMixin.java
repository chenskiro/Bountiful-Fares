package net.hecco.bountifulfares.mixin.util;

import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.content.BFPotions;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.event.brewing.PotionBrewEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PotionBrewing.class)
public interface BrewingRecipeRegistryMixin {
    @Invoker("addMix")
    static void addMix(Potion pPotionEntry, Item pPotionIngredient, Potion pPotionResult) {
    }

    // @Inject(method = "bootStrap", at = @At("TAIL"))
    // private static void registerDefaults(CallbackInfo ci) {

    // }
}