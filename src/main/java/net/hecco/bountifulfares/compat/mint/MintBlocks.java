package net.hecco.bountifulfares.compat.mint;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.compat.block.CompatBlockItem;
import net.hecco.bountifulfares.compat.block.CompatJackOStrawBlock;
import net.hecco.bountifulfares.compat.block.CompatPicketsBlock;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.minecraft.core.Registry;
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

import static net.hecco.bountifulfares.BountifulFares.ELS_AND_LS_DYES_MOD_ID;
import static net.hecco.bountifulfares.BountifulFares.ELS_AND_LS_DYES_MOD_ID;
import static net.hecco.bountifulfares.registry.content.BFBlocks.createLightLevelFromLitBlockState;
import static net.hecco.bountifulfares.registry.content.BFTrellises.TRELLIS_RENDER_CUTOUT;
import static net.hecco.bountifulfares.registry.misc.BFCompat.compatBlocks;

public class MintBlocks {
    public static RegistryObject<Block> ACORN_JACK_O_STRAW = registerBlock("acorn_jack_o_straw", () -> new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static RegistryObject<Block> AMBER_JACK_O_STRAW = registerBlock("amber_jack_o_straw", () -> new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static RegistryObject<Block> ARTICHOKE_JACK_O_STRAW = registerBlock("artichoke_jack_o_straw", () -> new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static RegistryObject<Block> BANANA_JACK_O_STRAW = registerBlock("banana_jack_o_straw", () -> new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static RegistryObject<Block> CERULEAN_JACK_O_STRAW = registerBlock("cerulean_jack_o_straw", () -> new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static RegistryObject<Block> FUCHSIA_JACK_O_STRAW = registerBlock("fuchsia_jack_o_straw", () -> new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static RegistryObject<Block> GRAPE_JACK_O_STRAW = registerBlock("grape_jack_o_straw", () -> new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static RegistryObject<Block> INDIGO_JACK_O_STRAW = registerBlock("indigo_jack_o_straw", () -> new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static RegistryObject<Block> MAROON_JACK_O_STRAW = registerBlock("maroon_jack_o_straw", () -> new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static RegistryObject<Block> MAUVE_JACK_O_STRAW = registerBlock("mauve_jack_o_straw", () -> new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static RegistryObject<Block> MINT_JACK_O_STRAW = registerBlock("mint_jack_o_straw", () -> new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static RegistryObject<Block> MOLD_JACK_O_STRAW = registerBlock("mold_jack_o_straw", () -> new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static RegistryObject<Block> NAVY_JACK_O_STRAW = registerBlock("navy_jack_o_straw", () -> new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static RegistryObject<Block> PEACH_JACK_O_STRAW = registerBlock("peach_jack_o_straw", () -> new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static RegistryObject<Block> PERIWINKLE_JACK_O_STRAW = registerBlock("periwinkle_jack_o_straw", () -> new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static RegistryObject<Block> SAGE_JACK_O_STRAW = registerBlock("sage_jack_o_straw", () -> new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static RegistryObject<Block> SAP_JACK_O_STRAW = registerBlock("sap_jack_o_straw", () -> new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static RegistryObject<Block> SHAMROCK_JACK_O_STRAW = registerBlock("shamrock_jack_o_straw", () -> new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static RegistryObject<Block> VELVET_JACK_O_STRAW = registerBlock("velvet_jack_o_straw", () -> new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static RegistryObject<Block> VERMILION_JACK_O_STRAW = registerBlock("vermilion_jack_o_straw", () -> new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));

    public static RegistryObject<Block> WINTERGREEN_PICKETS = registerBlock("wintergreen_pickets", () -> new CompatPicketsBlock(ELS_AND_LS_DYES_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.NONE).strength(0.5F).sound(BFSounds.LIGHT_WOOD).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion()));

    public static final TrellisVariant WINTERGREEN = new TrellisVariant(BountifulFares.ELS_AND_LS_DYES_MOD_ID, "wintergreen", ResourceLocation.tryBuild(ELS_AND_LS_DYES_MOD_ID, "wintergreen_planks"), TRELLIS_RENDER_CUTOUT);


    public static RegistryObject<Block> registerBlock(String name, Supplier<Block> block) {
        RegistryObject<Block> blockRegistryObject = BFBlocks.attachCache(BuiltInRegistries.BLOCK, ResourceLocation.tryBuild(ELS_AND_LS_DYES_MOD_ID, name), block);
        registerBlockItem(name, blockRegistryObject);
        compatBlocks.add(blockRegistryObject);
        return blockRegistryObject;
    }

    private static void registerBlockItem(String name, Supplier<Block> block) {
        BFBlocks.attachCache(BuiltInRegistries.ITEM, ResourceLocation.tryBuild(ELS_AND_LS_DYES_MOD_ID, name), () -> new CompatBlockItem(ELS_AND_LS_DYES_MOD_ID, block.get(), new Item.Properties()));
    }

    public static void registerMintBlocks() {

    }
}
