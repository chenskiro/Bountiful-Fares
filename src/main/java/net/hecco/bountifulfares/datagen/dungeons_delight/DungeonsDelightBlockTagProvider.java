package net.hecco.bountifulfares.datagen.dungeons_delight;


import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.compat.dungeons_delight.DungeonsDelightBlocks;
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

public class DungeonsDelightBlockTagProvider extends BlockTagsProvider {
    public DungeonsDelightBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture, BountifulFares.DUNGEONS_DELIGHT_MOD_ID, null);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(DungeonsDelightBlocks.WORMWOOD_PICKETS.get())
        ;
        registerTrellisBlockTags(DungeonsDelightBlocks.WORMWOOD);

        tag(BFBlockTags.PICKETS)
                .add(DungeonsDelightBlocks.WORMWOOD_PICKETS.get())
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
