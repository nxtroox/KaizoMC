package page.codeberg.niitroo.kaizomc.mixin.item;

import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Item.Properties.class)
public abstract class ItemMixin {
    @ModifyVariable(
            method = "durability",
            at = @At("HEAD"),
            argsOnly = true
    )
    private int kaizomc$halveMaxDamage(int maxDamage) {
        return maxDamage / 2;
    }
}
