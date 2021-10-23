package  me.cumhax.fart.module.misc;

import me.cumhax.fart.Client;
import me.cumhax.fart.module.Category;
import me.cumhax.fart.module.Module;
import me.cumhax.fart.setting.Setting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemEnderPearl;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Mouse;

import java.util.ArrayList;
import java.util.Arrays;

public class MiddleClick extends Module
{
	private final Setting mode = new Setting("Mode", this, Arrays.asList("Friend", "Pearl", "Smart"));

	public MiddleClick()
	{
		super("MiddleClick", "", Category.MISC);

		addSetting(mode);
	}

	@SubscribeEvent
	public void onMiddleClick(InputEvent.MouseInputEvent event)
	{
		if (mc.player == null || mc.world == null) return;

		if (Mouse.getEventButtonState() && Mouse.getEventButton() == 2)
		{
			switch (mode.getEnumValue())
			{
				case "Friend":

					if (mc.objectMouseOver.entityHit instanceof EntityPlayer) clickFriend();
					break;

				case "Pearl":

					throwPearl();
					break;

				case "Smart":

					if (mc.objectMouseOver.entityHit instanceof EntityPlayer)
					{
						clickFriend();
					}
					else
					{
						throwPearl();
					}
					break;

				default:
					break;

			}
		}
	}

	private void clickFriend()
	{
		String name = mc.objectMouseOver.entityHit.getName();

		if (Client.friendManager.isFriend(name))
		{
			Client.friendManager.delFriend(name);
		}
		else
		{
			Client.friendManager.addFriend(name);
		}
	}

	private void throwPearl()
	{
		if (pearlSlot() != -1)
		{
			int slot = mc.player.inventory.currentItem;
			mc.player.inventory.currentItem = pearlSlot();
			mc.playerController.processRightClick(mc.player, mc.world, EnumHand.MAIN_HAND);
			mc.player.inventory.currentItem = slot;
		}
	}


	private int pearlSlot()
	{
		for (int i = 0; i < 9; i++)
		{
			if (mc.player.inventory.getStackInSlot(i).getItem() instanceof ItemEnderPearl)
			{
				return i;
			}
		}
		return -1;
	}
}
