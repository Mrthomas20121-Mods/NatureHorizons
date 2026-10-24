package mrthomas20121.nature_horizons.worldgen.tree;

import mrthomas20121.nature_horizons.datagen.feature.NatureHorizonsTreeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class AspenTreeGrower extends AbstractTreeGrower {
    
    @Override
    protected @Nullable ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource source, boolean bool) {
        if(source.nextFloat() < 0.2f) {
            return bool ? NatureHorizonsTreeFeatures.TALL_ASPEN_TREE_BEES: NatureHorizonsTreeFeatures.TALL_ASPEN_TREE;
        }
        return bool ? NatureHorizonsTreeFeatures.ASPEN_TREE_BEES: NatureHorizonsTreeFeatures.ASPEN_TREE;
    }

}
