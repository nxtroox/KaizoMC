package io.github.nxtroox.kaizomc;

import io.github.nxtroox.kaizomc.loot.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KaizoMC implements ModInitializer {
	public static final String MOD_ID = "kaizomc";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello from KaizoMC!");

		LootTableEvents.REPLACE.register(ModLootTableModifiers::replaceLootTables);
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
