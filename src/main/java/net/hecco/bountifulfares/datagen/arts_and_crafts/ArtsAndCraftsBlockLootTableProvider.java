package net.hecco.bountifulfares.datagen.arts_and_crafts;

import net.minecraft.data.PackOutput;
import com.xueluoanping.bountifulfaresforge.api.data.provider.AutoSkipBlockLootSubProvider;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.BountifulFaresUtil;
import net.hecco.bountifulfares.block.custom.PicketsBlock;
import net.hecco.bountifulfares.compat.arts_and_crafts.ArtsAndCraftsBlocks;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.hecco.bountifulfares.trellis.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.trellis.trellis_parts.VineCrop;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.LootTableProvider;
import com.xueluoanping.bountifulfaresforge.api.data.provider.ModNameLootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ArtsAndCraftsBlockLootTableProvider extends AutoSkipBlockLootSubProvider {
    public static class BFLootTableProvider extends ModNameLootTableProvider {
        private final PackOutput generator;

        public BFLootTableProvider(PackOutput generator) {
            super(generator, Set.of(), List.of(new LootTableProvider.SubProviderEntry(
                    ArtsAndCraftsBlockLootTableProvider::new,
                    LootContextParamSets.BLOCK
            )));
            this.generator = generator;
        }
    }

    public ArtsAndCraftsBlockLootTableProvider() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
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
        registerTrellisLootTables(ArtsAndCraftsBlocks.CORK);
        picketsDrops(ArtsAndCraftsBlocks.CORK_PICKETS.get());

        for (ResourceLocation id : BountifulFaresUtil.allBlockIdsInNamespace(BountifulFares.ARTS_AND_CRAFTS_MOD_ID)) {
            Block block = BuiltInRegistries.BLOCK.get(id);
            if (usedBlocks.contains(block)) {
                continue;
            }
            this.dropSelf(block);
        }
    }

    public void registerTrellisLootTables(TrellisVariant trellis) {
        this.dropSelf(TrellisUtil.getTrellisFromVariant(trellis).get());
        for (VineCrop crop : TrellisUtil.VineCrops) {
            this.add(TrellisUtil.getCropTrellisFromVariant(trellis, crop).get(), LootTable.lootTable()
                    .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                            .add(this.applyExplosionDecay(TrellisUtil.getCropTrellisFromVariant(trellis, crop).get(), LootItem.lootTableItem(TrellisUtil.getTrellisFromVariant(trellis).get())))));
        }
        for (DecorativeVine vine : TrellisUtil.DecorativeVines) {
            this.add(TrellisUtil.getDecorTrellisFromVariant(trellis, vine).get(), LootTable.lootTable()
                    .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                            .add(this.applyExplosionDecay(TrellisUtil.getDecorTrellisFromVariant(trellis, vine).get(), LootItem.lootTableItem(TrellisUtil.getTrellisFromVariant(trellis).get())))));
        }
    }

    public void picketsDrops(Block block) {
        this.add(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PicketsBlock.NORTH, true)))
                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(block))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PicketsBlock.EAST, true)))
                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(block))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PicketsBlock.SOUTH, true)))
                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(block))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PicketsBlock.WEST, true)))
                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(block)))));
    }
}
