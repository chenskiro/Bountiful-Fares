package net.hecco.bountifulfares.datagen.farmersdelight;


import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.compat.farmersdelight.FarmersDelightBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class FarmersDelightBlockTagProvider extends BlockTagsProvider {
    public FarmersDelightBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture, BountifulFares.FARMERS_DELIGHT_MOD_ID, null);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(FarmersDelightBlocks.WALNUT_CABINET.get())
                .add(FarmersDelightBlocks.HOARY_CABINET.get())
                ;
    }
}
