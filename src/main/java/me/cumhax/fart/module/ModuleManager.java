package me.cumhax.fart.module;

import me.cumhax.fart.Client;
import me.cumhax.fart.gui.hud.component.Watermark;
import me.cumhax.fart.module.combat.*;
import me.cumhax.fart.module.exploit.BoatPlaceBypass;
import me.cumhax.fart.module.exploit.PacketCanceller;
import me.cumhax.fart.module.exploit.PortalGodmode;
import me.cumhax.fart.module.misc.*;
import me.cumhax.fart.module.movement.*;
import me.cumhax.fart.module.render.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ModuleManager {
    private final ArrayList<Module> modules = new ArrayList();

    public ModuleManager() {
		
		//Combat
        this.modules.add(new Auto32K ());
        this.modules.add(new AutoArmor());
        this.modules.add(new KillAura());
        this.modules.add(new AutoTotem());
        this.modules.add(new AutoTrap());
        this.modules.add(new Criticals());
        this.modules.add(new HoleFiller());
        this.modules.add(new PearlAlert());
        this.modules.add(new PistonCrystal());
        this.modules.add(new Surround());
		
		//Exploit
        this.modules.add(new BoatPlaceBypass());
        this.modules.add(new PacketCanceller());
        this.modules.add(new PortalGodmode ());
		
		//Movement
        this.modules.add(new Anchor());
        this.modules.add(new AutoWalk ());
        this.modules.add(new BoatFly ());
        this.modules.add(new FastSwim());
        this.modules.add(new Jesus());
        this.modules.add(new LongJump ());
        this.modules.add(new NoSlow ());
        this.modules.add(new OldfagNoFall());
        this.modules.add(new Sprint());
        this.modules.add(new Step());
        this.modules.add(new Strafe());
        this.modules.add(new Velocity());

		//Render
        this.modules.add(new BlockHighlight());
        this.modules.add(new CustomFont());
        this.modules.add(new Fullbright ());
        this.modules.add(new HoleESP());
        this.modules.add(new ItemViewmodle());
        this.modules.add(new NoRender());
        this.modules.add(new PenisESP());
        this.modules.add(new VoidESP());

        //Misc
		this.modules.add(new AutoRonaldo());
        this.modules.add(new ChatStyle());
        this.modules.add(new ChatSuffix ());
        this.modules.add(new FakePlayer());
        this.modules.add(new FastUse());
        this.modules.add(new FootXP());
        this.modules.add(new GuiMove());
        this.modules.add(new MiddleClick());
		this.modules.add(new RPC());
        this.modules.add(new NoBedtrapMsg());

		//Client
        this.modules.add(new ClickGUI());
		this.modules.add(new HUDEditor("HUDEditor", Category.CLIENT));

		//Hud
        this.modules.add(new Watermark("Watermark", Category.HUD));
    }

    public static void onUpdate() {
        Client.moduleManager.getModules().stream().filter(Module::isEnabled).forEach(Module::onUpdate);
    }

    public ArrayList<Module> getModules() {
        return this.modules;
    }

    public Module getModule(String name) {
        for (Module module : this.modules) {
            if (!module.getName().equalsIgnoreCase(name)) continue;
            return module;
        }
        return null;
    }

    public ArrayList<Module> getModules(Category category) {
        ArrayList<Module> mods = new ArrayList<Module>();
        for (Module module : this.modules) {
            if (!module.getCategory().equals((Object)category)) continue;
            mods.add(module);
        }
        return mods;
    }

    public ArrayList<Module> getEnabledModules() {
        return this.modules.stream().filter(Module::isEnabled).collect(Collectors.toCollection(ArrayList::new));
    }
}
