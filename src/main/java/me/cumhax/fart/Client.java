package me.cumhax.fart;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Font;
import me.cumhax.fart.EventHandler;
import me.cumhax.fart.command.CommandManager;
import me.cumhax.fart.config.Config;
import me.cumhax.fart.event.EventManager;
import me.cumhax.fart.gui.clickgui.ClickGUI;
import me.cumhax.fart.gui.hud.HUDEditor;
import me.cumhax.fart.friend.FriendManager;
import me.cumhax.fart.module.ModuleManager;
import me.cumhax.fart.setting.SettingManager;
import me.cumhax.fart.util.font.CustomFontRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid="farthax", name="FartHax", version="0.2")
public class Client {
    public static final String name = "FartHax";
    public static final String version = "0.2";
    public static final String creator = "cumhax";
    public static ModuleManager moduleManager;
    public static SettingManager settingManager;
    public static CustomFontRenderer customFontRenderer;
    public static FriendManager friendManager;
    public static ClickGUI clickGUI;
    public static CommandManager commandManager;
    public static final EventManager EVENT_MANAGER;
    public static HUDEditor hudEditor;

    public static void SendMessage(String string) {
        if (Minecraft.getMinecraft().ingameGUI != null || Minecraft.getMinecraft().player == null) {
            Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new TextComponentString("\u00a77" + ChatFormatting.BLUE + "[FartHax]\u00a7f " + ChatFormatting.RESET + string));
        }
    }

    public static Object moduleManager () {
        return null;
    }

    @Mod.EventHandler
    public void initialize(FMLInitializationEvent event) {
        commandManager = new CommandManager();
        settingManager = new SettingManager();
        moduleManager = new ModuleManager();
        friendManager = new FriendManager();
        customFontRenderer = new CustomFontRenderer(new Font("Verdana", 0, SettingManager.getSetting("CustomFont", "Font Sise").getIntegerValue()), true, false);
        clickGUI = new ClickGUI();
        hudEditor = new HUDEditor();
        Config.loadConfig();
        Runtime.getRuntime().addShutdownHook(new Config());
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }

    static {
        EVENT_MANAGER = new EventManager();
    }
}
