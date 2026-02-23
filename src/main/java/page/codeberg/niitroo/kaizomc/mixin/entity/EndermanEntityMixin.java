package page.codeberg.niitroo.kaizomc.mixin.entity;

import net.minecraft.entity.mob.EndermanEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(EndermanEntity.class)
public class EndermanEntityMixin {
    /**
     * @author Niitroo
     * @reason Make Endermen immune to water damage
     */
    @Overwrite
    public boolean hurtByWater() {
        return false;
    }
}