package com.github.yeetmanlord.laserweaponry;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.inventory.EquipmentSlot;

public class LaserGun extends LaserWeapon {
    public LaserGun() {
        super(6F, "&cLaser Gun", Material.IRON_HOE, true, Effect.CRIT, 10D, EquipmentSlot.HAND, 60, "&8A normal laser gun that shoots a laser whenever you right click.");
    }
}
