package me.cumhax.fart.gui.hud.component;

import me.cumhax.fart.module.Category;
import me.cumhax.fart.module.Module;
import me.cumhax.fart.setting.Setting;

public class Watermark
extends Module {
    public final Setting X_ = new Setting("X", this, 100, 0, 8000);
    public final Setting Y_ = new Setting("Y", this, 100, 0, 8000);

    public Watermark(String name, Category category) {
        super(name, category);
        this.addSetting(this.X_);
        this.addSetting(this.Y_);
    }
}
