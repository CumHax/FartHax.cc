package me.cumhax.fart.module.render;

import me.cumhax.fart.Client;
import me.cumhax.fart.module.Category;
import me.cumhax.fart.module.Module;

public class HUDEditor
extends Module {
    public HUDEditor(String name, Category category) {
        super(name, category);
    }

    @Override
    public void onEnable() {
        mc.displayGuiScreen(Client.hudEditor);
    }
}
