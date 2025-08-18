package net.hecco.bountifulfares.registry.content;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.entity.FlourProjectileEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class BFEntities {
    // private static final Map<ResourceKey<EntityType<?>>, EntityType<?>> entityTypes = new HashMap<>();
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE_DEFERRED_REGISTER = DeferredRegister.create(Registries.ENTITY_TYPE, BountifulFares.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<FlourProjectileEntity>> THROWN_FLOUR_PROJECTILE = ENTITY_TYPE_DEFERRED_REGISTER.register(
            "flour",
            ()->EntityType.Builder.<FlourProjectileEntity>of(FlourProjectileEntity::new, MobCategory.CREATURE)
                    .sized(0.25f, 0.25f).setTrackingRange(4).setUpdateInterval(10).build("flour"));

//     public static void registerModEntities() {
// //        BountifulFares.LOGGER.info("Registering Mod Entities for " + BountifulFares.MOD_ID);
//     }
//
//     private static <T extends Entity> EntityType<T> registerForCache(Registry<EntityType<?>> registry, ResourceLocation rl, EntityType<T> type) {
//         entityTypes.put(ResourceKey.create(Registries.ENTITY_TYPE, rl), type);
//         return type;
//     }


}
