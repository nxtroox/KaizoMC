package page.codeberg.niitroo.kaizomc.mixin.client;

import net.minecraft.client.gui.screen.option.OptionsScreen;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.CyclingButtonWidget;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.text.Text;
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
            method = "createTopRightButton",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/world/ClientWorld$Properties;isHardcore()Z"
            )
    )
    private boolean redirectIsHardcore(ClientWorld.Properties instance) {
        return true;
    }

    @Shadow
    private CyclingButtonWidget<Difficulty> difficultyButton;

    @Inject(method = "createTopRightButton", at = @At("RETURN"))
    private void addTooltip(CallbackInfoReturnable<Widget> cir) {
        if (this.difficultyButton != null) {
            this.difficultyButton.setTooltip(Tooltip.of(Text.translatable("options.difficulty.hard.info")));
        }
    }
}
