package net.hecco.bountifulfares.datagen.dye_depot;


import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.compat.dye_depot.DyeDepotBlocks;
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

public class DyeDepotBlockTagProvider extends BlockTagsProvider {
    public DyeDepotBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture, BountifulFares.DYE_DEPOT_MOD_ID, null);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(DyeDepotBlocks.MAROON_JACK_O_STRAW.get())
                .add(DyeDepotBlocks.ROSE_JACK_O_STRAW.get())
                .add(DyeDepotBlocks.CORAL_JACK_O_STRAW.get())
                .add(DyeDepotBlocks.GINGER_JACK_O_STRAW.get())
                .add(DyeDepotBlocks.TAN_JACK_O_STRAW.get())
                .add(DyeDepotBlocks.BEIGE_JACK_O_STRAW.get())
                .add(DyeDepotBlocks.AMBER_JACK_O_STRAW.get())
                .add(DyeDepotBlocks.OLIVE_JACK_O_STRAW.get())
                .add(DyeDepotBlocks.FOREST_JACK_O_STRAW.get())
                .add(DyeDepotBlocks.VERDANT_JACK_O_STRAW.get())
                .add(DyeDepotBlocks.TEAL_JACK_O_STRAW.get())
                .add(DyeDepotBlocks.MINT_JACK_O_STRAW.get())
                .add(DyeDepotBlocks.AQUA_JACK_O_STRAW.get())
                .add(DyeDepotBlocks.SLATE_JACK_O_STRAW.get())
                .add(DyeDepotBlocks.NAVY_JACK_O_STRAW.get())
                .add(DyeDepotBlocks.INDIGO_JACK_O_STRAW.get())
        ;

        tag(BFBlockTags.JACK_O_STRAWS)
                .add(DyeDepotBlocks.MAROON_JACK_O_STRAW.get())
                .add(DyeDepotBlocks.ROSE_JACK_O_STRAW.get())
                .add(DyeDepotBlocks.CORAL_JACK_O_STRAW.get())
                .add(DyeDepotBlocks.GINGER_JACK_O_STRAW.get())
                .add(DyeDepotBlocks.TAN_JACK_O_STRAW.get())
                .add(DyeDepotBlocks.BEIGE_JACK_O_STRAW.get())
                .add(DyeDepotBlocks.AMBER_JACK_O_STRAW.get())
                .add(DyeDepotBlocks.OLIVE_JACK_O_STRAW.get())
                .add(DyeDepotBlocks.FOREST_JACK_O_STRAW.get())
                .add(DyeDepotBlocks.VERDANT_JACK_O_STRAW.get())
                .add(DyeDepotBlocks.TEAL_JACK_O_STRAW.get())
                .add(DyeDepotBlocks.MINT_JACK_O_STRAW.get())
                .add(DyeDepotBlocks.AQUA_JACK_O_STRAW.get())
                .add(DyeDepotBlocks.SLATE_JACK_O_STRAW.get())
                .add(DyeDepotBlocks.NAVY_JACK_O_STRAW.get())
                .add(DyeDepotBlocks.INDIGO_JACK_O_STRAW.get())
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
