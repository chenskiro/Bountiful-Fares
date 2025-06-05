package net.hecco.bountifulfares.registry.misc;

import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.Optional;

public class BFSaplingGenerators {
    public static class BFTreeGrower extends AbstractTreeGrower {
        private final ResourceKey<ConfiguredFeature<?, ?>> resourceKey;

        protected BFTreeGrower(String name,
                               float seed,
                               Optional<ResourceKey<ConfiguredFeature<?, ?>>> var1,
                               Optional<ResourceKey<ConfiguredFeature<?, ?>>> var2,
                               Optional<ResourceKey<ConfiguredFeature<?, ?>>> var3,
                               Optional<ResourceKey<ConfiguredFeature<?, ?>>> var4,
                               Optional<ResourceKey<ConfiguredFeature<?, ?>>> var5,
                               Optional<ResourceKey<ConfiguredFeature<?, ?>>> var6) {
            this.resourceKey = var3.get();
        }
        

        protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_256308_, boolean p_256632_) {
            return resourceKey;
        }
    }
    
    public static final AbstractTreeGrower APPLE_SAPLING_GENERATOR = new BFTreeGrower("apple", 0f,
            Optional.empty(),
            Optional.empty(),
            Optional.of(BFConfiguredFeatures.APPLE_KEY),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());
    public static final AbstractTreeGrower ORANGE_SAPLING_GENERATOR = new BFTreeGrower("orange", 0f,
            Optional.empty(),
            Optional.empty(),
            Optional.of(BFConfiguredFeatures.ORANGE_KEY),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());
    public static final AbstractTreeGrower LEMON_SAPLING_GENERATOR = new BFTreeGrower("lemon", 0f,
            Optional.empty(),
            Optional.empty(),
            Optional.of(BFConfiguredFeatures.LEMON_KEY),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());
    public static final AbstractTreeGrower PLUM_SAPLING_GENERATOR = new BFTreeGrower("plum", 0f,
            Optional.empty(),
            Optional.empty(),
            Optional.of(BFConfiguredFeatures.PLUM_KEY),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());
    public static final AbstractTreeGrower PALM_SAPLING_GENERATOR = new BFTreeGrower("palm", 0f,
            Optional.empty(),
            Optional.empty(),
            Optional.of(BFConfiguredFeatures.PALM_KEY),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());
    public static final AbstractTreeGrower GOLDEN_APPLE_SAPLING_GENERATOR = new BFTreeGrower("golden_apple", 0f,
            Optional.empty(),
            Optional.empty(),
            Optional.of(BFConfiguredFeatures.GOLDEN_APPLE_KEY),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());
    public static final AbstractTreeGrower HOARY_SAPLING_GENERATOR = new BFTreeGrower("hoary", 0f,
            Optional.empty(),
            Optional.empty(),
            Optional.of(BFConfiguredFeatures.HOARY_KEY),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());
    public static final AbstractTreeGrower WALNUT_SAPLING_GENERATOR = new BFTreeGrower("walnut", 0f,
            Optional.empty(),
            Optional.empty(),
            Optional.of(BFConfiguredFeatures.WALNUT_KEY),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());
}
