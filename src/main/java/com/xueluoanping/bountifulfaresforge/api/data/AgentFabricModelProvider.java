package com.xueluoanping.bountifulfaresforge.api.data;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonElement;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.BlockStateGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class AgentFabricModelProvider implements DataProvider {
    private final String MOD_ID;
    private final PackOutput.PathProvider blockStatePathProvider;
    private final PackOutput.PathProvider modelPathProvider;

    public AgentFabricModelProvider(PackOutput pOutput, String MOD_ID) {
        this.blockStatePathProvider = pOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "blockstates");
        this.modelPathProvider = pOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "models");
        this.MOD_ID = MOD_ID;
    }

    public abstract void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator);

    public abstract void generateItemModels(ItemModelGenerators itemModelGenerator);

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
        // List<Block> list = BuiltInRegistries.BLOCK.stream().filter((p_125117_) -> {
        //     return !map.containsKey(p_125117_);
        // }).toList();
        // if (!list.isEmpty()) {
        //     throw new IllegalStateException("Missing blockstate definitions for: " + list);
        // } else
        {
            // BuiltInRegistries.BLOCK.forEach((p_125128_) -> {
            //     Item item = Item.BY_BLOCK.get(p_125128_);
            //     if (item != null) {
            //         if (set.contains(item)) {
            //             return;
            //         }
            //
            //         ResourceLocation resourcelocation = ModelLocationUtils.getModelLocation(item);
            //         if (!map1.containsKey(resourcelocation)) {
            //             map1.put(resourcelocation, new DelegatedModel(ModelLocationUtils.getModelLocation(p_125128_)));
            //         }
            //     }
            //
            // });
            return CompletableFuture.allOf(this.saveCollection(pOutput, map, (block) -> {
                return this.blockStatePathProvider.json(block.builtInRegistryHolder().key().location());
            }), this.saveCollection(pOutput, map1, this.modelPathProvider::json));
        }
    }

    @Override
    public @NotNull String getName() {
        return "BlockState Model and Item Model : %s".formatted(MOD_ID);
    }

    private <T> CompletableFuture<?> saveCollection(CachedOutput pOutput, Map<T, ? extends Supplier<JsonElement>> pObjectToJsonMap, Function<T, Path> pResolveObjectPath) {
        return CompletableFuture.allOf(pObjectToJsonMap.entrySet().stream().map((entry) -> {
            Path path = pResolveObjectPath.apply(entry.getKey());
            JsonElement jsonelement = entry.getValue().get();
            return DataProvider.saveStable(pOutput, jsonelement, path);
        }).toArray(CompletableFuture[]::new));
    }
}
