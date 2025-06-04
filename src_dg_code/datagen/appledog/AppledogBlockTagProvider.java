package net.hecco.bountifulfares.datagen.appledog;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hecco.bountifulfares.compat.appledog.AppledogBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import java.util.concurrent.CompletableFuture;

public class AppledogBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public AppledogBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(AppledogBlocks.APPLEDOG_BLOCK)
        ;

        tag(BlockTags.BEACON_BASE_BLOCKS)
                .add(AppledogBlocks.APPLEDOG_BLOCK)
        ;
    }
}
