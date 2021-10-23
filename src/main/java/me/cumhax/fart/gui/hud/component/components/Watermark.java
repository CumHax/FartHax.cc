package me.cumhax.fart.gui.hud.component.components;

import java.awt.Color;
import java.awt.Font;
import me.cumhax.fart.gui.hud.Component;
import me.cumhax.fart.util.font.FontUtil;
import me.cumhax.fart.util.fontrenderer.GlyphPage;
import me.cumhax.fart.util.fontrenderer.GlyphPageFontRenderer;

public class Watermark
extends Component {
    private GlyphPageFontRenderer renderer;

    public Watermark(String name) {
        super(name);
        char[] chars = new char[256];
        for (int i = 0; i < chars.length; ++i) {
            chars[i] = (char)i;
        }
        GlyphPage glyphPage = new GlyphPage(new Font("Comfortaa", 0, 40), true, true);
        this.renderer = new GlyphPageFontRenderer(glyphPage, glyphPage, glyphPage, glyphPage);
        this.setW(this.mc.fontRenderer.getStringWidth("FartHax-v0.2"));
        this.setH(this.mc.fontRenderer.FONT_HEIGHT);
        glyphPage.generateGlyphPage(chars);
        glyphPage.setupTexture();
    }

    @Override
    public void render() {
        this.renderer.drawString("FartHax-v0.2", this.getX(), this.getY(), -1, true);
        FontUtil.drawStringWithShadow("FartHax-v0.2", this.getX(), this.getY() + 140, new Color(255, 255, 255).getRGB());
    }
}
