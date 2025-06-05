// package net.hecco.bountifulfares.registry.content;
//
// import com.terraformersmc.terraform.boat.api.TerraformBoatType;
// import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
// import net.hecco.bountifulfares.BountifulFares;
// import net.minecraft.core.Registry;
// import net.minecraft.resources.ResourceKey;
// import net.minecraft.resources.ResourceLocation;
//
// public class BFBoats {
//     public static final ResourceLocation HOARY_BOAT_ID = BountifulFares.rl( "hoary_boat");
//     public static final ResourceLocation HOARY_CHEST_BOAT_ID = BountifulFares.rl( "hoary_chest_boat");
//
//     public static final ResourceLocation WALNUT_BOAT_ID = BountifulFares.rl( "walnut_boat");
//     public static final ResourceLocation WALNUT_CHEST_BOAT_ID = BountifulFares.rl( "walnut_chest_boat");
//
//     public static final ResourceKey<TerraformBoatType> HOARY_BOAT_KEY = TerraformBoatTypeRegistry.createKey(HOARY_BOAT_ID);
//     public static final ResourceKey<TerraformBoatType> WALNUT_BOAT_KEY = TerraformBoatTypeRegistry.createKey(WALNUT_BOAT_ID);
//
//     public static void registerBoats() {
//         TerraformBoatType hoaryBoat = new TerraformBoatType.Builder()
//                 .item(BFItems.HOARY_BOAT.get())
//                 .chestItem(BFItems.HOARY_CHEST_BOAT.get())
//                 .planks(BFBlocks.HOARY_PLANKS.asItem())
//                 .build();
//         Registry.register(TerraformBoatTypeRegistry.INSTANCE, HOARY_BOAT_KEY, hoaryBoat);
//         TerraformBoatType walnutBoat = new TerraformBoatType.Builder()
//                 .item(BFItems.WALNUT_BOAT.get())
//                 .chestItem(BFItems.WALNUT_CHEST_BOAT.get())
//                 .planks(BFBlocks.WALNUT_PLANKS.asItem())
//                 .build();
//         Registry.register(TerraformBoatTypeRegistry.INSTANCE, WALNUT_BOAT_KEY, walnutBoat);
//     }
// }
