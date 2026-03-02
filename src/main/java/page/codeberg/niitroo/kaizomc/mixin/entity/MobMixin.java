package page.codeberg.niitroo.kaizomc.mixin.entity;

import net.minecraft.world.entity.Mob;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Mob.class)
public class MobMixin {
    /**
     * @author Niitroo
     * @reason Make mobs not burn during the daytime
     */
    @Overwrite
    public boolean isSunBurnTick() {
        return false;
    }
}