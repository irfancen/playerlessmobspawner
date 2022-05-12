package com.irfancen.playerlessmobspawner.registry;

import net.minecraftforge.eventbus.api.IEventBus;

public class RegistryHandler {
    public static void init(IEventBus bus) {
        BlockRegistry.BLOCKS.register(bus);
        ItemRegistry.ITEMS.register(bus);
        TileEntityRegistry.TILE_ENTITY_TYPES.register(bus);
    }
}
