package com.irfancen.playerlessmobspawner.registry;

import com.irfancen.playerlessmobspawner.PlayerlessMobSpawner;
import com.irfancen.playerlessmobspawner.PlayerlessMobSpawnerTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityRegistry {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, PlayerlessMobSpawner.MOD_ID);

    public static final RegistryObject<TileEntityType<PlayerlessMobSpawnerTileEntity>> PLAYERLESS_MOB_SPAWNER = TILE_ENTITY_TYPES
            .register("spawner", () -> TileEntityType.Builder
                    .of(PlayerlessMobSpawnerTileEntity::new, BlockRegistry.PLAYERLESS_MOB_SPAWNER.get()).build(null));
}
