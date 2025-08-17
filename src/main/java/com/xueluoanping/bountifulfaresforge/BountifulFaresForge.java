package com.xueluoanping.bountifulfaresforge;

import com.xueluoanping.bountifulfaresforge.data.start;
import com.xueluoanping.bountifulfaresforge.registry.BFGlobalLootModifier;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFEntities;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.misc.BFResourcePacks;
import net.hecco.bountifulfares.registry.util.BFRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;


import java.util.Map;


@Mod(BountifulFares.MOD_ID)
public class BountifulFaresForge {
    public final BountifulFares MOD_INSTANCE;

    public BountifulFaresForge(IEventBus modEventBus, ModContainer modContainer) {
        MOD_INSTANCE = new BountifulFares();
        MOD_INSTANCE.onInitialize();

        BFBlocks.BLOCK_DEFERRED_REGISTER.register(modEventBus);
        BFBlocks.ITEM_DEFERRED_REGISTER.register(modEventBus);
        BFItems.ITEM_DEFERRED_REGISTER.register(modEventBus);
        for (Map<String, DeferredRegister<?>> value : BFBlocks.REGISTER_MAP.values()) {
            for (DeferredRegister<?> deferredRegister : value.values()) {
                deferredRegister.register(modEventBus);
            }
        }
        BFBlockEntities.BLOCK_ENTITY_TYPE_DEFERRED_REGISTER.register(modEventBus);
        BFEntities.ENTITY_TYPE_DEFERRED_REGISTER.register(modEventBus);
        BFGlobalLootModifier.LOOT_MODIFIERS.register(modEventBus);

        modEventBus.addListener(BFRegistries::RegisterModStuffs);

        // datagen
        modEventBus.addListener(start::onDataGather);

        // datagen
        modEventBus.addListener(BFResourcePacks::registerBuiltinResourcePacks);
    }
}
