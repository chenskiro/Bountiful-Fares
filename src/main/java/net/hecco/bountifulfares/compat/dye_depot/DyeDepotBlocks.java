package net.hecco.bountifulfares.compat.dye_depot;

// import net.fabricmc.fabric.api.object.builder.v1.block.BlockBehaviour.Properties;
import net.hecco.bountifulfares.compat.block.CompatBlockItem;
import net.hecco.bountifulfares.compat.block.CompatJackOStrawBlock;
import net.hecco.bountifulfares.registry.content.BFBlocks;
// import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredHolder;


import java.util.function.Supplier;

import static net.hecco.bountifulfares.BountifulFares.DYE_DEPOT_MOD_ID;
import static net.hecco.bountifulfares.registry.content.BFBlocks.createLightLevelFromLitBlockState;
import static net.hecco.bountifulfares.registry.misc.BFCompat.compatBlocks;

public class DyeDepotBlocks {

    public static final DeferredHolder<Block,Block> MAROON_JACK_O_STRAW = registerBlock("maroon_jack_o_straw",()-> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final DeferredHolder<Block,Block> ROSE_JACK_O_STRAW = registerBlock("rose_jack_o_straw",()-> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final DeferredHolder<Block,Block> CORAL_JACK_O_STRAW = registerBlock("coral_jack_o_straw", ()->new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final DeferredHolder<Block,Block> GINGER_JACK_O_STRAW = registerBlock("ginger_jack_o_straw",()-> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final DeferredHolder<Block,Block> TAN_JACK_O_STRAW = registerBlock("tan_jack_o_straw",()-> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final DeferredHolder<Block,Block> BEIGE_JACK_O_STRAW = registerBlock("beige_jack_o_straw", ()->new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final DeferredHolder<Block,Block> AMBER_JACK_O_STRAW = registerBlock("amber_jack_o_straw",()-> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final DeferredHolder<Block,Block> OLIVE_JACK_O_STRAW = registerBlock("olive_jack_o_straw",()-> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final DeferredHolder<Block,Block> FOREST_JACK_O_STRAW = registerBlock("forest_jack_o_straw",()-> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final DeferredHolder<Block,Block> VERDANT_JACK_O_STRAW = registerBlock("verdant_jack_o_straw",()-> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final DeferredHolder<Block,Block> TEAL_JACK_O_STRAW = registerBlock("teal_jack_o_straw", ()->new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final DeferredHolder<Block,Block> MINT_JACK_O_STRAW = registerBlock("mint_jack_o_straw", ()->new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final DeferredHolder<Block,Block> AQUA_JACK_O_STRAW = registerBlock("aqua_jack_o_straw",()-> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final DeferredHolder<Block,Block> SLATE_JACK_O_STRAW = registerBlock("slate_jack_o_straw", ()->new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final DeferredHolder<Block,Block> NAVY_JACK_O_STRAW = registerBlock("navy_jack_o_straw",()-> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final DeferredHolder<Block,Block> INDIGO_JACK_O_STRAW = registerBlock("indigo_jack_o_straw", ()->new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));

    public static DeferredHolder<Block,Block> registerBlock(String name, Supplier<Block> block) {
        DeferredHolder<Block,Block> blockRegistryObject = BFBlocks.attachCache(BuiltInRegistries.BLOCK, ResourceLocation.tryBuild(DYE_DEPOT_MOD_ID, name), block);
        registerBlockItem(name, blockRegistryObject);
        compatBlocks.add(blockRegistryObject);
        return blockRegistryObject;
    }

    private static void registerBlockItem(String name, Supplier<Block> block) {
        BFBlocks.attachCache(BuiltInRegistries.ITEM, ResourceLocation.tryBuild(DYE_DEPOT_MOD_ID, name), () -> new CompatBlockItem(DYE_DEPOT_MOD_ID, block.get(), new Item.Properties()));
    }
    public static void registerDyeDepotBlocks() {

    }
}
