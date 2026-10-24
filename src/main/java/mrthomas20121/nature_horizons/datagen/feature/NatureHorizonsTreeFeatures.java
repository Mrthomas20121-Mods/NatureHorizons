package mrthomas20121.nature_horizons.datagen.feature;

import com.google.common.collect.ImmutableList;
import mrthomas20121.nature_horizons.init.NatureHorizonsBlocks;
import mrthomas20121.nature_horizons.worldgen.feature.foliageplacers.*;
import mrthomas20121.nature_horizons.worldgen.feature.trunkplacers.MegaGiantTrunkPlacer;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaPineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AlterGroundDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.List;
import java.util.function.Supplier;

import static mrthomas20121.nature_horizons.datagen.feature.NatureHorizonsConfiguredFeatures.feature;

public class NatureHorizonsTreeFeatures {

    public static ResourceKey<ConfiguredFeature<? , ?>> ASPEN_TREE = feature("aspen_tree");
    public static ResourceKey<ConfiguredFeature<? , ?>> ASPEN_TREE_BEES = feature("aspen_tree_bees");
    public static ResourceKey<ConfiguredFeature<? , ?>> TALL_ASPEN_TREE = feature("tall_aspen_tree");
    public static ResourceKey<ConfiguredFeature<? , ?>> TALL_ASPEN_TREE_BEES = feature("tall_aspen_tree_bees");
    public static ResourceKey<ConfiguredFeature<? , ?>> BALSA_TREE = feature("balsa_tree");
    public static ResourceKey<ConfiguredFeature<? , ?>> BLACK_WALNUT_TREE = feature("black_walnut_tree");
    public static ResourceKey<ConfiguredFeature<? , ?>> BLACKWOOD_TREE = feature("blackwood_tree");
    public static ResourceKey<ConfiguredFeature<? , ?>> PINK_IPE_TREE = feature("pink_ipe_tree");
    public static ResourceKey<ConfiguredFeature<? , ?>> GOLDEN_IPE_TREE = feature("golden_ipe_tree");
    public static ResourceKey<ConfiguredFeature<? , ?>> WHITE_IPE_TREE = feature("white_ipe_tree");
    public static ResourceKey<ConfiguredFeature<? , ?>> JAPANESE_MAPLE_TREE = feature("japanese_maple_tree");
    public static ResourceKey<ConfiguredFeature<? , ?>> CRIMSON_JAPANESE_MAPLE_TREE = feature("crimson_japanese_maple_tree");
    public static ResourceKey<ConfiguredFeature<? , ?>> ORANGE_JAPANESE_MAPLE_TREE = feature("orange_japanese_maple_tree");
    public static ResourceKey<ConfiguredFeature<? , ?>> JUNIPER_TREE = feature("juniper_tree");
    public static ResourceKey<ConfiguredFeature<? , ?>> MAHOGANY_TREE = feature("mahogany_tree");
    public static ResourceKey<ConfiguredFeature<? , ?>> NANMU_TREE = feature("nanmu_tree");
    //public static ResourceKey<ConfiguredFeature<? , ?>> PINE_TREE = feature("pine_tree");
    public static ResourceKey<ConfiguredFeature<? , ?>> REDWOOD_TREE = feature("redwood_tree");
    public static ResourceKey<ConfiguredFeature<? , ?>> GIANT_REDWOOD_TREE = feature("giant_redwood_tree");
    public static ResourceKey<ConfiguredFeature<? , ?>> WILLOW_TREE = feature("willow_tree");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        BeehiveDecorator beehivedecorator = new BeehiveDecorator(0.002F);

