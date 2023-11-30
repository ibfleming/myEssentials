package me.ian.myessentials;

import lombok.Getter;
import me.ian.myessentials.commands.ButterflyCommand;
import me.ian.myessentials.commands.SpiralCommand;
import me.ian.myessentials.models.Scheduler;
import me.ian.myessentials.tasks.ButterflyTask;
import me.ian.myessentials.tasks.SpiralTask;
import me.ian.myessentials.utils.ConsoleColors;
import org.mineacademy.fo.plugin.SimplePlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class MyEssentials extends SimplePlugin {

    @Getter
    private static final Map<UUID, String> playerTags = new HashMap<>();

    private Scheduler.Task butterflyEffect;
    private Scheduler.Task spiralEffect;

    @Override
    protected void onPluginStart() {

        registerEvents(new BasicListeners());
        registerCommand(new ButterflyCommand());
        registerCommand(new SpiralCommand());

        getLogger().info(ConsoleColors.GREEN_BOLD + this.getName() + " enabled." + ConsoleColors.RESET);
        getLogger().info(ConsoleColors.WHITE_BOLD + "Loading modules..." + ConsoleColors.RESET);
        EconomyManager economyManager = new EconomyManager();
        getLogger().info(ConsoleColors.WHITE_BOLD + "Modules enabled." + ConsoleColors.RESET);

        butterflyEffect = Scheduler.runTimer(ButterflyTask.getInstance(), 0, 1);
        spiralEffect = Scheduler.runTimer(SpiralTask.getInstance(), 0, 1);
    }

    @Override
    protected void onReloadablesStart() {
        // You can check for necessary plugins and disable loading if they are missing
        //Valid.checkBoolean(HookManager.isVaultLoaded(), "You need to install Vault so that we can work with packets, offline player data, prefixes and groups.");

        // Uncomment to load variables
        // Variable.loadVariables();

        //
        // Add your own plugin parts to load automatically here
        // Please see @AutoRegister for parts you do not have to register manually
        //
    }

    @Override
    protected void onPluginPreReload() {
        // Close your database here if you use one
        // YourDatabase.getInstance().close();
    }

    @Override
    protected void onPluginStop() {
        // Plugin Stop/Close

        if( butterflyEffect != null ) {
            butterflyEffect.cancel();
        }
        if( spiralEffect != null ) {
            spiralEffect.cancel();
        }
    }

    public static MyEssentials getInstance() {
        return (MyEssentials) SimplePlugin.getInstance();
    }

}
