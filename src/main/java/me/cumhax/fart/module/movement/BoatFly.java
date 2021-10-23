package me.cumhax.fart.module.movement;

import me.cumhax.fart.module.Category;
import me.cumhax.fart.module.Module;
import me.cumhax.fart.setting.Setting;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.MathHelper;

public class BoatFly extends Module {

	Setting hSpeed = new Setting("Disconnect", this, 1, 5, 10);
	Setting vSpeed = new Setting("VSpeed", this, 1, 5, 10);

	public BoatFly() {
		super("BoatFly", "Allows Flight In Boats", Category.MOVEMENT);

		this.addSetting(hSpeed);
		this.addSetting(vSpeed);
	}

	@Override
	public void onUpdate() {
		if (mc.world == null || mc.player == null || !(mc.player.getRidingEntity() instanceof EntityBoat))
			return;

		double[] pos = { mc.player.getRidingEntity().prevPosX, mc.player.getRidingEntity().prevPosY,
				mc.player.getRidingEntity().prevPosZ };

		float player_speed = 0.2873f;
		float rotation_yaw = mc.player.getRidingEntity().rotationYaw;
		float move_forward = mc.player.movementInput.moveForward;
		float move_strafe = mc.player.movementInput.moveStrafe;
		if (mc.player.moveForward > 0) {
			pos[0] += ((move_forward * player_speed) * Math.cos(Math.toRadians((rotation_yaw + 90.0f)))
					+ (move_strafe * player_speed) * Math.sin(Math.toRadians((rotation_yaw + 90.0f)))) * hSpeed.value;
			pos[2] += ((move_forward * player_speed) * Math.sin(Math.toRadians((rotation_yaw + 90.0f)))
					- (move_strafe * player_speed) * Math.cos(Math.toRadians((rotation_yaw + 90.0f)))) * hSpeed.value;
		}

		double vert = 0;
		if (mc.player.movementInput.jump) {
			vert += 1d * vSpeed.value;
		} else if (mc.player.moveForward < 0.0f) {
			vert -= 1d * vSpeed.value;
		} else {
			mc.player.motionY = 0;
			mc.player.getRidingEntity().motionY = 0;
		}
		pos[1] += vert;

		mc.player.getRidingEntity().setPosition(pos[0], pos[1], pos[2]);
		mc.player.setPosition(pos[0], pos[1], pos[2]);
		final float yaw = YawRotationUtility();
		if (mc.player.movementInput.forwardKeyDown) {
			mc.player.getRidingEntity().motionX -= MathHelper.sin(yaw) * 0.017453292f * hSpeed.value;
			mc.player.getRidingEntity().motionZ += MathHelper.cos(yaw) * 0.017453292f * hSpeed.value;
			mc.player.motionX -= MathHelper.sin(yaw) * 0.017453292f * hSpeed.value;
			mc.player.motionZ += MathHelper.cos(yaw) * 0.017453292f * hSpeed.value;

			mc.player.connection
					.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY, mc.player.posZ, false));
		}
	}

	private float YawRotationUtility() {
		float rotationYaw = mc.player.getRidingEntity().rotationYaw;

		return rotationYaw * 0.017453292f;
	}
}
