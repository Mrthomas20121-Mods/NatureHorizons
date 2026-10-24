package mrthomas20121.nature_horizons.datagen.feature;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

import static mrthomas20121.nature_horizons.datagen.feature.NatureHorizonsConfiguredFeatures.feature;

public class NatureHorizonsVegetationFeatures {

    public static ResourceKey<ConfiguredFeature<? , ?>> TREES_WOODLAND = feature("trees_woodland");
    public static ResourceKey<ConfiguredFeature<? , ?>> TREES_TROPICAL_FOREST = feature("trees_tropical_forest");
    public static ResourceKey<ConfiguredFeature<? , ?>> TREES_ASPEN_FOREST = feature("trees_aspen_forest");
    public static ResourceKey<ConfiguredFeature<? , ?>> TREES_OLD_GROWTH_ASPEN_FOREST = feature("trees_old_growth_aspen_forest");
    public static ResourceKey<ConfiguredFeature<? , ?>> TREES_OLD_GROWTH_REDWOOD_TAIGA = feature("trees_old_growth_redwood_taiga");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<PlacedFeature> placedFeatureHolderGetter = context.lookup(Registries.PLACED_FEATURE);

        Holder<PlacedFeature> NANMU = placedFeatureHolderGetter.getOrThrow(NatureHorizonsTreePlacements.NANMU_CHECKED);
        Holder<PlacedFeature> ASPEN = placedFeatureHolderGetter.getOrThrow(NatureHorizonsTreePlacements.ASPEN_CHECKED);
        Holder<PlacedFeature> ASPEN_BEES = placedFeatureHolderGetter.getOrThrow(NatureHorizonsTreePlacements.ASPEN_BEES_CHECKED);
        Holder<PlacedFeature> TALL_ASPEN = placedFeatureHolderGetter.getOrThrow(NatureHorizonsTreePlacements.TALL_ASPEN_CHECKED);
        Holder<PlacedFeature> TALL_ASPEN_BEES = placedFeatureHolderGetter.getOrThrow(NatureHorizonsTreePlacements.TALL_ASPEN_BEES_CHECKED);
        Holder<PlacedFeature> BALSA = placedFeatureHolderGetter.getOrThrow(NatureHorizonsTreePlacements.BALSA_CHECKED);
        Holder<PlacedFeature> BLACK_WALNUT = placedFeatureHolderGetter.getOrThrow(NatureHorizonsTreePlacements.BLACK_WALNUT_CHECKED);
        Holder<PlacedFeature> PINK_IPE = placedFeatureHolderGetter.getOrThrow(NatureHorizonsTreePlacements.PINK_IPE_CHECKED);
        Holder<PlacedFeature> GOLDEN_IPE = placedFeatureHolderGetter.getOrThrow(NatureHorizonsTreePlacements.GOLDEN_IPE_CHECKED);
        Holder<PlacedFeature> WHITE_IPE = placedFeatureHolderGetter.getOrThrow(NatureHorizonsTreePlacements.WHITE_IPE_CHECKED);
        Holder<PlacedFeature> JAPANESE_MAPLE = placedFeatureHolderGetter.getOrThrow(NatureHorizonsTreePlacements.JAPANESE_MAPLE_CHECKED);
        Holder<PlacedFeature> CRIMSON_JAPANESE_MAPLE = placedFeatureHolderGetter.getOrThrow(NatureHorizonsTreePlacements.CRIMSON_JAPANESE_MAPLE_CHECKED);
        Holder<PlacedFeature> ORANGE_JAPANESE_MAPLE = placedFeatureHolderGetter.getOrThrow(NatureHorizonsTreePlacements.ORANGE_JAPANESE_MAPLE_CHECKED);
        Holder<PlacedFeature> JUNIPER = placedFeatureHolderGetter.getOrThrow(NatureHorizonsTreePlacements.JUNIPER_CHECKED);
        Holder<PlacedFeature> MAHOGANY = placedFeatureHolderGetter.getOrThrow(NatureHorizonsTreePlacements.MAHOGANY_CHECKED);
        Holder<PlacedFeature> REDWOOD = placedFeatureHolderGetter.getOrThrow(NatureHorizonsTreePlacements.REDWOOD_CHECKED);
        Holder<PlacedFeature> GIANT_REDWOOD = placedFeatureHolderGetter.getOrThrow(NatureHorizonsTreePlacements.GIANT_REDWOOD_CHECKED);
        Holder<PlacedFeature> PINE = placedFeatureHolderGetter.getOrThrow(TreePlacements.PINE_CHECKED);
        Holder<PlacedFeature> JUNGLE_BUSH = placedFeatureHolderGetter.getOrThrow(TreePlacements.JUNGLE_BUSH);

        register(context, TREES_ASPEN_FOREST, Feature.RANDOM_SELECTOR, randomFeatureConfig(ASPEN, weightedPlacedFeature(BLACK_WALNUT, 0.2f), weightedPlacedFeature(ASPEN_BEES, 0.1f)));
        register(context, TREES_OLD_GROWTH_ASPEN_FOREST, Feature.RANDOM_SELECTOR, randomFeatureConfig(TALL_ASPEN, weightedPlacedFeature(TALL_ASPEN_BEES, 0.1f), weightedPlacedFeature(JUNIPER, 0.1f)));
        register(context, TREES_WOODLAND, Feature.RANDOM_SELECTOR, randomFeatureConfig(NANMU, weightedPlacedFeature(JAPANESE_MAPLE, 0.5f), weightedPlacedFeature(ORANGE_JAPANESE_MAPLE, 0.3f), weightedPlacedFeature(CRIMSON_JAPANESE_MAPLE, 0.2f)));
        register(context, TREES_TROPICAL_FOREST, Feature.RANDOM_SELECTOR, randomFeatureConfig(BALSA, weightedPlacedFeature(MAHOGANY, 0.8f), weightedPlacedFeature(WHITE_IPE, 0.4f), weightedPlacedFeature(PINK_IPE, 0.1f), weightedPlacedFeature(GOLDEN_IPE, 0.1f)));
        register(context, TREES_OLD_GROWTH_REDWOOD_TAIGA, Feature.RANDOM_SELECTOR, randomFeatureConfig(REDWOOD, weightedPlacedFeature(GIANT_REDWOOD, 0.1f), weightedPlacedFeature(PINE, 0.1f)));
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> bootstapContext, ResourceKey<ConfiguredFeature<?, ?>> resourceKey, F feature, FC featureConfig) {
        bootstapContext.register(resourceKey, new ConfiguredFeature<>(feature, featureConfig));
    }

    private static WeightedPlacedFeature weightedPlacedFeature(Holder<PlacedFeature> feature, float weight) {
        return new WeightedPlacedFeature(feature, weight);
    }

    private static RandomFeatureConfiguration randomFeatureConfig(Holder<PlacedFeature> feature, WeightedPlacedFeature... others) {
        return new RandomFeatureConfiguration(List.of(others), feature);
    }
}
