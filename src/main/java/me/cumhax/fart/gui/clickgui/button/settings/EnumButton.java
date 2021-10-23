package me.cumhax.fart.gui.clickgui.button.settings;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Color;
import me.cumhax.fart.gui.clickgui.button.SettingButton;
import me.cumhax.fart.module.Module;
import me.cumhax.fart.setting.Setting;
import me.cumhax.fart.util.font.FontUtil;

public class EnumButton
extends SettingButton {
    private final Setting setting;

    public EnumButton(Module module, Setting setting, int X, int Y, int W, int H) {
        super(module, X, Y, W, H);
        this.setting = setting;
    }

    @Override
    public void render(int mX, int mY) {
        this.drawButton(mX, mY);
        FontUtil.drawStringWithShadow(this.setting.getName(), this.getX() + 6, this.getY() + 4, new Color(255, 255, 255, 255).getRGB());
        FontUtil.drawStringWithShadow(ChatFormatting.GRAY + this.setting.getEnumValue(), this.getX() + this.getW() - 6 - FontUtil.getStringWidth(this.setting.getEnumValue()), this.getY() + 4, new Color(255, 255, 255, 255).getRGB());
    }

    @Override
    public void mouseDown(int mX, int mY, int mB) {
        block12: {
            block13: {
                if (!this.isHover(this.getX(), this.getY(), this.getW(), this.getH() - 1, mX, mY)) break block12;
                if (mB != 0) break block13;
                int i = 0;
                int enumIndex = 0;
                for (String enumName : this.setting.getEnumValues()) {
                    if (enumName.equals(this.setting.getEnumValue())) {
                        enumIndex = i;
                    }
                    ++i;
                }
                if (enumIndex == this.setting.getEnumValues().size() - 1) {
                    this.setting.setEnumValue(this.setting.getEnumValues().get(0));
                } else {
                    ++enumIndex;
                    i = 0;
                    for (String enumName : this.setting.getEnumValues()) {
                        if (i == enumIndex) {
                            this.setting.setEnumValue(enumName);
                        }
                        ++i;
                    }
                }
                break block12;
            }
            if (mB != 1) break block12;
            int i = 0;
            int enumIndex = 0;
            for (String enumName : this.setting.getEnumValues()) {
                if (enumName.equals(this.setting.getEnumValue())) {
                    enumIndex = i;
                }
                ++i;
            }
            if (enumIndex == 0) {
                this.setting.setEnumValue(this.setting.getEnumValues().get(this.setting.getEnumValues().size() - 1));
            } else {
                --enumIndex;
                i = 0;
                for (String enumName : this.setting.getEnumValues()) {
                    if (i == enumIndex) {
                        this.setting.setEnumValue(enumName);
                    }
                    ++i;
                }
            }
        }
    }
}
