package net.hecco.bountifulfares.compat.twigs;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.compat.block.CompatBlockItem;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredHolder;


import java.util.function.Supplier;

import static net.hecco.bountifulfares.BountifulFares.TWIGS_MOD_ID;
import static net.hecco.bountifulfares.registry.content.BFBlocks.createLightLevelFromLitBlockState;
import static net.hecco.bountifulfares.registry.misc.BFCompat.compatBlocks;

public class TwigsBlocks {

    public static final DeferredHolder<Block,Block> WALNUT_TABLE = registerBlock("walnut_table",()-> new TwigsTableBlock(TWIGS_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.WALNUT_PLANKS.get())));
    public static final DeferredHolder<Block,Block> HOARY_TABLE = registerBlock("hoary_table", ()->new TwigsTableBlock(BountifulFares.TWIGS_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.HOARY_PLANKS.get())));
    public static final DeferredHolder<Block,Block> FELDSPAR_LAMP = registerBlock("feldspar_lamp",()-> new TwigsLampBlock(BountifulFares.TWIGS_MOD_ID, BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(4.5F).sound(TwigsSounds.LAMP).lightLevel(createLightLevelFromLitBlockState(8))));


    public static DeferredHolder<Block,Block> registerBlock(String name, Supplier<Block> block) {
        DeferredHolder<Block,Block> blockRegistryObject = BFBlocks.attachCache(BuiltInRegistries.BLOCK, ResourceLocation.tryBuild(BountifulFares.TWIGS_MOD_ID, name), block);
        registerBlockItem(name, blockRegistryObject);
        compatBlocks.add(blockRegistryObject);
        return blockRegistryObject;
    }

    private static void registerBlockItem(String name, Supplier<Block> block) {
        BFBlocks.attachCache(BuiltInRegistries.ITEM, ResourceLocation.tryBuild(BountifulFares.TWIGS_MOD_ID, name), () -> new CompatBlockItem(BountifulFares.TWIGS_MOD_ID, block.get(), new Item.Properties()));
    }
    public static void registerTwigsBlocks() {

    }
}
