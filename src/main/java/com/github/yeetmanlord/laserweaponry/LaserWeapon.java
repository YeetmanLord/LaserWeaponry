package com.github.yeetmanlord.laserweaponry;

import com.github.yeetmanlord.raycast_util.RayCastUtility;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class LaserWeapon {

    public int durability;

    public final int maxDurability;

    public final float damage;

    public String name;

    public List<String> lore;

    private final Material weaponMaterial;

    public final boolean explodeBlocks;

    public final Effect effect;

    public final double maxDistance;

    public LaserWeapon(int durability, int maxDurability, float damage, String name, Material weaponMaterial, boolean explodeBlocks, Effect effect, double maxDistance, String... lore) {
        this.durability = durability;
        this.maxDurability = maxDurability;
        this.damage = damage;
        this.name = name;
        this.weaponMaterial = weaponMaterial;
        this.explodeBlocks = explodeBlocks;
        this.effect = effect;
        this.maxDistance = maxDistance;
    }

    public void activate(Player player) {
        RayCastUtility.executeStepByStep(player, maxDistance, true, 0.01D, );
    }

    public ItemStack getItem() {
        ItemStack stack = new ItemStack(weaponMaterial);
        ItemMeta meta = stack.getItemMeta();
        assert meta != null;
        meta.setDisplayName(name);
        List<String> finalLore = new ArrayList<>();
        for (String s : lore){
            finalLore.add(ChatColor.translateAlternateColorCodes('&', s));
        }

        finalLore.add("");
        finalLore.add(ChatColor.DARK_GRAY + "Durability: " + ChatColor.GREEN + this.durability + "/" + this.maxDurability);
        meta.setLore(finalLore);
        stack.setItemMeta(meta);

    }
}
