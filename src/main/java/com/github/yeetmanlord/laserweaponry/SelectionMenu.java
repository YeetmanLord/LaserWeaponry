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

            this.inv.setItem(11, Registry.LASER_EYES.getItem());
            this.inv.setItem(13, Registry.LASER_GUN.getItem());
            this.inv.setItem(15, Registry.SUPER_LASER_GUN.getItem());

            player.openInventory(this.inv);
        });
    }
}
