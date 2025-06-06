package net.hecco.bountifulfares.datagen.dungeons_delight;

import net.hecco.bountifulfares.datagen.trellis.TrellisUtilProvider;
import net.minecraft.data.recipes.RecipeProvider;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.compat.dungeons_delight.DungeonsDelightBlocks;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.minecraft.core.HolderLookup;

import net.minecraft.resources.ResourceLocation;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import static net.hecco.bountifulfares.datagen.bountifulfares.BFRecipeProvider.offerPicketsRecipe;

public class DungeonsDelightRecipeProvider extends RecipeProvider {
    public DungeonsDelightRecipeProvider(PackOutput generator) {
        super(generator);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> exporter) {
        TrellisUtilProvider.registerCompatTrellisRecipe(exporter, DungeonsDelightBlocks.WORMWOOD);
        offerPicketsRecipe(exporter, DungeonsDelightBlocks.WORMWOOD_PICKETS.get(), ResourceLocation.tryBuild(BountifulFares.DUNGEONS_DELIGHT_MOD_ID, "wormwood_planks"));
    }
}
