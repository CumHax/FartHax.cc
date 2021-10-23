package me.cumhax.fart.module.movement;

import me.cumhax.fart.event.MoveEvent;
import me.cumhax.fart.module.Category;
import me.cumhax.fart.module.Module;
import me.cumhax.fart.setting.Setting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Arrays;

public class Step extends Module
{
	Setting mode = new Setting("Mode", (Module)this, Arrays.asList("Vanilla", "Normal"));
	Setting stepHeight = new Setting("Height", this, 2, 1, 4);
	
	public Step()
	{
		super("Step", "", Category.MOVEMENT);
		addSetting(mode);
		addSetting(stepHeight);
	}
	
	@SubscribeEvent
    public void onMove(MoveEvent event)
	{
		if(nullCheck()) return;
		mc.player.stepHeight = stepHeight.getIntegerValue();
    }
	
	public void onDisable() {
        mc.player.stepHeight = 0.5f;
    }
}
