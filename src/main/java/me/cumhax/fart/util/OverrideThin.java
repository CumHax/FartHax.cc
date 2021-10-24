package me.cumhax.fart.util;

import me.cumhax.fart.event.EventRender;
import net.minecraft.entity.player.EntityPlayer;

public interface OverrideThin {
    void enable ();

    void render ( EventRender event );

    void esp ( EntityPlayer player, double x, double y, double z );

    String array_detail ();
}
