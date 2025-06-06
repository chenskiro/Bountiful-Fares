package com.xueluoanping.bountifulfaresforge.api.data.provider;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public abstract class AutoSkipBlockLootSubProvider extends BlockLootSubProvider {
    protected AutoSkipBlockLootSubProvider(Set<Item> pExplosionResistant, FeatureFlagSet pEnabledFeatures) {
        super(pExplosionResistant, pEnabledFeatures);
    }

    protected AutoSkipBlockLootSubProvider(Set<Item> pExplosionResistant, FeatureFlagSet pEnabledFeatures, Map<ResourceLocation, LootTable.Builder> pMap) {
        super(pExplosionResistant, pEnabledFeatures, pMap);
    }

    private final Set<Block> blocks=new HashSet<>();

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return blocks;
    }

    @Override
    protected void add(@NotNull Block pBlock, LootTable.@NotNull Builder pBuilder) {
        super.add(pBlock, pBuilder);
        blocks.add(pBlock);
    }

}
