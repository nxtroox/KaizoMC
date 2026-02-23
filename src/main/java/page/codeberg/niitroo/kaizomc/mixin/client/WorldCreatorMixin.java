package page.codeberg.niitroo.kaizomc.mixin.client;

import net.minecraft.client.gui.screen.world.WorldCreator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(WorldCreator.class)
public abstract class WorldCreatorMixin {
    /**
     * @author Niitroo
     * @reason Force Hardcore on world creation
     */
    @Overwrite
    public WorldCreator.Mode getGameMode() {
        return WorldCreator.Mode.HARDCORE;
    }
}
