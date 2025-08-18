package net.hecco.bountifulfares.datagen.arts_and_crafts;

import net.hecco.bountifulfares.datagen.trellis.TrellisUtilProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeProvider;
import com.xueluoanping.bountifulfaresforge.api.data.provider.ModNameRecipeProvider;
import net.hecco.bountifulfares.compat.arts_and_crafts.ArtsAndCraftsBlocks;

import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;

import static net.hecco.bountifulfares.BountifulFares.ARTS_AND_CRAFTS_MOD_ID;
import static net.hecco.bountifulfares.datagen.bountifulfares.BFRecipeProvider.offerPicketsRecipe;

public class ArtsAndCraftsRecipeProvider extends ModNameRecipeProvider {
    public ArtsAndCraftsRecipeProvider(PackOutput generator) {
        super(generator);
    }

    @Override
    protected void buildRecipes(RecipeOutput exporter) {
        TrellisUtilProvider.registerCompatTrellisRecipe(exporter, ArtsAndCraftsBlocks.CORK);
        offerPicketsRecipe(exporter, ArtsAndCraftsBlocks.CORK_PICKETS.get(), ResourceLocation.tryBuild(ARTS_AND_CRAFTS_MOD_ID, "cork_planks"));
    }
}
