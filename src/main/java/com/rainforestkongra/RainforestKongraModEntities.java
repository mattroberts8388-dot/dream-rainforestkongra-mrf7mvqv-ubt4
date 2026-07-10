package com.rainforestkongra;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RainforestKongraModEntities {
    public static final EntityType<KongraEntity> KONGRA = Registry.register(
        Registries.ENTITY_TYPE,
        new Identifier(RainforestKongraMod.MOD_ID, "kongra"),
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, KongraEntity::new)
            .dimensions(EntityDimensions.fixed(1.4f, 2.9f)).build()
    );

    public static final EntityType<JaguarEntity> JAGUAR = Registry.register(
        Registries.ENTITY_TYPE,
        new Identifier(RainforestKongraMod.MOD_ID, "jaguar"),
        FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, JaguarEntity::new)
            .dimensions(EntityDimensions.fixed(0.9f, 0.9f)).build()
    );

    public static final EntityType<ToucanEntity> TOUCAN = Registry.register(
        Registries.ENTITY_TYPE,
        new Identifier(RainforestKongraMod.MOD_ID, "toucan"),
        FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ToucanEntity::new)
            .dimensions(EntityDimensions.fixed(0.5f, 0.6f)).build()
    );

    public static void registerEntities() {
        // Triggers static init / registration above.
    }

    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(KONGRA, KongraEntity.createKongraAttributes());
        FabricDefaultAttributeRegistry.register(JAGUAR, JaguarEntity.createJaguarAttributes());
        FabricDefaultAttributeRegistry.register(TOUCAN, ToucanEntity.createToucanAttributes());
    }
}