package net.hecco.bountifulfares.datagen.bountifulfares;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.BountifulFaresUtil;
import net.hecco.bountifulfares.compat.arts_and_crafts.ArtsAndCraftsBlocks;
import net.hecco.bountifulfares.compat.delicate_dyes.DelicateDyesBlocks;
import net.hecco.bountifulfares.compat.dungeons_delight.DungeonsDelightBlocks;
import net.hecco.bountifulfares.compat.dye_depot.DyeDepotBlocks;
import net.hecco.bountifulfares.compat.excessive_building.ExcessiveBuildingBlocks;
import net.hecco.bountifulfares.compat.farmersdelight.FarmersDelightBlocks;
import net.hecco.bountifulfares.compat.mint.MintBlocks;
import net.hecco.bountifulfares.compat.natures_spirit.NaturesSpiritBlocks;
import net.hecco.bountifulfares.compat.spawn.SpawnBlocks;
import net.hecco.bountifulfares.datagen.yapping.YappingCompatLangProvider;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.content.BFTrellises;
import net.hecco.bountifulfares.registry.misc.BFCompat;
import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.hecco.bountifulfares.trellis.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.trellis.trellis_parts.VineCrop;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static net.hecco.bountifulfares.BountifulFaresUtil.toSentenceCase;

public class BFLangProvider extends LanguageProvider {
    Set<String> usedTranslationKeys = new HashSet<>();

