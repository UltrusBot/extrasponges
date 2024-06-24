package me.ultrusmods.extrasponges;

import me.ultrusmods.extrasponges.registry.BlockRegistry;
import me.ultrusmods.extrasponges.registry.ItemRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ExtraSponges implements ModInitializer {
    public static final String MOD_ID = "extrasponges";
    public static final CreativeModeTab SPONGE_ITEMS = FabricItemGroup.builder()
            .title(Component.translatable("itemGroup.extrasponges.items"))
            .icon(() -> new ItemStack(Items.SPONGE))
            .displayItems((context, entries) -> {
                entries.accept(ItemRegistry.IRON_SPONGE);
                entries.accept(ItemRegistry.GOLD_SPONGE);
                entries.accept(ItemRegistry.DIAMOND_SPONGE);
                entries.accept(ItemRegistry.NETHERITE_SPONGE);
                entries.accept(ItemRegistry.WET_IRON_SPONGE);
                entries.accept(ItemRegistry.WET_GOLD_SPONGE);
                entries.accept(ItemRegistry.WET_DIAMOND_SPONGE);
                entries.accept(ItemRegistry.WET_NETHERITE_SPONGE);
                entries.accept(ItemRegistry.LAVA_SPONGE);
                entries.accept(ItemRegistry.WET_LAVA_SPONGE);
            })
            .build();

    public static ResourceLocation id(String id) {
        return new ResourceLocation(MOD_ID, id);
    }


    @Override
    public void onInitialize() {
        BlockRegistry.register();
        ItemRegistry.register();
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, id("sponge_items"), SPONGE_ITEMS);
    }
}
