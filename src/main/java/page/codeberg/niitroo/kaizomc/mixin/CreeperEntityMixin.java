package page.codeberg.niitroo.kaizomc.mixin;

import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.sound.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CreeperEntity.class)
public class CreeperEntityMixin {
    @Shadow
    private int fuseTime = 1;

    @Redirect(
            method = "tick",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/mob/CreeperEntity;playSound(Lnet/minecraft/sound/SoundEvent;FF)V"
            )
    )
    private void disablePrimedSound(CreeperEntity instance, net.minecraft.sound.SoundEvent sound, float volume, float pitch) {
        if (sound == SoundEvents.ENTITY_CREEPER_PRIMED) {
            return;
        }

        instance.playSound(sound, volume, pitch);
    }
}