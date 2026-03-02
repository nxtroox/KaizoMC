package page.codeberg.niitroo.kaizomc.mixin.entity;

import net.minecraft.world.entity.monster.EnderMan;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(EnderMan.class)
public class EnderManMixin {
    /**
     * @author Niitroo
     * @reason Make Endermen immune to water damage
     */
    @Overwrite
    public boolean isSensitiveToWater() {
        return false;
    }
}