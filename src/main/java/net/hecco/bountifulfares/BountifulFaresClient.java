package net.hecco.bountifulfares;

import com.xueluoanping.bountifulfaresforge.api.client.FastColorAttach;
import net.hecco.bountifulfares.block.entity.DyeableBlockEntity;
import net.hecco.bountifulfares.block.entity.renderer.CeramicDishBlockEntityRenderer;
import net.hecco.bountifulfares.compat.appledog.AppledogBlocks;
import net.hecco.bountifulfares.compat.arts_and_crafts.ArtsAndCraftsBlocks;
import net.hecco.bountifulfares.compat.delicate_dyes.DelicateDyesBlocks;
import net.hecco.bountifulfares.compat.dungeons_delight.DungeonsDelightBlocks;
import net.hecco.bountifulfares.compat.dye_depot.DyeDepotBlocks;
import net.hecco.bountifulfares.compat.excessive_building.ExcessiveBuildingBlocks;
import net.hecco.bountifulfares.compat.mint.MintBlocks;
import net.hecco.bountifulfares.compat.natures_spirit.NaturesSpiritBlocks;
import net.hecco.bountifulfares.compat.spawn.SpawnBlocks;
import net.hecco.bountifulfares.item.custom.ArtisanBrushItem;
import net.hecco.bountifulfares.networking.BFMessages;
import net.hecco.bountifulfares.particle.FermentedBubbleParticle;
import net.hecco.bountifulfares.particle.FlourCloudParticle;
import net.hecco.bountifulfares.particle.GoldenPetalParticle;
import net.hecco.bountifulfares.particle.PrismarineBlossomParticle;
import net.hecco.bountifulfares.registry.content.*;
import net.hecco.bountifulfares.registry.misc.BFScreenHandlers;
import net.hecco.bountifulfares.registry.util.BFWoodTypes;
import net.hecco.bountifulfares.screen.GristmillScreen;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.item.ItemProperties;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

