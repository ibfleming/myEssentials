package me.ian.commands;

import me.ian.ConsoleColors;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

/* -------------------------------------------------- */

public class MenuCommand implements CommandExecutor {

    @SuppressWarnings("DataFlowIssue")
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        /* ---------- Creating Inventory ---------- */
        if( sender instanceof Player ) {
            Player p = (Player) sender;
            Inventory inv = Bukkit.createInventory(p, 9, ChatColor.DARK_GREEN + "Test Menu");

            /* ---------- Adding Items to Inventory ---------- */

            // Button 1
            ItemStack button1 = new ItemStack(Material.LIGHT_BLUE_CONCRETE, 1);
            ItemMeta button1Meta = button1.getItemMeta();

            button1Meta.setDisplayName(ChatColor.GRAY + "" + ChatColor.ITALIC + "Button 1");
            ArrayList<String> button1Lore = new ArrayList<>();
            button1Lore.add(ChatColor.RESET + "" + ChatColor.WHITE + "Button 1 Info");

            button1Meta.setLore(button1Lore);
            button1.setItemMeta(button1Meta);
            inv.setItem(0, button1);

            // Button 2
            ItemStack button2 = new ItemStack(Material.LIME_CONCRETE, 1);
            ItemMeta button2Meta = button2.getItemMeta();

            button2Meta.setDisplayName(ChatColor.GRAY + "" + ChatColor.ITALIC + "Button 2");
            ArrayList<String> button2Lore = new ArrayList<>();
            button2Lore.add(ChatColor.RESET + "" + ChatColor.WHITE + "Button 2 Info");

            button2Meta.setLore(button2Lore);
            button2.setItemMeta(button2Meta);
            inv.setItem(1, button2);

            // Button 3
            ItemStack button3 = new ItemStack(Material.ORANGE_CONCRETE, 1);
            ItemMeta button3Meta = button3.getItemMeta();

            button3Meta.setDisplayName(ChatColor.GRAY + "" + ChatColor.ITALIC + "Button 3");
            ArrayList<String> button3Lore = new ArrayList<>();
            button3Lore.add(ChatColor.RESET + "" + ChatColor.WHITE + "Button 3 Info");

            button3Meta.setLore(button3Lore);
            button3.setItemMeta(button3Meta);
            inv.setItem(2, button3);

            // Button 4 (Exit)
            ItemStack buttonExit = new ItemStack(Material.BARRIER, 1);
            ItemMeta buttonExitMeta = buttonExit.getItemMeta();

            buttonExitMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Exit");
            ArrayList<String> buttonExitLore = new ArrayList<>();
            buttonExitLore.add(ChatColor.RESET + "" + ChatColor.WHITE + "Exit Info");

            buttonExitMeta.setLore(buttonExitLore);
            buttonExit.setItemMeta(buttonExitMeta);
            inv.setItem(8, buttonExit);
            /* -------------------------------------------------- */

            p.openInventory(inv);
        }
        else {
            System.err.println(ConsoleColors.RED + "ERROR: 'menu' command must be executed by a player." + ConsoleColors.RESET);
        }
        return true;
    }
}
