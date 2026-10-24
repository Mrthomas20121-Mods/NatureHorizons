package mrthomas20121.nature_horizons.datagen.feature;

import com.google.common.collect.ImmutableList;
import mrthomas20121.nature_horizons.init.NatureHorizonsBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

import static mrthomas20121.nature_horizons.datagen.feature.NatureHorizonsPlacedFeatures.feature;

public class NatureHorizonsVegetationPlacements {

    private static final PlacementModifier TREE_THRESHOLD = SurfaceWaterDepthFilter.forMaxDepth(0);

    public static ResourceKey<PlacedFeature> TREES_ASPEN_FOREST = feature("trees_aspen_forest");
    public static ResourceKey<PlacedFeature> TREES_OLD_GROWTH_ASPEN_FOREST = feature("trees_old_growth_aspen_forest");
    public static ResourceKey<PlacedFeature> TREES_TROPICAL_FOREST = feature("trees_tropical_forest");
    public static ResourceKey<PlacedFeature> TREES_WOODLAND = feature("trees_woodland");
    public static ResourceKey<PlacedFeature> TREES_OLD_GROWTH_REDWOOD_TAIGA = feature("trees_old_growth_redwood_taiga");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> TREES_ASPEN = holdergetter.getOrThrow(NatureHorizonsVegetationFeatures.TREES_ASPEN_FOREST);
        Holder<ConfiguredFeature<?, ?>> TREES_OLD_GROWTH_ASPEN = holdergetter.getOrThrow(NatureHorizonsVegetationFeatures.TREES_OLD_GROWTH_ASPEN_FOREST);
        Holder<ConfiguredFeature<?, ?>> TREE_TROPICAL_FOREST = holdergetter.getOrThrow(NatureHorizonsVegetationFeatures.TREES_TROPICAL_FOREST);
        Holder<ConfiguredFeature<?, ?>> TREE_WOODLAND = holdergetter.getOrThrow(NatureHorizonsVegetationFeatures.TREES_WOODLAND);
        Holder<ConfiguredFeature<?, ?>> TREE_REDWOOD = holdergetter.getOrThrow(NatureHorizonsVegetationFeatures.TREES_OLD_GROWTH_REDWOOD_TAIGA);

        register(context, TREES_ASPEN_FOREST, TREES_ASPEN, treePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
        register(context, TREES_OLD_GROWTH_ASPEN_FOREST, TREES_OLD_GROWTH_ASPEN, treePlacement(PlacementUtils.countExtra(10, 0.1F, 1), NatureHorizonsBlocks.ASPEN_SAPLING.get()));
        register(context, TREES_WOODLAND, TREE_WOODLAND, treePlacement(PlacementUtils.countExtra(3, 0.1F, 1)));
        register(context, TREES_OLD_GROWTH_REDWOOD_TAIGA, TREE_REDWOOD, treePlacement(PlacementUtils.countExtra(7, 0.1F, 1)));
        register(context, TREES_TROPICAL_FOREST, TREE_TROPICAL_FOREST, treePlacement(PlacementUtils.countExtra(20, 0.1F, 1)));
    }

    public static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> placedFeatureKey, Holder<ConfiguredFeature<?, ?>> configuredFeatureHolder, List<PlacementModifier> modifiers) {
        context.register(placedFeatureKey, new PlacedFeature(configuredFeatureHolder, List.copyOf(modifiers)));
    }

    public static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> placedFeatureResourceKey, Holder<ConfiguredFeature<?, ?>> configuredFeatureHolder, PlacementModifier... modifiers) {
        register(context, placedFeatureResourceKey, configuredFeatureHolder, List.of(modifiers));
    }

    private static ImmutableList.Builder<PlacementModifier> treePlacementBase(PlacementModifier p_195485_) {
        return ImmutableList.<PlacementModifier>builder().add(p_195485_).add(InSquarePlacement.spread()).add(TREE_THRESHOLD).add(PlacementUtils.HEIGHTMAP_OCEAN_FLOOR).add(BiomeFilter.biome());
    }

    public static List<PlacementModifier> treePlacement(PlacementModifier p_195480_) {
        return treePlacementBase(p_195480_).build();
    }

    public static List<PlacementModifier> treePlacement(PlacementModifier p_195482_, Block p_195483_) {
        return treePlacementBase(p_195482_).add(BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(p_195483_.defaultBlockState(), BlockPos.ZERO))).build();
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }
}
