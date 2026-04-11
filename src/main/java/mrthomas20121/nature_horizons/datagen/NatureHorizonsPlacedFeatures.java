package mrthomas20121.nature_horizons.datagen;

import com.google.common.collect.ImmutableList;
import mrthomas20121.nature_horizons.NatureHorizons;
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

public class NatureHorizonsPlacedFeatures {

    public static ResourceKey<PlacedFeature> ASPEN_FOREST_TREES = feature("aspen_forest_trees");
    public static ResourceKey<PlacedFeature> ASPEN_TREE = feature("aspen_tree");
    public static ResourceKey<PlacedFeature> ASPEN_TREE_BEES = feature("aspen_tree_bees");
    public static ResourceKey<PlacedFeature> TALL_ASPEN_TREE = feature("tall_aspen_tree");
    public static ResourceKey<PlacedFeature> BLACK_WALNUT_TREE = feature("black_walnut_tree");
    public static ResourceKey<PlacedFeature> BLACKWOOD_TREE = feature("blackwood_tree");
    public static ResourceKey<PlacedFeature> JUNIPER_TREE = feature("juniper_tree");
    public static ResourceKey<PlacedFeature> REDWOOD_TREE = feature("redwood_tree");
    public static ResourceKey<PlacedFeature> OLD_GROWTH_REDWOOD_TAIGA = feature("old_growth_redwood_taiga");

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
        Holder<ConfiguredFeature<?, ?>> JUNIPER = holdergetter.getOrThrow(NatureHorizonsConfiguredFeatures.JUNIPER_TREE);
        Holder<ConfiguredFeature<?, ?>> REDWOOD = holdergetter.getOrThrow(NatureHorizonsConfiguredFeatures.REDWOOD_TREE);
        Holder<ConfiguredFeature<?, ?>> REDWOOD_TREES = holdergetter.getOrThrow(NatureHorizonsConfiguredFeatures.OLD_GROWTH_REDWOOD_TAIGA);

        register(context, ASPEN_FOREST_TREES, ASPEN_FOREST, treePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
        register(context, ASPEN_TREE, ASPEN, List.of(PlacementUtils.filteredByBlockSurvival(NatureHorizonsBlocks.ASPEN_SAPLING.get())));
        register(context, ASPEN_TREE_BEES, ASPEN_BEES, List.of(PlacementUtils.filteredByBlockSurvival(NatureHorizonsBlocks.ASPEN_SAPLING.get())));
        register(context, TALL_ASPEN_TREE, TALL_ASPEN, treePlacement(PlacementUtils.countExtra(10, 0.1F, 1), NatureHorizonsBlocks.ASPEN_SAPLING.get()));
        register(context, BLACK_WALNUT_TREE, BLACK_WALNUT, List.of(PlacementUtils.filteredByBlockSurvival(NatureHorizonsBlocks.BLACK_WALNUT_SAPLING.get())));
        register(context, BLACKWOOD_TREE, BLACKWOOD, List.of(PlacementUtils.filteredByBlockSurvival(NatureHorizonsBlocks.BLACKWOOD_SAPLING.get())));
        register(context, JUNIPER_TREE, JUNIPER, treePlacement(PlacementUtils.countExtra(5, 0.1F, 1), NatureHorizonsBlocks.JUNIPER_SAPLING.get()));
        register(context, REDWOOD_TREE, REDWOOD, List.of(PlacementUtils.filteredByBlockSurvival(NatureHorizonsBlocks.REDWOOD_SAPLING.get())));
        register(context, OLD_GROWTH_REDWOOD_TAIGA, REDWOOD_TREES, treePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
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
}
