package net.hecco.bountifulfares.registry.util;

import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.Reference2IntMap;
import it.unimi.dsi.fastutil.objects.Reference2IntOpenHashMap;
// import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
// import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.compat.dye_depot.DyeDepotBlocks;
import net.hecco.bountifulfares.compat.excessive_building.ExcessiveBuildingBlocks;
import net.hecco.bountifulfares.compat.mint.MintBlocks;
import net.hecco.bountifulfares.entity.FlourProjectileEntity;
import net.hecco.bountifulfares.mixin.util.BrewingRecipeRegistryMixin;
import net.hecco.bountifulfares.mixin.util.FireBlockAccessor;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.content.BFPotions;
import net.hecco.bountifulfares.registry.tags.BFBlockTags;
import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.minecraft.core.BlockSource;
import net.minecraft.core.Holder;
import net.minecraft.core.Position;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.FireBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.event.TagsUpdatedEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.loading.FMLLoader;

import java.util.*;

// import static net.fabricmc.fabric.api.registry.StrippableBlockRegistry.register;
import static net.minecraft.world.level.block.ComposterBlock.COMPOSTABLES;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BFRegistries {

    public static final Reference2IntMap<Item> fuel_items = new Reference2IntOpenHashMap<>();
    public static final List<Pair<TagKey<Item>, Integer>> fuel_item_tags = new ArrayList<>();
    public static final Map<Block, Pair<Integer, Integer>> flam_blocks = new IdentityHashMap<>();
    public static final Map<Block, Pair<Integer, Integer>> flam_blocks_from_tag = new IdentityHashMap<>();
    public static final List<Pair<TagKey<Block>, Pair<Integer, Integer>>> flam_block_tags = new ArrayList<>();
    public static final Map<Block, Block> stripple_blocks = new IdentityHashMap<>();

    @SubscribeEvent
    public static void setFuels(FurnaceFuelBurnTimeEvent event) {
        int anInt = fuel_items.getInt(event.getItemStack().getItem());
        if (anInt > 0) {
            event.setBurnTime(anInt);
            return;
        } else {
            for (Pair<TagKey<Item>, Integer> fuelItemTag : fuel_item_tags) {
                if (event.getItemStack().is(fuelItemTag.getFirst())) {
                    event.setBurnTime(fuelItemTag.getSecond());
                    return;
                }
            }
        }
    }

    @SubscribeEvent
    public static void setAxe(BlockEvent.BlockToolModificationEvent event) {
        if (event.getToolAction() == ToolActions.AXE_STRIP) {
            Block orDefault = stripple_blocks.getOrDefault(event.getState().getBlock(), null);
            if (orDefault != null) {
                event.setFinalState(orDefault.defaultBlockState());
            }
        }
    }

    @SubscribeEvent
    public static void setFireBlock(TagsUpdatedEvent event) {
        if (FMLLoader.getDist() == Dist.DEDICATED_SERVER
                || event.getUpdateCause() == TagsUpdatedEvent.UpdateCause.CLIENT_PACKET_RECEIVED) {
            FireBlockAccessor fireBlockAccessor = (FireBlockAccessor) (Blocks.FIRE);
            flam_blocks.forEach((block, integerIntegerPair) -> {
                if (fireBlockAccessor.getBurnOdds().getInt(block) < 1) {
                    fireBlockAccessor.getIgniteOdds().put(block, integerIntegerPair.getFirst().intValue());
                    fireBlockAccessor.getBurnOdds().put(block, integerIntegerPair.getSecond().intValue());
                }
            });
            flam_blocks_from_tag.forEach((block, integerIntegerPair) -> {
                fireBlockAccessor.getIgniteOdds().removeInt(block);
                fireBlockAccessor.getBurnOdds().removeInt(block);
            });
            flam_blocks_from_tag.clear();
            Registry<Block> registry = event.getRegistryAccess().registryOrThrow(Registries.BLOCK);
            for (Pair<TagKey<Block>, Pair<Integer, Integer>> flamBlockTag : flam_block_tags) {
                registry.getTag(flamBlockTag.getFirst()).ifPresent(
                        blocks -> {
                            for (Holder<Block> block : blocks) {
                                flam_blocks_from_tag.put(block.value(), flamBlockTag.getSecond());
                            }
                        }
                );
            }
            flam_blocks_from_tag.forEach((block, integerIntegerPair) -> {
                if (fireBlockAccessor.getBurnOdds().getInt(block) < 1) {
                    fireBlockAccessor.getIgniteOdds().put(block, integerIntegerPair.getFirst().intValue());
                    fireBlockAccessor.getBurnOdds().put(block, integerIntegerPair.getSecond().intValue());
                }
            });
        }
    }


    public static void RegisterModStuffs(FMLCommonSetupEvent fmlCommonSetupEvent) {
        fmlCommonSetupEvent.enqueueWork(() -> {

            // ------------------patch
            BFBlocks._CROPS_TO_CROP_TRELLISES.forEach((optional, trellisBlock) -> BFBlocks.CROPS_TO_CROP_TRELLISES.put(optional.orElse(Items.AIR), trellisBlock));
            BFBlocks._CROPS_TO_VINE_CROPS.forEach((supplier, vineCrop) -> BFBlocks.CROPS_TO_VINE_CROPS.put(supplier.get(), vineCrop));
            //-------------

            registerBrewingRecipe();
            registerStrippables();
            registerCeramicCheckeredConversions();
            registerFuels();
            registerModCompostables();
            registerFermentationRecipes();
            registerFlammables();
            DispenserBlock.registerBehavior(BFItems.FLOUR.get(), new FlourDispenserBehavior() {
                @Override
                protected Projectile createProjectile(Level world, Position position, ItemStack stack) {
                    return new FlourProjectileEntity(world, position.x(), position.y(), position.z());
                }
            });
            DispenserBlock.registerBehavior(BFItems.GRASS_SEEDS.get(), new GrassSeedsDispenserBehavior() {
                @Override
                public ItemStack execute(BlockSource pointer, ItemStack stack) {
                    return super.execute(pointer, stack);
                }
            });
        });
    }

    public static void registerBrewingRecipe() {
        BrewingRecipeRegistryMixin.addMix(Potions.AWKWARD, BFItems.CITRUS_ESSENCE.get(), BFPotions.ACIDIC);
        BrewingRecipeRegistryMixin.addMix(BFPotions.ACIDIC, Items.REDSTONE, BFPotions.LONG_ACIDIC);
        BrewingRecipeRegistryMixin.addMix(BFPotions.ACIDIC, Items.GLOWSTONE_DUST, BFPotions.STRONG_ACIDIC);
        BrewingRecipeRegistryMixin.addMix(BFPotions.ACIDIC, Items.FERMENTED_SPIDER_EYE, BFPotions.STUPOR);
        BrewingRecipeRegistryMixin.addMix(BFPotions.LONG_ACIDIC, Items.FERMENTED_SPIDER_EYE, BFPotions.LONG_STUPOR);
        BrewingRecipeRegistryMixin.addMix(BFPotions.STUPOR, Items.REDSTONE, BFPotions.LONG_STUPOR);
    }

    public static void registerFermentationRecipes() {
//        FermentationRecipes.addRecipe(BFItems.ELDERBERRIES.get(), null, BFItems.ELDERBERRY_WINE_BOTTLE.get(), Items.GLASS_BOTTLE, null, 13803457);
//        FermentationRecipes.addRecipe(BFItems.LAPISBERRIES.get(), null, BFItems.LAPISBERRY_WINE_BOTTLE.get(), Items.GLASS_BOTTLE, null, 11512561);
//        FermentationRecipes.addRecipe(Items.HONEY_BOTTLE, Items.GLASS_BOTTLE, BFItems.MEAD_BOTTLE.get(), Items.GLASS_BOTTLE, null, 16774088);
//        FermentationRecipes.addRecipe(Items.APPLE, null, BFItems.APPLE_CIDER_JAR.get(), BFItems.JAR.get(), null, 16771237);
//        FermentationRecipes.addRecipe(BFItems.PLUM.get(), null, BFItems.PLUM_CIDER_JAR.get(), BFItems.JAR.get(), null, 14532546);
//        FermentationRecipes.addRecipe(BFItems.HOARY_APPLE.get(), null, BFItems.HOARY_CIDER_JAR.get(), BFItems.JAR.get(), null, 15714738);
//        FermentationRecipes.addRecipe(BFItems.ORANGE.get(), null, BFItems.CITRUS_ESSENCE.get(), null, 4, 15200149);
//        FermentationRecipes.addRecipe(BFItems.LEMON.get(), null, BFItems.CITRUS_ESSENCE.get(), null, 4, 15200149);
//        FermentationRecipes.addRecipe(Items.SPIDER_EYE, null, Items.FERMENTED_SPIDER_EYE, null, null, 10250865);
    }


    public static void registerFuels() {
        // FuelRegistry registry = FuelRegistry.INSTANCE;

        addToMap(BFItemTags.FRUIT_LOGS, 200);
        addToMap(BFItemTags.HOARY_LOGS, 300);
        addToMap(BFItemTags.WALNUT_LOGS, 300);
        addToMap(BFItemTags.PICKETS, 200);
        for (TrellisVariant trellis : TrellisUtil.TrellisVariants) {
            if (!(Objects.equals(trellis.getBlockName(), "warped_trellis") || Objects.equals(trellis.getBlockName(), "crimson_trellis")))
                addToMap(TrellisUtil.getTrellisFromVariant(trellis).get(), 300);
        }
        addToMap(BFBlocks.GRISTMILL.get(), 300);
        addToMap(BFBlocks.WHITE_JACK_O_STRAW.get(), 400);
        addToMap(BFBlocks.LIGHT_GRAY_JACK_O_STRAW.get(), 400);
        addToMap(BFBlocks.GRAY_JACK_O_STRAW.get(), 400);
        addToMap(BFBlocks.BLACK_JACK_O_STRAW.get(), 400);
        addToMap(BFBlocks.BROWN_JACK_O_STRAW.get(), 400);
        addToMap(BFBlocks.RED_JACK_O_STRAW.get(), 400);
        addToMap(BFBlocks.ORANGE_JACK_O_STRAW.get(), 400);
        addToMap(BFBlocks.YELLOW_JACK_O_STRAW.get(), 400);
        addToMap(BFBlocks.LIME_JACK_O_STRAW.get(), 400);
        addToMap(BFBlocks.GREEN_JACK_O_STRAW.get(), 400);
        addToMap(BFBlocks.CYAN_JACK_O_STRAW.get(), 400);
        addToMap(BFBlocks.LIGHT_BLUE_JACK_O_STRAW.get(), 400);
        addToMap(BFBlocks.BLUE_JACK_O_STRAW.get(), 400);
        addToMap(BFBlocks.PURPLE_JACK_O_STRAW.get(), 400);
        addToMap(BFBlocks.MAGENTA_JACK_O_STRAW.get(), 400);
        addToMap(BFBlocks.PINK_JACK_O_STRAW.get(), 400);
        addToMap(BFBlocks.PALM_FROND.get(), 100);
        addToMap(BFItems.COCONUT_COIR.get(), 100);
        addToMap(BFBlocks.PACKED_COCONUT_COIR.get(), 400);
        addToMap(BFBlocks.COIR_CARPET.get(), 200);
        addToMap(BFBlocks.COIR_BRICKS.get(), 400);
        addToMap(BFBlocks.COIR_BRICK_SLAB.get(), 400);
        addToMap(BFBlocks.COIR_BRICK_STAIRS.get(), 400);
        addToMap(BFBlocks.COIR_BRICK_WALL.get(), 400);
        addToMap(MintBlocks.ACORN_JACK_O_STRAW.get(), 400);
        addToMap(MintBlocks.AMBER_JACK_O_STRAW.get(), 400);
        addToMap(MintBlocks.ARTICHOKE_JACK_O_STRAW.get(), 400);
        addToMap(MintBlocks.BANANA_JACK_O_STRAW.get(), 400);
        addToMap(MintBlocks.CERULEAN_JACK_O_STRAW.get(), 400);
        addToMap(MintBlocks.FUCHSIA_JACK_O_STRAW.get(), 400);
        addToMap(MintBlocks.GRAPE_JACK_O_STRAW.get(), 400);
        addToMap(MintBlocks.INDIGO_JACK_O_STRAW.get(), 400);
        addToMap(MintBlocks.MAROON_JACK_O_STRAW.get(), 400);
        addToMap(MintBlocks.MAUVE_JACK_O_STRAW.get(), 400);
        addToMap(MintBlocks.MINT_JACK_O_STRAW.get(), 400);
        addToMap(MintBlocks.MOLD_JACK_O_STRAW.get(), 400);
        addToMap(MintBlocks.NAVY_JACK_O_STRAW.get(), 400);
        addToMap(MintBlocks.PEACH_JACK_O_STRAW.get(), 400);
        addToMap(MintBlocks.PERIWINKLE_JACK_O_STRAW.get(), 400);
        addToMap(MintBlocks.SAGE_JACK_O_STRAW.get(), 400);
        addToMap(MintBlocks.SAP_JACK_O_STRAW.get(), 400);
        addToMap(MintBlocks.SHAMROCK_JACK_O_STRAW.get(), 400);
        addToMap(MintBlocks.VELVET_JACK_O_STRAW.get(), 400);
        addToMap(MintBlocks.VERMILION_JACK_O_STRAW.get(), 400);
        addToMap(DyeDepotBlocks.MAROON_JACK_O_STRAW.get(), 400);
        addToMap(DyeDepotBlocks.ROSE_JACK_O_STRAW.get(), 400);
        addToMap(DyeDepotBlocks.CORAL_JACK_O_STRAW.get(), 400);
        addToMap(DyeDepotBlocks.GINGER_JACK_O_STRAW.get(), 400);
        addToMap(DyeDepotBlocks.TAN_JACK_O_STRAW.get(), 400);
        addToMap(DyeDepotBlocks.BEIGE_JACK_O_STRAW.get(), 400);
        addToMap(DyeDepotBlocks.AMBER_JACK_O_STRAW.get(), 400);
        addToMap(DyeDepotBlocks.OLIVE_JACK_O_STRAW.get(), 400);
        addToMap(DyeDepotBlocks.FOREST_JACK_O_STRAW.get(), 400);
        addToMap(DyeDepotBlocks.VERDANT_JACK_O_STRAW.get(), 400);
        addToMap(DyeDepotBlocks.TEAL_JACK_O_STRAW.get(), 400);
        addToMap(DyeDepotBlocks.MINT_JACK_O_STRAW.get(), 400);
        addToMap(DyeDepotBlocks.AQUA_JACK_O_STRAW.get(), 400);
        addToMap(DyeDepotBlocks.SLATE_JACK_O_STRAW.get(), 400);
        addToMap(DyeDepotBlocks.NAVY_JACK_O_STRAW.get(), 400);
        addToMap(DyeDepotBlocks.INDIGO_JACK_O_STRAW.get(), 400);
        addToMap(ExcessiveBuildingBlocks.WALNUT_VERTICAL_STAIRS.get(), 300);
        addToMap(ExcessiveBuildingBlocks.CHISELED_WALNUT_PLANKS.get(), 300);
        addToMap(ExcessiveBuildingBlocks.WALNUT_MOSAIC.get(), 300);
        addToMap(ExcessiveBuildingBlocks.WALNUT_MOSAIC_SLAB.get(), 300);
        addToMap(ExcessiveBuildingBlocks.WALNUT_MOSAIC_STAIRS.get(), 300);
        addToMap(ExcessiveBuildingBlocks.WALNUT_MOSAIC_VERTICAL_STAIRS.get(), 300);
        addToMap(ExcessiveBuildingBlocks.WALNUT_LADDER.get(), 300);
        addToMap(ExcessiveBuildingBlocks.HOARY_VERTICAL_STAIRS.get(), 300);
        addToMap(ExcessiveBuildingBlocks.CHISELED_HOARY_PLANKS.get(), 300);
        addToMap(ExcessiveBuildingBlocks.HOARY_MOSAIC.get(), 300);
        addToMap(ExcessiveBuildingBlocks.HOARY_MOSAIC_SLAB.get(), 300);
        addToMap(ExcessiveBuildingBlocks.HOARY_MOSAIC_STAIRS.get(), 300);
        addToMap(ExcessiveBuildingBlocks.HOARY_MOSAIC_VERTICAL_STAIRS.get(), 300);
        addToMap(ExcessiveBuildingBlocks.HOARY_LADDER.get(), 300);

    }

    private static void addToMap(TagKey<Item> itemTagKey, int i) {
        fuel_item_tags.add(Pair.of(itemTagKey, i));
    }

    private static void addToMap(ItemLike block, int i) {
        fuel_items.put(block.asItem(), i);
    }

    private static void addToFlammableMap(TagKey<Block> blockTagKey, int encouragement, int flammability) {
        flam_block_tags.add(Pair.of(blockTagKey, Pair.of(encouragement, flammability)));
    }

    private static void addToFlammableMap(Block block, int encouragement, int flammability) {
        flam_blocks.put(block, Pair.of(encouragement, flammability));
    }

    public static void registerFlammables() {
        // FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();
        addToFlammableMap(BFBlockTags.APPLE_LEAVES, 60, 30);
        addToFlammableMap(BFBlockTags.ORANGE_LEAVES, 60, 30);
        addToFlammableMap(BFBlockTags.LEMON_LEAVES, 60, 30);
        addToFlammableMap(BFBlockTags.PLUM_LEAVES, 60, 30);
        addToFlammableMap(BFBlocks.HOARY_LEAVES.get(), 60, 30);
        addToFlammableMap(BFBlocks.PALM_FROND.get(), 60, 30);
        addToFlammableMap(BFBlocks.WALL_PALM_FROND.get(), 60, 30);
        addToFlammableMap(BFBlockTags.APPLE_LOGS, 10, 5);
        addToFlammableMap(BFBlockTags.ORANGE_LOGS, 10, 5);
        addToFlammableMap(BFBlockTags.LEMON_LOGS, 10, 5);
        addToFlammableMap(BFBlockTags.PLUM_LOGS, 10, 5);
        addToFlammableMap(BFBlocks.PALM_CROWN.get(), 10, 5);
        addToFlammableMap(BFBlockTags.PALM_LOGS, 10, 5);
        addToFlammableMap(BFBlockTags.HOARY_LOGS, 10, 5);
        addToFlammableMap(BFBlockTags.WALNUT_LOGS, 10, 5);
        addToFlammableMap(BFBlocks.HOARY_PLANKS.get(), 10, 5);
        addToFlammableMap(BFBlocks.HOARY_STAIRS.get(), 10, 5);
        addToFlammableMap(BFBlocks.HOARY_SLAB.get(), 20, 5);
        addToFlammableMap(BFBlocks.HOARY_FENCE.get(), 20, 5);
        addToFlammableMap(BFBlocks.HOARY_FENCE_GATE.get(), 20, 5);
        addToFlammableMap(BFBlocks.HOARY_DOOR.get(), 20, 5);
        addToFlammableMap(BFBlocks.HOARY_TRAPDOOR.get(), 20, 5);
        addToFlammableMap(BFBlocks.WALNUT_PLANKS.get(), 10, 5);
        addToFlammableMap(BFBlocks.WALNUT_STAIRS.get(), 10, 5);
        addToFlammableMap(BFBlocks.WALNUT_SLAB.get(), 20, 5);
        addToFlammableMap(BFBlocks.WALNUT_FENCE.get(), 20, 5);
        addToFlammableMap(BFBlocks.WALNUT_FENCE_GATE.get(), 20, 5);
        addToFlammableMap(BFBlocks.WALNUT_DOOR.get(), 20, 5);
        addToFlammableMap(BFBlocks.WALNUT_TRAPDOOR.get(), 20, 5);
        addToFlammableMap(BFBlocks.WALNUT_MULCH.get(), 60, 30);
        addToFlammableMap(BFBlocks.WALNUT_MULCH_BLOCK.get(), 20, 30);
        addToFlammableMap(BFBlocks.PALM_MULCH.get(), 60, 30);
        addToFlammableMap(BFBlocks.PALM_MULCH_BLOCK.get(), 20, 30);
        addToFlammableMap(BFBlockTags.PICKETS, 20, 5);
    }

    public static void registerCeramicCheckeredConversions() {
        registerCheckeredCeramic(BFBlocks.CERAMIC_TILES.get(), BFBlocks.CHECKERED_CERAMIC_TILES.get());
        registerCheckeredCeramic(BFBlocks.CERAMIC_TILE_STAIRS.get(), BFBlocks.CHECKERED_CERAMIC_TILE_STAIRS.get());
        registerCheckeredCeramic(BFBlocks.CERAMIC_TILE_SLAB.get(), BFBlocks.CHECKERED_CERAMIC_TILE_SLAB.get());
        registerCheckeredCeramic(BFBlocks.CRACKED_CERAMIC_TILES.get(), BFBlocks.CRACKED_CHECKERED_CERAMIC_TILES.get());
        registerCheckeredCeramic(BFBlocks.CERAMIC_MOSAIC.get(), BFBlocks.CHECKERED_CERAMIC_MOSAIC.get());
        registerCheckeredCeramic(BFBlocks.CERAMIC_MOSAIC_STAIRS.get(), BFBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS.get());
        registerCheckeredCeramic(BFBlocks.CERAMIC_MOSAIC_SLAB.get(), BFBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB.get());
        if (BountifulFares.isModLoaded(BountifulFares.EXCESSIVE_BUILDING_MOD_ID)) {
            registerCheckeredCeramic(ExcessiveBuildingBlocks.CERAMIC_TILE_VERTICAL_STAIRS.get(), ExcessiveBuildingBlocks.CHECKERED_CERAMIC_TILE_VERTICAL_STAIRS.get());
            registerCheckeredCeramic(ExcessiveBuildingBlocks.CERAMIC_MOSAIC_VERTICAL_STAIRS.get(), ExcessiveBuildingBlocks.CHECKERED_CERAMIC_MOSAIC_VERTICAL_STAIRS.get());
        }
    }

    public static void registerCheckeredCeramic(Block normal, Block checkered) {
        BFBlocks.CERAMIC_TO_CHECKERED_CERAMIC.put(normal, checkered);
        BFBlocks.CERAMIC_TO_CHECKERED_CERAMIC.put(checkered, normal);
    }

    public static void registerStrippables() {
        stripple_blocks.put(BFBlocks.APPLE_LOG.get(), BFBlocks.STRIPPED_APPLE_LOG.get());
        stripple_blocks.put(BFBlocks.APPLE_WOOD.get(), BFBlocks.STRIPPED_APPLE_WOOD.get());
        stripple_blocks.put(BFBlocks.GOLDEN_APPLE_LOG.get(), BFBlocks.STRIPPED_APPLE_LOG.get());
        stripple_blocks.put(BFBlocks.GOLDEN_APPLE_WOOD.get(), BFBlocks.STRIPPED_APPLE_WOOD.get());
        stripple_blocks.put(BFBlocks.ORANGE_LOG.get(), BFBlocks.STRIPPED_ORANGE_LOG.get());
        stripple_blocks.put(BFBlocks.ORANGE_WOOD.get(), BFBlocks.STRIPPED_ORANGE_WOOD.get());
        stripple_blocks.put(BFBlocks.LEMON_LOG.get(), BFBlocks.STRIPPED_LEMON_LOG.get());
        stripple_blocks.put(BFBlocks.LEMON_WOOD.get(), BFBlocks.STRIPPED_LEMON_WOOD.get());
        stripple_blocks.put(BFBlocks.PLUM_LOG.get(), BFBlocks.STRIPPED_PLUM_LOG.get());
        stripple_blocks.put(BFBlocks.PLUM_WOOD.get(), BFBlocks.STRIPPED_PLUM_WOOD.get());
        stripple_blocks.put(BFBlocks.HOARY_LOG.get(), BFBlocks.STRIPPED_HOARY_LOG.get());
        stripple_blocks.put(BFBlocks.HOARY_WOOD.get(), BFBlocks.STRIPPED_HOARY_WOOD.get());
        stripple_blocks.put(BFBlocks.WALNUT_LOG.get(), BFBlocks.STRIPPED_WALNUT_LOG.get());
        stripple_blocks.put(BFBlocks.WALNUT_WOOD.get(), BFBlocks.STRIPPED_WALNUT_WOOD.get());
        stripple_blocks.put(BFBlocks.PALM_LOG.get(), BFBlocks.STRIPPED_PALM_LOG.get());
        stripple_blocks.put(BFBlocks.PALM_WOOD.get(), BFBlocks.STRIPPED_PALM_WOOD.get());
    }

    private static void registerModCompostables() {
        COMPOSTABLES.put(BFBlocks.APPLE_LEAVES.get().asItem(), 0.3f);
        COMPOSTABLES.put(BFBlocks.FLOWERING_APPLE_LEAVES.get().asItem(), 0.5f);
        COMPOSTABLES.put(BFBlocks.APPLE_SAPLING.get().asItem(), 0.85f);
        COMPOSTABLES.put(BFBlocks.APPLE_BLOCK.get().asItem(), 1f);
        COMPOSTABLES.put(BFBlocks.ORANGE_LEAVES.get().asItem(), 0.3f);
        COMPOSTABLES.put(BFBlocks.FLOWERING_ORANGE_LEAVES.get().asItem(), 0.5f);
        COMPOSTABLES.put(BFBlocks.ORANGE_SAPLING.get().asItem(), 0.85f);
        COMPOSTABLES.put(BFBlocks.ORANGE_BLOCK.get().asItem(), 1f);
        COMPOSTABLES.put(BFItems.ORANGE.get(), 0.65f);
        COMPOSTABLES.put(BFBlocks.LEMON_LEAVES.get().asItem(), 0.3f);
        COMPOSTABLES.put(BFBlocks.FLOWERING_LEMON_LEAVES.get().asItem(), 0.5f);
        COMPOSTABLES.put(BFBlocks.LEMON_SAPLING.get().asItem(), 0.85f);
        COMPOSTABLES.put(BFBlocks.LEMON_BLOCK.get().asItem(), 1f);
        COMPOSTABLES.put(BFItems.LEMON.get(), 0.65f);
        COMPOSTABLES.put(BFBlocks.PLUM_LEAVES.get().asItem(), 0.3f);
        COMPOSTABLES.put(BFBlocks.FLOWERING_PLUM_LEAVES.get().asItem(), 0.5f);
        COMPOSTABLES.put(BFBlocks.PLUM_SAPLING.get().asItem(), 0.85f);
        COMPOSTABLES.put(BFBlocks.PLUM_BLOCK.get().asItem(), 1f);
        COMPOSTABLES.put(BFItems.PLUM.get(), 0.65f);
        COMPOSTABLES.put(BFItems.HOARY_SEEDS.get(), 0.3f);
        COMPOSTABLES.put(BFBlocks.HOARY_LEAVES.get().asItem(), 0.65f);
        COMPOSTABLES.put(BFBlocks.HOARY_APPLE_SAPLING.get().asItem(), 0.85f);
        COMPOSTABLES.put(BFBlocks.HOARY_APPLE_BLOCK.get().asItem(), 1f);
        COMPOSTABLES.put(BFItems.HOARY_APPLE.get(), 0.65f);
        COMPOSTABLES.put(BFBlocks.WALNUT_LEAVES.get().asItem(), 0.65f);
        COMPOSTABLES.put(BFBlocks.WALNUT_SAPLING.get().asItem(), 0.85f);
        COMPOSTABLES.put(BFItems.WALNUT.get(), 0.3f);
        COMPOSTABLES.put(BFBlocks.WALNUT_MULCH.get().asItem(), 0.65f);
        COMPOSTABLES.put(BFBlocks.WALNUT_MULCH_BLOCK.get().asItem(), 1f);
        COMPOSTABLES.put(BFItems.COCONUT.get(), 0.5f);
        COMPOSTABLES.put(BFItems.COCONUT_HALF.get(), 0.3f);
        COMPOSTABLES.put(BFItems.PALM_FROND.get(), 0.5f);
        COMPOSTABLES.put(BFItems.COCONUT_COIR.get(), 0.5f);
        COMPOSTABLES.put(BFBlocks.PACKED_COCONUT_COIR.get(), 0.85f);
        COMPOSTABLES.put(BFBlocks.COIR_CARPET.get(), 0.5f);
        COMPOSTABLES.put(BFBlocks.PALM_MULCH.get().asItem(), 0.65f);
        COMPOSTABLES.put(BFBlocks.PALM_MULCH_BLOCK.get().asItem(), 1f);
        COMPOSTABLES.put(BFItems.PASSION_FRUIT.get(), 0.3f);
        COMPOSTABLES.put(BFItems.ELDERBERRIES.get(), 0.3f);
        COMPOSTABLES.put(BFItems.LAPISBERRY_SEEDS.get(), 0.3f);
        COMPOSTABLES.put(BFItems.LAPISBERRIES.get(), 0.3f);
        COMPOSTABLES.put(BFBlocks.WILD_WHEAT.get(), 0.3f);
        COMPOSTABLES.put(BFBlocks.WILD_POTATOES.get(), 0.3f);
        COMPOSTABLES.put(BFBlocks.WILD_CARROTS.get(), 0.3f);
        COMPOSTABLES.put(BFBlocks.WILD_BEETROOTS.get(), 0.3f);
        COMPOSTABLES.put(BFBlocks.WILD_MAIZE.get(), 0.5f);
        COMPOSTABLES.put(BFBlocks.WILD_LEEKS.get(), 0.3f);
        COMPOSTABLES.put(BFItems.GRASS_SEEDS.get(), 0.3f);
        COMPOSTABLES.put(BFItems.MAIZE_SEEDS.get(), 0.3f);
        COMPOSTABLES.put(BFItems.MAIZE.get(), 0.65f);
        COMPOSTABLES.put(BFItems.LEEK_SEEDS.get(), 0.3f);
        COMPOSTABLES.put(BFItems.LEEK.get(), 0.65f);
        COMPOSTABLES.put(BFItems.FLOUR.get(), 0.3f);
        COMPOSTABLES.put(BFItems.SPONGEKIN_SEEDS.get(), 0.3f);
        COMPOSTABLES.put(BFBlocks.SPONGEKIN.get().asItem(), 1f);
        COMPOSTABLES.put(BFItems.SPONGEKIN_SLICE.get(), 0.65f);
        COMPOSTABLES.put(BFItems.TEA_BERRIES.get(), 0.5f);
        COMPOSTABLES.put(BFItems.TEA_LEAVES.get(), 0.5f);
        COMPOSTABLES.put(BFItems.DRIED_TEA_LEAVES.get(), 0.5f);
        COMPOSTABLES.put(BFBlocks.CHAMOMILE_FLOWERS.get().asItem(), 0.5f);
        COMPOSTABLES.put(BFBlocks.HONEYSUCKLE.get().asItem(), 0.65f);
        COMPOSTABLES.put(BFBlocks.VIOLET_BELLFLOWER.get().asItem(), 0.65f);
        COMPOSTABLES.put(BFItems.GREEN_TEA_BLEND.get(), 0.3f);
        COMPOSTABLES.put(BFItems.BLACK_TEA_BLEND.get(), 0.3f);
        COMPOSTABLES.put(BFItems.CHAMOMILE_TEA_BLEND.get(), 0.3f);
        COMPOSTABLES.put(BFItems.HONEYSUCKLE_TEA_BLEND.get(), 0.3f);
        COMPOSTABLES.put(BFItems.BELLFLOWER_TEA_BLEND.get(), 0.3f);
        COMPOSTABLES.put(BFItems.TORCHFLOWER_TEA_BLEND.get(), 0.3f);
        COMPOSTABLES.put(BFItems.MAIZE_BREAD.get(), 0.85f);
        COMPOSTABLES.put(BFItems.WALNUT_COOKIE.get(), 0.85f);
    }
}
