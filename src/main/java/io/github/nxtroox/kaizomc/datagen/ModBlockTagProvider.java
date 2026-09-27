package io.github.nxtroox.kaizomc.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        var blockRegistryWrapper = registries.lookupOrThrow(Registries.BLOCK);

        blockRegistryWrapper.listElements().forEach(entry -> {
            Block block = entry.value();
            if (!(block == Blocks.AIR || block == Blocks.CAVE_AIR || block == Blocks.VOID_AIR)) {
                builder(BlockTags.ENDERMAN_HOLDABLE).add(entry.key());
            }
        });
    }
}
