package mrthomas20121.nature_horizons.datagen;

import com.google.common.collect.ImmutableList;
import mrthomas20121.nature_horizons.NatureHorizons;
import mrthomas20121.nature_horizons.init.NatureHorizonsBlocks;
import mrthomas20121.nature_horizons.init.NatureHorizonsFeatures;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AlterGroundDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.CherryTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import slimeknights.mantle.registration.object.WoodBlockObject;

import java.util.List;

public class NatureHorizonsConfiguredFeatures {

    public static ResourceKey<ConfiguredFeature<?, ?>> ASPEN_FOREST_TREES = feature("aspen_forest_trees");
    public static ResourceKey<ConfiguredFeature<?, ?>> ASPEN_TREE = feature("aspen_tree");
    public static ResourceKey<ConfiguredFeature<?, ?>> TALL_ASPEN_TREE = feature("tall_aspen_tree");
    public static ResourceKey<ConfiguredFeature<?, ?>> ASPEN_TREE_BEE = feature("aspen_tree_bee");

    public static ResourceKey<ConfiguredFeature<?, ?>> BLACK_WALNUT_TREE = feature("black_walnut_tree");
    public static ResourceKey<ConfiguredFeature<?, ?>> BLACKWOOD_TREE = feature("blackwood_tree");
    public static ResourceKey<ConfiguredFeature<?, ?>> TREES_JAPANESE_MAPLE = feature("trees_japanese_maple");
    public static ResourceKey<ConfiguredFeature<?, ?>> JAPANESE_MAPLE_TREE = feature("japanese_maple_tree");
    public static ResourceKey<ConfiguredFeature<?, ?>> CRIMSON_JAPANESE_MAPLE_TREE = feature("crimson_japanese_maple_tree");
    public static ResourceKey<ConfiguredFeature<?, ?>> ORANGE_JAPANESE_MAPLE_TREE = feature("orange_japanese_maple_tree");
    public static ResourceKey<ConfiguredFeature<?, ?>> JUNIPER_TREE = feature("juniper_tree");
    public static ResourceKey<ConfiguredFeature<?, ?>> AURIC_TREE = feature("auric_tree");
    public static ResourceKey<ConfiguredFeature<?, ?>> REDWOOD_TREE = feature("redwood_tree");
    public static ResourceKey<ConfiguredFeature<?, ?>> OLD_GROWTH_REDWOOD_TAIGA = feature("old_growth_redwood_taiga");

    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_ROCKSALT = feature("large_rocksalt");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ROCKSALT_CEILING = feature("rocksalt_ceiling");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ROCKSALT_PATCH = feature("rocksalt_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CALCITE = feature("calcite");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DIORITE = feature("diorite");

    private static ResourceKey<ConfiguredFeature<?, ?>> feature(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, NatureHorizons.getResource(name));
    }

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        BeehiveDecorator beehivedecorator = new BeehiveDecorator(0.002F);
        HolderGetter<PlacedFeature> placedFeatureHolderGetter = context.lookup(Registries.PLACED_FEATURE);
        Holder<PlacedFeature> ASPEN = placedFeatureHolderGetter.getOrThrow(NatureHorizonsPlacedFeatures.ASPEN_TREE);
        Holder<PlacedFeature> ASPEN_BEES = placedFeatureHolderGetter.getOrThrow(NatureHorizonsPlacedFeatures.ASPEN_TREE);
        Holder<PlacedFeature> BLACK_WALNUT = placedFeatureHolderGetter.getOrThrow(NatureHorizonsPlacedFeatures.BLACK_WALNUT_TREE);
        Holder<PlacedFeature> SPRUCE = placedFeatureHolderGetter.getOrThrow(TreePlacements.SPRUCE_CHECKED);
        Holder<PlacedFeature> PINE = placedFeatureHolderGetter.getOrThrow(TreePlacements.PINE_CHECKED);
        Holder<PlacedFeature> BIRCH = placedFeatureHolderGetter.getOrThrow(TreePlacements.BIRCH_CHECKED);
        Holder<PlacedFeature> JAPANESE_MAPLE = placedFeatureHolderGetter.getOrThrow(NatureHorizonsPlacedFeatures.JAPANESE_MAPLE_TREE);
        Holder<PlacedFeature> CRIMSON_JAPANESE_MAPLE = placedFeatureHolderGetter.getOrThrow(NatureHorizonsPlacedFeatures.CRIMSON_JAPANESE_MAPLE_TREE);
        Holder<PlacedFeature> ORANGE_JAPANESE_MAPLE = placedFeatureHolderGetter.getOrThrow(NatureHorizonsPlacedFeatures.ORANGE_JAPANESE_MAPLE_TREE);
        Holder<PlacedFeature> REDWOOD = placedFeatureHolderGetter.getOrThrow(NatureHorizonsPlacedFeatures.REDWOOD_TREE);

