package me.cumhax.fart.module.movement;

import me.cumhax.fart.event.EventTarget;
import me.cumhax.fart.module.Category;
import me.cumhax.fart.module.Module;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class NoSlow extends Module {

    public NoSlow() {
        super("NoSlow", "", Category.MOVEMENT);
    }

    @SubscribeEvent
    public void onInput(InputUpdateEvent event) {
        if (mc.player.isHandActive() && !mc.player.isRiding()) {
            event.getMovementInput().moveStrafe *= 5;
            event.getMovementInput().moveForward *= 5;
        }
    }

    // Check MixinBlockSoulSand for soulsand slowdown nullification

}