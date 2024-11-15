package me.ultrusmods.extrasponges.data;

import me.ultrusmods.extrasponges.register.BlockRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ExtraSpongesLootGenerator extends FabricBlockLootTableProvider {


    protected ExtraSpongesLootGenerator(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        this.dropSelf(BlockRegistry.IRON_SPONGE);
        this.dropSelf(BlockRegistry.GOLD_SPONGE);
        this.dropSelf(BlockRegistry.DIAMOND_SPONGE);
        this.dropSelf(BlockRegistry.NETHERITE_SPONGE);
        this.dropSelf(BlockRegistry.WET_IRON_SPONGE);
        this.dropSelf(BlockRegistry.WET_GOLD_SPONGE);
        this.dropSelf(BlockRegistry.WET_DIAMOND_SPONGE);
        this.dropSelf(BlockRegistry.WET_NETHERITE_SPONGE);
        this.dropSelf(BlockRegistry.LAVA_SPONGE);
        this.dropSelf(BlockRegistry.WET_LAVA_SPONGE);

        // Modded Material Sponges
        this.dropSelf(BlockRegistry.TIN_SPONGE);
        this.dropSelf(BlockRegistry.WET_TIN_SPONGE);

        this.dropSelf(BlockRegistry.STEEL_SPONGE);
        this.dropSelf(BlockRegistry.WET_STEEL_SPONGE);

        this.dropSelf(BlockRegistry.LEAD_SPONGE);
        this.dropSelf(BlockRegistry.WET_LEAD_SPONGE);
    }


}
