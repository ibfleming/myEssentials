package me.ian.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuListener implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {

        if( ChatColor.stripColor(e.getView().getTitle()).equalsIgnoreCase("Menu") ) {

            if( e.getCurrentItem() == null ) {
                return;
            }

            switch (e.getCurrentItem().getType()) {
                case LIGHT_BLUE_CONCRETE -> {}
                case LIME_CONCRETE -> {}
                case ORANGE_CONCRETE -> {}
                case RED_CONCRETE -> { e.getWhoClicked().closeInventory(); }
                default -> {
                }
            }


            if( e.getCurrentItem().getType() == Material.RED_CONCRETE ) {
                e.getWhoClicked().closeInventory();
            }
            // Players unable to move items in inventory.
            e.setCancelled(true);
        }
    }
}
