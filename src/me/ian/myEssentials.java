package me.ian;

import me.ian.commands.HealCommand;
import me.ian.commands.MenuCommand;
import me.ian.listeners.InteractionListener;
import me.ian.listeners.JoinLeaveListener;
import me.ian.listeners.MenuListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class myEssentials extends JavaPlugin implements Listener {

    public static JavaPlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;

        getCommand("menu").setExecutor(new MenuCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getServer().getPluginManager().registerEvents(new MenuListener(), plugin);
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(), plugin);
        getServer().getPluginManager().registerEvents(new InteractionListener(), plugin);

        System.out.println(ConsoleColors.GREEN + this.getName() + " enabled." + ConsoleColors.RESET);
    }

    @Override
    public void onDisable() {
        System.out.println(ConsoleColors.RED + this.getName() + " disabled." + ConsoleColors.RESET);
    }
}