    public BFLangProvider(PackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput,BountifulFares.MOD_ID, "en_us");
    }

    private void generate( String key, String translation) {
        if(usedTranslationKeys.contains(key)) {
            return;
        }
        add(key, translation);
        usedTranslationKeys.add(key);
    }
    private void generate( Block block, String translation) {
        generate( block.getDescriptionId(), translation);
    }

    private void generate( Block block) {
        generate( block.getDescriptionId(), toSentenceCase(BuiltInRegistries.BLOCK.getKey(block).getPath()));
    }

    private void generate( Item item, String translation) {
        generate( item.getDescriptionId(), translation);
    }

    private void generateJackOStraw( Block block, String color) {
        generate( block, color + " Jack O' Straw");
    }

    private void generateTag( TagKey<Item> itemTag, String translation) {
        generate( itemTag.location().toLanguageKey("tag.item"), translation);
    }


    @Override
    public void addTranslations() {
        generate( "itemgroup.bountiful_fares", "Bountiful Fares");
        generate( BFBlocks.HANGING_APPLE.get(), "Apple");
        add( BFBlocks.HANGING_ORANGE.get(), "Orange");
        generate( BFBlocks.HANGING_LEMON.get(), "Lemon");
        generate( BFBlocks.HANGING_PLUM.get(), "Plum");
        generate( BFBlocks.HANGING_GOLDEN_APPLE.get(), "Golden Apple");
        generate( BFBlocks.HANGING_WITHERED_GOLDEN_APPLE.get(), "Withered Golden Apple");



        generate( BFBlocks.HOARY_APPLE_SAPLING_CROP.get(), "Hoary Apple Sapling");
        // generate( BFItems.HOARY_CHEST_BOAT.get(), "Hoary Boat with Chest");
        generate( BFBlocks.HANGING_HOARY_APPLE.get(), "Hoary Apple");

        generate( BFBlocks.CERAMIC_CLAY_BLOCK.get(), "Block of Ceramic Clay");


        // generate( BFItems.WALNUT_CHEST_BOAT.get(), "Walnut Boat with Chest");

        generate( BFBlocks.HANGING_WALNUTS.get(), "Walnuts");


        generate( BFBlocks.WALL_PALM_FROND.get(), "Palm Frond");

        generate( BFBlocks.HOARY_SIGN.get(), "Hoary Sign");
        generate( BFBlocks.HOARY_WALL_SIGN.get(), "Hoary Sign");
        generate( BFItems.HOARY_SIGN.get(), "Hoary Sign");
        generate( BFBlocks.HOARY_HANGING_SIGN.get(), "Hoary Hanging Sign");
        generate( BFBlocks.HOARY_WALL_HANGING_SIGN.get(), "Hoary Hanging Sign");
        generate( BFItems.HOARY_HANGING_SIGN.get(), "Hoary Hanging Sign");

        generate( BFBlocks.WALNUT_SIGN.get(), "Walnut Sign");
        generate( BFBlocks.WALNUT_WALL_SIGN.get(), "Walnut Sign");
        generate( BFItems.WALNUT_SIGN.get(), "Walnut Sign");
        generate( BFBlocks.WALNUT_HANGING_SIGN.get(), "Walnut Hanging Sign");
        generate( BFBlocks.WALNUT_WALL_HANGING_SIGN.get(), "Walnut Hanging Sign");
        generate( BFItems.WALNUT_HANGING_SIGN.get(), "Walnut Hanging Sign");

        generate( "effect.bountifulfares.acidic", "Acidic");
        generate( "item.minecraft.potion.effect.bountifulfares.acidic", "Potion of Acidity");
        generate( "item.minecraft.potion.effect.bountifulfares.long_acidic", "Potion of Acidity");
        generate( "item.minecraft.potion.effect.bountifulfares.strong_acidic", "Potion of Acidity");
        generate( "item.minecraft.splash_potion.effect.bountifulfares.acidic", "Splash Potion of Acidity");
        generate( "item.minecraft.splash_potion.effect.bountifulfares.long_acidic", "Splash Potion of Acidity");
        generate( "item.minecraft.splash_potion.effect.bountifulfares.strong_acidic", "Splash Potion of Acidity");
        generate( "item.minecraft.lingering_potion.effect.bountifulfares.acidic", "Lingering Potion of Acidity");
        generate( "item.minecraft.lingering_potion.effect.bountifulfares.long_acidic", "Lingering Potion of Acidity");
        generate( "item.minecraft.lingering_potion.effect.bountifulfares.strong_acidic", "Lingering Potion of Acidity");
        generate( "item.minecraft.tipped_arrow.effect.bountifulfares.acidic", "Arrow of Acidity");
        generate( "item.minecraft.tipped_arrow.effect.bountifulfares.long_acidic", "Arrow of Acidity");
        generate( "item.minecraft.tipped_arrow.effect.bountifulfares.strong_acidic", "Arrow of Acidity");
        generate( "effect.bountifulfares.acidic.description", "Increases the amplifier of all other effects applied. Reverts after Acidic is removed.");
        generate( "effect.bountifulfares.stupor", "Stupor");
        generate( "item.minecraft.potion.effect.bountifulfares.stupor", "Potion of Stupor");
        generate( "item.minecraft.potion.effect.bountifulfares.long_stupor", "Potion of Stupor");
        generate( "item.minecraft.splash_potion.effect.bountifulfares.stupor", "Splash Potion of Stupor");
        generate( "item.minecraft.splash_potion.effect.bountifulfares.long_stupor", "Splash Potion of Stupor");
        generate( "item.minecraft.lingering_potion.effect.bountifulfares.stupor", "Lingering Potion of Stupor");
        generate( "item.minecraft.lingering_potion.effect.bountifulfares.long_stupor", "Lingering Potion of Stupor");
        generate( "item.minecraft.tipped_arrow.effect.bountifulfares.stupor", "Arrow of Stupor");
        generate( "item.minecraft.tipped_arrow.effect.bountifulfares.long_stupor", "Arrow of Stupor");
        generate( "effect.bountifulfares.stupor.description", "Removes all effects and stops effects from applying for its duration.");


        generate( "effect.bountifulfares.restoration", "Restoration");
        generate( "effect.bountifulfares.restoration.description", "Regenerates health up to the health when it was applied.");
        generate( "effect.bountifulfares.enrichment", "Enrichment");
        generate( "effect.bountifulfares.enrichment.description", "Minor buffs to most stats.");



        generate( TrellisUtil.getTrellisFromVariant(BFTrellises.OAK).get(), "Oak Trellis");
        generate( TrellisUtil.getTrellisFromVariant(BFTrellises.SPRUCE).get());
        generate( TrellisUtil.getTrellisFromVariant(BFTrellises.BIRCH).get());
        generate( TrellisUtil.getTrellisFromVariant(BFTrellises.JUNGLE).get());
        generate( TrellisUtil.getTrellisFromVariant(BFTrellises.ACACIA).get());
        generate( TrellisUtil.getTrellisFromVariant(BFTrellises.DARK_OAK).get());
        generate( TrellisUtil.getTrellisFromVariant(BFTrellises.MANGROVE).get());
        generate( TrellisUtil.getTrellisFromVariant(BFTrellises.CHERRY).get());
        generate( TrellisUtil.getTrellisFromVariant(BFTrellises.BAMBOO).get());
        generate( TrellisUtil.getTrellisFromVariant(BFTrellises.WALNUT).get());
        generate( TrellisUtil.getTrellisFromVariant(BFTrellises.HOARY).get());
        generate( TrellisUtil.getTrellisFromVariant(BFTrellises.CRIMSON).get());
        generate( TrellisUtil.getTrellisFromVariant(BFTrellises.WARPED).get());

        generate( TrellisUtil.getTrellisFromVariant(ExcessiveBuildingBlocks.ANCIENT).get());

        generate( TrellisUtil.getTrellisFromVariant(MintBlocks.WINTERGREEN).get());

        generate( TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.ASPEN).get());
        generate( TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.CEDAR).get());
        generate( TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.COCONUT).get());
        generate( TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.CYPRESS).get());
        generate( TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.FIR).get());
        generate( TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.GHAF).get());
        generate( TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.JOSHUA).get());
        generate( TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.LARCH).get());
        generate( TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.MAHOGANY).get());
        generate( TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.MAPLE).get());
        generate( TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.OLIVE).get());
        generate( TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.PALO_VERDE).get());
        generate( TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.SAXAUL).get());
        generate( TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.SUGI).get());
        generate( TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.WILLOW).get());
        generate( TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.WISTERIA).get());

        generate( TrellisUtil.getTrellisFromVariant(SpawnBlocks.ROTTEN).get());

        generate( TrellisUtil.getTrellisFromVariant(ArtsAndCraftsBlocks.CORK).get());

        generate( TrellisUtil.getTrellisFromVariant(DungeonsDelightBlocks.WORMWOOD).get());



        generate( BFBlocks.MAIZE_CROP.get(), "Maize");



        generate( "effect.bountifulfares.ebullience", "Ebullience");
        generate( "effect.bountifulfares.ebullience.description", "Negates exhaustion from actions like mining or walking.");
