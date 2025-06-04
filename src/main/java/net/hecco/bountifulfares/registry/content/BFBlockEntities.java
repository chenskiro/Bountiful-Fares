package net.hecco.bountifulfares.registry.content;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.entity.*;
import net.hecco.bountifulfares.block.entity.compat.CabinetBlockEntity;
import net.hecco.bountifulfares.compat.excessive_building.ExcessiveBuildingBlocks;
import net.hecco.bountifulfares.compat.farmersdelight.FarmersDelightBlocks;
import net.minecraft.core.DefaultedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegisterEvent;

import java.util.HashMap;
import java.util.Map;

import static net.hecco.bountifulfares.registry.content.BFBlocks.*;

@Mod.EventBusSubscriber(modid = BountifulFares.MOD_ID)
public class BFBlockEntities {
    private static final Map<ResourceKey<BlockEntityType<? extends BlockEntity>>, BlockEntityType<? extends BlockEntity>> blockEntityTypes = new HashMap<>();

    public static final BlockEntityType<DyeableCeramicBlockEntity> CERAMIC_TILES_BLOCK_ENTITY = registerForCache(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            BountifulFares.rl("ceramic_tiles_block_entity"),
            BlockEntityType.Builder.of(DyeableCeramicBlockEntity::new, CERAMIC_TILES, CERAMIC_TILE_STAIRS, CERAMIC_TILE_SLAB, CERAMIC_PRESSURE_PLATE, CERAMIC_BUTTON, CERAMIC_LEVER, CHECKERED_CERAMIC_TILES, CHECKERED_CERAMIC_TILE_STAIRS, CHECKERED_CERAMIC_TILE_SLAB, CRACKED_CERAMIC_TILES, CRACKED_CHECKERED_CERAMIC_TILES, CERAMIC_TILE_PILLAR, CERAMIC_MOSAIC, CERAMIC_MOSAIC_STAIRS, CERAMIC_MOSAIC_SLAB, CHECKERED_CERAMIC_MOSAIC, CHECKERED_CERAMIC_MOSAIC_STAIRS, CHECKERED_CERAMIC_MOSAIC_SLAB, CERAMIC_DOOR, CERAMIC_TRAPDOOR, ExcessiveBuildingBlocks.CERAMIC_TILE_VERTICAL_STAIRS, ExcessiveBuildingBlocks.CHECKERED_CERAMIC_TILE_VERTICAL_STAIRS, ExcessiveBuildingBlocks.CERAMIC_MOSAIC_VERTICAL_STAIRS, ExcessiveBuildingBlocks.CHECKERED_CERAMIC_MOSAIC_VERTICAL_STAIRS).build(null)
    );

    public static final BlockEntityType<CeramicDishBlockEntity> CERAMIC_DISH_BLOCK_ENTITY = registerForCache(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            BountifulFares.rl("ceramic_dish_block_entity"),
            BlockEntityType.Builder.of(CeramicDishBlockEntity::new, CERAMIC_DISH).build(null)
    );

    public static final BlockEntityType<FermentationVesselBlockEntity> FERMENTATION_VESSEL_BLOCK_ENTITY = registerForCache(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            BountifulFares.rl("fermentation_vessel_block_entity"),
            BlockEntityType.Builder.of(FermentationVesselBlockEntity::new, FERMENTATION_VESSEL).build(null)
    );

    public static final BlockEntityType<ModSignBlockEntity> MOD_SIGN_BLOCK_ENTITY = registerForCache(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            BountifulFares.rl("mod_sign_entity"),
            BlockEntityType.Builder.of(ModSignBlockEntity::new, HOARY_SIGN, HOARY_WALL_SIGN, WALNUT_SIGN, WALNUT_WALL_SIGN).build(null)
    );

    public static final BlockEntityType<ModHangingSignBlockEntity> MOD_HANGING_SIGN_BLOCK_ENTITY = registerForCache(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            BountifulFares.rl("mod_hanging_sign_entity"),
            BlockEntityType.Builder.of(ModHangingSignBlockEntity::new, HOARY_HANGING_SIGN, HOARY_WALL_HANGING_SIGN, WALNUT_HANGING_SIGN, WALNUT_WALL_HANGING_SIGN).build(null)
    );

