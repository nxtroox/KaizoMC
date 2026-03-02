package page.codeberg.niitroo.kaizomc.mixin.entity;

import net.minecraft.world.entity.projectile.EyeOfEnder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EyeOfEnder.class)
public class EyeOfEnderMixin {
    @Shadow
    private boolean surviveAfterDeath;

    @Inject(method = "signalTo(Lnet/minecraft/world/phys/Vec3;)V", at = @At("TAIL"))
    private void forceNoDrop(CallbackInfo ci) {
        this.surviveAfterDeath = false;
    }
}