package me.ian.myessentials.commands;


import me.ian.myessentials.tasks.ButterflyTask;
import me.ian.myessentials.tasks.SpiralTask;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public final class SpiralCommand extends SimpleCommand {

    public SpiralCommand() {
        super("spiral");
    }

    @Override
    protected void onCommand() {
        Player player = (Player) sender;
        SpiralTask instance = SpiralTask.getInstance();

        if (instance.hasPlayer(player.getUniqueId())) {
            instance.removePlayer(player.getUniqueId());
            player.sendMessage("Removed particle effects!");

        } else {
            instance.addPlayer(player.getUniqueId());
            player.sendMessage("Added particle effects!");
        }
    }
}