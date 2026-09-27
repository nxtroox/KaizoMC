package io.github.nxtroox.kaizomc.mixin.world.entity.monster.warden;

import net.minecraft.world.entity.monster.warden.WardenSpawnTracker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(WardenSpawnTracker.class)
public class WardenSpawnTrackerMixin {
    @Shadow
    private int ticksSinceLastWarning;

    @Shadow
    private int warningLevel;

    @Shadow
    private int cooldownTicks;

    /**
     * @author nxtroox
     * @reason Make Warden spawn instantly and reduce reset countdown
     */
    @Overwrite
    public void reset() {
        this.ticksSinceLastWarning = 0;
        this.warningLevel = 4;
        this.cooldownTicks = 0;
    }
}
