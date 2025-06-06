package com.xueluoanping.bountifulfaresforge.api.data.provider;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;

import java.util.List;
import java.util.Set;

public class ModNameLootTableProvider extends LootTableProvider {
    public ModNameLootTableProvider(PackOutput pOutput, Set<ResourceLocation> pRequiredTables, List<SubProviderEntry> pSubProviders) {
        super(pOutput, pRequiredTables, pSubProviders);
    }

    public final String getSelfName() {
        return "Loot Tables : %s".formatted(this.getClass().getName());
    }
}
