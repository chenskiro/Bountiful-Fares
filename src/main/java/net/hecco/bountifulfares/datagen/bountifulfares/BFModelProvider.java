package net.hecco.bountifulfares.datagen.bountifulfares;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonElement;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.compat.arts_and_crafts.ArtsAndCraftsBlocks;
import net.hecco.bountifulfares.compat.delicate_dyes.DelicateDyesBlocks;
import net.hecco.bountifulfares.compat.dungeons_delight.DungeonsDelightBlocks;
import net.hecco.bountifulfares.compat.excessive_building.ExcessiveBuildingBlocks;
import net.hecco.bountifulfares.compat.mint.MintBlocks;
import net.hecco.bountifulfares.compat.natures_spirit.NaturesSpiritBlocks;
import net.hecco.bountifulfares.compat.spawn.SpawnBlocks;
import net.hecco.bountifulfares.datagen.trellis.TrellisUtilProvider;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.content.BFTrellises;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.BlockStateGenerator;
import net.minecraft.data.models.model.DelegatedModel;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TexturedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static net.hecco.bountifulfares.datagen.bountifulfares.BFTemplateModels.*;

public class BFModelProvider implements DataProvider {
    private final PackOutput.PathProvider blockStatePathProvider;
    private final PackOutput.PathProvider modelPathProvider;

