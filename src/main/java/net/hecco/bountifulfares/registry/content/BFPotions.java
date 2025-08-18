package net.hecco.bountifulfares.registry.content;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BFPotions {
    public static final DeferredRegister<Potion> POTION_DEFERRED_REGISTER = DeferredRegister.create(Registries.POTION, BountifulFares.MOD_ID);

    public static final DeferredHolder<Potion, Potion> ACIDIC = POTION_DEFERRED_REGISTER.register(("bountifulfares.acidic"),
            () -> new Potion(new MobEffectInstance(BFEffects.ACIDIC, 2000, 0)));
    public static final DeferredHolder<Potion, Potion> LONG_ACIDIC = POTION_DEFERRED_REGISTER.register(("bountifulfares.long_acidic"),
            () -> new Potion(new MobEffectInstance(BFEffects.ACIDIC, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_ACIDIC = POTION_DEFERRED_REGISTER.register(("bountifulfares.strong_acidic"),
            () -> new Potion(new MobEffectInstance(BFEffects.ACIDIC, 1000, 1)));
    public static final DeferredHolder<Potion, Potion> STUPOR = POTION_DEFERRED_REGISTER.register(("bountifulfares.stupor"),
            () -> new Potion(new MobEffectInstance(BFEffects.STUPOR, 2000, 0)));
    public static final DeferredHolder<Potion, Potion> LONG_STUPOR = POTION_DEFERRED_REGISTER.register(("bountifulfares.long_stupor"),
            () -> new Potion(new MobEffectInstance(BFEffects.STUPOR, 3600, 0)));


    public static Holder<Potion> getHolder(Holder<Potion> potions) {
        return potions;
    }
}
