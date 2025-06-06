package net.hecco.bountifulfares.datagen.spawn;

import net.hecco.bountifulfares.datagen.trellis.TrellisUtilProvider;
import net.minecraft.data.recipes.RecipeProvider;
import net.hecco.bountifulfares.compat.spawn.SpawnBlocks;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.minecraft.core.HolderLookup;

import net.minecraft.resources.ResourceLocation;
import java.util.concurrent.CompletableFuture;

import static net.hecco.bountifulfares.BountifulFares.SPAWN_MOD_ID;
import static net.hecco.bountifulfares.datagen.bountifulfares.BFRecipeProvider.offerPicketsRecipe;
import java.util.function.Consumer;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
public class SpawnRecipeProvider extends RecipeProvider {
    public SpawnRecipeProvider(PackOutput generator) {
        super(generator);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> exporter) {
        TrellisUtilProvider.registerCompatTrellisRecipe(exporter, SpawnBlocks.ROTTEN);
        offerPicketsRecipe(exporter, SpawnBlocks.ROTTEN_PICKETS.get(), ResourceLocation.tryBuild(SPAWN_MOD_ID, "rotten_planks"));
    }
}
