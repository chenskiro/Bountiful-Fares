package com.xueluoanping.bountifulfaresforge.registry;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.misc.BFPlacedFeatures;
import net.hecco.bountifulfares.registry.tags.BFBiomeTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.holdersets.OrHolderSet;

import java.util.List;

public class BFBiomeModifiers {

    public static final ResourceKey<BiomeModifier> APPLE = createKey("trees/apple");
    public static final ResourceKey<BiomeModifier> ORANGE = createKey("trees/orange");
    public static final ResourceKey<BiomeModifier> LEMON = createKey("trees/lemon");
    public static final ResourceKey<BiomeModifier> PLUM = createKey("trees/plum");
    public static final ResourceKey<BiomeModifier> WALNUT = createKey("trees/walnut");
    public static final ResourceKey<BiomeModifier> PALM = createKey("trees/palm");

    // config
    public static final ResourceKey<BiomeModifier> PATCH_GRASSY_DIRT = createKey("ground/patch_grassy_dirt");

    // not config
    public static final ResourceKey<BiomeModifier> HONEYSUCKLE = createKey("ground/honeysuckle");
    public static final ResourceKey<BiomeModifier> VIOLET_BELLFLOWER = createKey("ground/violet_bellflower");
    public static final ResourceKey<BiomeModifier> CHAMOMILE = createKey("ground/chamomile");

    // config
    public static final ResourceKey<BiomeModifier> WILD_WHEAT = createKey("ground/wild_wheat");
    public static final ResourceKey<BiomeModifier> LARGE_WILD_WHEAT = createKey("ground/large_wild_wheat");
    public static final ResourceKey<BiomeModifier> WILD_CARROTS = createKey("ground/wild_carrots");
    public static final ResourceKey<BiomeModifier> LARGE_WILD_CARROTS = createKey("ground/large_wild_carrots");
    public static final ResourceKey<BiomeModifier> WILD_POTATOES = createKey("ground/wild_potatoes");
    public static final ResourceKey<BiomeModifier> LARGE_WILD_POTATOES = createKey("ground/large_wild_potatoes");
    public static final ResourceKey<BiomeModifier> WILD_BEETROOTS = createKey("ground/wild_beetroots");
    public static final ResourceKey<BiomeModifier> LARGE_WILD_BEETROOTS = createKey("ground/large_wild_beetroots");

    // not config
    public static final ResourceKey<BiomeModifier> WILD_LEEKS = createKey("ground/wild_leeks");
    public static final ResourceKey<BiomeModifier> LARGE_WILD_LEEKS = createKey("ground/large_wild_leeks");
    public static final ResourceKey<BiomeModifier> WILD_MAIZE = createKey("ground/wild_maize");
    public static final ResourceKey<BiomeModifier> LARGE_WILD_MAIZE = createKey("ground/large_wild_maize");
    public static final ResourceKey<BiomeModifier> TEA_SHRUB = createKey("ground/tea_shrub");

    // config
    public static final ResourceKey<BiomeModifier> WILD_PASSION_FRUIT = createKey("ground/wild_passion_fruit");
    public static final ResourceKey<BiomeModifier> WILD_ELDERBERRY = createKey("ground/wild_elderberry");
    // public static final ResourceKey<BiomeModifier> FOREST_TEA_SHRUB= createKey("ground/forest_tea_shrub");


