package page.codeberg.niitroo.kaizomc.mixin.entity;

import net.minecraft.world.entity.monster.Blaze;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Blaze.class)
public class BlazeMixin {
    /**
     * @author Niitroo
     * @reason Make Blazes immune to water damage
     */
    @Overwrite
    public boolean isSensitiveToWater() {
        return false;
    }
}
