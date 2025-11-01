package page.codeberg.niitroo.kaizomc.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class MobDoubleLifeMixin {
    @Unique
    private static final String MODIFIER_NAME = "kaizomc:double_health";

    @Inject(method = "<init>", at = @At("TAIL"))
    private void onConstructed(EntityType<LivingEntity> entityType, World world, CallbackInfo ci) {
        LivingEntity self = (LivingEntity)(Object)this;

        if (self instanceof PlayerEntity) return;

        EntityAttributeInstance inst = self.getAttributeInstance(EntityAttributes.MAX_HEALTH);
        if (inst == null) return;

        if (inst.getModifier(Identifier.of(MODIFIER_NAME)) != null) return;

        // Operation.ADD_MULTIPLIED_BASE with amount=1.0 => base * (1 + 1.0) = base * 2 => double max health
        EntityAttributeModifier mod = new EntityAttributeModifier(
                Identifier.of(MODIFIER_NAME),
                1.0,
                EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE
        );

        inst.addPersistentModifier(mod);

        try {
            self.setHealth((float)inst.getValue());
        } catch (Exception ignored) {}
    }
}
