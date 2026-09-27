package io.github.nxtroox.kaizomc.mixin.world.item;

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
    private int kaizomc$halveDamage(int maxDamage) {
        return maxDamage / 2;
    }
}
