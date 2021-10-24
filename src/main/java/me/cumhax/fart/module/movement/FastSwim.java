package me.cumhax.fart.module.movement;

import me.cumhax.fart.module.Category;
import me.cumhax.fart.module.Module;
import me.cumhax.fart.setting.Setting;

public class FastSwim extends Module {
    private final Setting up = new Setting("FastSwimUp", this, true);
    private final Setting down = new Setting("FastSwimDown", this, true);
    private final Setting forward = new Setting("FastSwimForward", this, true);
    private final Setting sprint = new Setting("AutoSprintInLiquid", this, true);
    private final Setting only2b = new Setting("Only2b", this, true);
    int divider;

    public FastSwim()
    {
        super("FastSwim", "", Category.MOVEMENT);
        this.divider = 5;
        addSetting(up);
                addSetting(down);
                        addSetting(forward);
                                addSetting(sprint);
                                        addSetting(only2b);
    }

    @Override
    public void onUpdate() {
        if (this.only2b.getValue() && !FastSwim.mc.isSingleplayer() && mc.getCurrentServerData() != null && mc.getCurrentServerData().serverIP.equalsIgnoreCase("2b2t.org")) {
            if (this.sprint.getValue() && (FastSwim.mc.player.isInLava() || FastSwim.mc.player.isInWater())) {
                FastSwim.mc.player.setSprinting(true);
            }
            if ((FastSwim.mc.player.isInWater() || FastSwim.mc.player.isInLava()) && FastSwim.mc.gameSettings.keyBindJump.isKeyDown() && this.up.getValue()) {
                FastSwim.mc.player.motionY = 0.725 / this.divider;
            }
            if (FastSwim.mc.player.isInWater() || FastSwim.mc.player.isInLava()) {
                if ((this.forward.getValue() && FastSwim.mc.gameSettings.keyBindForward.isKeyDown()) || FastSwim.mc.gameSettings.keyBindLeft.isKeyDown() || FastSwim.mc.gameSettings.keyBindRight.isKeyDown() || FastSwim.mc.gameSettings.keyBindBack.isKeyDown()) {
                    FastSwim.mc.player.jumpMovementFactor = 0.34f / this.divider;
                }
                else {
                    FastSwim.mc.player.jumpMovementFactor = 0.0f;
                }
            }
            if (FastSwim.mc.player.isInWater() && this.down.getValue() && FastSwim.mc.gameSettings.keyBindSneak.isKeyDown()) {
                final int divider2 = this.divider * -1;
                FastSwim.mc.player.motionY = 2.2 / divider2;
            }
            if (FastSwim.mc.player.isInLava() && this.down.getValue() && FastSwim.mc.gameSettings.keyBindSneak.isKeyDown()) {
                final int divider2 = this.divider * -1;
                FastSwim.mc.player.motionY = 0.91 / divider2;
            }
        }
        if (!this.only2b.getValue()) {
            if (this.sprint.getValue() && (FastSwim.mc.player.isInLava() || FastSwim.mc.player.isInWater())) {
                FastSwim.mc.player.setSprinting(true);
            }
            if ((FastSwim.mc.player.isInWater() || FastSwim.mc.player.isInLava()) && FastSwim.mc.gameSettings.keyBindJump.isKeyDown() && this.up.getValue()) {
                FastSwim.mc.player.motionY = 0.725 / this.divider;
            }
            if (FastSwim.mc.player.isInWater() || FastSwim.mc.player.isInLava()) {
                if ((this.forward.getValue() && FastSwim.mc.gameSettings.keyBindForward.isKeyDown()) || FastSwim.mc.gameSettings.keyBindLeft.isKeyDown() || FastSwim.mc.gameSettings.keyBindRight.isKeyDown() || FastSwim.mc.gameSettings.keyBindBack.isKeyDown()) {
                    FastSwim.mc.player.jumpMovementFactor = 0.34f / this.divider;
                }
                else {
                    FastSwim.mc.player.jumpMovementFactor = 0.0f;
                }
            }
            if (FastSwim.mc.player.isInWater() && this.down.getValue() && FastSwim.mc.gameSettings.keyBindSneak.isKeyDown()) {
                final int divider2 = this.divider * -1;
                FastSwim.mc.player.motionY = 2.2 / divider2;
            }
            if (FastSwim.mc.player.isInLava() && this.down.getValue() && FastSwim.mc.gameSettings.keyBindSneak.isKeyDown()) {
                final int divider2 = this.divider * -1;
                FastSwim.mc.player.motionY = 0.91 / divider2;
            }
        }
    }
}