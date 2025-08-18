package com.xueluoanping.bountifulfaresforge.api.resource;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.neoforged.neoforge.event.AddPackFindersEvent;

public class FakeResourceManagerHelperUtil {
    public static void registerBuiltinResourcePack(AddPackFindersEvent event, ResourceLocation packId, ModFile modFile, PackSource source) {
        String languageKey = packId.toLanguageKey("pack");
        registerBuiltinResourcePack(event, packId, modFile, Component.translatable(languageKey), source);
    }

    public static void registerBuiltinResourcePack(AddPackFindersEvent event, ResourceLocation packId, ModFile modFile, Component translate, PackSource source) {
        String packIdLanguageKey = packId.toLanguageKey();
        event.addRepositorySource(consumer -> consumer.accept(
                Pack.readMetaAndCreate(packIdLanguageKey, translate, true,
                        id -> new ModFilePackResources(packIdLanguageKey, modFile, "resourcepacks/" + packId.getPath()), event.getPackType(),
                        Pack.Position.TOP, source)));
    }

    public static void registerBuiltinResourcePack(AddPackFindersEvent event, ResourceLocation packId, ModFile modFile, MutableComponent translate, PackType packType, PackSource source) {
        registerBuiltinResourcePack(event, packId, modFile, translate, packType, source, true);
    }

    public static void registerBuiltinResourcePack(AddPackFindersEvent event, ResourceLocation packId, ModFile modFile, MutableComponent translate, PackType packType, PackSource source, boolean require) {
        if (event.getPackType() == packType) {
            String packIdLanguageKey = packId.toLanguageKey();
            event.addRepositorySource(consumer -> consumer.accept(
                    Pack.readMetaAndCreate(packIdLanguageKey, translate, require,
                            id -> new ModFilePackResources(packIdLanguageKey, modFile, "resourcepacks/" + packId.getPath()), packType,
                            Pack.Position.TOP, source)));
        }
    }
}
