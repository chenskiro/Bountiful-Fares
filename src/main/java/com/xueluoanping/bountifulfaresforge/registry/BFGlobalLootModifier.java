package com.xueluoanping.bountifulfaresforge.registry;

import com.mojang.serialization.Codec;
import com.xueluoanping.bountifulfaresforge.BountifulFaresForge;
import com.xueluoanping.bountifulfaresforge.loot.AddItemModifier;
import com.xueluoanping.bountifulfaresforge.loot.AddLootTableModifier;
import net.hecco.bountifulfares.BountifulFares;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BFGlobalLootModifier {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, BountifulFares.MOD_ID);
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_LOOT_TABLE = LOOT_MODIFIERS.register("add_loot_table", AddLootTableModifier.CODEC);
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_ITEM = LOOT_MODIFIERS.register("add_item", AddItemModifier.CODEC);
}
