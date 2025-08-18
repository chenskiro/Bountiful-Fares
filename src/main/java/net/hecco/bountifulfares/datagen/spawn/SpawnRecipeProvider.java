package net.hecco.bountifulfares.datagen.spawn;

import net.hecco.bountifulfares.datagen.trellis.TrellisUtilProvider;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import com.xueluoanping.bountifulfaresforge.api.data.provider.ModNameRecipeProvider;
import net.hecco.bountifulfares.compat.spawn.SpawnBlocks;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.minecraft.core.HolderLookup;

import net.minecraft.resources.ResourceLocation;
import java.util.concurrent.CompletableFuture;

import static net.hecco.bountifulfares.BountifulFares.SPAWN_MOD_ID;
import static net.hecco.bountifulfares.datagen.bountifulfares.BFRecipeProvider.offerPicketsRecipe;
import java.util.function.Consumer;
import net.minecraft.data.PackOutput;
public class SpawnRecipeProvider extends ModNameRecipeProvider {
    public SpawnRecipeProvider(PackOutput generator, CompletableFuture<HolderLookup.Provider> registries) {
        super(generator,registries);
    }
    @Override
    public void buildRecipes(RecipeOutput exporter) {
        TrellisUtilProvider.registerCompatTrellisRecipe(exporter, SpawnBlocks.ROTTEN);
        offerPicketsRecipe(exporter, SpawnBlocks.ROTTEN_PICKETS.get(), ResourceLocation.tryBuild(SPAWN_MOD_ID, "rotten_planks"));
    }
}
