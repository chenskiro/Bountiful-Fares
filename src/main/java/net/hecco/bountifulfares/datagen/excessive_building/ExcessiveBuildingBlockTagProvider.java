package net.hecco.bountifulfares.datagen.excessive_building;


import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.compat.excessive_building.ExcessiveBuildingBlocks;
import net.hecco.bountifulfares.registry.tags.BFBlockTags;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.hecco.bountifulfares.trellis.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.trellis.trellis_parts.VineCrop;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ExcessiveBuildingBlockTagProvider extends BlockTagsProvider {
    public ExcessiveBuildingBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture, BountifulFares.EXCESSIVE_BUILDING_MOD_ID, null);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        registerTrellisBlockTags(ExcessiveBuildingBlocks.ANCIENT);

        tag(BFBlockTags.PICKETS)
                .add(ExcessiveBuildingBlocks.ANCIENT_PICKETS.get())
        ;
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ExcessiveBuildingBlocks.WALNUT_VERTICAL_STAIRS.get())
                .add(ExcessiveBuildingBlocks.CHISELED_WALNUT_PLANKS.get())
                .add(ExcessiveBuildingBlocks.WALNUT_MOSAIC.get())
                .add(ExcessiveBuildingBlocks.WALNUT_MOSAIC_STAIRS.get())
                .add(ExcessiveBuildingBlocks.WALNUT_MOSAIC_SLAB.get())
                .add(ExcessiveBuildingBlocks.WALNUT_MOSAIC_VERTICAL_STAIRS.get())
                .add(ExcessiveBuildingBlocks.WALNUT_LADDER.get())
                .add(ExcessiveBuildingBlocks.HOARY_VERTICAL_STAIRS.get())
                .add(ExcessiveBuildingBlocks.CHISELED_HOARY_PLANKS.get())
                .add(ExcessiveBuildingBlocks.HOARY_MOSAIC.get())
                .add(ExcessiveBuildingBlocks.HOARY_MOSAIC_STAIRS.get())
                .add(ExcessiveBuildingBlocks.HOARY_MOSAIC_SLAB.get())
                .add(ExcessiveBuildingBlocks.HOARY_MOSAIC_VERTICAL_STAIRS.get())
                .add(ExcessiveBuildingBlocks.HOARY_LADDER.get())
                .add(ExcessiveBuildingBlocks.ANCIENT_PICKETS.get())
                ;
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ExcessiveBuildingBlocks.FELDSPAR_BRICK_VERTICAL_STAIRS.get())
                .add(ExcessiveBuildingBlocks.CERAMIC_TILE_VERTICAL_STAIRS.get())
                .add(ExcessiveBuildingBlocks.CHECKERED_CERAMIC_TILE_VERTICAL_STAIRS.get())
                .add(ExcessiveBuildingBlocks.CERAMIC_MOSAIC_VERTICAL_STAIRS.get())
                .add(ExcessiveBuildingBlocks.CHECKERED_CERAMIC_MOSAIC_VERTICAL_STAIRS.get())
                ;
        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICKS.get())
                .add(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICK_STAIRS.get())
                .add(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICK_SLAB.get())
                .add(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICK_WALL.get())
                .add(ExcessiveBuildingBlocks.PALM_MULCH_BRICKS.get())
                .add(ExcessiveBuildingBlocks.PALM_MULCH_BRICK_STAIRS.get())
                .add(ExcessiveBuildingBlocks.PALM_MULCH_BRICK_SLAB.get())
                .add(ExcessiveBuildingBlocks.PALM_MULCH_BRICK_WALL.get())
                ;

        tag(BlockTags.STAIRS)
                .add(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICK_STAIRS.get())
                .add(ExcessiveBuildingBlocks.PALM_MULCH_BRICK_STAIRS.get())
                ;

        tag(BlockTags.SLABS)
                .add(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICK_SLAB.get())
                .add(ExcessiveBuildingBlocks.PALM_MULCH_BRICK_SLAB.get())
        ;

        tag(BlockTags.WALLS)
                .add(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICK_WALL.get())
                .add(ExcessiveBuildingBlocks.PALM_MULCH_BRICK_WALL.get())
        ;

        tag(BlockTags.CLIMBABLE)
                .add(ExcessiveBuildingBlocks.HOARY_LADDER.get())
                .add(ExcessiveBuildingBlocks.WALNUT_LADDER.get())
                ;
    }

    public void registerTrellisBlockTags(TrellisVariant trellis) {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .addOptional(ResourceLocation.tryBuild(trellis.getModId(), trellis.getBlockName()))
        ;
        for (VineCrop crop : TrellisUtil.VineCrops) {
            tag(BlockTags.MINEABLE_WITH_AXE)
                    .addOptional(ResourceLocation.tryBuild(trellis.getModId(), crop.getName() + "_" + trellis.getBlockName()))
            ;
        }
        for (DecorativeVine vine : TrellisUtil.DecorativeVines) {
            tag(BlockTags.MINEABLE_WITH_AXE)
                    .addOptional(ResourceLocation.tryBuild(trellis.getModId(), vine.getName() + "_" + trellis.getBlockName()))
            ;
        }
    }
}
