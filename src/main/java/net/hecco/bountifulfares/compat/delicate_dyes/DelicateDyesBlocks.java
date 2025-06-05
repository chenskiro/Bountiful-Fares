package net.hecco.bountifulfares.compat.delicate_dyes;

import net.hecco.bountifulfares.compat.block.CompatBlockItem;
import net.hecco.bountifulfares.compat.block.CompatJackOStrawBlock;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.hecco.bountifulfares.BountifulFares.DELICATE_DYES_MOD_ID;
import static net.hecco.bountifulfares.BountifulFares.DELICATE_DYES_MOD_ID;
import static net.hecco.bountifulfares.registry.misc.BFCompat.compatBlocks;

public class DelicateDyesBlocks {
    public static final RegistryObject<Block> CORAL_JACK_O_STRAW = registerBlock("coral_jack_o_straw", () -> new CompatJackOStrawBlock(DELICATE_DYES_MOD_ID, BlockBehaviour.Properties.copy(BFBlocks.RED_JACK_O_STRAW.get())));
    public static final RegistryObject<Block> CANARY_JACK_O_STRAW = registerBlock("canary_jack_o_straw", () -> new CompatJackOStrawBlock(DELICATE_DYES_MOD_ID, BlockBehaviour.Properties.copy(BFBlocks.RED_JACK_O_STRAW.get())));
    public static final RegistryObject<Block> WASABI_JACK_O_STRAW = registerBlock("wasabi_jack_o_straw", () -> new CompatJackOStrawBlock(DELICATE_DYES_MOD_ID, BlockBehaviour.Properties.copy(BFBlocks.RED_JACK_O_STRAW.get())));
    public static final RegistryObject<Block> SACRAMENTO_JACK_O_STRAW = registerBlock("sacramento_jack_o_straw", () -> new CompatJackOStrawBlock(DELICATE_DYES_MOD_ID, BlockBehaviour.Properties.copy(BFBlocks.RED_JACK_O_STRAW.get())));
    public static final RegistryObject<Block> SKY_JACK_O_STRAW = registerBlock("sky_jack_o_straw", () -> new CompatJackOStrawBlock(DELICATE_DYES_MOD_ID, BlockBehaviour.Properties.copy(BFBlocks.RED_JACK_O_STRAW.get())));
    public static final RegistryObject<Block> BLURPLE_JACK_O_STRAW = registerBlock("blurple_jack_o_straw", () -> new CompatJackOStrawBlock(DELICATE_DYES_MOD_ID, BlockBehaviour.Properties.copy(BFBlocks.RED_JACK_O_STRAW.get())));
    public static final RegistryObject<Block> SANGRIA_JACK_O_STRAW = registerBlock("sangria_jack_o_straw", () -> new CompatJackOStrawBlock(DELICATE_DYES_MOD_ID, BlockBehaviour.Properties.copy(BFBlocks.RED_JACK_O_STRAW.get())));
    public static final RegistryObject<Block> ROSE_JACK_O_STRAW = registerBlock("rose_jack_o_straw", () -> new CompatJackOStrawBlock(DELICATE_DYES_MOD_ID, BlockBehaviour.Properties.copy(BFBlocks.RED_JACK_O_STRAW.get())));

    public static RegistryObject<Block> registerBlock(String name, Supplier<Block> block) {
        RegistryObject<Block> blockRegistryObject = BFBlocks.attachCache(BuiltInRegistries.BLOCK, ResourceLocation.tryBuild(DELICATE_DYES_MOD_ID, name), block);
        registerBlockItem(name, blockRegistryObject);
        compatBlocks.add(blockRegistryObject);
        return blockRegistryObject;
    }

    private static void registerBlockItem(String name, Supplier<Block> block) {
        BFBlocks.attachCache(BuiltInRegistries.ITEM, ResourceLocation.tryBuild(DELICATE_DYES_MOD_ID, name), () -> new CompatBlockItem(DELICATE_DYES_MOD_ID, block.get(), new Item.Properties()));
    }

    public static void registerPigmentPaloozaBlocks() {

    }
}
