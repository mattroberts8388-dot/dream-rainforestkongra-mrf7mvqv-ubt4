package com.rainforestkongra;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.biome.Biome;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RainforestKongraRainDamage {
    // Ticks a player has spent in the rain unprotected.
    private static final Map<UUID, Integer> RAIN_EXPOSURE = new HashMap<>();

    // 200 ticks (10 seconds) of exposure before damage begins.
    private static final int EXPOSURE_THRESHOLD = 200;
    // Damage applied every 40 ticks (2 seconds) once threshold reached.
    private static final int DAMAGE_INTERVAL = 40;

    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                tickPlayer(player);
            }
        });
    }

    private static void tickPlayer(ServerPlayerEntity player) {
        UUID id = player.getUuid();

        if (player.isSpectator() || player.isCreative() || !player.isAlive()) {
            RAIN_EXPOSURE.remove(id);
            return;
        }

        boolean rainingOnPlayer = isExposedToRain(player);

        if (!rainingOnPlayer) {
            // Dry off slowly.
            int current = RAIN_EXPOSURE.getOrDefault(id, 0);
            if (current > 0) {
                RAIN_EXPOSURE.put(id, Math.max(0, current - 2));
            } else {
                RAIN_EXPOSURE.remove(id);
            }
            return;
        }

        if (hasFullKongraArmor(player)) {
            // Protected: KONGRA armor shields the player from the corrosive rain.
            RAIN_EXPOSURE.remove(id);
            return;
        }

        int exposure = RAIN_EXPOSURE.getOrDefault(id, 0) + 1;
        RAIN_EXPOSURE.put(id, exposure);

        if (exposure >= EXPOSURE_THRESHOLD && (exposure - EXPOSURE_THRESHOLD) % DAMAGE_INTERVAL == 0) {
            player.damage(player.getDamageSources().magic(), 2.0f);
        }
    }

    private static boolean isExposedToRain(ServerPlayerEntity player) {
        if (!player.getWorld().isRaining()) {
            return false;
        }
        var pos = player.getBlockPos();
        boolean underOpenSky = player.getWorld().isSkyVisible(pos);
        if (!underOpenSky) {
            return false;
        }
        Biome biome = player.getWorld().getBiome(pos).value();
        // Rain (not snow) means precipitation is falling here.
        return biome.getPrecipitation(pos) == Biome.Precipitation.RAIN;
    }

    private static boolean hasFullKongraArmor(ServerPlayerEntity player) {
        return isKongra(player.getEquippedStack(EquipmentSlot.HEAD), RainforestKongraModItems.KONGRA_HELMET)
            && isKongra(player.getEquippedStack(EquipmentSlot.CHEST), RainforestKongraModItems.KONGRA_CHESTPLATE)
            && isKongra(player.getEquippedStack(EquipmentSlot.LEGS), RainforestKongraModItems.KONGRA_LEGGINGS)
            && isKongra(player.getEquippedStack(EquipmentSlot.FEET), RainforestKongraModItems.KONGRA_BOOTS);
    }

    private static boolean isKongra(ItemStack stack, net.minecraft.item.Item expected) {
        return stack.isOf(expected) && stack.getItem() instanceof ArmorItem;
    }
}