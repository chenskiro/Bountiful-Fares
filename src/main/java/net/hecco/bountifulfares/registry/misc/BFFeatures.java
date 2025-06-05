package net.hecco.bountifulfares.registry.misc;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.world.wild_vine_feature.WildVineFeature;
import net.hecco.bountifulfares.world.wild_vine_feature.WildVineFeatureConfig;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegisterEvent;

import java.util.HashMap;
import java.util.Map;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BFFeatures {
    private static final Map<ResourceKey<Feature<?>>, Feature<?>> features = new HashMap<>();

    public static final Feature<?> WILD_VINE_FEATURE = register("wild_vine", new WildVineFeature(WildVineFeatureConfig.CODEC));

    private static <C extends FeatureConfiguration, F extends Feature<C>> Feature<?> register(String name, F feature) {
        // return Registry.register(BuiltInRegistries.FEATURE, BountifulFares.rl( name), feature);
        return features.put(ResourceKey.create(Registries.FEATURE, BountifulFares.rl(name)),
                feature);
    }

    // public static void register() {
    // }

    @SubscribeEvent
    public static void blockRegister(RegisterEvent event) {
        event.register(Registries.FEATURE, registerHelper -> {
            features.forEach(registerHelper::register);
        });
    }
}