//        generate( "effect.bountifulfares.gorging", "Gorging");


        generateJackOStraw( BFBlocks.RED_JACK_O_STRAW.get(), "Red");
        generateJackOStraw( BFBlocks.ORANGE_JACK_O_STRAW.get(), "Orange");
        generateJackOStraw( BFBlocks.YELLOW_JACK_O_STRAW.get(), "Yellow");
        generateJackOStraw( BFBlocks.LIME_JACK_O_STRAW.get(), "Lime");
        generateJackOStraw( BFBlocks.GREEN_JACK_O_STRAW.get(), "Green");
        generateJackOStraw( BFBlocks.CYAN_JACK_O_STRAW.get(), "Cyan");
        generateJackOStraw( BFBlocks.LIGHT_BLUE_JACK_O_STRAW.get(), "Light Blue");
        generateJackOStraw( BFBlocks.BLUE_JACK_O_STRAW.get(), "Blue");
        generateJackOStraw( BFBlocks.PURPLE_JACK_O_STRAW.get(), "Purple");
        generateJackOStraw( BFBlocks.MAGENTA_JACK_O_STRAW.get(), "Magenta");
        generateJackOStraw( BFBlocks.PINK_JACK_O_STRAW.get(), "Pink");
        generateJackOStraw( BFBlocks.WHITE_JACK_O_STRAW.get(), "White");
        generateJackOStraw( BFBlocks.LIGHT_GRAY_JACK_O_STRAW.get(), "Light Gray");
        generateJackOStraw( BFBlocks.GRAY_JACK_O_STRAW.get(), "Gray");
        generateJackOStraw( BFBlocks.BLACK_JACK_O_STRAW.get(), "Black");
        generateJackOStraw( BFBlocks.BROWN_JACK_O_STRAW.get(), "Brown");

        generateJackOStraw( MintBlocks.ACORN_JACK_O_STRAW.get(), "Acorn");
        generateJackOStraw( MintBlocks.AMBER_JACK_O_STRAW.get(), "Amber");
        generateJackOStraw( MintBlocks.ARTICHOKE_JACK_O_STRAW.get(), "Artichoke");
        generateJackOStraw( MintBlocks.BANANA_JACK_O_STRAW.get(), "Banana");
        generateJackOStraw( MintBlocks.CERULEAN_JACK_O_STRAW.get(), "Cerulean");
        generateJackOStraw( MintBlocks.FUCHSIA_JACK_O_STRAW.get(), "Fuchsia");
        generateJackOStraw( MintBlocks.GRAPE_JACK_O_STRAW.get(), "Grape");
        generateJackOStraw( MintBlocks.INDIGO_JACK_O_STRAW.get(), "Indigo");
        generateJackOStraw( MintBlocks.MAROON_JACK_O_STRAW.get(), "Maroon");
        generateJackOStraw( MintBlocks.MAUVE_JACK_O_STRAW.get(), "Mauve");
        generateJackOStraw( MintBlocks.MINT_JACK_O_STRAW.get(), "Mint");
        generateJackOStraw( MintBlocks.MOLD_JACK_O_STRAW.get(), "Mold");
        generateJackOStraw( MintBlocks.NAVY_JACK_O_STRAW.get(), "Navy");
        generateJackOStraw( MintBlocks.PEACH_JACK_O_STRAW.get(), "Peach");
        generateJackOStraw( MintBlocks.PERIWINKLE_JACK_O_STRAW.get(), "Periwinkle");
        generateJackOStraw( MintBlocks.SAGE_JACK_O_STRAW.get(), "Sage");
        generateJackOStraw( MintBlocks.SAP_JACK_O_STRAW.get(), "Sap");
        generateJackOStraw( MintBlocks.SHAMROCK_JACK_O_STRAW.get(), "Shamrock");
        generateJackOStraw( MintBlocks.VELVET_JACK_O_STRAW.get(), "Velvet");
        generateJackOStraw( MintBlocks.VERMILION_JACK_O_STRAW.get(), "Vermilion");

        generateJackOStraw( DyeDepotBlocks.MAROON_JACK_O_STRAW.get(), "Maroon");
        generateJackOStraw( DyeDepotBlocks.ROSE_JACK_O_STRAW.get(), "Rose");
        generateJackOStraw( DyeDepotBlocks.CORAL_JACK_O_STRAW.get(), "Coral");
        generateJackOStraw( DyeDepotBlocks.GINGER_JACK_O_STRAW.get(), "Ginger");
        generateJackOStraw( DyeDepotBlocks.TAN_JACK_O_STRAW.get(), "Tan");
        generateJackOStraw( DyeDepotBlocks.BEIGE_JACK_O_STRAW.get(), "Beige");
        generateJackOStraw( DyeDepotBlocks.AMBER_JACK_O_STRAW.get(), "Amber");
        generateJackOStraw( DyeDepotBlocks.OLIVE_JACK_O_STRAW.get(), "Olive");
        generateJackOStraw( DyeDepotBlocks.FOREST_JACK_O_STRAW.get(), "Forest");
        generateJackOStraw( DyeDepotBlocks.VERDANT_JACK_O_STRAW.get(), "Verdant");
        generateJackOStraw( DyeDepotBlocks.TEAL_JACK_O_STRAW.get(), "Teal");
        generateJackOStraw( DyeDepotBlocks.MINT_JACK_O_STRAW.get(), "Mint");
        generateJackOStraw( DyeDepotBlocks.AQUA_JACK_O_STRAW.get(), "Aqua");
        generateJackOStraw( DyeDepotBlocks.SLATE_JACK_O_STRAW.get(), "Slate");
        generateJackOStraw( DyeDepotBlocks.NAVY_JACK_O_STRAW.get(), "Navy");
        generateJackOStraw( DyeDepotBlocks.INDIGO_JACK_O_STRAW.get(), "Indigo");

        generateJackOStraw( DelicateDyesBlocks.CORAL_JACK_O_STRAW.get(), "Coral");
        generateJackOStraw( DelicateDyesBlocks.CANARY_JACK_O_STRAW.get(), "Canary");
        generateJackOStraw( DelicateDyesBlocks.WASABI_JACK_O_STRAW.get(), "Wasabi");
        generateJackOStraw( DelicateDyesBlocks.SACRAMENTO_JACK_O_STRAW.get(), "Sacramento");
        generateJackOStraw( DelicateDyesBlocks.SKY_JACK_O_STRAW.get(), "Sky");
        generateJackOStraw( DelicateDyesBlocks.BLURPLE_JACK_O_STRAW.get(), "Blurple");
        generateJackOStraw( DelicateDyesBlocks.SANGRIA_JACK_O_STRAW.get(), "Sangria");
        generateJackOStraw( DelicateDyesBlocks.ROSE_JACK_O_STRAW.get(), "Rose");



        generate( "tooltip.bountifulfares.dyeable", "Dyeable");
        generate( "tooltip.bountifulfares.when_lit", "When lit:");
        generate( "tooltip.bountifulfares.removes", "Removes:");
        generate( "tooltip.bountifulfares.when_eaten", "When eaten:");
        generate( "tooltip.bountifulfares.when_drunk", "When drunk:");
        generate( "tooltip.bountifulfares.air_time", "Oxygen");
        generate( "tooltip.bountifulfares.removes_all_effects", "Removes all effects");


        generate( "painting.bountifulfares.bountiful.title", "Bountiful");
        generate( "painting.bountifulfares.bountiful.author", "Hecco");
