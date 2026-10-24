package mrthomas20121.nature_horizons.worldgen.feature.trunkplacers;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.List;
import java.util.function.BiConsumer;

import mrthomas20121.nature_horizons.init.NatureHorizonsTrunkPlacers;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

public class MegaGiantTrunkPlacer extends TrunkPlacer {
    public static final Codec<MegaGiantTrunkPlacer> CODEC = RecordCodecBuilder.create((p_70189_) -> trunkPlacerParts(p_70189_).apply(p_70189_, MegaGiantTrunkPlacer::new));

    public MegaGiantTrunkPlacer(int p_70165_, int p_70166_, int p_70167_) {
        super(p_70165_, p_70166_, p_70167_);
    }

    protected TrunkPlacerType<?> type() {
        return NatureHorizonsTrunkPlacers.MEGA_GIANT_TRUNK_PLACER.get();
    }

    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> biConsumer, RandomSource random, int p_226126_, BlockPos blockPos, TreeConfiguration treeConfiguration) {
        BlockPos blockpos = blockPos.below();
        setDirtAt(level, biConsumer, random, blockpos, treeConfiguration);
        setDirtAt(level, biConsumer, random, blockpos.east(), treeConfiguration);
        setDirtAt(level, biConsumer, random, blockpos.south(), treeConfiguration);
        setDirtAt(level, biConsumer, random, blockpos.south().east(), treeConfiguration);
        setDirtAt(level, biConsumer, random, blockpos.west(), treeConfiguration);
        setDirtAt(level, biConsumer, random, blockpos.north(), treeConfiguration);
        setDirtAt(level, biConsumer, random, blockpos.north().south(), treeConfiguration);
        setDirtAt(level, biConsumer, random, blockpos.north().east(), treeConfiguration);
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for(int i = 0; i < p_226126_; ++i) {
            if (i < p_226126_ - 1) {
                place4by4Logs(i, level, biConsumer, random, blockPos, blockpos$mutableblockpos, treeConfiguration);
            }
        }

        return ImmutableList.of(new FoliagePlacer.FoliageAttachment(blockPos.above(p_226126_), 0, true));
    }

    private void place2by2Logs(int i , LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> biConsumer, RandomSource random, BlockPos blockPos, BlockPos.MutableBlockPos blockpos$mutableblockpos, TreeConfiguration treeConfiguration) {
        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, 0, i, 0);
        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, 0, i, 1);
        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, 1, i, 0);
        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, 1, i, 1);
    }

    private void place4by4Logs(int i , LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> biConsumer, RandomSource random, BlockPos blockPos, BlockPos.MutableBlockPos blockpos$mutableblockpos, TreeConfiguration treeConfiguration) {
        place2by2Logs(i, level, biConsumer, random, blockPos, blockpos$mutableblockpos, treeConfiguration);

        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, 2, i, 0);
        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, 2, i, 1);
        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, 1, i, 2);
        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, 0, i, 2);
        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, 2, i, 2);
        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, -1, i, -1);
        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, 0, i, -1);
        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, -1, i, 2);
        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, -1, i, 0);
        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, 1, i, -1);
        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, 2, i, -1);
        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, -1, i, 1);
    }

    private void place6by6Logs(int i , LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> biConsumer, RandomSource random, BlockPos blockPos, BlockPos.MutableBlockPos blockpos$mutableblockpos, TreeConfiguration treeConfiguration) {
        place2by2Logs(i, level, biConsumer, random, blockPos, blockpos$mutableblockpos, treeConfiguration);
        place4by4Logs(i, level, biConsumer, random, blockPos, blockpos$mutableblockpos, treeConfiguration);

        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, 3, i, 0);
        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, 3, i, 1);
        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, 3, i, 2);
        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, 3, i, 3);
        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, 3, i, -1);
        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, 3, i, -2);
        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, 3, i, 3);
        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, 0, i, 3);
        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, 0, i, -2);
        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, 1, i, -2);
        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, 2, i, -2);
        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, -2, i, -2);
        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, -2, i, 2);
        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, -2, i, 3);
        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, -2, i, -1);
        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, -1, i, 3);
        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, -1, i, -2);
        this.placeLogIfFreeWithOffset(level, biConsumer, random, blockpos$mutableblockpos, treeConfiguration, blockPos, 2, i, 3);
    }

    private void placeLogIfFreeWithOffset(LevelSimulatedReader p_226130_, BiConsumer<BlockPos, BlockState> p_226131_, RandomSource p_226132_, BlockPos.MutableBlockPos p_226133_, TreeConfiguration p_226134_, BlockPos p_226135_, int p_226136_, int p_226137_, int p_226138_) {
        p_226133_.setWithOffset(p_226135_, p_226136_, p_226137_, p_226138_);
        this.placeLogIfFree(p_226130_, p_226131_, p_226132_, p_226133_, p_226134_);
    }
}
