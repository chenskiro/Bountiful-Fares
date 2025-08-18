package net.hecco.bountifulfares.datagen.appledog;


import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.compat.appledog.AppledogBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class AppledogBlockTagProvider extends BlockTagsProvider {
    public AppledogBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture, BountifulFares.APPLEDOG_MOD_ID, null);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(AppledogBlocks.APPLEDOG_BLOCK.get())
        ;

        tag(BlockTags.BEACON_BASE_BLOCKS)
                .add(AppledogBlocks.APPLEDOG_BLOCK.get())
        ;
    }
}
