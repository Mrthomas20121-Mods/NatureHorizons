package mrthomas20121.nature_horizons.worldgen.feature.foliageplacers;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mrthomas20121.nature_horizons.init.NatureHorizonsFoliagePlacers;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import org.jetbrains.annotations.NotNull;

public class BlackWalnutFoliagePlacer extends FoliagePlacer {
    public static final Codec<BlackWalnutFoliagePlacer> CODEC = RecordCodecBuilder.create((p_68427_) ->
            foliagePlacerParts(p_68427_).apply(p_68427_, BlackWalnutFoliagePlacer::new));

    public BlackWalnutFoliagePlacer(IntProvider p_161356_, IntProvider p_161357_) {
        super(p_161356_, p_161357_);
    }

    protected @NotNull FoliagePlacerType<?> type() {
        return NatureHorizonsFoliagePlacers.BLACK_WALNUT_FOLIAGE_PLACER.get();
    }

    protected void createFoliage(LevelSimulatedReader level, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration tree, int treeHeight, FoliageAttachment foliageAttachment, int foliageHeight, int leafRadisu, int offset) {
        BlockPos foliagePos = foliageAttachment.pos().above(offset);

        placeCrossLeaves(foliagePos, level, foliageSetter, random, tree, 0);
        placeLargerCrossLeaves(foliagePos, level, foliageSetter, random, tree, 1);
        placeLargerCrossLeaves(foliagePos, level, foliageSetter, random, tree, 2);
        placeLargerCrossLeaves(foliagePos, level, foliageSetter, random, tree, 3);
        placeCrossLeaves(foliagePos, level, foliageSetter, random, tree, 4);
    }

    private void placeLargerCrossLeaves(BlockPos foliagePos, LevelSimulatedReader level, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration tree, int below) {
        BlockPos underPos = below == 0 ? foliagePos: foliagePos.below(below);
        BlockPos underPosEast = underPos.east(1);
        BlockPos underPosWest = underPos.west(1);
        BlockPos underPosNorth = underPos.north(1);
        BlockPos underPosSouth = underPos.south(1);
        BlockPos underPos2East = underPos.east(2);
        BlockPos underPos2West = underPos.west(2);
        BlockPos underPos2North = underPos.north(2);
        BlockPos underPos2South = underPos.south(2);
        tryPlaceLeaf(level, foliageSetter, random, tree, underPos);
        tryPlaceLeaf(level, foliageSetter, random, tree, underPosEast);
        tryPlaceLeaf(level, foliageSetter, random, tree, underPosWest);
        tryPlaceLeaf(level, foliageSetter, random, tree, underPosSouth);
        tryPlaceLeaf(level, foliageSetter, random, tree, underPosNorth);
        tryPlaceLeaf(level, foliageSetter, random, tree, underPosEast.north(1));
        tryPlaceLeaf(level, foliageSetter, random, tree, underPosWest.north(1));
        tryPlaceLeaf(level, foliageSetter, random, tree, underPosEast.south(1));
        tryPlaceLeaf(level, foliageSetter, random, tree, underPosWest.south(1));
        tryPlaceLeaf(level, foliageSetter, random, tree, underPos2East);
        tryPlaceLeaf(level, foliageSetter, random, tree, underPos2West);
        tryPlaceLeaf(level, foliageSetter, random, tree, underPos2North);
        tryPlaceLeaf(level, foliageSetter, random, tree, underPos2South);
    }

    private void placeCrossLeaves(BlockPos foliagePos, LevelSimulatedReader level, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration tree, int below) {
        BlockPos pos = below == 0 ? foliagePos: foliagePos.below(below);
        tryPlaceLeaf(level, foliageSetter, random, tree, pos);
        tryPlaceLeaf(level, foliageSetter, random, tree, pos.east(1));
        tryPlaceLeaf(level, foliageSetter, random, tree, pos.west(1));
        tryPlaceLeaf(level, foliageSetter, random, tree, pos.north(1));
        tryPlaceLeaf(level, foliageSetter, random, tree, pos.south(1));
    }

