package io.github.pkstdev.btamodlist.mixin;

import io.github.pkstdev.btamodlist.screen.ScreenModList;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiMainMenu;
import net.minecraft.src.GuiScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = GuiMainMenu.class, remap = false)
public class GuiMainMenuMixin extends GuiScreen {
    @Inject(method = "initGui", at = @At("RETURN"))
    public void onInitGui(CallbackInfo ci) {
        int i = this.height / 4 + 48;
        this.controlList.add(new GuiButton(9999, this.width / 2 - 100, i + 108, "Mods (" + FabricLoader.getInstance().getAllMods().size() + " Loaded)"));
    }

    @Inject(method = "actionPerformed", at = @At("RETURN"))
    public void onActionPerformed(GuiButton guiButton, CallbackInfo ci) {
        if (guiButton.id == 9999) {
            this.mc.displayGuiScreen(new ScreenModList(this));
        }
    }
}
