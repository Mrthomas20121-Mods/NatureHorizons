package mrthomas20121.nature_horizons.datagen.feature;

import com.google.common.collect.ImmutableList;
import mrthomas20121.nature_horizons.NatureHorizons;
import mrthomas20121.nature_horizons.init.NatureHorizonsBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;
import java.util.function.Supplier;

import static mrthomas20121.nature_horizons.datagen.feature.NatureHorizonsPlacedFeatures.feature;

public class NatureHorizonsCavePlacements {

    public static final ResourceKey<PlacedFeature> LARGE_ROCKSALT = feature("large_rocksalt");
    public static final ResourceKey<PlacedFeature> CALCITE = feature("calcite");
    public static final ResourceKey<PlacedFeature> DIORITE = feature("diorite");
    public static final ResourceKey<PlacedFeature> ROCKSALT_CEILING = feature("rocksalt_ceiling");
    public static final ResourceKey<PlacedFeature> ROCKSALT_PATCH = feature("rocksalt_patch");

    private static final PlacementModifier TREE_THRESHOLD = SurfaceWaterDepthFilter.forMaxDepth(0);

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> LARGE_ROCKSALT_FEATURE = holdergetter.getOrThrow(NatureHorizonsCaveFeatures.LARGE_ROCKSALT);
        Holder<ConfiguredFeature<?, ?>> CALCITE_FEATURE = holdergetter.getOrThrow(NatureHorizonsCaveFeatures.CALCITE);
        Holder<ConfiguredFeature<?, ?>> DIORITE_FEATURE = holdergetter.getOrThrow(NatureHorizonsCaveFeatures.DIORITE);
        Holder<ConfiguredFeature<?, ?>> ROCKSALT_CEILING_FEATURE = holdergetter.getOrThrow(NatureHorizonsCaveFeatures.ROCKSALT_CEILING);
        Holder<ConfiguredFeature<?, ?>> ROCKSALT_PATCH_FEATURE = holdergetter.getOrThrow(NatureHorizonsCaveFeatures.ROCKSALT_PATCH);

        register(context, ROCKSALT_CEILING, ROCKSALT_CEILING_FEATURE, List.of(CountPlacement.of(188), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.hasSturdyFace(Direction.DOWN), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(-1)), BiomeFilter.biome()));
        register(context, ROCKSALT_PATCH, ROCKSALT_PATCH_FEATURE, List.of(RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, LARGE_ROCKSALT, LARGE_ROCKSALT_FEATURE, List.of(CountPlacement.of(UniformInt.of(35, 55)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome()));
        register(context, CALCITE, CALCITE_FEATURE, commonOrePlacement(20, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(55))));
        register(context, DIORITE, DIORITE_FEATURE, commonOrePlacement(20, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(55))));
    }

    public static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> placedFeatureKey, Holder<ConfiguredFeature<?, ?>> configuredFeatureHolder, List<PlacementModifier> modifiers) {
        context.register(placedFeatureKey, new PlacedFeature(configuredFeatureHolder, List.copyOf(modifiers)));
    }

    public static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> placedFeatureResourceKey, Holder<ConfiguredFeature<?, ?>> configuredFeatureHolder, PlacementModifier... modifiers) {
        register(context, placedFeatureResourceKey, configuredFeatureHolder, List.of(modifiers));
    }

    private static List<PlacementModifier> wouldSurviveSapling(Supplier<? extends SaplingBlock> saplingBlockSupplier) {
        return List.of(PlacementUtils.filteredByBlockSurvival(saplingBlockSupplier.get()));
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