//        generate( "painting.bountifulfares.sponge_house.title", "Sponge House");
//        generate( "painting.bountifulfares.sponge_house.author", "Hecco");
        generate( "painting.bountifulfares.citrus_dish.title", "Citrus Dish");
        generate( "painting.bountifulfares.citrus_dish.author", "Hecco");
//        generate( "painting.bountifulfares.mulcher.title", "Mulcher");
//        generate( "painting.bountifulfares.mulcher.author", "Hecco");
        generate( "painting.bountifulfares.ruminer.title", "Ruminer");
        generate( "painting.bountifulfares.ruminer.author", "Hecco");
        generate( "painting.bountifulfares.hazel_floret.title", "Hazel Floret");
        generate( "painting.bountifulfares.hazel_floret.author", "Hecco");
        generate( "painting.bountifulfares.violet_floret.title", "Violet Floret");
        generate( "painting.bountifulfares.violet_floret.author", "Hecco");
        generate( "painting.bountifulfares.why_blue.title", "Why Blue");
        generate( "painting.bountifulfares.why_blue.author", "Hecco");
        generate( "painting.bountifulfares.phylogenesis.title", "Phylogenesis");
        generate( "painting.bountifulfares.phylogenesis.author", "Hecco");
        generate( "painting.bountifulfares.escalade.title", "Escalade");
        generate( "painting.bountifulfares.escalade.author", "Hecco");
        generate( "painting.bountifulfares.aquaculture.title", "Aquaculture");
        generate( "painting.bountifulfares.aquaculture.author", "Hecco");
        generate( "painting.bountifulfares.unpleasant_tiles.title", "Unpleasant Tiles");
        generate( "painting.bountifulfares.unpleasant_tiles.author", "Hecco");

        generate( "warning.bountifulfares.fermentation_vessel.minecraft:glass_bottle", "Use a Glass Bottle to collect this");
        generate( "warning.bountifulfares.fermentation_vessel.bountifulfares:jar", "Use a Jar to collect this");
        generate( "warning.bountifulfares.fermentation_vessel.minecraft:bucket", "Use a Bucket to collect this");
        generate( "warning.bountifulfares.fermentation_vessel.minecraft:bowl", "Use a Bowl to collect this");

        generate( "advancement.bountifulfares.bountiful_fares", "Bountiful Fares");
        generate( "advancement.bountifulfares.bountiful_fares.description", "The world is filled with more food!");

        generate( "advancement.bountifulfares.place_gristmill", "On The Grind");
        generate( "advancement.bountifulfares.place_gristmill.description", "Place a Gristmill");

        generate( "advancement.bountifulfares.obtain_feldspar", "Felsic Forager");
        generate( "advancement.bountifulfares.obtain_feldspar.description", "Collect Feldspar from milling stones");

        generate( "advancement.bountifulfares.obtain_ceramic_tiles", "Roy G Biv");
        generate( "advancement.bountifulfares.obtain_ceramic_tiles.description", "Craft any dyeable ceramic block");

        generate( "advancement.bountifulfares.feed_wolf_mulch", "Mulchmaxxer");
        generate( "advancement.bountifulfares.feed_wolf_mulch.description", "Feed a wolf mulch");

        generate( "advancement.bountifulfares.how_easy", "How Easy...");
        generate( "advancement.bountifulfares.how_easy.description", "Threaten to squeeze a Lemon Block");

        generate( "advancement.bountifulfares.obtain_fermentation_vessel", "Toil And Trouble");
        generate( "advancement.bountifulfares.obtain_fermentation_vessel.description", "Craft a Fermentation Vessel");

        generate( "advancement.bountifulfares.eat_ancient_fruit", "How Long Has This Sat Out?");
        generate( "advancement.bountifulfares.eat_ancient_fruit.description", "Eat a fruit from the distant past");

        generate( "advancement.bountifulfares.place_all_baked_goods", "Baker's Dozen");
        generate( "advancement.bountifulfares.place_all_baked_goods.description", "Place every baked good");

        generate( "advancement.bountifulfares.eat_citrus_essence", "Pass The Antacid");
        generate( "advancement.bountifulfares.eat_citrus_essence.description", "Eat Citric Essence");

