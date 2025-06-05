package net.hecco.bountifulfares;

import com.xueluoanping.bountifulfaresforge.client.FastColorAttach;
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
import net.hecco.bountifulfares.item.custom.BFDyeableLeatherItem;
import net.hecco.bountifulfares.networking.BFMessages;
import net.hecco.bountifulfares.particle.FermentedBubbleParticle;
import net.hecco.bountifulfares.particle.FlourCloudParticle;
import net.hecco.bountifulfares.particle.GoldenPetalParticle;
import net.hecco.bountifulfares.particle.PrismarineBlossomParticle;
import net.hecco.bountifulfares.registry.content.*;
import net.hecco.bountifulfares.registry.misc.BFScreenHandlers;
import net.hecco.bountifulfares.registry.util.BFWoodTypes;
import net.hecco.bountifulfares.screen.GristmillScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.item.ItemProperties;

import net.minecraft.util.FastColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.Objects;

// import static net.hecco.bountifulfares.registry.content.BFItems.ARTISAN_BRUSH;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BountifulFaresClient {

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(BFBlockEntities.CERAMIC_DISH_BLOCK_ENTITY, CeramicDishBlockEntityRenderer::new);

        event.registerEntityRenderer(BFEntities.THROWN_FLOUR_PROJECTILE, ThrownItemRenderer::new);
    }


    @SubscribeEvent
    public static void onInitializeClient(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            BFMessages.registerS2CPackets();
            // ItemTooltipCallback.EVENT.register(BFTooltipEvents::addTooltipsToVanillaItems);
            // BlockEntityRenderers.register(BFBlockEntities.CERAMIC_DISH_BLOCK_ENTITY, CeramicDishBlockEntityRenderer::new);
//        ElsAndLsDyes compat
            setRenderLayer(MintBlocks.ACORN_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(MintBlocks.ARTICHOKE_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(MintBlocks.AMBER_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(MintBlocks.BANANA_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(MintBlocks.CERULEAN_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(MintBlocks.FUCHSIA_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(MintBlocks.GRAPE_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(MintBlocks.INDIGO_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(MintBlocks.MAROON_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(MintBlocks.MAUVE_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(MintBlocks.MOLD_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(MintBlocks.MINT_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(MintBlocks.NAVY_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(MintBlocks.PEACH_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(MintBlocks.PERIWINKLE_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(MintBlocks.SAGE_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(MintBlocks.SAP_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(MintBlocks.SHAMROCK_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(MintBlocks.VELVET_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(MintBlocks.VERMILION_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(MintBlocks.WINTERGREEN_PICKETS, RenderType.cutout());

//        DyeDepot compat
            setRenderLayer(DyeDepotBlocks.MAROON_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(DyeDepotBlocks.ROSE_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(DyeDepotBlocks.CORAL_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(DyeDepotBlocks.GINGER_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(DyeDepotBlocks.TAN_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(DyeDepotBlocks.BEIGE_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(DyeDepotBlocks.AMBER_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(DyeDepotBlocks.OLIVE_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(DyeDepotBlocks.FOREST_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(DyeDepotBlocks.VERDANT_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(DyeDepotBlocks.TEAL_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(DyeDepotBlocks.MINT_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(DyeDepotBlocks.AQUA_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(DyeDepotBlocks.SLATE_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(DyeDepotBlocks.NAVY_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(DyeDepotBlocks.INDIGO_JACK_O_STRAW, RenderType.cutout());
//        ExcessiveBuilding compat
            setRenderLayer(ExcessiveBuildingBlocks.ANCIENT_PICKETS, RenderType.cutout());
            setRenderLayer(ExcessiveBuildingBlocks.WALNUT_LADDER, RenderType.cutout());
            setRenderLayer(ExcessiveBuildingBlocks.HOARY_LADDER, RenderType.cutout());
            setRenderLayer(ExcessiveBuildingBlocks.CHECKERED_CERAMIC_TILE_VERTICAL_STAIRS, RenderType.cutout());
            setRenderLayer(ExcessiveBuildingBlocks.CHECKERED_CERAMIC_MOSAIC_VERTICAL_STAIRS, RenderType.cutout());
            registerBlockColor(ExcessiveBuildingBlocks.CERAMIC_TILE_VERTICAL_STAIRS);
            registerBlockColor(ExcessiveBuildingBlocks.CHECKERED_CERAMIC_TILE_VERTICAL_STAIRS);
            registerBlockColor(ExcessiveBuildingBlocks.CERAMIC_MOSAIC_VERTICAL_STAIRS);
            registerBlockColor(ExcessiveBuildingBlocks.CHECKERED_CERAMIC_MOSAIC_VERTICAL_STAIRS);

//        NaturesSpirit compat
            setRenderLayer(NaturesSpiritBlocks.ASPEN_PICKETS, RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.CEDAR_PICKETS, RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.COCONUT_PICKETS, RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.CYPRESS_PICKETS, RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.FIR_PICKETS, RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.JOSHUA_PICKETS, RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.GHAF_PICKETS, RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.LARCH_PICKETS, RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.MAHOGANY_PICKETS, RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.MAPLE_PICKETS, RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.MAHOGANY_PICKETS, RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.OLIVE_PICKETS, RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.PALO_VERDE_PICKETS, RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.REDWOOD_PICKETS, RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.SAXAUL_PICKETS, RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.SUGI_PICKETS, RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.WILLOW_PICKETS, RenderType.cutout());
            setRenderLayer(NaturesSpiritBlocks.WISTERIA_PICKETS, RenderType.cutout());

            //        Spawn compat
            setRenderLayer(SpawnBlocks.ROTTEN_PICKETS, RenderType.cutout());
            //        ArtsAndCrafts compat
            setRenderLayer(ArtsAndCraftsBlocks.CORK_PICKETS, RenderType.cutout());

            //        DelicateDyes compat
            setRenderLayer(DelicateDyesBlocks.CORAL_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(DelicateDyesBlocks.CANARY_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(DelicateDyesBlocks.WASABI_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(DelicateDyesBlocks.SACRAMENTO_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(DelicateDyesBlocks.SKY_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(DelicateDyesBlocks.BLURPLE_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(DelicateDyesBlocks.SANGRIA_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(DelicateDyesBlocks.ROSE_JACK_O_STRAW, RenderType.cutout());

            //          Appledog compat
            setRenderLayer(AppledogBlocks.APPLEDOG_BLOCK, RenderType.cutout());

            //          DungeonsDelight compat
            setRenderLayer(DungeonsDelightBlocks.WORMWOOD_PICKETS, RenderType.cutout());

            setRenderLayer(BFBlocks.APPLE_LOG, RenderType.cutout());
            setRenderLayer(BFBlocks.APPLE_WOOD, RenderType.cutout());
            setRenderLayer(BFBlocks.HANGING_APPLE, RenderType.cutout());
            setRenderLayer(BFBlocks.APPLE_SAPLING, RenderType.cutout());
            setRenderLayer(BFBlocks.POTTED_APPLE_SAPLING, RenderType.cutout());
            setRenderLayer(BFBlocks.ORANGE_LOG, RenderType.cutout());
            setRenderLayer(BFBlocks.ORANGE_WOOD, RenderType.cutout());
            setRenderLayer(BFBlocks.HANGING_ORANGE, RenderType.cutout());
            setRenderLayer(BFBlocks.ORANGE_SAPLING, RenderType.cutout());
            setRenderLayer(BFBlocks.POTTED_ORANGE_SAPLING, RenderType.cutout());
            setRenderLayer(BFBlocks.LEMON_LOG, RenderType.cutout());
            setRenderLayer(BFBlocks.LEMON_WOOD, RenderType.cutout());
            setRenderLayer(BFBlocks.HANGING_LEMON, RenderType.cutout());
            setRenderLayer(BFBlocks.LEMON_SAPLING, RenderType.cutout());
            setRenderLayer(BFBlocks.POTTED_LEMON_SAPLING, RenderType.cutout());
            setRenderLayer(BFBlocks.PLUM_LOG, RenderType.cutout());
            setRenderLayer(BFBlocks.PLUM_WOOD, RenderType.cutout());
            setRenderLayer(BFBlocks.HANGING_PLUM, RenderType.cutout());
            setRenderLayer(BFBlocks.PLUM_SAPLING, RenderType.cutout());
            setRenderLayer(BFBlocks.POTTED_PLUM_SAPLING, RenderType.cutout());
            setRenderLayer(BFBlocks.GOLDEN_APPLE_LOG, RenderType.cutout());
            setRenderLayer(BFBlocks.GOLDEN_APPLE_WOOD, RenderType.cutout());
            setRenderLayer(BFBlocks.HANGING_GOLDEN_APPLE, RenderType.cutout());
            setRenderLayer(BFBlocks.HANGING_WITHERED_GOLDEN_APPLE, RenderType.cutout());
            setRenderLayer(BFBlocks.GOLDEN_APPLE_SAPLING, RenderType.cutout());
            setRenderLayer(BFBlocks.POTTED_GOLDEN_APPLE_SAPLING, RenderType.cutout());
            setRenderLayer(BFBlocks.HOARY_APPLE_SAPLING_CROP, RenderType.cutout());
            setRenderLayer(BFBlocks.HOARY_APPLE_SAPLING, RenderType.cutout());
            setRenderLayer(BFBlocks.POTTED_WALNUT_SAPLING, RenderType.cutout());
            setRenderLayer(BFBlocks.POTTED_HOARY_APPLE_SAPLING, RenderType.cutout());
            setRenderLayer(BFBlocks.HANGING_HOARY_APPLE, RenderType.cutout());
            setRenderLayer(BFBlocks.WALNUT_SAPLING, RenderType.cutout());
            setRenderLayer(BFBlocks.HANGING_WALNUTS, RenderType.cutout());
            setRenderLayer(BFBlocks.FALLEN_WALNUTS, RenderType.cutout());
            setRenderLayer(BFBlocks.WILD_CARROTS, RenderType.cutout());
            setRenderLayer(BFBlocks.WILD_POTATOES, RenderType.cutout());
            setRenderLayer(BFBlocks.WILD_WHEAT, RenderType.cutout());
            setRenderLayer(BFBlocks.WILD_BEETROOTS, RenderType.cutout());
            setRenderLayer(BFBlocks.WILD_LEEKS, RenderType.cutout());
            setRenderLayer(BFBlocks.WILD_MAIZE, RenderType.cutout());
            setRenderLayer(BFBlocks.WILD_PASSION_FRUIT_VINE, RenderType.cutout());
            setRenderLayer(BFBlocks.WILD_ELDERBERRY_VINE, RenderType.cutout());
            setRenderLayer(BFBlocks.FERMENTATION_VESSEL, RenderType.cutout());
            setRenderLayer(BFBlocks.FELDSPAR_LANTERN, RenderType.cutout());
            setRenderLayer(BFBlocks.TINGED_GLASS, RenderType.translucent());
            setRenderLayer(BFBlocks.CHECKERED_CERAMIC_TILES, RenderType.cutout());
            setRenderLayer(BFBlocks.CHECKERED_CERAMIC_TILE_STAIRS, RenderType.cutout());
            setRenderLayer(BFBlocks.CHECKERED_CERAMIC_TILE_SLAB, RenderType.cutout());
            setRenderLayer(BFBlocks.CRACKED_CHECKERED_CERAMIC_TILES, RenderType.cutout());
            setRenderLayer(BFBlocks.CHECKERED_CERAMIC_MOSAIC, RenderType.cutout());
            setRenderLayer(BFBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS, RenderType.cutout());
            setRenderLayer(BFBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB, RenderType.cutout());
            setRenderLayer(BFBlocks.CERAMIC_DOOR, RenderType.cutout());
            setRenderLayer(BFBlocks.APPLE_BLOCK, RenderType.cutout());
            setRenderLayer(BFBlocks.GOLDEN_APPLE_BLOCK, RenderType.cutout());
            setRenderLayer(BFBlocks.ORANGE_BLOCK, RenderType.cutout());
            setRenderLayer(BFBlocks.LEMON_BLOCK, RenderType.cutout());
            setRenderLayer(BFBlocks.PLUM_BLOCK, RenderType.cutout());
            setRenderLayer(BFBlocks.HOARY_APPLE_BLOCK, RenderType.cutout());
            setRenderLayer(BFBlocks.WALNUT_DOOR, RenderType.cutout());
            setRenderLayer(BFBlocks.TEA_SHRUB, RenderType.cutout());
            setRenderLayer(BFBlocks.CHAMOMILE_FLOWERS, RenderType.cutout());
            setRenderLayer(BFBlocks.HONEYSUCKLE, RenderType.cutout());
            setRenderLayer(BFBlocks.POTTED_HONEYSUCKLE, RenderType.cutout());
            setRenderLayer(BFBlocks.VIOLET_BELLFLOWER, RenderType.cutout());
            setRenderLayer(BFBlocks.POTTED_VIOLET_BELLFLOWER, RenderType.cutout());
            setRenderLayer(BFBlocks.RED_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(BFBlocks.ORANGE_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(BFBlocks.YELLOW_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(BFBlocks.LIME_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(BFBlocks.GREEN_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(BFBlocks.CYAN_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(BFBlocks.LIGHT_BLUE_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(BFBlocks.BLUE_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(BFBlocks.PURPLE_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(BFBlocks.MAGENTA_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(BFBlocks.PINK_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(BFBlocks.WHITE_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(BFBlocks.LIGHT_GRAY_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(BFBlocks.GRAY_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(BFBlocks.BLACK_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(BFBlocks.BROWN_JACK_O_STRAW, RenderType.cutout());
            setRenderLayer(BFBlocks.GREEN_TEA_CANDLE, RenderType.cutout());
            setRenderLayer(BFBlocks.BLACK_TEA_CANDLE, RenderType.cutout());
            setRenderLayer(BFBlocks.CHAMOMILE_CANDLE, RenderType.cutout());
            setRenderLayer(BFBlocks.HONEYSUCKLE_CANDLE, RenderType.cutout());
            setRenderLayer(BFBlocks.BELLFLOWER_CANDLE, RenderType.cutout());
            setRenderLayer(BFBlocks.TORCHFLOWER_CANDLE, RenderType.cutout());
            setRenderLayer(BFBlocks.WALNUT_CANDLE, RenderType.cutout());
            setRenderLayer(BFBlocks.LEEKS, RenderType.cutout());
            setRenderLayer(BFBlocks.MAIZE_CROP, RenderType.cutout());
            setRenderLayer(BFBlocks.SPONGEKIN_STEM, RenderType.cutout());
            setRenderLayer(BFBlocks.SPONGEKIN_SPROUT, RenderType.cutout());
            setRenderLayer(BFBlocks.SPONGE_CAKE, RenderType.cutout());
            setRenderLayer(BFBlocks.PRISMARINE_BLOSSOM, RenderType.cutout());
            setRenderLayer(BFBlocks.SCORCHKIN_STEM, RenderType.cutout());
            setRenderLayer(BFBlocks.OAK_PICKETS, RenderType.cutout());
            setRenderLayer(BFBlocks.SPRUCE_PICKETS, RenderType.cutout());
            setRenderLayer(BFBlocks.BIRCH_PICKETS, RenderType.cutout());
            setRenderLayer(BFBlocks.JUNGLE_PICKETS, RenderType.cutout());
            setRenderLayer(BFBlocks.ACACIA_PICKETS, RenderType.cutout());
            setRenderLayer(BFBlocks.DARK_OAK_PICKETS, RenderType.cutout());
            setRenderLayer(BFBlocks.MANGROVE_PICKETS, RenderType.cutout());
            setRenderLayer(BFBlocks.CHERRY_PICKETS, RenderType.cutout());
            setRenderLayer(BFBlocks.BAMBOO_PICKETS, RenderType.cutout());
            setRenderLayer(BFBlocks.WALNUT_PICKETS, RenderType.cutout());
            setRenderLayer(BFBlocks.HOARY_PICKETS, RenderType.cutout());
            setRenderLayer(BFBlocks.CRIMSON_PICKETS, RenderType.cutout());
            setRenderLayer(BFBlocks.WARPED_PICKETS, RenderType.cutout());
            setRenderLayer(BFBlocks.IRON_RAILING, RenderType.cutout());
            setRenderLayer(BFBlocks.GRASSY_DIRT, RenderType.cutout());
            setRenderLayer(BFBlocks.PALM_FROND, RenderType.cutout());
            setRenderLayer(BFBlocks.WALL_PALM_FROND, RenderType.cutout());
            setRenderLayer(BFBlocks.POTTED_PALM_FROND, RenderType.cutout());
            setRenderLayer(BFBlocks.COCONUT, RenderType.cutout());
            setRenderLayer(BFBlocks.PALM_SAPLING, RenderType.cutout());


            Sheets.SIGN_MATERIALS.put(BFWoodTypes.HOARY, Sheets.getSignMaterial(BFWoodTypes.HOARY));
            Sheets.SIGN_MATERIALS.put(BFWoodTypes.WALNUT, Sheets.getSignMaterial(BFWoodTypes.WALNUT));
            BlockEntityRenderers.register(BFBlockEntities.MOD_SIGN_BLOCK_ENTITY, SignRenderer::new);
            BlockEntityRenderers.register(BFBlockEntities.MOD_HANGING_SIGN_BLOCK_ENTITY, HangingSignRenderer::new);




            MenuScreens.register(BFScreenHandlers.GRISTMILL_SCREEN_HANDLER, GristmillScreen::new);


            ItemProperties.register(
                    BFItems.ARTISAN_BRUSH.get(), BountifulFares.rl("dyed"),
                    (itemStack, clientWorld, livingEntity, seed) ->
                            BFDyeableLeatherItem.hasColorStatic(itemStack) ? 1.0F : 0.0F);

            for (Block block : BFTrellises.TRELLIS_RENDER_CUTOUT) {
                setRenderLayer(block, RenderType.cutout());
            }
        });
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


    private static void registerBlockColor(Block ModCeramicBlocksItems) {
//        Registers tint for ceramic blocks
        registerItemColor(ModCeramicBlocksItems.asItem());
        Minecraft.getInstance().getBlockColors()
                .register((state, world, pos, tintIndex) -> FastColorAttach.opaque(DyeableBlockEntity.getColor(world, pos)), ModCeramicBlocksItems);
    }

    private static void registerItemColor(Item item) {
//        Registers tint for ceramic items
        Minecraft.getInstance().getItemColors().register((stack, tintIndex) -> {
            if (BFDyeableLeatherItem.hasColorStatic(stack) && tintIndex == 0) {
                return FastColorAttach.opaque(BFDyeableLeatherItem.getColorStatic(stack));
            }
            return DyeableBlockEntity.DEFAULT_COLOR;
        }, item);
    }

    @SubscribeEvent
    public static void onRegisterColorHandlersEvent_Block(RegisterColorHandlersEvent.Block event) {
        registerBlockColor(BFBlocks.CERAMIC_TILES);
        registerBlockColor(BFBlocks.CERAMIC_TILE_STAIRS);
        registerBlockColor(BFBlocks.CERAMIC_TILE_SLAB);
        registerBlockColor(BFBlocks.CRACKED_CERAMIC_TILES);
        registerBlockColor(BFBlocks.CHECKERED_CERAMIC_TILES);
        registerBlockColor(BFBlocks.CHECKERED_CERAMIC_TILE_STAIRS);
        registerBlockColor(BFBlocks.CHECKERED_CERAMIC_TILE_SLAB);
        registerBlockColor(BFBlocks.CRACKED_CHECKERED_CERAMIC_TILES);
        registerBlockColor(BFBlocks.CERAMIC_MOSAIC);
        registerBlockColor(BFBlocks.CERAMIC_MOSAIC_STAIRS);
        registerBlockColor(BFBlocks.CERAMIC_MOSAIC_SLAB);
        registerBlockColor(BFBlocks.CHECKERED_CERAMIC_MOSAIC);
        registerBlockColor(BFBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS);
        registerBlockColor(BFBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB);
        registerBlockColor(BFBlocks.CERAMIC_TILE_PILLAR);
        registerBlockColor(BFBlocks.CERAMIC_PRESSURE_PLATE);
        registerBlockColor(BFBlocks.CERAMIC_BUTTON);
        registerBlockColor(BFBlocks.CERAMIC_LEVER);
        registerBlockColor(BFBlocks.CERAMIC_DOOR);
        registerBlockColor(BFBlocks.CERAMIC_TRAPDOOR);
        registerBlockColor(BFBlocks.CERAMIC_DISH);

        event.register((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageGrassColor(world, pos)
                : GrassColor.getDefaultColor(), BFBlocks.CHAMOMILE_FLOWERS, BFBlocks.GRASSY_DIRT);

        event.register((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos)
                        : FoliageColor.getDefaultColor(),
                BFBlocks.APPLE_LEAVES, BFBlocks.FLOWERING_APPLE_LEAVES, BFBlocks.APPLE_LOG, BFBlocks.APPLE_WOOD,
                BFBlocks.ORANGE_LEAVES, BFBlocks.FLOWERING_ORANGE_LEAVES, BFBlocks.ORANGE_LOG, BFBlocks.ORANGE_WOOD,
                BFBlocks.LEMON_LEAVES, BFBlocks.FLOWERING_LEMON_LEAVES, BFBlocks.LEMON_LOG, BFBlocks.LEMON_WOOD,
                BFBlocks.PLUM_LEAVES, BFBlocks.FLOWERING_PLUM_LEAVES, BFBlocks.PLUM_LOG, BFBlocks.PLUM_WOOD,
                BFBlocks.WALNUT_LEAVES);

        event.register((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos)
                : FoliageColor.getDefaultColor(), BFBlocks.HANGING_WALNUTS);

        event.register(((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageGrassColor(world, pos) : FoliageColor.getDefaultColor()), BFBlocks.WILD_POTATOES, BFBlocks.WILD_CARROTS, BFBlocks.WILD_BEETROOTS, BFBlocks.WILD_LEEKS, BFBlocks.WILD_MAIZE, BFBlocks.WILD_PASSION_FRUIT_VINE, BFBlocks.WILD_ELDERBERRY_VINE);

    }

    @SubscribeEvent
    public static void onRegisterColorHandlersEvent_Item(RegisterColorHandlersEvent.Item event) {
        event.register(((stack, tintIndex) -> GrassColor.getDefaultColor()), BFBlocks.GRASSY_DIRT);
        event.register((stack, tintIndex) -> FastColorAttach.opaque(FoliageColor.getDefaultColor()), BFBlocks.APPLE_LEAVES, BFBlocks.FLOWERING_APPLE_LEAVES, BFBlocks.ORANGE_LEAVES, BFBlocks.FLOWERING_ORANGE_LEAVES, BFBlocks.LEMON_LEAVES, BFBlocks.FLOWERING_LEMON_LEAVES, BFBlocks.PLUM_LEAVES, BFBlocks.FLOWERING_PLUM_LEAVES, BFBlocks.ORANGE_LEAVES);
        event.register((stack, tintIndex) -> FastColorAttach.opaque(5809764), BFBlocks.WALNUT_LEAVES);

        event.register((stack, tintIndex) -> {
            if (BFDyeableLeatherItem.hasColorStatic(stack) && tintIndex == 0) {
                return FastColorAttach.opaque(BFDyeableLeatherItem.getColorStatic(stack));
            }
            return ArtisanBrushItem.DEFAULT_COLOR;
        }, BFItems.ARTISAN_BRUSH.get());
    }
}
