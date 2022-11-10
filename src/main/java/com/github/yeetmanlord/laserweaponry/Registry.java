package com.github.yeetmanlord.laserweaponry;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class Registry {

    public static final HashMap<String, LaserWeapon> nameToWeapon = new HashMap<>();

    public static final HashMap<Player, LaserWeaponHandler> cooldownHandlers = new HashMap<>();

    public static final LaserWeapon LASER_EYES = register(new LaserEyes());

    public static final LaserWeapon LASER_GUN = register(new LaserGun());

    public static final LaserWeapon SUPER_LASER_GUN = register(new SuperLaserGun());

    public static final LaserWeapon DOOM_LASER = register(new DoomLaser());

    public static LaserWeapon register(LaserWeapon weapon) {
        nameToWeapon.put(ChatColor.translateAlternateColorCodes('&', weapon.name), weapon);
        return weapon;
    }

    public static LaserWeaponHandler getCooldownTracker(Player player) {
        if (cooldownHandlers.containsKey(player)) {
            return cooldownHandlers.get(player);
        }
        cooldownHandlers.put(player, new LaserWeaponHandler(player));
        return cooldownHandlers.get(player);
    }
}
