package me.ultrusmods.extrasponges.register;

import me.ultrusmods.extrasponges.Constants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import java.util.function.BiConsumer;

public class ItemRegistry {
    public static Item IRON_SPONGE =  new BlockItem(BlockRegistry.IRON_SPONGE, new Item.Properties());
    public static Item GOLD_SPONGE =  new BlockItem(BlockRegistry.GOLD_SPONGE, new Item.Properties());
    public static Item DIAMOND_SPONGE =  new BlockItem(BlockRegistry.DIAMOND_SPONGE, new Item.Properties());
    public static Item NETHERITE_SPONGE =  new BlockItem(BlockRegistry.NETHERITE_SPONGE, new Item.Properties());
    public static Item WET_IRON_SPONGE =  new BlockItem(BlockRegistry.WET_IRON_SPONGE, new Item.Properties());
    public static Item WET_GOLD_SPONGE =  new BlockItem(BlockRegistry.WET_GOLD_SPONGE, new Item.Properties());
    public static Item WET_DIAMOND_SPONGE =  new BlockItem(BlockRegistry.WET_DIAMOND_SPONGE, new Item.Properties());
    public static Item WET_NETHERITE_SPONGE =  new BlockItem(BlockRegistry.WET_NETHERITE_SPONGE, new Item.Properties());
    public static Item LAVA_SPONGE =  new BlockItem(BlockRegistry.LAVA_SPONGE, new Item.Properties());
    public static Item WET_LAVA_SPONGE =  new BlockItem(BlockRegistry.WET_LAVA_SPONGE, new Item.Properties());

    public static void register(BiConsumer<ResourceLocation, Item> registerFunction) {
        registerFunction.accept(Constants.id("iron_sponge"), IRON_SPONGE);
        registerFunction.accept(Constants.id("gold_sponge"), GOLD_SPONGE);
        registerFunction.accept(Constants.id("diamond_sponge"), DIAMOND_SPONGE);
        registerFunction.accept(Constants.id("netherite_sponge"), NETHERITE_SPONGE);
        registerFunction.accept(Constants.id("wet_iron_sponge"), WET_IRON_SPONGE);
        registerFunction.accept(Constants.id("wet_gold_sponge"), WET_GOLD_SPONGE);
        registerFunction.accept(Constants.id("wet_diamond_sponge"), WET_DIAMOND_SPONGE);
        registerFunction.accept(Constants.id("wet_netherite_sponge"), WET_NETHERITE_SPONGE);
        registerFunction.accept(Constants.id("lava_sponge"), LAVA_SPONGE);
        registerFunction.accept(Constants.id("wet_lava_sponge"), WET_LAVA_SPONGE);
    }
}
