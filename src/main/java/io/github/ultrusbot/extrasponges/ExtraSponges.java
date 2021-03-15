package io.github.ultrusbot.extrasponges;

import io.github.ultrusbot.extrasponges.block.BlockRegistry;
import io.github.ultrusbot.extrasponges.client.ItemRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ExtraSponges implements ModInitializer {
    public static final String MOD_ID = "extrasponges";
    public static final ItemGroup SPONGE_ITEMS = FabricItemGroupBuilder.build(
            new Identifier(MOD_ID, "items"),
            () -> new ItemStack(Blocks.SPONGE));

    @Override
    public void onInitialize() {
        BlockRegistry.register();
        ItemRegistry.register();
    }
}
