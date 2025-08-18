package net.hecco.bountifulfares.recipe;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.common.EventBusSubscriber;

import net.minecraftforge.registries.RegisterEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class BFSpecialRecipes {
    private static final Map<ResourceKey<RecipeSerializer<?>>, RecipeSerializer<?>> recipeSerializers = new HashMap<>();

    public static final RecipeSerializer<?> CERAMIC_MASS_DYEING = registerSpecialRecipe("ceramic_mass_dyeing", CeramicMassDyeingRecipe::new);

    // public static void registerSpecialRecipes() {
    // }

    private static RecipeSerializer<?> registerSpecialRecipe(String name,SimpleCraftingRecipeSerializer.Factory<?> toRecipe){
        return recipeSerializers.put(ResourceKey.create(Registries.RECIPE_SERIALIZER,BountifulFares.rl( name)),
                new SimpleCraftingRecipeSerializer<>(toRecipe));
    }

    @SubscribeEvent
    public static void blockRegister(RegisterEvent event) {
        event.register(Registries.RECIPE_SERIALIZER, registerHelper -> {
            recipeSerializers.forEach(registerHelper::register);
        });
    }
}