//        generate( "advancement.bountifulfares.throw_flour", "Great Escape");
//        generate( "advancement.bountifulfares.throw_flour.description", "Throw Flour");

        generate( "advancement.bountifulfares.obtain_sun_hat", "Who's the Farmer Now?");
        generate( "advancement.bountifulfares.obtain_sun_hat.description", "Obtain a Sun Hat");

        generate( "advancement.bountifulfares.eat_all_candy", "Sweet Tooth");
        generate( "advancement.bountifulfares.eat_all_candy.description", "Eat every Candy");

        generate( "advancement.bountifulfares.gorge", "Maybe One More...");
        generate( "advancement.bountifulfares.gorge.description", "Gorge");

        generate( "advancement.bountifulfares.obtain_tea_blends", "Tea Tea");
        generate( "advancement.bountifulfares.obtain_tea_blends.description", "Obtain every Tea Blend");

        generate( "advancement.bountifulfares.place_all_tea_candles", "Fragrant!");
        generate( "advancement.bountifulfares.place_all_tea_candles.description", "Place every Tea Candle");

        generate( "advancement.bountifulfares.obtain_walnut", "Insert Funny Nut Phrase");
        generate( "advancement.bountifulfares.obtain_walnut.description", "Find a Walnut");

        generate( "advancement.bountifulfares.obtain_spongekin_seeds", "A Spongy Place");
        generate( "advancement.bountifulfares.obtain_spongekin_seeds.description", "Discover the source of all these Sponges...");

        generate( "advancement.bountifulfares.obtain_spongekin", "Who Lives In A Loofah Under The Sea");
        generate( "advancement.bountifulfares.obtain_spongekin.description", "Grow and collect a Spongekin");

        generate( "advancement.bountifulfares.make_first_food", "Anyone Can Cook");
        generate( "advancement.bountifulfares.make_first_food.description", "Make your first meal");

        generate( "advancement.bountifulfares.eat_all_food", "Bountiful Fares");
        generate( "advancement.bountifulfares.eat_all_food.description", "Eat every food");

        generate( "subtitles.block.gristmill.grind", "Gristmill mills");
        generate( "subtitles.entity.flour.throw", "Flour flies");
        generate( "subtitles.entity.flour.land", "Flour billows");

        generate( "subtitles.block.fermentation_vessel.fill", "Fermentation Vessel fills");
        generate( "subtitles.block.fermentation_vessel.splash", "Fermentation Vessel splashes");
        generate( "subtitles.block.fermentation_vessel.empty", "Fermentation Vessel empties");
        generate( "subtitles.block.fermentation_vessel.ferment", "Fermentation Vessel ferments");
        generate( "subtitles.block.hanging_fruit.pick", "Fruit pops");

        generate( "subtitles.block.coconut.land", "Coconut thuds");
        generate( "subtitles.block.coconut.bonk", "Coconut bonks");

        generate( "subtitles.block.golden_apple.wither", "Golden Apple withers");

        generate( "subtitles.block.popped_maize.pop", "Maize pops");



        generate( "config.bountifulfares.title", "Bountiful Fares Configuration");

