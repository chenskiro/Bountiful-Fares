package net.hecco.bountifulfares.registry.content;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.effect.*;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegisterEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BFEffects {
    // public static final Holder<MobEffect> ACIDIC = registerStatusEffect("acidic", new AcidicEffect(MobEffectCategory.NEUTRAL, 0xD1FF00));
    // public static final Holder<MobEffect> STUPOR = registerStatusEffect("stupor", new StuporEffect(MobEffectCategory.NEUTRAL, 0x5F1ED8));
    //
    // public static final Holder<MobEffect> EBULLIENCE = registerStatusEffect("ebullience", new EbullienceEffect(MobEffectCategory.BENEFICIAL, 0xE9DEE2));
    //
    // //    public static final StatusEffect GORGING = registerStatusEffect("gorging", new GorgingEffect(StatusEffectCategory.NEUTRAL, 0x8d6f3a).addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "91AEAA56-376B-4498-935B-2F7F68070635", 0.13, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
    //
    // public static final Holder<MobEffect> ENRICHMENT = registerStatusEffect("enrichment", new EnrichmentEffect(MobEffectCategory.BENEFICIAL, 0xffd48f)
    //         .addAttributeModifier(Attributes.MOVEMENT_SPEED, BountifulFares.rl(BountifulFares.MOD_ID, "effect.speed"), 0.08, AttributeModifier.Operation.MULTIPLY_TOTAL)
    //         .addAttributeModifier(Attributes.ATTACK_SPEED, BountifulFares.rl(BountifulFares.MOD_ID, "effect.attack_speed"), 0.08, AttributeModifier.Operation.MULTIPLY_TOTAL)
    //         .addAttributeModifier(Attributes.ATTACK_DAMAGE, BountifulFares.rl(BountifulFares.MOD_ID, "effect.attack"), 0.2, AttributeModifier.Operation.MULTIPLY_TOTAL)
    //         .addAttributeModifier(Attributes.LUCK, BountifulFares.rl(BountifulFares.MOD_ID, "effect.luck"), 1.0, AttributeModifier.Operation.MULTIPLY_TOTAL)
    // );
    // public static final Holder<MobEffect> RESTORATION = registerStatusEffect("restoration", new RestorationEffect(MobEffectCategory.BENEFICIAL, 0xFF4B19));
    // private static Holder<MobEffect> registerStatusEffect(String name, MobEffect statusEffect) {
    //     return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, BountifulFares.rl(BountifulFares.MOD_ID, name), statusEffect);
    // }
    // public static void registerEffects() {
    // }

    public static final MobEffect ACIDIC = new AcidicEffect(MobEffectCategory.NEUTRAL, 0xD1FF00);
    public static final MobEffect STUPOR = new StuporEffect(MobEffectCategory.NEUTRAL, 0x5F1ED8);
    public static final MobEffect EBULLIENCE = new EbullienceEffect(MobEffectCategory.BENEFICIAL, 0xE9DEE2);
    public static final MobEffect ENRICHMENT = new AcidicEffect(MobEffectCategory.BENEFICIAL, 0xffd48f)
            .addAttributeModifier(Attributes.MOVEMENT_SPEED, BountifulFares.rl("effect.speed").getPath(), 0.08, AttributeModifier.Operation.MULTIPLY_TOTAL)
            .addAttributeModifier(Attributes.ATTACK_SPEED, BountifulFares.rl("effect.attack_speed").getPath(), 0.08, AttributeModifier.Operation.MULTIPLY_TOTAL)
            .addAttributeModifier(Attributes.ATTACK_DAMAGE, BountifulFares.rl("effect.attack").getPath(), 0.2, AttributeModifier.Operation.MULTIPLY_TOTAL)
            .addAttributeModifier(Attributes.LUCK, BountifulFares.rl("effect.luck").getPath(), 1.0, AttributeModifier.Operation.MULTIPLY_TOTAL);
    public static final MobEffect RESTORATION = new RestorationEffect(MobEffectCategory.BENEFICIAL, 0xFF4B19);

    @SubscribeEvent
    public static void onRegister(RegisterEvent event) {
        event.register(Registries.MOB_EFFECT, registerHelper -> {
            registerHelper.register(BountifulFares.rl("acidic"), ACIDIC);
            registerHelper.register(BountifulFares.rl("stupor"), STUPOR);
            registerHelper.register(BountifulFares.rl("ebullience"), EBULLIENCE);
            registerHelper.register(BountifulFares.rl("enrichment"), ENRICHMENT);
            registerHelper.register(BountifulFares.rl("restoration"), RESTORATION);
        });
    }
}
