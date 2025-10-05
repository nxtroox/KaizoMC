package page.codeberg.niitroo.kaizomc.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        var blockRegistryWrapper = wrapperLookup.getOrThrow(RegistryKeys.BLOCK);
        blockRegistryWrapper.streamEntries().forEach(entry -> {
            Block block = entry.value();
            if (!(block == Blocks.AIR || block == Blocks.CAVE_AIR || block == Blocks.VOID_AIR)) {
                valueLookupBuilder(BlockTags.ENDERMAN_HOLDABLE).add(block);
            }
        });
    }
}