package me.cumhax.fart.command;

import me.cumhax.fart.Client;
import me.cumhax.fart.command.Command;
import me.cumhax.fart.util.LoggerUtil;

public class Prefix
extends Command {
    public Prefix(String name, String[] alias, String usage) {
        super(name, alias, usage);
    }

    @Override
    public void onTrigger(String arguments) {
        if (arguments.equals("")) {
            this.printUsage();
            return;
        }
        Client.commandManager.setPrefix(arguments);
        LoggerUtil.sendMessage("Prefix set to " + arguments);
    }
}
