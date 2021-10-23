package me.cumhax.fart.command;

import me.cumhax.fart.Client;
import me.cumhax.fart.command.Command;
import me.cumhax.fart.util.LoggerUtil;

public class Help
extends Command {
    public Help(String name, String[] alias, String usage) {
        super(name, alias, usage);
    }

    @Override
    public void onTrigger(String arguments) {
        LoggerUtil.sendMessage("ZenithCore");
        for (Command command : Client.commandManager.getCommands()) {
            LoggerUtil.sendMessage(command.getName() + " - " + command.getUsage());
        }
    }
}
