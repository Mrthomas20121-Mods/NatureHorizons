package mrthomas20121.nature_horizons.datagen;

import mrthomas20121.nature_horizons.NatureHorizons;
import mrthomas20121.nature_horizons.init.NatureHorizonsBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.List;
import java.util.OptionalInt;

public class NatureHorizonsConfiguredFeatures {

    public static ResourceKey<ConfiguredFeature<?, ?>> ASPEN_TREE = feature("aspen_tree");
    public static ResourceKey<ConfiguredFeature<?, ?>> TALL_ASPEN_TREE = feature("tall_aspen_tree");
    public static ResourceKey<ConfiguredFeature<?, ?>> ASPEN_TREE_BEE = feature("aspen_tree_bee");

    public static ResourceKey<ConfiguredFeature<?, ?>> BLACKWOOD_TREE = feature("blackwood_tree");
    public static ResourceKey<ConfiguredFeature<?, ?>> JUNIPER_TREE = feature("juniper_tree");

    private static ResourceKey<ConfiguredFeature<?, ?>> feature(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, NatureHorizons.getResource(name));
    }

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        BeehiveDecorator beehivedecorator = new BeehiveDecorator(0.002F);

        register(context, ASPEN_TREE, Feature.TREE, createAspenTree().build());
        register(context, TALL_ASPEN_TREE, Feature.TREE, createTallAspenTree().build());
        register(context, ASPEN_TREE_BEE, Feature.TREE, createAspenTree().decorators(List.of(beehivedecorator)).build());
        register(context, BLACKWOOD_TREE, Feature.TREE, createBlackWoodTree().build());
        register(context, JUNIPER_TREE, Feature.TREE, createJuniperTree().ignoreVines().build());

    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> p_256315_, ResourceKey<ConfiguredFeature<?, ?>> p_255983_, F p_255949_, FC p_256398_) {
        p_256315_.register(p_255983_, new ConfiguredFeature<>(p_255949_, p_256398_));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createBlackWoodTree() {
        return (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(NatureHorizonsBlocks.BLACKWOOD.getLog()), new FancyTrunkPlacer(3, 10, 0), BlockStateProvider.simple(NatureHorizonsBlocks.BLACKWOOD_LEAVES.get()), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(3), 3), new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty()))).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createAspenTree() {
        return createStraightBlobTree(NatureHorizonsBlocks.ASPEN.getLog(), NatureHorizonsBlocks.ASPEN_LEAVES.get(), 5, 2, 0, 2).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createTallAspenTree() {
        return createStraightBlobTree(NatureHorizonsBlocks.ASPEN.getLog(), NatureHorizonsBlocks.ASPEN_LEAVES.get(), 5, 2, 6, 2).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createJuniperTree() {
        return createStraightBlobTree(NatureHorizonsBlocks.JUNIPER.getLog(), NatureHorizonsBlocks.JUNIPER_LEAVES.get(), 4, 8, 0, 2);
    }

    private static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(Block p_195147_, Block p_195148_, int p_195149_, int p_195150_, int p_195151_, int p_195152_) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(p_195147_), new StraightTrunkPlacer(p_195149_, p_195150_, p_195151_), BlockStateProvider.simple(p_195148_), new BlobFoliagePlacer(ConstantInt.of(p_195152_), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1));
    }
}
