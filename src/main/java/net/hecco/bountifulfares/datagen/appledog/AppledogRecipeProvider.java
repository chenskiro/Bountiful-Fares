package net.hecco.bountifulfares.datagen.appledog;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.hecco.bountifulfares.compat.appledog.AppledogBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;

import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;

import static net.hecco.bountifulfares.BountifulFares.APPLEDOG_MOD_ID;

public class AppledogRecipeProvider extends RecipeProvider {

    public AppledogRecipeProvider(PackOutput generator) {
        super(generator);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> exporter) {
        threeByThreePacker(exporter, RecipeCategory.MISC, AppledogBlocks.APPLEDOG_BLOCK.get(), BuiltInRegistries.ITEM.get(ResourceLocation.tryBuild(APPLEDOG_MOD_ID, "dogapple")));
    }
}
