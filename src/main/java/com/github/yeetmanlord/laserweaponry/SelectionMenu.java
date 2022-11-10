package com.github.yeetmanlord.laserweaponry;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class SelectionMenu implements InventoryHolder {
    protected Inventory inv;

    @Override
    public Inventory getInventory() {
        return inv;
    }

    public void open(Player player) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(LaserWeaponry.instance, () -> {
            player.closeInventory();
            this.inv = Bukkit.createInventory(this, 27, "Select an item");

            this.inv.setItem(10, Registry.LASER_EYES.getItem());
            this.inv.setItem(12, Registry.LASER_GUN.getItem());
            this.inv.setItem(14, Registry.SUPER_LASER_GUN.getItem());
            this.inv.setItem(16, Registry.DOOM_LASER.getItem());

            player.openInventory(this.inv);
        });
    }
}
