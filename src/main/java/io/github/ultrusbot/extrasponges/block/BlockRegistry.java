package io.github.ultrusbot.extrasponges.block;

import io.github.ultrusbot.extrasponges.ExtraSponges;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockRegistry {
    private static final String MOD_ID = ExtraSponges.MOD_ID;
    public static Block IRON_SPONGE = new ExtraSpongeBlock(FabricBlockSettings.copy(Blocks.SPONGE), 18, 128);
    public static Block GOLD_SPONGE = new ExtraSpongeBlock(FabricBlockSettings.copy(Blocks.SPONGE), 30, 192);
    public static Block DIAMOND_SPONGE = new ExtraSpongeBlock(FabricBlockSettings.copy(Blocks.SPONGE), 42, 256);
    public static Block NETHERITE_SPONGE = new ExtraSpongeBlock(FabricBlockSettings.copy(Blocks.SPONGE), 66, 384);
    public static Block WET_IRON_SPONGE = new ExtraWetSpongeBlock(FabricBlockSettings.copy(Blocks.SPONGE), IRON_SPONGE.getDefaultState());
    public static Block WET_GOLD_SPONGE = new ExtraWetSpongeBlock(FabricBlockSettings.copy(Blocks.SPONGE), GOLD_SPONGE.getDefaultState());
    public static Block WET_DIAMOND_SPONGE = new ExtraWetSpongeBlock(FabricBlockSettings.copy(Blocks.SPONGE), DIAMOND_SPONGE.getDefaultState());
    public static Block WET_NETHERITE_SPONGE = new ExtraWetSpongeBlock(FabricBlockSettings.copy(Blocks.SPONGE), NETHERITE_SPONGE.getDefaultState());

    public static Block LAVA_SPONGE = new LavaSpongeBlock(FabricBlockSettings.copy(Blocks.SPONGE), 6, 64);
    public static Block WET_LAVA_SPONGE = new WetLavaSpongeBlock(FabricBlockSettings.copy(Blocks.SPONGE), LAVA_SPONGE.getDefaultState());

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
        return Registry.register(Registry.BLOCK, new Identifier(MOD_ID, id), block);
    }

}
