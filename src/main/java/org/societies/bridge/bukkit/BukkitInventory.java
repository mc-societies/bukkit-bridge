package org.societies.bridge.bukkit;

import org.bukkit.inventory.PlayerInventory;
import org.societies.bridge.Inventory;
import org.societies.bridge.ItemStack;

/**
 * Represents a BukkitInventory
 */
public class BukkitInventory implements Inventory {

    private final PlayerInventory inventory;

    public BukkitInventory(PlayerInventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public ItemStack[] getContents() {
        ItemStack[] itemStacks = new ItemStack[inventory.getSize()];

        for (int i = 0, length = itemStacks.length; i < length; i++) {
            if (itemStacks[i] == null) {
                continue;
            }
            itemStacks[i] = new BukkitItemStack(inventory.getContents()[i]);

        }

        return itemStacks;
    }

    @Override
    public void remove(ItemStack itemStack) {
        inventory.remove(BukkitItemStack.toBukkitItemStack(itemStack));
    }

    @Override
    public ItemStack getHelmet() {
        if (inventory.getHelmet() == null) {
            return null;
        }
        return new BukkitItemStack(inventory.getHelmet());
    }

    @Override
    public ItemStack getLeggings() {
        if (inventory.getLeggings() == null) {
            return null;
        }
        return new BukkitItemStack(inventory.getLeggings());
    }

    @Override
    public ItemStack getChestplate() {
        if (inventory.getChestplate() == null) {
            return null;
        }
        return new BukkitItemStack(inventory.getChestplate());
    }

    @Override
    public ItemStack getBoots() {
        if (inventory.getBoots() == null) {
            return null;
        }
        return new BukkitItemStack(inventory.getBoots());
    }
}