    public static final BlockEntityType<GristmillBlockEntity> GRISTMILL_BLOCK_ENTITY = registerForCache(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            BountifulFares.rl("gristmill_block_entity"),
            BlockEntityType.Builder.of(GristmillBlockEntity::new, GRISTMILL).build(null)
    );

    public static final BlockEntityType<GreenTeaCandleBlockEntity> GREEN_TEA_CANDLE_BLOCK_ENTITY = registerForCache(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            BountifulFares.rl("green_tea_candle_entity"),
            BlockEntityType.Builder.of(GreenTeaCandleBlockEntity::new, GREEN_TEA_CANDLE).build(null)
    );
    public static final BlockEntityType<BlackTeaCandleBlockEntity> BLACK_TEA_CANDLE_BLOCK_ENTITY = registerForCache(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            BountifulFares.rl("black_tea_candle_entity"),
            BlockEntityType.Builder.of(BlackTeaCandleBlockEntity::new, BLACK_TEA_CANDLE).build(null)
    );
    public static final BlockEntityType<ChamomileCandleBlockEntity> CHAMOMILE_CANDLE_BLOCK_ENTITY = registerForCache(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            BountifulFares.rl("chamomile_candle_entity"),
            BlockEntityType.Builder.of(ChamomileCandleBlockEntity::new, CHAMOMILE_CANDLE).build(null)
    );
    public static final BlockEntityType<HoneysuckleCandleBlockEntity> HONEYSUCKLE_CANDLE_BLOCK_ENTITY = registerForCache(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            BountifulFares.rl("honeysuckle_candle_entity"),
            BlockEntityType.Builder.of(HoneysuckleCandleBlockEntity::new, HONEYSUCKLE_CANDLE).build(null)
    );
    public static final BlockEntityType<BellflowerCandleBlockEntity> BELLFLOWER_CANDLE_BLOCK_ENTITY = registerForCache(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            BountifulFares.rl("bellflower_candle_entity"),
            BlockEntityType.Builder.of(BellflowerCandleBlockEntity::new, BELLFLOWER_CANDLE).build(null)
    );
    public static final BlockEntityType<TorchflowerCandleBlockEntity> TORCHFLOWER_CANDLE_BLOCK_ENTITY = registerForCache(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            BountifulFares.rl("torchflower_candle_entity"),
            BlockEntityType.Builder.of(TorchflowerCandleBlockEntity::new, TORCHFLOWER_CANDLE).build(null)
    );

    public static final BlockEntityType<WalnutCandleBlockEntity> WALNUT_CANDLE_BLOCK_ENTITY = registerForCache(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            BountifulFares.rl("walnut_candle_entity"),
            BlockEntityType.Builder.of(WalnutCandleBlockEntity::new, WALNUT_CANDLE).build(null)
    );

    public static BlockEntityType<CabinetBlockEntity> CABINET_BLOCK_ENTITY;

    public static void registerBlockEntities() {
        if (BountifulFares.isModLoaded(BountifulFares.FARMERS_DELIGHT_MOD_ID) || BountifulFares.isDatagen()) {
            CABINET_BLOCK_ENTITY = registerForCache(
                    BuiltInRegistries.BLOCK_ENTITY_TYPE,
                    BountifulFares.rl("cabinet_block_entity"),
                    BlockEntityType.Builder.of(CabinetBlockEntity::new, FarmersDelightBlocks.WALNUT_CABINET, FarmersDelightBlocks.HOARY_CABINET).build(null)
            );
        }
    }

    private static <T extends BlockEntity> BlockEntityType<T> registerForCache(Registry<BlockEntityType<?>> registry, ResourceLocation rl, BlockEntityType<T> type) {
        blockEntityTypes.put(ResourceKey.create(Registries.BLOCK_ENTITY_TYPE, rl), type);
        return type;
    }


    @SubscribeEvent
    public static void blockRegister(RegisterEvent event) {
        event.register(Registries.BLOCK_ENTITY_TYPE, registerHelper -> {
            blockEntityTypes.forEach(registerHelper::register);
        });
    }
}
