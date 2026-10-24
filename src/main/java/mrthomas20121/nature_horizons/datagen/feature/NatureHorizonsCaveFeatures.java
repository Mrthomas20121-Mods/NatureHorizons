package mrthomas20121.nature_horizons.datagen.feature;

import mrthomas20121.nature_horizons.NatureHorizons;
import mrthomas20121.nature_horizons.init.NatureHorizonsBlocks;
import mrthomas20121.nature_horizons.init.NatureHorizonsFeatures;
import mrthomas20121.nature_horizons.worldgen.feature.foliageplacers.*;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;
import static mrthomas20121.nature_horizons.datagen.feature.NatureHorizonsConfiguredFeatures.feature;

public class NatureHorizonsCaveFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_ROCKSALT = feature("large_rocksalt");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ROCKSALT_CEILING = feature("rocksalt_ceiling");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ROCKSALT_PATCH = feature("rocksalt_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CALCITE = feature("calcite");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DIORITE = feature("diorite");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
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
        register(context, LARGE_ROCKSALT, NatureHorizonsFeatures.LARGE_ROCKSALT.get(), new LargeDripstoneConfiguration(30, UniformInt.of(3, 15), UniformFloat.of(0.4F, 2.0F), 0.33F, UniformFloat.of(0.3F, 0.9F), UniformFloat.of(0.4F, 1.0F), UniformFloat.of(0.0F, 0.4F), 4, 0.6F));
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> bootstapContext, ResourceKey<ConfiguredFeature<?, ?>> resourceKey, F feature, FC featureConfig) {
        bootstapContext.register(resourceKey, new ConfiguredFeature<>(feature, featureConfig));
    }
}
