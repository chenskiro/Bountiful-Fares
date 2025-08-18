package net.hecco.bountifulfares.trellis.trellis_parts;

import cpw.mods.util.Lazy;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;


import java.util.function.Supplier;

public class VineCrop {
    public final String MOD_ID;
    public final String TYPE_ID;
    public final Lazy<Item> CROP_ITEM;
    public final Lazy<Item> SEEDS_ITEM;
    public VineCrop(String modId, String id, Supplier<Item> crop, Supplier<Item> seeds) {
        this.MOD_ID = modId;
        this.TYPE_ID = id;
        this.CROP_ITEM = Lazy.of(crop::get);
        this.SEEDS_ITEM = Lazy.of(seeds::get);
//        TrellisVariants.VineCrops.add(this);
        BFBlocks._CROPS_TO_VINE_CROPS.put(seeds, this);
    }

    public VineCrop(String modId, String id, ResourceLocation crop) {
        this.MOD_ID = modId;
        this.TYPE_ID = id;
        this.CROP_ITEM = Lazy.of(()->BuiltInRegistries.ITEM.get(crop));;
        this.SEEDS_ITEM = Lazy.of(()->BuiltInRegistries.ITEM.get(crop));;
//        TrellisVariants.VineCrops.add(this);
        BFBlocks._CROPS_TO_VINE_CROPS.put(()->BuiltInRegistries.ITEM.get(crop), this);
    }

    public VineCrop(String modId, String id, Supplier<Item> crop) {
        this.MOD_ID = modId;
        this.TYPE_ID = id;
        this.CROP_ITEM = Lazy.of(crop::get);
        this.SEEDS_ITEM = Lazy.of(crop::get);
//        TrellisVariants.VineCrops.add(this);
        BFBlocks._CROPS_TO_VINE_CROPS.put(crop, this);
    }

    public String getName() {
        return this.TYPE_ID;
    }

    public String getId() {
        return this.MOD_ID;
    }

    public Lazy<Item> getCropItem() {
        return this.CROP_ITEM;
    }

    public Lazy<Item> getSeedsItem() {
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
