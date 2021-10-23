package me.cumhax.fart.gui.clickgui.button.settings;

import java.awt.Color;
import me.cumhax.fart.Client;
import me.cumhax.fart.gui.clickgui.button.SettingButton;
import me.cumhax.fart.module.Module;
import me.cumhax.fart.setting.Setting;
import me.cumhax.fart.setting.SettingManager;
import me.cumhax.fart.util.font.FontUtil;

public class BoolButton
extends SettingButton {
    private final Setting setting;

    public BoolButton(Module module, Setting setting, int X, int Y, int W, int H) {
        super(module, X, Y, W, H);
        this.setting = setting;
    }

    @Override
    public void render(int mX, int mY) {
        if (this.setting.getBooleanValue()) {
            this.drawButton(mX, mY);
            FontUtil.drawStringWithShadow(this.setting.getName(), this.getX() + 6, this.getY() + 4, new Color(255, 255, 255, 232).getRGB());
        } else {
            if (this.isHover(this.getX(), this.getY(), this.getW(), this.getH() - 1, mX, mY)) {
                Client.clickGUI.drawGradient(this.getX(), this.getY(), this.getX() + this.getW(), this.getY() + this.getH(), new Color(20, 20, 20, SettingManager.getSetting("ClickGUI", "backround alpha").getIntegerValue()).getRGB(), new Color(20, 20, 20, SettingManager.getSetting("ClickGUI", "backround alpha").getIntegerValue()).getRGB());
            } else {
                Client.clickGUI.drawGradient(this.getX(), this.getY(), this.getX() + this.getW(), this.getY() + this.getH(), new Color(20, 20, 20, SettingManager.getSetting("ClickGUI", "backround alpha").getIntegerValue()).getRGB(), new Color(20, 20, 20, SettingManager.getSetting("ClickGUI", "backround alpha").getIntegerValue()).getRGB());
            }
            FontUtil.drawString(this.setting.getName(), this.getX() + 6, this.getY() + 4, new Color(255, 255, 255, 232).getRGB());
        }
    }

    @Override
    public void mouseDown(int mX, int mY, int mB) {
        if (this.isHover(this.getX(), this.getY(), this.getW(), this.getH() - 1, mX, mY) && (mB == 0 || mB == 1)) {
            this.setting.setBooleanValue(!this.setting.getBooleanValue());
        }
    }
}
