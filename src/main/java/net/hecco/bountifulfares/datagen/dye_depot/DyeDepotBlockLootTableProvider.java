package net.hecco.bountifulfares.datagen.dye_depot;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import com.xueluoanping.bountifulfaresforge.api.data.provider.AutoSkipBlockLootSubProvider;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.BountifulFaresUtil;
import net.hecco.bountifulfares.block.custom.JackOStrawBlock;
import net.hecco.bountifulfares.compat.dye_depot.DyeDepotBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.LootTableProvider;
import com.xueluoanping.bountifulfaresforge.api.data.provider.ModNameLootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class DyeDepotBlockLootTableProvider extends AutoSkipBlockLootSubProvider {
    public static class BFLootTableProvider extends ModNameLootTableProvider {
        private final PackOutput generator;
        public BFLootTableProvider(PackOutput generator, CompletableFuture<HolderLookup.Provider> lookupProvider) {
            super(generator, Set.of(), List.of(new LootTableProvider.SubProviderEntry(
                    DyeDepotBlockLootTableProvider::new,
                    LootContextParamSets.BLOCK
            )),lookupProvider);
            this.generator = generator;
        }
    }

    public DyeDepotBlockLootTableProvider(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    public static final ArrayList<Block> usedBlocks = new ArrayList<>();

    @Override
    public void add(Block block, LootTable.Builder lootTable) {
        if(usedBlocks.contains(block)) {
            return;
        }
        super.add(block, lootTable);
        usedBlocks.add(block);
    }

    @Override
    public void generate() {
        jackOStrawDrops(DyeDepotBlocks.MAROON_JACK_O_STRAW.get());
        jackOStrawDrops(DyeDepotBlocks.ROSE_JACK_O_STRAW.get());
        jackOStrawDrops(DyeDepotBlocks.CORAL_JACK_O_STRAW.get());
        jackOStrawDrops(DyeDepotBlocks.GINGER_JACK_O_STRAW.get());
        jackOStrawDrops(DyeDepotBlocks.TAN_JACK_O_STRAW.get());
        jackOStrawDrops(DyeDepotBlocks.BEIGE_JACK_O_STRAW.get());
        jackOStrawDrops(DyeDepotBlocks.AMBER_JACK_O_STRAW.get());
        jackOStrawDrops(DyeDepotBlocks.OLIVE_JACK_O_STRAW.get());
        jackOStrawDrops(DyeDepotBlocks.FOREST_JACK_O_STRAW.get());
        jackOStrawDrops(DyeDepotBlocks.VERDANT_JACK_O_STRAW.get());
        jackOStrawDrops(DyeDepotBlocks.TEAL_JACK_O_STRAW.get());
        jackOStrawDrops(DyeDepotBlocks.MINT_JACK_O_STRAW.get());
        jackOStrawDrops(DyeDepotBlocks.AQUA_JACK_O_STRAW.get());
        jackOStrawDrops(DyeDepotBlocks.SLATE_JACK_O_STRAW.get());
        jackOStrawDrops(DyeDepotBlocks.NAVY_JACK_O_STRAW.get());
        jackOStrawDrops(DyeDepotBlocks.INDIGO_JACK_O_STRAW.get());

        for(ResourceLocation id : BountifulFaresUtil.allBlockIdsInNamespace(BountifulFares.DYE_DEPOT_MOD_ID)) {
            Block block = BuiltInRegistries.BLOCK.get(id);
            if(usedBlocks.contains(block)) { continue; }
            this.dropSelf(block);
        }
    }

    public void jackOStrawDrops(Block block) {
        this.add(block, this.createSinglePropConditionTable(block, JackOStrawBlock.HALF, DoubleBlockHalf.LOWER));
    }
}
