package net.hecco.bountifulfares.datagen.natures_spirit;

import net.hecco.bountifulfares.datagen.trellis.TrellisUtilProvider;
import net.minecraft.data.recipes.RecipeProvider;
import net.hecco.bountifulfares.compat.natures_spirit.NaturesSpiritBlocks;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.minecraft.core.HolderLookup;

import net.minecraft.resources.ResourceLocation;
import java.util.concurrent.CompletableFuture;

import static net.hecco.bountifulfares.BountifulFares.NATURES_SPIRIT_MOD_ID;
import static net.hecco.bountifulfares.datagen.bountifulfares.BFRecipeProvider.offerPicketsRecipe;
import java.util.function.Consumer;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
public class NaturesSpiritRecipeProvider extends RecipeProvider {
    public NaturesSpiritRecipeProvider(PackOutput generator) {
        super(generator);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> exporter) {
        TrellisUtilProvider.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.REDWOOD);
        TrellisUtilProvider.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.SUGI);
        TrellisUtilProvider.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.WISTERIA);
        TrellisUtilProvider.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.FIR);
        TrellisUtilProvider.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.WILLOW);
        TrellisUtilProvider.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.ASPEN);
        TrellisUtilProvider.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.MAPLE);
        TrellisUtilProvider.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.CYPRESS);
        TrellisUtilProvider.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.OLIVE);
        TrellisUtilProvider.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.JOSHUA);
        TrellisUtilProvider.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.GHAF);
        TrellisUtilProvider.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.PALO_VERDE);
        TrellisUtilProvider.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.COCONUT);
        TrellisUtilProvider.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.CEDAR);
        TrellisUtilProvider.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.LARCH);
        TrellisUtilProvider.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.MAHOGANY);
        TrellisUtilProvider.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.SAXAUL);

        offerPicketsRecipe(exporter, NaturesSpiritBlocks.REDWOOD_PICKETS.get(), ResourceLocation.tryBuild(NATURES_SPIRIT_MOD_ID, "redwood_planks"));
        offerPicketsRecipe(exporter, NaturesSpiritBlocks.SUGI_PICKETS.get(), ResourceLocation.tryBuild(NATURES_SPIRIT_MOD_ID, "sugi_planks"));
        offerPicketsRecipe(exporter, NaturesSpiritBlocks.WISTERIA_PICKETS.get(), ResourceLocation.tryBuild(NATURES_SPIRIT_MOD_ID, "wisteria_planks"));
        offerPicketsRecipe(exporter, NaturesSpiritBlocks.FIR_PICKETS.get(), ResourceLocation.tryBuild(NATURES_SPIRIT_MOD_ID, "fir_planks"));
        offerPicketsRecipe(exporter, NaturesSpiritBlocks.WILLOW_PICKETS.get(), ResourceLocation.tryBuild(NATURES_SPIRIT_MOD_ID, "willow_planks"));
        offerPicketsRecipe(exporter, NaturesSpiritBlocks.ASPEN_PICKETS.get(), ResourceLocation.tryBuild(NATURES_SPIRIT_MOD_ID, "aspen_planks"));
        offerPicketsRecipe(exporter, NaturesSpiritBlocks.MAPLE_PICKETS.get(), ResourceLocation.tryBuild(NATURES_SPIRIT_MOD_ID, "maple_planks"));
        offerPicketsRecipe(exporter, NaturesSpiritBlocks.CYPRESS_PICKETS.get(), ResourceLocation.tryBuild(NATURES_SPIRIT_MOD_ID, "cypress_planks"));
        offerPicketsRecipe(exporter, NaturesSpiritBlocks.OLIVE_PICKETS.get(), ResourceLocation.tryBuild(NATURES_SPIRIT_MOD_ID, "olive_planks"));
        offerPicketsRecipe(exporter, NaturesSpiritBlocks.JOSHUA_PICKETS.get(), ResourceLocation.tryBuild(NATURES_SPIRIT_MOD_ID, "joshua_planks"));
        offerPicketsRecipe(exporter, NaturesSpiritBlocks.GHAF_PICKETS.get(), ResourceLocation.tryBuild(NATURES_SPIRIT_MOD_ID, "ghaf_planks"));
        offerPicketsRecipe(exporter, NaturesSpiritBlocks.PALO_VERDE_PICKETS.get(), ResourceLocation.tryBuild(NATURES_SPIRIT_MOD_ID, "palo_verde_planks"));
        offerPicketsRecipe(exporter, NaturesSpiritBlocks.COCONUT_PICKETS.get(), ResourceLocation.tryBuild(NATURES_SPIRIT_MOD_ID, "coconut_planks"));
        offerPicketsRecipe(exporter, NaturesSpiritBlocks.CEDAR_PICKETS.get(), ResourceLocation.tryBuild(NATURES_SPIRIT_MOD_ID, "cedar_planks"));
        offerPicketsRecipe(exporter, NaturesSpiritBlocks.LARCH_PICKETS.get(), ResourceLocation.tryBuild(NATURES_SPIRIT_MOD_ID, "larch_planks"));
        offerPicketsRecipe(exporter, NaturesSpiritBlocks.MAHOGANY_PICKETS.get(), ResourceLocation.tryBuild(NATURES_SPIRIT_MOD_ID, "mahogany_planks"));
        offerPicketsRecipe(exporter, NaturesSpiritBlocks.SAXAUL_PICKETS.get(), ResourceLocation.tryBuild(NATURES_SPIRIT_MOD_ID, "saxaul_planks"));
    }
}
