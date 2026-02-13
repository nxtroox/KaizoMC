package page.codeberg.niitroo.kaizomc.mixin;

import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Item.Settings.class)
public abstract class ItemMixin {
    @ModifyVariable(
            method = "maxDamage",
            at = @At("HEAD"),
            argsOnly = true
    )
    private int kaizomc$halveMaxDamage(int maxDamage) {
        return maxDamage / 2;
    }
}