    public BFModelProvider(PackOutput pOutput) {
        this.blockStatePathProvider = pOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "blockstates");
        this.modelPathProvider = pOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "models");
    }

    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        registerFruitLogModels(blockStateModelGenerator, BFBlocks.APPLE_LOG.get(), BFBlocks.APPLE_WOOD.get(), BFBlocks.APPLE_LEAVES.get());
        registerFruitLogModels(blockStateModelGenerator, BFBlocks.STRIPPED_APPLE_LOG.get(), BFBlocks.STRIPPED_APPLE_WOOD.get());
        registerFruitLogModels(blockStateModelGenerator, BFBlocks.ORANGE_LOG.get(), BFBlocks.ORANGE_WOOD.get(), BFBlocks.ORANGE_LEAVES.get());
        registerFruitLogModels(blockStateModelGenerator, BFBlocks.STRIPPED_ORANGE_LOG.get(), BFBlocks.STRIPPED_ORANGE_WOOD.get());
        registerFruitLogModels(blockStateModelGenerator, BFBlocks.LEMON_LOG.get(), BFBlocks.LEMON_WOOD.get(), BFBlocks.LEMON_LEAVES.get());
        registerFruitLogModels(blockStateModelGenerator, BFBlocks.STRIPPED_LEMON_LOG.get(), BFBlocks.STRIPPED_LEMON_WOOD.get());
        registerFruitLogModels(blockStateModelGenerator, BFBlocks.PLUM_LOG.get(), BFBlocks.PLUM_WOOD.get(), BFBlocks.PLUM_LEAVES.get());
        registerFruitLogModels(blockStateModelGenerator, BFBlocks.STRIPPED_PLUM_LOG.get(), BFBlocks.STRIPPED_PLUM_WOOD.get());
        registerFruitLogModels(blockStateModelGenerator, BFBlocks.PALM_LOG.get(), BFBlocks.PALM_WOOD.get());
        registerFruitLogModels(blockStateModelGenerator, BFBlocks.STRIPPED_PALM_LOG.get(), BFBlocks.STRIPPED_PALM_WOOD.get());
        registerFruitLogModels(blockStateModelGenerator, BFBlocks.GOLDEN_APPLE_LOG.get(), BFBlocks.GOLDEN_APPLE_WOOD.get(), BFBlocks.GOLDEN_APPLE_LEAVES.get());

        blockStateModelGenerator.woodProvider(BFBlocks.WALNUT_LOG.get()).logWithHorizontal(BFBlocks.WALNUT_LOG.get()).wood(BFBlocks.WALNUT_WOOD.get());
        blockStateModelGenerator.woodProvider(BFBlocks.STRIPPED_WALNUT_LOG.get()).logWithHorizontal(BFBlocks.STRIPPED_WALNUT_LOG.get()).wood(BFBlocks.STRIPPED_WALNUT_WOOD.get());
        blockStateModelGenerator.createTrivialBlock(BFBlocks.WALNUT_LEAVES.get(), TexturedModel.LEAVES);
        blockStateModelGenerator.createTrivialBlock(BFBlocks.GOLDEN_APPLE_LEAVES.get(), TexturedModel.LEAVES);
        blockStateModelGenerator.createTrivialBlock(BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES.get(), TexturedModel.LEAVES);
        BlockModelGenerators.BlockFamilyProvider walnutTexturePool = blockStateModelGenerator.family(BFBlocks.WALNUT_PLANKS.get());
        walnutTexturePool.stairs(BFBlocks.WALNUT_STAIRS.get());
        walnutTexturePool.slab(BFBlocks.WALNUT_SLAB.get());
        walnutTexturePool.fence(BFBlocks.WALNUT_FENCE.get());
        walnutTexturePool.fenceGate(BFBlocks.WALNUT_FENCE_GATE.get());
        walnutTexturePool.pressurePlate(BFBlocks.WALNUT_PRESSURE_PLATE.get());
        walnutTexturePool.button(BFBlocks.WALNUT_BUTTON.get());
        blockStateModelGenerator.createHangingSign(BFBlocks.STRIPPED_WALNUT_LOG.get(), BFBlocks.WALNUT_HANGING_SIGN.get(), BFBlocks.WALNUT_WALL_HANGING_SIGN.get());
        blockStateModelGenerator.createDoor(BFBlocks.WALNUT_DOOR.get());
        blockStateModelGenerator.createTrivialCube(BFBlocks.CUT_FELDSPAR_BLOCK.get());
        BlockModelGenerators.BlockFamilyProvider feldsparTexturePool = blockStateModelGenerator.family(BFBlocks.FELDSPAR_BRICKS.get());
        feldsparTexturePool.stairs(BFBlocks.FELDSPAR_BRICK_STAIRS.get());
        feldsparTexturePool.slab(BFBlocks.FELDSPAR_BRICK_SLAB.get());

        BlockModelGenerators.BlockFamilyProvider coirBrickTexturePool = blockStateModelGenerator.family(BFBlocks.COIR_BRICKS.get());
        coirBrickTexturePool.stairs(BFBlocks.COIR_BRICK_STAIRS.get());
        coirBrickTexturePool.slab(BFBlocks.COIR_BRICK_SLAB.get());
        coirBrickTexturePool.wall(BFBlocks.COIR_BRICK_WALL.get());
        blockStateModelGenerator.createFullAndCarpetBlocks(BFBlocks.PACKED_COCONUT_COIR.get(), BFBlocks.COIR_CARPET.get());

        blockStateModelGenerator.createPlant(BFBlocks.GOLDEN_APPLE_SAPLING.get(), BFBlocks.POTTED_GOLDEN_APPLE_SAPLING.get(), BlockModelGenerators.TintState.NOT_TINTED);

        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.RED_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.ORANGE_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.YELLOW_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.LIME_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.GREEN_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.CYAN_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.LIGHT_BLUE_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.BLUE_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.PURPLE_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.MAGENTA_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.PINK_JACK_O_STRAW.get());
        registerUnlitableJackOStrawModels(blockStateModelGenerator, BFBlocks.BROWN_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.WHITE_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.LIGHT_GRAY_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.GRAY_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.BLACK_JACK_O_STRAW.get());

        registerJackOStrawModels(blockStateModelGenerator, DelicateDyesBlocks.CORAL_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, DelicateDyesBlocks.CANARY_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, DelicateDyesBlocks.WASABI_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, DelicateDyesBlocks.SACRAMENTO_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, DelicateDyesBlocks.SKY_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, DelicateDyesBlocks.BLURPLE_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, DelicateDyesBlocks.SANGRIA_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, DelicateDyesBlocks.ROSE_JACK_O_STRAW.get());

        registerPicketsModels(blockStateModelGenerator, BFBlocks.OAK_PICKETS.get());
        registerPicketsModels(blockStateModelGenerator, BFBlocks.SPRUCE_PICKETS.get());
        registerPicketsModels(blockStateModelGenerator, BFBlocks.BIRCH_PICKETS.get());
        registerPicketsModels(blockStateModelGenerator, BFBlocks.JUNGLE_PICKETS.get());
        registerPicketsModels(blockStateModelGenerator, BFBlocks.ACACIA_PICKETS.get());
        registerPicketsModels(blockStateModelGenerator, BFBlocks.DARK_OAK_PICKETS.get());
        registerPicketsModels(blockStateModelGenerator, BFBlocks.MANGROVE_PICKETS.get());
        registerPicketsModels(blockStateModelGenerator, BFBlocks.CHERRY_PICKETS.get());
        registerPicketsModels(blockStateModelGenerator, BFBlocks.BAMBOO_PICKETS.get());
        registerPicketsModels(blockStateModelGenerator, BFBlocks.HOARY_PICKETS.get());
        registerPicketsModels(blockStateModelGenerator, BFBlocks.WALNUT_PICKETS.get());
        registerPicketsModels(blockStateModelGenerator, BFBlocks.CRIMSON_PICKETS.get());
        registerPicketsModels(blockStateModelGenerator, BFBlocks.WARPED_PICKETS.get());
        registerPicketsModels(blockStateModelGenerator, BFBlocks.IRON_RAILING.get());
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.ASPEN_PICKETS.get());
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.CEDAR_PICKETS.get());
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.COCONUT_PICKETS.get());
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.CYPRESS_PICKETS.get());
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.FIR_PICKETS.get());
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.GHAF_PICKETS.get());
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.JOSHUA_PICKETS.get());
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.LARCH_PICKETS.get());
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.MAHOGANY_PICKETS.get());
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.MAPLE_PICKETS.get());
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.OLIVE_PICKETS.get());
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.PALO_VERDE_PICKETS.get());
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.REDWOOD_PICKETS.get());
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.SAXAUL_PICKETS.get());
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.SUGI_PICKETS.get());
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.WILLOW_PICKETS.get());
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.WISTERIA_PICKETS.get());
        registerPicketsModels(blockStateModelGenerator, SpawnBlocks.ROTTEN_PICKETS.get());
        registerPicketsModels(blockStateModelGenerator, ArtsAndCraftsBlocks.CORK_PICKETS.get());
        registerPicketsModels(blockStateModelGenerator, DungeonsDelightBlocks.WORMWOOD_PICKETS.get());

