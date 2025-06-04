package net.hecco.bountifulfares.registry.content;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegisterEvent;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BFParticles {
    private static final Map<ResourceKey<ParticleType<?>>, SimpleParticleType> particleTypeMap = new HashMap<>();

    public static final SimpleParticleType FLOUR_CLOUD = registerParticle("flour_cloud", new SimpleParticleType(false));
    public static final SimpleParticleType PRISMARINE_BLOSSOM = registerParticle("prismarine_blossom", new SimpleParticleType(false));
    public static final SimpleParticleType FERMENTED_BUBBLE = registerParticle("fermented_bubble", new SimpleParticleType(false));
    public static final SimpleParticleType GOLDEN_PETAL = registerParticle("golden_petal", new SimpleParticleType(false));


    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType) {
        // return Registry.register(BuiltInRegistries.PARTICLE_TYPE, BountifulFares.rl(name), particleType);
        return particleTypeMap.put(ResourceKey.create(Registries.PARTICLE_TYPE, BountifulFares.rl(name)), particleType);
    }

    public static void registerParticles() {
//        BountifulFares.LOGGER.info("Registering Mod Particles for " + BountifulFares.MOD_ID);
    }

    @SubscribeEvent
    public static void blockRegister(RegisterEvent event) {
        event.register(Registries.PARTICLE_TYPE, particleTypeRegisterHelper -> {
            particleTypeMap.forEach(particleTypeRegisterHelper::register);
        });
    }
}