// import static net.hecco.bountifulfares.registry.content.BFItems.ARTISAN_BRUSH;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BountifulFaresClient {

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(BFBlockEntities.CERAMIC_DISH_BLOCK_ENTITY.get(), CeramicDishBlockEntityRenderer::new);

        event.registerEntityRenderer(BFEntities.THROWN_FLOUR_PROJECTILE.get(), ThrownItemRenderer::new);
    }


    @SubscribeEvent
    public static void onInitializeClient(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            BFMessages.registerS2CPackets();
            // ItemTooltipCallback.EVENT.register(BFTooltipEvents::addTooltipsToVanillaItems);
            // BlockEntityRenderers.register(BFBlockEntities.CERAMIC_DISH_BLOCK_ENTITY, CeramicDishBlockEntityRenderer::new);
//        ElsAndLsDyes compat
            setRenderLayer(MintBlocks.ACORN_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(MintBlocks.ARTICHOKE_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(MintBlocks.AMBER_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(MintBlocks.BANANA_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(MintBlocks.CERULEAN_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(MintBlocks.FUCHSIA_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(MintBlocks.GRAPE_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(MintBlocks.INDIGO_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(MintBlocks.MAROON_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(MintBlocks.MAUVE_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(MintBlocks.MOLD_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(MintBlocks.MINT_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(MintBlocks.NAVY_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(MintBlocks.PEACH_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(MintBlocks.PERIWINKLE_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(MintBlocks.SAGE_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(MintBlocks.SAP_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(MintBlocks.SHAMROCK_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(MintBlocks.VELVET_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(MintBlocks.VERMILION_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(MintBlocks.WINTERGREEN_PICKETS.get(), RenderType.cutout());

//        DyeDepot compat
            setRenderLayer(DyeDepotBlocks.MAROON_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(DyeDepotBlocks.ROSE_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(DyeDepotBlocks.CORAL_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(DyeDepotBlocks.GINGER_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(DyeDepotBlocks.TAN_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(DyeDepotBlocks.BEIGE_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(DyeDepotBlocks.AMBER_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(DyeDepotBlocks.OLIVE_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(DyeDepotBlocks.FOREST_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(DyeDepotBlocks.VERDANT_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(DyeDepotBlocks.TEAL_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(DyeDepotBlocks.MINT_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(DyeDepotBlocks.AQUA_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(DyeDepotBlocks.SLATE_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(DyeDepotBlocks.NAVY_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(DyeDepotBlocks.INDIGO_JACK_O_STRAW.get(), RenderType.cutout());
//        ExcessiveBuilding compat
            setRenderLayer(ExcessiveBuildingBlocks.ANCIENT_PICKETS.get(), RenderType.cutout());
            setRenderLayer(ExcessiveBuildingBlocks.WALNUT_LADDER.get(), RenderType.cutout());
            setRenderLayer(ExcessiveBuildingBlocks.HOARY_LADDER.get(), RenderType.cutout());
            setRenderLayer(ExcessiveBuildingBlocks.CHECKERED_CERAMIC_TILE_VERTICAL_STAIRS.get(), RenderType.cutout());
            setRenderLayer(ExcessiveBuildingBlocks.CHECKERED_CERAMIC_MOSAIC_VERTICAL_STAIRS.get(), RenderType.cutout());

//        NaturesSpirit compat
            setRenderLayer(NaturesSpiritBlocks.ASPEN_PICKETS.get(), RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.CEDAR_PICKETS.get(), RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.COCONUT_PICKETS.get(), RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.CYPRESS_PICKETS.get(), RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.FIR_PICKETS.get(), RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.JOSHUA_PICKETS.get(), RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.GHAF_PICKETS.get(), RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.LARCH_PICKETS.get(), RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.MAHOGANY_PICKETS.get(), RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.MAPLE_PICKETS.get(), RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.MAHOGANY_PICKETS.get(), RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.OLIVE_PICKETS.get(), RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.PALO_VERDE_PICKETS.get(), RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.REDWOOD_PICKETS.get(), RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.SAXAUL_PICKETS.get(), RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.SUGI_PICKETS.get(), RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.WILLOW_PICKETS.get(), RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.WISTERIA_PICKETS.get(), RenderType.cutout());

            //        Spawn compat
            setRenderLayer(SpawnBlocks.ROTTEN_PICKETS.get(), RenderType.cutout());
            //        ArtsAndCrafts compat
            setRenderLayer(ArtsAndCraftsBlocks.CORK_PICKETS.get(), RenderType.cutout());

            //        DelicateDyes compat
            setRenderLayer(DelicateDyesBlocks.CORAL_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(DelicateDyesBlocks.CANARY_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(DelicateDyesBlocks.WASABI_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(DelicateDyesBlocks.SACRAMENTO_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(DelicateDyesBlocks.SKY_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(DelicateDyesBlocks.BLURPLE_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(DelicateDyesBlocks.SANGRIA_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(DelicateDyesBlocks.ROSE_JACK_O_STRAW.get(), RenderType.cutout());

            //          Appledog compat
            setRenderLayer(AppledogBlocks.APPLEDOG_BLOCK.get(), RenderType.cutout());

            //          DungeonsDelight compat
            setRenderLayer(DungeonsDelightBlocks.WORMWOOD_PICKETS.get(), RenderType.cutout());

            setRenderLayer(BFBlocks.APPLE_LOG.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.APPLE_WOOD.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.HANGING_APPLE.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.APPLE_SAPLING.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.POTTED_APPLE_SAPLING.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.ORANGE_LOG.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.ORANGE_WOOD.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.HANGING_ORANGE.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.ORANGE_SAPLING.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.POTTED_ORANGE_SAPLING.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.LEMON_LOG.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.LEMON_WOOD.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.HANGING_LEMON.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.LEMON_SAPLING.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.POTTED_LEMON_SAPLING.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.PLUM_LOG.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.PLUM_WOOD.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.HANGING_PLUM.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.PLUM_SAPLING.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.POTTED_PLUM_SAPLING.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.GOLDEN_APPLE_LOG.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.GOLDEN_APPLE_WOOD.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.HANGING_GOLDEN_APPLE.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.HANGING_WITHERED_GOLDEN_APPLE.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.GOLDEN_APPLE_SAPLING.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.POTTED_GOLDEN_APPLE_SAPLING.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.HOARY_APPLE_SAPLING_CROP.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.HOARY_APPLE_SAPLING.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.POTTED_WALNUT_SAPLING.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.POTTED_HOARY_APPLE_SAPLING.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.HANGING_HOARY_APPLE.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.WALNUT_SAPLING.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.HANGING_WALNUTS.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.FALLEN_WALNUTS.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.WILD_CARROTS.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.WILD_POTATOES.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.WILD_WHEAT.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.WILD_BEETROOTS.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.WILD_LEEKS.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.WILD_MAIZE.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.WILD_PASSION_FRUIT_VINE.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.WILD_ELDERBERRY_VINE.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.FERMENTATION_VESSEL.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.FELDSPAR_LANTERN.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.TINGED_GLASS.get(), RenderType.translucent());
            setRenderLayer(BFBlocks.CHECKERED_CERAMIC_TILES.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.CHECKERED_CERAMIC_TILE_STAIRS.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.CHECKERED_CERAMIC_TILE_SLAB.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.CRACKED_CHECKERED_CERAMIC_TILES.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.CHECKERED_CERAMIC_MOSAIC.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.CERAMIC_DOOR.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.APPLE_BLOCK.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.GOLDEN_APPLE_BLOCK.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.ORANGE_BLOCK.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.LEMON_BLOCK.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.PLUM_BLOCK.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.HOARY_APPLE_BLOCK.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.WALNUT_DOOR.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.TEA_SHRUB.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.CHAMOMILE_FLOWERS.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.HONEYSUCKLE.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.POTTED_HONEYSUCKLE.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.VIOLET_BELLFLOWER.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.POTTED_VIOLET_BELLFLOWER.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.RED_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.ORANGE_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.YELLOW_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.LIME_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.GREEN_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.CYAN_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.LIGHT_BLUE_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.BLUE_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.PURPLE_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.MAGENTA_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.PINK_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.WHITE_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.LIGHT_GRAY_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.GRAY_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.BLACK_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.BROWN_JACK_O_STRAW.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.GREEN_TEA_CANDLE.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.BLACK_TEA_CANDLE.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.CHAMOMILE_CANDLE.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.HONEYSUCKLE_CANDLE.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.BELLFLOWER_CANDLE.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.TORCHFLOWER_CANDLE.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.WALNUT_CANDLE.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.LEEKS.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.MAIZE_CROP.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.SPONGEKIN_STEM.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.SPONGEKIN_SPROUT.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.SPONGE_CAKE.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.PRISMARINE_BLOSSOM.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.SCORCHKIN_STEM.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.OAK_PICKETS.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.SPRUCE_PICKETS.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.BIRCH_PICKETS.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.JUNGLE_PICKETS.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.ACACIA_PICKETS.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.DARK_OAK_PICKETS.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.MANGROVE_PICKETS.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.CHERRY_PICKETS.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.BAMBOO_PICKETS.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.WALNUT_PICKETS.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.HOARY_PICKETS.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.CRIMSON_PICKETS.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.WARPED_PICKETS.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.IRON_RAILING.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.GRASSY_DIRT.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.PALM_FROND.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.WALL_PALM_FROND.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.POTTED_PALM_FROND.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.COCONUT.get(), RenderType.cutout());
            setRenderLayer(BFBlocks.PALM_SAPLING.get(), RenderType.cutout());


            Sheets.SIGN_MATERIALS.put(BFWoodTypes.HOARY, Sheets.getSignMaterial(BFWoodTypes.HOARY));
            Sheets.SIGN_MATERIALS.put(BFWoodTypes.WALNUT, Sheets.getSignMaterial(BFWoodTypes.WALNUT));
            BlockEntityRenderers.register(BFBlockEntities.MOD_SIGN_BLOCK_ENTITY.get(), SignRenderer::new);
            BlockEntityRenderers.register(BFBlockEntities.MOD_HANGING_SIGN_BLOCK_ENTITY.get(), HangingSignRenderer::new);


            ItemProperties.register(
                    BFItems.ARTISAN_BRUSH.get(), BountifulFares.rl("dyed"),
                    (itemStack, clientWorld, livingEntity, seed) ->
                            BFDyeableLeatherItem.hasColorStatic(itemStack) ? 1.0F : 0.0F);

            for (Supplier<Block> block : BFTrellises.TRELLIS_RENDER_CUTOUT) {
                setRenderLayer(block.get(), RenderType.cutout());
            }
        });
    }

    @SubscribeEvent
    public static void onRegisterMenuScreensEvent(RegisterMenuScreensEvent event) {
        event.register(BFScreenHandlers.GRISTMILL_SCREEN_HANDLER, GristmillScreen::new);
    }


    @SubscribeEvent
    public static void onRegisterParticleProvidersEvent(EntityRenderersEvent.AddLayers event) {
        // TerraformBoatClientHelper.registerModelLayers(BFBoats.HOARY_BOAT_ID, false);
        // TerraformBoatClientHelper.registerModelLayers(BFBoats.WALNUT_BOAT_ID, false);
    }

    @SubscribeEvent
    public static void onRegisterParticleProvidersEvent(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(BFParticles.FLOUR_CLOUD, FlourCloudParticle.Factory::new);
        event.registerSpriteSet(BFParticles.PRISMARINE_BLOSSOM, PrismarineBlossomParticle.Factory::new);
        event.registerSpriteSet(BFParticles.FERMENTED_BUBBLE, FermentedBubbleParticle.Factory::new);
        event.registerSpriteSet(BFParticles.GOLDEN_PETAL, GoldenPetalParticle.Factory::new);
    }

    @SuppressWarnings("deprecated")
    private static void setRenderLayer(Block block, RenderType type) {
        ItemBlockRenderTypes.setRenderLayer(block, type);
    }


    private static void registerBlockColor(RegisterColorHandlersEvent.Block event, Block ModCeramicBlocksItems) {
//        Registers tint for ceramic blocks
        registerItemColor(ModCeramicBlocksItems.asItem());
        event.register((state, world, pos, tintIndex) -> FastColorAttach.opaque(DyeableBlockEntity.getColor(world, pos)),
                ModCeramicBlocksItems);
    }

    private static final Map<Item, ItemColor> colorItems = new HashMap<>();

    private static void registerItemColor(Item item) {
//        Registers tint for ceramic items
//         Minecraft.getInstance().getItemColors().register((stack, tintIndex) -> {
//             if (BFDyeableLeatherItem.hasColorStatic(stack) && tintIndex == 0) {
//                 return FastColorAttach.opaque(BFDyeableLeatherItem.getColorStatic(stack));
//             }
//             return DyeableBlockEntity.DEFAULT_COLOR;
//         }, item);
        colorItems.put(item, (stack, tintIndex) -> {
            if (BFDyeableLeatherItem.hasColorStatic(stack) && tintIndex == 0) {
                return FastColorAttach.opaque(BFDyeableLeatherItem.getColorStatic(stack));
            }
            return DyeableBlockEntity.DEFAULT_COLOR;
        });
    }

    @SubscribeEvent
    public static void onRegisterColorHandlersEvent_Block(RegisterColorHandlersEvent.Block event) {
        registerBlockColor(event, BFBlocks.CERAMIC_TILES.get());
        registerBlockColor(event, BFBlocks.CERAMIC_TILE_STAIRS.get());
        registerBlockColor(event, BFBlocks.CERAMIC_TILE_SLAB.get());
        registerBlockColor(event, BFBlocks.CRACKED_CERAMIC_TILES.get());
        registerBlockColor(event, BFBlocks.CHECKERED_CERAMIC_TILES.get());
        registerBlockColor(event, BFBlocks.CHECKERED_CERAMIC_TILE_STAIRS.get());
        registerBlockColor(event, BFBlocks.CHECKERED_CERAMIC_TILE_SLAB.get());
        registerBlockColor(event, BFBlocks.CRACKED_CHECKERED_CERAMIC_TILES.get());
        registerBlockColor(event, BFBlocks.CERAMIC_MOSAIC.get());
        registerBlockColor(event, BFBlocks.CERAMIC_MOSAIC_STAIRS.get());
        registerBlockColor(event, BFBlocks.CERAMIC_MOSAIC_SLAB.get());
        registerBlockColor(event, BFBlocks.CHECKERED_CERAMIC_MOSAIC.get());
        registerBlockColor(event, BFBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS.get());
        registerBlockColor(event, BFBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB.get());
        registerBlockColor(event, BFBlocks.CERAMIC_TILE_PILLAR.get());
        registerBlockColor(event, BFBlocks.CERAMIC_PRESSURE_PLATE.get());
        registerBlockColor(event, BFBlocks.CERAMIC_BUTTON.get());
        registerBlockColor(event, BFBlocks.CERAMIC_LEVER.get());
        registerBlockColor(event, BFBlocks.CERAMIC_DOOR.get());
        registerBlockColor(event, BFBlocks.CERAMIC_TRAPDOOR.get());
        registerBlockColor(event, BFBlocks.CERAMIC_DISH.get());

        registerBlockColor(event, ExcessiveBuildingBlocks.CERAMIC_TILE_VERTICAL_STAIRS.get());
        registerBlockColor(event, ExcessiveBuildingBlocks.CHECKERED_CERAMIC_TILE_VERTICAL_STAIRS.get());
        registerBlockColor(event, ExcessiveBuildingBlocks.CERAMIC_MOSAIC_VERTICAL_STAIRS.get());
        registerBlockColor(event, ExcessiveBuildingBlocks.CHECKERED_CERAMIC_MOSAIC_VERTICAL_STAIRS.get());

        event.register((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageGrassColor(world, pos)
                : GrassColor.getDefaultColor(), BFBlocks.CHAMOMILE_FLOWERS.get(), BFBlocks.GRASSY_DIRT.get());

        event.register((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos)
                        : FoliageColor.getDefaultColor(),
                BFBlocks.APPLE_LEAVES.get(), BFBlocks.FLOWERING_APPLE_LEAVES.get(), BFBlocks.APPLE_LOG.get(), BFBlocks.APPLE_WOOD.get(),
                BFBlocks.ORANGE_LEAVES.get(), BFBlocks.FLOWERING_ORANGE_LEAVES.get(), BFBlocks.ORANGE_LOG.get(), BFBlocks.ORANGE_WOOD.get(),
                BFBlocks.LEMON_LEAVES.get(), BFBlocks.FLOWERING_LEMON_LEAVES.get(), BFBlocks.LEMON_LOG.get(), BFBlocks.LEMON_WOOD.get(),
                BFBlocks.PLUM_LEAVES.get(), BFBlocks.FLOWERING_PLUM_LEAVES.get(), BFBlocks.PLUM_LOG.get(), BFBlocks.PLUM_WOOD.get(),
                BFBlocks.WALNUT_LEAVES.get());

        event.register((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos)
                : FoliageColor.getDefaultColor(), BFBlocks.HANGING_WALNUTS.get());

        event.register(((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageGrassColor(world, pos) : FoliageColor.getDefaultColor()), BFBlocks.WILD_POTATOES.get(), BFBlocks.WILD_CARROTS.get(), BFBlocks.WILD_BEETROOTS.get(), BFBlocks.WILD_LEEKS.get(), BFBlocks.WILD_MAIZE.get(), BFBlocks.WILD_PASSION_FRUIT_VINE.get(), BFBlocks.WILD_ELDERBERRY_VINE.get());

    }

    @SubscribeEvent
    public static void onRegisterColorHandlersEvent_Item(RegisterColorHandlersEvent.Item event) {
        colorItems.forEach(
                (item, itemColor) -> event.register(itemColor, item)
        );
        event.register(((stack, tintIndex) -> GrassColor.getDefaultColor()), BFBlocks.GRASSY_DIRT.get());
        event.register((stack, tintIndex) -> FastColorAttach.opaque(FoliageColor.getDefaultColor()), BFBlocks.APPLE_LEAVES.get(), BFBlocks.FLOWERING_APPLE_LEAVES.get(), BFBlocks.ORANGE_LEAVES.get(), BFBlocks.FLOWERING_ORANGE_LEAVES.get(), BFBlocks.LEMON_LEAVES.get(), BFBlocks.FLOWERING_LEMON_LEAVES.get(), BFBlocks.PLUM_LEAVES.get(), BFBlocks.FLOWERING_PLUM_LEAVES.get(), BFBlocks.ORANGE_LEAVES.get());
        event.register((stack, tintIndex) -> FastColorAttach.opaque(5809764), BFBlocks.WALNUT_LEAVES.get());

        event.register((stack, tintIndex) -> {
            if (BFDyeableLeatherItem.hasColorStatic(stack) && tintIndex == 0) {
                return FastColorAttach.opaque(BFDyeableLeatherItem.getColorStatic(stack));
            }
            return ArtisanBrushItem.DEFAULT_COLOR;
        }, BFItems.ARTISAN_BRUSH.get());
    }
}
