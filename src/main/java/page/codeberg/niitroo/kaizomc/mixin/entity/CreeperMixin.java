package page.codeberg.niitroo.kaizomc.mixin.entity;

import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.sounds.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Creeper.class)
public class CreeperMixin {
    @Shadow
    private int maxSwell = 1;

    @Redirect(
            method = "tick",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/monster/Creeper;playSound(Lnet/minecraft/sounds/SoundEvent;FF)V"
            )
    )
    private void disablePrimedSound(Creeper instance, net.minecraft.sounds.SoundEvent sound, float volume, float pitch) {
        if (sound == SoundEvents.CREEPER_PRIMED) {
            return;
        }

        instance.playSound(sound, volume, pitch);
    }
}