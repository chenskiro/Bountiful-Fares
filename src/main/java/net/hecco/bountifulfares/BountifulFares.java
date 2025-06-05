package net.hecco.bountifulfares;

import net.hecco.bountifulfares.registry.content.*;
import net.hecco.bountifulfares.registry.misc.*;
import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.hecco.bountifulfares.registry.util.BFRegistries;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


public class BountifulFares  {
	public static final String MOD_ID = "bountifulfares";

	public static final String ELS_AND_LS_DYES_MOD_ID = "mint";
	public static final String DYE_DEPOT_MOD_ID = "dye_depot";
	public static final String AMENDMENTS_MOD_ID = "amendments";
	public static final String EXCESSIVE_BUILDING_MOD_ID = "excessive_building";
	public static final String DELICATE_DYES_MOD_ID = "delicate_dyes";
	public static final String NATURES_SPIRIT_MOD_ID = "natures_spirit";
	public static final String SPAWN_MOD_ID = "spawn";
	public static final String FARMERS_DELIGHT_MOD_ID = "farmersdelight";
	public static final String TWIGS_MOD_ID = "twigs";
	public static final String ETCETERA_MOD_ID = "etcetera";
	public static final String ARTS_AND_CRAFTS_MOD_ID = "arts_and_crafts";
	public static final String APPLEDOG_MOD_ID = "appledog";
	public static final String DUNGEONS_DELIGHT_MOD_ID = "dungeonsdelight";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static BountifulFaresConfiguration CONFIG = new BountifulFaresConfiguration();

	public static boolean isModLoaded(String modId) {
		return FMLLoader.getLoadingModList().getModFileById(modId) != null;
	}

	public static boolean isDatagen() {
		try {
			Class.forName("net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint");
			return System.getProperty("fabric-api.datagen") != null;
		} catch (ClassNotFoundException e) {
            return false;
        }
    }
	// @Override
	public void onInitialize() {
		BountifulFares.CONFIG = BountifulFaresConfiguration.load();

		// todo make forge version
		// BFResourcePacks.registerBuiltinResourcePacks();

		// BFItems.registerModItems.get()();
		// BFBlocks.registerModBlocks();
		BFTrellises.registerTrellisParts();
		TrellisUtil.registerTrellisParts();
		// BFItemGroups.registerItemGroups();
		// BFItemGroupAdditions.registerItemGroupAdditions();
		// BFRecipes.registerRecipes();

		// todo make forge version
		// BFTreeGeneration.generateTrees();
		// todo make forge version
		// BFFoliageGeneration.generateFlowers();

		// BFEffects.registerEffects();
		// todo not use api
		// BFBoats.registerBoats();

		// todo make forge version
		// BFLootTableModifiers.modifyLootTables();

		// BFParticles.registerParticles();
		// BFPotions.registerPotions();
		// BFTrunkPlacerTypes.register();
		// BFFeatures.register();
		// BFRegistries.RegisterModStuffs();
		// BFScreenHandlers.registerScreenHandlers();
		BFBlockEntities.cacheExtraBlockEntities(); //change to cache model
		// BFEntities.registerModEntities();
		// BFSounds.registerSounds();
		// BFDamageTypes.registerDamageTypes();
		// BFSpecialRecipes.registerSpecialRecipes();

		BFCompat.registerCompatContent();


		// DynamicRegistrySetupCallback.EVENT.register(registryManager -> {
		// 	LOGGER.info("DynamicRegistrySetupCallback triggered!");
		//
		// 	// Access the item registry
		// 	registryManager.getOptional(Registries.ITEM).ifPresent(itemRegistry -> {
		// 		LOGGER.info("Item registry is available!");
		// 		Holder<Item> diamondEntry = itemRegistry.wrapAsHolder(Items.DIAMOND);
		// 		LOGGER.info("Diamond Entry: " + diamondEntry);
		// 		if (diamondEntry != null) {
		// 			Map<TagKey<Item>, List<Holder<Item>>> map = new HashMap<>();
		// 			map.put(BFItemTags.C_HIDDEN_FROM_RECIPE_VIEWERS, List.of(diamondEntry));
		// 			itemRegistry.bindTags(map);
		// 		} else {
		// 			LOGGER.warn("Diamond entry is null!");
		// 		}
		// 	});
		// });

		// Optional<Holder<Item>> diamondEntry = ForgeRegistries.ITEMS.getHolder(Items.DIAMOND);
		// if (diamondEntry.isPresent()) {
		// 	Map<TagKey<Item>, List<Holder<Item>>> map = new HashMap<>();
		// 	map.put(BFItemTags.C_HIDDEN_FROM_RECIPE_VIEWERS, List.of(diamondEntry.get()));
		// 	ForgeRegistries.ITEMS.tags().addOptionalTagDefaults(BFItemTags.C_HIDDEN_FROM_RECIPE_VIEWERS,Set.of(()->Items.DIAMOND));
		// 	// BuiltInRegistries.ITEM.bindTags(map);
		// } else {
		// 	LOGGER.warn("Diamond entry is null!");
		// }
		ForgeRegistries.ITEMS.tags().addOptionalTagDefaults(BFItemTags.C_HIDDEN_FROM_RECIPE_VIEWERS,Set.of(()->Items.DIAMOND));
	} //appledog - Lydia
	//appledog - Hecco
	//appledog - Diemond_Player (holy self-insert)

	public static ResourceLocation rl(String id) {
		return new ResourceLocation(MOD_ID, id);
	}
}