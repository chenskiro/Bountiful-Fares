package net.hecco.bountifulfares.compat.farmersdelight;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

public class FarmersDelightItemGroups {
    public static final ResourceKey<CreativeModeTab> BOUNTIFUL_FARES_TAB =
            ResourceKey.create(Registries.CREATIVE_MODE_TAB, BountifulFares.rl("bountiful_fares")
            );
    public static final ResourceKey<CreativeModeTab> FARMERS_DELIGHT_TAB =
            ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.tryBuild(BountifulFares.FARMERS_DELIGHT_MOD_ID, "farmersdelight")
            );

    
    public static void onBuildCreativeModeTabContentsEvent(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey().equals(BOUNTIFUL_FARES_TAB)) {
            event.accept(FarmersDelightBlocks.HOARY_CABINET);
            event.accept(FarmersDelightBlocks.WALNUT_CABINET);
        } else if (event.getTabKey().equals(FARMERS_DELIGHT_TAB)) {
            event.accept(FarmersDelightBlocks.HOARY_CABINET);
            event.accept(FarmersDelightBlocks.WALNUT_CABINET);
        }
    }

    //
    // public static void tabFarmersDelight(FabricItemGroupEntries tab) {
    //     Block warped_cabinet = BuiltInRegistries.BLOCK.get(ResourceLocation.tryBuild(BountifulFares.FARMERS_DELIGHT_MOD_ID, "warped_cabinet"));
    //
    //     tab.addAfter(warped_cabinet, FarmersDelightBlocks.HOARY_CABINET);
    //     tab.addAfter(FarmersDelightBlocks.HOARY_CABINET, FarmersDelightBlocks.WALNUT_CABINET);
    // }
    //
    // public static void tabBountifulFares(FabricItemGroupEntries tab) {
    //     tab.addAfter(BFItems.HOARY_CHEST_BOAT, FarmersDelightBlocks.HOARY_CABINET);
    //     tab.addAfter(BFItems.WALNUT_CHEST_BOAT, FarmersDelightBlocks.WALNUT_CABINET);
    // }
    //
    // public static void registerModItemTabs() {
    //     ItemGroupEvents.modifyEntriesEvent(BOUNTIFUL_FARES_TAB).register(FarmersDelightItemGroups::tabBountifulFares);
    //     ItemGroupEvents.modifyEntriesEvent(FARMERS_DELIGHT_TAB).register(FarmersDelightItemGroups::tabFarmersDelight);
    // }
}