        register(context, ASPEN_TREE, Feature.TREE, createAspenTree().build());
        register(context, ASPEN_TREE_BEES, Feature.TREE, createAspenTree().decorators(List.of(beehivedecorator)).build());
        register(context, TALL_ASPEN_TREE, Feature.TREE, createTallAspenTree().build());
        register(context, TALL_ASPEN_TREE_BEES, Feature.TREE, createTallAspenTree().decorators(List.of(beehivedecorator)).build());
        register(context, BALSA_TREE, Feature.TREE, createBalsaTree().build());
        register(context, BLACK_WALNUT_TREE, Feature.TREE, createBlackWalnutTree().build());
        register(context, BLACKWOOD_TREE, Feature.TREE, createBlackwoodTree().build());
        register(context, PINK_IPE_TREE, Feature.TREE, createIpeTree(NatureHorizonsBlocks.PINK_IPE_LEAVES).build());
        register(context, GOLDEN_IPE_TREE, Feature.TREE, createIpeTree(NatureHorizonsBlocks.GOLDEN_IPE_LEAVES).build());
        register(context, WHITE_IPE_TREE, Feature.TREE, createIpeTree(NatureHorizonsBlocks.WHITE_IPE_LEAVES).build());
        register(context, JAPANESE_MAPLE_TREE, Feature.TREE,
                createJapaneseMapleTree(NatureHorizonsBlocks.JAPANESE_MAPLE_LEAVES)
                        .decorators(List.of(new AlterGroundDecorator(BlockStateProvider.simple(Blocks.COARSE_DIRT)))).build());
        register(context, CRIMSON_JAPANESE_MAPLE_TREE, Feature.TREE,
                createJapaneseMapleTree(NatureHorizonsBlocks.CRIMSON_JAPANESE_MAPLE_LEAVES)
                        .decorators(List.of(new AlterGroundDecorator(BlockStateProvider.simple(Blocks.COARSE_DIRT)))).build());
        register(context, ORANGE_JAPANESE_MAPLE_TREE, Feature.TREE,
                createJapaneseMapleTree(NatureHorizonsBlocks.ORANGE_JAPANESE_MAPLE_LEAVES)
                        .decorators(List.of(new AlterGroundDecorator(BlockStateProvider.simple(Blocks.COARSE_DIRT)))).build());
        register(context, JUNIPER_TREE, Feature.TREE, createJuniperTree().build());
        register(context, MAHOGANY_TREE, Feature.TREE, createMahoganyTree().build());
        register(context, NANMU_TREE, Feature.TREE, createNanmuTree().build());
        register(context, REDWOOD_TREE, Feature.TREE, createRedWoodTree().build());
        register(context, GIANT_REDWOOD_TREE, Feature.TREE, createGiantRedWoodTree().build());
        register(context, WILLOW_TREE, Feature.TREE, createWillowTree().build());
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> bootstapContext, ResourceKey<ConfiguredFeature<?, ?>> resourceKey, F feature, FC featureConfig) {
        bootstapContext.register(resourceKey, new ConfiguredFeature<>(feature, featureConfig));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createNanmuTree() {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(NatureHorizonsBlocks.NANMU.getLog()), new StraightTrunkPlacer(7, 2, 1), BlockStateProvider.simple(NatureHorizonsBlocks.NANMU_LEAVES.get()), new NanmuFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createJapaneseMapleTree(Supplier<LeavesBlock> leavesBlock) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(NatureHorizonsBlocks.JAPANESE_MAPLE.getLog()), new FancyTrunkPlacer(8, 5, 0), BlockStateProvider.simple(leavesBlock.get()), new JapaneseMapleFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createRedWoodTree() {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(NatureHorizonsBlocks.REDWOOD.getLog()), new GiantTrunkPlacer(14, 10, 14), BlockStateProvider.simple(NatureHorizonsBlocks.REDWOOD_LEAVES.get()), new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(13, 17)), new TwoLayersFeatureSize(1, 1, 2)).decorators(ImmutableList.of(new AlterGroundDecorator(BlockStateProvider.simple(Blocks.PODZOL))));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createGiantRedWoodTree() {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(NatureHorizonsBlocks.REDWOOD.getLog()), new MegaGiantTrunkPlacer(20, 15, 24), BlockStateProvider.simple(NatureHorizonsBlocks.REDWOOD_LEAVES.get()), new MegaRedwoodFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), UniformInt.of(13, 16)), new TwoLayersFeatureSize(2, 1, 5)).decorators(ImmutableList.of(new AlterGroundDecorator(BlockStateProvider.simple(Blocks.PODZOL))));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createBalsaTree() {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(NatureHorizonsBlocks.BALSA.getLog()), new StraightTrunkPlacer(6, 3, 0), BlockStateProvider.simple(NatureHorizonsBlocks.BALSA_LEAVES.get()), new BalsaFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createBlackWalnutTree() {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(NatureHorizonsBlocks.BLACK_WALNUT.getLog()), new StraightTrunkPlacer(5, 2, 0), BlockStateProvider.simple(NatureHorizonsBlocks.BLACK_WALNUT_LEAVES.get()), new BlackWalnutFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createBlackwoodTree() {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(NatureHorizonsBlocks.BLACKWOOD.getLog()), new StraightTrunkPlacer(5, 2, 0), BlockStateProvider.simple(NatureHorizonsBlocks.BLACKWOOD_LEAVES.get()), new BlackwoodFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createIpeTree(Supplier<LeavesBlock> leave) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(NatureHorizonsBlocks.IPE.getLog()), new StraightTrunkPlacer(12, 2, 0), BlockStateProvider.simple(leave.get()), new IpeFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createMahoganyTree() {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(NatureHorizonsBlocks.MAHOGANY.getLog()), new StraightTrunkPlacer(10, 2, 1), BlockStateProvider.simple(NatureHorizonsBlocks.MAHOGANY_LEAVES.get()), new MahoganyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createAspenTree() {
        return createAspenTree(NatureHorizonsBlocks.ASPEN.getLog(), NatureHorizonsBlocks.ASPEN_LEAVES.get(), 5, 2, 0, 3).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createTallAspenTree() {
        return createTallAspenTree(NatureHorizonsBlocks.ASPEN.getLog(), NatureHorizonsBlocks.ASPEN_LEAVES.get(), 5, 2, 6, 3).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createJuniperTree() {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(NatureHorizonsBlocks.JUNIPER.getLog()), new StraightTrunkPlacer(7, 2, 2), BlockStateProvider.simple(NatureHorizonsBlocks.JUNIPER_LEAVES.get()), new JuniperFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createWillowTree() {
        return createWillowTreeBase(NatureHorizonsBlocks.WILLOW.getLog(), NatureHorizonsBlocks.WILLOW_LEAVES.get(), 5, 3, 0, 6).decorators(ImmutableList.of(new LeaveVineDecorator(0.25F)));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createWillowTreeBase(Block p_195147_, Block p_195148_, int p_195149_, int p_195150_, int p_195151_, int p_195152_) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(p_195147_), new FancyTrunkPlacer(p_195149_, p_195150_, p_195151_), BlockStateProvider.simple(p_195148_), new WillowFoliagePlacer(ConstantInt.of(p_195152_), ConstantInt.of(0), 6, 0.16666667F, 0.33333334F), new TwoLayersFeatureSize(1, 0, 1));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createAspenTree(Block p_195147_, Block p_195148_, int p_195149_, int p_195150_, int p_195151_, int p_195152_) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(p_195147_), new StraightTrunkPlacer(p_195149_, p_195150_, p_195151_), BlockStateProvider.simple(p_195148_), new AspenFoliagePlacer(ConstantInt.of(p_195152_), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 1));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createTallAspenTree(Block p_195147_, Block p_195148_, int p_195149_, int p_195150_, int p_195151_, int p_195152_) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(p_195147_), new StraightTrunkPlacer(p_195149_, p_195150_, p_195151_), BlockStateProvider.simple(p_195148_), new TallAspenFoliagePlacer(ConstantInt.of(p_195152_), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 1));
    }
}
