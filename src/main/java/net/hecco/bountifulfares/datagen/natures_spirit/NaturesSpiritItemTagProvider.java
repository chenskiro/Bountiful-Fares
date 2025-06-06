package net.hecco.bountifulfares.datagen.natures_spirit;


import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class NaturesSpiritItemTagProvider extends ItemTagsProvider {
    public NaturesSpiritItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> providerCompletableFuture, CompletableFuture<TagsProvider.TagLookup<Block>> tagLookupCompletableFuture) {
        super(packOutput, providerCompletableFuture, tagLookupCompletableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        tag(BFItemTags.C_COCONUT_HALVES)
                .addOptional(ResourceLocation.tryBuild(BountifulFares.NATURES_SPIRIT_MOD_ID, "coconut_half"))
                ;
    }
}
