package net.hecco.bountifulfares.compat.twigs;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegisterEvent;

import java.util.HashMap;
import java.util.Map;

import static net.hecco.bountifulfares.BountifulFares.TWIGS_MOD_ID;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TwigsSounds {
    private static final Map<ResourceKey<SoundEvent>, SoundEvent> sounds = new HashMap<>();
    public static SoundEvent LAMP_PLACE = registerSoundEvent("block.lamp.place");
    public static SoundEvent LAMP_BREAK = registerSoundEvent("block.lamp.break");
    public static SoundEvent LAMP_HIT = registerSoundEvent("block.lamp.hit");
    public static SoundEvent LAMP_STEP = registerSoundEvent("block.lamp.step");
    public static SoundEvent LAMP_FALL = registerSoundEvent("block.lamp.fall");
    public static SoundEvent LAMP_ON = registerSoundEvent("block.lamp.on");
    public static SoundEvent LAMP_OFF = registerSoundEvent("block.lamp.off");
    public static SoundType LAMP = new ForgeSoundType(1, 0.7f, () -> LAMP_BREAK, () -> LAMP_STEP, () -> LAMP_PLACE, () -> LAMP_HIT, () -> LAMP_FALL);

    public static SoundEvent registerSoundEvent(String name) {
        ResourceLocation identifier = BountifulFares.rl(name);
        // return Registry.register(BuiltInRegistries.SOUND_EVENT, identifier, SoundEvent.createVariableRangeEvent(identifier));
        SoundEvent variableRangeEvent = SoundEvent.createVariableRangeEvent(identifier);
        sounds.put(ResourceKey.create(Registries.SOUND_EVENT, identifier), variableRangeEvent);
        return variableRangeEvent;
    }
    // public static void registerSounds() {
    // }

    @SubscribeEvent
    public static void blockRegister(RegisterEvent event) {
        if (BountifulFares.isModLoaded(TWIGS_MOD_ID)) {
            event.register(Registries.SOUND_EVENT, registerHelper -> {
                sounds.forEach(registerHelper::register);
            });
        }
    }
}
