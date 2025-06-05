package net.hecco.bountifulfares.compat.farmersdelight;

import net.hecco.bountifulfares.compat.block.CompatBlockItem;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.hecco.bountifulfares.BountifulFares.FARMERS_DELIGHT_MOD_ID;
import static net.hecco.bountifulfares.BountifulFares.FARMERS_DELIGHT_MOD_ID;
import static net.hecco.bountifulfares.registry.misc.BFCompat.compatBlocks;

public class FarmersDelightBlocks {
    public static final RegistryObject<Block> WALNUT_CABINET = registerBlock("walnut_cabinet",()-> new CabinetBlock(FARMERS_DELIGHT_MOD_ID, BlockBehaviour.Properties.copy(Blocks.BARREL).mapColor(MapColor.COLOR_BROWN)));
    public static final RegistryObject<Block> HOARY_CABINET = registerBlock("hoary_cabinet",()->  new CabinetBlock(FARMERS_DELIGHT_MOD_ID, BlockBehaviour.Properties.copy(Blocks.BARREL).mapColor(MapColor.TERRACOTTA_GRAY)));

    public static RegistryObject<Block> registerBlock(String name, Supplier<Block> block) {
        RegistryObject<Block> blockRegistryObject = BFBlocks.attachCache(BuiltInRegistries.BLOCK, ResourceLocation.tryBuild(FARMERS_DELIGHT_MOD_ID, name), block);
        registerBlockItem(name, blockRegistryObject);
        compatBlocks.add(blockRegistryObject);
        return blockRegistryObject;
    }

    private static void registerBlockItem(String name, Supplier<Block> block) {
        BFBlocks.attachCache(BuiltInRegistries.ITEM, ResourceLocation.tryBuild(FARMERS_DELIGHT_MOD_ID, name), () -> new CompatBlockItem(FARMERS_DELIGHT_MOD_ID, block.get(), new Item.Properties()));
    }
    
    public static void registerFarmersDelightBlocks()
    {

    }
}
