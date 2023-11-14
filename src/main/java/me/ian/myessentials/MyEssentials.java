package me.ian.myessentials;

import org.mineacademy.fo.plugin.SimplePlugin;

public final class MyEssentials extends SimplePlugin {

    @Override
    protected void onPluginStart() {
        getLogger().info("Hello, World!");
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

    public static MyEssentials getInstance() {
        return (MyEssentials) SimplePlugin.getInstance();
    }

}