        RuleTest stoneTest = new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD);

        register(context, CALCITE, Feature.ORE, new OreConfiguration(stoneTest, Blocks.CALCITE.defaultBlockState(), 44));
        register(context, DIORITE, Feature.ORE, new OreConfiguration(stoneTest, Blocks.DIORITE.defaultBlockState(), 44));
        register(context, ROCKSALT_CEILING, Feature.BLOCK_COLUMN, new BlockColumnConfiguration(
                List.of(
                        BlockColumnConfiguration.layer(UniformInt.of(1, 2), BlockStateProvider.simple(Blocks.DIORITE)),
                        BlockColumnConfiguration.layer(UniformInt.of(3, 5), BlockStateProvider.simple(NatureHorizonsBlocks.ROCKSALT.get()))
                ),
                Direction.DOWN,
                BlockPredicate.ONLY_IN_AIR_PREDICATE,
                false
        ));

        register(context, ROCKSALT_PATCH, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(NatureHorizonsBlocks.ROCKSALT.get())), List.of(Blocks.STONE, Blocks.DEEPSLATE)));

        register(context, ASPEN_TREE, Feature.TREE, createAspenTree().build());
        register(context, TALL_ASPEN_TREE, Feature.TREE, createTallAspenTree().build());
        register(context, ASPEN_TREE_BEE, Feature.TREE, createAspenTree().decorators(List.of(beehivedecorator)).build());
        register(context, BLACK_WALNUT_TREE, Feature.TREE, createBlackWalnutTree().build());
        register(context, BLACKWOOD_TREE, Feature.TREE, createBlackwoodTree().build());
        register(context, JAPANESE_MAPLE_TREE, Feature.TREE, createJapaneseMaple(NatureHorizonsBlocks.JAPANESE_MAPLE, NatureHorizonsBlocks.JAPANESE_MAPLE_LEAVES.get()).build());
        register(context, CRIMSON_JAPANESE_MAPLE_TREE, Feature.TREE, createJapaneseMaple(NatureHorizonsBlocks.JAPANESE_MAPLE, NatureHorizonsBlocks.CRIMSON_JAPANESE_MAPLE_LEAVES.get()).build());
        register(context, ORANGE_JAPANESE_MAPLE_TREE, Feature.TREE, createJapaneseMaple(NatureHorizonsBlocks.JAPANESE_MAPLE, NatureHorizonsBlocks.ORANGE_JAPANESE_MAPLE_LEAVES.get()).build());
        register(context, JUNIPER_TREE, Feature.TREE, createJuniperTree().ignoreVines().build());
        register(context, AURIC_TREE, Feature.TREE, createAuric().build());

        register(context, ASPEN_FOREST_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(ASPEN, 0.3F), new WeightedPlacedFeature(BLACK_WALNUT, 0.2F)), ASPEN_BEES));
        register(context, TREES_JAPANESE_MAPLE, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(ORANGE_JAPANESE_MAPLE, 0.3F), new WeightedPlacedFeature(CRIMSON_JAPANESE_MAPLE, 0.2F)), JAPANESE_MAPLE));
        register(context, REDWOOD_TREE, Feature.TREE, createRedWoodTree().build());
        register(context, OLD_GROWTH_REDWOOD_TAIGA, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(SPRUCE, 0.1f), new WeightedPlacedFeature(PINE, 0.1f)), REDWOOD));

        register(context, LARGE_ROCKSALT, NatureHorizonsFeatures.LARGE_ROCKSALT.get(), new LargeDripstoneConfiguration(30, UniformInt.of(3, 15), UniformFloat.of(0.4F, 2.0F), 0.33F, UniformFloat.of(0.3F, 0.9F), UniformFloat.of(0.4F, 1.0F), UniformFloat.of(0.0F, 0.4F), 4, 0.6F));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createAuric() {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(NatureHorizonsBlocks.AURIC.getLog()), new StraightTrunkPlacer(1, 0, 0), BlockStateProvider.simple(NatureHorizonsBlocks.AURIC_LEAVES.get()), new BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 2), new TwoLayersFeatureSize(1, 0, 0)).dirt(BlockStateProvider.simple(Blocks.SAND));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createJapaneseMaple(WoodBlockObject woodBlockObject, LeavesBlock leavesBlock) {
        return (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(woodBlockObject.getLog()), new CherryTrunkPlacer(6, 1, 0, new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder().add(ConstantInt.of(1), 1).add(ConstantInt.of(2), 1).add(ConstantInt.of(3), 1).build()), UniformInt.of(2, 4), UniformInt.of(-4, -3), UniformInt.of(-1, 0)), BlockStateProvider.simple(leavesBlock), new CherryFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(6), 0.25F, 0.5F, 0.16666667F, 0.33333334F), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createRedWoodTree() {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(NatureHorizonsBlocks.REDWOOD.getLog()), new GiantTrunkPlacer(14, 2, 14), BlockStateProvider.simple(NatureHorizonsBlocks.REDWOOD_LEAVES.get()), new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(13, 17)), new TwoLayersFeatureSize(1, 1, 2)).decorators(ImmutableList.of(new AlterGroundDecorator(BlockStateProvider.simple(Blocks.PODZOL))));
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> p_256315_, ResourceKey<ConfiguredFeature<?, ?>> p_255983_, F p_255949_, FC p_256398_) {
        p_256315_.register(p_255983_, new ConfiguredFeature<>(p_255949_, p_256398_));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createBlackWalnutTree() {
        return (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(NatureHorizonsBlocks.BLACK_WALNUT.getLog()), new FancyTrunkPlacer(4, 5, 1), BlockStateProvider.simple(NatureHorizonsBlocks.BLACK_WALNUT_LEAVES.get()), new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 2), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createBlackwoodTree() {
        return (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(NatureHorizonsBlocks.BLACKWOOD.getLog()), new FancyTrunkPlacer(5, 6, 3), BlockStateProvider.simple(NatureHorizonsBlocks.BLACKWOOD_LEAVES.get()), new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(3), 3), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createAspenTree() {
        return createStraightBlobTree(NatureHorizonsBlocks.ASPEN.getLog(), NatureHorizonsBlocks.ASPEN_LEAVES.get(), 5, 2, 0, 2).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createTallAspenTree() {
        return createStraightBlobTree(NatureHorizonsBlocks.ASPEN.getLog(), NatureHorizonsBlocks.ASPEN_LEAVES.get(), 5, 2, 6, 2).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createJuniperTree() {
        return baseJuniperTree(NatureHorizonsBlocks.JUNIPER.getLog(), NatureHorizonsBlocks.JUNIPER_LEAVES.get(), 4, 2, 0, 2);
    }

    private static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(Block p_195147_, Block p_195148_, int p_195149_, int p_195150_, int p_195151_, int p_195152_) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(p_195147_), new StraightTrunkPlacer(p_195149_, p_195150_, p_195151_), BlockStateProvider.simple(p_195148_), new BlobFoliagePlacer(ConstantInt.of(p_195152_), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1));
    }

    private static TreeConfiguration.TreeConfigurationBuilder baseJuniperTree(Block p_195147_, Block p_195148_, int p_195149_, int p_195150_, int p_195151_, int p_195152_) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(p_195147_), new StraightTrunkPlacer(p_195149_, p_195150_, p_195151_), BlockStateProvider.simple(p_195148_), new BlobFoliagePlacer(ConstantInt.of(p_195152_), ConstantInt.of(0), 2), new TwoLayersFeatureSize(1, 0, 1));
    }
}
