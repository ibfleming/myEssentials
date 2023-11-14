package me.ian.myessentials.commands;

import me.ian.myessentials.menus.NexusMenu;
import org.mineacademy.fo.annotation.AutoRegister;
import org.mineacademy.fo.command.SimpleCommand;

import java.util.List;

// https://github.com/kangarko/PluginTemplate/blob/master/src/main/java/org/mineacademy/template/command/SampleCommand.java

@AutoRegister
public final class DebugCommand extends SimpleCommand {

    public DebugCommand() {
        super("ian");
        this.setDescription("My debug command");
        this.setPermission(null);
        this.setAutoHandleHelp(false);
    }

    @Override
    protected String[] getMultilineUsageMessage() {
        return new String[] {
                "A debug command that is used",
                "in my testing of the plugin."
        };
    }

    @Override
    protected void onCommand() {
        if( this.args.length != 0 ) {
            final String param = this.args[0].toLowerCase();
            if("nexus".equals(param)) {
                this.checkConsole();
                this.checkBoolean(this.args.length == 1, "Do not type anything after '/{label} nexus'!");
                NexusMenu.showTo(this.getPlayer());
            }
        }
    }

    @Override
    protected List<String> tabComplete() {

        // Automatically returns tab completion suggestions for each amount of command arguments
        // Player typed /sample and pressed tab, he is completing the first argument.
        if (this.args.length == 1) {
            return this.completeLastWord("nexus");
        }

        return NO_COMPLETE;
    }
}
