package com.xueluoanping.bountifulfaresforge.data.loot;

import com.xueluoanping.bountifulfaresforge.loot.AddItemModifier;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.List;
import java.util.stream.Stream;

public class BFGLMProvider extends GlobalLootModifierProvider {
    public BFGLMProvider(PackOutput gen, String modid) {
        super(gen, modid);
    }

    @Override
    protected void start() {


        add("add_grass_seed", new AddItemModifier(Stream.of(Blocks.GRASS, Blocks.TALL_GRASS, Blocks.FERN, Blocks.LARGE_FERN)
                .map(grass -> LootTableIdCondition.builder(grass.getLootTable())
                        .and(LootItemRandomChanceCondition.randomChance(0.005f))
                        .build()).toArray(LootItemCondition[]::new)
                , BFItems.GRASS_SEEDS.get(), 1));


        for (var seed : List.of(BFItems.LAPISBERRY_SEEDS, BFItems.HOARY_SEEDS)) {
            LootItemCondition lootItemCondition = LootTableIdCondition.builder(BuiltInLootTables.SNIFFER_DIGGING)
                    .and(LootItemRandomChanceCondition.randomChance(0.6f))
                    .build();
            add("add_sniffer_digging_"+seed.getId().getPath() ,
                    new AddItemModifier(new LootItemCondition[]{lootItemCondition}, seed.get(), 1));
        }

        LootItemCondition lootItemCondition_guardian = LootTableIdCondition.builder(EntityType.GUARDIAN.getDefaultLootTable())
                .and(LootItemRandomChanceCondition.randomChance(0.16667f))
                .build();
        add("add_guardian_drop" ,
                new AddItemModifier(new LootItemCondition[]{lootItemCondition_guardian}, BFItems.SPONGEKIN_SEEDS.get(), 1));

        LootItemCondition lootItemCondition_elder_guardian = LootTableIdCondition.builder(EntityType.ELDER_GUARDIAN.getDefaultLootTable())
                .build();
        add("add_elder_guardian_drop" ,
                new AddItemModifier(new LootItemCondition[]{lootItemCondition_elder_guardian}, BFItems.SPONGEKIN_SEEDS.get(), 1));
    }


}
