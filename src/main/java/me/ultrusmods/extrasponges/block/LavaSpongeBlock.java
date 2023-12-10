package me.ultrusmods.extrasponges.block;

import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class LavaSpongeBlock extends Block {

    private final int range;
    private final int absorbAmount;
    private Block wetSponge;

    public LavaSpongeBlock(Settings settings, int range, int absorbAmount) {
        super(settings);
        this.range = range;
        this.absorbAmount = absorbAmount;
    }

    public void setWetSponge(Block wetSponge) {
        this.wetSponge = wetSponge;
    }
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (!oldState.isOf(state.getBlock())) {
            this.update(world, pos);
        }
    }

    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        this.update(world, pos);
        super.neighborUpdate(state, world, pos, block, fromPos, notify);
    }

    protected void update(World world, BlockPos pos) {
        if (this.absorbLava(world, pos)) {
            world.setBlockState(pos, wetSponge.getDefaultState(), 2);
            world.syncWorldEvent(2001, pos, Block.getRawIdFromState(Blocks.LAVA.getDefaultState()));
        }
    }

    private boolean absorbLava(World world, BlockPos pos) {
        return BlockPos.breadthFirstTraversal(pos, range, absorbAmount, (posx, consumer) -> {
            for (Direction direction : DIRECTIONS) {
                consumer.accept(posx.offset(direction));
            }
        }, (checkedPos) -> {
            if (checkedPos.equals(pos)) {
                return true;
            } else {
                BlockState blockState = world.getBlockState(checkedPos);
                FluidState fluidState = world.getFluidState(checkedPos);
                if (!fluidState.isIn(FluidTags.LAVA)) {
                    return false;
                } else {
                    Block block = blockState.getBlock();
                    if (block instanceof FluidDrainable fluidDrainable) {
                        if (!fluidDrainable.tryDrainFluid(null, world, checkedPos, blockState).isEmpty()) {
                            return true;
                        }
                    }
                    if (blockState.getBlock() instanceof FluidBlock) {
                        world.setBlockState(checkedPos, Blocks.AIR.getDefaultState(), 3);
                    } else {
                        return false;
                    }
                    return true;
                }
            }
        }) > 1;
    }
}