    private void placeSquareLeaves(BlockPos foliagePos, LevelSimulatedReader level, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration tree, int below) {
        BlockPos under2 = foliagePos.below(below);
        BlockPos under2east = under2.east(1);
        BlockPos under2west = under2.west(1);
        tryPlaceLeaf(level, foliageSetter, random, tree, under2);
        tryPlaceLeaf(level, foliageSetter, random, tree, under2east);
        tryPlaceLeaf(level, foliageSetter, random, tree, under2west);
        tryPlaceLeaf(level, foliageSetter, random, tree, under2east.north(1));
        tryPlaceLeaf(level, foliageSetter, random, tree, under2west.north(1));
        tryPlaceLeaf(level, foliageSetter, random, tree, under2east.south(1));
        tryPlaceLeaf(level, foliageSetter, random, tree, under2west.south(1));
        tryPlaceLeaf(level, foliageSetter, random, tree, under2.north(1));
        tryPlaceLeaf(level, foliageSetter, random, tree, under2.south(1));
    }

    private void placeLargerSquareLeaves(BlockPos foliagePos, LevelSimulatedReader level, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration tree, int below) {
        BlockPos underPos = foliagePos.below(below);
        BlockPos underPosEast = underPos.east(1);
        BlockPos underPosWest = underPos.west(1);
        BlockPos underPosNorth = underPos.north(1);
        BlockPos underPosSouth = underPos.south(1);
        BlockPos underPos2East = underPos.east(2);
        BlockPos underPos2West = underPos.west(2);
        BlockPos underPos2North = underPos.north(2);
        BlockPos underPos2South = underPos.south(2);
        tryPlaceLeaf(level, foliageSetter, random, tree, underPos);
        tryPlaceLeaf(level, foliageSetter, random, tree, underPosEast);
        tryPlaceLeaf(level, foliageSetter, random, tree, underPosWest);
        tryPlaceLeaf(level, foliageSetter, random, tree, underPosSouth);
        tryPlaceLeaf(level, foliageSetter, random, tree, underPosEast.north(1));
        tryPlaceLeaf(level, foliageSetter, random, tree, underPosWest.north(1));
        tryPlaceLeaf(level, foliageSetter, random, tree, underPosEast.south(1));
        tryPlaceLeaf(level, foliageSetter, random, tree, underPosWest.south(1));
        tryPlaceLeaf(level, foliageSetter, random, tree, underPos2East);
        tryPlaceLeaf(level, foliageSetter, random, tree, underPos2West);
        tryPlaceLeaf(level, foliageSetter, random, tree, underPos2North);
        tryPlaceLeaf(level, foliageSetter, random, tree, underPos2South);
        tryPlaceLeaf(level, foliageSetter, random, tree, underPos2East.north(1));
        tryPlaceLeaf(level, foliageSetter, random, tree, underPos2West.north(1));
        tryPlaceLeaf(level, foliageSetter, random, tree, underPos2East.south(1));
        tryPlaceLeaf(level, foliageSetter, random, tree, underPos2West.south(1));
        tryPlaceLeaf(level, foliageSetter, random, tree, underPos2North.east(1));
        tryPlaceLeaf(level, foliageSetter, random, tree, underPos2South.east(1));
        tryPlaceLeaf(level, foliageSetter, random, tree, underPos2North.west(1));
        tryPlaceLeaf(level, foliageSetter, random, tree, underPos2South.west(1));
    }

    public int foliageHeight(RandomSource p_225516_, int p_225517_, TreeConfiguration p_225518_) {
        return 6;
    }

    protected boolean shouldSkipLocation(RandomSource p_225509_, int p_225510_, int p_225511_, int p_225512_, int p_225513_, boolean p_225514_) {
        return p_225510_ == p_225513_ && p_225512_ == p_225513_ && (p_225509_.nextInt(2) == 0 || p_225511_ == 0);
    }
}
