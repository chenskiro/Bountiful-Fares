package com.xueluoanping.bountifulfaresforge.data;


import com.xueluoanping.bountifulfaresforge.data.datapack.DatapackRegistryGenerator;
import com.xueluoanping.bountifulfaresforge.data.loot.BFGLMProvider;
import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;


public final class start {
    public final static String MODID = BountifulFares.MOD_ID;

    public static void onDataGather(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        if (event.includeServer()) {
            generator.addProvider(event.includeServer(),new BFGLMProvider(packOutput, MODID));

            generator.addProvider(event.includeServer(),new DatapackRegistryGenerator(packOutput,lookupProvider));
        }if (event.includeClient()) {


        }
    }
}
