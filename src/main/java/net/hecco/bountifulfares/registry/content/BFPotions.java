package net.hecco.bountifulfares.registry.content;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.core.DefaultedRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.RegisterEvent;

import java.util.HashMap;
import java.util.Map;

public class BFPotions {
    private static final Map<ResourceKey<Potion>, Potion> potions = new HashMap<>();

    public static final Potion ACIDIC = registerForCache(BuiltInRegistries.POTION, BountifulFares.rl("bountifulfares.acidic"),
            new Potion(new MobEffectInstance(BFEffects.ACIDIC, 2000, 0)));
    public static final Potion LONG_ACIDIC = registerForCache(BuiltInRegistries.POTION, BountifulFares.rl("bountifulfares.long_acidic"),
            new Potion(new MobEffectInstance(BFEffects.ACIDIC, 3600, 0)));
    public static final Potion STRONG_ACIDIC = registerForCache(BuiltInRegistries.POTION, BountifulFares.rl("bountifulfares.strong_acidic"),
            new Potion(new MobEffectInstance(BFEffects.ACIDIC, 1000, 1)));
    public static final Potion STUPOR = registerForCache(BuiltInRegistries.POTION, BountifulFares.rl("bountifulfares.stupor"),
            new Potion(new MobEffectInstance(BFEffects.STUPOR, 2000, 0)));
    public static final Potion LONG_STUPOR = registerForCache(BuiltInRegistries.POTION, BountifulFares.rl("bountifulfares.long_stupor"),
            new Potion(new MobEffectInstance(BFEffects.STUPOR, 3600, 0)));

    private static Potion registerForCache(DefaultedRegistry<Potion> potion, ResourceLocation rl, Potion potion1) {
        return potions.put(ResourceKey.create(Registries.POTION, rl), potion1);
    }


    @SubscribeEvent
    public static void blockRegister(RegisterEvent event) {
        event.register(Registries.POTION, registerHelper -> {
            potions.forEach(registerHelper::register);
        });
    }
}
