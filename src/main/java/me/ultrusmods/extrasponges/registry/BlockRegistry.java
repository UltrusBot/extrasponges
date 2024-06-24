package me.ultrusmods.extrasponges.registry;

import me.ultrusmods.extrasponges.ExtraSponges;
import me.ultrusmods.extrasponges.block.ExtraSpongeBlock;
import me.ultrusmods.extrasponges.block.ExtraWetSpongeBlock;
import me.ultrusmods.extrasponges.block.LavaSpongeBlock;
import me.ultrusmods.extrasponges.block.WetLavaSpongeBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class BlockRegistry {
    private static final String MOD_ID = ExtraSponges.MOD_ID;
    public static Block IRON_SPONGE = new ExtraSpongeBlock(FabricBlockSettings.copyOf(Blocks.SPONGE), 18, 128);
    public static Block GOLD_SPONGE = new ExtraSpongeBlock(FabricBlockSettings.copyOf(Blocks.SPONGE), 30, 192);
    public static Block DIAMOND_SPONGE = new ExtraSpongeBlock(FabricBlockSettings.copyOf(Blocks.SPONGE), 42, 256);
    public static Block NETHERITE_SPONGE = new ExtraSpongeBlock(FabricBlockSettings.copyOf(Blocks.SPONGE), 66, 384);
    public static Block WET_IRON_SPONGE = new ExtraWetSpongeBlock(FabricBlockSettings.copyOf(Blocks.SPONGE), IRON_SPONGE.defaultBlockState());
    public static Block WET_GOLD_SPONGE = new ExtraWetSpongeBlock(FabricBlockSettings.copyOf(Blocks.SPONGE), GOLD_SPONGE.defaultBlockState());
    public static Block WET_DIAMOND_SPONGE = new ExtraWetSpongeBlock(FabricBlockSettings.copyOf(Blocks.SPONGE), DIAMOND_SPONGE.defaultBlockState());
    public static Block WET_NETHERITE_SPONGE = new ExtraWetSpongeBlock(FabricBlockSettings.copyOf(Blocks.SPONGE), NETHERITE_SPONGE.defaultBlockState());

    public static Block LAVA_SPONGE = new LavaSpongeBlock(FabricBlockSettings.copyOf(Blocks.SPONGE), 6, 64);
    public static Block WET_LAVA_SPONGE = new WetLavaSpongeBlock(FabricBlockSettings.copyOf(Blocks.SPONGE), LAVA_SPONGE.defaultBlockState());

    public static void register() {
        ((ExtraSpongeBlock)IRON_SPONGE).setWetSponge(WET_IRON_SPONGE);
        ((ExtraSpongeBlock)GOLD_SPONGE).setWetSponge(WET_GOLD_SPONGE);
        ((ExtraSpongeBlock)DIAMOND_SPONGE).setWetSponge(WET_DIAMOND_SPONGE);
        ((ExtraSpongeBlock)NETHERITE_SPONGE).setWetSponge(WET_NETHERITE_SPONGE);
        IRON_SPONGE = register("iron_sponge", IRON_SPONGE);
        GOLD_SPONGE = register("gold_sponge", GOLD_SPONGE);
        DIAMOND_SPONGE = register("diamond_sponge", DIAMOND_SPONGE);
        NETHERITE_SPONGE = register("netherite_sponge", NETHERITE_SPONGE);
        WET_IRON_SPONGE = register("wet_iron_sponge", WET_IRON_SPONGE);
        WET_GOLD_SPONGE = register("wet_gold_sponge", WET_GOLD_SPONGE);
        WET_DIAMOND_SPONGE = register("wet_diamond_sponge", WET_DIAMOND_SPONGE);
        WET_NETHERITE_SPONGE = register("wet_netherite_sponge", WET_NETHERITE_SPONGE);

        ((LavaSpongeBlock)LAVA_SPONGE).setWetSponge(WET_LAVA_SPONGE);
        LAVA_SPONGE = register("lava_sponge", LAVA_SPONGE);
        WET_LAVA_SPONGE = register("wet_lava_sponge", WET_LAVA_SPONGE);

    }
    private static Block register(String id, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, ExtraSponges.id(id), block);
    }

}
