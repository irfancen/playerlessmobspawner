package com.irfancen.playerlessmobspawner;

import com.irfancen.playerlessmobspawner.registry.TileEntityRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.MobSpawnerTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.WeightedSpawnerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.spawner.AbstractSpawner;


public class PlayerlessMobSpawnerTileEntity extends MobSpawnerTileEntity {
    private final AbstractSpawner customSpawner = new AbstractSpawner() {
        public void broadcastEvent(int flag) {
            PlayerlessMobSpawnerTileEntity.this.level.blockEvent(PlayerlessMobSpawnerTileEntity.this.worldPosition, Blocks.SPAWNER, flag, 0);
        }

        public World getLevel() {
            return PlayerlessMobSpawnerTileEntity.this.level;
        }

        public BlockPos getPos() {
            return PlayerlessMobSpawnerTileEntity.this.worldPosition;
        }

        public void setNextSpawnData(WeightedSpawnerEntity weightedSpawnerEntity) {
            super.setNextSpawnData(weightedSpawnerEntity);
            if (this.getLevel() != null) {
                BlockState blockstate = this.getLevel().getBlockState(this.getPos());
                this.getLevel().sendBlockUpdated(PlayerlessMobSpawnerTileEntity.this.worldPosition, blockstate, blockstate, 4);
            }
        }

        public boolean isNearPlayer() {
            return true;
        }
    };

    @Override
    public TileEntityType<?> getType() {
        return TileEntityRegistry.PLAYERLESS_MOB_SPAWNER.get();
    }

    @Override
    public void load(BlockState p_230337_1_, CompoundNBT p_230337_2_) {
        super.load(p_230337_1_, p_230337_2_);
        this.customSpawner.load(p_230337_2_);
    }

    @Override
    public CompoundNBT save(CompoundNBT p_189515_1_) {
        super.save(p_189515_1_);
        this.customSpawner.save(p_189515_1_);
        return p_189515_1_;
    }

    @Override
    public void tick() {
        this.customSpawner.tick();
    }

    @Override
    public boolean triggerEvent(int p_145842_1_, int p_145842_2_) {
        return this.customSpawner.onEventTriggered(p_145842_1_) ? true : super.triggerEvent(p_145842_1_, p_145842_2_);
    }

    @Override
    public AbstractSpawner getSpawner() {
        return this.customSpawner;
    }
}
