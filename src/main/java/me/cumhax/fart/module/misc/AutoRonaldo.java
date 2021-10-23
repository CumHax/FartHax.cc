
package me.cumhax.fart.module.misc;

import me.cumhax.fart.module.Module;
import me.cumhax.fart.module.Category;
import me.cumhax.fart.util.LoggerUtil;
import net.minecraft.client.Minecraft;
import sun.audio.AudioPlayer;

public class AutoRonaldo extends Module
{
    private static Minecraft mc;

    public AutoRonaldo()
    {
        super("AutoRonaldo", "", Category.MISC);
    }
    
    @Override
    public void enable () {
        super.enable();
        LoggerUtil.sendMessage("SIUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
		toggle();
    }
}
