package io.github.nxtroox.kaizomc.mixin.world.entity.monster;

import net.minecraft.world.entity.monster.Enderman;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Enderman.class)
public class EndermanMixin {
    /**
     * @author nxtroox
     * @reason Make Endermen immune to water damage
     */
    @Overwrite
    public boolean isSensitiveToWater() {
        return false;
    }
}
