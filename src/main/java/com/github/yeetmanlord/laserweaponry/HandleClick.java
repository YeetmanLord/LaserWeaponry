package com.github.yeetmanlord.laserweaponry;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;


public class HandleClick implements Listener {

    @EventHandler
    public void menuClicked(InventoryClickEvent event) {

        if (event.getWhoClicked() instanceof Player && event.getClickedInventory() != null) {
            InventoryHolder holder = event.getClickedInventory().getHolder();
            if (holder instanceof SelectionMenu) {
                switch (event.getSlot()) {
                    case 11:
                        event.getWhoClicked().getInventory().addItem(Registry.LASER_EYES.getItem());
                        break;
                    case 13:
                        event.getWhoClicked().getInventory().addItem(Registry.LASER_GUN.getItem());
                        break;
                    case 15:
                        event.getWhoClicked().getInventory().addItem(Registry.SUPER_LASER_GUN.getItem());
                        break;
                }
                event.setCancelled(true);
            }
        }

    }
}