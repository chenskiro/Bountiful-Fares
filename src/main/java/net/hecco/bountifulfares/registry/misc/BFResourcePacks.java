package net.hecco.bountifulfares.registry.misc;

import com.xueluoanping.bountifulfaresforge.api.resource.FakeResourceManagerHelperUtil;
import com.xueluoanping.bountifulfaresforge.api.resource.ModFilePackResources;
import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.neoforged.fml.loading.moddiscovery.ModFile;
import net.neoforged.neoforge.event.AddPackFindersEvent;

import java.util.Calendar;
import java.util.Optional;

public class BFResourcePacks {
    private static void registerBuiltinResourcePack(AddPackFindersEvent event, ModFile modContainer, String forModID) {
        // ResourceManagerHelper.registerBuiltinResourcePack(
        //         BountifulFares.rl( forModID + "_res"),
        //         modContainer,
        //         Component.translatable("pack." + BountifulFares.MOD_ID + "." + forModID),
        //         ResourcePackActivationType.ALWAYS_ENABLED
        // );
        FakeResourceManagerHelperUtil.registerBuiltinResourcePack(
                event,
                BountifulFares.rl(forModID + "_dat"),
                modContainer,
                Component.translatable("pack." + BountifulFares.MOD_ID + "." + forModID),
                PackType.CLIENT_RESOURCES,
                PackSource.BUILT_IN);
    }

    private static void registerBuiltinResourcePack(AddPackFindersEvent event, ModFile modContainer, String forModID, String additional) {
        // ResourceManagerHelper.registerBuiltinResourcePack(
        //         BountifulFares.rl( forModID + "_res_" + additional),
        //         modContainer,
        //         Component.translatable("pack." + BountifulFares.MOD_ID + "." + forModID),
        //         ResourcePackActivationType.ALWAYS_ENABLED
        // );
        FakeResourceManagerHelperUtil.registerBuiltinResourcePack(
                event,
                BountifulFares.rl( forModID + "_res_" + additional),
                modContainer,
                Component.translatable("pack." + BountifulFares.MOD_ID + "." + forModID),
                PackType.CLIENT_RESOURCES,
                PackSource.BUILT_IN);
    }

    private static void registerBuiltinDataPack(AddPackFindersEvent event, ModFile modContainer, String packId) {
        // ResourceManagerHelper.registerBuiltinResourcePack(
        //         BountifulFares.rl( packId + "_dat"),
        //         modContainer,
        //         Component.translatable("pack." + BountifulFares.MOD_ID + "." + packId),
        //         ResourcePackActivationType.ALWAYS_ENABLED
        // );
        FakeResourceManagerHelperUtil.registerBuiltinResourcePack(
                event,
                BountifulFares.rl(packId + "_dat"),
                modContainer,
                Component.translatable("pack." + BountifulFares.MOD_ID + "." + packId),
                PackType.SERVER_DATA,
                PackSource.BUILT_IN);
    }

    private static void registerBuiltinDataPack(AddPackFindersEvent event, ModFile modContainer, String packId, String additional) {
        // ResourceManagerHelper.registerBuiltinResourcePack(
        //         BountifulFares.rl( packId + "_dat_" + additional),
        //         modContainer,
        //         Component.translatable("pack." + BountifulFares.MOD_ID + "." + packId),
        //         ResourcePackActivationType.ALWAYS_ENABLED
        // );
        FakeResourceManagerHelperUtil.registerBuiltinResourcePack(
                event,
                BountifulFares.rl(packId + "_dat"+ additional),
                modContainer,
                Component.translatable("pack." + BountifulFares.MOD_ID + "." + packId),
                PackType.SERVER_DATA,
                PackSource.BUILT_IN);
    }

