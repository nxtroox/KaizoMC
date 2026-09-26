package io.github.nxtroox.kaizomc;

import io.github.nxtroox.kaizomc.datagen.ModBlockTagProvider;
import io.github.nxtroox.kaizomc.datagen.ModEntityTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class KaizoMCDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModEntityTagProvider::new);
	}
}
