package com.xueluoanping.bountifulfaresforge.data;


import com.xueluoanping.bountifulfaresforge.api.data.MutablePackOutput;
import com.xueluoanping.bountifulfaresforge.data.datapack.DatapackRegistryGenerator;
import com.xueluoanping.bountifulfaresforge.data.loot.BFGLMProvider;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.datagen.DisableCompatItemsVisibility;
import net.hecco.bountifulfares.datagen.appledog.AppledogBlockLootTableProvider;
import net.hecco.bountifulfares.datagen.appledog.AppledogBlockTagProvider;
import net.hecco.bountifulfares.datagen.appledog.AppledogRecipeProvider;
import net.hecco.bountifulfares.datagen.arts_and_crafts.ArtsAndCraftsBlockLootTableProvider;
import net.hecco.bountifulfares.datagen.arts_and_crafts.ArtsAndCraftsBlockTagProvider;
import net.hecco.bountifulfares.datagen.arts_and_crafts.ArtsAndCraftsRecipeProvider;
import net.hecco.bountifulfares.datagen.bountifulfares.*;
import net.hecco.bountifulfares.datagen.delicate_dyes.DelicateDyesBlockLootTableProvider;
import net.hecco.bountifulfares.datagen.delicate_dyes.DelicateDyesBlockTagProvider;
import net.hecco.bountifulfares.datagen.delicate_dyes.DelicateDyesRecipeProvider;
import net.hecco.bountifulfares.datagen.dungeons_delight.DungeonsDelightBlockLootTableProvider;
import net.hecco.bountifulfares.datagen.dungeons_delight.DungeonsDelightBlockTagProvider;
import net.hecco.bountifulfares.datagen.dungeons_delight.DungeonsDelightRecipeProvider;
import net.hecco.bountifulfares.datagen.dye_depot.DyeDepotBlockLootTableProvider;
import net.hecco.bountifulfares.datagen.dye_depot.DyeDepotBlockTagProvider;
import net.hecco.bountifulfares.datagen.dye_depot.DyeDepotRecipeProvider;
import net.hecco.bountifulfares.datagen.excessive_building.ExcessiveBuildingBlockLootTableProvider;
import net.hecco.bountifulfares.datagen.excessive_building.ExcessiveBuildingBlockTagProvider;
import net.hecco.bountifulfares.datagen.excessive_building.ExcessiveBuildingRecipeProvider;
import net.hecco.bountifulfares.datagen.farmersdelight.FarmersDelightBlockLootTableProvider;
import net.hecco.bountifulfares.datagen.farmersdelight.FarmersDelightBlockTagProvider;
import net.hecco.bountifulfares.datagen.farmersdelight.FarmersDelightRecipeProvider;
import net.hecco.bountifulfares.datagen.mint.MintBlockLootTableProvider;
import net.hecco.bountifulfares.datagen.mint.MintBlockTagProvider;
import net.hecco.bountifulfares.datagen.mint.MintRecipeProvider;
import net.hecco.bountifulfares.datagen.natures_spirit.NaturesSpiritBlockLootTableProvider;
import net.hecco.bountifulfares.datagen.natures_spirit.NaturesSpiritBlockTagProvider;
import net.hecco.bountifulfares.datagen.natures_spirit.NaturesSpiritItemTagProvider;
import net.hecco.bountifulfares.datagen.natures_spirit.NaturesSpiritRecipeProvider;
import net.hecco.bountifulfares.datagen.spawn.SpawnBlockLootTableProvider;
import net.hecco.bountifulfares.datagen.spawn.SpawnBlockTagProvider;
import net.hecco.bountifulfares.datagen.spawn.SpawnRecipeProvider;
import net.hecco.bountifulfares.datagen.twigs.TwigsBlockLootTableProvider;
import net.hecco.bountifulfares.datagen.twigs.TwigsBlockTagProvider;
import net.hecco.bountifulfares.datagen.twigs.TwigsRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;

import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;


public final class start {
    public final static String MODID = BountifulFares.MOD_ID;

