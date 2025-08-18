package net.hecco.bountifulfares.mixin.render;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.mixin.util.HandledScreenMixin;
import net.hecco.bountifulfares.registry.content.BFEffects;
import net.hecco.bountifulfares.registry.tags.BFEffectTags;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Mixin(EffectRenderingInventoryScreen.class)
public class AbstractInventoryMixin {

    // @Shadow @Final private static ResourceLocation EFFECT_BACKGROUND_LARGE_TEXTURE = ResourceLocation.ofVanilla("container/inventory/effect_background_large");
    // @Shadow @Final private static ResourceLocation EFFECT_BACKGROUND_SMALL_TEXTURE = ResourceLocation.ofVanilla("container/inventory/effect_background_small");
    @Unique
    private static final ResourceLocation ACIDFIED_EFFECT_BACKGROUND_SMALL_TEXTURE = BountifulFares.rl("container/inventory/acidified_effect_background_small");
    @Unique
    private static final ResourceLocation ACIDFIED_EFFECT_BACKGROUND_LARGE_TEXTURE = BountifulFares.rl("container/inventory/acidified_effect_background_large");

    @Inject(method = "renderBackgrounds", at = @At(value = "HEAD"), cancellable = true)
    private void bountifulfares_acidicBackgroundOverlay(GuiGraphics context, int x, int height, Iterable<MobEffectInstance> statusEffects, boolean wide, CallbackInfo ci) {
        if (BountifulFares.CONFIG.isAcidifiedEffectIconEffects()) {
            List<Holder<MobEffect>> effects = new ArrayList<>();
            for (MobEffectInstance instance : statusEffects) {
                effects.add(instance.getEffect());
            }
            if (effects.contains(BFEffects.ACIDIC)) {
                int i = ((HandledScreenMixin) this).getY();

                for (Iterator<MobEffectInstance> var7 = statusEffects.iterator(); var7.hasNext(); i += height) {
                    ResourceLocation largeTexture = AbstractContainerScreen.INVENTORY_LOCATION;
                    ResourceLocation smallTexture = AbstractContainerScreen.INVENTORY_LOCATION;
                    MobEffectInstance effect = var7.next();
                    if (effect.getEffect() != BFEffects.ACIDIC&&effect.getEffect().is(BFEffectTags.ACIDIC_BLACKLIST)) {
                        largeTexture = ACIDFIED_EFFECT_BACKGROUND_LARGE_TEXTURE;
                        smallTexture = ACIDFIED_EFFECT_BACKGROUND_SMALL_TEXTURE;
                    }
                    if (wide) {
                        // context.drawGuiTexture(largeTexture, x, i, 120, 32);
                        context.blit(largeTexture, x, i, 0, 166, 120, 32);

                    } else {
                        // context.drawGuiTexture(smallTexture, x, i, 32, 32);
                        context.blit(smallTexture, x, i, 0, 198, 32, 32);
                    }
                }
                ci.cancel();
            }
        }
    }


}
