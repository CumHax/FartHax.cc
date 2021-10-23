package me.cumhax.fart.command;

import me.cumhax.fart.Client;
import me.cumhax.fart.command.Command;
import me.cumhax.fart.util.LoggerUtil;
import me.cumhax.fart.util.font.CustomFontRenderer;
import me.cumhax.fart.util.font.FontUtil;

public class Font
extends Command {
    public Font(String name, String[] alias, String usage) {
        super(name, alias, usage);
    }

    @Override
    public void onTrigger(String arguments) {
        if (arguments.equals("")) {
            this.printUsage();
            return;
        }
        if (FontUtil.validateFont(arguments)) {
            try {
                Client.customFontRenderer = new CustomFontRenderer(new java.awt.Font(arguments, 0, 19), true, false);
                LoggerUtil.sendMessage("New font set to " + arguments);
            }
            catch (Exception e) {
                LoggerUtil.sendMessage("Failed to set font");
            }
        } else {
            LoggerUtil.sendMessage("Invalid font");
        }
    }
}
