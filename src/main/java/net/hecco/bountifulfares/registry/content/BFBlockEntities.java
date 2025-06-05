package net.hecco.bountifulfares.registry.content;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.entity.*;
import net.hecco.bountifulfares.block.entity.compat.CabinetBlockEntity;
import net.hecco.bountifulfares.compat.excessive_building.ExcessiveBuildingBlocks;
import net.hecco.bountifulfares.compat.farmersdelight.FarmersDelightBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;


// @Mod.EventBusSubscriber(modid = BountifulFares.MOD_ID)
public class BFBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPE_DEFERRED_REGISTER = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, BountifulFares.MOD_ID);

    private static final Map<ResourceKey<BlockEntityType<?>>, BlockEntityType<?>> blockEntityTypes = new HashMap<>();

    public static final RegistryObject<BlockEntityType<DyeableCeramicBlockEntity>> CERAMIC_TILES_BLOCK_ENTITY = registerForCache(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            BountifulFares.rl("ceramic_tiles_block_entity"),
            () -> BlockEntityType.Builder.of(DyeableCeramicBlockEntity::new, BFBlocks.CERAMIC_TILES.get(), BFBlocks.CERAMIC_TILE_STAIRS.get(), BFBlocks.CERAMIC_TILE_SLAB.get(), BFBlocks.CERAMIC_PRESSURE_PLATE.get(), BFBlocks.CERAMIC_BUTTON.get(), BFBlocks.CERAMIC_LEVER.get(), BFBlocks.CHECKERED_CERAMIC_TILES.get(), BFBlocks.CHECKERED_CERAMIC_TILE_STAIRS.get(), BFBlocks.CHECKERED_CERAMIC_TILE_SLAB.get(), BFBlocks.CRACKED_CERAMIC_TILES.get(), BFBlocks.CRACKED_CHECKERED_CERAMIC_TILES.get(), BFBlocks.CERAMIC_TILE_PILLAR.get(), BFBlocks.CERAMIC_MOSAIC.get(), BFBlocks.CERAMIC_MOSAIC_STAIRS.get(), BFBlocks.CERAMIC_MOSAIC_SLAB.get(), BFBlocks.CHECKERED_CERAMIC_MOSAIC.get(), BFBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS.get(), BFBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB.get(), BFBlocks.CERAMIC_DOOR.get(), BFBlocks.CERAMIC_TRAPDOOR.get(),
                    ExcessiveBuildingBlocks.CERAMIC_TILE_VERTICAL_STAIRS.get(), ExcessiveBuildingBlocks.CHECKERED_CERAMIC_TILE_VERTICAL_STAIRS.get(), ExcessiveBuildingBlocks.CERAMIC_MOSAIC_VERTICAL_STAIRS.get(), ExcessiveBuildingBlocks.CHECKERED_CERAMIC_MOSAIC_VERTICAL_STAIRS.get()).build(null)
    );

    public static final RegistryObject<BlockEntityType<CeramicDishBlockEntity>> CERAMIC_DISH_BLOCK_ENTITY = registerForCache(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            BountifulFares.rl("ceramic_dish_block_entity"),
            () -> BlockEntityType.Builder.of(CeramicDishBlockEntity::new, BFBlocks.CERAMIC_DISH.get()).build(null)
    );

    public static final RegistryObject<BlockEntityType<FermentationVesselBlockEntity>> FERMENTATION_VESSEL_BLOCK_ENTITY = registerForCache(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            BountifulFares.rl("fermentation_vessel_block_entity"),
            () -> BlockEntityType.Builder.of(FermentationVesselBlockEntity::new, BFBlocks.FERMENTATION_VESSEL.get()).build(null)
    );

    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> MOD_SIGN_BLOCK_ENTITY = registerForCache(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            BountifulFares.rl("mod_sign_entity"),
            () -> BlockEntityType.Builder.of(ModSignBlockEntity::new, BFBlocks.HOARY_SIGN.get(), BFBlocks.HOARY_WALL_SIGN.get(), BFBlocks.WALNUT_SIGN.get(), BFBlocks.WALNUT_WALL_SIGN.get()).build(null)
    );

    public static final RegistryObject<BlockEntityType<ModHangingSignBlockEntity>> MOD_HANGING_SIGN_BLOCK_ENTITY = registerForCache(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            BountifulFares.rl("mod_hanging_sign_entity"),
            () -> BlockEntityType.Builder.of(ModHangingSignBlockEntity::new, BFBlocks.HOARY_HANGING_SIGN.get(), BFBlocks.HOARY_WALL_HANGING_SIGN.get(), BFBlocks.WALNUT_HANGING_SIGN.get(), BFBlocks.WALNUT_WALL_HANGING_SIGN.get()).build(null)
    );

    public static final RegistryObject<BlockEntityType<GristmillBlockEntity>> GRISTMILL_BLOCK_ENTITY = registerForCache(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            BountifulFares.rl("gristmill_block_entity"),
            () -> BlockEntityType.Builder.of(GristmillBlockEntity::new, BFBlocks.GRISTMILL.get()).build(null)
    );

    public static final RegistryObject<BlockEntityType<GreenTeaCandleBlockEntity>> GREEN_TEA_CANDLE_BLOCK_ENTITY = registerForCache(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            BountifulFares.rl("green_tea_candle_entity"),
            () -> BlockEntityType.Builder.of(GreenTeaCandleBlockEntity::new, BFBlocks.GREEN_TEA_CANDLE.get()).build(null)
    );
    public static final RegistryObject<BlockEntityType<BlackTeaCandleBlockEntity>> BLACK_TEA_CANDLE_BLOCK_ENTITY = registerForCache(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            BountifulFares.rl("black_tea_candle_entity"),
            () -> BlockEntityType.Builder.of(BlackTeaCandleBlockEntity::new, BFBlocks.BLACK_TEA_CANDLE.get()).build(null)
    );
    public static final RegistryObject<BlockEntityType<ChamomileCandleBlockEntity>> CHAMOMILE_CANDLE_BLOCK_ENTITY = registerForCache(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            BountifulFares.rl("chamomile_candle_entity"),
            () -> BlockEntityType.Builder.of(ChamomileCandleBlockEntity::new, BFBlocks.CHAMOMILE_CANDLE.get()).build(null)
    );
    public static final RegistryObject<BlockEntityType<HoneysuckleCandleBlockEntity>> HONEYSUCKLE_CANDLE_BLOCK_ENTITY = registerForCache(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            BountifulFares.rl("honeysuckle_candle_entity"),
            () -> BlockEntityType.Builder.of(HoneysuckleCandleBlockEntity::new, BFBlocks.HONEYSUCKLE_CANDLE.get()).build(null)
    );
    public static final RegistryObject<BlockEntityType<BellflowerCandleBlockEntity>> BELLFLOWER_CANDLE_BLOCK_ENTITY = registerForCache(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            BountifulFares.rl("bellflower_candle_entity"),
            () -> BlockEntityType.Builder.of(BellflowerCandleBlockEntity::new, BFBlocks.BELLFLOWER_CANDLE.get()).build(null)
    );
    public static final RegistryObject<BlockEntityType<TorchflowerCandleBlockEntity>> TORCHFLOWER_CANDLE_BLOCK_ENTITY = registerForCache(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            BountifulFares.rl("torchflower_candle_entity"),
            () -> BlockEntityType.Builder.of(TorchflowerCandleBlockEntity::new, BFBlocks.TORCHFLOWER_CANDLE.get()).build(null)
    );

    public static final RegistryObject<BlockEntityType<WalnutCandleBlockEntity>> WALNUT_CANDLE_BLOCK_ENTITY = registerForCache(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            BountifulFares.rl("walnut_candle_entity"),
            () -> BlockEntityType.Builder.of(WalnutCandleBlockEntity::new, BFBlocks.WALNUT_CANDLE.get()).build(null)
    );

    public static RegistryObject<BlockEntityType<CabinetBlockEntity>> CABINET_BLOCK_ENTITY;

    public static void cacheExtraBlockEntities() {
        if (BountifulFares.isModLoaded(BountifulFares.FARMERS_DELIGHT_MOD_ID) || BountifulFares.isDatagen()) {
            CABINET_BLOCK_ENTITY = registerForCache(
                    BuiltInRegistries.BLOCK_ENTITY_TYPE,
                    BountifulFares.rl("cabinet_block_entity"),
                    () -> BlockEntityType.Builder.of(CabinetBlockEntity::new, FarmersDelightBlocks.WALNUT_CABINET.get(), FarmersDelightBlocks.HOARY_CABINET.get()).build(null)
            );
        }
    }

    private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> registerForCache(Registry<BlockEntityType<?>> registry, ResourceLocation id, Supplier<BlockEntityType<T>> type) {
        // blockEntityTypes.put(ResourceKey.create(Registries.BLOCK_ENTITY_TYPE, rl), type);
        return BLOCK_ENTITY_TYPE_DEFERRED_REGISTER.register(id.getPath(), type);
    }


    // @SubscribeEvent
    // public static void onRegister(RegisterEvent event) {
    //     event.register(Registries.BLOCK_ENTITY_TYPE, registerHelper -> {
    //         blockEntityTypes.forEach(registerHelper::register);
    //     });
    // }
}
