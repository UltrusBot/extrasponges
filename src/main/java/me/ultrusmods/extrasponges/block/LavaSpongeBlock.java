package me.ultrusmods.extrasponges.block;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BucketPickup;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;

public class LavaSpongeBlock extends Block {

    private final int range;
    private final int absorbAmount;
    private Block wetSponge;

    public LavaSpongeBlock(BlockBehaviour.Properties settings, int range, int absorbAmount) {
        super(settings);
        this.range = range;
        this.absorbAmount = absorbAmount;
    }

    public void setWetSponge(Block wetSponge) {
        this.wetSponge = wetSponge;
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean notify) {
        if (!oldState.is(state.getBlock())) {
            this.update(level, pos);
        }
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        this.update(level, pos);
        super.neighborChanged(state, level, pos, block, fromPos, notify);
    }


    protected void update(Level level, BlockPos pos) {
        if (this.absorbLava(level, pos)) {
            level.setBlock(pos, wetSponge.defaultBlockState(), 2);
            level.globalLevelEvent(2001, pos, Block.getId(Blocks.LAVA.defaultBlockState()));
        }
    }

    private boolean absorbLava(Level level, BlockPos pos) {
        return BlockPos.breadthFirstTraversal(pos, range, absorbAmount, (posx, consumer) -> {
            for (Direction direction : BlockBehaviour.UPDATE_SHAPE_ORDER) {
                consumer.accept(posx.relative(direction));
            }
        }, (checkedPos) -> {
            if (checkedPos.equals(pos)) {
                return true;
            } else {
                BlockState blockState = level.getBlockState(checkedPos);
                FluidState fluidState = level.getFluidState(checkedPos);
                if (!fluidState.is(FluidTags.LAVA)) {
                    return false;
                } else {
                    Block block = blockState.getBlock();
                    if (block instanceof BucketPickup bucketPickup) {
                        if (!bucketPickup.pickupBlock(null, level, checkedPos, blockState).isEmpty()) {
                            return true;
                        }
                    }
                    if (blockState.getBlock() instanceof LiquidBlock) {
                        level.setBlock(checkedPos, Blocks.AIR.defaultBlockState(), 3);
                    } else {
                        return false;
                    }
                    return true;
                }
            }
        }) > 1;
    }
}