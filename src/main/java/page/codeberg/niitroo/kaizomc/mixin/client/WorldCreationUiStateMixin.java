package page.codeberg.niitroo.kaizomc.mixin.client;

import net.minecraft.client.gui.screens.worldselection.WorldCreationUiState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(WorldCreationUiState.class)
public abstract class WorldCreationUiStateMixin {
    /**
     * @author Niitroo
     * @reason Force Hardcore on world creation
     */
    @Overwrite
    public WorldCreationUiState.SelectedGameMode getGameMode() {
        return WorldCreationUiState.SelectedGameMode.HARDCORE;
    }
}
