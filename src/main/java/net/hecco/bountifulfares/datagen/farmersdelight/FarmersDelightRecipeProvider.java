package net.hecco.bountifulfares.datagen.farmersdelight;

import net.minecraft.data.recipes.RecipeProvider;
import com.xueluoanping.bountifulfaresforge.api.data.provider.ModNameRecipeProvider;
import net.hecco.bountifulfares.compat.farmersdelight.FarmersDelightBlocks;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
public class FarmersDelightRecipeProvider extends ModNameRecipeProvider {
    public FarmersDelightRecipeProvider(PackOutput generator) {
        super(generator);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, FarmersDelightBlocks.HOARY_CABINET.get())
                .define('_', BFBlocks.HOARY_SLAB.get())
                .define('D', BFBlocks.HOARY_TRAPDOOR.get())
                .pattern("___")
                .pattern("D D")
                .pattern("___")
                .unlockedBy(getHasName(BFBlocks.HOARY_TRAPDOOR.get()), has(BFBlocks.HOARY_TRAPDOOR.get()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, FarmersDelightBlocks.WALNUT_CABINET.get())
                .define('_', BFBlocks.WALNUT_SLAB.get())
                .define('D', BFBlocks.WALNUT_TRAPDOOR.get())
                .pattern("___")
                .pattern("D D")
                .pattern("___")
                .unlockedBy(getHasName(BFBlocks.WALNUT_TRAPDOOR.get()), has(BFBlocks.WALNUT_TRAPDOOR.get()))
                .save(exporter);
    }
}
