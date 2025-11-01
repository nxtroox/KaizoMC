package page.codeberg.niitroo.kaizomc.mixin;

import net.minecraft.entity.EyeOfEnderEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EyeOfEnderEntity.class)
public class EyeOfEnderEntityMixin {
    @Shadow
    private boolean dropsItem;

    @Inject(method = "initTargetPos(Lnet/minecraft/util/math/Vec3d;)V", at = @At("TAIL"))
    private void forceNoDrop(CallbackInfo ci) {
        this.dropsItem = false;
    }
}