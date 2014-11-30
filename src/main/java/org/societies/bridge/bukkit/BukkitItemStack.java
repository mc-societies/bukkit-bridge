package org.societies.bridge.bukkit;

import org.societies.bridge.ItemStack;
import org.societies.bridge.Material;
import org.societies.bridge.Materials;

/**
 * Represents a BukkitItemStack
 */
public class BukkitItemStack implements ItemStack {

    private final Materials materials;
    private final org.bukkit.inventory.ItemStack itemStack;

    public BukkitItemStack(Materials materials, org.bukkit.inventory.ItemStack itemStack) {
        if (itemStack == null) {
            throw new IllegalArgumentException("Itemstack not not be null!");
        }
        this.materials = materials;
        this.itemStack = itemStack;
    }

    @Override
    public int getAmount() {
        return itemStack.getAmount();
    }

    @SuppressWarnings("deprecation")
    @Override
    public Material getType() {
        return materials.getMaterial(itemStack.getType().getId());
    }

    public static org.bukkit.inventory.ItemStack toBukkitItemStack(ItemStack itemStack) {
        return new org.bukkit.inventory.ItemStack(toBukkitMaterial(itemStack.getType()), itemStack.getAmount());
    }

    @SuppressWarnings("deprecation")
    public static org.bukkit.Material toBukkitMaterial(Material material) {
        return org.bukkit.Material.getMaterial(material.getID());
    }
}
