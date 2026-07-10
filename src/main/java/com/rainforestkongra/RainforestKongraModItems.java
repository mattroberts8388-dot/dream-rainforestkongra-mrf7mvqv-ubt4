package com.rainforestkongra;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RainforestKongraModItems {
    public static final Item RAINFOREST_ESSENCE = new Item(new Item.Settings());
    public static final Item COBRA_SCALE = new Item(new Item.Settings());
    public static final Item GORILLA_HIDE = new Item(new Item.Settings());

    public static final Item KONGRA_HELMET = new ArmorItem(
        KongraArmorMaterial.INSTANCE, ArmorItem.Type.HELMET, new Item.Settings());
    public static final Item KONGRA_CHESTPLATE = new ArmorItem(
        KongraArmorMaterial.INSTANCE, ArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final Item KONGRA_LEGGINGS = new ArmorItem(
        KongraArmorMaterial.INSTANCE, ArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final Item KONGRA_BOOTS = new ArmorItem(
        KongraArmorMaterial.INSTANCE, ArmorItem.Type.BOOTS, new Item.Settings());

    public static final Item KONGRA_SPAWN_EGG = new SpawnEggItem(
        RainforestKongraModEntities.KONGRA, 0x2b2b2b, 0x66cc33, new Item.Settings());
    public static final Item JAGUAR_SPAWN_EGG = new SpawnEggItem(
        RainforestKongraModEntities.JAGUAR, 0xd9a441, 0x2b2b2b, new Item.Settings());
    public static final Item TOUCAN_SPAWN_EGG = new SpawnEggItem(
        RainforestKongraModEntities.TOUCAN, 0x111111, 0xffcc00, new Item.Settings());

    private static Item register(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(RainforestKongraMod.MOD_ID, name), item);
    }

    public static void registerItems() {
        register("rainforest_essence", RAINFOREST_ESSENCE);
        register("cobra_scale", COBRA_SCALE);
        register("gorilla_hide", GORILLA_HIDE);
        register("kongra_helmet", KONGRA_HELMET);
        register("kongra_chestplate", KONGRA_CHESTPLATE);
        register("kongra_leggings", KONGRA_LEGGINGS);
        register("kongra_boots", KONGRA_BOOTS);
        register("kongra_spawn_egg", KONGRA_SPAWN_EGG);
        register("jaguar_spawn_egg", JAGUAR_SPAWN_EGG);
        register("toucan_spawn_egg", TOUCAN_SPAWN_EGG);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RAINFOREST_ESSENCE);
            entries.add(COBRA_SCALE);
            entries.add(GORILLA_HIDE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(KONGRA_HELMET);
            entries.add(KONGRA_CHESTPLATE);
            entries.add(KONGRA_LEGGINGS);
            entries.add(KONGRA_BOOTS);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
            entries.add(KONGRA_SPAWN_EGG);
            entries.add(JAGUAR_SPAWN_EGG);
            entries.add(TOUCAN_SPAWN_EGG);
        });
    }
}