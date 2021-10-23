package me.cumhax.fart.module.combat;

import me.cumhax.fart.util.LoggerUtil;
import me.cumhax.fart.module.Category;
import me.cumhax.fart.module.Module;
import me.cumhax.fart.util.ColorTextUtils;
import me.cumhax.fart.setting.Setting;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.input.Keyboard;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class PearlAlert extends Module {

    private final Setting watermark = new Setting("Watermark", this, true);
    private final Setting color = new Setting("Color", this, true);

    ConcurrentHashMap<UUID, Integer> uuidMap = new ConcurrentHashMap<>();

    public PearlAlert()
    {
        super("PearlAlert", "", Category.COMBAT);
        addSetting(watermark);
                addSetting(color);
    }


    @Override
    public void onEnable() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void onDisable() {
        MinecraftForge.EVENT_BUS.unregister(this);
    }

    @Override
    public void onUpdate() {
        for (Entity entity : mc.world.loadedEntityList) {
            if (entity instanceof EntityEnderPearl) {
                EntityPlayer closest = null;
                for (EntityPlayer p : mc.world.playerEntities) {
                    if (closest == null || entity.getDistance(p) < entity.getDistance(closest)) {
                        closest = p;
                    }
                }
                if (closest != null && closest.getDistance(entity) < 2 && !uuidMap.containsKey(entity.getUniqueID()) && !closest.getName().equalsIgnoreCase(mc.player.getName())) {
                    uuidMap.put(entity.getUniqueID(), 200);
                    if (watermark.getValue()) {
                        LoggerUtil.sendMessage(ColorTextUtils.getColor( String.valueOf ( color.getValue() ) ) + closest.getName() + " threw a pearl towards " + getTitle(entity.getHorizontalFacing().getName()) + "!");
                    } else {
                        LoggerUtil.sendMessage(ColorTextUtils.getColor( String.valueOf ( color.getValue() ) ) + closest.getName() + " threw a pearl towards " + getTitle(entity.getHorizontalFacing().getName()) + "!");
                    }
                }
            }
        }
        this.uuidMap.forEach((name, timeout) -> {
            if (timeout <= 0) {
                this.uuidMap.remove(name);
            }
            else {
                this.uuidMap.put(name, timeout - 1);
            }
        });
    }

    public String getTitle(String in) {
        if (in.equalsIgnoreCase("west")) {
            return "east";
        }
        else if (in.equalsIgnoreCase("east")) {
            return "west";
        } else {
            return in;
        }
    }
}
