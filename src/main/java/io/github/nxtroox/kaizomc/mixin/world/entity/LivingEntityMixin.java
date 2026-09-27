package io.github.nxtroox.kaizomc.mixin.world.entity;

import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Unique
    private static final String MODIFIER_NAME = "kaizomc:double_health";

    @Inject(method = "<init>", at = @At("TAIL"))
    private void onConstructed(EntityType<LivingEntity> entityType, Level world, CallbackInfo ci) {
        LivingEntity self = (LivingEntity)(Object)this;

        if (self instanceof Player) return;

        AttributeInstance inst = self.getAttribute(Attributes.MAX_HEALTH);
        if (inst == null) return;

        if (inst.getModifier(Identifier.parse(MODIFIER_NAME)) != null) return;

        // Operation.ADD_MULTIPLIED_BASE with amount=1.0 => base * (1 + 1.0) = base * 2 => double max health
        AttributeModifier mod = new AttributeModifier(
                Identifier.parse(MODIFIER_NAME),
                1.0,
                AttributeModifier.Operation.ADD_MULTIPLIED_BASE
        );

        inst.addPermanentModifier(mod);

        try {
            self.setHealth((float)inst.getValue());
        } catch (Exception ignored) {}
    }
}
