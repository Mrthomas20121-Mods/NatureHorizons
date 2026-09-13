package mrthomas20121.nature_horizons.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;

public class SandSaplingBlock extends SaplingBlock {

    public SandSaplingBlock(AbstractTreeGrower treeGrower, Properties properties) {
        super(treeGrower, properties);
    }

    protected boolean mayPlaceOn(BlockState blockState, BlockGetter p_51043_, BlockPos blockPos) {
        return blockState.is(BlockTags.SAND);
    }

    public boolean canSurvive(BlockState blockState, LevelReader level, BlockPos blockPos) {
        BlockPos blockpos = blockPos.below();
        if (blockState.getBlock() == this) //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
            return level.getBlockState(blockpos).canSustainPlant(level, blockpos, Direction.UP, this);
        return this.mayPlaceOn(level.getBlockState(blockpos), level, blockpos);
    }


}
