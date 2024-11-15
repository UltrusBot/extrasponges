package me.ultrusmods.extrasponges.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ExtraSpongesDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        var pack = fabricDataGenerator.createPack();
        var doModRecipes = System.getProperty("doModRecipes") != null;
        if (doModRecipes) {
            pack.addProvider(ExtraSpongesModRecipeGeneratorFabric::new);
        } else {
            pack.addProvider(ExtraSpongesModelGenerator::new);
            pack.addProvider(ExtraSpongesLootGenerator::new);
            pack.addProvider(ExtraSpongesRecipeGenerator::new);
        }
    }
}
