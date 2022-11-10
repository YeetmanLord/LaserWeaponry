package com.github.yeetmanlord.laserweaponry;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.inventory.EquipmentSlot;

public class DoomLaser extends LaserWeapon {
    public DoomLaser() {
        super(50F, "&6Doom &cLaser", Material.DIAMOND_SPADE, true, Effect.HAPPY_VILLAGER, 40D, EquipmentSlot.HAND, 100, "&cA mega laser that fires a massive blast", "&cWill kill almost anything!");
    }
}
