package page.codeberg.niitroo.kaizomc.mixin;

import net.minecraft.block.entity.SculkShriekerWarningManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(SculkShriekerWarningManager.class)
public class InstantWardenSpawnMixin {
    @Shadow
    private int ticksSinceLastWarning;

    @Shadow
    private int warningLevel;

    @Shadow
    private int cooldownTicks;

    /**
     * @author Niitroo
     * @reason Make warden spawn instantly and reduce reset countdown
     */
    @Overwrite
    public void reset() {
        this.ticksSinceLastWarning = 0;
        this.warningLevel = 4;
        this.cooldownTicks = 0;
    }
}
