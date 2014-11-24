package net.catharos.bridge.bukkit;

import net.catharos.bridge.Inventory;
import net.catharos.bridge.ItemStack;
import net.catharos.bridge.Materials;
import org.bukkit.inventory.PlayerInventory;

/**
 * Represents a BukkitInventory
 */
public class BukkitInventory implements Inventory {

    private final Materials materials;
    private final PlayerInventory inventory;

    public BukkitInventory(Materials materials, PlayerInventory inventory) {
        this.materials = materials;
        this.inventory = inventory;
    }

    @Override
    public ItemStack[] getContents() {
        ItemStack[] itemStacks = new ItemStack[inventory.getSize()];

        for (int i = 0, length = itemStacks.length; i < length; i++) {
            if (itemStacks[i] == null) {
                continue;
            }
            itemStacks[i] = new BukkitItemStack(materials, inventory.getContents()[i]);

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
        return new BukkitItemStack(materials, inventory.getHelmet());
    }

    @Override
    public ItemStack getLeggings() {
        if (inventory.getLeggings() == null) {
            return null;
        }
        return new BukkitItemStack(materials, inventory.getLeggings());
    }

    @Override
    public ItemStack getChestplate() {
        if (inventory.getChestplate() == null) {
            return null;
        }
        return new BukkitItemStack(materials, inventory.getChestplate());
    }

    @Override
    public ItemStack getBoots() {
        if (inventory.getBoots() == null) {
            return null;
        }
        return new BukkitItemStack(materials, inventory.getBoots());
    }
}
