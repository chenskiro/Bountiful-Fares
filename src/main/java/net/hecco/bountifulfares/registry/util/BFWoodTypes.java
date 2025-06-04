package net.hecco.bountifulfares.registry.util;

import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.WoodType;

public class BFWoodTypes {
    public static final WoodType HOARY = new WoodTypeBuilder().register(BountifulFares.rl( "hoary"), BFBlockSetTypes.HOARY);
    public static final WoodType WALNUT = new WoodTypeBuilder().register(BountifulFares.rl( "walnut"), BFBlockSetTypes.WALNUT);
}

