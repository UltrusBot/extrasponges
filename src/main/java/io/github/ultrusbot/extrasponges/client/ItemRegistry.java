package io.github.ultrusbot.extrasponges.client;

import io.github.ultrusbot.extrasponges.ExtraSponges;
import io.github.ultrusbot.extrasponges.block.BlockRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemRegistry {
    private static final String MOD_ID = ExtraSponges.MOD_ID;
    public static Item IRON_SPONGE;
    public static Item GOLD_SPONGE;
    public static Item DIAMOND_SPONGE;
    public static Item NETHERITE_SPONGE;
    public static Item WET_IRON_SPONGE;
    public static Item WET_GOLD_SPONGE;
    public static Item WET_DIAMOND_SPONGE;
    public static Item WET_NETHERITE_SPONGE;
    public static Item LAVA_SPONGE;
    public static Item WET_LAVA_SPONGE;

    public static void register() {

    }
    private static Item register(String id, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MOD_ID, id), item);
    }
    static {
        IRON_SPONGE = register("iron_sponge", new BlockItem(BlockRegistry.IRON_SPONGE, new FabricItemSettings()));
        GOLD_SPONGE = register("gold_sponge", new BlockItem(BlockRegistry.GOLD_SPONGE, new FabricItemSettings()));
        DIAMOND_SPONGE = register("diamond_sponge", new BlockItem(BlockRegistry.DIAMOND_SPONGE, new FabricItemSettings()));
        NETHERITE_SPONGE = register("netherite_sponge", new BlockItem(BlockRegistry.NETHERITE_SPONGE, new FabricItemSettings()));
        WET_IRON_SPONGE = register("wet_iron_sponge", new BlockItem(BlockRegistry.WET_IRON_SPONGE, new FabricItemSettings()));
        WET_GOLD_SPONGE = register("wet_gold_sponge", new BlockItem(BlockRegistry.WET_GOLD_SPONGE, new FabricItemSettings()));
        WET_DIAMOND_SPONGE = register("wet_diamond_sponge", new BlockItem(BlockRegistry.WET_DIAMOND_SPONGE, new FabricItemSettings()));
        WET_NETHERITE_SPONGE = register("wet_netherite_sponge", new BlockItem(BlockRegistry.WET_NETHERITE_SPONGE, new FabricItemSettings()));
        LAVA_SPONGE = register("lava_sponge", new BlockItem(BlockRegistry.LAVA_SPONGE, new FabricItemSettings()));
        WET_LAVA_SPONGE = register("wet_lava_sponge", new BlockItem(BlockRegistry.WET_LAVA_SPONGE, new FabricItemSettings()));
    }
}
