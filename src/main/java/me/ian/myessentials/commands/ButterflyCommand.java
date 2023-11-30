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
            player.sendMessage("You are no longer viewing butterfly wings!");

        } else {
            instance.addPlayer(player.getUniqueId());
            player.sendMessage("You are now viewing butterfly wings!");
        }
    }
}