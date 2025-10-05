package page.codeberg.niitroo.kaizomc.mixin;

import net.minecraft.entity.mob.MobEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(MobEntity.class)
public class MobNoBurnMixin {
    /**
     * @author Niitroo
     * @reason Make mobs not burn during daytime
     */
    @Overwrite
    public boolean isAffectedByDaylight() {
        return false;
    }
}