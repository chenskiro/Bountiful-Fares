package net.hecco.bountifulfares.compat.appledog;

import net.hecco.bountifulfares.compat.block.CompatBlockItem;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredHolder;


import java.util.function.Supplier;

import static net.hecco.bountifulfares.BountifulFares.APPLEDOG_MOD_ID;
import static net.hecco.bountifulfares.BountifulFares.EXCESSIVE_BUILDING_MOD_ID;
import static net.hecco.bountifulfares.registry.misc.BFCompat.compatBlocks;

public class AppledogBlocks {
    public static final DeferredHolder<Block,Block> APPLEDOG_BLOCK = registerBlock("appledog_block", () -> new AppledogBlock(APPLEDOG_MOD_ID, BlockBehaviour.Properties.copy(BFBlocks.APPLE_BLOCK.get()).strength(1f, 1000f)));

    public static DeferredHolder<Block,Block> registerBlock(String name, Supplier<Block> block) {
        DeferredHolder<Block,Block> blockRegistryObject = BFBlocks.attachCache(BuiltInRegistries.BLOCK, ResourceLocation.tryBuild(APPLEDOG_MOD_ID, name), block);
        registerBlockItem(name, blockRegistryObject);
        compatBlocks.add(blockRegistryObject);
        return blockRegistryObject;
    }

    private static void registerBlockItem(String name, Supplier<Block> block) {
        BFBlocks.attachCache(BuiltInRegistries.ITEM, ResourceLocation.tryBuild(APPLEDOG_MOD_ID, name), () -> new CompatBlockItem(APPLEDOG_MOD_ID, block.get(), new Item.Properties().rarity(Rarity.EPIC)));
    }

    public static void registerAppledogBlocks() {
    }
}
