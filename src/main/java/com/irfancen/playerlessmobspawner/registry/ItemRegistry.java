package com.irfancen.playerlessmobspawner.registry;

import com.irfancen.playerlessmobspawner.PlayerlessMobSpawner;
import com.irfancen.playerlessmobspawner.PlayerlessMobSpawnerItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PlayerlessMobSpawner.MOD_ID);

    public static final RegistryObject<Item> PLAYERLESS_MOB_SPAWNER = ITEMS.register("spawner",
            PlayerlessMobSpawnerItem::new);
}