    public static void registerBuiltinResourcePacks(AddPackFindersEvent event) {
        // Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer(BountifulFares.MOD_ID);
        Optional<ModFile> modContainer = Optional.ofNullable(FMLLoader.getLoadingModList().getModFileById(BountifulFares.MOD_ID).getFile());
        if (modContainer.isPresent()) {
            if (BountifulFares.isModLoaded(BountifulFares.AMENDMENTS_MOD_ID)) {
                registerBuiltinDataPack(event, modContainer.get(), BountifulFares.AMENDMENTS_MOD_ID);
            }
            if (BountifulFares.isModLoaded(BountifulFares.ELS_AND_LS_DYES_MOD_ID)) {
                registerBuiltinDataPack(event, modContainer.get(), BountifulFares.ELS_AND_LS_DYES_MOD_ID);
            }
            if (BountifulFares.isModLoaded(BountifulFares.ARTS_AND_CRAFTS_MOD_ID)) {
                registerBuiltinDataPack(event, modContainer.get(), BountifulFares.ARTS_AND_CRAFTS_MOD_ID);
            }
            if (BountifulFares.isModLoaded(BountifulFares.DYE_DEPOT_MOD_ID)) {
                registerBuiltinDataPack(event, modContainer.get(), BountifulFares.DYE_DEPOT_MOD_ID);
            }
            if (BountifulFares.isModLoaded(BountifulFares.EXCESSIVE_BUILDING_MOD_ID)) {
                registerBuiltinDataPack(event, modContainer.get(), BountifulFares.EXCESSIVE_BUILDING_MOD_ID);
            }
            if (BountifulFares.isModLoaded(BountifulFares.FARMERS_DELIGHT_MOD_ID)) {
                registerBuiltinDataPack(event, modContainer.get(), BountifulFares.FARMERS_DELIGHT_MOD_ID);
            }
            if (BountifulFares.isModLoaded(BountifulFares.NATURES_SPIRIT_MOD_ID)) {
                registerBuiltinDataPack(event, modContainer.get(), BountifulFares.NATURES_SPIRIT_MOD_ID);
            }
            if (BountifulFares.isModLoaded(BountifulFares.SPAWN_MOD_ID)) {
                registerBuiltinDataPack(event, modContainer.get(), BountifulFares.SPAWN_MOD_ID);
            }
            if (BountifulFares.isModLoaded(BountifulFares.TWIGS_MOD_ID)) {
                registerBuiltinDataPack(event, modContainer.get(), BountifulFares.TWIGS_MOD_ID);
            }
            if (BountifulFares.isModLoaded(BountifulFares.DELICATE_DYES_MOD_ID)) {
                registerBuiltinDataPack(event, modContainer.get(), BountifulFares.DELICATE_DYES_MOD_ID);
            }
            if (BountifulFares.isModLoaded(BountifulFares.APPLEDOG_MOD_ID)) {
                registerBuiltinDataPack(event, modContainer.get(), BountifulFares.APPLEDOG_MOD_ID);
            }
            if (BountifulFares.isModLoaded(BountifulFares.DUNGEONS_DELIGHT_MOD_ID)) {
                registerBuiltinDataPack(event, modContainer.get(), BountifulFares.DUNGEONS_DELIGHT_MOD_ID);
            }

            if (!BountifulFares.CONFIG.showCompatItemsInRecipeViewers) {
                // ResourceManagerHelper.registerBuiltinResourcePack(
                //         BountifulFares.rl( "hide_compat_items"),
                //         modContainer.get(),
                //         ResourcePackActivationType.ALWAYS_ENABLED);
                FakeResourceManagerHelperUtil.registerBuiltinResourcePack(
                        event,
                        BountifulFares.rl("hide_compat_items"),
                        modContainer.get(),
                        Component.translatable("pack." + BountifulFares.MOD_ID + "." + "hide_compat_items"),
                        PackType.SERVER_DATA,
                        PackSource.BUILT_IN);
            }

            // ResourceManagerHelper.registerBuiltinResourcePack(
            //         BountifulFares.rl( "vanilla_item_override"),
            //         modContainer.get(),
            //         Component.translatable("pack." + BountifulFares.MOD_ID + "." + "vanilla_item_override"),
            //         ResourcePackActivationType.DEFAULT_ENABLED);

            FakeResourceManagerHelperUtil.registerBuiltinResourcePack(
                    event,
                    BountifulFares.rl("vanilla_item_override"),
                    modContainer.get(),
                    Component.translatable("pack." + BountifulFares.MOD_ID + "." + "vanilla_item_override"),
                    PackType.CLIENT_RESOURCES,
                    PackSource.BUILT_IN,
                    false);

            if ((Calendar.getInstance().get(Calendar.MONTH) == Calendar.APRIL
                    && Calendar.getInstance().get(Calendar.DAY_OF_MONTH) == 1)) {
                // ResourceManagerHelper.registerBuiltinResourcePack(
                //         BountifulFares.rl( "lime"),
                //         modContainer.get(),
                //         ResourcePackActivationType.ALWAYS_ENABLED);
                FakeResourceManagerHelperUtil.registerBuiltinResourcePack(
                        event,
                        BountifulFares.rl("lime"),
                        modContainer.get(),
                        Component.translatable("pack." + BountifulFares.MOD_ID + "." + "lime"),
                        PackType.CLIENT_RESOURCES,
                        PackSource.BUILT_IN);
            }
        }
    }
}
