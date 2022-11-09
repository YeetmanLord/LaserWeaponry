package com.github.yeetmanlord.laserweaponry;

import org.bukkit.plugin.java.JavaPlugin;

public final class LaserWeaponry extends JavaPlugin {

    public static LaserWeaponry instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {

    }
}
