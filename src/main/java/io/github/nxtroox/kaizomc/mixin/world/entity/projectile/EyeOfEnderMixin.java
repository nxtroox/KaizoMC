package io.github.nxtroox.kaizomc.mixin.world.entity.projectile;

import net.minecraft.world.entity.projectile.EyeOfEnder;
import net.minecraft.world.phys.Vec3;
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
    private void forceNoDrop(Vec3 target, CallbackInfo ci) {
        this.surviveAfterDeath = false;
    }
}
