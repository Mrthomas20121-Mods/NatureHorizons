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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;
import java.util.function.Supplier;

public class NatureHorizonsPlacedFeatures {

    public static ResourceKey<PlacedFeature> ASPEN_TREE = feature("aspen_tree");
    public static ResourceKey<PlacedFeature> TALL_ASPEN_TREE = feature("tall_aspen_tree");
    public static ResourceKey<PlacedFeature> BLACKWOOD_TREE = feature("blackwood_tree");
    public static ResourceKey<PlacedFeature> JUNIPER_TREE = feature("juniper_tree");

    private static ResourceKey<PlacedFeature> feature(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, NatureHorizons.getResource(name));
    }

    private static final PlacementModifier TREE_THRESHOLD = SurfaceWaterDepthFilter.forMaxDepth(0);

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> ASPEN = holdergetter.getOrThrow(NatureHorizonsConfiguredFeatures.ASPEN_TREE);
        Holder<ConfiguredFeature<?, ?>> TALL_ASPEN = holdergetter.getOrThrow(NatureHorizonsConfiguredFeatures.TALL_ASPEN_TREE);
        Holder<ConfiguredFeature<?, ?>> BLACKWOOD = holdergetter.getOrThrow(NatureHorizonsConfiguredFeatures.BLACKWOOD_TREE);
        Holder<ConfiguredFeature<?, ?>> JUNIPER = holdergetter.getOrThrow(NatureHorizonsConfiguredFeatures.JUNIPER_TREE);

        register(context, ASPEN_TREE, ASPEN, treePlacement(PlacementUtils.countExtra(10, 0.1F, 1), NatureHorizonsBlocks.ASPEN_SAPLING.get()));
        register(context, TALL_ASPEN_TREE, TALL_ASPEN, treePlacement(PlacementUtils.countExtra(10, 0.1F, 1), NatureHorizonsBlocks.ASPEN_SAPLING.get()));
        register(context, BLACKWOOD_TREE, BLACKWOOD, treePlacement(PlacementUtils.countExtra(1, 0.1F, 2)));
        register(context, JUNIPER_TREE, JUNIPER, treePlacement(PlacementUtils.countExtra(5, 0.1F, 1), NatureHorizonsBlocks.JUNIPER_SAPLING.get()));
    }

    public static void register(BootstapContext<PlacedFeature> p_255872_, ResourceKey<PlacedFeature> p_255820_, Holder<ConfiguredFeature<?, ?>> p_255813_, List<PlacementModifier> p_256042_) {
        p_255872_.register(p_255820_, new PlacedFeature(p_255813_, List.copyOf(p_256042_)));
    }

    public static BlockPredicateFilter filteredByBlockSurvival(Supplier<Block> block) {
        return filteredByBlockSurvival(block.get());
    }

    public static BlockPredicateFilter filteredByBlockSurvival(Block block) {
        return BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(block.defaultBlockState(), BlockPos.ZERO));
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
