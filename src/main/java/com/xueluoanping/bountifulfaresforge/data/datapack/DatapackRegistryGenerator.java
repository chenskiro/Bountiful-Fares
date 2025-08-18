package com.xueluoanping.bountifulfaresforge.data.datapack;


import com.xueluoanping.bountifulfaresforge.registry.BFBiomeModifiers;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.misc.BFConfiguredFeatures;
import net.hecco.bountifulfares.registry.misc.BFPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class DatapackRegistryGenerator extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder REGISTRY_SET_BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, BFConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, BFPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, BFBiomeModifiers::bootstrap);

    public DatapackRegistryGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, REGISTRY_SET_BUILDER, Set.of(BountifulFares.MOD_ID));
    }

}