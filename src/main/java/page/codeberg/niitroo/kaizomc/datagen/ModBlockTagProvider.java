package page.codeberg.niitroo.kaizomc.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        var blockRegistryWrapper = wrapperLookup.lookupOrThrow(Registries.BLOCK);
        blockRegistryWrapper.listElements().forEach(entry -> {
            Block block = entry.value();
            if (!(block == Blocks.AIR || block == Blocks.CAVE_AIR || block == Blocks.VOID_AIR)) {
                valueLookupBuilder(BlockTags.ENDERMAN_HOLDABLE).add(block);
            }
        });
    }
}