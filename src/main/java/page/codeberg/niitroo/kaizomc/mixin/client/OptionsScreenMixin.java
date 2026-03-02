package page.codeberg.niitroo.kaizomc.mixin.client;

import net.minecraft.client.gui.screens.options.OptionsScreen;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.components.CycleButton;
import net.minecraft.client.gui.layouts.LayoutElement;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Difficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(OptionsScreen.class)
public class OptionsScreenMixin {
    @Redirect(
            method = "createOnlineButton",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/multiplayer/ClientLevel$ClientLevelData;isHardcore()Z"
            )
    )
    private boolean redirectIsHardcore(ClientLevel.ClientLevelData instance) {
        return true;
    }

    @Shadow
    private CycleButton<Difficulty> difficultyButton;

    @Inject(method = "createOnlineButton", at = @At("RETURN"))
    private void addTooltip(CallbackInfoReturnable<LayoutElement> cir) {
        if (this.difficultyButton != null) {
            this.difficultyButton.setTooltip(Tooltip.create(Component.translatable("options.difficulty.hard.info")));
        }
    }
}
