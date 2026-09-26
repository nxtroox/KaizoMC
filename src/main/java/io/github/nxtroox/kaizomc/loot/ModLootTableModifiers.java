package io.github.nxtroox.kaizomc.loot;

import net.fabricmc.fabric.api.loot.v3.LootTableSource;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.providers.number.ints.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.ints.UniformGenerator;

public class ModLootTableModifiers {
    public static LootTable replaceLootTables(ResourceKey<LootTable> key, LootTable original,
                                                       LootTableSource source, HolderLookup.Provider provider) {
        if (key.identifier().equals(Identifier.withDefaultNamespace("entities/evoker"))) {
            var pool = LootPool.lootPool()
                    .setRolls(Holder.direct(new ConstantValue(1)))
                    .when(LootItemKilledByPlayerCondition.killedByPlayer())
                    .add(LootItem.lootTableItem(Items.EMERALD))
                    .apply(SetItemCountFunction.setCount(
                            Holder.direct(new UniformGenerator(
                                    Holder.direct(new ConstantValue(1)),
                                    Holder.direct(new ConstantValue(1))
                            ))
                    ))
                    .build();

            return LootTable.lootTable().pool(pool).build();
        }

        return null;
    }
}