package org.societies.bridge.bukkit;

import org.bukkit.Server;
import org.societies.bridge.ItemStack;
import org.societies.bridge.Location;
import org.societies.bridge.World;

import java.util.UUID;

/**
 * Represents a BukkitWorld
 */
public class BukkitWorld implements World {

    private final org.bukkit.World world;

    public BukkitWorld(org.bukkit.World world) {
        this.world = world;
    }

    @Override
    public void dropItem(Location location, ItemStack itemStack) {
        world.dropItemNaturally(
                new org.bukkit.Location(world, location.getX(), location.getY(), location.getZ()),
                BukkitItemStack.toBukkitItemStack(itemStack)
        );
    }

    @Override
    public UUID getUUID() {
        return world.getUID(); //fuck off bukkit!!
    }

    @Override
    public String getName() {
        return world.getName();
    }

    public static Location toLocation(org.bukkit.Location loc) {
        return new Location(new BukkitWorld(loc.getWorld()), loc.getX(), loc.getY(), loc.getZ());
    }

    public static org.bukkit.Location toBukkitLocation(Server server, Location loc) {
        World world = loc.getWorld();
        org.bukkit.World bukkitWorld;

        if (world == null) {
            bukkitWorld = server.getWorlds().get(0);
        } else {
            bukkitWorld = server.getWorld(world.getUUID());
        }

        return new org.bukkit.Location(bukkitWorld, loc.getX(), loc.getY(), loc.getZ());
    }

}
