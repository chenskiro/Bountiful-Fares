package net.hecco.bountifulfares.datagen.dungeons_delight;

import net.hecco.bountifulfares.datagen.trellis.TrellisUtilProvider;
import net.minecraft.data.recipes.RecipeProvider;
import com.xueluoanping.bountifulfaresforge.api.data.provider.ModNameRecipeProvider;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.compat.dungeons_delight.DungeonsDelightBlocks;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.minecraft.core.HolderLookup;

import net.minecraft.resources.ResourceLocation;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import net.minecraft.data.PackOutput;
import static net.hecco.bountifulfares.datagen.bountifulfares.BFRecipeProvider.offerPicketsRecipe;
import net.minecraft.data.recipes.RecipeOutput;

public class DungeonsDelightRecipeProvider extends ModNameRecipeProvider {
    public DungeonsDelightRecipeProvider(PackOutput generator, CompletableFuture<HolderLookup.Provider> registries) {
        super(generator,registries);
    }
    @Override
    protected void buildRecipes(RecipeOutput exporter) {
        TrellisUtilProvider.registerCompatTrellisRecipe(exporter, DungeonsDelightBlocks.WORMWOOD);
        offerPicketsRecipe(exporter, DungeonsDelightBlocks.WORMWOOD_PICKETS.get(), ResourceLocation.tryBuild(BountifulFares.DUNGEONS_DELIGHT_MOD_ID, "wormwood_planks"));
    }
}
