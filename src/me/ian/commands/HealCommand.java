package me.ian.commands;

import me.ian.ConsoleColors;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if( !(sender instanceof Player p) ) {
            System.err.println(ConsoleColors.RED + "ERROR: 'heal' command must be executed by a player." + ConsoleColors.RESET);
            return false;
        }

        // heal - heals to full
        // heal <player> - heals the player to full

        if( args.length == 0 ) {
            p.setHealth(20.0);
            p.setFoodLevel(20);
        }

        if( args.length == 1 ) {
            for( Player player : Bukkit.getOnlinePlayers() ) {
                if( player.getDisplayName().equals(args[0]) ) {
                    player.setHealth(20.0);
                    player.setFoodLevel(20);
                }
            }
        }

        return true;
    }
}
