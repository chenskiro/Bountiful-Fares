package net.hecco.bountifulfares.datagen.excessive_building;

import net.hecco.bountifulfares.datagen.trellis.TrellisUtilProvider;
import net.minecraft.data.recipes.RecipeProvider;
import net.hecco.bountifulfares.compat.excessive_building.ExcessiveBuildingBlocks;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import static net.hecco.bountifulfares.BountifulFares.EXCESSIVE_BUILDING_MOD_ID;
import static net.hecco.bountifulfares.datagen.bountifulfares.BFRecipeProvider.offerPicketsRecipe;
import static net.minecraft.data.BlockFamilies.familyBuilder;

import java.util.function.Consumer;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;

public class ExcessiveBuildingRecipeProvider extends RecipeProvider {
    public ExcessiveBuildingRecipeProvider(PackOutput generator) {
        super(generator);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> exporter) {
        TrellisUtilProvider.registerCompatTrellisRecipe(exporter, ExcessiveBuildingBlocks.ANCIENT);
        offerPicketsRecipe(exporter, ExcessiveBuildingBlocks.ANCIENT_PICKETS.get(), ResourceLocation.tryBuild(EXCESSIVE_BUILDING_MOD_ID, "ancient_planks"));
        offerVerticalStairsRecipe(exporter, ExcessiveBuildingBlocks.HOARY_VERTICAL_STAIRS.get(), BFBlocks.HOARY_PLANKS.get());
        offerVerticalStairsRecipe(exporter, ExcessiveBuildingBlocks.HOARY_MOSAIC_VERTICAL_STAIRS.get(), ExcessiveBuildingBlocks.HOARY_MOSAIC.get());
        offerVerticalStairsRecipe(exporter, ExcessiveBuildingBlocks.WALNUT_VERTICAL_STAIRS.get(), BFBlocks.WALNUT_PLANKS.get());
        offerVerticalStairsRecipe(exporter, ExcessiveBuildingBlocks.WALNUT_MOSAIC_VERTICAL_STAIRS.get(), ExcessiveBuildingBlocks.WALNUT_MOSAIC.get());
        offerVerticalStairsRecipe(exporter, ExcessiveBuildingBlocks.FELDSPAR_BRICK_VERTICAL_STAIRS.get(), BFBlocks.FELDSPAR_BRICKS.get());
        offerVerticalStairsRecipe(exporter, ExcessiveBuildingBlocks.CERAMIC_TILE_VERTICAL_STAIRS.get(), BFBlocks.CERAMIC_TILES.get());
        offerVerticalStairsRecipe(exporter, ExcessiveBuildingBlocks.CERAMIC_MOSAIC_VERTICAL_STAIRS.get(), BFBlocks.CERAMIC_MOSAIC.get());
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ExcessiveBuildingBlocks.CHISELED_HOARY_PLANKS.get(), 2)
                .define('#', BFBlocks.HOARY_SLAB.get())
                .pattern("##")
                .pattern("##")
                .unlockedBy(getHasName(BFBlocks.HOARY_SLAB.get()), has(BFBlocks.HOARY_SLAB.get())).save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ExcessiveBuildingBlocks.CHISELED_WALNUT_PLANKS.get(), 2)
                .define('#', BFBlocks.WALNUT_SLAB.get())
                .pattern("##")
                .pattern("##")
                .unlockedBy(getHasName(BFBlocks.WALNUT_SLAB.get()), has(BFBlocks.WALNUT_SLAB.get())).save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ExcessiveBuildingBlocks.HOARY_LADDER.get(), 8)
                .define('S', Items.STICK)
                .define('#', BFBlocks.HOARY_PLANKS.get())
                .pattern("S S")
                .pattern("S#S")
                .pattern("S S")
                .unlockedBy(getHasName(BFBlocks.HOARY_PLANKS.get()), has(BFBlocks.HOARY_PLANKS.get())).save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ExcessiveBuildingBlocks.WALNUT_LADDER.get(), 8)
                .define('S', Items.STICK)
                .define('#', BFBlocks.WALNUT_PLANKS.get())
                .pattern("S S")
                .pattern("S#S")
                .pattern("S S")
                .unlockedBy(getHasName(BFBlocks.WALNUT_PLANKS.get()), has(BFBlocks.WALNUT_PLANKS.get())).save(exporter);
        chiseled(exporter, RecipeCategory.BUILDING_BLOCKS, ExcessiveBuildingBlocks.HOARY_MOSAIC.get(), BFBlocks.HOARY_SLAB.get());
        BlockFamily hoaryMosaicFamily = familyBuilder(ExcessiveBuildingBlocks.HOARY_MOSAIC.get())
                .stairs(ExcessiveBuildingBlocks.HOARY_MOSAIC_STAIRS.get())
                .slab(ExcessiveBuildingBlocks.HOARY_MOSAIC_SLAB.get())
                .recipeUnlockedBy(getHasName(ExcessiveBuildingBlocks.HOARY_MOSAIC.get()))
                .getFamily();
        generateRecipes(exporter, hoaryMosaicFamily);
        chiseled(exporter, RecipeCategory.BUILDING_BLOCKS, ExcessiveBuildingBlocks.WALNUT_MOSAIC.get(), BFBlocks.WALNUT_SLAB.get());
        BlockFamily walnutMosaicFamily = familyBuilder(ExcessiveBuildingBlocks.WALNUT_MOSAIC.get())
                .stairs(ExcessiveBuildingBlocks.WALNUT_MOSAIC_STAIRS.get())
                .slab(ExcessiveBuildingBlocks.WALNUT_MOSAIC_SLAB.get())
                .recipeUnlockedBy(getHasName(ExcessiveBuildingBlocks.WALNUT_MOSAIC.get()))
                .getFamily();
        generateRecipes(exporter, walnutMosaicFamily);
    }

    private static void offerVerticalStairsRecipe(Consumer<FinishedRecipe> exporter, ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 4)
                .define('#', input)
                .pattern("###")
                .pattern("## ")
                .pattern("#  ")
                .unlockedBy(getHasName(input), has(input)).save(exporter);
    }
}
