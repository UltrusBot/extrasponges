package me.ultrusmods.extrasponges.register;

import me.ultrusmods.extrasponges.Constants;
import me.ultrusmods.extrasponges.platform.Services;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.function.BiConsumer;

public class CreativeTabRegistry {
    public static final CreativeModeTab EXTRA_SPONGES = Services.PLATFORM.getCreativeTab()
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

    public static void register(BiConsumer<ResourceLocation, CreativeModeTab> registerFunction) {
        registerFunction.accept(Constants.id("sponge_items"), EXTRA_SPONGES);
    }
}