//        for (TrellisVariant trellis : TrellisVariants.TrellisVariants) {
//            if (Objects.equals(trellis.getId(), BountifulFares.MOD_ID)) {
//                ModTemplateModels.registerTrellis(blockStateModelGenerator, TrellisUtilProvider.getTrellisFromVariant(trellis));
//                for (VineCrop crop : TrellisVariants.VineCrops) {
//                    ModTemplateModels.registerCropTrellis(blockStateModelGenerator,
//                            TrellisUtilProvider.getCropTrellisFromVariant(trellis, crop),
//                            trellis.getTrellisName(),
//                            crop.getName() + "_trellis_vines",
//                            crop.getName() + "_trellis_foliage",
//                            trellis.getId());
//                }
//                for (DecorativeVine vine : TrellisVariants.DecorativeVines) {
//                    if (vine != ModTrellises.TWISTING) {
//                        ModTemplateModels.registerDecorTrellis(blockStateModelGenerator,
//                                TrellisUtilProvider.getDecorTrellisFromVariant(trellis, vine),
//                                trellis.getTrellisName(),
//                                vine.getName() + "_trellis_vines",
//                                vine.getName() + "_trellis_foliage",
//                                trellis.getId());
//                    } else {
//                        ModTemplateModels.registerUpsideDownDecorTrellis(blockStateModelGenerator,
//                                TrellisUtilProvider.getDecorTrellisFromVariant(trellis, vine),
//                                trellis.getTrellisName(),
//                                vine.getName() + "_trellis_vines",
//                                vine.getName() + "_trellis_foliage",
//                                trellis.getId());
//                    }
//                }
//            }
//        }
        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, BFTrellises.OAK);
        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, BFTrellises.SPRUCE);
        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, BFTrellises.BIRCH);
        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, BFTrellises.JUNGLE);
        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, BFTrellises.ACACIA);
        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, BFTrellises.DARK_OAK);
        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, BFTrellises.MANGROVE);
        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, BFTrellises.CHERRY);
        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, BFTrellises.BAMBOO);
        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, BFTrellises.WALNUT);
        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, BFTrellises.HOARY);
        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, BFTrellises.CRIMSON);
        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, BFTrellises.WARPED);

