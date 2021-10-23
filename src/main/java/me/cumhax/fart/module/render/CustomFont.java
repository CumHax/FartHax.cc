package me.cumhax.fart.module.render;

import me.cumhax.fart.module.Category;
import me.cumhax.fart.module.Module;
import me.cumhax.fart.setting.Setting;

public class CustomFont
extends Module {
    public final Setting fontsise = new Setting("Font Sise", this, 20, 14, 30);
    public final Setting yoffset = new Setting("Y-Offset", this, 0, -8, 8);

    public CustomFont() {
        super("CustomFont", "", Category.CLIENT);

        this.addSetting(this.fontsise);
        this.addSetting(this.yoffset);
    }

    @Override
    public void onUpdate() {
    }
}
