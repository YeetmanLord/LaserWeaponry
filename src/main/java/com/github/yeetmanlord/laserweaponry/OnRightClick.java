package com.github.yeetmanlord.laserweaponry;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class OnRightClick implements Listener {

    @EventHandler
    public void onInteract(final PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            for (ItemStack stack : event.getPlayer().getInventory().getArmorContents()) {
                if (stack.hasItemMeta() && stack.getItemMeta().hasDisplayName()) {
                    LaserWeapon weapon = Registry.nameToWeapon.get(stack.getItemMeta().getDisplayName());
                    if (weapon != null) {
                        weapon.activate(event.getPlayer());
                    }
                }
            }

            ItemStack stack = event.getItem();
            if (stack.hasItemMeta() && stack.getItemMeta().hasDisplayName()) {
                LaserWeapon weapon = Registry.nameToWeapon.get(stack.getItemMeta().getDisplayName());
                if (weapon != null) {
                    weapon.activate(event.getPlayer());
                }
            }
        }
    }

}
