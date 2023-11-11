package me.ian.builder;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ItemBuilder {
    private final ItemStack item;
    private final ItemMeta  meta;

    // Constructors

    public ItemBuilder() {
        item = new ItemStack(Material.AIR);
        meta = item.getItemMeta();
    }

    public ItemBuilder(final Material type) {
        item = new ItemStack(type);
        meta = item.getItemMeta();
    }

    public ItemBuilder(final ItemStack item) {
        this.item = item;
        meta = item.getItemMeta();
    }

    // Functions

    public ItemBuilder type(final Material type) {
        item.setType(type);
        return this;
    }

    public ItemBuilder amount(final int n) {
        item.setAmount(n);
        return this;
    }

    @Deprecated
    public ItemBuilder durability(final int n) {
        item.setDurability((short) n);
        return this;
    }

    public ItemBuilder name(final String name) {
        meta().setDisplayName(name);
        apply();
        return this;
    }

    public ItemBuilder lore(final String lore) {
        List<String> lores = meta().getLore();
        if( lores == null ) {
            lores = new ArrayList<>();
        }
        lores.add(lore);
        meta().setLore(lores);
        apply();
        return this;
    }

    public ItemBuilder lores(final String[] lores) {
        List<String> loresList = meta().getLore();
        if( loresList == null ) {
            loresList = new ArrayList<>();
        } else {
            loresList.clear();
        }
        Collections.addAll(loresList, lores);
        meta().setLore(loresList);
        apply();
        return this;
    }

    // Extension functions

    private ItemMeta meta() {
        return meta;
    }

    public ItemStack create() {
        return item;
    }

    private void apply() {
        item.setItemMeta(meta);
    }
}
