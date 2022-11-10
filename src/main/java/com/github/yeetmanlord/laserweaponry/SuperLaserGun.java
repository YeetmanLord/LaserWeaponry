package com.github.yeetmanlord.laserweaponry;

import org.bukkit.Material;
import org.bukkit.inventory.EquipmentSlot;

public class SuperLaserGun extends LaserWeapon {
    public SuperLaserGun() {
        super(16F, "&c&lSuper&c Laser Gun", Material.DIAMOND_HOE, true, LaserWeaponry.version < 13 ? "MAGIC_CRIT" : "CRIT_MAGIC", 30D, EquipmentSlot.HAND, 200, "&8A super laser gun that deals massive damage.", "&8Right click to attack");
    }
}
