package net.hecco.bountifulfares.trellis;


import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFTrellises;
import net.hecco.bountifulfares.trellis.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.trellis.trellis_parts.VineCrop;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class TrellisUtil {

    public static List<TrellisVariant> TrellisVariants = new ArrayList<>();
    public static List<VineCrop> VineCrops = new ArrayList<>(List.of(
            BFTrellises.PASSION_FRUIT,
            BFTrellises.ELDERBERRY,
            BFTrellises.LAPISBERRY,
            BFTrellises.GLOW_BERRY

    ));
    public static List<DecorativeVine> DecorativeVines = new ArrayList<>(List.of(
            BFTrellises.ROSE,
            BFTrellises.LILAC,
            BFTrellises.PEONY,
            BFTrellises.SUNFLOWER,
            BFTrellises.VINE,
            BFTrellises.WEEPING,
            BFTrellises.TWISTING
    ));

    public static void registerTrellisParts() {
        if (BountifulFares.isModLoaded(BountifulFares.NATURES_SPIRIT_MOD_ID) || BountifulFares.isDatagen()) {
            DecorativeVines.add(BFTrellises.NS_LAVENDER);
            DecorativeVines.add(BFTrellises.NS_BLEEDING_HEART);
            DecorativeVines.add(BFTrellises.NS_BLUE_BULB);
            DecorativeVines.add(BFTrellises.NS_CARNATION);
            DecorativeVines.add(BFTrellises.NS_GARDENIA);
            DecorativeVines.add(BFTrellises.NS_MARIGOLD);
            DecorativeVines.add(BFTrellises.NS_FOXGLOVE);
        }
        if (BountifulFares.isModLoaded(BountifulFares.SPAWN_MOD_ID) || BountifulFares.isDatagen()) {
            VineCrops.add(BFTrellises.SPAWN_SUNFLOWER);
        }
    }

    public static RegistryObject<Block> registerBlockNoItem(String id, String name, Supplier<Block> block) {
        return BFBlocks.attachCache(BuiltInRegistries.BLOCK, ResourceLocation.tryBuild(id, name), block);
    }

    public static RegistryObject<Block> registerBlock(String id, String name, Supplier<Block> block) {
        RegistryObject<Block> rBlock = BFBlocks.attachCache(BuiltInRegistries.BLOCK, ResourceLocation.tryBuild(id, name), block);
        registerBlockItem(id, name, rBlock);
        return rBlock;
    }

    private static RegistryObject<Item> registerBlockItem(String id, String name, RegistryObject<Block> block) {
        return BFBlocks.attachCache(BuiltInRegistries.ITEM, ResourceLocation.tryBuild(id, name), () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static RegistryObject<Block> getTrellisFromVariant(TrellisVariant variant) {
        return BFTrellises.TRELLISES.get(variant.getBlockName());
    }

    public static RegistryObject<Block> getCropTrellisFromVariant(TrellisVariant variant, VineCrop crop) {
        return BFTrellises.CROP_TRELLISES.get(crop.getName() + variant.getBlockName());
    }

    public static RegistryObject<Block> getDecorTrellisFromVariant(TrellisVariant variant, DecorativeVine vine) {
        return BFTrellises.DECORATIVE_TRELLISES.get(vine.getName() + variant.getBlockName());
    }


}
