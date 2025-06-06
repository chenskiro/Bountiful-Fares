package net.hecco.bountifulfares.datagen.delicate_dyes;

import net.minecraft.data.PackOutput;
import com.xueluoanping.bountifulfaresforge.api.data.provider.AutoSkipBlockLootSubProvider;

import net.hecco.bountifulfares.block.custom.JackOStrawBlock;
import net.hecco.bountifulfares.compat.delicate_dyes.DelicateDyesBlocks;
import net.minecraft.data.loot.LootTableProvider;
import com.xueluoanping.bountifulfaresforge.api.data.provider.ModNameLootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class DelicateDyesBlockLootTableProvider  extends AutoSkipBlockLootSubProvider {
    public static class BFLootTableProvider extends ModNameLootTableProvider {
        private final PackOutput generator;
        public BFLootTableProvider(PackOutput generator) {
            super(generator, Set.of(), List.of(new LootTableProvider.SubProviderEntry(
                    DelicateDyesBlockLootTableProvider::new,
                    LootContextParamSets.BLOCK
            )));
            this.generator = generator;
        }
    }

    public DelicateDyesBlockLootTableProvider() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate() {
        jackOStrawDrops(DelicateDyesBlocks.CORAL_JACK_O_STRAW.get());
        jackOStrawDrops(DelicateDyesBlocks.CANARY_JACK_O_STRAW.get());
        jackOStrawDrops(DelicateDyesBlocks.WASABI_JACK_O_STRAW.get());
        jackOStrawDrops(DelicateDyesBlocks.SACRAMENTO_JACK_O_STRAW.get());
        jackOStrawDrops(DelicateDyesBlocks.SKY_JACK_O_STRAW.get());
        jackOStrawDrops(DelicateDyesBlocks.BLURPLE_JACK_O_STRAW.get());
        jackOStrawDrops(DelicateDyesBlocks.SANGRIA_JACK_O_STRAW.get());
        jackOStrawDrops(DelicateDyesBlocks.ROSE_JACK_O_STRAW.get());
    }

    public void jackOStrawDrops(Block block) {
        this.add(block, this.createSinglePropConditionTable(block, JackOStrawBlock.HALF, DoubleBlockHalf.LOWER));
    }
}
