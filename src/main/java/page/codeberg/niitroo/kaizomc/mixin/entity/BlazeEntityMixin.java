package page.codeberg.niitroo.kaizomc.mixin.entity;

import net.minecraft.entity.mob.BlazeEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(BlazeEntity.class)
public class BlazeEntityMixin {
    /**
     * @author Niitroo
     * @reason Make Blazes immune to water damage
     */
    @Overwrite
    public boolean hurtByWater() {
        return false;
    }
}
