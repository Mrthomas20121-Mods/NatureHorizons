package mrthomas20121.nature_horizons.worldgen.tree;

import mrthomas20121.nature_horizons.datagen.feature.NatureHorizonsTreeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class BalsaTreeGrower extends AbstractTreeGrower {
    
    @Override
    protected @Nullable ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource source, boolean bool) {
        return NatureHorizonsTreeFeatures.BALSA_TREE;
    }

}
