package net.hecco.bountifulfares.registry.util;

// import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.world.level.block.state.properties.WoodType;


public class BFWoodTypes {

    public static final WoodType HOARY = new WoodType(BountifulFares.rl( "hoary").toLanguageKey(), BFBlockSetTypes.HOARY);
    public static final WoodType WALNUT = new WoodType(BountifulFares.rl( "walnut").toLanguageKey(), BFBlockSetTypes.WALNUT);

    public static void registerWoodTypes() {
        WoodType.register(HOARY);
        WoodType.register(WALNUT);
    }
}

