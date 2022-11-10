package com.github.yeetmanlord.laserweaponry;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class LaserWeaponry extends JavaPlugin implements CommandExecutor {

    private static int getVersion() {
        try {
            Server server = Bukkit.getServer();
            Object nmsServer = server.getClass().getMethod("getServer").invoke(server);
            String versionStr = (String) nmsServer.getClass().getMethod("getVersion").invoke(nmsServer);
            return Integer.parseInt(versionStr.split("\\.")[1]);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return 0;
    }

    public static LaserWeaponry instance;
    public static int version = getVersion();

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
