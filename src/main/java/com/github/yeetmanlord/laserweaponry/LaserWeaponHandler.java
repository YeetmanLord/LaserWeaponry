package com.github.yeetmanlord.laserweaponry;

import org.bukkit.entity.Player;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.HashMap;

public class LaserWeaponHandler {

    private Player owner;

    private HashMap<LaserWeapon, LocalDateTime> cooldowns;

    public LaserWeaponHandler(Player owner) {
        this.owner = owner;
        this.cooldowns = new HashMap<>();
    }

    public Player getPlayer() {
        return this.owner;
    }

    public void addCooldown(LaserWeapon weapon, int timeTicks) {
        int timeMillis = 50 * timeTicks;
        cooldowns.put(weapon, LocalDateTime.now().plus(timeMillis, ChronoUnit.MILLIS));
    }

    public boolean checkCooldown(LaserWeapon weapon) {
        LocalDateTime time = cooldowns.get(weapon);
        if (time == null) {
            return true;
        }
        return LocalDateTime.now().isAfter(time);
    }
}