    private static ResourceKey<BiomeModifier> createKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, BountifulFares.rl(name));
    }

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        HolderGetter<Biome> biomeGetter = context.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placedGetter = context.lookup(Registries.PLACED_FEATURE);
        context.register(APPLE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomeGetter.getOrThrow(BFBiomeTags.HAS_APPLE_TREES),
                HolderSet.direct(placedGetter.getOrThrow(BFPlacedFeatures.APPLE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ORANGE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomeGetter.getOrThrow(BFBiomeTags.HAS_ORANGE_TREES),
                HolderSet.direct(placedGetter.getOrThrow(BFPlacedFeatures.ORANGE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(LEMON, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomeGetter.getOrThrow(BFBiomeTags.HAS_LEMON_TREES),
                HolderSet.direct(placedGetter.getOrThrow(BFPlacedFeatures.LEMON_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(PLUM, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomeGetter.getOrThrow(BFBiomeTags.HAS_PLUM_TREES),
                HolderSet.direct(placedGetter.getOrThrow(BFPlacedFeatures.PLUM_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(WALNUT, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomeGetter.getOrThrow(BFBiomeTags.HAS_WALNUT_TREES),
                HolderSet.direct(placedGetter.getOrThrow(BFPlacedFeatures.WALNUT_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(PALM, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomeGetter.getOrThrow(BFBiomeTags.HAS_PALM_TREES),
                HolderSet.direct(placedGetter.getOrThrow(BFPlacedFeatures.PALM_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        // ground plant or block

        context.register(HONEYSUCKLE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomeGetter.getOrThrow(BFBiomeTags.HAS_HONEYSUCKLE),
                HolderSet.direct(placedGetter.getOrThrow(BFPlacedFeatures.HONEYSUCKLE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(VIOLET_BELLFLOWER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomeGetter.getOrThrow(BFBiomeTags.HAS_VIOLET_BELLFLOWER),
                HolderSet.direct(placedGetter.getOrThrow(BFPlacedFeatures.VIOLET_BELLFLOWER_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(CHAMOMILE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomeGetter.getOrThrow(BFBiomeTags.HAS_CHAMOMILE),
                HolderSet.direct(placedGetter.getOrThrow(BFPlacedFeatures.CHAMOMILE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(WILD_LEEKS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomeGetter.getOrThrow(BFBiomeTags.HAS_WILD_LEEKS),
                HolderSet.direct(placedGetter.getOrThrow(BFPlacedFeatures.WILD_LEEKS_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(LARGE_WILD_LEEKS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomeGetter.getOrThrow(BFBiomeTags.HAS_LARGE_WILD_LEEKS),
                HolderSet.direct(placedGetter.getOrThrow(BFPlacedFeatures.LARGE_WILD_LEEKS_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(WILD_MAIZE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomeGetter.getOrThrow(BFBiomeTags.HAS_WILD_MAIZE),
                HolderSet.direct(placedGetter.getOrThrow(BFPlacedFeatures.WILD_MAIZE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(LARGE_WILD_MAIZE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomeGetter.getOrThrow(BFBiomeTags.HAS_LARGE_WILD_MAIZE),
                HolderSet.direct(placedGetter.getOrThrow(BFPlacedFeatures.LARGE_WILD_MAIZE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(TEA_SHRUB, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomeGetter.getOrThrow(BFBiomeTags.HAS_TEA_SHRUB),
                HolderSet.direct(placedGetter.getOrThrow(BFPlacedFeatures.TEA_SHRUB_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        // start config
        context.register(PATCH_GRASSY_DIRT, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                new OrHolderSet<>(List.of(HolderSet.direct(biomeGetter.getOrThrow(Biomes.FOREST)), HolderSet.direct(biomeGetter.getOrThrow(Biomes.FLOWER_FOREST)), HolderSet.direct(biomeGetter.getOrThrow(Biomes.BIRCH_FOREST)), HolderSet.direct(biomeGetter.getOrThrow(Biomes.DARK_FOREST)), HolderSet.direct(biomeGetter.getOrThrow(Biomes.OLD_GROWTH_BIRCH_FOREST)))),
                HolderSet.direct(placedGetter.getOrThrow(BFPlacedFeatures.PATCH_GRASSY_DIRT_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(WILD_WHEAT, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomeGetter.getOrThrow(BFBiomeTags.HAS_WILD_WHEAT),
                HolderSet.direct(placedGetter.getOrThrow(BFPlacedFeatures.WILD_WHEAT_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(LARGE_WILD_WHEAT, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomeGetter.getOrThrow(BFBiomeTags.HAS_LARGE_WILD_WHEAT),
                HolderSet.direct(placedGetter.getOrThrow(BFPlacedFeatures.LARGE_WILD_WHEAT_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(WILD_CARROTS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomeGetter.getOrThrow(BFBiomeTags.HAS_WILD_CARROTS),
                HolderSet.direct(placedGetter.getOrThrow(BFPlacedFeatures.WILD_CARROTS_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(LARGE_WILD_CARROTS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomeGetter.getOrThrow(BFBiomeTags.HAS_LARGE_WILD_CARROTS),
                HolderSet.direct(placedGetter.getOrThrow(BFPlacedFeatures.LARGE_WILD_CARROTS_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(WILD_POTATOES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomeGetter.getOrThrow(BFBiomeTags.HAS_WILD_POTATOES),
                HolderSet.direct(placedGetter.getOrThrow(BFPlacedFeatures.WILD_POTATOES_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(LARGE_WILD_POTATOES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomeGetter.getOrThrow(BFBiomeTags.HAS_LARGE_WILD_POTATOES),
                HolderSet.direct(placedGetter.getOrThrow(BFPlacedFeatures.LARGE_WILD_POTATOES_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(WILD_BEETROOTS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomeGetter.getOrThrow(BFBiomeTags.HAS_WILD_BEETROOT),
                HolderSet.direct(placedGetter.getOrThrow(BFPlacedFeatures.WILD_BEETROOTS_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(LARGE_WILD_BEETROOTS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomeGetter.getOrThrow(BFBiomeTags.HAS_LARGE_WILD_BEETROOT),
                HolderSet.direct(placedGetter.getOrThrow(BFPlacedFeatures.LARGE_WILD_BEETROOTS_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
    }
}
