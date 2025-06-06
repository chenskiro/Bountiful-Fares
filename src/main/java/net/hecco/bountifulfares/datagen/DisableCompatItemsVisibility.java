package net.hecco.bountifulfares.datagen;


import net.hecco.bountifulfares.BountifulFaresUtil;
import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class DisableCompatItemsVisibility extends ItemTagsProvider {
    public DisableCompatItemsVisibility(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> providerCompletableFuture, CompletableFuture<TagsProvider.TagLookup<Block>> tagLookupCompletableFuture) {
        super(packOutput, providerCompletableFuture, tagLookupCompletableFuture,"hide_compat_items",null);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider wrapperLookup) {
        for (ResourceLocation item : BountifulFaresUtil.allCompatItemIds()) {
            tag(BFItemTags.C_HIDDEN_FROM_RECIPE_VIEWERS).addOptional(item);
        }
    }
}
