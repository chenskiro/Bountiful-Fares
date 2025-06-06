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
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;

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
            generator.addProvider(event.includeServer(), new BFModelProvider(packOutput, helper));
            generator.addProvider(event.includeServer(), new BFLangProvider(packOutput));
        }


        // for compat
        // ELS_AND_LS_DYES
        packOutput = packOutput.move(Path.of("resourcepacks", BountifulFares.ELS_AND_LS_DYES_MOD_ID + "_dat"));
        if (event.includeServer()) {
            generator.addProvider(event.includeServer(), new MintBlockLootTableProvider.BFLootTableProvider(packOutput));
            generator.addProvider(event.includeServer(), new MintBlockTagProvider(packOutput, lookupProvider));
            generator.addProvider(event.includeServer(), new MintRecipeProvider(packOutput));
        }

        // ARTS_AND_CRAFTS
        packOutput = packOutput.move(Path.of("resourcepacks", BountifulFares.ARTS_AND_CRAFTS_MOD_ID + "_dat"));
        if (event.includeServer()) {
            generator.addProvider(event.includeServer(), new ArtsAndCraftsBlockLootTableProvider.BFLootTableProvider(packOutput));
            generator.addProvider(event.includeServer(), new ArtsAndCraftsBlockTagProvider(packOutput, lookupProvider));
            generator.addProvider(event.includeServer(), new ArtsAndCraftsRecipeProvider(packOutput));
        }

        // DYE_DEPOT
        packOutput = packOutput.move(Path.of("resourcepacks", BountifulFares.DYE_DEPOT_MOD_ID + "_dat"));
        if (event.includeServer()) {
            generator.addProvider(event.includeServer(), new DyeDepotBlockLootTableProvider.BFLootTableProvider(packOutput));
            generator.addProvider(event.includeServer(), new DyeDepotBlockTagProvider(packOutput, lookupProvider));
            generator.addProvider(event.includeServer(), new DyeDepotRecipeProvider(packOutput));
        }

        // EXCESSIVE_BUILDING
        packOutput = packOutput.move(Path.of("resourcepacks", BountifulFares.EXCESSIVE_BUILDING_MOD_ID + "_dat"));
        if (event.includeServer()) {
            generator.addProvider(event.includeServer(), new ExcessiveBuildingBlockLootTableProvider.BFLootTableProvider(packOutput));
            generator.addProvider(event.includeServer(), new ExcessiveBuildingBlockTagProvider(packOutput, lookupProvider));
            generator.addProvider(event.includeServer(), new ExcessiveBuildingRecipeProvider(packOutput));
        }

        // FARMERS_DELIGHT
        packOutput = packOutput.move(Path.of("resourcepacks", BountifulFares.FARMERS_DELIGHT_MOD_ID + "_dat"));
        if (event.includeServer()) {
            generator.addProvider(event.includeServer(), new FarmersDelightBlockLootTableProvider.BFLootTableProvider(packOutput));
            generator.addProvider(event.includeServer(), new FarmersDelightBlockTagProvider(packOutput, lookupProvider));
            generator.addProvider(event.includeServer(), new FarmersDelightRecipeProvider(packOutput));
        }

        // NATURES_SPIRIT
        packOutput = packOutput.move(Path.of("resourcepacks", BountifulFares.NATURES_SPIRIT_MOD_ID + "_dat"));
        if (event.includeServer()) {
            generator.addProvider(event.includeServer(), new NaturesSpiritBlockLootTableProvider.BFLootTableProvider(packOutput));
            NaturesSpiritBlockTagProvider naturesSpiritBlockTagProvider = new NaturesSpiritBlockTagProvider(packOutput, lookupProvider);
            generator.addProvider(event.includeServer(), naturesSpiritBlockTagProvider);
            generator.addProvider(event.includeServer(), new NaturesSpiritItemTagProvider(packOutput, lookupProvider, naturesSpiritBlockTagProvider.contentsGetter()));
            generator.addProvider(event.includeServer(), new NaturesSpiritRecipeProvider(packOutput));
        }

        // SPAWN
        packOutput = packOutput.move(Path.of("resourcepacks", BountifulFares.SPAWN_MOD_ID + "_dat"));
        if (event.includeServer()) {
            generator.addProvider(event.includeServer(), new SpawnBlockLootTableProvider.BFLootTableProvider(packOutput));
            generator.addProvider(event.includeServer(), new SpawnBlockTagProvider(packOutput, lookupProvider));
            generator.addProvider(event.includeServer(), new SpawnRecipeProvider(packOutput));
        }

        // TWIGS
        packOutput = packOutput.move(Path.of("resourcepacks", BountifulFares.TWIGS_MOD_ID + "_dat"));
        if (event.includeServer()) {
            generator.addProvider(event.includeServer(), new TwigsBlockLootTableProvider.BFLootTableProvider(packOutput));
            generator.addProvider(event.includeServer(), new TwigsBlockTagProvider(packOutput, lookupProvider));
            generator.addProvider(event.includeServer(), new TwigsRecipeProvider(packOutput));
        }

        // DELICATE_DYES
        packOutput = packOutput.move(Path.of("resourcepacks", BountifulFares.DELICATE_DYES_MOD_ID + "_dat"));
        if (event.includeServer()) {
            generator.addProvider(event.includeServer(), new DelicateDyesBlockLootTableProvider.BFLootTableProvider(packOutput));
            generator.addProvider(event.includeServer(), new DelicateDyesBlockTagProvider(packOutput, lookupProvider));
            generator.addProvider(event.includeServer(), new DelicateDyesRecipeProvider(packOutput));
        }

        // APPLEDOG
        packOutput = packOutput.move(Path.of("resourcepacks", BountifulFares.APPLEDOG_MOD_ID + "_dat"));
        if (event.includeServer()) {
            generator.addProvider(event.includeServer(), new AppledogBlockLootTableProvider.BFLootTableProvider(packOutput));
            generator.addProvider(event.includeServer(), new AppledogBlockTagProvider(packOutput, lookupProvider));
            generator.addProvider(event.includeServer(), new AppledogRecipeProvider(packOutput));
        }

        // DUNGEONS_DELIGHT
        packOutput = packOutput.move(Path.of("resourcepacks", BountifulFares.DUNGEONS_DELIGHT_MOD_ID + "_dat"));
        if (event.includeServer()) {
            generator.addProvider(event.includeServer(), new DungeonsDelightBlockLootTableProvider.BFLootTableProvider(packOutput));
            generator.addProvider(event.includeServer(), new DungeonsDelightBlockTagProvider(packOutput, lookupProvider));
            generator.addProvider(event.includeServer(), new DungeonsDelightRecipeProvider(packOutput));
        }

        // DISABLE_COMPAT_ITEMS
        packOutput = packOutput.move(Path.of("resourcepacks", "hide_compat_items"));
        if (event.includeServer()) {
            BlockTagsProvider tagsProvider = new BlockTagsProvider(packOutput, lookupProvider, "hide_compat_items", helper) {
                @Override
                protected void addTags(HolderLookup.@NotNull Provider pProvider) {
                }
            };
            generator.addProvider(event.includeServer(), tagsProvider);
            generator.addProvider(event.includeServer(), new DisableCompatItemsVisibility(packOutput, lookupProvider, tagsProvider.contentsGetter()));
        }
    }
}
