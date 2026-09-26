package io.github.nxtroox.kaizomc.tags;

import io.github.nxtroox.kaizomc.KaizoMC;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class ModTags {
    public static class Entities {
        public static final TagKey<EntityType<?>> NEUTRAL = createTag("neutral");

        private static TagKey<EntityType<?>> createTag(String name) {
            return TagKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(KaizoMC.MOD_ID, name));
        }
    }
}
