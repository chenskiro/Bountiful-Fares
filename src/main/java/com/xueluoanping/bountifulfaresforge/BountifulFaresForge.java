package com.xueluoanping.bountifulfaresforge;

import com.xueluoanping.bountifulfaresforge.data.start;
import com.xueluoanping.bountifulfaresforge.registry.BFGlobalLootModifier;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFEntities;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.util.BFRegistries;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;

import java.util.Map;


@Mod(BountifulFares.MOD_ID)
public class BountifulFaresForge {
    public final BountifulFares MOD_INSTANCE;

    public BountifulFaresForge() {
        MOD_INSTANCE = new BountifulFares();
        MOD_INSTANCE.onInitialize();
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

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

        FMLJavaModLoadingContext.get().getModEventBus().addListener(BFRegistries::RegisterModStuffs);

        // datagen
        FMLJavaModLoadingContext.get().getModEventBus().addListener(start::onDataGather);
    }
}
