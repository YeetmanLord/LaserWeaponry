package com.github.yeetmanlord.laserweaponry;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.inventory.EquipmentSlot;

public class LaserEyes extends LaserWeapon {
    public LaserEyes() {
        super(4F, "&cLaser Eyes", Material.CHAINMAIL_HELMET, true, Effect.CRIT, 20D, EquipmentSlot.HEAD, 20, "&8Fires a laser beam when this is helmet is equipped.", "&8Right click to fire when equipped.");
    }

}