//        generate( "config.bountifulfares.category.client", "Client");
        generate( "config.bountifulfares.category.gameplay", "Gameplay");
        generate( "config.bountifulfares.category.paintings", "Paintings");
        generate( "config.bountifulfares.category.world", "World");
        generate( "config.bountifulfares.category.client", "Client");
        generate( "config.bountifulfares.category.compat", "Compatibility");
        generate( "config.bountifulfares.category.mint", "El's and L's Dye Mod");
        generate( "config.bountifulfares.category.dye_depot", "Dye Depot");

        generate( "config.bountifulfares.restart_warning", "Requires a restart to apply changes");

//        generate( "config.bountifulfares.item_guide_tooltips", "Show information in some items' tooltip");
        generate( "config.bountifulfares.fruit_replace_when_picked", "Fruits on trees replant when picked");
        generate( "config.bountifulfares.flour_throwing", "Flour can be thrown");
        generate( "config.bountifulfares.flour_throwing_cooldown", "Flour throwing cooldown, in ticks");
        generate( "config.bountifulfares.container_foods_eatable_on_dish", "Foods with containers can be eaten on Ceramic Dishes");
        generate( "config.bountifulfares.restoration_overlay", "Restoration effect changes health icons");
        generate( "config.bountifulfares.acidified_effect_icon_effects", "Status Effects modified by Acidity have visual effects");
        generate( "config.bountifulfares.effect_tooltips", "Foods have effect tooltips");
        generate( "config.subterrous.particle_tint_override_msg", "Disable this if it is causing issues.");
        generate( "config.bountifulfares.placeable_pumpkin_pie", "Pumpkin Pie can be placed as a block");
        generate( "config.bountifulfares.cake_eating_sounds", "Cakes make eating sounds");
        generate( "config.bountifulfares.sweet_berry_pips", "Sweet Berries cannot place Sweet Berry Bushes");
        generate( "config.bountifulfares.lapisberry_seeds", "Sniffers can dig up Lapisberry Seeds");
        generate( "config.bountifulfares.hoary_seeds", "Sniffers can dig up Hoary Seeds");
        generate( "config.bountifulfares.grass_loot_table_override", "Grass loot tables are overridden");
        generate( "config.bountifulfares.spongekin_seeds_elder_guardian", "Elder Guardians drop Spongekin Seeds");
        generate( "config.bountifulfares.spongekin_seeds_guardian", "Guardians drop Spongekin Seeds");
        generate( "config.bountifulfares.milling_time", "Gristmill milling time, in seconds");
        generate( "config.bountifulfares.fermentation_time", "Fermentation time, in seconds");
        generate( "config.bountifulfares.fermentation_bubble_particles", "Fermentation Vessels emit bubble particles");
        generate( "config.bountifulfares.infused_candle_radius", "Size of area where Infused Candles give effects");
        generate( "config.bountifulfares.show_compat_items_in_recipe_viewers", "Show compatibility items in recipe viewers");
