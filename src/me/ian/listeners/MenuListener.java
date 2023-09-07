package me.ian.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCreativeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MenuListener implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {
        if( ChatColor.stripColor(e.getView().getTitle()).equalsIgnoreCase("Test Menu") ) {

            if( e.getCurrentItem() == null ) {
                return;
            }

            switch (e.getCurrentItem().getType()) {
                case LIGHT_BLUE_CONCRETE -> {}
                case LIME_CONCRETE -> {}
                case ORANGE_CONCRETE -> {}
                case BARRIER -> { e.getWhoClicked().closeInventory(); }
                default -> { break; }
            }
            // Players unable to move items in inventory.e.setCancelled(true);
            e.setCancelled(true);
        }
    }
}
