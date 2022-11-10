package com.github.yeetmanlord.laserweaponry;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;

public class LaserEyes extends LaserWeapon {
    public LaserEyes() {

        super(4F, "&cLaser Eyes", Material.CHAINMAIL_HELMET, true, "CRIT", 20D, EquipmentSlot.HEAD, 5, "&8Fires a laser beam when this is helmet is equipped.", "&8Sneak to fire when equipped.");
    }

    @Override
    public boolean shouldRun(Player player) {
        return super.shouldRun(player);
    }
}