//        generate( "config.bountifulfares.bountiful_painting", "Allow \"Bountiful\" painting to be placed");
//        generate( "config.bountifulfares.citrus_dish_painting", "Allow \"Citrus Dish\" painting to be placed");
//        generate( "config.bountifulfares.hazel_floret_painting", "Allow \"Hazel Floret\" painting to be placed");
//        generate( "config.bountifulfares.violet_floret_painting", "Allow \"Violet Floret\" painting to be placed");
//        generate( "config.bountifulfares.why_blue_painting", "Allow \"Why Blue\" painting to be placed");
//        generate( "config.bountifulfares.ruminer_painting", "Allow \"Ruminer\" painting to be placed");
//        generate( "config.bountifulfares.phylogenesis_painting", "Allow \"Phylogenesis\" painting to be placed");
//        generate( "config.bountifulfares.escalade_painting", "Allow \"Escalade\" painting to be placed");
//        generate( "config.bountifulfares.aquaculture_painting", "Allow \"Aquaculture\" painting to be placed");
//        generate( "config.bountifulfares.unpleasant_tiles_painting", "Allow \"Unpleasant Tiles\" painting to be placed");
        generate( "config.bountifulfares.wild_wheat", "Generate Wild Wheat");
        generate( "config.bountifulfares.wild_carrots", "Generate Wild Carrots");
        generate( "config.bountifulfares.wild_potatoes", "Generate Wild Potatoes");
        generate( "config.bountifulfares.wild_beetroot", "Generate Wild Beetroot");
        generate( "config.bountifulfares.wild_leeks", "Generate Wild Leeks");
        generate( "config.bountifulfares.wild_maize", "Generate Wild Maize");
        generate( "config.bountifulfares.apple_trees", "Generate Apple Trees");
        generate( "config.bountifulfares.orange_trees", "Generate Orange Trees");
        generate( "config.bountifulfares.lemon_trees", "Generate Lemon Trees");
        generate( "config.bountifulfares.plum_trees", "Generate Plum Trees");
        generate( "config.bountifulfares.palm_trees", "Generate Palm Trees");
        generate( "config.bountifulfares.grassy_dirt_patches", "Generate Patches of Grassy Dirt");
        generate( "config.bountifulfares.wild_passion_fruit", "Generate Wild Passion Fruit");
        generate( "config.bountifulfares.wild_elderberries", "Generate Wild Elderberries");
        generate( "config.bountifulfares.golden_apple_tree_rooms", "Generate Golden Apple Trees in Woodland Mansions");
        generate( "config.bountifulfares.flower_forest_fruit_trees", "Generate fruit trees in Flower Forests");
        generate( "config.bountifulfares.forest_tea_shrubs", "Generate Tea Shrubs in Forests");
        generate( "config.bountifulfares.forest_walnut_trees", "Generate Walnut Trees in Forests");
