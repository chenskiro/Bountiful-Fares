package net.hecco.bountifulfares.datagen.mint;


import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.compat.mint.MintBlocks;
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

public class MintBlockTagProvider extends BlockTagsProvider {
    public MintBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture, BountifulFares.ELS_AND_LS_DYES_MOD_ID, null);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(MintBlocks.ACORN_JACK_O_STRAW.get())
                .add(MintBlocks.AMBER_JACK_O_STRAW.get())
                .add(MintBlocks.ARTICHOKE_JACK_O_STRAW.get())
                .add(MintBlocks.BANANA_JACK_O_STRAW.get())
                .add(MintBlocks.CERULEAN_JACK_O_STRAW.get())
                .add(MintBlocks.FUCHSIA_JACK_O_STRAW.get())
                .add(MintBlocks.GRAPE_JACK_O_STRAW.get())
                .add(MintBlocks.INDIGO_JACK_O_STRAW.get())
                .add(MintBlocks.MAROON_JACK_O_STRAW.get())
                .add(MintBlocks.MAUVE_JACK_O_STRAW.get())
                .add(MintBlocks.MINT_JACK_O_STRAW.get())
                .add(MintBlocks.MOLD_JACK_O_STRAW.get())
                .add(MintBlocks.NAVY_JACK_O_STRAW.get())
                .add(MintBlocks.PEACH_JACK_O_STRAW.get())
                .add(MintBlocks.PERIWINKLE_JACK_O_STRAW.get())
                .add(MintBlocks.SAGE_JACK_O_STRAW.get())
                .add(MintBlocks.SAP_JACK_O_STRAW.get())
                .add(MintBlocks.SHAMROCK_JACK_O_STRAW.get())
                .add(MintBlocks.VELVET_JACK_O_STRAW.get())
                .add(MintBlocks.VERMILION_JACK_O_STRAW.get())
                .add(MintBlocks.WINTERGREEN_PICKETS.get())
                ;
        registerTrellisBlockTags(MintBlocks.WINTERGREEN);

        tag(BFBlockTags.PICKETS)
                .add(MintBlocks.WINTERGREEN_PICKETS.get())
                ;

        tag(BFBlockTags.JACK_O_STRAWS)
                .add(MintBlocks.ACORN_JACK_O_STRAW.get())
                .add(MintBlocks.MAROON_JACK_O_STRAW.get())
                .add(MintBlocks.PEACH_JACK_O_STRAW.get())
                .add(MintBlocks.VERMILION_JACK_O_STRAW.get())
                .add(MintBlocks.AMBER_JACK_O_STRAW.get())
                .add(MintBlocks.BANANA_JACK_O_STRAW.get())
                .add(MintBlocks.ARTICHOKE_JACK_O_STRAW.get())
                .add(MintBlocks.MINT_JACK_O_STRAW.get())
                .add(MintBlocks.SHAMROCK_JACK_O_STRAW.get())
                .add(MintBlocks.SAGE_JACK_O_STRAW.get())
                .add(MintBlocks.MOLD_JACK_O_STRAW.get())
                .add(MintBlocks.SAP_JACK_O_STRAW.get())
                .add(MintBlocks.NAVY_JACK_O_STRAW.get())
                .add(MintBlocks.CERULEAN_JACK_O_STRAW.get())
                .add(MintBlocks.INDIGO_JACK_O_STRAW.get())
                .add(MintBlocks.PERIWINKLE_JACK_O_STRAW.get())
                .add(MintBlocks.GRAPE_JACK_O_STRAW.get())
                .add(MintBlocks.MAUVE_JACK_O_STRAW.get())
                .add(MintBlocks.VELVET_JACK_O_STRAW.get())
                .add(MintBlocks.FUCHSIA_JACK_O_STRAW.get())
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
