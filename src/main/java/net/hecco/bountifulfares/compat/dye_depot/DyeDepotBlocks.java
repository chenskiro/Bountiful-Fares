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
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.hecco.bountifulfares.BountifulFares.DYE_DEPOT_MOD_ID;
import static net.hecco.bountifulfares.registry.content.BFBlocks.createLightLevelFromLitBlockState;
import static net.hecco.bountifulfares.registry.misc.BFCompat.compatBlocks;

public class DyeDepotBlocks {

    public static final RegistryObject<Block> MAROON_JACK_O_STRAW = registerBlock("maroon_jack_o_straw",()-> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ROSE_JACK_O_STRAW = registerBlock("rose_jack_o_straw",()-> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> CORAL_JACK_O_STRAW = registerBlock("coral_jack_o_straw", ()->new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> GINGER_JACK_O_STRAW = registerBlock("ginger_jack_o_straw",()-> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> TAN_JACK_O_STRAW = registerBlock("tan_jack_o_straw",()-> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> BEIGE_JACK_O_STRAW = registerBlock("beige_jack_o_straw", ()->new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> AMBER_JACK_O_STRAW = registerBlock("amber_jack_o_straw",()-> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> OLIVE_JACK_O_STRAW = registerBlock("olive_jack_o_straw",()-> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> FOREST_JACK_O_STRAW = registerBlock("forest_jack_o_straw",()-> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> VERDANT_JACK_O_STRAW = registerBlock("verdant_jack_o_straw",()-> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> TEAL_JACK_O_STRAW = registerBlock("teal_jack_o_straw", ()->new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> MINT_JACK_O_STRAW = registerBlock("mint_jack_o_straw", ()->new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> AQUA_JACK_O_STRAW = registerBlock("aqua_jack_o_straw",()-> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> SLATE_JACK_O_STRAW = registerBlock("slate_jack_o_straw", ()->new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> NAVY_JACK_O_STRAW = registerBlock("navy_jack_o_straw",()-> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> INDIGO_JACK_O_STRAW = registerBlock("indigo_jack_o_straw", ()->new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));

    public static RegistryObject<Block> registerBlock(String name, Supplier<Block> block) {
        RegistryObject<Block> blockRegistryObject = BFBlocks.attachCache(BuiltInRegistries.BLOCK, ResourceLocation.tryBuild(DYE_DEPOT_MOD_ID, name), block);
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
