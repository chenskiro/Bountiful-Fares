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
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.tags.BFBlockTags;
import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.minecraft.core.BlockSource;
import net.minecraft.core.Position;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// import static net.fabricmc.fabric.api.registry.StrippableBlockRegistry.register;
import static net.minecraft.world.level.block.ComposterBlock.COMPOSTABLES;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BFRegistries {

    public static final Reference2IntMap<Item> fuel_items = new Reference2IntOpenHashMap<>();
    public static final List<Pair<TagKey<Item>, Integer>> fuel_item_tags = new ArrayList<>();

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

    public static void RegisterModStuffs() {
        registerStrippables();
        registerCeramicCheckeredConversions();
        registerFuels();
        registerModCompostables();
        registerFermentationRecipes();
        registerFlammables();
        DispenserBlock.registerBehavior(BFItems.FLOUR, new FlourDispenserBehavior() {
            @Override
            protected Projectile createProjectile(Level world, Position position, ItemStack stack) {
                return new FlourProjectileEntity(world, position.x(), position.y(), position.z());
            }
        });
        DispenserBlock.registerBehavior(BFItems.GRASS_SEEDS, new GrassSeedsDispenserBehavior() {
            @Override
            public ItemStack execute(BlockSource pointer, ItemStack stack) {
                return super.execute(pointer, stack);
            }
        });
    }

    public static void registerFermentationRecipes() {
//        FermentationRecipes.addRecipe(BFItems.ELDERBERRIES, null, BFItems.ELDERBERRY_WINE_BOTTLE, Items.GLASS_BOTTLE, null, 13803457);
//        FermentationRecipes.addRecipe(BFItems.LAPISBERRIES, null, BFItems.LAPISBERRY_WINE_BOTTLE, Items.GLASS_BOTTLE, null, 11512561);
//        FermentationRecipes.addRecipe(Items.HONEY_BOTTLE, Items.GLASS_BOTTLE, BFItems.MEAD_BOTTLE, Items.GLASS_BOTTLE, null, 16774088);
//        FermentationRecipes.addRecipe(Items.APPLE, null, BFItems.APPLE_CIDER_JAR, BFItems.JAR, null, 16771237);
//        FermentationRecipes.addRecipe(BFItems.PLUM, null, BFItems.PLUM_CIDER_JAR, BFItems.JAR, null, 14532546);
//        FermentationRecipes.addRecipe(BFItems.HOARY_APPLE, null, BFItems.HOARY_CIDER_JAR, BFItems.JAR, null, 15714738);
//        FermentationRecipes.addRecipe(BFItems.ORANGE, null, BFItems.CITRUS_ESSENCE, null, 4, 15200149);
//        FermentationRecipes.addRecipe(BFItems.LEMON, null, BFItems.CITRUS_ESSENCE, null, 4, 15200149);
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
                addToMap(TrellisUtil.getTrellisFromVariant(trellis), 300);
        }
        addToMap(BFBlocks.GRISTMILL, 300);
        addToMap(BFBlocks.WHITE_JACK_O_STRAW, 400);
        addToMap(BFBlocks.LIGHT_GRAY_JACK_O_STRAW, 400);
        addToMap(BFBlocks.GRAY_JACK_O_STRAW, 400);
        addToMap(BFBlocks.BLACK_JACK_O_STRAW, 400);
        addToMap(BFBlocks.BROWN_JACK_O_STRAW, 400);
        addToMap(BFBlocks.RED_JACK_O_STRAW, 400);
        addToMap(BFBlocks.ORANGE_JACK_O_STRAW, 400);
        addToMap(BFBlocks.YELLOW_JACK_O_STRAW, 400);
        addToMap(BFBlocks.LIME_JACK_O_STRAW, 400);
        addToMap(BFBlocks.GREEN_JACK_O_STRAW, 400);
        addToMap(BFBlocks.CYAN_JACK_O_STRAW, 400);
        addToMap(BFBlocks.LIGHT_BLUE_JACK_O_STRAW, 400);
        addToMap(BFBlocks.BLUE_JACK_O_STRAW, 400);
        addToMap(BFBlocks.PURPLE_JACK_O_STRAW, 400);
        addToMap(BFBlocks.MAGENTA_JACK_O_STRAW, 400);
        addToMap(BFBlocks.PINK_JACK_O_STRAW, 400);
        addToMap(BFBlocks.PALM_FROND, 100);
        addToMap(BFItems.COCONUT_COIR, 100);
        addToMap(BFBlocks.PACKED_COCONUT_COIR, 400);
        addToMap(BFBlocks.COIR_CARPET, 200);
        addToMap(BFBlocks.COIR_BRICKS, 400);
        addToMap(BFBlocks.COIR_BRICK_SLAB, 400);
        addToMap(BFBlocks.COIR_BRICK_STAIRS, 400);
        addToMap(BFBlocks.COIR_BRICK_WALL, 400);
        addToMap(MintBlocks.ACORN_JACK_O_STRAW, 400);
        addToMap(MintBlocks.AMBER_JACK_O_STRAW, 400);
        addToMap(MintBlocks.ARTICHOKE_JACK_O_STRAW, 400);
        addToMap(MintBlocks.BANANA_JACK_O_STRAW, 400);
        addToMap(MintBlocks.CERULEAN_JACK_O_STRAW, 400);
        addToMap(MintBlocks.FUCHSIA_JACK_O_STRAW, 400);
        addToMap(MintBlocks.GRAPE_JACK_O_STRAW, 400);
        addToMap(MintBlocks.INDIGO_JACK_O_STRAW, 400);
        addToMap(MintBlocks.MAROON_JACK_O_STRAW, 400);
        addToMap(MintBlocks.MAUVE_JACK_O_STRAW, 400);
        addToMap(MintBlocks.MINT_JACK_O_STRAW, 400);
        addToMap(MintBlocks.MOLD_JACK_O_STRAW, 400);
        addToMap(MintBlocks.NAVY_JACK_O_STRAW, 400);
        addToMap(MintBlocks.PEACH_JACK_O_STRAW, 400);
        addToMap(MintBlocks.PERIWINKLE_JACK_O_STRAW, 400);
        addToMap(MintBlocks.SAGE_JACK_O_STRAW, 400);
        addToMap(MintBlocks.SAP_JACK_O_STRAW, 400);
        addToMap(MintBlocks.SHAMROCK_JACK_O_STRAW, 400);
        addToMap(MintBlocks.VELVET_JACK_O_STRAW, 400);
        addToMap(MintBlocks.VERMILION_JACK_O_STRAW, 400);
        addToMap(DyeDepotBlocks.MAROON_JACK_O_STRAW, 400);
        addToMap(DyeDepotBlocks.ROSE_JACK_O_STRAW, 400);
        addToMap(DyeDepotBlocks.CORAL_JACK_O_STRAW, 400);
        addToMap(DyeDepotBlocks.GINGER_JACK_O_STRAW, 400);
        addToMap(DyeDepotBlocks.TAN_JACK_O_STRAW, 400);
        addToMap(DyeDepotBlocks.BEIGE_JACK_O_STRAW, 400);
        addToMap(DyeDepotBlocks.AMBER_JACK_O_STRAW, 400);
        addToMap(DyeDepotBlocks.OLIVE_JACK_O_STRAW, 400);
        addToMap(DyeDepotBlocks.FOREST_JACK_O_STRAW, 400);
        addToMap(DyeDepotBlocks.VERDANT_JACK_O_STRAW, 400);
        addToMap(DyeDepotBlocks.TEAL_JACK_O_STRAW, 400);
        addToMap(DyeDepotBlocks.MINT_JACK_O_STRAW, 400);
        addToMap(DyeDepotBlocks.AQUA_JACK_O_STRAW, 400);
        addToMap(DyeDepotBlocks.SLATE_JACK_O_STRAW, 400);
        addToMap(DyeDepotBlocks.NAVY_JACK_O_STRAW, 400);
        addToMap(DyeDepotBlocks.INDIGO_JACK_O_STRAW, 400);
        addToMap(ExcessiveBuildingBlocks.WALNUT_VERTICAL_STAIRS, 300);
        addToMap(ExcessiveBuildingBlocks.CHISELED_WALNUT_PLANKS, 300);
        addToMap(ExcessiveBuildingBlocks.WALNUT_MOSAIC, 300);
        addToMap(ExcessiveBuildingBlocks.WALNUT_MOSAIC_SLAB, 300);
        addToMap(ExcessiveBuildingBlocks.WALNUT_MOSAIC_STAIRS, 300);
        addToMap(ExcessiveBuildingBlocks.WALNUT_MOSAIC_VERTICAL_STAIRS, 300);
        addToMap(ExcessiveBuildingBlocks.WALNUT_LADDER, 300);
        addToMap(ExcessiveBuildingBlocks.HOARY_VERTICAL_STAIRS, 300);
        addToMap(ExcessiveBuildingBlocks.CHISELED_HOARY_PLANKS, 300);
        addToMap(ExcessiveBuildingBlocks.HOARY_MOSAIC, 300);
        addToMap(ExcessiveBuildingBlocks.HOARY_MOSAIC_SLAB, 300);
        addToMap(ExcessiveBuildingBlocks.HOARY_MOSAIC_STAIRS, 300);
        addToMap(ExcessiveBuildingBlocks.HOARY_MOSAIC_VERTICAL_STAIRS, 300);
        addToMap(ExcessiveBuildingBlocks.HOARY_LADDER, 300);

    }

    private static void addToMap(TagKey<Item> itemTagKey, int i) {
        fuel_item_tags.add(Pair.of(itemTagKey, i));
    }

    private static void addToMap(ItemLike block, int i) {
        fuel_items.put(block.asItem(), i);
    }

    public static void registerFlammables() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();
        registry.add(BFBlockTags.APPLE_LEAVES, 60, 30);
        registry.add(BFBlockTags.ORANGE_LEAVES, 60, 30);
        registry.add(BFBlockTags.LEMON_LEAVES, 60, 30);
        registry.add(BFBlockTags.PLUM_LEAVES, 60, 30);
        registry.add(BFBlocks.HOARY_LEAVES, 60, 30);
        registry.add(BFBlocks.PALM_FROND, 60, 30);
        registry.add(BFBlocks.WALL_PALM_FROND, 60, 30);
        registry.add(BFBlockTags.APPLE_LOGS, 10, 5);
        registry.add(BFBlockTags.ORANGE_LOGS, 10, 5);
        registry.add(BFBlockTags.LEMON_LOGS, 10, 5);
        registry.add(BFBlockTags.PLUM_LOGS, 10, 5);
        registry.add(BFBlocks.PALM_CROWN, 10, 5);
        registry.add(BFBlockTags.PALM_LOGS, 10, 5);
        registry.add(BFBlockTags.HOARY_LOGS, 10, 5);
        registry.add(BFBlockTags.WALNUT_LOGS, 10, 5);
        registry.add(BFBlocks.HOARY_PLANKS, 10, 5);
        registry.add(BFBlocks.HOARY_STAIRS, 10, 5);
        registry.add(BFBlocks.HOARY_SLAB, 20, 5);
        registry.add(BFBlocks.HOARY_FENCE, 20, 5);
        registry.add(BFBlocks.HOARY_FENCE_GATE, 20, 5);
        registry.add(BFBlocks.HOARY_DOOR, 20, 5);
        registry.add(BFBlocks.HOARY_TRAPDOOR, 20, 5);
        registry.add(BFBlocks.WALNUT_PLANKS, 10, 5);
        registry.add(BFBlocks.WALNUT_STAIRS, 10, 5);
        registry.add(BFBlocks.WALNUT_SLAB, 20, 5);
        registry.add(BFBlocks.WALNUT_FENCE, 20, 5);
        registry.add(BFBlocks.WALNUT_FENCE_GATE, 20, 5);
        registry.add(BFBlocks.WALNUT_DOOR, 20, 5);
        registry.add(BFBlocks.WALNUT_TRAPDOOR, 20, 5);
        registry.add(BFBlocks.WALNUT_MULCH, 60, 30);
        registry.add(BFBlocks.WALNUT_MULCH_BLOCK, 20, 30);
        registry.add(BFBlocks.PALM_MULCH, 60, 30);
        registry.add(BFBlocks.PALM_MULCH_BLOCK, 20, 30);
        registry.add(BFBlockTags.PICKETS, 20, 5);
    }

    public static void registerCeramicCheckeredConversions() {
        registerCheckeredCeramic(BFBlocks.CERAMIC_TILES, BFBlocks.CHECKERED_CERAMIC_TILES);
        registerCheckeredCeramic(BFBlocks.CERAMIC_TILE_STAIRS, BFBlocks.CHECKERED_CERAMIC_TILE_STAIRS);
        registerCheckeredCeramic(BFBlocks.CERAMIC_TILE_SLAB, BFBlocks.CHECKERED_CERAMIC_TILE_SLAB);
        registerCheckeredCeramic(BFBlocks.CRACKED_CERAMIC_TILES, BFBlocks.CRACKED_CHECKERED_CERAMIC_TILES);
        registerCheckeredCeramic(BFBlocks.CERAMIC_MOSAIC, BFBlocks.CHECKERED_CERAMIC_MOSAIC);
        registerCheckeredCeramic(BFBlocks.CERAMIC_MOSAIC_STAIRS, BFBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS);
        registerCheckeredCeramic(BFBlocks.CERAMIC_MOSAIC_SLAB, BFBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB);
        if (BountifulFares.isModLoaded(BountifulFares.EXCESSIVE_BUILDING_MOD_ID)) {
            registerCheckeredCeramic(ExcessiveBuildingBlocks.CERAMIC_TILE_VERTICAL_STAIRS, ExcessiveBuildingBlocks.CHECKERED_CERAMIC_TILE_VERTICAL_STAIRS);
            registerCheckeredCeramic(ExcessiveBuildingBlocks.CERAMIC_MOSAIC_VERTICAL_STAIRS, ExcessiveBuildingBlocks.CHECKERED_CERAMIC_MOSAIC_VERTICAL_STAIRS);
        }
    }

    public static void registerCheckeredCeramic(Block normal, Block checkered) {
        BFBlocks.CERAMIC_TO_CHECKERED_CERAMIC.put(normal, checkered);
        BFBlocks.CERAMIC_TO_CHECKERED_CERAMIC.put(checkered, normal);
    }

    public static void registerStrippables() {
        register(BFBlocks.APPLE_LOG, BFBlocks.STRIPPED_APPLE_LOG);
        register(BFBlocks.APPLE_WOOD, BFBlocks.STRIPPED_APPLE_WOOD);
        register(BFBlocks.GOLDEN_APPLE_LOG, BFBlocks.STRIPPED_APPLE_LOG);
        register(BFBlocks.GOLDEN_APPLE_WOOD, BFBlocks.STRIPPED_APPLE_WOOD);
        register(BFBlocks.ORANGE_LOG, BFBlocks.STRIPPED_ORANGE_LOG);
        register(BFBlocks.ORANGE_WOOD, BFBlocks.STRIPPED_ORANGE_WOOD);
        register(BFBlocks.LEMON_LOG, BFBlocks.STRIPPED_LEMON_LOG);
        register(BFBlocks.LEMON_WOOD, BFBlocks.STRIPPED_LEMON_WOOD);
        register(BFBlocks.PLUM_LOG, BFBlocks.STRIPPED_PLUM_LOG);
        register(BFBlocks.PLUM_WOOD, BFBlocks.STRIPPED_PLUM_WOOD);
        register(BFBlocks.HOARY_LOG, BFBlocks.STRIPPED_HOARY_LOG);
        register(BFBlocks.HOARY_WOOD, BFBlocks.STRIPPED_HOARY_WOOD);
        register(BFBlocks.WALNUT_LOG, BFBlocks.STRIPPED_WALNUT_LOG);
        register(BFBlocks.WALNUT_WOOD, BFBlocks.STRIPPED_WALNUT_WOOD);
        register(BFBlocks.PALM_LOG, BFBlocks.STRIPPED_PALM_LOG);
        register(BFBlocks.PALM_WOOD, BFBlocks.STRIPPED_PALM_WOOD);
    }

    private static void registerModCompostables() {
        COMPOSTABLES.put(BFBlocks.APPLE_LEAVES.asItem(), 0.3f);
        COMPOSTABLES.put(BFBlocks.FLOWERING_APPLE_LEAVES.asItem(), 0.5f);
        COMPOSTABLES.put(BFBlocks.APPLE_SAPLING.asItem(), 0.85f);
        COMPOSTABLES.put(BFBlocks.APPLE_BLOCK.asItem(), 1f);
        COMPOSTABLES.put(BFBlocks.ORANGE_LEAVES.asItem(), 0.3f);
        COMPOSTABLES.put(BFBlocks.FLOWERING_ORANGE_LEAVES.asItem(), 0.5f);
        COMPOSTABLES.put(BFBlocks.ORANGE_SAPLING.asItem(), 0.85f);
        COMPOSTABLES.put(BFBlocks.ORANGE_BLOCK.asItem(), 1f);
        COMPOSTABLES.put(BFItems.ORANGE, 0.65f);
        COMPOSTABLES.put(BFBlocks.LEMON_LEAVES.asItem(), 0.3f);
        COMPOSTABLES.put(BFBlocks.FLOWERING_LEMON_LEAVES.asItem(), 0.5f);
        COMPOSTABLES.put(BFBlocks.LEMON_SAPLING.asItem(), 0.85f);
        COMPOSTABLES.put(BFBlocks.LEMON_BLOCK.asItem(), 1f);
        COMPOSTABLES.put(BFItems.LEMON, 0.65f);
        COMPOSTABLES.put(BFBlocks.PLUM_LEAVES.asItem(), 0.3f);
        COMPOSTABLES.put(BFBlocks.FLOWERING_PLUM_LEAVES.asItem(), 0.5f);
        COMPOSTABLES.put(BFBlocks.PLUM_SAPLING.asItem(), 0.85f);
        COMPOSTABLES.put(BFBlocks.PLUM_BLOCK.asItem(), 1f);
        COMPOSTABLES.put(BFItems.PLUM, 0.65f);
        COMPOSTABLES.put(BFItems.HOARY_SEEDS, 0.3f);
        COMPOSTABLES.put(BFBlocks.HOARY_LEAVES.asItem(), 0.65f);
        COMPOSTABLES.put(BFBlocks.HOARY_APPLE_SAPLING.asItem(), 0.85f);
        COMPOSTABLES.put(BFBlocks.HOARY_APPLE_BLOCK.asItem(), 1f);
        COMPOSTABLES.put(BFItems.HOARY_APPLE, 0.65f);
        COMPOSTABLES.put(BFBlocks.WALNUT_LEAVES.asItem(), 0.65f);
        COMPOSTABLES.put(BFBlocks.WALNUT_SAPLING.asItem(), 0.85f);
        COMPOSTABLES.put(BFItems.WALNUT, 0.3f);
        COMPOSTABLES.put(BFBlocks.WALNUT_MULCH.asItem(), 0.65f);
        COMPOSTABLES.put(BFBlocks.WALNUT_MULCH_BLOCK.asItem(), 1f);
        COMPOSTABLES.put(BFItems.COCONUT, 0.5f);
        COMPOSTABLES.put(BFItems.COCONUT_HALF, 0.3f);
        COMPOSTABLES.put(BFItems.PALM_FROND, 0.5f);
        COMPOSTABLES.put(BFItems.COCONUT_COIR, 0.5f);
        COMPOSTABLES.put(BFBlocks.PACKED_COCONUT_COIR, 0.85f);
        COMPOSTABLES.put(BFBlocks.COIR_CARPET, 0.5f);
        COMPOSTABLES.put(BFBlocks.PALM_MULCH.asItem(), 0.65f);
        COMPOSTABLES.put(BFBlocks.PALM_MULCH_BLOCK.asItem(), 1f);
        COMPOSTABLES.put(BFItems.PASSION_FRUIT, 0.3f);
        COMPOSTABLES.put(BFItems.ELDERBERRIES, 0.3f);
        COMPOSTABLES.put(BFItems.LAPISBERRY_SEEDS, 0.3f);
        COMPOSTABLES.put(BFItems.LAPISBERRIES, 0.3f);
        COMPOSTABLES.put(BFBlocks.WILD_WHEAT, 0.3f);
        COMPOSTABLES.put(BFBlocks.WILD_POTATOES, 0.3f);
        COMPOSTABLES.put(BFBlocks.WILD_CARROTS, 0.3f);
        COMPOSTABLES.put(BFBlocks.WILD_BEETROOTS, 0.3f);
        COMPOSTABLES.put(BFBlocks.WILD_MAIZE, 0.5f);
        COMPOSTABLES.put(BFBlocks.WILD_LEEKS, 0.3f);
        COMPOSTABLES.put(BFItems.GRASS_SEEDS, 0.3f);
        COMPOSTABLES.put(BFItems.MAIZE_SEEDS, 0.3f);
        COMPOSTABLES.put(BFItems.MAIZE, 0.65f);
        COMPOSTABLES.put(BFItems.LEEK_SEEDS, 0.3f);
        COMPOSTABLES.put(BFItems.LEEK, 0.65f);
        COMPOSTABLES.put(BFItems.FLOUR, 0.3f);
        COMPOSTABLES.put(BFItems.SPONGEKIN_SEEDS, 0.3f);
        COMPOSTABLES.put(BFBlocks.SPONGEKIN.asItem(), 1f);
        COMPOSTABLES.put(BFItems.SPONGEKIN_SLICE, 0.65f);
        COMPOSTABLES.put(BFItems.TEA_BERRIES, 0.5f);
        COMPOSTABLES.put(BFItems.TEA_LEAVES, 0.5f);
        COMPOSTABLES.put(BFItems.DRIED_TEA_LEAVES, 0.5f);
        COMPOSTABLES.put(BFBlocks.CHAMOMILE_FLOWERS.asItem(), 0.5f);
        COMPOSTABLES.put(BFBlocks.HONEYSUCKLE.asItem(), 0.65f);
        COMPOSTABLES.put(BFBlocks.VIOLET_BELLFLOWER.asItem(), 0.65f);
        COMPOSTABLES.put(BFItems.GREEN_TEA_BLEND, 0.3f);
        COMPOSTABLES.put(BFItems.BLACK_TEA_BLEND, 0.3f);
        COMPOSTABLES.put(BFItems.CHAMOMILE_TEA_BLEND, 0.3f);
        COMPOSTABLES.put(BFItems.HONEYSUCKLE_TEA_BLEND, 0.3f);
        COMPOSTABLES.put(BFItems.BELLFLOWER_TEA_BLEND, 0.3f);
        COMPOSTABLES.put(BFItems.TORCHFLOWER_TEA_BLEND, 0.3f);
        COMPOSTABLES.put(BFItems.MAIZE_BREAD, 0.85f);
        COMPOSTABLES.put(BFItems.WALNUT_COOKIE, 0.85f);
    }
}
