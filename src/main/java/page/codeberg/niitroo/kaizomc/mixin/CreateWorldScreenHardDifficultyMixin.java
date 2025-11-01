package page.codeberg.niitroo.kaizomc.mixin;

import net.minecraft.client.gui.screen.world.WorldCreator;
import net.minecraft.world.Difficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(WorldCreator.class)
public class CreateWorldScreenHardDifficultyMixin {
    @Shadow
    private Difficulty difficulty = Difficulty.HARD;

    /**
     * @author Niitroo
     * @reason Force hard difficulty on world creation
     */
    @Overwrite
    public void setDifficulty(Difficulty difficulty) {
        WorldCreator self = (WorldCreator)(Object)this;
        self.update();
    }
}
