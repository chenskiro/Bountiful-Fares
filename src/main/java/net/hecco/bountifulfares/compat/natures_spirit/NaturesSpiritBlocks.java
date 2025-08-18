package net.hecco.bountifulfares.compat.natures_spirit;

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

public class NaturesSpiritBlocks {
    public static final DeferredHolder<Block,Block> ASPEN_PICKETS = registerBlock("aspen_pickets", ()-> new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.OAK_PICKETS.get())));
    public static final DeferredHolder<Block,Block> CEDAR_PICKETS = registerBlock("cedar_pickets", ()-> new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.OAK_PICKETS.get())));
    public static final DeferredHolder<Block,Block> COCONUT_PICKETS = registerBlock("coconut_pickets", ()-> new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.OAK_PICKETS.get())));
    public static final DeferredHolder<Block,Block> CYPRESS_PICKETS = registerBlock("cypress_pickets", ()-> new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.OAK_PICKETS.get())));
    public static final DeferredHolder<Block,Block> FIR_PICKETS = registerBlock("fir_pickets", ()-> new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.OAK_PICKETS.get())));
    public static final DeferredHolder<Block,Block> GHAF_PICKETS = registerBlock("ghaf_pickets", ()-> new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.OAK_PICKETS.get())));
    public static final DeferredHolder<Block,Block> JOSHUA_PICKETS = registerBlock("joshua_pickets", ()-> new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.OAK_PICKETS.get())));
    public static final DeferredHolder<Block,Block> LARCH_PICKETS = registerBlock("larch_pickets", ()-> new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.OAK_PICKETS.get())));
    public static final DeferredHolder<Block,Block> MAHOGANY_PICKETS = registerBlock("mahogany_pickets", ()-> new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.OAK_PICKETS.get())));
    public static final DeferredHolder<Block,Block> MAPLE_PICKETS = registerBlock("maple_pickets", ()-> new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.OAK_PICKETS.get())));
    public static final DeferredHolder<Block,Block> OLIVE_PICKETS = registerBlock("olive_pickets", ()-> new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.OAK_PICKETS.get())));
    public static final DeferredHolder<Block,Block> PALO_VERDE_PICKETS = registerBlock("palo_verde_pickets", ()-> new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.OAK_PICKETS.get())));
    public static final DeferredHolder<Block,Block> REDWOOD_PICKETS = registerBlock("redwood_pickets", ()-> new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.OAK_PICKETS.get())));
    public static final DeferredHolder<Block,Block> SAXAUL_PICKETS = registerBlock("saxaul_pickets", ()-> new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.OAK_PICKETS.get())));
    public static final DeferredHolder<Block,Block> SUGI_PICKETS = registerBlock("sugi_pickets", ()-> new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.OAK_PICKETS.get())));
    public static final DeferredHolder<Block,Block> WILLOW_PICKETS = registerBlock("willow_pickets", ()-> new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.OAK_PICKETS.get())));
    public static final DeferredHolder<Block,Block> WISTERIA_PICKETS = registerBlock("wisteria_pickets", ()-> new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.OAK_PICKETS.get())));

    public static final TrellisVariant REDWOOD = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "redwood", ResourceLocation.tryBuild(BountifulFares.NATURES_SPIRIT_MOD_ID, "redwood_planks"), TRELLIS_RENDER_CUTOUT);
    public static final TrellisVariant SUGI = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "sugi", ResourceLocation.tryBuild(BountifulFares.NATURES_SPIRIT_MOD_ID, "sugi_planks"), TRELLIS_RENDER_CUTOUT);
    public static final TrellisVariant WISTERIA = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "wisteria", ResourceLocation.tryBuild(BountifulFares.NATURES_SPIRIT_MOD_ID, "wisteria_planks"), TRELLIS_RENDER_CUTOUT);
    public static final TrellisVariant FIR = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "fir", ResourceLocation.tryBuild(BountifulFares.NATURES_SPIRIT_MOD_ID, "fir_planks"), TRELLIS_RENDER_CUTOUT);
    public static final TrellisVariant WILLOW = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "willow", ResourceLocation.tryBuild(BountifulFares.NATURES_SPIRIT_MOD_ID, "willow_planks"), TRELLIS_RENDER_CUTOUT);
    public static final TrellisVariant ASPEN = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "aspen", ResourceLocation.tryBuild(BountifulFares.NATURES_SPIRIT_MOD_ID, "aspen_planks"), TRELLIS_RENDER_CUTOUT);
    public static final TrellisVariant MAPLE = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "maple", ResourceLocation.tryBuild(BountifulFares.NATURES_SPIRIT_MOD_ID, "maple_planks"), TRELLIS_RENDER_CUTOUT);
    public static final TrellisVariant CYPRESS = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "cypress", ResourceLocation.tryBuild(BountifulFares.NATURES_SPIRIT_MOD_ID, "cypress_planks"), TRELLIS_RENDER_CUTOUT);
    public static final TrellisVariant OLIVE = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "olive", ResourceLocation.tryBuild(BountifulFares.NATURES_SPIRIT_MOD_ID, "olive_planks"), TRELLIS_RENDER_CUTOUT);
    public static final TrellisVariant JOSHUA = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "joshua", ResourceLocation.tryBuild(BountifulFares.NATURES_SPIRIT_MOD_ID, "joshua_planks"), TRELLIS_RENDER_CUTOUT);
    public static final TrellisVariant GHAF = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "ghaf", ResourceLocation.tryBuild(BountifulFares.NATURES_SPIRIT_MOD_ID, "ghaf_planks"), TRELLIS_RENDER_CUTOUT);
    public static final TrellisVariant PALO_VERDE = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "palo_verde", ResourceLocation.tryBuild(BountifulFares.NATURES_SPIRIT_MOD_ID, "palo_verde_planks"), TRELLIS_RENDER_CUTOUT);

    public static final TrellisVariant COCONUT = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "coconut", ResourceLocation.tryBuild(BountifulFares.NATURES_SPIRIT_MOD_ID, "coconut_planks"), TRELLIS_RENDER_CUTOUT);
    public static final TrellisVariant CEDAR = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "cedar", ResourceLocation.tryBuild(BountifulFares.NATURES_SPIRIT_MOD_ID, "cedar_planks"), TRELLIS_RENDER_CUTOUT);
    public static final TrellisVariant LARCH = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "larch", ResourceLocation.tryBuild(BountifulFares.NATURES_SPIRIT_MOD_ID, "larch_planks"), TRELLIS_RENDER_CUTOUT);
    public static final TrellisVariant MAHOGANY = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "mahogany", ResourceLocation.tryBuild(BountifulFares.NATURES_SPIRIT_MOD_ID, "mahogany_planks"), TRELLIS_RENDER_CUTOUT);
    public static final TrellisVariant SAXAUL = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "saxaul", ResourceLocation.tryBuild(BountifulFares.NATURES_SPIRIT_MOD_ID, "saxaul_planks"), TRELLIS_RENDER_CUTOUT);

    public static DeferredHolder<Block,Block> registerBlock(String name, Supplier<Block> block) {
        DeferredHolder<Block,Block> blockRegistryObject = BFBlocks.attachCache(BuiltInRegistries.BLOCK, ResourceLocation.tryBuild(BountifulFares.NATURES_SPIRIT_MOD_ID, name), block);
        registerBlockItem(name, blockRegistryObject);
        compatBlocks.add(blockRegistryObject);
        return blockRegistryObject;
    }

    private static void registerBlockItem(String name, Supplier<Block> block) {
        BFBlocks.attachCache(BuiltInRegistries.ITEM, ResourceLocation.tryBuild(BountifulFares.NATURES_SPIRIT_MOD_ID, name), () -> new CompatBlockItem(BountifulFares.NATURES_SPIRIT_MOD_ID, block.get(), new Item.Properties()));
    }
    public static void registerNaturesSpiritBlocks() {

    }
}
