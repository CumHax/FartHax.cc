package me.cumhax.fart.module.misc;

import me.cumhax.fart.discord.*;
import me.cumhax.fart.module.Category;
import me.cumhax.fart.module.Module;

public class RPC extends Module {

	public RPC()
	{
		super("RPC", "", Category.MISC);
	}

    public static Discord discordRPC = new RPCBuilder("898880371901485058").withDetails("sNIGGERS?!?!").withState("").withLargeImageKey("lol").withLargeImageText("Ballin").build();

    @Override
    public void onEnable()
    {
        discordRPC.start();
    }

    @Override
    public void onDisable()
    {
        discordRPC.stop();
    }

}
