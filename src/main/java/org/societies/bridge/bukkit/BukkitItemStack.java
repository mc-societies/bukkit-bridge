package org.societies.bridge.bukkit;

import org.societies.bridge.ItemStack;
import org.societies.bridge.Material;

/**
 * Represents a BukkitItemStack
 */
public class BukkitItemStack implements ItemStack {

    private final org.bukkit.inventory.ItemStack itemStack;

    public BukkitItemStack(org.bukkit.inventory.ItemStack itemStack) {
        if (itemStack == null) {
            throw new IllegalArgumentException("ItemStack mustn't be null!");
        }

        this.itemStack = itemStack;
    }

    @Override
    public int getAmount() {
        return itemStack.getAmount();
    }

    @SuppressWarnings("deprecation")
    @Override
    public Material getType() {
        return new BukkitMaterial(itemStack.getType());
    }

    public static org.bukkit.inventory.ItemStack toBukkitItemStack(ItemStack itemStack) {
        return new org.bukkit.inventory.ItemStack(toBukkitMaterial(itemStack.getType()), itemStack.getAmount());
    }

    @SuppressWarnings("deprecation")
    public static org.bukkit.Material toBukkitMaterial(Material material) {
        return org.bukkit.Material.getMaterial(material.getID());
    }
}
