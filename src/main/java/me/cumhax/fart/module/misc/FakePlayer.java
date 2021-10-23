package me.cumhax.fart.module.misc;

import me.cumhax.fart.module.Category;
import me.cumhax.fart.module.Module;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.entity.EntityOtherPlayerMP;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FakePlayer extends Module
{
	private final List<Integer> fakePlayerIdList = new ArrayList<>();

	public FakePlayer()
	{
		super("FakePlayer", "", Category.MISC);

	}

	@Override
	public void onEnable()
	{
		addFakePlayer();
	}

	@Override
	public void onDisable()
	{
		for (int id : fakePlayerIdList)
		{
			mc.world.removeEntityFromWorld(id);
		}
	}

	private void addFakePlayer()
	{
		GameProfile profile = new GameProfile(UUID.fromString("b75baa53-79e1-4e6b-bddc-7e48ee1f3b77"), "cumhax");
		EntityOtherPlayerMP fakePlayer = new EntityOtherPlayerMP(mc.world, profile);

		fakePlayer.copyLocationAndAnglesFrom(mc.player);
		fakePlayer.setHealth(mc.player.getHealth() + mc.player.getAbsorptionAmount());

		mc.world.addEntityToWorld(-69, fakePlayer);

		fakePlayerIdList.add(-69);
	}
}
