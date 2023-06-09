package me.ultrusmods.extrasponges;

import me.ultrusmods.extrasponges.block.BlockRegistry;
import me.ultrusmods.extrasponges.client.ItemRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ExtraSponges implements ModInitializer {
    public static final String MOD_ID = "extrasponges";
    public static final ItemGroup SPONGE_ITEMS = FabricItemGroup.builder()
            .name(Text.translatable("itemGroup.extrasponges.items"))
            .icon(() -> new ItemStack(Items.SPONGE))
            .entries((context, entries) -> {
                entries.addItem(ItemRegistry.IRON_SPONGE);
                entries.addItem(ItemRegistry.GOLD_SPONGE);
                entries.addItem(ItemRegistry.DIAMOND_SPONGE);
                entries.addItem(ItemRegistry.NETHERITE_SPONGE);
                entries.addItem(ItemRegistry.WET_IRON_SPONGE);
                entries.addItem(ItemRegistry.WET_GOLD_SPONGE);
                entries.addItem(ItemRegistry.WET_DIAMOND_SPONGE);
                entries.addItem(ItemRegistry.WET_NETHERITE_SPONGE);
                entries.addItem(ItemRegistry.LAVA_SPONGE);
                entries.addItem(ItemRegistry.WET_LAVA_SPONGE);
            })
            .build();



    @Override
    public void onInitialize() {
        BlockRegistry.register();
        ItemRegistry.register();
        Registry.register(Registries.ITEM_GROUP, new Identifier(MOD_ID, "sponge_items"), SPONGE_ITEMS);
    }
}
