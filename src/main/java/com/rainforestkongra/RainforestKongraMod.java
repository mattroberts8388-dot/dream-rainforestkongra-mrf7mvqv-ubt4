package com.rainforestkongra;

import net.fabricmc.api.ModInitializer;

public class RainforestKongraMod implements ModInitializer {
    public static final String MOD_ID = "rainforestkongra";

    @Override
    public void onInitialize() {
        RainforestKongraModEntities.registerEntities();
        RainforestKongraModItems.registerItems();
        RainforestKongraRainDamage.register();
        RainforestKongraModEntities.registerAttributes();
    }
}