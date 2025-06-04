package net.hecco.bountifulfares.registry.misc;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.compat.excessive_building.ExcessiveBuildingBlocks;
import net.hecco.bountifulfares.compat.natures_spirit.NaturesSpiritBlocks;
import net.hecco.bountifulfares.compat.spawn.SpawnBlocks;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.content.BFTrellises;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = BountifulFares.MOD_ID)
public class BFItemGroupAdditions {

    @SubscribeEvent
    public static void registerItemGroupAdditions(BuildCreativeModeTabContentsEvent event) {
//        BountifulFares.LOGGER.info("Adding Items to Vanilla Tabs from " + BountifulFares.MOD_ID);
        if (event.getTabKey().equals(CreativeModeTabs.BUILDING_BLOCKS))
        // ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(entries -> 
        {
            addAfter(event, Items.OAK_FENCE_GATE, BFBlocks.OAK_PICKETS);
            addAfter(event, Items.SPRUCE_FENCE_GATE, BFBlocks.SPRUCE_PICKETS);
            addAfter(event, Items.BIRCH_FENCE_GATE, BFBlocks.BIRCH_PICKETS);
            addAfter(event, Items.JUNGLE_FENCE_GATE, BFBlocks.JUNGLE_PICKETS);
            addAfter(event, Items.ACACIA_FENCE_GATE, BFBlocks.ACACIA_PICKETS);
            addAfter(event, Items.DARK_OAK_FENCE_GATE, BFBlocks.DARK_OAK_PICKETS);
            addAfter(event, Items.MANGROVE_FENCE_GATE, BFBlocks.MANGROVE_PICKETS);
            addAfter(event, Items.CHERRY_FENCE_GATE, BFBlocks.CHERRY_PICKETS);
            addAfter(event, Items.BAMBOO_FENCE_GATE, BFBlocks.BAMBOO_PICKETS);
            addAfter(event, Items.BAMBOO_BUTTON, BFBlocks.WALNUT_LOG);
            addAfter(event, BFBlocks.WALNUT_LOG, BFBlocks.WALNUT_WOOD);
            addAfter(event, BFBlocks.WALNUT_WOOD, BFBlocks.STRIPPED_WALNUT_LOG);
            addAfter(event, BFBlocks.STRIPPED_WALNUT_LOG, BFBlocks.STRIPPED_WALNUT_WOOD);
            addAfter(event, BFBlocks.STRIPPED_WALNUT_WOOD, BFBlocks.WALNUT_PLANKS);
            addAfter(event, BFBlocks.WALNUT_PLANKS, BFBlocks.WALNUT_STAIRS);
            addAfter(event, BFBlocks.WALNUT_STAIRS, BFBlocks.WALNUT_SLAB);
            addAfter(event, BFBlocks.WALNUT_SLAB, BFBlocks.WALNUT_FENCE);
            addAfter(event, BFBlocks.WALNUT_FENCE, BFBlocks.WALNUT_FENCE_GATE);
            addAfter(event, BFBlocks.WALNUT_FENCE_GATE, BFBlocks.WALNUT_PICKETS);
            addAfter(event, BFBlocks.WALNUT_PICKETS, BFBlocks.WALNUT_DOOR);
            addAfter(event, BFBlocks.WALNUT_DOOR, BFBlocks.WALNUT_TRAPDOOR);
            addAfter(event, BFBlocks.WALNUT_TRAPDOOR, BFBlocks.WALNUT_PRESSURE_PLATE);
            addAfter(event, BFBlocks.WALNUT_PRESSURE_PLATE, BFBlocks.WALNUT_BUTTON);
            addAfter(event, BFBlocks.WALNUT_BUTTON, BFBlocks.HOARY_LOG);
            addAfter(event, BFBlocks.HOARY_LOG, BFBlocks.HOARY_WOOD);
            addAfter(event, BFBlocks.HOARY_WOOD, BFBlocks.STRIPPED_HOARY_LOG);
            addAfter(event, BFBlocks.STRIPPED_HOARY_LOG, BFBlocks.STRIPPED_HOARY_WOOD);
            addAfter(event, BFBlocks.STRIPPED_HOARY_WOOD, BFBlocks.HOARY_PLANKS);
            addAfter(event, BFBlocks.HOARY_PLANKS, BFBlocks.HOARY_STAIRS);
            addAfter(event, BFBlocks.HOARY_STAIRS, BFBlocks.HOARY_SLAB);
            addAfter(event, BFBlocks.HOARY_SLAB, BFBlocks.HOARY_FENCE);
            addAfter(event, BFBlocks.HOARY_FENCE, BFBlocks.HOARY_FENCE_GATE);
            addAfter(event, BFBlocks.HOARY_FENCE_GATE, BFBlocks.HOARY_PICKETS);
            addAfter(event, BFBlocks.HOARY_PICKETS, BFBlocks.HOARY_DOOR);
            addAfter(event, BFBlocks.HOARY_DOOR, BFBlocks.HOARY_TRAPDOOR);
            addAfter(event, BFBlocks.HOARY_TRAPDOOR, BFBlocks.HOARY_PRESSURE_PLATE);
            addAfter(event, BFBlocks.HOARY_PRESSURE_PLATE, BFBlocks.HOARY_BUTTON);
            addAfter(event, Items.CRIMSON_FENCE_GATE, BFBlocks.CRIMSON_PICKETS);
            addAfter(event, Items.WARPED_FENCE_GATE, BFBlocks.WARPED_PICKETS);
            addAfter(event, Items.WARPED_BUTTON, BFBlocks.APPLE_LOG);
            addAfter(event, BFBlocks.APPLE_LOG, BFBlocks.APPLE_WOOD);
            addAfter(event, BFBlocks.APPLE_WOOD, BFBlocks.STRIPPED_APPLE_LOG);
            addAfter(event, BFBlocks.STRIPPED_APPLE_LOG, BFBlocks.STRIPPED_APPLE_WOOD);
            addAfter(event, BFBlocks.STRIPPED_APPLE_WOOD, BFBlocks.ORANGE_LOG);
            addAfter(event, BFBlocks.ORANGE_LOG, BFBlocks.ORANGE_WOOD);
            addAfter(event, BFBlocks.ORANGE_WOOD, BFBlocks.STRIPPED_ORANGE_LOG);
            addAfter(event, BFBlocks.STRIPPED_ORANGE_LOG, BFBlocks.STRIPPED_ORANGE_WOOD);
            addAfter(event, BFBlocks.STRIPPED_ORANGE_WOOD, BFBlocks.LEMON_LOG);
            addAfter(event, BFBlocks.LEMON_LOG, BFBlocks.LEMON_WOOD);
            addAfter(event, BFBlocks.LEMON_WOOD, BFBlocks.STRIPPED_LEMON_LOG);
            addAfter(event, BFBlocks.STRIPPED_LEMON_LOG, BFBlocks.STRIPPED_LEMON_WOOD);
            addAfter(event, BFBlocks.STRIPPED_LEMON_WOOD, BFBlocks.PLUM_LOG);
            addAfter(event, BFBlocks.PLUM_LOG, BFBlocks.PLUM_WOOD);
            addAfter(event, BFBlocks.PLUM_WOOD, BFBlocks.STRIPPED_PLUM_LOG);
            addAfter(event, BFBlocks.STRIPPED_PLUM_LOG, BFBlocks.STRIPPED_PLUM_WOOD);
            addAfter(event, BFBlocks.STRIPPED_PLUM_WOOD, BFBlocks.PALM_LOG);
            addAfter(event, BFBlocks.PALM_LOG, BFBlocks.PALM_WOOD);
            addAfter(event, BFBlocks.PALM_WOOD, BFBlocks.STRIPPED_PALM_LOG);
            addAfter(event, BFBlocks.STRIPPED_PALM_LOG, BFBlocks.STRIPPED_PALM_WOOD);
            addAfter(event, BFBlocks.STRIPPED_PALM_WOOD, BFBlocks.GOLDEN_APPLE_LOG);
            addAfter(event, BFBlocks.GOLDEN_APPLE_LOG, BFBlocks.GOLDEN_APPLE_WOOD);
//           addAfter(event,BFBlocks.STRIPPED_PLUM_WOOD, TrellisUtil.getTrellisFromVariant(ModTrellises.OAK));
//            TrellisVariant prevTrellis = ModTrellises.OAK;
//            for (TrellisVariant trellis : TrellisVariants.TrellisVariants) {
//                if (Objects.equals(trellis.getId(), BountifulFares.MOD_ID)) {
//                    if (trellis == ModTrellises.OAK) {
//                        continue;
//                    }
//                    if (TrellisUtil.getTrellisFromVariant(trellis) != null) {
//                       addAfter(event,TrellisUtil.getTrellisFromVariant(prevTrellis), TrellisUtil.getTrellisFromVariant(trellis));
//                        prevTrellis = trellis;
//                    }
//                }
//            }
            addAfter(event, BFBlocks.STRIPPED_PLUM_WOOD, BFBlocks.WALNUT_MULCH);
            addAfter(event, BFBlocks.WALNUT_MULCH, BFBlocks.WALNUT_MULCH_BLOCK);
            addAfter(event, BFBlocks.WALNUT_MULCH_BLOCK, BFBlocks.PALM_MULCH);
            addAfter(event, BFBlocks.PALM_MULCH, BFBlocks.PALM_MULCH_BLOCK);
            addAfter(event, Blocks.MUD_BRICK_WALL, BFBlocks.PACKED_COCONUT_COIR);
            addAfter(event, BFBlocks.PACKED_COCONUT_COIR, BFBlocks.COIR_CARPET);
            addAfter(event, BFBlocks.COIR_CARPET, BFBlocks.COIR_BRICKS);
            addAfter(event, BFBlocks.COIR_BRICKS, BFBlocks.COIR_BRICK_STAIRS);
            addAfter(event, BFBlocks.COIR_BRICK_STAIRS, BFBlocks.COIR_BRICK_SLAB);
            addAfter(event, BFBlocks.COIR_BRICK_SLAB, BFBlocks.COIR_BRICK_WALL);
            addAfter(event, Items.DARK_PRISMARINE_SLAB, BFBlocks.PRISMARINE_BLOSSOM);
            addAfter(event, BFBlocks.PRISMARINE_BLOSSOM, BFBlocks.FELDSPAR_BLOCK);
            addAfter(event, BFBlocks.FELDSPAR_BLOCK, BFBlocks.CUT_FELDSPAR_BLOCK);
            addAfter(event, BFBlocks.CUT_FELDSPAR_BLOCK, BFBlocks.FELDSPAR_BRICKS);
            addAfter(event, BFBlocks.FELDSPAR_BRICKS, BFBlocks.FELDSPAR_BRICK_STAIRS);
            addAfter(event, BFBlocks.FELDSPAR_BRICK_STAIRS, BFBlocks.FELDSPAR_BRICK_SLAB);
            addAfter(event, BFBlocks.FELDSPAR_BRICK_SLAB, BFBlocks.CERAMIC_CLAY_BLOCK);
            addAfter(event, BFBlocks.CERAMIC_CLAY_BLOCK, BFBlocks.CERAMIC_TILES);
            addAfter(event, BFBlocks.CERAMIC_TILES, BFBlocks.CERAMIC_TILE_STAIRS);
            addAfter(event, BFBlocks.CERAMIC_TILE_STAIRS, BFBlocks.CERAMIC_TILE_SLAB);
            addAfter(event, BFBlocks.CERAMIC_TILE_SLAB, BFBlocks.CRACKED_CERAMIC_TILES);
            addAfter(event, BFBlocks.CRACKED_CERAMIC_TILES, BFBlocks.CERAMIC_TILE_PILLAR);
            addAfter(event, BFBlocks.CERAMIC_TILE_PILLAR, BFBlocks.CERAMIC_MOSAIC);
            addAfter(event, BFBlocks.CERAMIC_MOSAIC, BFBlocks.CERAMIC_MOSAIC_STAIRS);
            addAfter(event, BFBlocks.CERAMIC_MOSAIC_STAIRS, BFBlocks.CERAMIC_MOSAIC_SLAB);
            addAfter(event, BFBlocks.CERAMIC_MOSAIC_SLAB, BFBlocks.CERAMIC_DOOR);
            addAfter(event, BFBlocks.CERAMIC_DOOR, BFBlocks.CERAMIC_TRAPDOOR);
            addAfter(event, BFBlocks.CERAMIC_TRAPDOOR, BFBlocks.CERAMIC_PRESSURE_PLATE);
            addAfter(event, BFBlocks.CERAMIC_PRESSURE_PLATE, BFBlocks.CERAMIC_BUTTON);
            addAfter(event, Blocks.IRON_BARS, BFBlocks.IRON_RAILING);
        }
        // );

        if (event.getTabKey().equals(CreativeModeTabs.NATURAL_BLOCKS))
        // ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register(entries ->
        {
            addAfter(event, Items.GRASS_BLOCK, BFBlocks.GRASSY_DIRT);
            addAfter(event, Items.CHERRY_LOG, BFBlocks.APPLE_LOG);
            addAfter(event, BFBlocks.APPLE_LOG, BFBlocks.ORANGE_LOG);
            addAfter(event, BFBlocks.ORANGE_LOG, BFBlocks.LEMON_LOG);
            addAfter(event, BFBlocks.LEMON_LOG, BFBlocks.PLUM_LOG);
            addAfter(event, BFBlocks.PLUM_LOG, BFBlocks.PALM_LOG);
            addAfter(event, BFBlocks.PALM_LOG, BFBlocks.PALM_CROWN);
            addAfter(event, Items.CHERRY_LOG, BFBlocks.WALNUT_LOG);
            addAfter(event, BFBlocks.WALNUT_LOG, BFBlocks.HOARY_LOG);
            addAfter(event, Items.FLOWERING_AZALEA_LEAVES, BFBlocks.APPLE_LEAVES);
            addAfter(event, BFBlocks.APPLE_LEAVES, BFBlocks.FLOWERING_APPLE_LEAVES);
            addAfter(event, BFBlocks.FLOWERING_APPLE_LEAVES, BFBlocks.ORANGE_LEAVES);
            addAfter(event, BFBlocks.ORANGE_LEAVES, BFBlocks.FLOWERING_ORANGE_LEAVES);
            addAfter(event, BFBlocks.FLOWERING_ORANGE_LEAVES, BFBlocks.LEMON_LEAVES);
            addAfter(event, BFBlocks.LEMON_LEAVES, BFBlocks.FLOWERING_LEMON_LEAVES);
            addAfter(event, BFBlocks.FLOWERING_LEMON_LEAVES, BFBlocks.PLUM_LEAVES);
            addAfter(event, BFBlocks.PLUM_LEAVES, BFBlocks.FLOWERING_PLUM_LEAVES);
            addAfter(event, BFBlocks.FLOWERING_PLUM_LEAVES, BFBlocks.GOLDEN_APPLE_LEAVES);
            addAfter(event, BFBlocks.GOLDEN_APPLE_LEAVES, BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES);
            addAfter(event, BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES, BFBlocks.WALNUT_LEAVES);
            addAfter(event, BFBlocks.WALNUT_LEAVES, BFBlocks.HOARY_LEAVES);
            addAfter(event, BFBlocks.HOARY_LEAVES, BFItems.PALM_FROND);
            addAfter(event, Items.CHERRY_SAPLING, BFBlocks.APPLE_SAPLING);
            addAfter(event, BFBlocks.APPLE_SAPLING, BFBlocks.ORANGE_SAPLING);
            addAfter(event, BFBlocks.ORANGE_SAPLING, BFBlocks.LEMON_SAPLING);
            addAfter(event, BFBlocks.LEMON_SAPLING, BFBlocks.PLUM_SAPLING);
            addAfter(event, BFBlocks.PLUM_SAPLING, BFBlocks.HOARY_APPLE_SAPLING);
            addAfter(event, BFBlocks.HOARY_APPLE_SAPLING, BFBlocks.WALNUT_SAPLING);
            addAfter(event, Blocks.FLOWERING_AZALEA, BFItems.COCONUT);
            addAfter(event, Items.SNIFFER_EGG, BFBlocks.WILD_WHEAT);
            addAfter(event, BFBlocks.WILD_WHEAT, BFBlocks.WILD_CARROTS);
            addAfter(event, BFBlocks.WILD_CARROTS, BFBlocks.WILD_POTATOES);
            addAfter(event, BFBlocks.WILD_POTATOES, BFBlocks.WILD_BEETROOTS);
            addAfter(event, BFBlocks.WILD_BEETROOTS, BFBlocks.WILD_LEEKS);
            addAfter(event, BFBlocks.WILD_LEEKS, BFBlocks.WILD_MAIZE);
            addAfter(event, BFBlocks.WILD_MAIZE, BFBlocks.WILD_PASSION_FRUIT_VINE);
            addAfter(event, BFBlocks.WILD_PASSION_FRUIT_VINE, BFBlocks.WILD_ELDERBERRY_VINE);
            addAfter(event, BFBlocks.WILD_ELDERBERRY_VINE, BFItems.GRASS_SEEDS);
            addAfter(event, BFItems.GRASS_SEEDS, BFItems.SWEET_BERRY_PIPS);
            addAfter(event, Items.KELP, BFBlocks.SPONGEKIN);
            addAfter(event, BFBlocks.SPONGEKIN, BFBlocks.PRISMARINE_BLOSSOM);
            addAfter(event, Items.LILY_OF_THE_VALLEY, BFBlocks.CHAMOMILE_FLOWERS);
            addAfter(event, BFBlocks.CHAMOMILE_FLOWERS, BFBlocks.HONEYSUCKLE);
            addAfter(event, BFBlocks.HONEYSUCKLE, BFBlocks.VIOLET_BELLFLOWER);
            addAfter(event, Items.BEETROOT_SEEDS, BFItems.MAIZE_SEEDS);
            addAfter(event, BFItems.MAIZE_SEEDS, BFItems.LEEK_SEEDS);
            addAfter(event, BFItems.LEEK_SEEDS, BFItems.TEA_BERRIES);
            addAfter(event, BFItems.TEA_BERRIES, BFItems.SPONGEKIN_SEEDS);
            addAfter(event, Items.PITCHER_POD, BFItems.LAPISBERRY_SEEDS);
            addAfter(event, BFItems.LAPISBERRY_SEEDS, BFItems.HOARY_SEEDS);
        }
        // );

        if (event.getTabKey().equals(CreativeModeTabs.FUNCTIONAL_BLOCKS))

        // ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(entries ->
        {
            addAfter(event, Items.LANTERN, BFBlocks.FELDSPAR_LANTERN);
            addAfter(event, Items.GRINDSTONE, BFBlocks.GRISTMILL);
            addAfter(event, Items.SOUL_CAMPFIRE, BFBlocks.GREEN_TEA_CANDLE);
            addAfter(event, BFBlocks.GREEN_TEA_CANDLE, BFBlocks.BLACK_TEA_CANDLE);
            addAfter(event, BFBlocks.BLACK_TEA_CANDLE, BFBlocks.CHAMOMILE_CANDLE);
            addAfter(event, BFBlocks.CHAMOMILE_CANDLE, BFBlocks.HONEYSUCKLE_CANDLE);
            addAfter(event, BFBlocks.HONEYSUCKLE_CANDLE, BFBlocks.BELLFLOWER_CANDLE);
            addAfter(event, BFBlocks.BELLFLOWER_CANDLE, BFBlocks.TORCHFLOWER_CANDLE);
            addAfter(event, BFBlocks.TORCHFLOWER_CANDLE, BFBlocks.WALNUT_CANDLE);
            addAfter(event, BFBlocks.WALNUT_CANDLE, BFBlocks.FERMENTATION_VESSEL);
            addAfter(event, BFBlocks.FERMENTATION_VESSEL, BFBlocks.COCONUT_CANDLE);
            addAfter(event, BFBlocks.COCONUT_CANDLE, BFBlocks.GOLDEN_APPLE_SAPLING);
            addAfter(event, Blocks.COMPOSTER, TrellisUtil.getTrellisFromVariant(BFTrellises.OAK));
            TrellisVariant prevTrellis = BFTrellises.OAK;
            for (TrellisVariant trellis : TrellisUtil.TrellisVariants) {
                if (Objects.equals(trellis.getModId(), BountifulFares.MOD_ID)) {
                    if (trellis == BFTrellises.OAK) {
                        continue;
                    }
                    if (TrellisUtil.getTrellisFromVariant(trellis) != null) {
                        addAfter(event, TrellisUtil.getTrellisFromVariant(prevTrellis), TrellisUtil.getTrellisFromVariant(trellis));
                        prevTrellis = trellis;
                    }
                }
            }
//            if (BountifulFares.isModLoaded(BountifulFares.ELS_AND_LS_DYES_MOD_ID)) {
//               addAfter(event,TrellisUtil.getTrellisFromVariant(prevTrellis), TrellisUtil.getTrellisFromVariant(BFTrellises.WINTERGREEN));
//                prevTrellis = BFTrellises.WINTERGREEN;
//            }
            if (BountifulFares.isModLoaded(BountifulFares.NATURES_SPIRIT_MOD_ID)) {
                addAfter(event, TrellisUtil.getTrellisFromVariant(prevTrellis), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.REDWOOD));
                addAfter(event, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.REDWOOD), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.SUGI));
                addAfter(event, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.SUGI), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.WISTERIA));
                addAfter(event, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.WISTERIA), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.FIR));
                addAfter(event, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.FIR), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.WILLOW));
                addAfter(event, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.WILLOW), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.ASPEN));
                addAfter(event, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.ASPEN), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.MAPLE));
                addAfter(event, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.MAPLE), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.CYPRESS));
                addAfter(event, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.CYPRESS), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.OLIVE));
                addAfter(event, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.OLIVE), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.JOSHUA));
                addAfter(event, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.JOSHUA), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.GHAF));
                addAfter(event, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.GHAF), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.PALO_VERDE));
                addAfter(event, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.PALO_VERDE), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.COCONUT));
                addAfter(event, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.COCONUT), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.CEDAR));
                addAfter(event, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.CEDAR), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.LARCH));
                addAfter(event, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.LARCH), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.MAHOGANY));
                addAfter(event, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.MAHOGANY), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.SAXAUL));
                prevTrellis = NaturesSpiritBlocks.SAXAUL;
            }
            if (BountifulFares.isModLoaded(BountifulFares.EXCESSIVE_BUILDING_MOD_ID)) {
                addAfter(event, TrellisUtil.getTrellisFromVariant(prevTrellis), TrellisUtil.getTrellisFromVariant(ExcessiveBuildingBlocks.ANCIENT));
                prevTrellis = ExcessiveBuildingBlocks.ANCIENT;
            }
            if (BountifulFares.isModLoaded(BountifulFares.SPAWN_MOD_ID)) {
                addAfter(event, TrellisUtil.getTrellisFromVariant(prevTrellis), TrellisUtil.getTrellisFromVariant(SpawnBlocks.ROTTEN));
                prevTrellis = SpawnBlocks.ROTTEN;
            }
            addAfter(event, Items.TINTED_GLASS, BFBlocks.TINGED_GLASS);
            addAfter(event, Items.BAMBOO_HANGING_SIGN, BFItems.WALNUT_SIGN);
            addAfter(event, BFItems.WALNUT_SIGN, BFItems.WALNUT_HANGING_SIGN);
            addAfter(event, BFItems.WALNUT_HANGING_SIGN, BFItems.HOARY_SIGN);
            addAfter(event, BFItems.HOARY_SIGN, BFItems.HOARY_HANGING_SIGN);
        }
        // );

        if (event.getTabKey().equals(CreativeModeTabs.REDSTONE_BLOCKS))
        // ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.REDSTONE_BLOCKS).register(rEntries ->
        {
            addAfter(event, Items.LEVER, BFBlocks.CERAMIC_LEVER);
            addAfter(event, Items.STONE_BUTTON, BFBlocks.CERAMIC_BUTTON);
            addAfter(event, Items.HEAVY_WEIGHTED_PRESSURE_PLATE, BFBlocks.CERAMIC_PRESSURE_PLATE);
            addAfter(event, Items.WHITE_WOOL, BFBlocks.CERAMIC_TILES);
        }
        // );

        if (event.getTabKey().equals(CreativeModeTabs.TOOLS_AND_UTILITIES))
        // ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries ->
        {
            addAfter(event, Items.LEAD, BFItems.SUN_HAT);
            addAfter(event, Items.BRUSH, BFItems.ARTISAN_BRUSH);
            addAfter(event, Items.BAMBOO_CHEST_RAFT, BFItems.WALNUT_BOAT);
            addAfter(event, BFItems.WALNUT_BOAT, BFItems.WALNUT_CHEST_BOAT);
            addAfter(event, BFItems.WALNUT_CHEST_BOAT, BFItems.HOARY_BOAT);
            addAfter(event, BFItems.HOARY_BOAT, BFItems.HOARY_CHEST_BOAT);
        }
        // );

        if (event.getTabKey().equals(CreativeModeTabs.COMBAT))
        // ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(entries ->
        {
            addAfter(event, Items.EGG, BFItems.FLOUR);
        }
        // );
        if (event.getTabKey().equals(CreativeModeTabs.FOOD_AND_DRINKS))
        // ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(entries ->
        {
            addAfter(event, Items.APPLE, BFItems.APPLE_COMPOTE_JAR);
            addAfter(event, BFItems.APPLE_COMPOTE_JAR, BFItems.APPLE_CIDER_JAR);
            addAfter(event, BFItems.APPLE_CIDER_JAR, BFBlocks.APPLE_BLOCK);
            addAfter(event, BFBlocks.APPLE_BLOCK, BFItems.ORANGE);
            addAfter(event, BFItems.ORANGE, BFItems.ORANGE_COMPOTE_JAR);
            addAfter(event, BFItems.ORANGE_COMPOTE_JAR, BFBlocks.ORANGE_BLOCK);
            addAfter(event, BFBlocks.ORANGE_BLOCK, BFItems.LEMON);
            addAfter(event, BFItems.LEMON, BFItems.LEMON_COMPOTE_JAR);
            addAfter(event, BFItems.LEMON_COMPOTE_JAR, BFBlocks.LEMON_BLOCK);
            addAfter(event, BFBlocks.LEMON_BLOCK, BFItems.PLUM);
            addAfter(event, BFItems.PLUM, BFItems.PLUM_COMPOTE_JAR);
            addAfter(event, BFItems.PLUM_COMPOTE_JAR, BFItems.PLUM_CIDER_JAR);
            addAfter(event, BFItems.PLUM_CIDER_JAR, BFBlocks.PLUM_BLOCK);
            addAfter(event, BFBlocks.PLUM_BLOCK, BFItems.HOARY_APPLE);
            addAfter(event, BFItems.HOARY_APPLE, BFItems.STUFFED_HOARY_APPLE);
            addAfter(event, BFItems.STUFFED_HOARY_APPLE, BFItems.HOARY_COMPOTE_JAR);
            addAfter(event, BFItems.HOARY_COMPOTE_JAR, BFItems.HOARY_CIDER_JAR);
            addAfter(event, BFItems.HOARY_CIDER_JAR, BFBlocks.HOARY_APPLE_BLOCK);
            addAfter(event, BFBlocks.HOARY_APPLE_BLOCK, BFItems.COCONUT_HALF);
            addAfter(event, Items.ENCHANTED_GOLDEN_APPLE, BFBlocks.GOLDEN_APPLE_BLOCK);
            addAfter(event, Items.MELON_SLICE, BFItems.SPONGEKIN_SLICE);
            addAfter(event, BFItems.SPONGEKIN_SLICE, BFItems.PICKLED_SPONGEKIN);
            addAfter(event, Items.SWEET_BERRIES, BFItems.PASSION_FRUIT);
            addAfter(event, BFItems.PASSION_FRUIT, BFItems.ELDERBERRIES);
            addAfter(event, BFItems.ELDERBERRIES, BFItems.ELDERBERRY_WINE_BOTTLE);
            addAfter(event, Items.GLOW_BERRIES, BFItems.LAPISBERRIES);
            addAfter(event, BFItems.LAPISBERRIES, BFItems.LAPISBERRY_WINE_BOTTLE);
            addAfter(event, Items.MILK_BUCKET, BFItems.COCONUT_MILK_BOTTLE);
            addAfter(event, BFItems.COCONUT_MILK_BOTTLE, BFItems.GREEN_TEA_BOTTLE);
            addAfter(event, BFItems.GREEN_TEA_BOTTLE, BFItems.BLACK_TEA_BOTTLE);
            addAfter(event, BFItems.BLACK_TEA_BOTTLE, BFItems.CHAMOMILE_TEA_BOTTLE);
            addAfter(event, BFItems.CHAMOMILE_TEA_BOTTLE, BFItems.HONEYSUCKLE_TEA_BOTTLE);
            addAfter(event, BFItems.HONEYSUCKLE_TEA_BOTTLE, BFItems.BELLFLOWER_TEA_BOTTLE);
            addAfter(event, BFItems.BELLFLOWER_TEA_BOTTLE, BFItems.TORCHFLOWER_TEA_BOTTLE);
            addAfter(event, Items.HONEY_BOTTLE, BFItems.MEAD_BOTTLE);
            addAfter(event, Items.BAKED_POTATO, BFItems.MUSHROOM_STUFFED_POTATO);
            addAfter(event, BFItems.MUSHROOM_STUFFED_POTATO, BFItems.BERRY_STUFFED_POTATO);
            addAfter(event, BFItems.BERRY_STUFFED_POTATO, BFItems.MAIZE_STUFFED_POTATO);
            addAfter(event, Items.BEETROOT, BFItems.MAIZE);
            addAfter(event, BFItems.MAIZE, BFItems.LEEK);
            addAfter(event, BFItems.LEEK, BFItems.WALNUT);
            addAfter(event, BFItems.WALNUT, BFItems.POPPED_MAIZE);
            addAfter(event, Items.BREAD, BFItems.MAIZE_BREAD);
            addAfter(event, BFItems.MAIZE_BREAD, BFBlocks.ARTISAN_BREAD);
            addAfter(event, Items.COOKIE, BFItems.WALNUT_COOKIE);
            addAfter(event, BFItems.WALNUT_COOKIE, BFItems.ARTISAN_COOKIE);
            addAfter(event, BFItems.ARTISAN_COOKIE, BFBlocks.PASSION_FRUIT_TART);
            addAfter(event, BFBlocks.PASSION_FRUIT_TART, BFBlocks.ELDERBERRY_TART);
            addAfter(event, BFBlocks.ELDERBERRY_TART, BFBlocks.GLOW_BERRY_TART);
            addAfter(event, BFBlocks.GLOW_BERRY_TART, BFBlocks.SWEET_BERRY_TART);
            addAfter(event, BFBlocks.SWEET_BERRY_TART, BFBlocks.LAPISBERRY_TART);
            addAfter(event, Items.CAKE, BFBlocks.COCOA_CAKE);
            addAfter(event, BFBlocks.COCOA_CAKE, BFBlocks.COCONUT_CAKE);
            addAfter(event, Items.PUMPKIN_PIE, BFBlocks.MELON_PIE);
            addAfter(event, BFBlocks.MELON_PIE, BFBlocks.APPLE_PIE);
            addAfter(event, BFBlocks.APPLE_PIE, BFBlocks.ORANGE_PIE);
            addAfter(event, BFBlocks.ORANGE_PIE, BFBlocks.LEMON_PIE);
            addAfter(event, BFBlocks.LEMON_PIE, BFBlocks.PLUM_PIE);
            addAfter(event, BFBlocks.PLUM_PIE, BFBlocks.HOARY_PIE);
            addAfter(event, Items.SPIDER_EYE, BFItems.CITRUS_ESSENCE);
            addAfter(event, BFItems.CITRUS_ESSENCE, BFItems.CANDY);
            addAfter(event, BFItems.CANDY, BFItems.PIQUANT_CANDY);
            addAfter(event, BFItems.PIQUANT_CANDY, BFItems.SOUR_CANDY);
            addAfter(event, BFItems.SOUR_CANDY, BFItems.BITTER_CANDY);
            addAfter(event, BFItems.BITTER_CANDY, BFItems.STRANGE_CANDY);
            addAfter(event, BFItems.STRANGE_CANDY, BFItems.CANDIED_APPLE);
            addAfter(event, BFItems.CANDIED_APPLE, BFItems.CANDIED_PLUM);
            addAfter(event, BFItems.CANDIED_PLUM, BFItems.CANDIED_ORANGE);
            addAfter(event, BFItems.CANDIED_ORANGE, BFItems.CANDIED_LEMON);
            addAfter(event, BFItems.CANDIED_LEMON, BFItems.FOREST_MEDLEY);
            addAfter(event, BFItems.FOREST_MEDLEY, BFItems.ARID_MEDLEY);
            addAfter(event, BFItems.ARID_MEDLEY, BFItems.MEADOW_MEDLEY);
            addAfter(event, BFItems.MEADOW_MEDLEY, BFItems.MIRE_MEDLEY);
            addAfter(event, BFItems.MIRE_MEDLEY, BFItems.COASTAL_MEDLEY);
            addAfter(event, BFItems.COASTAL_MEDLEY, BFItems.TROPICAL_MEDLEY);
            addAfter(event, BFItems.TROPICAL_MEDLEY, BFItems.SEA_SALAD);
            addAfter(event, Items.RABBIT_STEW, BFItems.LEEK_STEW);
            addAfter(event, BFItems.LEEK_STEW, BFItems.FISH_STEW);
            addAfter(event, BFItems.FISH_STEW, BFItems.APPLE_STEW);
            addAfter(event, BFItems.APPLE_STEW, BFItems.COCONUT_STEW);
            addAfter(event, BFItems.COCONUT_STEW, BFItems.STONE_STEW);
            addAfter(event, BFItems.STONE_STEW, BFItems.BOUNTIFUL_STEW);
            addAfter(event, BFItems.BOUNTIFUL_STEW, BFItems.COCONUT_CRUSTED_COD);
            addAfter(event, BFItems.COCONUT_CRUSTED_COD, BFItems.PASSION_GLAZED_SALMON);
            addAfter(event, BFItems.PASSION_GLAZED_SALMON, BFItems.CRUSTED_BEEF);
            addAfter(event, BFItems.CRUSTED_BEEF, BFItems.CRIMSON_CHOW);
            addAfter(event, BFItems.CRIMSON_CHOW, BFItems.WARPED_CHOW);
            addAfter(event, BFItems.WARPED_CHOW, BFItems.CUSTARD);
            addAfter(event, BFItems.CUSTARD, BFItems.PIQUANT_CUSTARD);
            addAfter(event, BFItems.PIQUANT_CUSTARD, BFItems.PASSION_CUSTARD);
            addAfter(event, BFItems.PASSION_CUSTARD, BFItems.COCOA_CUSTARD);
            addAfter(event, BFItems.COCOA_CUSTARD, BFItems.ANCIENT_CUSTARD);
        }
        // );

        if (event.getTabKey().equals(CreativeModeTabs.INGREDIENTS))
        // ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(entries ->
        {
            addAfter(event, Items.WHEAT, BFItems.MAIZE);
            addAfter(event, BFItems.MAIZE, BFItems.FLOUR);
            addAfter(event, Items.SLIME_BALL, BFItems.FELDSPAR);
            addAfter(event, BFItems.FELDSPAR, BFItems.CERAMIC_CLAY);
            addAfter(event, BFItems.CERAMIC_CLAY, BFItems.CERAMIC_TILE);
            addAfter(event, Items.BOWL, BFBlocks.CERAMIC_DISH);
            addAfter(event, BFBlocks.CERAMIC_DISH, BFItems.JAR);
            addAfter(event, Items.FIREWORK_STAR, BFItems.COCONUT);
            addAfter(event, BFItems.COCONUT, BFItems.COCONUT_HALF);
            addAfter(event, BFItems.COCONUT_HALF, BFItems.COCONUT_COIR);
            addAfter(event, BFItems.COCONUT_COIR, BFItems.TEA_LEAVES);
            addAfter(event, BFItems.TEA_LEAVES, BFItems.DRIED_TEA_LEAVES);
            addAfter(event, BFItems.DRIED_TEA_LEAVES, BFItems.GREEN_TEA_BLEND);
            addAfter(event, BFItems.GREEN_TEA_BLEND, BFItems.BLACK_TEA_BLEND);
            addAfter(event, BFItems.BLACK_TEA_BLEND, BFItems.CHAMOMILE_TEA_BLEND);
            addAfter(event, BFItems.CHAMOMILE_TEA_BLEND, BFItems.HONEYSUCKLE_TEA_BLEND);
            addAfter(event, BFItems.HONEYSUCKLE_TEA_BLEND, BFItems.BELLFLOWER_TEA_BLEND);
            addAfter(event, BFItems.BELLFLOWER_TEA_BLEND, BFItems.TORCHFLOWER_TEA_BLEND);
        }
        // );

        if (event.getTabKey().equals(CreativeModeTabs.COLORED_BLOCKS))
        // ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COLORED_BLOCKS).register(entries ->
        {
            event.accept(BFBlocks.WHITE_JACK_O_STRAW);
            event.accept(BFBlocks.LIGHT_GRAY_JACK_O_STRAW);
            event.accept(BFBlocks.GRAY_JACK_O_STRAW);
            event.accept(BFBlocks.BLACK_JACK_O_STRAW);
            event.accept(BFBlocks.BROWN_JACK_O_STRAW);
            event.accept(BFBlocks.RED_JACK_O_STRAW);
            event.accept(BFBlocks.ORANGE_JACK_O_STRAW);
            event.accept(BFBlocks.YELLOW_JACK_O_STRAW);
            event.accept(BFBlocks.LIME_JACK_O_STRAW);
            event.accept(BFBlocks.GREEN_JACK_O_STRAW);
            event.accept(BFBlocks.CYAN_JACK_O_STRAW);
            event.accept(BFBlocks.LIGHT_BLUE_JACK_O_STRAW);
            event.accept(BFBlocks.BLUE_JACK_O_STRAW);
            event.accept(BFBlocks.PURPLE_JACK_O_STRAW);
            event.accept(BFBlocks.MAGENTA_JACK_O_STRAW);
            event.accept(BFBlocks.PINK_JACK_O_STRAW);
        }
        // );
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
//           addAfter(event,BFBlocks.BLACK_JACK_O_STRAW, MintBlocks.ACORN_JACK_O_STRAW);
//           addAfter(event,BFBlocks.BROWN_JACK_O_STRAW,MintBlocks.MAROON_JACK_O_STRAW);
//           addAfter(event,BFBlocks.RED_JACK_O_STRAW,MintBlocks.PEACH_JACK_O_STRAW);
//           addAfter(event,MintBlocks.PEACH_JACK_O_STRAW,MintBlocks.VERMILION_JACK_O_STRAW);
//           addAfter(event,BFBlocks.ORANGE_JACK_O_STRAW,MintBlocks.AMBER_JACK_O_STRAW);
//           addAfter(event,BFBlocks.YELLOW_JACK_O_STRAW,MintBlocks.BANANA_JACK_O_STRAW);
//           addAfter(event,MintBlocks.BANANA_JACK_O_STRAW,MintBlocks.ARTICHOKE_JACK_O_STRAW);
//           addAfter(event,MintBlocks.ARTICHOKE_JACK_O_STRAW,MintBlocks.MOLD_JACK_O_STRAW);
//           addAfter(event,BFBlocks.LIME_JACK_O_STRAW,MintBlocks.SAGE_JACK_O_STRAW);
//           addAfter(event,MintBlocks.SAGE_JACK_O_STRAW,MintBlocks.SAP_JACK_O_STRAW);
//           addAfter(event,BFBlocks.GREEN_JACK_O_STRAW,MintBlocks.SHAMROCK_JACK_O_STRAW);
//           addAfter(event,MintBlocks.SHAMROCK_JACK_O_STRAW,MintBlocks.MINT_JACK_O_STRAW);
//           addAfter(event,BFBlocks.CYAN_JACK_O_STRAW,MintBlocks.CERULEAN_JACK_O_STRAW);
//           addAfter(event,BFBlocks.LIGHT_BLUE_JACK_O_STRAW,MintBlocks.NAVY_JACK_O_STRAW);
//           addAfter(event,BFBlocks.BLUE_JACK_O_STRAW,MintBlocks.PERIWINKLE_JACK_O_STRAW);
//           addAfter(event,MintBlocks.PERIWINKLE_JACK_O_STRAW,MintBlocks.GRAPE_JACK_O_STRAW);
//           addAfter(event,BFBlocks.PURPLE_JACK_O_STRAW,MintBlocks.INDIGO_JACK_O_STRAW);
//           addAfter(event,BFBlocks.MAGENTA_JACK_O_STRAW,MintBlocks.MAUVE_JACK_O_STRAW);
//           addAfter(event,MintBlocks.MAUVE_JACK_O_STRAW,MintBlocks.VELVET_JACK_O_STRAW);
//           addAfter(event,MintBlocks.VELVET_JACK_O_STRAW,MintBlocks.FUCHSIA_JACK_O_STRAW);
//        });

