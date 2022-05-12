package com.irfancen.playerlessmobspawner.registry;

import com.irfancen.playerlessmobspawner.PlayerlessMobSpawner;
import com.irfancen.playerlessmobspawner.PlayerlessMobSpawnerBlock;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PlayerlessMobSpawner.MOD_ID);

    public static final RegistryObject<Block> PLAYERLESS_MOB_SPAWNER = BLOCKS.register("spawner", PlayerlessMobSpawnerBlock::new);
}
