package me.ultrusmods.extrasponges.register;

import me.ultrusmods.extrasponges.Constants;
import me.ultrusmods.extrasponges.block.ExtraSpongeBlock;
import me.ultrusmods.extrasponges.block.ExtraWetSpongeBlock;
import me.ultrusmods.extrasponges.block.LavaSpongeBlock;
import me.ultrusmods.extrasponges.block.WetLavaSpongeBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.BiConsumer;

public class BlockRegistry {
    public static Block IRON_SPONGE = new ExtraSpongeBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.SPONGE), 18, 128);
    public static Block GOLD_SPONGE = new ExtraSpongeBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.SPONGE), 30, 192);
    public static Block DIAMOND_SPONGE = new ExtraSpongeBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.SPONGE), 42, 256);
    public static Block NETHERITE_SPONGE = new ExtraSpongeBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.SPONGE), 66, 384);
    public static Block WET_IRON_SPONGE = new ExtraWetSpongeBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.SPONGE), IRON_SPONGE.defaultBlockState());
    public static Block WET_GOLD_SPONGE = new ExtraWetSpongeBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.SPONGE), GOLD_SPONGE.defaultBlockState());
    public static Block WET_DIAMOND_SPONGE = new ExtraWetSpongeBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.SPONGE), DIAMOND_SPONGE.defaultBlockState());
    public static Block WET_NETHERITE_SPONGE = new ExtraWetSpongeBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.SPONGE), NETHERITE_SPONGE.defaultBlockState());

    public static Block LAVA_SPONGE = new LavaSpongeBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.SPONGE), 6, 64);
    public static Block WET_LAVA_SPONGE = new WetLavaSpongeBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.SPONGE), LAVA_SPONGE.defaultBlockState());

    public static void register(BiConsumer<ResourceLocation, Block> registerFunction) {
        ((ExtraSpongeBlock)IRON_SPONGE).setWetSponge(WET_IRON_SPONGE);
        ((ExtraSpongeBlock)GOLD_SPONGE).setWetSponge(WET_GOLD_SPONGE);
        ((ExtraSpongeBlock)DIAMOND_SPONGE).setWetSponge(WET_DIAMOND_SPONGE);
        ((ExtraSpongeBlock)NETHERITE_SPONGE).setWetSponge(WET_NETHERITE_SPONGE);
        registerFunction.accept(Constants.id("iron_sponge"), IRON_SPONGE);
        registerFunction.accept(Constants.id("gold_sponge"), GOLD_SPONGE);
        registerFunction.accept(Constants.id("diamond_sponge"), DIAMOND_SPONGE);
        registerFunction.accept(Constants.id("netherite_sponge"), NETHERITE_SPONGE);
        registerFunction.accept(Constants.id("wet_iron_sponge"), WET_IRON_SPONGE);
        registerFunction.accept(Constants.id("wet_gold_sponge"), WET_GOLD_SPONGE);
        registerFunction.accept(Constants.id("wet_diamond_sponge"), WET_DIAMOND_SPONGE);
        registerFunction.accept(Constants.id("wet_netherite_sponge"), WET_NETHERITE_SPONGE);

        ((LavaSpongeBlock)LAVA_SPONGE).setWetSponge(WET_LAVA_SPONGE);
        registerFunction.accept(Constants.id("lava_sponge"), LAVA_SPONGE);
        registerFunction.accept(Constants.id("wet_lava_sponge"), WET_LAVA_SPONGE);

    }

}
