package net.hecco.bountifulfares.datagen.delicate_dyes;


import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.compat.delicate_dyes.DelicateDyesBlocks;
import net.hecco.bountifulfares.registry.tags.BFBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class DelicateDyesBlockTagProvider extends BlockTagsProvider {
    public DelicateDyesBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture, BountifulFares.DELICATE_DYES_MOD_ID, null);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(DelicateDyesBlocks.CORAL_JACK_O_STRAW.get())
                .add(DelicateDyesBlocks.CANARY_JACK_O_STRAW.get())
                .add(DelicateDyesBlocks.WASABI_JACK_O_STRAW.get())
                .add(DelicateDyesBlocks.SACRAMENTO_JACK_O_STRAW.get())
                .add(DelicateDyesBlocks.SKY_JACK_O_STRAW.get())
                .add(DelicateDyesBlocks.BLURPLE_JACK_O_STRAW.get())
                .add(DelicateDyesBlocks.SANGRIA_JACK_O_STRAW.get())
                .add(DelicateDyesBlocks.ROSE_JACK_O_STRAW.get())
        ;

        tag(BFBlockTags.JACK_O_STRAWS)
                .add(DelicateDyesBlocks.CORAL_JACK_O_STRAW.get())
                .add(DelicateDyesBlocks.CANARY_JACK_O_STRAW.get())
                .add(DelicateDyesBlocks.WASABI_JACK_O_STRAW.get())
                .add(DelicateDyesBlocks.SACRAMENTO_JACK_O_STRAW.get())
                .add(DelicateDyesBlocks.SKY_JACK_O_STRAW.get())
                .add(DelicateDyesBlocks.BLURPLE_JACK_O_STRAW.get())
                .add(DelicateDyesBlocks.SANGRIA_JACK_O_STRAW.get())
                .add(DelicateDyesBlocks.ROSE_JACK_O_STRAW.get())
        ;
    }
}
