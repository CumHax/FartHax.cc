package me.cumhax.fart.module.combat;

import me.cumhax.fart.module.Category;
import me.cumhax.fart.module.Module;
import me.cumhax.fart.setting.Setting;
import me.cumhax.fart.setting.SettingType;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AutoLog extends Module
{
    private final Setting health = new Setting("Health", this, 10, 1, 30);

    public AutoLog() {
        super("AutoLog", "", Category.COMBAT);
        addSetting(health);
    }
    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event)
    {
        if (nullCheck()) return;

        if (mc.player.getHealth() <= health.getIntegerValue())
        {
            disable();
            mc.world.sendQuittingDisconnectingPacket();
            mc.loadWorld(null);
            mc.displayGuiScreen(new GuiMainMenu());
        }
    }
}