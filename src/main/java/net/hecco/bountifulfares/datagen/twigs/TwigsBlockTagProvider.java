package net.hecco.bountifulfares.datagen.twigs;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.compat.twigs.TwigsBlockTags;
import net.hecco.bountifulfares.compat.twigs.TwigsBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class TwigsBlockTagProvider extends BlockTagsProvider {
    public TwigsBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture, BountifulFares.TWIGS_MOD_ID, null);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(TwigsBlocks.WALNUT_TABLE.get())
                .add(TwigsBlocks.HOARY_TABLE.get());
        tag(TwigsBlockTags.TABLES)
                .add(TwigsBlocks.WALNUT_TABLE.get())
                .add(TwigsBlocks.HOARY_TABLE.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(TwigsBlocks.FELDSPAR_LAMP.get());
    }
}
