package net.hecco.bountifulfares.registry.misc;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.recipe.FermentationRecipe;
import net.hecco.bountifulfares.recipe.MillingRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.RegisterEvent;


import java.util.HashMap;
import java.util.Map;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class BFRecipes {
    private static final Map<ResourceKey<RecipeType<?>>, RecipeType<?>> recipeTypes = new HashMap<>();
    private static final Map<ResourceKey<RecipeSerializer<?>>, RecipeSerializer<?>> recipeSerializers = new HashMap<>();

    public static final RecipeType<MillingRecipe> MILLING = register("milling", MillingRecipe.Type.INSTANCE);
    public static final RecipeType<FermentationRecipe> FERMENTING = register("fermenting", FermentationRecipe.Type.INSTANCE);

    public static <T extends Recipe<?>> RecipeType<T> register(final String id, RecipeType<T> recipeType) {
        // return Registry.register(BuiltInRegistries.RECIPE_TYPE, BountifulFares.rl(id),recipeType );
        recipeTypes.put(ResourceKey.create(Registries.RECIPE_TYPE, BountifulFares.rl(id)), recipeType);
        return recipeType;
    }

    public static final RecipeSerializer<MillingRecipe> MILLING_SERIALIZER = registerSerializer("milling",
            MillingRecipe.Serializer.INSTANCE);

    public static final RecipeSerializer<FermentationRecipe> FERMENTING_SERIALIZER = registerSerializer("fermenting",
            FermentationRecipe.Serializer.INSTANCE);

    public static <S extends RecipeSerializer<T>, T extends Recipe<?>> S registerSerializer(String id, S serializer) {
        // return Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, BountifulFares.rl( id), serializer);
        recipeSerializers.put(ResourceKey.create(Registries.RECIPE_SERIALIZER, BountifulFares.rl(id)), serializer);
        return serializer;
    }

    // public static void registerRecipes() {
    // }

    @SubscribeEvent
    public static void onRegister(RegisterEvent event) {
        event.register(Registries.RECIPE_TYPE, registerHelper -> {
            recipeTypes.forEach(registerHelper::register);
        });
        event.register(Registries.RECIPE_SERIALIZER, registerHelper -> {
            recipeSerializers.forEach(registerHelper::register);
        });
    }
}
