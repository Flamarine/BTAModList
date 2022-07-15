package io.github.pkstdev.btamodlist.screen;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.client.Minecraft;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.GuiSlot;
import net.minecraft.src.Tessellator;

import java.util.ArrayList;
import java.util.Collection;

public class ScreenModListSlot extends GuiSlot {
    private final Collection<ModContainer> mods;
    private final ScreenModList parent;

    public ScreenModListSlot(ScreenModList modListScreen) {
        super(Minecraft.getMinecraft(), modListScreen.width, modListScreen.height, 32, modListScreen.height - 51, 36);
        this.mods = FabricLoader.getInstance().getAllMods();
        this.parent = modListScreen;
    }

    @Override
    public int getSize() {
        return mods.size();
    }

    @Override
    protected void elementClicked(int i, boolean b) {
    }

    @Override
    protected boolean isSelected(int i) {
        return false;
    }

    @Override
    protected void drawBackground() {
        this.parent.drawDefaultBackground();
    }

    @Override
    protected void drawSlot(int i, int j, int k, int l, Tessellator tessellator) {
        ModContainer mod = new ArrayList<>(mods).get(i);
        FontRenderer textRenderer = Minecraft.getMinecraft().fontRenderer;
        this.parent.drawString(textRenderer, mod.getMetadata().getName(), (this.parent.width - textRenderer.getStringWidth(mod.getMetadata().getName())) / 2, k + 1, 16777215);
        this.parent.drawString(textRenderer, mod.getMetadata().getDescription(), (this.parent.width - textRenderer.getStringWidth(mod.getMetadata().getDescription())) / 2, k + 12, 8421504);
    }
}
