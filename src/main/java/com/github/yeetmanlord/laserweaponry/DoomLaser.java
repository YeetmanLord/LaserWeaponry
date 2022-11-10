package com.github.yeetmanlord.laserweaponry;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.EquipmentSlot;

public class DoomLaser extends LaserWeapon {
    public DoomLaser() {
        super(50F, "&6Doom &cLaser", Material.valueOf("DIAMOND_SPADE"), true, LaserWeaponry.version < 13 ? "HAPPY_VILLAGER" : "VILLAGER_HAPPY", 40D, EquipmentSlot.HAND, 100, "&cA mega laser that fires a massive blast", "&cWill kill almost anything!");
    }
}
