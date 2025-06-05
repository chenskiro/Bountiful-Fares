package com.xueluoanping.bountifulfaresforge;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraftforge.fml.common.Mod;


@Mod(BountifulFares.MOD_ID)
public class BountifulFaresForge {
    public final BountifulFares MOD_INSTANCE;

    public BountifulFaresForge() {
        MOD_INSTANCE = new BountifulFares();
        MOD_INSTANCE.onInitialize();
    }
}
