package me.ian.myessentials.commands;


import me.ian.myessentials.tasks.ButterflyTask;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public final class ButterflyCommand extends SimpleCommand {

    public ButterflyCommand() {
        super("butterfly");
    }

    @Override
    protected void onCommand() {
        Player player = (Player) sender;
        ButterflyTask instance = ButterflyTask.getInstance();

        if (instance.hasPlayer(player.getUniqueId())) {
            instance.removePlayer(player.getUniqueId());
            player.sendMessage("Removed particle effects!");

        } else {
            instance.addPlayer(player.getUniqueId());
            player.sendMessage("Added particle effects!");
        }
    }
}