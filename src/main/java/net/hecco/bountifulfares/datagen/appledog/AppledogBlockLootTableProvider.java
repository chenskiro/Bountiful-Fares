package net.hecco.bountifulfares.datagen.appledog;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import com.xueluoanping.bountifulfaresforge.api.data.provider.AutoSkipBlockLootSubProvider;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.BountifulFaresUtil;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.LootTableProvider;
import com.xueluoanping.bountifulfaresforge.api.data.provider.ModNameLootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class AppledogBlockLootTableProvider extends AutoSkipBlockLootSubProvider {
    public static class BFLootTableProvider extends ModNameLootTableProvider {
        private final PackOutput generator;

        public BFLootTableProvider(PackOutput generator, CompletableFuture<HolderLookup.Provider> lookupProvider) {
            super(generator, Set.of(), List.of(new LootTableProvider.SubProviderEntry(
                    AppledogBlockLootTableProvider::new,
                    LootContextParamSets.BLOCK
            )), lookupProvider);
            this.generator = generator;
        }
    }

    public AppledogBlockLootTableProvider(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    public static final ArrayList<Block> usedBlocks = new ArrayList<>();

    @Override
    public void add(Block block, LootTable.Builder lootTable) {
        if (usedBlocks.contains(block)) {
            return;
        }
        super.add(block, lootTable);
        usedBlocks.add(block);
    }

    @Override
    public void generate() {
        for (ResourceLocation id : BountifulFaresUtil.allBlockIdsInNamespace(BountifulFares.APPLEDOG_MOD_ID)) {
            Block block = BuiltInRegistries.BLOCK.get(id);
            if (usedBlocks.contains(block)) {
                continue;
            }
            this.dropSelf(block);
        }
    }
}
