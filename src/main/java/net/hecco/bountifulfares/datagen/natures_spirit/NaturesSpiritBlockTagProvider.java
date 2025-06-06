package net.hecco.bountifulfares.datagen.natures_spirit;


import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.compat.natures_spirit.NaturesSpiritBlocks;
import net.hecco.bountifulfares.registry.tags.BFBlockTags;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.hecco.bountifulfares.trellis.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.trellis.trellis_parts.VineCrop;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class NaturesSpiritBlockTagProvider extends BlockTagsProvider {
    public NaturesSpiritBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture, BountifulFares.NATURES_SPIRIT_MOD_ID, null);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        registerTrellisBlockTags(NaturesSpiritBlocks.ASPEN);
        registerTrellisBlockTags(NaturesSpiritBlocks.CEDAR);
        registerTrellisBlockTags(NaturesSpiritBlocks.COCONUT);
        registerTrellisBlockTags(NaturesSpiritBlocks.CYPRESS);
        registerTrellisBlockTags(NaturesSpiritBlocks.FIR);
        registerTrellisBlockTags(NaturesSpiritBlocks.GHAF);
        registerTrellisBlockTags(NaturesSpiritBlocks.JOSHUA);
        registerTrellisBlockTags(NaturesSpiritBlocks.LARCH);
        registerTrellisBlockTags(NaturesSpiritBlocks.MAHOGANY);
        registerTrellisBlockTags(NaturesSpiritBlocks.MAPLE);
        registerTrellisBlockTags(NaturesSpiritBlocks.OLIVE);
        registerTrellisBlockTags(NaturesSpiritBlocks.PALO_VERDE);
        registerTrellisBlockTags(NaturesSpiritBlocks.SAXAUL);
        registerTrellisBlockTags(NaturesSpiritBlocks.SUGI);
        registerTrellisBlockTags(NaturesSpiritBlocks.WILLOW);
        registerTrellisBlockTags(NaturesSpiritBlocks.WISTERIA);

        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(NaturesSpiritBlocks.ASPEN_PICKETS.get())
                .add(NaturesSpiritBlocks.CEDAR_PICKETS.get())
                .add(NaturesSpiritBlocks.COCONUT_PICKETS.get())
                .add(NaturesSpiritBlocks.CYPRESS_PICKETS.get())
                .add(NaturesSpiritBlocks.FIR_PICKETS.get())
                .add(NaturesSpiritBlocks.GHAF_PICKETS.get())
                .add(NaturesSpiritBlocks.JOSHUA_PICKETS.get())
                .add(NaturesSpiritBlocks.LARCH_PICKETS.get())
                .add(NaturesSpiritBlocks.MAHOGANY_PICKETS.get())
                .add(NaturesSpiritBlocks.MAPLE_PICKETS.get())
                .add(NaturesSpiritBlocks.OLIVE_PICKETS.get())
                .add(NaturesSpiritBlocks.PALO_VERDE_PICKETS.get())
                .add(NaturesSpiritBlocks.SAXAUL_PICKETS.get())
                .add(NaturesSpiritBlocks.SUGI_PICKETS.get())
                .add(NaturesSpiritBlocks.WILLOW_PICKETS.get())
                .add(NaturesSpiritBlocks.WISTERIA_PICKETS.get());

        tag(BFBlockTags.PICKETS)
                .add(NaturesSpiritBlocks.ASPEN_PICKETS.get())
                .add(NaturesSpiritBlocks.CEDAR_PICKETS.get())
                .add(NaturesSpiritBlocks.COCONUT_PICKETS.get())
                .add(NaturesSpiritBlocks.CYPRESS_PICKETS.get())
                .add(NaturesSpiritBlocks.FIR_PICKETS.get())
                .add(NaturesSpiritBlocks.GHAF_PICKETS.get())
                .add(NaturesSpiritBlocks.JOSHUA_PICKETS.get())
                .add(NaturesSpiritBlocks.LARCH_PICKETS.get())
                .add(NaturesSpiritBlocks.MAHOGANY_PICKETS.get())
                .add(NaturesSpiritBlocks.MAPLE_PICKETS.get())
                .add(NaturesSpiritBlocks.OLIVE_PICKETS.get())
                .add(NaturesSpiritBlocks.PALO_VERDE_PICKETS.get())
                .add(NaturesSpiritBlocks.SAXAUL_PICKETS.get())
                .add(NaturesSpiritBlocks.SUGI_PICKETS.get())
                .add(NaturesSpiritBlocks.WILLOW_PICKETS.get())
                .add(NaturesSpiritBlocks.WISTERIA_PICKETS.get())
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
