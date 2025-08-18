package net.hecco.bountifulfares.datagen.twigs;

import com.xueluoanping.bountifulfaresforge.api.data.provider.ModNameRecipeProvider;
import net.hecco.bountifulfares.compat.twigs.TwigsBlocks;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.packs.VanillaRecipeProvider;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class TwigsRecipeProvider extends ModNameRecipeProvider {
    public TwigsRecipeProvider(PackOutput generator, CompletableFuture<HolderLookup.Provider> registries) {
        super(generator,registries);
    }
    
    @Override
    public void buildRecipes(RecipeOutput exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, TwigsBlocks.WALNUT_TABLE.get())
                .pattern("___")
                .pattern("0 0")
                .pattern("0 0")
                .define('_', BFBlocks.WALNUT_SLAB.get())
                .define('0', BFBlocks.WALNUT_FENCE.get())
                .unlockedBy(getHasName(BFBlocks.WALNUT_PLANKS.get()), has(BFBlocks.WALNUT_PLANKS.get()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, TwigsBlocks.HOARY_TABLE.get())
                .pattern("___")
                .pattern("0 0")
                .pattern("0 0")
                .define('_', BFBlocks.HOARY_SLAB.get())
                .define('0', BFBlocks.HOARY_FENCE.get())
                .unlockedBy(getHasName(BFBlocks.HOARY_PLANKS.get()), has(BFBlocks.HOARY_PLANKS.get()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, TwigsBlocks.FELDSPAR_LAMP.get())
                .pattern("III")
                .pattern("FSF")
                .pattern("ICI")
                .define('I', Items.IRON_INGOT)
                .define('F', BFItems.FELDSPAR.get())
                .define('S', Items.TORCH)
                .define('C', Items.COAL)
                .unlockedBy(getHasName(BFItems.FELDSPAR.get()), has(BFItems.FELDSPAR.get()))
                .save(exporter);
    }
}
