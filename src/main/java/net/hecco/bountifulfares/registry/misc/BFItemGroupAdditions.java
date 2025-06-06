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

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BFItemGroupAdditions {

    @SubscribeEvent
    public static void registerItemGroupAdditions(BuildCreativeModeTabContentsEvent event) {
//        BountifulFares.LOGGER.info("Adding Items to Vanilla Tabs from " + BountifulFares.MOD_ID);
        if (event.getTabKey().equals(CreativeModeTabs.BUILDING_BLOCKS))
        // ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(entries -> 
        {
            addAfter(event, Items.OAK_FENCE_GATE, BFBlocks.OAK_PICKETS.get());
            addAfter(event, Items.SPRUCE_FENCE_GATE, BFBlocks.SPRUCE_PICKETS.get());
            addAfter(event, Items.BIRCH_FENCE_GATE, BFBlocks.BIRCH_PICKETS.get());
            addAfter(event, Items.JUNGLE_FENCE_GATE, BFBlocks.JUNGLE_PICKETS.get());
            addAfter(event, Items.ACACIA_FENCE_GATE, BFBlocks.ACACIA_PICKETS.get());
            addAfter(event, Items.DARK_OAK_FENCE_GATE, BFBlocks.DARK_OAK_PICKETS.get());
            addAfter(event, Items.MANGROVE_FENCE_GATE, BFBlocks.MANGROVE_PICKETS.get());
            addAfter(event, Items.CHERRY_FENCE_GATE, BFBlocks.CHERRY_PICKETS.get());
            addAfter(event, Items.BAMBOO_FENCE_GATE, BFBlocks.BAMBOO_PICKETS.get());
            addAfter(event, Items.BAMBOO_BUTTON, BFBlocks.WALNUT_LOG.get());
            addAfter(event, BFBlocks.WALNUT_LOG.get(), BFBlocks.WALNUT_WOOD.get());
            addAfter(event, BFBlocks.WALNUT_WOOD.get(), BFBlocks.STRIPPED_WALNUT_LOG.get());
            addAfter(event, BFBlocks.STRIPPED_WALNUT_LOG.get(), BFBlocks.STRIPPED_WALNUT_WOOD.get());
            addAfter(event, BFBlocks.STRIPPED_WALNUT_WOOD.get(), BFBlocks.WALNUT_PLANKS.get());
            addAfter(event, BFBlocks.WALNUT_PLANKS.get(), BFBlocks.WALNUT_STAIRS.get());
            addAfter(event, BFBlocks.WALNUT_STAIRS.get(), BFBlocks.WALNUT_SLAB.get());
            addAfter(event, BFBlocks.WALNUT_SLAB.get(), BFBlocks.WALNUT_FENCE.get());
            addAfter(event, BFBlocks.WALNUT_FENCE.get(), BFBlocks.WALNUT_FENCE_GATE.get());
            addAfter(event, BFBlocks.WALNUT_FENCE_GATE.get(), BFBlocks.WALNUT_PICKETS.get());
            addAfter(event, BFBlocks.WALNUT_PICKETS.get(), BFBlocks.WALNUT_DOOR.get());
            addAfter(event, BFBlocks.WALNUT_DOOR.get(), BFBlocks.WALNUT_TRAPDOOR.get());
            addAfter(event, BFBlocks.WALNUT_TRAPDOOR.get(), BFBlocks.WALNUT_PRESSURE_PLATE.get());
            addAfter(event, BFBlocks.WALNUT_PRESSURE_PLATE.get(), BFBlocks.WALNUT_BUTTON.get());
            addAfter(event, BFBlocks.WALNUT_BUTTON.get(), BFBlocks.HOARY_LOG.get());
            addAfter(event, BFBlocks.HOARY_LOG.get(), BFBlocks.HOARY_WOOD.get());
            addAfter(event, BFBlocks.HOARY_WOOD.get(), BFBlocks.STRIPPED_HOARY_LOG.get());
            addAfter(event, BFBlocks.STRIPPED_HOARY_LOG.get(), BFBlocks.STRIPPED_HOARY_WOOD.get());
            addAfter(event, BFBlocks.STRIPPED_HOARY_WOOD.get(), BFBlocks.HOARY_PLANKS.get());
            addAfter(event, BFBlocks.HOARY_PLANKS.get(), BFBlocks.HOARY_STAIRS.get());
            addAfter(event, BFBlocks.HOARY_STAIRS.get(), BFBlocks.HOARY_SLAB.get());
            addAfter(event, BFBlocks.HOARY_SLAB.get(), BFBlocks.HOARY_FENCE.get());
            addAfter(event, BFBlocks.HOARY_FENCE.get(), BFBlocks.HOARY_FENCE_GATE.get());
            addAfter(event, BFBlocks.HOARY_FENCE_GATE.get(), BFBlocks.HOARY_PICKETS.get());
            addAfter(event, BFBlocks.HOARY_PICKETS.get(), BFBlocks.HOARY_DOOR.get());
            addAfter(event, BFBlocks.HOARY_DOOR.get(), BFBlocks.HOARY_TRAPDOOR.get());
            addAfter(event, BFBlocks.HOARY_TRAPDOOR.get(), BFBlocks.HOARY_PRESSURE_PLATE.get());
            addAfter(event, BFBlocks.HOARY_PRESSURE_PLATE.get(), BFBlocks.HOARY_BUTTON.get());
            addAfter(event, Items.CRIMSON_FENCE_GATE, BFBlocks.CRIMSON_PICKETS.get());
            addAfter(event, Items.WARPED_FENCE_GATE, BFBlocks.WARPED_PICKETS.get());
            addAfter(event, Items.WARPED_BUTTON, BFBlocks.APPLE_LOG.get());
            addAfter(event, BFBlocks.APPLE_LOG.get(), BFBlocks.APPLE_WOOD.get());
            addAfter(event, BFBlocks.APPLE_WOOD.get(), BFBlocks.STRIPPED_APPLE_LOG.get());
            addAfter(event, BFBlocks.STRIPPED_APPLE_LOG.get(), BFBlocks.STRIPPED_APPLE_WOOD.get());
            addAfter(event, BFBlocks.STRIPPED_APPLE_WOOD.get(), BFBlocks.ORANGE_LOG.get());
            addAfter(event, BFBlocks.ORANGE_LOG.get(), BFBlocks.ORANGE_WOOD.get());
            addAfter(event, BFBlocks.ORANGE_WOOD.get(), BFBlocks.STRIPPED_ORANGE_LOG.get());
            addAfter(event, BFBlocks.STRIPPED_ORANGE_LOG.get(), BFBlocks.STRIPPED_ORANGE_WOOD.get());
            addAfter(event, BFBlocks.STRIPPED_ORANGE_WOOD.get(), BFBlocks.LEMON_LOG.get());
            addAfter(event, BFBlocks.LEMON_LOG.get(), BFBlocks.LEMON_WOOD.get());
            addAfter(event, BFBlocks.LEMON_WOOD.get(), BFBlocks.STRIPPED_LEMON_LOG.get());
            addAfter(event, BFBlocks.STRIPPED_LEMON_LOG.get(), BFBlocks.STRIPPED_LEMON_WOOD.get());
            addAfter(event, BFBlocks.STRIPPED_LEMON_WOOD.get(), BFBlocks.PLUM_LOG.get());
            addAfter(event, BFBlocks.PLUM_LOG.get(), BFBlocks.PLUM_WOOD.get());
            addAfter(event, BFBlocks.PLUM_WOOD.get(), BFBlocks.STRIPPED_PLUM_LOG.get());
            addAfter(event, BFBlocks.STRIPPED_PLUM_LOG.get(), BFBlocks.STRIPPED_PLUM_WOOD.get());
            addAfter(event, BFBlocks.STRIPPED_PLUM_WOOD.get(), BFBlocks.PALM_LOG.get());
            addAfter(event, BFBlocks.PALM_LOG.get(), BFBlocks.PALM_WOOD.get());
            addAfter(event, BFBlocks.PALM_WOOD.get(), BFBlocks.STRIPPED_PALM_LOG.get());
            addAfter(event, BFBlocks.STRIPPED_PALM_LOG.get(), BFBlocks.STRIPPED_PALM_WOOD.get());
            addAfter(event, BFBlocks.STRIPPED_PALM_WOOD.get(), BFBlocks.GOLDEN_APPLE_LOG.get());
            addAfter(event, BFBlocks.GOLDEN_APPLE_LOG.get(), BFBlocks.GOLDEN_APPLE_WOOD.get());
//           addAfter(event,BFBlocks.STRIPPED_PLUM_WOOD.get(), TrellisUtil.getTrellisFromVariant(ModTrellises.OAK));
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
            addAfter(event, BFBlocks.STRIPPED_PLUM_WOOD.get(), BFBlocks.WALNUT_MULCH.get());
            addAfter(event, BFBlocks.WALNUT_MULCH.get(), BFBlocks.WALNUT_MULCH_BLOCK.get());
            addAfter(event, BFBlocks.WALNUT_MULCH_BLOCK.get(), BFBlocks.PALM_MULCH.get());
            addAfter(event, BFBlocks.PALM_MULCH.get(), BFBlocks.PALM_MULCH_BLOCK.get());
            addAfter(event, Blocks.MUD_BRICK_WALL, BFBlocks.PACKED_COCONUT_COIR.get());
            addAfter(event, BFBlocks.PACKED_COCONUT_COIR.get(), BFBlocks.COIR_CARPET.get());
            addAfter(event, BFBlocks.COIR_CARPET.get(), BFBlocks.COIR_BRICKS.get());
            addAfter(event, BFBlocks.COIR_BRICKS.get(), BFBlocks.COIR_BRICK_STAIRS.get());
            addAfter(event, BFBlocks.COIR_BRICK_STAIRS.get(), BFBlocks.COIR_BRICK_SLAB.get());
            addAfter(event, BFBlocks.COIR_BRICK_SLAB.get(), BFBlocks.COIR_BRICK_WALL.get());
            addAfter(event, Items.DARK_PRISMARINE_SLAB, BFBlocks.PRISMARINE_BLOSSOM.get());
            addAfter(event, BFBlocks.PRISMARINE_BLOSSOM.get(), BFBlocks.FELDSPAR_BLOCK.get());
            addAfter(event, BFBlocks.FELDSPAR_BLOCK.get(), BFBlocks.CUT_FELDSPAR_BLOCK.get());
            addAfter(event, BFBlocks.CUT_FELDSPAR_BLOCK.get(), BFBlocks.FELDSPAR_BRICKS.get());
            addAfter(event, BFBlocks.FELDSPAR_BRICKS.get(), BFBlocks.FELDSPAR_BRICK_STAIRS.get());
            addAfter(event, BFBlocks.FELDSPAR_BRICK_STAIRS.get(), BFBlocks.FELDSPAR_BRICK_SLAB.get());
            addAfter(event, BFBlocks.FELDSPAR_BRICK_SLAB.get(), BFBlocks.CERAMIC_CLAY_BLOCK.get());
            addAfter(event, BFBlocks.CERAMIC_CLAY_BLOCK.get(), BFBlocks.CERAMIC_TILES.get());
            addAfter(event, BFBlocks.CERAMIC_TILES.get(), BFBlocks.CERAMIC_TILE_STAIRS.get());
            addAfter(event, BFBlocks.CERAMIC_TILE_STAIRS.get(), BFBlocks.CERAMIC_TILE_SLAB.get());
            addAfter(event, BFBlocks.CERAMIC_TILE_SLAB.get(), BFBlocks.CRACKED_CERAMIC_TILES.get());
            addAfter(event, BFBlocks.CRACKED_CERAMIC_TILES.get(), BFBlocks.CERAMIC_TILE_PILLAR.get());
            addAfter(event, BFBlocks.CERAMIC_TILE_PILLAR.get(), BFBlocks.CERAMIC_MOSAIC.get());
            addAfter(event, BFBlocks.CERAMIC_MOSAIC.get(), BFBlocks.CERAMIC_MOSAIC_STAIRS.get());
            addAfter(event, BFBlocks.CERAMIC_MOSAIC_STAIRS.get(), BFBlocks.CERAMIC_MOSAIC_SLAB.get());
            addAfter(event, BFBlocks.CERAMIC_MOSAIC_SLAB.get(), BFBlocks.CERAMIC_DOOR.get());
            addAfter(event, BFBlocks.CERAMIC_DOOR.get(), BFBlocks.CERAMIC_TRAPDOOR.get());
            addAfter(event, BFBlocks.CERAMIC_TRAPDOOR.get(), BFBlocks.CERAMIC_PRESSURE_PLATE.get());
            addAfter(event, BFBlocks.CERAMIC_PRESSURE_PLATE.get(), BFBlocks.CERAMIC_BUTTON.get());
            addAfter(event, Blocks.IRON_BARS, BFBlocks.IRON_RAILING.get());
        }
        // );

        if (event.getTabKey().equals(CreativeModeTabs.NATURAL_BLOCKS))
        // ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register(entries ->
        {
            addAfter(event, Items.GRASS_BLOCK, BFBlocks.GRASSY_DIRT.get());
            addAfter(event, Items.CHERRY_LOG, BFBlocks.APPLE_LOG.get());
            addAfter(event, BFBlocks.APPLE_LOG.get(), BFBlocks.ORANGE_LOG.get());
            addAfter(event, BFBlocks.ORANGE_LOG.get(), BFBlocks.LEMON_LOG.get());
            addAfter(event, BFBlocks.LEMON_LOG.get(), BFBlocks.PLUM_LOG.get());
            addAfter(event, BFBlocks.PLUM_LOG.get(), BFBlocks.PALM_LOG.get());
            addAfter(event, BFBlocks.PALM_LOG.get(), BFBlocks.PALM_CROWN.get());
            addAfter(event, Items.CHERRY_LOG, BFBlocks.WALNUT_LOG.get());
            addAfter(event, BFBlocks.WALNUT_LOG.get(), BFBlocks.HOARY_LOG.get());
            addAfter(event, Items.FLOWERING_AZALEA_LEAVES, BFBlocks.APPLE_LEAVES.get());
            addAfter(event, BFBlocks.APPLE_LEAVES.get(), BFBlocks.FLOWERING_APPLE_LEAVES.get());
            addAfter(event, BFBlocks.FLOWERING_APPLE_LEAVES.get(), BFBlocks.ORANGE_LEAVES.get());
            addAfter(event, BFBlocks.ORANGE_LEAVES.get(), BFBlocks.FLOWERING_ORANGE_LEAVES.get());
            addAfter(event, BFBlocks.FLOWERING_ORANGE_LEAVES.get(), BFBlocks.LEMON_LEAVES.get());
            addAfter(event, BFBlocks.LEMON_LEAVES.get(), BFBlocks.FLOWERING_LEMON_LEAVES.get());
            addAfter(event, BFBlocks.FLOWERING_LEMON_LEAVES.get(), BFBlocks.PLUM_LEAVES.get());
            addAfter(event, BFBlocks.PLUM_LEAVES.get(), BFBlocks.FLOWERING_PLUM_LEAVES.get());
            addAfter(event, BFBlocks.FLOWERING_PLUM_LEAVES.get(), BFBlocks.GOLDEN_APPLE_LEAVES.get());
            addAfter(event, BFBlocks.GOLDEN_APPLE_LEAVES.get(), BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES.get());
            addAfter(event, BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES.get(), BFBlocks.WALNUT_LEAVES.get());
            addAfter(event, BFBlocks.WALNUT_LEAVES.get(), BFBlocks.HOARY_LEAVES.get());
            addAfter(event, BFBlocks.HOARY_LEAVES.get(), BFItems.PALM_FROND.get());
            addAfter(event, Items.CHERRY_SAPLING, BFBlocks.APPLE_SAPLING.get());
            addAfter(event, BFBlocks.APPLE_SAPLING.get(), BFBlocks.ORANGE_SAPLING.get());
            addAfter(event, BFBlocks.ORANGE_SAPLING.get(), BFBlocks.LEMON_SAPLING.get());
            addAfter(event, BFBlocks.LEMON_SAPLING.get(), BFBlocks.PLUM_SAPLING.get());
            addAfter(event, BFBlocks.PLUM_SAPLING.get(), BFBlocks.HOARY_APPLE_SAPLING.get());
            addAfter(event, BFBlocks.HOARY_APPLE_SAPLING.get(), BFBlocks.WALNUT_SAPLING.get());
            addAfter(event, Blocks.FLOWERING_AZALEA, BFItems.COCONUT.get());
            addAfter(event, Items.SNIFFER_EGG, BFBlocks.WILD_WHEAT.get());
            addAfter(event, BFBlocks.WILD_WHEAT.get(), BFBlocks.WILD_CARROTS.get());
            addAfter(event, BFBlocks.WILD_CARROTS.get(), BFBlocks.WILD_POTATOES.get());
            addAfter(event, BFBlocks.WILD_POTATOES.get(), BFBlocks.WILD_BEETROOTS.get());
            addAfter(event, BFBlocks.WILD_BEETROOTS.get(), BFBlocks.WILD_LEEKS.get());
            addAfter(event, BFBlocks.WILD_LEEKS.get(), BFBlocks.WILD_MAIZE.get());
            addAfter(event, BFBlocks.WILD_MAIZE.get(), BFBlocks.WILD_PASSION_FRUIT_VINE.get());
            addAfter(event, BFBlocks.WILD_PASSION_FRUIT_VINE.get(), BFBlocks.WILD_ELDERBERRY_VINE.get());
            addAfter(event, BFBlocks.WILD_ELDERBERRY_VINE.get(), BFItems.GRASS_SEEDS.get());
            addAfter(event, BFItems.GRASS_SEEDS.get(), BFItems.SWEET_BERRY_PIPS.get());
            addAfter(event, Items.KELP, BFBlocks.SPONGEKIN.get());
            addAfter(event, BFBlocks.SPONGEKIN.get(), BFBlocks.PRISMARINE_BLOSSOM.get());
            addAfter(event, Items.LILY_OF_THE_VALLEY, BFBlocks.CHAMOMILE_FLOWERS.get());
            addAfter(event, BFBlocks.CHAMOMILE_FLOWERS.get(), BFBlocks.HONEYSUCKLE.get());
            addAfter(event, BFBlocks.HONEYSUCKLE.get(), BFBlocks.VIOLET_BELLFLOWER.get());
            addAfter(event, Items.BEETROOT_SEEDS, BFItems.MAIZE_SEEDS.get());
            addAfter(event, BFItems.MAIZE_SEEDS.get(), BFItems.LEEK_SEEDS.get());
            addAfter(event, BFItems.LEEK_SEEDS.get(), BFItems.TEA_BERRIES.get());
            addAfter(event, BFItems.TEA_BERRIES.get(), BFItems.SPONGEKIN_SEEDS.get());
            addAfter(event, Items.PITCHER_POD, BFItems.LAPISBERRY_SEEDS.get());
            addAfter(event, BFItems.LAPISBERRY_SEEDS.get(), BFItems.HOARY_SEEDS.get());
        }
        // );

        if (event.getTabKey().equals(CreativeModeTabs.FUNCTIONAL_BLOCKS))

        // ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(entries ->
        {
            addAfter(event, Items.LANTERN, BFBlocks.FELDSPAR_LANTERN.get());
            addAfter(event, Items.GRINDSTONE, BFBlocks.GRISTMILL.get());
            addAfter(event, Items.SOUL_CAMPFIRE, BFBlocks.GREEN_TEA_CANDLE.get());
            addAfter(event, BFBlocks.GREEN_TEA_CANDLE.get(), BFBlocks.BLACK_TEA_CANDLE.get());
            addAfter(event, BFBlocks.BLACK_TEA_CANDLE.get(), BFBlocks.CHAMOMILE_CANDLE.get());
            addAfter(event, BFBlocks.CHAMOMILE_CANDLE.get(), BFBlocks.HONEYSUCKLE_CANDLE.get());
            addAfter(event, BFBlocks.HONEYSUCKLE_CANDLE.get(), BFBlocks.BELLFLOWER_CANDLE.get());
            addAfter(event, BFBlocks.BELLFLOWER_CANDLE.get(), BFBlocks.TORCHFLOWER_CANDLE.get());
            addAfter(event, BFBlocks.TORCHFLOWER_CANDLE.get(), BFBlocks.WALNUT_CANDLE.get());
            addAfter(event, BFBlocks.WALNUT_CANDLE.get(), BFBlocks.FERMENTATION_VESSEL.get());
            addAfter(event, BFBlocks.FERMENTATION_VESSEL.get(), BFBlocks.COCONUT_CANDLE.get());
            addAfter(event, BFBlocks.COCONUT_CANDLE.get(), BFBlocks.GOLDEN_APPLE_SAPLING.get());
            addAfter(event, Blocks.COMPOSTER, TrellisUtil.getTrellisFromVariant(BFTrellises.OAK).get());
            TrellisVariant prevTrellis = BFTrellises.OAK;
            for (TrellisVariant trellis : TrellisUtil.TrellisVariants) {
                if (Objects.equals(trellis.getModId(), BountifulFares.MOD_ID)) {
                    if (trellis == BFTrellises.OAK) {
                        continue;
                    }
                    if (TrellisUtil.getTrellisFromVariant(trellis) != null) {
                        addAfter(event, TrellisUtil.getTrellisFromVariant(prevTrellis).get(), TrellisUtil.getTrellisFromVariant(trellis).get());
                        prevTrellis = trellis;
                    }
                }
            }
//            if (BountifulFares.isModLoaded(BountifulFares.ELS_AND_LS_DYES_MOD_ID)) {
//               addAfter(event,TrellisUtil.getTrellisFromVariant(prevTrellis), TrellisUtil.getTrellisFromVariant(BFTrellises.WINTERGREEN));
//                prevTrellis = BFTrellises.WINTERGREEN;
//            }
            if (BountifulFares.isModLoaded(BountifulFares.NATURES_SPIRIT_MOD_ID)) {
                addAfter(event, TrellisUtil.getTrellisFromVariant(prevTrellis).get(), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.REDWOOD).get());
                addAfter(event, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.REDWOOD).get(), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.SUGI).get());
                addAfter(event, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.SUGI).get(), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.WISTERIA).get());
                addAfter(event, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.WISTERIA).get(), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.FIR).get());
                addAfter(event, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.FIR).get(), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.WILLOW).get());
                addAfter(event, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.WILLOW).get(), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.ASPEN).get());
                addAfter(event, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.ASPEN).get(), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.MAPLE).get());
                addAfter(event, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.MAPLE).get(), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.CYPRESS).get());
                addAfter(event, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.CYPRESS).get(), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.OLIVE).get());
                addAfter(event, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.OLIVE).get(), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.JOSHUA).get());
                addAfter(event, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.JOSHUA).get(), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.GHAF).get());
                addAfter(event, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.GHAF).get(), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.PALO_VERDE).get());
                addAfter(event, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.PALO_VERDE).get(), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.COCONUT).get());
                addAfter(event, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.COCONUT).get(), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.CEDAR).get());
                addAfter(event, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.CEDAR).get(), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.LARCH).get());
                addAfter(event, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.LARCH).get(), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.MAHOGANY).get());
                addAfter(event, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.MAHOGANY).get(), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.SAXAUL).get());
                prevTrellis = NaturesSpiritBlocks.SAXAUL;
            }
            if (BountifulFares.isModLoaded(BountifulFares.EXCESSIVE_BUILDING_MOD_ID)) {
                addAfter(event, TrellisUtil.getTrellisFromVariant(prevTrellis).get(), TrellisUtil.getTrellisFromVariant(ExcessiveBuildingBlocks.ANCIENT).get());
                prevTrellis = ExcessiveBuildingBlocks.ANCIENT;
            }
            if (BountifulFares.isModLoaded(BountifulFares.SPAWN_MOD_ID)) {
                addAfter(event, TrellisUtil.getTrellisFromVariant(prevTrellis).get(), TrellisUtil.getTrellisFromVariant(SpawnBlocks.ROTTEN).get());
                prevTrellis = SpawnBlocks.ROTTEN;
            }
            addAfter(event, Items.TINTED_GLASS, BFBlocks.TINGED_GLASS.get());
            addAfter(event, Items.BAMBOO_HANGING_SIGN, BFItems.WALNUT_SIGN.get());
            addAfter(event, BFItems.WALNUT_SIGN.get(), BFItems.WALNUT_HANGING_SIGN.get());
            addAfter(event, BFItems.WALNUT_HANGING_SIGN.get(), BFItems.HOARY_SIGN.get());
            addAfter(event, BFItems.HOARY_SIGN.get(), BFItems.HOARY_HANGING_SIGN.get());
        }
        // );

        if (event.getTabKey().equals(CreativeModeTabs.REDSTONE_BLOCKS))
        // ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.REDSTONE_BLOCKS).register(rEntries ->
        {
            addAfter(event, Items.LEVER, BFBlocks.CERAMIC_LEVER.get());
            addAfter(event, Items.STONE_BUTTON, BFBlocks.CERAMIC_BUTTON.get());
            addAfter(event, Items.HEAVY_WEIGHTED_PRESSURE_PLATE, BFBlocks.CERAMIC_PRESSURE_PLATE.get());
            addAfter(event, Items.WHITE_WOOL, BFBlocks.CERAMIC_TILES.get());
        }
        // );

        if (event.getTabKey().equals(CreativeModeTabs.TOOLS_AND_UTILITIES))
        // ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries ->
        {
            addAfter(event, Items.LEAD, BFItems.SUN_HAT.get());
            addAfter(event, Items.BRUSH, BFItems.ARTISAN_BRUSH.get());
            // addAfter(event, Items.BAMBOO_CHEST_RAFT, BFItems.WALNUT_BOAT.get());
            // addAfter(event, BFItems.WALNUT_BOAT.get(), BFItems.WALNUT_CHEST_BOAT.get());
            // addAfter(event, BFItems.WALNUT_CHEST_BOAT.get(), BFItems.HOARY_BOAT.get());
            // addAfter(event, BFItems.HOARY_BOAT.get(), BFItems.HOARY_CHEST_BOAT.get());
        }
        // );

        if (event.getTabKey().equals(CreativeModeTabs.COMBAT))
        // ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(entries ->
        {
            addAfter(event, Items.EGG, BFItems.FLOUR.get());
        }
        // );
        if (event.getTabKey().equals(CreativeModeTabs.FOOD_AND_DRINKS))
        // ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(entries ->
        {
            addAfter(event, Items.APPLE, BFItems.APPLE_COMPOTE_JAR.get());
            addAfter(event, BFItems.APPLE_COMPOTE_JAR.get(), BFItems.APPLE_CIDER_JAR.get());
            addAfter(event, BFItems.APPLE_CIDER_JAR.get(), BFBlocks.APPLE_BLOCK.get());
            addAfter(event, BFBlocks.APPLE_BLOCK.get(), BFItems.ORANGE.get());
            addAfter(event, BFItems.ORANGE.get(), BFItems.ORANGE_COMPOTE_JAR.get());
            addAfter(event, BFItems.ORANGE_COMPOTE_JAR.get(), BFBlocks.ORANGE_BLOCK.get());
            addAfter(event, BFBlocks.ORANGE_BLOCK.get(), BFItems.LEMON.get());
            addAfter(event, BFItems.LEMON.get(), BFItems.LEMON_COMPOTE_JAR.get());
            addAfter(event, BFItems.LEMON_COMPOTE_JAR.get(), BFBlocks.LEMON_BLOCK.get());
            addAfter(event, BFBlocks.LEMON_BLOCK.get(), BFItems.PLUM.get());
            addAfter(event, BFItems.PLUM.get(), BFItems.PLUM_COMPOTE_JAR.get());
            addAfter(event, BFItems.PLUM_COMPOTE_JAR.get(), BFItems.PLUM_CIDER_JAR.get());
            addAfter(event, BFItems.PLUM_CIDER_JAR.get(), BFBlocks.PLUM_BLOCK.get());
            addAfter(event, BFBlocks.PLUM_BLOCK.get(), BFItems.HOARY_APPLE.get());
            addAfter(event, BFItems.HOARY_APPLE.get(), BFItems.STUFFED_HOARY_APPLE.get());
            addAfter(event, BFItems.STUFFED_HOARY_APPLE.get(), BFItems.HOARY_COMPOTE_JAR.get());
            addAfter(event, BFItems.HOARY_COMPOTE_JAR.get(), BFItems.HOARY_CIDER_JAR.get());
            addAfter(event, BFItems.HOARY_CIDER_JAR.get(), BFBlocks.HOARY_APPLE_BLOCK.get());
            addAfter(event, BFBlocks.HOARY_APPLE_BLOCK.get(), BFItems.COCONUT_HALF.get());
            addAfter(event, Items.ENCHANTED_GOLDEN_APPLE, BFBlocks.GOLDEN_APPLE_BLOCK.get());
            addAfter(event, Items.MELON_SLICE, BFItems.SPONGEKIN_SLICE.get());
            addAfter(event, BFItems.SPONGEKIN_SLICE.get(), BFItems.PICKLED_SPONGEKIN.get());
            addAfter(event, Items.SWEET_BERRIES, BFItems.PASSION_FRUIT.get());
            addAfter(event, BFItems.PASSION_FRUIT.get(), BFItems.ELDERBERRIES.get());
            addAfter(event, BFItems.ELDERBERRIES.get(), BFItems.ELDERBERRY_WINE_BOTTLE.get());
            addAfter(event, Items.GLOW_BERRIES, BFItems.LAPISBERRIES.get());
            addAfter(event, BFItems.LAPISBERRIES.get(), BFItems.LAPISBERRY_WINE_BOTTLE.get());
            addAfter(event, Items.MILK_BUCKET, BFItems.COCONUT_MILK_BOTTLE.get());
            addAfter(event, BFItems.COCONUT_MILK_BOTTLE.get(), BFItems.GREEN_TEA_BOTTLE.get());
            addAfter(event, BFItems.GREEN_TEA_BOTTLE.get(), BFItems.BLACK_TEA_BOTTLE.get());
            addAfter(event, BFItems.BLACK_TEA_BOTTLE.get(), BFItems.CHAMOMILE_TEA_BOTTLE.get());
            addAfter(event, BFItems.CHAMOMILE_TEA_BOTTLE.get(), BFItems.HONEYSUCKLE_TEA_BOTTLE.get());
            addAfter(event, BFItems.HONEYSUCKLE_TEA_BOTTLE.get(), BFItems.BELLFLOWER_TEA_BOTTLE.get());
            addAfter(event, BFItems.BELLFLOWER_TEA_BOTTLE.get(), BFItems.TORCHFLOWER_TEA_BOTTLE.get());
            addAfter(event, Items.HONEY_BOTTLE, BFItems.MEAD_BOTTLE.get());
            addAfter(event, Items.BAKED_POTATO, BFItems.MUSHROOM_STUFFED_POTATO.get());
            addAfter(event, BFItems.MUSHROOM_STUFFED_POTATO.get(), BFItems.BERRY_STUFFED_POTATO.get());
            addAfter(event, BFItems.BERRY_STUFFED_POTATO.get(), BFItems.MAIZE_STUFFED_POTATO.get());
            addAfter(event, Items.BEETROOT, BFItems.MAIZE.get());
            addAfter(event, BFItems.MAIZE.get(), BFItems.LEEK.get());
            addAfter(event, BFItems.LEEK.get(), BFItems.WALNUT.get());
            addAfter(event, BFItems.WALNUT.get(), BFItems.POPPED_MAIZE.get());
            addAfter(event, Items.BREAD, BFItems.MAIZE_BREAD.get());
            addAfter(event, BFItems.MAIZE_BREAD.get(), BFBlocks.ARTISAN_BREAD.get());
            addAfter(event, Items.COOKIE, BFItems.WALNUT_COOKIE.get());
            addAfter(event, BFItems.WALNUT_COOKIE.get(), BFItems.ARTISAN_COOKIE.get());
            addAfter(event, BFItems.ARTISAN_COOKIE.get(), BFBlocks.PASSION_FRUIT_TART.get());
            addAfter(event, BFBlocks.PASSION_FRUIT_TART.get(), BFBlocks.ELDERBERRY_TART.get());
            addAfter(event, BFBlocks.ELDERBERRY_TART.get(), BFBlocks.GLOW_BERRY_TART.get());
            addAfter(event, BFBlocks.GLOW_BERRY_TART.get(), BFBlocks.SWEET_BERRY_TART.get());
            addAfter(event, BFBlocks.SWEET_BERRY_TART.get(), BFBlocks.LAPISBERRY_TART.get());
            addAfter(event, Items.CAKE, BFBlocks.COCOA_CAKE.get());
            addAfter(event, BFBlocks.COCOA_CAKE.get(), BFBlocks.COCONUT_CAKE.get());
            addAfter(event, Items.PUMPKIN_PIE, BFBlocks.MELON_PIE.get());
            addAfter(event, BFBlocks.MELON_PIE.get(), BFBlocks.APPLE_PIE.get());
            addAfter(event, BFBlocks.APPLE_PIE.get(), BFBlocks.ORANGE_PIE.get());
            addAfter(event, BFBlocks.ORANGE_PIE.get(), BFBlocks.LEMON_PIE.get());
            addAfter(event, BFBlocks.LEMON_PIE.get(), BFBlocks.PLUM_PIE.get());
            addAfter(event, BFBlocks.PLUM_PIE.get(), BFBlocks.HOARY_PIE.get());
            addAfter(event, Items.SPIDER_EYE, BFItems.CITRUS_ESSENCE.get());
            addAfter(event, BFItems.CITRUS_ESSENCE.get(), BFItems.CANDY.get());
            addAfter(event, BFItems.CANDY.get(), BFItems.PIQUANT_CANDY.get());
            addAfter(event, BFItems.PIQUANT_CANDY.get(), BFItems.SOUR_CANDY.get());
            addAfter(event, BFItems.SOUR_CANDY.get(), BFItems.BITTER_CANDY.get());
            addAfter(event, BFItems.BITTER_CANDY.get(), BFItems.STRANGE_CANDY.get());
            addAfter(event, BFItems.STRANGE_CANDY.get(), BFItems.CANDIED_APPLE.get());
            addAfter(event, BFItems.CANDIED_APPLE.get(), BFItems.CANDIED_PLUM.get());
            addAfter(event, BFItems.CANDIED_PLUM.get(), BFItems.CANDIED_ORANGE.get());
            addAfter(event, BFItems.CANDIED_ORANGE.get(), BFItems.CANDIED_LEMON.get());
            addAfter(event, BFItems.CANDIED_LEMON.get(), BFItems.FOREST_MEDLEY.get());
            addAfter(event, BFItems.FOREST_MEDLEY.get(), BFItems.ARID_MEDLEY.get());
            addAfter(event, BFItems.ARID_MEDLEY.get(), BFItems.MEADOW_MEDLEY.get());
            addAfter(event, BFItems.MEADOW_MEDLEY.get(), BFItems.MIRE_MEDLEY.get());
            addAfter(event, BFItems.MIRE_MEDLEY.get(), BFItems.COASTAL_MEDLEY.get());
            addAfter(event, BFItems.COASTAL_MEDLEY.get(), BFItems.TROPICAL_MEDLEY.get());
            addAfter(event, BFItems.TROPICAL_MEDLEY.get(), BFItems.SEA_SALAD.get());
            addAfter(event, Items.RABBIT_STEW, BFItems.LEEK_STEW.get());
            addAfter(event, BFItems.LEEK_STEW.get(), BFItems.FISH_STEW.get());
            addAfter(event, BFItems.FISH_STEW.get(), BFItems.APPLE_STEW.get());
            addAfter(event, BFItems.APPLE_STEW.get(), BFItems.COCONUT_STEW.get());
            addAfter(event, BFItems.COCONUT_STEW.get(), BFItems.STONE_STEW.get());
            addAfter(event, BFItems.STONE_STEW.get(), BFItems.BOUNTIFUL_STEW.get());
            addAfter(event, BFItems.BOUNTIFUL_STEW.get(), BFItems.COCONUT_CRUSTED_COD.get());
            addAfter(event, BFItems.COCONUT_CRUSTED_COD.get(), BFItems.PASSION_GLAZED_SALMON.get());
            addAfter(event, BFItems.PASSION_GLAZED_SALMON.get(), BFItems.CRUSTED_BEEF.get());
            addAfter(event, BFItems.CRUSTED_BEEF.get(), BFItems.CRIMSON_CHOW.get());
            addAfter(event, BFItems.CRIMSON_CHOW.get(), BFItems.WARPED_CHOW.get());
            addAfter(event, BFItems.WARPED_CHOW.get(), BFItems.CUSTARD.get());
            addAfter(event, BFItems.CUSTARD.get(), BFItems.PIQUANT_CUSTARD.get());
            addAfter(event, BFItems.PIQUANT_CUSTARD.get(), BFItems.PASSION_CUSTARD.get());
            addAfter(event, BFItems.PASSION_CUSTARD.get(), BFItems.COCOA_CUSTARD.get());
            addAfter(event, BFItems.COCOA_CUSTARD.get(), BFItems.ANCIENT_CUSTARD.get());
        }
        // );

        if (event.getTabKey().equals(CreativeModeTabs.INGREDIENTS))
        // ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(entries ->
        {
            addAfter(event, Items.WHEAT, BFItems.MAIZE.get());
            addAfter(event, BFItems.MAIZE.get(), BFItems.FLOUR.get());
            addAfter(event, Items.SLIME_BALL, BFItems.FELDSPAR.get());
            addAfter(event, BFItems.FELDSPAR.get(), BFItems.CERAMIC_CLAY.get());
            addAfter(event, BFItems.CERAMIC_CLAY.get(), BFItems.CERAMIC_TILE.get());
            addAfter(event, Items.BOWL, BFBlocks.CERAMIC_DISH.get());
            addAfter(event, BFBlocks.CERAMIC_DISH.get(), BFItems.JAR.get());
            addAfter(event, Items.FIREWORK_STAR, BFItems.COCONUT.get());
            addAfter(event, BFItems.COCONUT.get(), BFItems.COCONUT_HALF.get());
            addAfter(event, BFItems.COCONUT_HALF.get(), BFItems.COCONUT_COIR.get());
            addAfter(event, BFItems.COCONUT_COIR.get(), BFItems.TEA_LEAVES.get());
            addAfter(event, BFItems.TEA_LEAVES.get(), BFItems.DRIED_TEA_LEAVES.get());
            addAfter(event, BFItems.DRIED_TEA_LEAVES.get(), BFItems.GREEN_TEA_BLEND.get());
            addAfter(event, BFItems.GREEN_TEA_BLEND.get(), BFItems.BLACK_TEA_BLEND.get());
            addAfter(event, BFItems.BLACK_TEA_BLEND.get(), BFItems.CHAMOMILE_TEA_BLEND.get());
            addAfter(event, BFItems.CHAMOMILE_TEA_BLEND.get(), BFItems.HONEYSUCKLE_TEA_BLEND.get());
            addAfter(event, BFItems.HONEYSUCKLE_TEA_BLEND.get(), BFItems.BELLFLOWER_TEA_BLEND.get());
            addAfter(event, BFItems.BELLFLOWER_TEA_BLEND.get(), BFItems.TORCHFLOWER_TEA_BLEND.get());
        }
        // );

        if (event.getTabKey().equals(CreativeModeTabs.COLORED_BLOCKS))
        // ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COLORED_BLOCKS).register(entries ->
        {
            event.accept(BFBlocks.WHITE_JACK_O_STRAW.get());
            event.accept(BFBlocks.LIGHT_GRAY_JACK_O_STRAW.get());
            event.accept(BFBlocks.GRAY_JACK_O_STRAW.get());
            event.accept(BFBlocks.BLACK_JACK_O_STRAW.get());
            event.accept(BFBlocks.BROWN_JACK_O_STRAW.get());
            event.accept(BFBlocks.RED_JACK_O_STRAW.get());
            event.accept(BFBlocks.ORANGE_JACK_O_STRAW.get());
            event.accept(BFBlocks.YELLOW_JACK_O_STRAW.get());
            event.accept(BFBlocks.LIME_JACK_O_STRAW.get());
            event.accept(BFBlocks.GREEN_JACK_O_STRAW.get());
            event.accept(BFBlocks.CYAN_JACK_O_STRAW.get());
            event.accept(BFBlocks.LIGHT_BLUE_JACK_O_STRAW.get());
            event.accept(BFBlocks.BLUE_JACK_O_STRAW.get());
            event.accept(BFBlocks.PURPLE_JACK_O_STRAW.get());
            event.accept(BFBlocks.MAGENTA_JACK_O_STRAW.get());
            event.accept(BFBlocks.PINK_JACK_O_STRAW.get());
        }
        // );
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
//           addAfter(event,BFBlocks.BLACK_JACK_O_STRAW.get(), MintBlocks.ACORN_JACK_O_STRAW);
//           addAfter(event,BFBlocks.BROWN_JACK_O_STRAW.get(),MintBlocks.MAROON_JACK_O_STRAW);
//           addAfter(event,BFBlocks.RED_JACK_O_STRAW.get(),MintBlocks.PEACH_JACK_O_STRAW);
//           addAfter(event,MintBlocks.PEACH_JACK_O_STRAW,MintBlocks.VERMILION_JACK_O_STRAW);
//           addAfter(event,BFBlocks.ORANGE_JACK_O_STRAW.get(),MintBlocks.AMBER_JACK_O_STRAW);
//           addAfter(event,BFBlocks.YELLOW_JACK_O_STRAW.get(),MintBlocks.BANANA_JACK_O_STRAW);
//           addAfter(event,MintBlocks.BANANA_JACK_O_STRAW,MintBlocks.ARTICHOKE_JACK_O_STRAW);
//           addAfter(event,MintBlocks.ARTICHOKE_JACK_O_STRAW,MintBlocks.MOLD_JACK_O_STRAW);
//           addAfter(event,BFBlocks.LIME_JACK_O_STRAW.get(),MintBlocks.SAGE_JACK_O_STRAW);
//           addAfter(event,MintBlocks.SAGE_JACK_O_STRAW,MintBlocks.SAP_JACK_O_STRAW);
//           addAfter(event,BFBlocks.GREEN_JACK_O_STRAW.get(),MintBlocks.SHAMROCK_JACK_O_STRAW);
//           addAfter(event,MintBlocks.SHAMROCK_JACK_O_STRAW,MintBlocks.MINT_JACK_O_STRAW);
//           addAfter(event,BFBlocks.CYAN_JACK_O_STRAW.get(),MintBlocks.CERULEAN_JACK_O_STRAW);
//           addAfter(event,BFBlocks.LIGHT_BLUE_JACK_O_STRAW.get(),MintBlocks.NAVY_JACK_O_STRAW);
//           addAfter(event,BFBlocks.BLUE_JACK_O_STRAW.get(),MintBlocks.PERIWINKLE_JACK_O_STRAW);
//           addAfter(event,MintBlocks.PERIWINKLE_JACK_O_STRAW,MintBlocks.GRAPE_JACK_O_STRAW);
//           addAfter(event,BFBlocks.PURPLE_JACK_O_STRAW.get(),MintBlocks.INDIGO_JACK_O_STRAW);
//           addAfter(event,BFBlocks.MAGENTA_JACK_O_STRAW.get(),MintBlocks.MAUVE_JACK_O_STRAW);
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
