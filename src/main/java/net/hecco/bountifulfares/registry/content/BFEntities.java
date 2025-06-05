package net.hecco.bountifulfares.registry.content;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.entity.FlourProjectileEntity;
import net.minecraft.core.DefaultedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

public class BFEntities {
    // private static final Map<ResourceKey<EntityType<?>>, EntityType<?>> entityTypes = new HashMap<>();
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, BountifulFares.MOD_ID);

    public static final RegistryObject<EntityType<FlourProjectileEntity>> THROWN_FLOUR_PROJECTILE = ENTITY_TYPE_DEFERRED_REGISTER.register(
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
