package com.github.yeetmanlord.laserweaponry;

import com.github.yeetmanlord.raycast_util.RayCastUtility;
import com.github.yeetmanlord.raycast_util.ResultType;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LaserWeapon {

    public final float damage;

    public String name;

    public List<String> lore;

    private final Material weaponMaterial;

    public final boolean explodeBlocks;

    public final String particle;

    public final double maxDistance;

    public final EquipmentSlot slot;

    private final int cooldownTicks;

    public LaserWeapon(float damage, String name, Material weaponMaterial, boolean explodeBlocks, String particle, double maxDistance, EquipmentSlot slot, int cooldownTicks, String... lore) {
        this.damage = damage;
        this.name = name;
        this.weaponMaterial = weaponMaterial;
        this.explodeBlocks = explodeBlocks;
        this.particle = particle;
        this.maxDistance = maxDistance;
        this.slot = slot;
        this.cooldownTicks = cooldownTicks;
        this.lore = new ArrayList<>();
        this.lore.addAll(Arrays.asList(lore));
    }

    public void activate(Player player) {
        if (this.shouldRun(player)) {
            RayCastUtility.executeStepByStepWithPrecision(player, maxDistance, true, 0.5D, false, RayCastUtility.Precision.PRECISE_ENTITY, (loc) -> {
                ParticleUtility.spawnParticle(loc, this.particle, 0F, 0F, 0F, 0F, 1, 64);
            }, (rayCastResult) -> {
                if (rayCastResult.getType() == ResultType.BLOCK && explodeBlocks) {
                    Block b = (Block) rayCastResult.get();
                    b.getLocation().getWorld().createExplosion(b.getLocation(), damage / 2);
                } else if (rayCastResult.getType() == ResultType.ENTITY) {
                    Entity e = (Entity) rayCastResult.get();
                    if (e instanceof LivingEntity) {
                        ((LivingEntity)e).damage(damage, player);
                    } else {
                        e.remove();
                    }
                }
            });
            Registry.getCooldownTracker(player).addCooldown(this, this.cooldownTicks);
        }
    }

    public boolean shouldRun(Player player) {
        ItemStack stack = null;

        switch (slot) {
            case HEAD:
                stack = player.getInventory().getArmorContents()[3];
                break;
            case CHEST:
                stack = player.getInventory().getArmorContents()[2];
                break;
            case LEGS:
                stack = player.getInventory().getArmorContents()[1];
                break;
            case FEET:
                stack = player.getInventory().getArmorContents()[0];
                break;
            case HAND:
                stack = player.getInventory().getItem(player.getInventory().getHeldItemSlot());
                break;
        }

        return stack != null && stack.hasItemMeta() && stack.getItemMeta().hasDisplayName() && ChatColor.translateAlternateColorCodes('&', this.name).equalsIgnoreCase(stack.getItemMeta().getDisplayName());
    }

    public ItemStack getItem() {
        ItemStack stack = new ItemStack(weaponMaterial);
        ItemMeta meta = stack.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        List<String> finalLore = new ArrayList<>();
        for (String s : lore) {
            finalLore.add(ChatColor.translateAlternateColorCodes('&', s));
        }
        meta.setLore(finalLore);
        stack.setItemMeta(meta);
        return stack;
    }
}