    public static void onDataGather(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();
        MutablePackOutput packOutput = new MutablePackOutput(generator.getPackOutput());
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        if (event.includeServer()) {
            generator.addProvider(event.includeServer(), new BFGLMProvider(packOutput, MODID));
            generator.addProvider(event.includeServer(), new BFRecipeProvider(packOutput));
            generator.addProvider(event.includeServer(), new BFBlockLootTableProvider.BFLootTableProvider(packOutput));
            BFBlockTagProvider bfBlockTagProvider = new BFBlockTagProvider(packOutput, lookupProvider);
            generator.addProvider(event.includeServer(), bfBlockTagProvider);
            generator.addProvider(event.includeServer(), new BFItemTagProvider(packOutput, lookupProvider, bfBlockTagProvider.contentsGetter()));
            generator.addProvider(event.includeServer(), new DatapackRegistryGenerator(packOutput, lookupProvider));

            // for compat

        }
        if (event.includeClient()) {
            packOutput.reset();
            generator.addProvider(event.includeServer(), new BFModelProvider(packOutput,helper));
            generator.addProvider(event.includeServer(), new BFLangProvider(packOutput));
        }
        
        
        // for compat
        // ELS_AND_LS_DYES
         packOutput.move(Path.of("resourcepacks", BountifulFares.ELS_AND_LS_DYES_MOD_ID + "_dat"));
        if (event.includeServer()) {
            generator.addProvider(true, new MintBlockLootTableProvider.BFLootTableProvider(packOutput));
            generator.addProvider(true, new MintBlockTagProvider(packOutput,lookupProvider));
            generator.addProvider(true, new MintRecipeProvider(packOutput));
        }

        // ARTS_AND_CRAFTS
         packOutput.move(Path.of("resourcepacks", BountifulFares.ARTS_AND_CRAFTS_MOD_ID + "_dat"));
        if (event.includeServer()) {
            generator.addProvider(true, new ArtsAndCraftsBlockLootTableProvider.BFLootTableProvider(packOutput));
            generator.addProvider(true, new ArtsAndCraftsBlockTagProvider(packOutput, lookupProvider));
            generator.addProvider(true, new ArtsAndCraftsRecipeProvider(packOutput));
        }

        // DYE_DEPOT
         packOutput.move(Path.of("resourcepacks", BountifulFares.DYE_DEPOT_MOD_ID + "_dat"));
        if (event.includeServer()) {
            generator.addProvider(true, new DyeDepotBlockLootTableProvider.BFLootTableProvider(packOutput));
            generator.addProvider(true, new DyeDepotBlockTagProvider(packOutput, lookupProvider));
            generator.addProvider(true, new DyeDepotRecipeProvider(packOutput));
        }

        // EXCESSIVE_BUILDING
         packOutput.move(Path.of("resourcepacks", BountifulFares.EXCESSIVE_BUILDING_MOD_ID + "_dat"));
        if (event.includeServer()) {
            generator.addProvider(true, new ExcessiveBuildingBlockLootTableProvider.BFLootTableProvider(packOutput));
            generator.addProvider(true, new ExcessiveBuildingBlockTagProvider(packOutput, lookupProvider));
            generator.addProvider(true, new ExcessiveBuildingRecipeProvider(packOutput));
        }

        // FARMERS_DELIGHT
         packOutput.move(Path.of("resourcepacks", BountifulFares.FARMERS_DELIGHT_MOD_ID + "_dat"));
        if (event.includeServer()) {
            generator.addProvider(true, new FarmersDelightBlockLootTableProvider.BFLootTableProvider(packOutput));
            generator.addProvider(true, new FarmersDelightBlockTagProvider(packOutput, lookupProvider));
            generator.addProvider(true, new FarmersDelightRecipeProvider(packOutput));
        }

        // NATURES_SPIRIT
         packOutput.move(Path.of("resourcepacks", BountifulFares.NATURES_SPIRIT_MOD_ID + "_dat"));
        if (event.includeServer()) {
            generator.addProvider(true, new NaturesSpiritBlockLootTableProvider.BFLootTableProvider(packOutput));
            NaturesSpiritBlockTagProvider naturesSpiritBlockTagProvider = new NaturesSpiritBlockTagProvider(packOutput, lookupProvider);
            generator.addProvider(true, naturesSpiritBlockTagProvider);
            generator.addProvider(true, new NaturesSpiritItemTagProvider(packOutput, lookupProvider,naturesSpiritBlockTagProvider.contentsGetter()));
            generator.addProvider(true, new NaturesSpiritRecipeProvider(packOutput));
        }

        // SPAWN
         packOutput.move(Path.of("resourcepacks", BountifulFares.SPAWN_MOD_ID + "_dat"));
        if (event.includeServer()) {
            generator.addProvider(true, new SpawnBlockLootTableProvider.BFLootTableProvider(packOutput));
            generator.addProvider(true, new SpawnBlockTagProvider(packOutput, lookupProvider));
            generator.addProvider(true, new SpawnRecipeProvider(packOutput));
        }

        // TWIGS
         packOutput.move(Path.of("resourcepacks", BountifulFares.TWIGS_MOD_ID + "_dat"));
        if (event.includeServer()) {
            generator.addProvider(true, new TwigsBlockLootTableProvider.BFLootTableProvider(packOutput));
            generator.addProvider(true, new TwigsBlockTagProvider(packOutput, lookupProvider));
            generator.addProvider(true, new TwigsRecipeProvider(packOutput));
        }

        // DELICATE_DYES
         packOutput.move(Path.of("resourcepacks", BountifulFares.DELICATE_DYES_MOD_ID + "_dat"));
        if (event.includeServer()) {
            generator.addProvider(true, new DelicateDyesBlockLootTableProvider.BFLootTableProvider(packOutput));
            generator.addProvider(true, new DelicateDyesBlockTagProvider(packOutput, lookupProvider));
            generator.addProvider(true, new DelicateDyesRecipeProvider(packOutput));
        }

        // APPLEDOG
         packOutput.move(Path.of("resourcepacks", BountifulFares.APPLEDOG_MOD_ID + "_dat"));
        if (event.includeServer()) {
            generator.addProvider(true, new AppledogBlockLootTableProvider.BFLootTableProvider(packOutput));
            generator.addProvider(true, new AppledogBlockTagProvider(packOutput, lookupProvider));
            generator.addProvider(true, new AppledogRecipeProvider(packOutput));
        }

        // DUNGEONS_DELIGHT
         packOutput.move(Path.of("resourcepacks", BountifulFares.DUNGEONS_DELIGHT_MOD_ID + "_dat"));
        if (event.includeServer()) {
            generator.addProvider(true, new DungeonsDelightBlockLootTableProvider.BFLootTableProvider(packOutput));
            generator.addProvider(true, new DungeonsDelightBlockTagProvider(packOutput, lookupProvider));
            generator.addProvider(true, new DungeonsDelightRecipeProvider(packOutput));
        }

        // DISABLE_COMPAT_ITEMS
         packOutput.move(Path.of("resourcepacks", "hide_compat_items"));
        if (event.includeServer()) {
            generator.addProvider(true, new DisableCompatItemsVisibility(packOutput,lookupProvider,new CompletableFuture<>()));
        }
    }
}
