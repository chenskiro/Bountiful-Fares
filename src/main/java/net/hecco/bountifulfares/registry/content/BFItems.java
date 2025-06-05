package net.hecco.bountifulfares.registry.content;

// import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.item.custom.*;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

// @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BFItems {
    public static final DeferredRegister<Item> ITEM_DEFERRED_REGISTER = DeferredRegister.create(Registries.ITEM, BountifulFares.MOD_ID);

    private static final Map<ResourceKey<Item>, Item> items = new HashMap<>();

    public static final RegistryObject<Item> PASSION_FRUIT = ITEM_DEFERRED_REGISTER.register("passion_fruit",()-> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1f).fast().build())));
    public static final RegistryObject<Item> ELDERBERRIES = ITEM_DEFERRED_REGISTER.register("elderberries",()-> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1f).fast().effect(()->new MobEffectInstance(MobEffects.HEAL, 1, 0, true, false), 0.3f).build())));
    public static final RegistryObject<Item> LAPISBERRY_SEEDS = ITEM_DEFERRED_REGISTER.register("lapisberry_seeds",()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LAPISBERRIES = ITEM_DEFERRED_REGISTER.register("lapisberries",()-> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(0.1f).fast().build())));

    public static final RegistryObject<Item> ORANGE = ITEM_DEFERRED_REGISTER.register("orange",()-> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.3F).build())));
    public static final RegistryObject<Item> LEMON = ITEM_DEFERRED_REGISTER.register("lemon",()-> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.3F).build())));
    public static final RegistryObject<Item> PLUM = ITEM_DEFERRED_REGISTER.register("plum",()-> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.3F).build())));
    public static final RegistryObject<Item> HOARY_APPLE = ITEM_DEFERRED_REGISTER.register("hoary_apple",()-> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.6F).build())));
    public static final RegistryObject<Item> HOARY_SEEDS = ITEM_DEFERRED_REGISTER.register("hoary_seeds",()-> new ItemNameBlockItem(BFBlocks.HOARY_APPLE_SAPLING_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> HOARY_SIGN = ITEM_DEFERRED_REGISTER.register("hoary_sign",()-> new SignItem(new Item.Properties().stacksTo(16), BFBlocks.HOARY_SIGN.get(), BFBlocks.HOARY_WALL_SIGN.get()));
    public static final RegistryObject<Item> HOARY_HANGING_SIGN = ITEM_DEFERRED_REGISTER.register("hoary_hanging_sign",()-> new HangingSignItem(BFBlocks.HOARY_HANGING_SIGN.get(), BFBlocks.HOARY_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

    // public static final RegistryObject<Item> HOARY_BOAT = TerraformBoatItemHelper.registerBoatItem(BFBoats.HOARY_BOAT_ID, BFBoats.HOARY_BOAT_KEY, false);
    // public static final RegistryObject<Item> HOARY_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(BFBoats.HOARY_CHEST_BOAT_ID, BFBoats.HOARY_BOAT_KEY, true);

    public static final RegistryObject<Item> SWEET_BERRY_PIPS = ITEM_DEFERRED_REGISTER.register("sweet_berry_pips",()-> new SweetBerryPipsItem(Blocks.SWEET_BERRY_BUSH, new Item.Properties()));

    public static final RegistryObject<Item> WALNUT = ITEM_DEFERRED_REGISTER.register("walnut",()-> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(0).fast().build())));
    public static final RegistryObject<Item> WALNUT_SIGN = ITEM_DEFERRED_REGISTER.register("walnut_sign",()-> new SignItem(new Item.Properties().stacksTo(16), BFBlocks.WALNUT_SIGN.get(), BFBlocks.WALNUT_WALL_SIGN.get()));
    public static final RegistryObject<Item> WALNUT_HANGING_SIGN = ITEM_DEFERRED_REGISTER.register("walnut_hanging_sign",()-> new HangingSignItem(BFBlocks.WALNUT_HANGING_SIGN.get(), BFBlocks.WALNUT_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

    // public static final RegistryObject<Item> WALNUT_BOAT = TerraformBoatItemHelper.registerBoatItem(BFBoats.WALNUT_BOAT_ID, BFBoats.WALNUT_BOAT_KEY, false);
    // public static final RegistryObject<Item> WALNUT_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(BFBoats.WALNUT_CHEST_BOAT_ID, BFBoats.WALNUT_BOAT_KEY, true);

    public static final RegistryObject<Item> PALM_FROND = ITEM_DEFERRED_REGISTER.register("palm_frond",()-> new StandingAndWallBlockItem(BFBlocks.PALM_FROND.get(), BFBlocks.WALL_PALM_FROND.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> COCONUT = ITEM_DEFERRED_REGISTER.register("coconut",()-> new ItemNameBlockItem(BFBlocks.PALM_SAPLING.get(), new Item.Properties()));
    public static final RegistryObject<Item> COCONUT_COIR = ITEM_DEFERRED_REGISTER.register("coconut_coir",()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COCONUT_HALF = ITEM_DEFERRED_REGISTER.register("coconut_half",()-> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.1f).build())));
    public static final RegistryObject<Item> COCONUT_MILK_BOTTLE = ITEM_DEFERRED_REGISTER.register("coconut_milk_bottle",()-> new CoconutMilkBottleItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(1f).build()).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> CITRUS_ESSENCE = ITEM_DEFERRED_REGISTER.register("citrus_essence",()-> new EffectFoodItem(List.of(new MobEffectInstance(BFEffects.ACIDIC, 300, 0)), new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1f).fast().alwaysEat().effect(()->new MobEffectInstance(BFEffects.ACIDIC, 300, 0),1).build())));
    public static final RegistryObject<Item> CANDIED_ORANGE = ITEM_DEFERRED_REGISTER.register("candied_orange",()-> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.2f).fast().build())));
    public static final RegistryObject<Item> CANDIED_LEMON = ITEM_DEFERRED_REGISTER.register("candied_lemon",()-> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.2f).fast().build())));
    public static final RegistryObject<Item> ELDERBERRY_WINE_BOTTLE = ITEM_DEFERRED_REGISTER.register("elderberry_wine_bottle",()-> new LiquidBottleItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).food(new FoodProperties.Builder().nutrition(4).saturationMod(0.2f).effect(()->new MobEffectInstance(MobEffects.HEAL, 1, 1, true, false), 1).effect(()->new MobEffectInstance(MobEffects.CONFUSION, 600, 0), 0.3f).alwaysEat().build()).stacksTo(16)));
    public static final RegistryObject<Item> LAPISBERRY_WINE_BOTTLE = ITEM_DEFERRED_REGISTER.register("lapisberry_wine_bottle",()-> new LiquidBottleItem(List.of(new MobEffectInstance(MobEffects.NIGHT_VISION, 600, 0)), new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).food(new FoodProperties.Builder().nutrition(5).saturationMod(0.4f).effect(()->new MobEffectInstance(MobEffects.NIGHT_VISION, 600, 0), 1).effect(()->new MobEffectInstance(MobEffects.CONFUSION, 600, 0), 0.3f).alwaysEat().build()).stacksTo(16)));
    public static final RegistryObject<Item> MEAD_BOTTLE = ITEM_DEFERRED_REGISTER.register("mead_bottle",()-> new MeadBottleItem(List.of(new MobEffectInstance(MobEffects.REGENERATION, 200, 0)), new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).food(new FoodProperties.Builder().nutrition(5).saturationMod(0.4f).effect(()->new MobEffectInstance(MobEffects.REGENERATION, 200, 0), 1).effect(()->new MobEffectInstance(MobEffects.CONFUSION, 600, 0), 0.3f).alwaysEat().build()).stacksTo(16)));
    public static final RegistryObject<Item> FELDSPAR = ITEM_DEFERRED_REGISTER.register("feldspar",()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CERAMIC_CLAY = ITEM_DEFERRED_REGISTER.register("ceramic_clay",()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CERAMIC_TILE = ITEM_DEFERRED_REGISTER.register("ceramic_tile",()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TEA_BERRIES = ITEM_DEFERRED_REGISTER.register("tea_berries",()-> new TeaBerriesItem(BFBlocks.TEA_SHRUB.get(), new Item.Properties()));
    public static final RegistryObject<Item> TEA_LEAVES = ITEM_DEFERRED_REGISTER.register("tea_leaves",()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DRIED_TEA_LEAVES = ITEM_DEFERRED_REGISTER.register("dried_tea_leaves",()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GREEN_TEA_BLEND = ITEM_DEFERRED_REGISTER.register("green_tea_blend",()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BLACK_TEA_BLEND = ITEM_DEFERRED_REGISTER.register("black_tea_blend",()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHAMOMILE_TEA_BLEND = ITEM_DEFERRED_REGISTER.register("chamomile_tea_blend",()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HONEYSUCKLE_TEA_BLEND = ITEM_DEFERRED_REGISTER.register("honeysuckle_tea_blend",()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BELLFLOWER_TEA_BLEND = ITEM_DEFERRED_REGISTER.register("bellflower_tea_blend",()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TORCHFLOWER_TEA_BLEND = ITEM_DEFERRED_REGISTER.register("torchflower_tea_blend",()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GREEN_TEA_BOTTLE = ITEM_DEFERRED_REGISTER.register("green_tea_bottle",()-> new GreenTeaBottleItem(new Item.Properties().stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).food(new FoodProperties.Builder().nutrition(4).saturationMod(1f).effect(()->new MobEffectInstance(BFEffects.EBULLIENCE, 6000, 0, true, true), 1f).alwaysEat().build())));
    public static final RegistryObject<Item> BLACK_TEA_BOTTLE = ITEM_DEFERRED_REGISTER.register("black_tea_bottle",()-> new BlackTeaBottleItem(new Item.Properties().stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).food(new FoodProperties.Builder().nutrition(4).saturationMod(1f).effect(()->new MobEffectInstance(BFEffects.EBULLIENCE, 6000, 0, true, true), 1f).alwaysEat().build())));
    public static final RegistryObject<Item> CHAMOMILE_TEA_BOTTLE = ITEM_DEFERRED_REGISTER.register("chamomile_tea_bottle",()-> new ChamomileTeaBottleItem(new Item.Properties().stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).food(new FoodProperties.Builder().nutrition(4).saturationMod(1f).effect(()->new MobEffectInstance(BFEffects.EBULLIENCE, 6000, 0, true, true), 1f).alwaysEat().build())));
    public static final RegistryObject<Item> HONEYSUCKLE_TEA_BOTTLE = ITEM_DEFERRED_REGISTER.register("honeysuckle_tea_bottle",()-> new HoneysuckleTeaBottleItem(new Item.Properties().stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).food(new FoodProperties.Builder().nutrition(4).saturationMod(1f).effect(()->new MobEffectInstance(BFEffects.EBULLIENCE, 6000, 0, true, true), 1f).alwaysEat().build())));
    public static final RegistryObject<Item> BELLFLOWER_TEA_BOTTLE = ITEM_DEFERRED_REGISTER.register("bellflower_tea_bottle",()-> new BellflowerTeaBottleItem(new Item.Properties().stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).food(new FoodProperties.Builder().nutrition(4).saturationMod(1f).effect(()->new MobEffectInstance(BFEffects.EBULLIENCE, 6000, 0, true, true), 1f).alwaysEat().build())));
    public static final RegistryObject<Item> TORCHFLOWER_TEA_BOTTLE = ITEM_DEFERRED_REGISTER.register("torchflower_tea_bottle",()-> new TorchflowerTeaBottleItem(new Item.Properties().stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).food(new FoodProperties.Builder().nutrition(4).saturationMod(1f).effect(()->new MobEffectInstance(BFEffects.EBULLIENCE, 6000, 0, true, true), 1f).alwaysEat().build())));
    public static final RegistryObject<Item> MAIZE = ITEM_DEFERRED_REGISTER.register("maize",()-> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(0.6f).build())));
    public static final RegistryObject<Item> GRASS_SEEDS = ITEM_DEFERRED_REGISTER.register("grass_seeds",()-> new GrassSeedsItem(new Item.Properties()));
    public static final RegistryObject<Item> MAIZE_SEEDS = ITEM_DEFERRED_REGISTER.register("maize_seeds",()-> new ItemNameBlockItem(BFBlocks.MAIZE_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> POPPED_MAIZE = ITEM_DEFERRED_REGISTER.register("popped_maize",()-> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(0.5f).fast().build())));
    public static final RegistryObject<Item> LEEK = ITEM_DEFERRED_REGISTER.register("leek",()-> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(0.6f).build())));
    public static final RegistryObject<Item> LEEK_SEEDS = ITEM_DEFERRED_REGISTER.register("leek_seeds",()-> new ItemNameBlockItem(BFBlocks.LEEKS.get(), new Item.Properties()));
    public static final RegistryObject<Item> SPONGEKIN_SEEDS = ITEM_DEFERRED_REGISTER.register("spongekin_seeds",()-> new ItemNameBlockItem(BFBlocks.SPONGEKIN_STEM.get(), new Item.Properties()));
    public static final RegistryObject<Item> SPONGEKIN_SLICE = ITEM_DEFERRED_REGISTER.register("spongekin_slice",()-> new AirTimeIncreasingItem( 200, new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.3f).alwaysEat().build())));
    public static final RegistryObject<Item> PICKLED_SPONGEKIN = ITEM_DEFERRED_REGISTER.register("pickled_spongekin",()-> new AirTimeIncreasingItem( 250, new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationMod(0.8f).alwaysEat().build())));
    public static final RegistryObject<Item> SCORCHKIN_SEEDS = ITEM_DEFERRED_REGISTER.register("scorchkin_seeds",()-> new ItemNameBlockItem(BFBlocks.SCORCHKIN_STEM.get(), new Item.Properties()));
    public static final RegistryObject<Item> FLOUR = ITEM_DEFERRED_REGISTER.register("flour",()-> new FlourItem(new Item.Properties()));
    public static final RegistryObject<Item> ARTISAN_COOKIE = ITEM_DEFERRED_REGISTER.register("artisan_cookie",()-> new ItemNameBlockItem(BFBlocks.ARTISAN_COOKIES.get(), new Item.Properties()));
    public static final RegistryObject<Item> SUN_HAT = ITEM_DEFERRED_REGISTER.register("sun_hat",()-> new SunHatItem(new Item.Properties().stacksTo(1)));



    public static final RegistryObject<Item> ARTISAN_BRUSH = ITEM_DEFERRED_REGISTER.register("artisan_brush",()-> new ArtisanBrushItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> JAR = ITEM_DEFERRED_REGISTER.register("jar",()-> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> APPLE_COMPOTE_JAR = ITEM_DEFERRED_REGISTER.register("apple_compote_jar",()-> new EdibleJarItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0)), SoundEvents.HONEY_DRINK, new Item.Properties().stacksTo(16).craftRemainder(JAR.get()).food(new FoodProperties.Builder().nutrition(6).saturationMod(0.4f).effect(()->new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0), 1f).build()).craftRemainder(JAR.get())));
    public static final RegistryObject<Item> ORANGE_COMPOTE_JAR = ITEM_DEFERRED_REGISTER.register("orange_compote_jar",()-> new EdibleJarItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0)), SoundEvents.HONEY_DRINK, new Item.Properties().stacksTo(16).craftRemainder(JAR.get()).food(new FoodProperties.Builder().nutrition(6).saturationMod(0.4f).effect(()->new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0), 1f).build()).craftRemainder(JAR.get())));
    public static final RegistryObject<Item> LEMON_COMPOTE_JAR = ITEM_DEFERRED_REGISTER.register("lemon_compote_jar",()-> new EdibleJarItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0)), SoundEvents.HONEY_DRINK, new Item.Properties().stacksTo(16).craftRemainder(JAR.get()).food(new FoodProperties.Builder().nutrition(6).saturationMod(0.4f).effect(()->new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0), 1f).build()).craftRemainder(JAR.get())));
    public static final RegistryObject<Item> PLUM_COMPOTE_JAR = ITEM_DEFERRED_REGISTER.register("plum_compote_jar",()-> new EdibleJarItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0)), SoundEvents.HONEY_DRINK, new Item.Properties().stacksTo(16).craftRemainder(JAR.get()).food(new FoodProperties.Builder().nutrition(6).saturationMod(0.4f).effect(()->new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0), 1f).build()).craftRemainder(JAR.get())));
    public static final RegistryObject<Item> HOARY_COMPOTE_JAR = ITEM_DEFERRED_REGISTER.register("hoary_compote_jar",()-> new EdibleJarItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0)), SoundEvents.HONEY_DRINK, new Item.Properties().stacksTo(16).craftRemainder(JAR.get()).food(new FoodProperties.Builder().nutrition(6).saturationMod(0.4f).effect(()->new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0), 1f).build()).craftRemainder(JAR.get())));

    public static final RegistryObject<Item> APPLE_CIDER_JAR = ITEM_DEFERRED_REGISTER.register("apple_cider_jar",()-> new LiquidJarItem(new Item.Properties().stacksTo(16).craftRemainder(JAR.get()).food(new FoodProperties.Builder().nutrition(6).saturationMod(0.6f).build())));
    public static final RegistryObject<Item> PLUM_CIDER_JAR = ITEM_DEFERRED_REGISTER.register("plum_cider_jar",()-> new LiquidJarItem(new Item.Properties().stacksTo(16).craftRemainder(JAR.get()).food(new FoodProperties.Builder().nutrition(6).saturationMod(0.6f).build())));
    public static final RegistryObject<Item> HOARY_CIDER_JAR = ITEM_DEFERRED_REGISTER.register("hoary_cider_jar",()-> new LiquidJarItem(new Item.Properties().stacksTo(16).craftRemainder(JAR.get()).food(new FoodProperties.Builder().nutrition(6).saturationMod(0.6f).build())));

    public static final RegistryObject<Item> CANDY = ITEM_DEFERRED_REGISTER.register("candy",()-> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationMod(0.4F).fast().build())));
    public static final RegistryObject<Item> SOUR_CANDY = ITEM_DEFERRED_REGISTER.register("sour_candy",()-> new EffectFoodItem(List.of(new MobEffectInstance(BFEffects.ACIDIC, 200)), new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.3F).effect(()->new MobEffectInstance(BFEffects.ACIDIC, 200), 0.2f).fast().build())));
    public static final RegistryObject<Item> PIQUANT_CANDY = ITEM_DEFERRED_REGISTER.register("piquant_candy",()-> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.3F).fast().build())));
    public static final RegistryObject<Item> BITTER_CANDY = ITEM_DEFERRED_REGISTER.register("bitter_candy",()-> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.3F).effect(()->new MobEffectInstance(MobEffects.HEAL, 1, 0, true, false), 0.75f).fast().build())));
    public static final RegistryObject<Item> STRANGE_CANDY = ITEM_DEFERRED_REGISTER.register("strange_candy",()-> new EffectFoodItem(List.of(new MobEffectInstance(MobEffects.NIGHT_VISION, 20, 0)), new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.3F).effect(()->new MobEffectInstance(MobEffects.NIGHT_VISION, 20, 0, true, false), 1f).fast().build())));



    public static final RegistryObject<Item> PASSION_GLAZED_SALMON = ITEM_DEFERRED_REGISTER.register("passion_glazed_salmon",()-> new StackableBowlFoodItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 2400, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(8).saturationMod(0.7F).effect(()->new MobEffectInstance(BFEffects.ENRICHMENT, 2400, 0, true, true), 1).build()).craftRemainder(Items.BOWL)));
    public static final RegistryObject<Item> COCONUT_CRUSTED_COD = ITEM_DEFERRED_REGISTER.register("coconut_crusted_cod",()-> new StackableBowlFoodItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 2400, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(8).saturationMod(0.7F).effect(()->new MobEffectInstance(BFEffects.ENRICHMENT, 2400, 0, true, true), 1).build()).craftRemainder(Items.BOWL)));
    public static final RegistryObject<Item> BOUNTIFUL_STEW = ITEM_DEFERRED_REGISTER.register("bountiful_stew",()-> new StackableBowlFoodItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 2400, 0, true, true)), new Item.Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(10).saturationMod(0.6F).effect(()->new MobEffectInstance(BFEffects.RESTORATION, 2400, 0, true, true), 1).build()).craftRemainder(Items.BOWL)));
    public static final RegistryObject<Item> CRUSTED_BEEF = ITEM_DEFERRED_REGISTER.register("crusted_beef",()-> new StackableBowlFoodItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 2400, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(10).saturationMod(0.7F).effect(()->new MobEffectInstance(BFEffects.ENRICHMENT, 2400, 0, true, true), 1).build()).craftRemainder(Items.BOWL)));
    public static final RegistryObject<Item> LEEK_STEW = ITEM_DEFERRED_REGISTER.register("leek_stew",()-> new StackableBowlFoodItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 1800, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(6).saturationMod(0.6F).effect(()->new MobEffectInstance(BFEffects.ENRICHMENT, 1800, 0, true, true), 1).build()).craftRemainder(Items.BOWL)));
    public static final RegistryObject<Item> FISH_STEW = ITEM_DEFERRED_REGISTER.register("fish_stew",()-> new StackableBowlFoodItem(List.of(new MobEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(10).saturationMod(0.6F).effect(()->new MobEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true), 1).build()).craftRemainder(Items.BOWL)));
    public static final RegistryObject<Item> STONE_STEW = ITEM_DEFERRED_REGISTER.register("stone_stew",()-> new StackableBowlFoodItem(new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(5).saturationMod(0.4F).build()).craftRemainder(Items.BOWL)));
    public static final RegistryObject<Item> APPLE_STEW = ITEM_DEFERRED_REGISTER.register("apple_stew",()-> new StackableBowlFoodItem(List.of(new MobEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(10).saturationMod(0.5F).effect(()->new MobEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true), 1).build()).craftRemainder(Items.BOWL)));
    public static final RegistryObject<Item> COCONUT_STEW = ITEM_DEFERRED_REGISTER.register("coconut_stew",()-> new StackableBowlFoodItem(List.of(new MobEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(10).saturationMod(0.6F).effect(()->new MobEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true), 1).build()).craftRemainder(Items.BOWL)));
    public static final RegistryObject<Item> SEA_SALAD = ITEM_DEFERRED_REGISTER.register("sea_salad",()-> new StackableBowlFoodItem(new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(6).saturationMod(0.5F).build()).craftRemainder(Items.BOWL)));
    public static final RegistryObject<Item> FOREST_MEDLEY = ITEM_DEFERRED_REGISTER.register("forest_medley",()-> new EffectFoodItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(10).saturationMod(0.6F).effect(()->new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true), 1).build())));
    public static final RegistryObject<Item> ARID_MEDLEY = ITEM_DEFERRED_REGISTER.register("arid_medley",()-> new EffectFoodItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(9).saturationMod(0.5F).effect(()->new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true), 1).build())));
    public static final RegistryObject<Item> MEADOW_MEDLEY = ITEM_DEFERRED_REGISTER.register("meadow_medley",()-> new EffectFoodItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(9).saturationMod(0.5F).effect(()->new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true), 1).build())));
    public static final RegistryObject<Item> MIRE_MEDLEY = ITEM_DEFERRED_REGISTER.register("mire_medley",()-> new EffectFoodItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(8).saturationMod(0.6F).effect(()->new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true), 1).build())));
    public static final RegistryObject<Item> COASTAL_MEDLEY = ITEM_DEFERRED_REGISTER.register("coastal_medley",()-> new AirTimeIncreasingItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true)), 150, new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(8).saturationMod(0.6F).effect(()->new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true), 1).build())));
    public static final RegistryObject<Item> TROPICAL_MEDLEY = ITEM_DEFERRED_REGISTER.register("tropical_medley",()-> new EffectFoodItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(8).saturationMod(0.6F).effect(()->new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true), 1).build())));
    public static final RegistryObject<Item> STUFFED_HOARY_APPLE = ITEM_DEFERRED_REGISTER.register("stuffed_hoary_apple",()-> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationMod(0.5F).build())));
    public static final RegistryObject<Item> CRIMSON_CHOW = ITEM_DEFERRED_REGISTER.register("crimson_chow",()-> new StackableBowlFoodItem(new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(10).saturationMod(0.8F).build()).craftRemainder(Items.BOWL)));
    public static final RegistryObject<Item> WARPED_CHOW = ITEM_DEFERRED_REGISTER.register("warped_chow",()-> new StackableBowlFoodItem(new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(8).saturationMod(0.7F).build()).craftRemainder(Items.BOWL)));

    public static final RegistryObject<Item> CUSTARD = ITEM_DEFERRED_REGISTER.register("custard",()-> new StackableBowlFoodItem(List.of(new MobEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(5).saturationMod(1.2f).effect(new MobEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true), 1).build()).craftRemainder(Items.BOWL)));
    public static final RegistryObject<Item> PIQUANT_CUSTARD = ITEM_DEFERRED_REGISTER.register("piquant_custard",()-> new StackableBowlFoodItem(List.of(new MobEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(7).saturationMod(1.2f).effect(()->new MobEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true), 1).build()).craftRemainder(Items.BOWL)));
    public static final RegistryObject<Item> PASSION_CUSTARD = ITEM_DEFERRED_REGISTER.register("passion_custard",()-> new StackableBowlFoodItem(List.of(new MobEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(7).saturationMod(1.2f).effect(()->new MobEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true), 1).build()).craftRemainder(Items.BOWL)));
    public static final RegistryObject<Item> COCOA_CUSTARD = ITEM_DEFERRED_REGISTER.register("cocoa_custard",()-> new StackableBowlFoodItem(List.of(new MobEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(8).saturationMod(1f).effect(()->new MobEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true), 1).build()).craftRemainder(Items.BOWL)));
    public static final RegistryObject<Item> ANCIENT_CUSTARD = ITEM_DEFERRED_REGISTER.register("ancient_custard",()-> new StackableBowlFoodItem(List.of(new MobEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(8).saturationMod(1f).effect(()->new MobEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true), 1).build()).craftRemainder(Items.BOWL)));
    public static final RegistryObject<Item> MUSHROOM_STUFFED_POTATO = ITEM_DEFERRED_REGISTER.register("mushroom_stuffed_potato",()-> new EffectFoodItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 1800, 0, true, true)), new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationMod(0.6F).effect(()->new MobEffectInstance(BFEffects.ENRICHMENT, 1800, 0, true, true), 1).build())));
    public static final RegistryObject<Item> BERRY_STUFFED_POTATO = ITEM_DEFERRED_REGISTER.register("berry_stuffed_potato",()-> new EffectFoodItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true)), new Item.Properties().food(new FoodProperties.Builder().nutrition(7).saturationMod(0.5F).effect(()->new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true), 1).build())));
    public static final RegistryObject<Item> MAIZE_STUFFED_POTATO = ITEM_DEFERRED_REGISTER.register("maize_stuffed_potato",()-> new EffectFoodItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true)), new Item.Properties().food(new FoodProperties.Builder().nutrition(7).saturationMod(0.6F).effect(()->new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true), 1).build())));
    public static final RegistryObject<Item> MAIZE_BREAD = ITEM_DEFERRED_REGISTER.register("maize_bread",()-> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationMod(0.5F).build())));
    public static final RegistryObject<Item> WALNUT_COOKIE = ITEM_DEFERRED_REGISTER.register("walnut_cookie",()-> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build())));
    public static final RegistryObject<Item> CANDIED_APPLE = ITEM_DEFERRED_REGISTER.register("candied_apple",()-> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(0.5F).build())));
    public static final RegistryObject<Item> CANDIED_PLUM = ITEM_DEFERRED_REGISTER.register("candied_plum",()-> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(0.5F).build())));
    public static final RegistryObject<Item> DIRT_STEW = ITEM_DEFERRED_REGISTER.register("dirt_stew",()-> new OPStewItem(new Item.Properties().stacksTo(99).food(new FoodProperties.Builder().nutrition(1000).saturationMod(1000)
            .effect(()->new MobEffectInstance(BFEffects.RESTORATION, 72000, 10, true, true), 1)
            .effect(()->new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 72000, 10, true, true), 1)
            .effect(()->new MobEffectInstance(MobEffects.ABSORPTION, 72000, 10, true, true), 1)
            .effect(()->new MobEffectInstance(MobEffects.HEALTH_BOOST, 72000, 25, true, true), 1)
            .build())));


    // private static Item ITEM_DEFERRED_REGISTER.register(String name, Supplier<Item> item) {
    //     // return Registry.register(BuiltInRegistries.ITEM, BountifulFares.rl( name), item);
    //     items.put(ResourceKey.create(Registries.ITEM, BountifulFares.rl(name)), item);
    //     return item;
    // }
    // public static void registerModItems() {
    // }

    // @SubscribeEvent
    // public static void blockRegister(RegisterEvent event) {
    //     event.register(Registries.ITEM, registerHelper -> {
    //         items.forEach(registerHelper::register);
    //     });
    // }
}
