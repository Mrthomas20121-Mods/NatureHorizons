package mrthomas20121.nature_horizons.datagen;

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
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class NatureHorizonsPlacedFeatures {

    public static ResourceKey<PlacedFeature> ASPEN_FOREST_TREES = feature("aspen_forest_trees");
    public static ResourceKey<PlacedFeature> ASPEN_TREE = feature("aspen_tree");
    public static ResourceKey<PlacedFeature> ASPEN_TREE_BEES = feature("aspen_tree_bees");
    public static ResourceKey<PlacedFeature> TALL_ASPEN_TREE = feature("tall_aspen_tree");
    public static ResourceKey<PlacedFeature> BLACK_WALNUT_TREE = feature("black_walnut_tree");
    public static ResourceKey<PlacedFeature> BLACKWOOD_TREE = feature("blackwood_tree");
    public static ResourceKey<PlacedFeature> TREES_JAPANESE_MAPLE = feature("trees_japanese_maple");
    public static ResourceKey<PlacedFeature> JAPANESE_MAPLE_TREE = feature("japanese_maple_tree");
    public static ResourceKey<PlacedFeature> CRIMSON_JAPANESE_MAPLE_TREE = feature("crimson_japanese_maple_tree");
    public static ResourceKey<PlacedFeature> ORANGE_JAPANESE_MAPLE_TREE = feature("orange_japanese_maple_tree");
    public static ResourceKey<PlacedFeature> JUNIPER_TREE = feature("juniper_tree");
    public static ResourceKey<PlacedFeature> AURIC_TREE = feature("auric_tree");
    public static ResourceKey<PlacedFeature> SHRUBLAND_TREES = feature("shrubland_trees");
    public static ResourceKey<PlacedFeature> REDWOOD_TREE = feature("redwood_tree");
    public static ResourceKey<PlacedFeature> OLD_GROWTH_REDWOOD_TAIGA = feature("old_growth_redwood_taiga");
    public static final ResourceKey<PlacedFeature> LARGE_ROCKSALT = feature("large_rocksalt");
    public static final ResourceKey<PlacedFeature> CALCITE = feature("calcite");
    public static final ResourceKey<PlacedFeature> DIORITE = feature("diorite");
    public static final ResourceKey<PlacedFeature> ROCKSALT_CEILING = feature("rocksalt_ceiling");
    public static final ResourceKey<PlacedFeature> ROCKSALT_PATCH = feature("rocksalt_patch");

    private static ResourceKey<PlacedFeature> feature(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, NatureHorizons.getResource(name));
    }

    private static final PlacementModifier TREE_THRESHOLD = SurfaceWaterDepthFilter.forMaxDepth(0);

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> ASPEN = holdergetter.getOrThrow(NatureHorizonsConfiguredFeatures.ASPEN_TREE);
        Holder<ConfiguredFeature<?, ?>> ASPEN_BEES = holdergetter.getOrThrow(NatureHorizonsConfiguredFeatures.ASPEN_TREE_BEE);
        Holder<ConfiguredFeature<?, ?>> ASPEN_FOREST = holdergetter.getOrThrow(NatureHorizonsConfiguredFeatures.ASPEN_FOREST_TREES);
        Holder<ConfiguredFeature<?, ?>> TALL_ASPEN = holdergetter.getOrThrow(NatureHorizonsConfiguredFeatures.TALL_ASPEN_TREE);
        Holder<ConfiguredFeature<?, ?>> BLACK_WALNUT = holdergetter.getOrThrow(NatureHorizonsConfiguredFeatures.BLACK_WALNUT_TREE);
        Holder<ConfiguredFeature<?, ?>> BLACKWOOD = holdergetter.getOrThrow(NatureHorizonsConfiguredFeatures.BLACKWOOD_TREE);
        Holder<ConfiguredFeature<?, ?>> MEADOW = holdergetter.getOrThrow(NatureHorizonsConfiguredFeatures.TREES_JAPANESE_MAPLE);
        Holder<ConfiguredFeature<?, ?>> JAPANESE_MAPLE = holdergetter.getOrThrow(NatureHorizonsConfiguredFeatures.JAPANESE_MAPLE_TREE);
        Holder<ConfiguredFeature<?, ?>> CRIMSON_JAPANESE_MAPLE = holdergetter.getOrThrow(NatureHorizonsConfiguredFeatures.CRIMSON_JAPANESE_MAPLE_TREE);
        Holder<ConfiguredFeature<?, ?>> ORANGE_JAPANESE_MAPLE = holdergetter.getOrThrow(NatureHorizonsConfiguredFeatures.ORANGE_JAPANESE_MAPLE_TREE);
        Holder<ConfiguredFeature<?, ?>> JUNIPER = holdergetter.getOrThrow(NatureHorizonsConfiguredFeatures.JUNIPER_TREE);
        Holder<ConfiguredFeature<?, ?>> AURIC = holdergetter.getOrThrow(NatureHorizonsConfiguredFeatures.AURIC_TREE);
        Holder<ConfiguredFeature<?, ?>> REDWOOD = holdergetter.getOrThrow(NatureHorizonsConfiguredFeatures.REDWOOD_TREE);
        Holder<ConfiguredFeature<?, ?>> REDWOOD_TREES = holdergetter.getOrThrow(NatureHorizonsConfiguredFeatures.OLD_GROWTH_REDWOOD_TAIGA);
        Holder<ConfiguredFeature<?, ?>> LARGE_ROCKSALT_FEATURE = holdergetter.getOrThrow(NatureHorizonsConfiguredFeatures.LARGE_ROCKSALT);
        Holder<ConfiguredFeature<?, ?>> CALCITE_FEATURE = holdergetter.getOrThrow(NatureHorizonsConfiguredFeatures.CALCITE);
        Holder<ConfiguredFeature<?, ?>> DIORITE_FEATURE = holdergetter.getOrThrow(NatureHorizonsConfiguredFeatures.DIORITE);
        Holder<ConfiguredFeature<?, ?>> ROCKSALT_CEILING_FEATURE = holdergetter.getOrThrow(NatureHorizonsConfiguredFeatures.ROCKSALT_CEILING);
        Holder<ConfiguredFeature<?, ?>> ROCKSALT_PATCH_FEATURE = holdergetter.getOrThrow(NatureHorizonsConfiguredFeatures.ROCKSALT_PATCH);

        register(context, ROCKSALT_CEILING, ROCKSALT_CEILING_FEATURE, List.of(CountPlacement.of(188), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.hasSturdyFace(Direction.DOWN), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(-1)), BiomeFilter.biome()));
        register(context, ROCKSALT_PATCH, ROCKSALT_PATCH_FEATURE, List.of(RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        register(context, ASPEN_FOREST_TREES, ASPEN_FOREST, treePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
        register(context, ASPEN_TREE, ASPEN, List.of(PlacementUtils.filteredByBlockSurvival(NatureHorizonsBlocks.ASPEN_SAPLING.get())));
        register(context, ASPEN_TREE_BEES, ASPEN_BEES, List.of(PlacementUtils.filteredByBlockSurvival(NatureHorizonsBlocks.ASPEN_SAPLING.get())));
        register(context, TALL_ASPEN_TREE, TALL_ASPEN, treePlacement(PlacementUtils.countExtra(10, 0.1F, 1), NatureHorizonsBlocks.ASPEN_SAPLING.get()));
        register(context, BLACK_WALNUT_TREE, BLACK_WALNUT, List.of(PlacementUtils.filteredByBlockSurvival(NatureHorizonsBlocks.BLACK_WALNUT_SAPLING.get())));
        register(context, BLACKWOOD_TREE, BLACKWOOD, List.of(PlacementUtils.filteredByBlockSurvival(NatureHorizonsBlocks.BLACKWOOD_SAPLING.get())));

        register(context, JAPANESE_MAPLE_TREE, JAPANESE_MAPLE, List.of(PlacementUtils.filteredByBlockSurvival(NatureHorizonsBlocks.JAPANESE_MAPLE_SAPLING.get())));
        register(context, CRIMSON_JAPANESE_MAPLE_TREE, CRIMSON_JAPANESE_MAPLE, List.of(PlacementUtils.filteredByBlockSurvival(NatureHorizonsBlocks.CRIMSON_JAPANESE_MAPLE_SAPLING.get())));
        register(context, ORANGE_JAPANESE_MAPLE_TREE, ORANGE_JAPANESE_MAPLE, List.of(PlacementUtils.filteredByBlockSurvival(NatureHorizonsBlocks.ORANGE_JAPANESE_MAPLE_SAPLING.get())));
        register(context, TREES_JAPANESE_MAPLE, MEADOW, treePlacement(PlacementUtils.countExtra(8, 0.1F, 1)));

        register(context, AURIC_TREE, AURIC, List.of(PlacementUtils.filteredByBlockSurvival(NatureHorizonsBlocks.AURIC_SAPLING.get())));
        register(context, SHRUBLAND_TREES, AURIC, treePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
        register(context, JUNIPER_TREE, JUNIPER, treePlacement(PlacementUtils.countExtra(5, 0.1F, 1), NatureHorizonsBlocks.JUNIPER_SAPLING.get()));
        register(context, REDWOOD_TREE, REDWOOD, List.of(PlacementUtils.filteredByBlockSurvival(NatureHorizonsBlocks.REDWOOD_SAPLING.get())));
        register(context, OLD_GROWTH_REDWOOD_TAIGA, REDWOOD_TREES, treePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));

        register(context, LARGE_ROCKSALT, LARGE_ROCKSALT_FEATURE, List.of(CountPlacement.of(UniformInt.of(35, 55)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome()));
        register(context, CALCITE, CALCITE_FEATURE, commonOrePlacement(20, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(55))));
        register(context, DIORITE, DIORITE_FEATURE, commonOrePlacement(20, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(55))));
    }

    public static void register(BootstapContext<PlacedFeature> p_255872_, ResourceKey<PlacedFeature> p_255820_, Holder<ConfiguredFeature<?, ?>> p_255813_, List<PlacementModifier> p_256042_) {
        p_255872_.register(p_255820_, new PlacedFeature(p_255813_, List.copyOf(p_256042_)));
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
