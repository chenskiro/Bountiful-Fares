package net.hecco.bountifulfares.compat.dungeons_delight;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.custom.PicketsBlock;
import net.hecco.bountifulfares.compat.block.CompatBlockItem;
import net.hecco.bountifulfares.compat.block.CompatPicketsBlock;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredHolder;


import java.util.function.Supplier;

import static net.hecco.bountifulfares.registry.content.BFTrellises.TRELLIS_RENDER_CUTOUT;
import static net.hecco.bountifulfares.registry.misc.BFCompat.compatBlocks;

public class DungeonsDelightBlocks {
    public static DeferredHolder<Block,Block> WORMWOOD_PICKETS = registerBlock("wormwood_pickets", ()->new CompatPicketsBlock(BountifulFares.DUNGEONS_DELIGHT_MOD_ID, BlockBehaviour.Properties.copy(BFBlocks.OAK_PICKETS.get())));

    public static final TrellisVariant WORMWOOD = new TrellisVariant(BountifulFares.DUNGEONS_DELIGHT_MOD_ID, "wormwood", ResourceLocation.tryBuild(BountifulFares.DUNGEONS_DELIGHT_MOD_ID, "wormwood_planks"), TRELLIS_RENDER_CUTOUT);


    public static DeferredHolder<Block,Block> registerBlock(String name, Supplier<Block> block) {
        DeferredHolder<Block,Block> blockRegistryObject = BFBlocks.attachCache(BuiltInRegistries.BLOCK, ResourceLocation.tryBuild(BountifulFares.DUNGEONS_DELIGHT_MOD_ID, name), block);
        registerBlockItem(name, blockRegistryObject);
        compatBlocks.add(blockRegistryObject);
        return blockRegistryObject;
    }

    private static void registerBlockItem(String name, Supplier<Block> block) {
        BFBlocks.attachCache(BuiltInRegistries.ITEM, ResourceLocation.tryBuild(BountifulFares.DUNGEONS_DELIGHT_MOD_ID, name), () -> new CompatBlockItem(BountifulFares.DUNGEONS_DELIGHT_MOD_ID, block.get(), new Item.Properties()));
    }
    
    public static void registerDungeonsDelightBlocks() {
    }
}
