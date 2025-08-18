package net.hecco.bountifulfares.recipe;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.RegisterEvent;


import java.util.HashMap;
import java.util.Map;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class BFSpecialRecipes {
    private static final Map<ResourceKey<RecipeSerializer<?>>, RecipeSerializer<?>> recipeSerializers = new HashMap<>();

    public static final RecipeSerializer<?> CERAMIC_MASS_DYEING = registerSpecialRecipe("ceramic_mass_dyeing", CeramicMassDyeingRecipe::new);

    // public static void registerSpecialRecipes() {
    // }

    private static RecipeSerializer<?> registerSpecialRecipe(String name, SimpleCraftingRecipeSerializer.Factory<?> toRecipe) {
        SimpleCraftingRecipeSerializer<?> serializer = new SimpleCraftingRecipeSerializer<>(toRecipe);
        recipeSerializers.put(ResourceKey.create(Registries.RECIPE_SERIALIZER, BountifulFares.rl(name)), serializer);
        return serializer;
    }

    @SubscribeEvent
    public static void blockRegister(RegisterEvent event) {
        event.register(Registries.RECIPE_SERIALIZER, registerHelper -> {
            recipeSerializers.forEach(registerHelper::register);
        });
    }
}
