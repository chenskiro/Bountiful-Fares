package net.hecco.bountifulfares.mixin.data;

import com.llamalad7.mixinextras.sugar.Local;
import com.xueluoanping.bountifulfaresforge.data.datapack.DatapackRegistryGenerator;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(net.minecraft.core.RegistrySetBuilder.class)
public abstract class RegistrySetBuilderMixin {


    @Inject(method = {"buildPatch"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/core/RegistrySetBuilder$BuildState;throwOnError()V")}, cancellable = true)
    private void buildPatch$fixError(RegistryAccess pRegistryAccess,
                                     HolderLookup.Provider pOriginal,
                                     CallbackInfoReturnable<HolderLookup.Provider> cir,
                                     @Local(ordinal = 1) HolderLookup.Provider provider) {
        // because we not generate feature by dg, so it is not registered.
        if ((Object) this == DatapackRegistryGenerator.REGISTRY_SET_BUILDER)
            cir.setReturnValue(provider);
    }
}