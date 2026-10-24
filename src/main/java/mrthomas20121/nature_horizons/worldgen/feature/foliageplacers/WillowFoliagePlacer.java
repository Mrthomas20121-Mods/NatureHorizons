package mrthomas20121.nature_horizons.worldgen.feature.foliageplacers;

import mrthomas20121.nature_horizons.init.NatureHorizonsFoliagePlacers;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import org.jetbrains.annotations.NotNull;

public class WillowFoliagePlacer extends FoliagePlacer {
    public static final Codec<WillowFoliagePlacer> CODEC = RecordCodecBuilder.create(
            (provider) -> foliagePlacerParts(provider)
                    .and(provider.group(
                            Codec.intRange(0, 16).fieldOf("height").forGetter((p_68412_) -> p_68412_.height),
                            Codec.floatRange(0.0F, 1.0F).fieldOf("hanging_leaves_chance").forGetter((p_273148_) -> p_273148_.hangingLeavesChance),
                            Codec.floatRange(0.0F, 1.0F).fieldOf("hanging_leaves_extension_chance").forGetter((p_273098_) -> p_273098_.hangingLeavesExtensionChance))
                    ).apply(provider, WillowFoliagePlacer::new));

    protected final int height;
    protected final float hangingLeavesChance;
    protected final float hangingLeavesExtensionChance;

    public WillowFoliagePlacer(IntProvider p_161356_, IntProvider p_161357_, int height, float hangingLeavesChance, float hangingLeavesExtensionChance) {
        super(p_161356_, p_161357_);
        this.height = height;
        this.hangingLeavesChance = hangingLeavesChance;
        this.hangingLeavesExtensionChance = hangingLeavesExtensionChance;
    }

    protected @NotNull FoliagePlacerType<?> type() {
        return NatureHorizonsFoliagePlacers.WILLOW_FOLIAGE_PLACER.get();
    }

    protected void createFoliage(LevelSimulatedReader p_273066_, FoliagePlacer.FoliageSetter p_272716_, RandomSource p_273178_, TreeConfiguration p_272850_, int p_273067_, FoliagePlacer.FoliageAttachment p_273711_, int p_273580_, int p_273511_, int p_273685_) {
        for(int i = p_273685_; i >= p_273685_ - p_273580_; --i) {
            int j = Math.max(p_273511_ + p_273711_.radiusOffset() - 1 - i / 2, 0);
            this.placeLeavesRowWithHangingLeavesBelow(p_273066_, p_272716_, p_273178_, p_272850_, p_273711_.pos(), j, i, p_273711_.doubleTrunk(), hangingLeavesChance, hangingLeavesExtensionChance);
        }

    }

    public int foliageHeight(RandomSource p_225516_, int p_225517_, TreeConfiguration p_225518_) {
        return this.height;
    }

    protected boolean shouldSkipLocation(RandomSource p_225509_, int p_225510_, int p_225511_, int p_225512_, int p_225513_, boolean p_225514_) {
        return p_225510_ == p_225513_ && p_225512_ == p_225513_ && (p_225509_.nextInt(2) == 0 || p_225511_ == 0);
    }
}
