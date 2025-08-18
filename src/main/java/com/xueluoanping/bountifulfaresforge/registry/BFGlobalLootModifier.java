package com.xueluoanping.bountifulfaresforge.registry;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.xueluoanping.bountifulfaresforge.BountifulFaresForge;
import com.xueluoanping.bountifulfaresforge.loot.AddItemModifier;
import com.xueluoanping.bountifulfaresforge.loot.AddLootTableModifier;
import net.hecco.bountifulfares.BountifulFares;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class BFGlobalLootModifier {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, BountifulFares.MOD_ID);
    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<AddLootTableModifier>> ADD_LOOT_TABLE = LOOT_MODIFIERS.register("add_loot_table", AddLootTableModifier.CODEC);
    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<AddItemModifier>> ADD_ITEM = LOOT_MODIFIERS.register("add_item", AddItemModifier.CODEC);
}
