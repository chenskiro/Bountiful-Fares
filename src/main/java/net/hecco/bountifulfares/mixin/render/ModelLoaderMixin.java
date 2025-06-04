package net.hecco.bountifulfares.mixin.render;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ModelBakery.class)
public abstract class ModelLoaderMixin {
    @Shadow
    protected abstract void loadItemModel(ModelResourceLocation id);

    @Inject(method = {"<init>"}, at = {@At(value = "invoke", ordinal = 0, target = "Lnet/minecraft/client/render/model/ModelLoader;loadItemModel(Lnet/minecraft/client/util/ModelIdentifier;)V")})
    private void addModels(CallbackInfo info) {
        this.loadItemModel(ModelResourceLocation.ofInventoryVariant(BountifulFares.rl( "sun_hat_head")));
    }
}