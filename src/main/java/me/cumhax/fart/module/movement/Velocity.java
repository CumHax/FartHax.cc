package me.cumhax.fart.module.movement;

import me.cumhax.fart.event.PacketEvent;
import me.cumhax.fart.module.Category;
import me.cumhax.fart.module.Module;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.network.play.server.SPacketExplosion;
import team.stiff.pomelo.impl.annotated.handler.annotation.Listener;

public class Velocity extends Module {

    public Velocity() {
        super ( "Velocity", "", Category.MOVEMENT);
    }

    @Listener
    public void listener(PacketEvent.Receive event) {
        if (event.getPacket() instanceof SPacketEntityVelocity) {
            if (((SPacketEntityVelocity) event.getPacket()).getEntityID() == mc.player.getEntityId())
                event.setCanceled(true);
        }
        if (event.getPacket() instanceof SPacketExplosion)
            event.setCanceled(true);
    }
}
