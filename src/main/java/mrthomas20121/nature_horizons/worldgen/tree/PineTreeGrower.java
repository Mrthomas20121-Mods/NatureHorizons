package mrthomas20121.nature_horizons.worldgen.tree;

import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class PineTreeGrower extends AbstractMegaTreeGrower {
    @Override
    protected @Nullable ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_222910_, boolean p_222911_) {
        return TreeFeatures.PINE;
    }

    @Override
    protected @Nullable ResourceKey<ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource p_222904_) {
        return TreeFeatures.MEGA_PINE;
    }
}
