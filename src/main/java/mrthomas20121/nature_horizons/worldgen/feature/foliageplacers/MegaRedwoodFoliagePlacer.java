package mrthomas20121.nature_horizons.worldgen.feature.foliageplacers;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mrthomas20121.nature_horizons.init.NatureHorizonsFoliagePlacers;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import org.jetbrains.annotations.NotNull;

public class MegaRedwoodFoliagePlacer extends FoliagePlacer {
    public static final Codec<MegaRedwoodFoliagePlacer> CODEC = RecordCodecBuilder.create((p_68664_) -> foliagePlacerParts(p_68664_).and(IntProvider.codec(0, 24).fieldOf("crown_height").forGetter((p_161484_) -> p_161484_.crownHeight)).apply(p_68664_, MegaRedwoodFoliagePlacer::new));
    private final IntProvider crownHeight;

    public MegaRedwoodFoliagePlacer(IntProvider p_161470_, IntProvider p_161471_, IntProvider p_161472_) {
        super(p_161470_, p_161471_);
        this.crownHeight = p_161472_;
    }

    protected @NotNull FoliagePlacerType<?> type() {
        return NatureHorizonsFoliagePlacers.MEGA_REDWOOD.get();
    }

    protected void createFoliage(LevelSimulatedReader p_225678_, FoliagePlacer.FoliageSetter p_273345_, RandomSource p_225680_, TreeConfiguration p_225681_, int p_225682_, FoliagePlacer.FoliageAttachment p_225683_, int p_225684_, int p_225685_, int p_225686_) {
        BlockPos blockpos = p_225683_.pos();
        int i = 0;

        for(int j = blockpos.getY() - p_225684_ + p_225686_; j <= blockpos.getY() + p_225686_; ++j) {
            int k = blockpos.getY() - j;
            int l = p_225685_ + p_225683_.radiusOffset() + Mth.floor((float)k / (float)p_225684_ * 3.5F);
            int i1;
            if (k > 0 && l == i && (j & 1) == 0) {
                i1 = l + 1;
            } else {
                i1 = l;
            }

            this.placeLeavesRowMega(p_225678_, p_273345_, p_225680_, p_225681_, new BlockPos(blockpos.getX(), j, blockpos.getZ()), i1, 0, p_225683_.doubleTrunk());
            i = l;
        }

    }

    protected void placeLeavesRowMega(LevelSimulatedReader p_225629_, FoliagePlacer.FoliageSetter p_272772_, RandomSource p_225631_, TreeConfiguration p_225632_, BlockPos p_225633_, int p_225634_, int p_225635_, boolean p_225636_) {
        int i = 4;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for(int j = -p_225634_; j <= p_225634_ + i; ++j) {
            for(int k = -p_225634_; k <= p_225634_ + i; ++k) {
                if (!this.shouldSkipLocationSigned(p_225631_, j, p_225635_, k, p_225634_, p_225636_)) {
                    blockpos$mutableblockpos.setWithOffset(p_225633_, j, p_225635_, k);
                    tryPlaceLeaf(p_225629_, p_272772_, p_225631_, p_225632_, blockpos$mutableblockpos);
                }
            }
        }

    }

    public int foliageHeight(RandomSource p_225674_, int p_225675_, TreeConfiguration p_225676_) {
        return this.crownHeight.sample(p_225674_);
    }

    protected boolean shouldSkipLocation(RandomSource p_225667_, int p_225668_, int p_225669_, int p_225670_, int p_225671_, boolean p_225672_) {
        if (p_225668_ + p_225670_ >= 7) {
            return true;
        } else {
            return p_225668_ * p_225668_ + p_225670_ * p_225670_ > p_225671_ * p_225671_;
        }
    }
}
