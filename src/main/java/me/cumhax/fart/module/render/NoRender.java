package me.cumhax.fart.module.render;

import me.cumhax.fart.module.Category;
import me.cumhax.fart.module.Module;
import me.cumhax.fart.setting.Setting;

import java.util.Arrays;

public class NoRender<INSTANCE> extends Module {
    public static NoRender INSTANCE;
    public static Setting fov;
    public static Setting hurtcam;
    public static Setting weather;
    public static Setting fog;
    public static Setting totems;

    private final Setting fire = new Setting("Fire", this,  false);
    private final Setting particles = new Setting("Particles", this,  false);
    private final Setting totems2 = new Setting("Totems", this,  false);
    private final Setting blocks = new Setting("Blocks", this,  false);
    private final Setting weather3 = new Setting("Weather", this,  false);
    private final Setting fog4 = new Setting("Fog", this,  false);
    private final Setting pumpkin = new Setting("Pumpkin", this,  false);
    private final Setting potions = new Setting("Potions", this,  false);
    private final Setting scoreboard = new Setting("Scoreboard", this,  false);
    private final Setting advancements = new Setting("Advancements", this,  false);
    private final Setting xp = new Setting("XP", this,  false);
    private final Setting portals = new Setting("Portals", this,  false);
    private final Setting armor = new Setting("Armor", this, Arrays.asList("None", "Glint", "Remove"));
    private final Setting bossbar = new Setting("Bossbar", this, Arrays.asList("None", "Remove", "Stack"));

    public NoRender()
    {
        super("NoRender", "", Category.RENDER);
        addSetting(fire);
                addSetting(particles);
                        addSetting(totems2);
                                addSetting(blocks);
                                        addSetting(weather3);
                                                addSetting(fog4);
                                                        addSetting(pumpkin);
                                                                addSetting(potions);
                                                                        addSetting(scoreboard);
                                                                                addSetting(advancements);
                                                                                        addSetting(xp);
                                                                                                addSetting(portals);
                                                                                                        addSetting(bossbar);
    }

    public boolean isOn () {
        return false;
    }
}
