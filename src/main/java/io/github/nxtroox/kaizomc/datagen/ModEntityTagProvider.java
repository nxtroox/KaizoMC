package io.github.nxtroox.kaizomc.datagen;


import io.github.nxtroox.kaizomc.tags.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;

import java.util.concurrent.CompletableFuture;

public class ModEntityTagProvider extends FabricTagsProvider.EntityTypeTagsProvider {
    public ModEntityTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        builder(ModTags.Entities.NEUTRAL)
                .add(key(EntityTypes.BEE))
                .add(key(EntityTypes.CAVE_SPIDER))
                .add(key(EntityTypes.DOLPHIN))
                .add(key(EntityTypes.DROWNED))
                .add(key(EntityTypes.ENDERMAN))
                .add(key(EntityTypes.FOX))
                .add(key(EntityTypes.GOAT))
                .add(key(EntityTypes.IRON_GOLEM))
                .add(key(EntityTypes.LLAMA))
                .add(key(EntityTypes.NAUTILUS))
                .add(key(EntityTypes.PANDA))
                .add(key(EntityTypes.PIGLIN))
                .add(key(EntityTypes.POLAR_BEAR))
                .add(key(EntityTypes.PUFFERFISH))
                .add(key(EntityTypes.SPIDER))
                .add(key(EntityTypes.TRADER_LLAMA))
                .add(key(EntityTypes.WOLF))
                .add(key(EntityTypes.ZOMBIE_NAUTILUS))
                .add(key(EntityTypes.ZOMBIFIED_PIGLIN));
    }

    private static ResourceKey<EntityType<?>> key(EntityType<?> type) {
        return BuiltInRegistries.ENTITY_TYPE.getResourceKey(type).orElseThrow();
    }
}
