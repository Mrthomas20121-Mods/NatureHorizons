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

public class TallAspenFoliagePlacer extends FoliagePlacer {
    public static final Codec<TallAspenFoliagePlacer> CODEC = RecordCodecBuilder.create((p_68427_) ->
            foliagePlacerParts(p_68427_).apply(p_68427_, TallAspenFoliagePlacer::new));

    public TallAspenFoliagePlacer(IntProvider p_161356_, IntProvider p_161357_) {
        super(p_161356_, p_161357_);
    }

    protected @NotNull FoliagePlacerType<?> type() {
        return NatureHorizonsFoliagePlacers.TALL_ASPEN_FOLIAGE_PLACER.get();
    }

    protected void createFoliage(LevelSimulatedReader level, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration tree, int treeHeight, FoliageAttachment foliageAttachment, int foliageHeight, int leafRadisu, int offset) {
        BlockPos foliagePos = foliageAttachment.pos().above(offset);

        above(foliagePos, level, foliageSetter, random, tree, 0);
        above(foliagePos, level, foliageSetter, random, tree, 1);

        tryPlaceLeaf(level, foliageSetter, random, tree, foliagePos.above(2));
        tryPlaceLeaf(level, foliageSetter, random, tree, foliagePos.above(3));

        under(foliagePos, level, foliageSetter, random, tree, 1);
        under(foliagePos, level, foliageSetter, random, tree, 2);
        under(foliagePos, level, foliageSetter, random, tree, 3);

        BlockPos under4 = foliagePos.below(4);
        tryPlaceLeaf(level, foliageSetter, random, tree, under4);
        tryPlaceLeaf(level, foliageSetter, random, tree, under4.east(1));
        tryPlaceLeaf(level, foliageSetter, random, tree, under4.west(1));
        tryPlaceLeaf(level, foliageSetter, random, tree, under4.north(1));
        tryPlaceLeaf(level, foliageSetter, random, tree, under4.south(1));

    }

    private void above(BlockPos foliagePos, LevelSimulatedReader level, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration tree, int above) {
        tryPlaceLeaf(level, foliageSetter, random, tree, foliagePos.above(above));
        tryPlaceLeaf(level, foliageSetter, random, tree, foliagePos.east(above));
        tryPlaceLeaf(level, foliageSetter, random, tree, foliagePos.west(above));
        tryPlaceLeaf(level, foliageSetter, random, tree, foliagePos.north(above));
        tryPlaceLeaf(level, foliageSetter, random, tree, foliagePos.south(above));
    }

    private void under(BlockPos foliagePos, LevelSimulatedReader level, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration tree, int below) {
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
        return 8;
    }

    protected boolean shouldSkipLocation(RandomSource p_225509_, int p_225510_, int p_225511_, int p_225512_, int p_225513_, boolean p_225514_) {
        return p_225510_ == p_225513_ && p_225512_ == p_225513_ && (p_225509_.nextInt(2) == 0 || p_225511_ == 0);
    }
}
