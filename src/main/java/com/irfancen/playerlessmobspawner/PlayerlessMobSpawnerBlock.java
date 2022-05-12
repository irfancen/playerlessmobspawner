package com.irfancen.playerlessmobspawner;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.SpawnerBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class PlayerlessMobSpawnerBlock extends SpawnerBlock {
    public PlayerlessMobSpawnerBlock() {
        super(AbstractBlock.Properties.copy(Blocks.SPAWNER));
    }

    @Override
    public TileEntity newBlockEntity(IBlockReader blockReader) {
        return new PlayerlessMobSpawnerTileEntity();
    }
}