//        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, BFTrellises.BAOBAB);
//        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, BFTrellises.WW_CYPRESS);
//        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, BFTrellises.PALM);

        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, ExcessiveBuildingBlocks.ANCIENT);
        BlockModelGenerators.BlockFamilyProvider walnutMulchBrickPool = blockStateModelGenerator.family(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICKS.get());
        walnutMulchBrickPool.stairs(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICK_STAIRS.get());
        walnutMulchBrickPool.slab(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICK_SLAB.get());
        walnutMulchBrickPool.wall(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICK_WALL.get());
        blockStateModelGenerator.delegateItemModel(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICKS.get(), ResourceLocation.tryBuild(BountifulFares.EXCESSIVE_BUILDING_MOD_ID, "block/walnut_mulch_bricks"));
        BlockModelGenerators.BlockFamilyProvider palmMulchBrickPool = blockStateModelGenerator.family(ExcessiveBuildingBlocks.PALM_MULCH_BRICKS.get());
        palmMulchBrickPool.stairs(ExcessiveBuildingBlocks.PALM_MULCH_BRICK_STAIRS.get());
        palmMulchBrickPool.slab(ExcessiveBuildingBlocks.PALM_MULCH_BRICK_SLAB.get());
        palmMulchBrickPool.wall(ExcessiveBuildingBlocks.PALM_MULCH_BRICK_WALL.get());
        blockStateModelGenerator.delegateItemModel(ExcessiveBuildingBlocks.PALM_MULCH_BRICKS.get(), ResourceLocation.tryBuild(BountifulFares.EXCESSIVE_BUILDING_MOD_ID, "block/palm_mulch_bricks"));

        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, MintBlocks.WINTERGREEN);

        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, SpawnBlocks.ROTTEN);

        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.ASPEN);
        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.CEDAR);
        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.COCONUT);
        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.CYPRESS);
        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.FIR);
        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.GHAF);
        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.JOSHUA);
        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.LARCH);
        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.MAHOGANY);
        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.MAPLE);
        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.OLIVE);
        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.PALO_VERDE);
        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.REDWOOD);
        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.SAXAUL);
        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.SUGI);
        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.WILLOW);
        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.WISTERIA);

        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, ArtsAndCraftsBlocks.CORK);

        TrellisUtilProvider.registerTrellisModels(blockStateModelGenerator, DungeonsDelightBlocks.WORMWOOD);
    }

    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(BFItems.LEEK.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.LEEK_SEEDS.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.LEEK_STEW.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.CRUSTED_BEEF.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.WALNUT.get(), ModelTemplates.FLAT_ITEM);
        // itemModelGenerator.generateFlatItem(BFItems.WALNUT_BOAT.get(), ModelTemplates.FLAT_ITEM);
        // itemModelGenerator.generateFlatItem(BFItems.WALNUT_CHEST_BOAT.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFBlocks.WILD_PASSION_FRUIT_VINE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFBlocks.WILD_ELDERBERRY_VINE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.FISH_STEW.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.APPLE_STEW.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.STONE_STEW.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.FOREST_MEDLEY.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.ARID_MEDLEY.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.MEADOW_MEDLEY.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.COASTAL_MEDLEY.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.BERRY_STUFFED_POTATO.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.MAIZE_STUFFED_POTATO.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.MAIZE_BREAD.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.WALNUT_COOKIE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.CUSTARD.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.PIQUANT_CUSTARD.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.PASSION_CUSTARD.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.COCOA_CUSTARD.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.ANCIENT_CUSTARD.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.CANDIED_APPLE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.CANDIED_PLUM.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.GRASS_SEEDS.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.SCORCHKIN_SEEDS.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.PALM_FROND.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.COCONUT.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.COCONUT_COIR.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.COCONUT_HALF.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.COCONUT_STEW.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.COCONUT_CRUSTED_COD.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFBlocks.COCONUT_CANDLE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.DIRT_STEW.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.PICKLED_SPONGEKIN.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.TROPICAL_MEDLEY.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.SWEET_BERRY_PIPS.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.SEA_SALAD.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.STUFFED_HOARY_APPLE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.MIRE_MEDLEY.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.STRANGE_CANDY.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.COCONUT_MILK_BOTTLE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFBlocks.MELON_PIE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFBlocks.SPONGE_CAKE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.POPPED_MAIZE.get(), ModelTemplates.FLAT_ITEM);
    }

    @Override
    public @NotNull CompletableFuture<?> run(@NotNull CachedOutput pOutput) {
        Map<Block, BlockStateGenerator> map = Maps.newHashMap();
        Consumer<BlockStateGenerator> consumer = (p_125120_) -> {
            Block block = p_125120_.getBlock();
            BlockStateGenerator blockstategenerator = map.put(block, p_125120_);
            if (blockstategenerator != null) {
                throw new IllegalStateException("Duplicate blockstate definition for " + block);
            }
        };
        Map<ResourceLocation, Supplier<JsonElement>> map1 = Maps.newHashMap();
        Set<Item> set = Sets.newHashSet();
        BiConsumer<ResourceLocation, Supplier<JsonElement>> biconsumer = (p_125123_, p_125124_) -> {
            Supplier<JsonElement> supplier = map1.put(p_125123_, p_125124_);
            if (supplier != null) {
                throw new IllegalStateException("Duplicate model definition for " + p_125123_);
            }
        };
        Consumer<Item> consumer1 = set::add;

        // refer from ModelProvider
        generateBlockStateModels(new BlockModelGenerators(consumer, biconsumer, consumer1));
        generateItemModels(new ItemModelGenerators(biconsumer));


        // (new BlockModelGenerators(consumer, biconsumer, consumer1)).run();
        // (new ItemModelGenerators(biconsumer)).run();
        List<Block> list = BuiltInRegistries.BLOCK.stream().filter((p_125117_) -> {
            return !map.containsKey(p_125117_);
        }).toList();
        if (!list.isEmpty()) {
            throw new IllegalStateException("Missing blockstate definitions for: " + list);
        } else {
            BuiltInRegistries.BLOCK.forEach((p_125128_) -> {
                Item item = Item.BY_BLOCK.get(p_125128_);
                if (item != null) {
                    if (set.contains(item)) {
                        return;
                    }

                    ResourceLocation resourcelocation = ModelLocationUtils.getModelLocation(item);
                    if (!map1.containsKey(resourcelocation)) {
                        map1.put(resourcelocation, new DelegatedModel(ModelLocationUtils.getModelLocation(p_125128_)));
                    }
                }

            });
            return CompletableFuture.allOf(this.saveCollection(pOutput, map, (p_248016_) -> {
                return this.blockStatePathProvider.json(p_248016_.builtInRegistryHolder().key().location());
            }), this.saveCollection(pOutput, map1, this.modelPathProvider::json));
        }
    }

    @Override
    public String getName() {
        return BountifulFares.MOD_ID + " " + "Model";
    }

    private <T> CompletableFuture<?> saveCollection(CachedOutput pOutput, Map<T, ? extends Supplier<JsonElement>> pObjectToJsonMap, Function<T, Path> pResolveObjectPath) {
        return CompletableFuture.allOf(pObjectToJsonMap.entrySet().stream().map((p_253408_) -> {
            Path path = pResolveObjectPath.apply(p_253408_.getKey());
            JsonElement jsonelement = p_253408_.getValue().get();
            return DataProvider.saveStable(pOutput, jsonelement, path);
        }).toArray((p_253409_) -> {
            return new CompletableFuture[p_253409_];
        }));
    }
}
