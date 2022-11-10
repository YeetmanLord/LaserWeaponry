package com.github.yeetmanlord.laserweaponry;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class LaserWeaponry extends JavaPlugin implements CommandExecutor {

    public static LaserWeaponry instance;

    @Override
    public void onEnable() {
        instance = this;

        this.getCommand("laser_weapons").setExecutor(((sender, command, label, args) -> {
            if (sender instanceof Player) {
                if (sender.hasPermission("laserweaponry.admin")) {
                    new SelectionMenu().open((Player) sender);
                }
            } else {
                sender.sendMessage(ChatColor.RED + "This command can only be run by players");
            }

            return true;
        }));

        getServer().getPluginManager().registerEvents(new HandleClick(), this);
        getServer().getPluginManager().registerEvents(new Interactions(), this);
    }

    @Override
    public void onDisable() {

    }
}
