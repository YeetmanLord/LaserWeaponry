package com.github.yeetmanlord.laserweaponry;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;

public class Interactions implements Listener {

    @EventHandler
    public void onInteract(final PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            ItemStack stack = event.getItem();
            if (stack.hasItemMeta() && stack.getItemMeta().hasDisplayName()) {
                LaserWeapon weapon = Registry.nameToWeapon.get(stack.getItemMeta().getDisplayName());
                if (weapon != null && Registry.getCooldownTracker(event.getPlayer()).checkCooldown(weapon)) {
                    weapon.activate(event.getPlayer());
                } else if (!Registry.getCooldownTracker(event.getPlayer()).checkCooldown(weapon)) {
                    event.getPlayer().sendMessage(ChatColor.RED + "You cannot use " + ChatColor.translateAlternateColorCodes('&', weapon.name) + " weapon yet");
                }
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onSneak(final PlayerToggleSneakEvent event) {
        if (event.isSneaking()) {
            for (ItemStack stack : event.getPlayer().getInventory().getArmorContents()) {
                if (stack.hasItemMeta() && stack.getItemMeta().hasDisplayName()) {
                    LaserWeapon weapon = Registry.nameToWeapon.get(stack.getItemMeta().getDisplayName());
                    if (weapon != null) {
                        Registry.getCooldownTracker(event.getPlayer()).onSneak(weapon, true);
                    }
                }
            }
        }
    }

}