//        generate( "config.bountifulfares.honeysuckle_to_banana_dye", "Honeysuckles craft into Banana Dye");
//        generate( "config.bountifulfares.rename_items_to_match_dyes", "Rename dyed items to match Dye Depot's override pack");
//        generate( "config.bountifulfares.honeysuckle_to_amber_dye", "Honeysuckles craft into Amber Dye");
//        generate( "config.bountifulfares.chamomile_to_beige_dye", "Chamomile Flowers craft into Beige Dye");

        generate( "pack.bountifulfares.vanilla_item_override", "Vanilla Item Texture Override");
        generate( "pack.bountifulfares.grass_loot_table_override", "Grass Loot Table Override");
        generate( "pack.bountifulfares.amendments", "Bountiful Fares X Amendments");
        generate( "pack.bountifulfares.mint", "Bountiful Fares X El's and L's Dye Mod");
        generate( "pack.bountifulfares.dye_depot", "Bountiful Fares X Dye Depot");
        generate( "pack.bountifulfares.natures_spirit", "Bountiful Fares X Nature's Spirit");
        generate( "pack.bountifulfares.excessive_building", "Bountiful Fares X Excessive Building");
        generate( "pack.bountifulfares.spawn", "Bountiful Fares X Spawn");
        generate( "pack.bountifulfares.farmersdelight", "Bountiful Fares X Farmer's Delight");
        generate( "pack.bountifulfares.twigs", "Bountiful Fares X Twigs");
        generate( "pack.bountifulfares.delicate_dyes", "Bountiful Fares X Delicate Dyes");
        generate( "pack.bountifulfares.appledog", "Bountiful Fares X Appledog!");
        generate( "pack.bountifulfares.dungeons_delight", "Bountiful Fares X Dungeon's Delight");

        generate( "death.attack.falling_coconut", "%1$s was bonked too hard");

        generate( "bountifulfares.milling", "Milling");
        generate( "bountifulfares.fermenting", "Fermenting");
        generate( "bountifulfares.prismarine_propagation", "Prismarine Propagation");
        generate( "jei.bountifulfares.collect_using", "Collect using ");
        generate( "jei.bountifulfares.minutes", "minutes");
        generate( "jei.bountifulfares.seconds", "seconds");

        generateTag( BFItemTags.C_MILKS, "Milks");
        generateTag( BFItemTags.C_FLOUR, "Flours");
        generateTag( BFItemTags.C_ORANGES, "Oranges");
        generateTag( BFItemTags.C_LEMONS, "Lemons");
        generateTag( BFItemTags.C_PLUMS, "Plums");
        generateTag( BFItemTags.C_PASSION_FRUIT, "Passion Fruit");
        generateTag( BFItemTags.C_ELDERBERRIES, "Elderberries");
        generateTag( BFItemTags.C_WALNUTS, "Walnuts");
        generateTag( BFItemTags.C_COCONUT_HALVES, "Coconut Halves");

        generateTag( BFItemTags.APPLE_LOGS, "Apple Logs");
        generateTag( BFItemTags.ORANGE_LOGS, "Orange Logs");
        generateTag( BFItemTags.LEMON_LOGS, "Lemon Logs");
        generateTag( BFItemTags.PLUM_LOGS, "Plum Logs");
        generateTag( BFItemTags.HOARY_LOGS, "Hoary Logs");
        generateTag( BFItemTags.WALNUT_LOGS, "Walnut Logs");
        generateTag( BFItemTags.PALM_LOGS, "Palm Logs");
        generateTag( BFItemTags.GOLDEN_APPLE_LOGS, "Golden Apple Logs");
        generateTag( BFItemTags.APPLE_LEAVES, "Apple Leaves");
        generateTag( BFItemTags.ORANGE_LEAVES, "Orange Leaves");
        generateTag( BFItemTags.LEMON_LEAVES, "Lemon Leaves");
        generateTag( BFItemTags.PLUM_LEAVES, "Plum Leaves");
        generateTag( BFItemTags.GOLDEN_APPLE_LEAVES, "Golden Apple Leaves");
        generateTag( BFItemTags.FRUIT_LOGS, "Fruit Logs");
        generateTag( BFItemTags.JACK_O_STRAW_LIGHTABLE, "Can Light Jack O' Straws");
        generateTag( BFItemTags.DYES, "Dyes");
        generateTag( BFItemTags.DYEABLE_CERAMIC_BLOCKS, "Dyeable Ceramic Blocks");
        generateTag( BFItemTags.FELSIC_STONES, "Felsic Stones");
        generateTag( BFItemTags.VINE_CROP_SEEDS, "Vine Crop Seeds");
        generateTag( BFItemTags.PLANTABLE_ON_TRELLIS, "Plantable On Trellis");
        generateTag( BFItemTags.COOKED_FISHES, "Cooked Fishes");
        generateTag( BFItemTags.MEALS, "Meals");
        generateTag( BFItemTags.GRASS_SEEDS_PLANTABLE_ON, "Can Plant Grass Seeds On");
        generateTag( BFItemTags.PICKETS, "Pickets");
        generateTag( BFItemTags.MULCH, "Mulches");
        generateTag( BFItemTags.SUGAR_INGREDIENTS, "Sugar Ingredients");

        generate( "emi.category.bountifulfares.milling", "Milling");
        generate( "emi.category.bountifulfares.fermenting", "Fermenting");
        generate( "emi.category.bountifulfares.propagation", "Prismarine Propagation");

        for(ResourceLocation id : BountifulFaresUtil.allBlockIdsInNamespace(BountifulFares.MOD_ID)) {
            String key = BuiltInRegistries.BLOCK.get(id).getDescriptionId();
            if(usedTranslationKeys.contains(key)) { continue; }
            usedTranslationKeys.add(key);
            add(key, toSentenceCase(id.getPath()));
        }
        for(ResourceLocation id : BountifulFaresUtil.allItemIdsInNamespace(BountifulFares.MOD_ID)) {
            String key = BuiltInRegistries.ITEM.get(id).getDescriptionId();
            if (usedTranslationKeys.contains(key)) {
                continue;
            }
            usedTranslationKeys.add(key);
            add(key, toSentenceCase(id.getPath()));
        }

//      for compat
        Set<Block> collectCompat = BFCompat.compatBlocks.stream().map(Supplier::get).collect(Collectors.toSet());
        for(ResourceLocation id : BountifulFaresUtil.allCompatBlockIds()) {
            String key = BuiltInRegistries.BLOCK.get(id).getDescriptionId();
            if(usedTranslationKeys.contains(key)) { continue; }
            if (collectCompat.contains(BuiltInRegistries.BLOCK.get(id))) {
                usedTranslationKeys.add(key);
                add(key, toSentenceCase(id.getPath()));
            }
        }

        YappingCompatLangProvider.generateTranslations(this);
    }
}
