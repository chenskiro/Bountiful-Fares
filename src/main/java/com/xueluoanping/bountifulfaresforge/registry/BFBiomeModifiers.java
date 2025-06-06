package com.xueluoanping.bountifulfaresforge.registry;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.misc.BFPlacedFeatures;
import net.hecco.bountifulfares.registry.tags.BFBiomeTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.holdersets.AndHolderSet;
import net.minecraftforge.registries.holdersets.OrHolderSet;

import java.util.List;

public class BFBiomeModifiers {

    public static final ResourceKey<BiomeModifier> APPLE = createKey("trees/apple");
    public static final ResourceKey<BiomeModifier> ORANGE = createKey("trees/orange");
    public static final ResourceKey<BiomeModifier> LEMON = createKey("trees/lemon");
    public static final ResourceKey<BiomeModifier> PLUM = createKey("trees/plum");
    public static final ResourceKey<BiomeModifier> WALNUT = createKey("trees/walnut");

    public static final ResourceKey<BiomeModifier> HONEYSUCKLE = createKey("ground/honeysuckle");
    public static final ResourceKey<BiomeModifier> VIOLET_BELLFLOWER = createKey("ground/violet_bellflower");
    public static final ResourceKey<BiomeModifier> CHAMOMILE = createKey("ground/chamomile");
    public static final ResourceKey<BiomeModifier> WILD_LEEKS = createKey("ground/wild_leeks");
    public static final ResourceKey<BiomeModifier> LARGE_WILD_LEEKS = createKey("ground/large_wild_leeks");
    public static final ResourceKey<BiomeModifier> WILD_MAIZE = createKey("ground/wild_maize");
    public static final ResourceKey<BiomeModifier> LARGE_WILD_MAIZE = createKey("ground/large_wild_maize");
    public static final ResourceKey<BiomeModifier> TEA_SHRUB = createKey("ground/tea_shrub");


    private static ResourceKey<BiomeModifier> createKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, BountifulFares.rl(name));
    }

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        HolderGetter<Biome> holderGetter = context.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placedFeatureHolderGetter = context.lookup(Registries.PLACED_FEATURE);
        context.register(APPLE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                holderGetter.getOrThrow(BFBiomeTags.HAS_APPLE_TREES),
                HolderSet.direct(placedFeatureHolderGetter.getOrThrow(BFPlacedFeatures.APPLE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        
        context.register(ORANGE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                holderGetter.getOrThrow(BFBiomeTags.HAS_ORANGE_TREES),
                HolderSet.direct(placedFeatureHolderGetter.getOrThrow(BFPlacedFeatures.ORANGE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        
        context.register(LEMON, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                holderGetter.getOrThrow(BFBiomeTags.HAS_LEMON_TREES),
                HolderSet.direct(placedFeatureHolderGetter.getOrThrow(BFPlacedFeatures.LEMON_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(PLUM, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                holderGetter.getOrThrow(BFBiomeTags.HAS_PLUM_TREES),
                HolderSet.direct(placedFeatureHolderGetter.getOrThrow(BFPlacedFeatures.PLUM_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        
        context.register(WALNUT, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                holderGetter.getOrThrow(BFBiomeTags.HAS_WALNUT_TREES),
                HolderSet.direct(placedFeatureHolderGetter.getOrThrow(BFPlacedFeatures.WALNUT_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        // ground plant or block

        context.register(HONEYSUCKLE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                holderGetter.getOrThrow(BFBiomeTags.HAS_HONEYSUCKLE),
                HolderSet.direct(placedFeatureHolderGetter.getOrThrow(BFPlacedFeatures.HONEYSUCKLE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(VIOLET_BELLFLOWER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                holderGetter.getOrThrow(BFBiomeTags.HAS_VIOLET_BELLFLOWER),
                HolderSet.direct(placedFeatureHolderGetter.getOrThrow(BFPlacedFeatures.VIOLET_BELLFLOWER_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(CHAMOMILE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                holderGetter.getOrThrow(BFBiomeTags.HAS_CHAMOMILE),
                HolderSet.direct(placedFeatureHolderGetter.getOrThrow(BFPlacedFeatures.CHAMOMILE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(WILD_LEEKS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                holderGetter.getOrThrow(BFBiomeTags.HAS_WILD_LEEKS),
                HolderSet.direct(placedFeatureHolderGetter.getOrThrow(BFPlacedFeatures.WILD_LEEKS_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(LARGE_WILD_LEEKS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                holderGetter.getOrThrow(BFBiomeTags.HAS_LARGE_WILD_LEEKS),
                HolderSet.direct(placedFeatureHolderGetter.getOrThrow(BFPlacedFeatures.LARGE_WILD_LEEKS_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(WILD_MAIZE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                holderGetter.getOrThrow(BFBiomeTags.HAS_WILD_MAIZE),
                HolderSet.direct(placedFeatureHolderGetter.getOrThrow(BFPlacedFeatures.WILD_MAIZE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(LARGE_WILD_MAIZE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                holderGetter.getOrThrow(BFBiomeTags.HAS_LARGE_WILD_MAIZE),
                HolderSet.direct(placedFeatureHolderGetter.getOrThrow(BFPlacedFeatures.LARGE_WILD_MAIZE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(TEA_SHRUB, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                holderGetter.getOrThrow(BFBiomeTags.HAS_TEA_SHRUB),
                HolderSet.direct(placedFeatureHolderGetter.getOrThrow(BFPlacedFeatures.TEA_SHRUB_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

    }
}
