package com.irfancen.playerlessmobspawner.events;

import com.irfancen.playerlessmobspawner.PlayerlessMobSpawner;
import com.irfancen.playerlessmobspawner.registry.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.tileentity.MobSpawnerTileEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = PlayerlessMobSpawner.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventHandler {

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void onSpawnerRightClick(PlayerInteractEvent.RightClickBlock event) {
        ItemStack stack = event.getItemStack();
        World world = event.getWorld();
        BlockState blockstate = world.getBlockState(event.getPos());
        if (!world.isClientSide()) {
            if (stack.getItem() instanceof SpawnEggItem) {
                EntityType<?> spawnEggEntity = ((SpawnEggItem) stack.getItem()).getType(stack.getTag());
                if (checkBlockAt(event, BlockRegistry.PLAYERLESS_MOB_SPAWNER.get().getBlock())) {
                    MobSpawnerTileEntity spawnerTileEntity = (MobSpawnerTileEntity) world.getBlockEntity(event.getPos());
                    spawnerTileEntity.getSpawner().setEntityId(spawnEggEntity);
                    spawnerTileEntity.setChanged();
                    world.sendBlockUpdated(event.getPos(), blockstate, blockstate, 3);
                    if (!event.getPlayer().isCreative()) {
                        stack.shrink(1);
                    }
                    event.setCanceled(true);
                }
            }
        }
    }

    private static boolean checkBlockAt(PlayerInteractEvent event, Block block) {
        return event.getWorld().getBlockState(event.getPos()).getBlock().equals(block);
    }

}
