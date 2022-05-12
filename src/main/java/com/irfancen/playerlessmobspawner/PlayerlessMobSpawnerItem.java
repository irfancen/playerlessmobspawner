package com.irfancen.playerlessmobspawner;

import com.irfancen.playerlessmobspawner.registry.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.SpawnerBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.tileentity.MobSpawnerTileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.WeightedSpawnerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;


public class PlayerlessMobSpawnerItem extends Item {

    public PlayerlessMobSpawnerItem() {
        super(new Item.Properties().tab(ItemGroup.TAB_MISC));
    }

    @Override
    public ActionResultType useOn(ItemUseContext ctx) {
        BlockPos pos = ctx.getClickedPos();
        World world = ctx.getLevel();
        Block block = world.getBlockState(pos).getBlock();
        ItemStack stack = ctx.getItemInHand();

        if (!world.isClientSide()) {
            if (block instanceof SpawnerBlock) {
                WeightedSpawnerEntity spawnerEntity = ((MobSpawnerTileEntity) world.getBlockEntity(pos)).getSpawner().nextSpawnData;
                world.setBlock(pos, BlockRegistry.PLAYERLESS_MOB_SPAWNER.get().defaultBlockState(), Constants.BlockFlags.BLOCK_UPDATE);
                ((MobSpawnerTileEntity) world.getBlockEntity(pos)).getSpawner().setNextSpawnData(spawnerEntity);
                if (!ctx.getPlayer().isCreative()) {
                    stack.shrink(1);
                    return ActionResultType.PASS;
                }
                return ActionResultType.SUCCESS;
            }
        }
        return super.useOn(ctx);
    }
}
