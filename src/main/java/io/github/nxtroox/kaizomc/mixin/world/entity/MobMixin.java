package io.github.nxtroox.kaizomc.mixin.world.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityReference;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.NeutralMob;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mob.class)
public class MobMixin {
    /**
     * @author nxtroox
     * @reason Make mobs not burn during the daytime
     */
    @Overwrite
    public boolean isSunBurnTick() {
        return false;
    }

    @Inject(method = "tick", at = @At("TAIL"))
    private void kaizomc$modifyNeutralData(CallbackInfo ci) {
        var mob = (Mob) (Object) this;

        if (!(mob.level() instanceof ServerLevel level)) return;
        if (!(mob instanceof NeutralMob)) return;

        var player = level.getNearestPlayer(mob, 32.0D);
        if (player != null && mob instanceof NeutralMob neutralMob) {
            neutralMob.setPersistentAngerTarget(EntityReference.of(player));
            neutralMob.startPersistentAngerTimer();
        }

        if (mob.getType() == EntityTypes.IRON_GOLEM && !mob.entityTags().contains("hp_set")) {
            mob.setHealth(200.0F);
            mob.addTag("hp_set");
        }
    }
}
