package org.societies.bridge.bukkit;


import org.bukkit.plugin.Plugin;
import org.societies.bridge.Scheduler;

import javax.inject.Inject;

/**
 * Represents a BukkitScheduler
 */
public class BukkitScheduler implements Scheduler {

    private final org.bukkit.scheduler.BukkitScheduler scheduler;
    private final Plugin plugin;

    @Inject
    public BukkitScheduler(org.bukkit.scheduler.BukkitScheduler scheduler, Plugin plugin) {
        this.scheduler = scheduler;
        this.plugin = plugin;
    }

    @Override
    public void scheduleSyncRepeatingTask(Runnable task, long period) {
        scheduler.scheduleSyncRepeatingTask(plugin, task, 0L, period);
    }
}
