package me.ian.listeners;

import me.ian.myEssentials;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class JoinLeaveListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        ItemStack menu_item = createItemMenu();
        Player player = e.getPlayer();
        if( player.getGameMode() == GameMode.SURVIVAL ) {
            Inventory inv = player.getInventory();
            inv.clear();
            inv.setItem(0, menu_item);
        }
        e.setJoinMessage(ChatColor.GREEN + player.getName() + " has joined...");
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {

    }

    public ItemStack createItemMenu() {
        ItemStack menu = new ItemStack(Material.BOOK);
        ItemMeta menuMeta = menu.getItemMeta();
        menuMeta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Open Menu");
        ArrayList<String> menuLore = new ArrayList<>();
        menuLore.add(ChatColor.GRAY + "Right-click this");
        menuLore.add(ChatColor.GRAY + "to open the menu.");
        menuMeta.setLore(menuLore);
        menu.setItemMeta(menuMeta);
        return menu;
    }
}


