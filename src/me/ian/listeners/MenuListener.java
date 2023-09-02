package me.ian.listeners;

import me.ian.ConsoleColors;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;

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
                case BARRIER -> { e.getWhoClicked().closeInventory(); }
                default -> { break; }
            }
            // Players unable to move items in inventory.e.setCancelled(true);
            e.setCancelled(true);
        }
        else {
            if( e.getCurrentItem() != null ) {
                ItemMeta temp = e.getCurrentItem().getItemMeta();
                if( temp != null) {
                    if( ChatColor.stripColor(temp.getDisplayName()).equals("Open Menu") ) {
                        e.setCancelled(true);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlayerRightClick(PlayerInteractEvent e) {
        if( e.getAction() != null && (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK))) {
            ItemStack item = e.getItem();
            if( item != null && !(item.getType().equals(Material.AIR))) {
                if( ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("Open Menu") ) {
                    Bukkit.getServer().dispatchCommand(e.getPlayer(), "menu");
                }
            }
        }
    }

}
