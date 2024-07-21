package me.ultrusmods.extrasponges;

import me.ultrusmods.extrasponges.register.BlockRegistry;
import me.ultrusmods.extrasponges.register.CreativeTabRegistry;
import me.ultrusmods.extrasponges.register.ItemRegistry;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

public class ExtraSpongesFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        
        ExtraSpongesCommon.init();
        BlockRegistry.register(((resourceLocation, block) -> Registry.register(BuiltInRegistries.BLOCK, resourceLocation, block)));
        ItemRegistry.register(((resourceLocation, item) -> Registry.register(BuiltInRegistries.ITEM, resourceLocation, item)));
        CreativeTabRegistry.register(((resourceLocation, creativeModeTab) -> Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, resourceLocation, creativeModeTab)));
    }
}
