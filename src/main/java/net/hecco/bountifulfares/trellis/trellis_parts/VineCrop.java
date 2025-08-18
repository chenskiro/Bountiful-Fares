package net.hecco.bountifulfares.trellis.trellis_parts;

import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.util.LazyOptional;


import java.util.function.Supplier;

public class VineCrop {
    public final String MOD_ID;
    public final String TYPE_ID;
    public final LazyOptional<Item> CROP_ITEM;
    public final LazyOptional<Item> SEEDS_ITEM;
    public VineCrop(String modId, String id, Supplier<Item> crop, Supplier<Item> seeds) {
        this.MOD_ID = modId;
        this.TYPE_ID = id;
        this.CROP_ITEM = LazyOptional.of(crop::get);
        this.SEEDS_ITEM = LazyOptional.of(seeds::get);
//        TrellisVariants.VineCrops.add(this);
        BFBlocks._CROPS_TO_VINE_CROPS.put(seeds, this);
    }

    public VineCrop(String modId, String id, ResourceLocation crop) {
        this.MOD_ID = modId;
        this.TYPE_ID = id;
        this.CROP_ITEM = LazyOptional.of(()->BuiltInRegistries.ITEM.get(crop));;
        this.SEEDS_ITEM = LazyOptional.of(()->BuiltInRegistries.ITEM.get(crop));;
//        TrellisVariants.VineCrops.add(this);
        BFBlocks._CROPS_TO_VINE_CROPS.put(()->BuiltInRegistries.ITEM.get(crop), this);
    }

    public VineCrop(String modId, String id, Supplier<Item> crop) {
        this.MOD_ID = modId;
        this.TYPE_ID = id;
        this.CROP_ITEM = LazyOptional.of(crop::get);
        this.SEEDS_ITEM = LazyOptional.of(crop::get);
//        TrellisVariants.VineCrops.add(this);
        BFBlocks._CROPS_TO_VINE_CROPS.put(crop, this);
    }

    public String getName() {
        return this.TYPE_ID;
    }

    public String getId() {
        return this.MOD_ID;
    }

    public LazyOptional<Item> getCropItem() {
        return this.CROP_ITEM;
    }

    public LazyOptional<Item> getSeedsItem() {
        return this.SEEDS_ITEM;
    }

//    public Block getBlockClass() {
//        return this.BLOCK_CLASS;
//    }

    @Override
    public String toString() {
        return "[" + TYPE_ID + "]";
    }
}
