package mrthomas20121.nature_horizons.worldgen.tree;

import mrthomas20121.nature_horizons.datagen.NatureHorizonsConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class JuniperTreeGrower extends AbstractTreeGrower {

    @Override
    protected @Nullable ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_222910_, boolean p_222911_) {
        return NatureHorizonsConfiguredFeatures.JUNIPER_TREE;
    }
}
