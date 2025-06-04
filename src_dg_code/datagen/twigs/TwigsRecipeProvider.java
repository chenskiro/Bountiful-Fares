package net.hecco.bountifulfares.datagen.twigs;

import net.hecco.bountifulfares.compat.twigs.TwigsBlocks;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.packs.VanillaRecipeProvider;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class TwigsRecipeProvider extends VanillaRecipeProvider {
    public TwigsRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, TwigsBlocks.WALNUT_TABLE)
                .pattern("___")
                .pattern("0 0")
                .pattern("0 0")
                .define('_', BFBlocks.WALNUT_SLAB)
                .define('0', BFBlocks.WALNUT_FENCE)
                .unlockedBy(getHasName(BFBlocks.WALNUT_PLANKS), has(BFBlocks.WALNUT_PLANKS))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, TwigsBlocks.HOARY_TABLE)
                .pattern("___")
                .pattern("0 0")
                .pattern("0 0")
                .define('_', BFBlocks.HOARY_SLAB)
                .define('0', BFBlocks.HOARY_FENCE)
                .unlockedBy(getHasName(BFBlocks.HOARY_PLANKS), has(BFBlocks.HOARY_PLANKS))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, TwigsBlocks.FELDSPAR_LAMP)
                .pattern("III")
                .pattern("FSF")
                .pattern("ICI")
                .define('I', Items.IRON_INGOT)
                .define('F', BFItems.FELDSPAR)
                .define('S', Items.TORCH)
                .define('C', Items.COAL)
                .unlockedBy(getHasName(BFItems.FELDSPAR), has(BFItems.FELDSPAR))
                .save(exporter);
    }
}