//        if (BountifulFares.isModLoaded(BountifulFares.NATURES_SPIRIT_MOD_ID)) {
//            ItemGroupEvents.modifyEntriesEvent(RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "tab"))).register(entries -> {
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "redwood_fence")), NaturesSpiritBlocks.REDWOOD_PICKETS.asItem());
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "redwood_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.REDWOOD));
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "sugi_fence")), NaturesSpiritBlocks.SUGI_PICKETS.asItem());
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "sugi_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.SUGI));
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "wisteria_fence")), NaturesSpiritBlocks.WISTERIA_PICKETS.asItem());
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "wisteria_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.WISTERIA));
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "fir_fence")), NaturesSpiritBlocks.FIR_PICKETS.asItem());
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "fir_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.FIR));
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "willow_fence")), NaturesSpiritBlocks.WILLOW_PICKETS.asItem());
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "willow_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.WILLOW));
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "aspen_fence")), NaturesSpiritBlocks.ASPEN_PICKETS.asItem());
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "aspen_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.ASPEN));
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "maple_fence")), NaturesSpiritBlocks.MAPLE_PICKETS.asItem());
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "maple_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.MAPLE));
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "cypress_fence")), NaturesSpiritBlocks.CYPRESS_PICKETS.asItem());
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "cypress_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.CYPRESS));
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "olive_fence")), NaturesSpiritBlocks.OLIVE_PICKETS.asItem());
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "olive_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.OLIVE));
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "joshua_fence")), NaturesSpiritBlocks.JOSHUA_PICKETS.asItem());
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "joshua_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.JOSHUA));
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "ghaf_fence")), NaturesSpiritBlocks.GHAF_PICKETS.asItem());
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "ghaf_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.GHAF));
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "palo_verde_fence")), NaturesSpiritBlocks.PALO_VERDE_PICKETS.asItem());
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "palo_verde_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.PALO_VERDE));
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "coconut_fence")), NaturesSpiritBlocks.COCONUT_PICKETS.asItem());
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "coconut_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.COCONUT));
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "cedar_fence")), NaturesSpiritBlocks.CEDAR_PICKETS.asItem());
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "cedar_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.CEDAR));
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "larch_fence")), NaturesSpiritBlocks.LARCH_PICKETS.asItem());
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "larch_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.LARCH));
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "mahogany_fence")), NaturesSpiritBlocks.MAHOGANY_PICKETS.asItem());
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "mahogany_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.MAHOGANY));
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "saxaul_fence")), NaturesSpiritBlocks.SAXAUL_PICKETS.asItem());
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "saxaul_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.SAXAUL));
//            });
//        }
////        if (BountifulFares.isModLoaded(BountifulFares.FARMERS_DELIGHT_MOD_ID)) {
////            ItemGroupEvents.modifyEntriesEvent(RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(BountifulFares.FARMERS_DELIGHT_MOD_ID, "farmersdelight"))).register(entries -> {
////               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.FARMERS_DELIGHT_MOD_ID, "bamboo_cabinet")), FarmersDelightBlocks.WALNUT_CABINET.asItem());
////               addAfter(event,FarmersDelightBlocks.WALNUT_CABINET.asItem(), FarmersDelightBlocks.HOARY_CABINET.asItem());
////            });
////        }
//        if (BountifulFares.isModLoaded(BountifulFares.TWIGS_MOD_ID)) {
//            ItemGroupEvents.modifyEntriesEvent(RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(BountifulFares.TWIGS_MOD_ID, "item_group"))).register(entries -> {
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.TWIGS_MOD_ID, "lamp")), TwigsBlocks.FELDSPAR_LAMP.asItem());
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.TWIGS_MOD_ID, "bamboo_table")), TwigsBlocks.WALNUT_TABLE.asItem());
//               addAfter(event,TwigsBlocks.WALNUT_TABLE.asItem(), TwigsBlocks.HOARY_TABLE.asItem());
//            });
//        }
//        if (BountifulFares.isModLoaded(BountifulFares.SPAWN_MOD_ID)) {
//            ItemGroupEvents.modifyEntriesEvent(RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(BountifulFares.SPAWN_MOD_ID, "item_group"))).register(entries -> {
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.SPAWN_MOD_ID, "rotten_fence")), SpawnBlocks.ROTTEN_PICKETS.asItem());
//               addAfter(event,Registries.ITEM.get(Identifier.of(BountifulFares.SPAWN_MOD_ID, "rotten_hanging_sign")), TrellisUtil.getTrellisFromVariant(SpawnBlocks.ROTTEN));
//            });
//        }
    }

    private static void addAfter(BuildCreativeModeTabContentsEvent event, ItemLike before, ItemLike now) {
        event.accept(now);
    }
}
