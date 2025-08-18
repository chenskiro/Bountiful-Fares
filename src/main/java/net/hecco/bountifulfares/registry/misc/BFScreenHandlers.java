package net.hecco.bountifulfares.registry.misc;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.screen.GristmillScreenHandler;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.RegisterEvent;


import java.util.HashMap;
import java.util.Map;


@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class BFScreenHandlers {
    private static final Map<ResourceKey<MenuType<?>>, MenuType<?>> menuTypes = new HashMap<>();

    public static final MenuType<GristmillScreenHandler> GRISTMILL_SCREEN_HANDLER =
            register("gristmill_screen_handler", GristmillScreenHandler::new);

//    public static <T extends ScreenHandler, D extends PacketByteBuf> ExtendedScreenHandlerType<T, D> register (String name, ExtendedScreenHandlerType.ExtendedFactory<T, D> factory, PacketCodec<? super RegistryByteBuf, D> codec) {
//        return Registry.register(Registries.SCREEN_HANDLER, Identifier.of(BountifulFares.MOD_ID, name), new ExtendedScreenHandlerType<>(factory, codec));
//    }

    private static <T extends AbstractContainerMenu> MenuType<T> register(String id, MenuType.MenuSupplier<T> factory) {
        MenuType<T> tMenuType = new MenuType<>(factory, FeatureFlags.VANILLA_SET);
        menuTypes.put(ResourceKey.create(Registries.MENU, BountifulFares.rl(id)), tMenuType);
        // return Registry.register(BuiltInRegistries.MENU, id, tMenuType);
        return tMenuType;
    }

    // public static void registerScreenHandlers() {
    // }

    @SubscribeEvent
    public static void onRegister(RegisterEvent event) {
        event.register(Registries.MENU, registerHelper -> {
            menuTypes.forEach(registerHelper::register);
        });
    }
}
