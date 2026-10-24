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

public class JuniperFoliagePlacer extends FoliagePlacer {
    public static final Codec<JuniperFoliagePlacer> CODEC = RecordCodecBuilder.create((p_68427_) ->
            foliagePlacerParts(p_68427_).apply(p_68427_, JuniperFoliagePlacer::new));

    public JuniperFoliagePlacer(IntProvider p_161356_, IntProvider p_161357_) {
        super(p_161356_, p_161357_);
    }

    protected @NotNull FoliagePlacerType<?> type() {
        return NatureHorizonsFoliagePlacers.JUNIPER_FOLIAGE_PLACER.get();
    }

    protected void createFoliage(LevelSimulatedReader level, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration tree, int treeHeight, FoliageAttachment foliageAttachment, int foliageHeight, int leafRadisu, int offset) {
        BlockPos foliagePos = foliageAttachment.pos().above(offset);

        tryPlaceLeaf(level, foliageSetter, random, tree, foliagePos.above(1));
        placeCrossLeaves(foliagePos, level, foliageSetter, random, tree, 0);
        placeSquareLeaves(foliagePos, level, foliageSetter, random, tree, 1);
        placeSquareLeaves(foliagePos, level, foliageSetter, random, tree, 2);
        placeSquareLeaves(foliagePos, level, foliageSetter, random, tree, 3);
        placeCrossLeaves(foliagePos, level, foliageSetter, random, tree, 4);
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

    public int foliageHeight(RandomSource p_225516_, int p_225517_, TreeConfiguration p_225518_) {
        return 4;
    }

    protected boolean shouldSkipLocation(RandomSource p_225509_, int p_225510_, int p_225511_, int p_225512_, int p_225513_, boolean p_225514_) {
        return p_225510_ == p_225513_ && p_225512_ == p_225513_ && (p_225509_.nextInt(2) == 0 || p_225511_ == 0);
    }
}
