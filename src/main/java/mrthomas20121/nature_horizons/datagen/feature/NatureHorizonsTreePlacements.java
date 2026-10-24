package mrthomas20121.nature_horizons.datagen.feature;

import mrthomas20121.nature_horizons.init.NatureHorizonsBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;
import java.util.function.Supplier;

import static mrthomas20121.nature_horizons.datagen.feature.NatureHorizonsPlacedFeatures.feature;

public class NatureHorizonsTreePlacements {

    public static ResourceKey<PlacedFeature> ASPEN_CHECKED = feature("aspen_checked");
    public static ResourceKey<PlacedFeature> ASPEN_BEES_CHECKED = feature("aspen_bees_checked");
    public static ResourceKey<PlacedFeature> TALL_ASPEN_CHECKED = feature("tall_aspen_checked");
    public static ResourceKey<PlacedFeature> TALL_ASPEN_BEES_CHECKED = feature("tall_aspen_bees_checked");
    public static ResourceKey<PlacedFeature> BALSA_CHECKED = feature("balsa_checked");
    public static ResourceKey<PlacedFeature> BLACK_WALNUT_CHECKED = feature("black_walnut_checked");
    public static ResourceKey<PlacedFeature> BLACKWOOD_CHECKED = feature("blackwood_checked");
    public static ResourceKey<PlacedFeature> PINK_IPE_CHECKED = feature("pink_ipe_checked");
    public static ResourceKey<PlacedFeature> GOLDEN_IPE_CHECKED = feature("golden_ipe_checked");
    public static ResourceKey<PlacedFeature> WHITE_IPE_CHECKED = feature("white_ipe_checked");
    public static ResourceKey<PlacedFeature> JAPANESE_MAPLE_CHECKED = feature("japanese_maple_checked");
    public static ResourceKey<PlacedFeature> CRIMSON_JAPANESE_MAPLE_CHECKED = feature("crimson_japanese_maple_checked");
    public static ResourceKey<PlacedFeature> ORANGE_JAPANESE_MAPLE_CHECKED = feature("orange_japanese_maple_checked");
    public static ResourceKey<PlacedFeature> JUNIPER_CHECKED = feature("juniper_checked");
    public static ResourceKey<PlacedFeature> MAHOGANY_CHECKED = feature("mahogany_checked");
    public static ResourceKey<PlacedFeature> NANMU_CHECKED = feature("nanmu_checked");
    public static ResourceKey<PlacedFeature> REDWOOD_CHECKED = feature("redwood_checked");
    public static ResourceKey<PlacedFeature> GIANT_REDWOOD_CHECKED = feature("giant_redwood_checked");
    public static ResourceKey<PlacedFeature> WILLOW_CHECKED = feature("willow_checked");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> NANMU_TREE = holdergetter.getOrThrow(NatureHorizonsTreeFeatures.NANMU_TREE);
        Holder<ConfiguredFeature<?, ?>> ASPEN_TREE = holdergetter.getOrThrow(NatureHorizonsTreeFeatures.ASPEN_TREE);
        Holder<ConfiguredFeature<?, ?>> ASPEN_TREE_BEES = holdergetter.getOrThrow(NatureHorizonsTreeFeatures.ASPEN_TREE_BEES);
        Holder<ConfiguredFeature<?, ?>> TALL_ASPEN_TREE = holdergetter.getOrThrow(NatureHorizonsTreeFeatures.TALL_ASPEN_TREE);
        Holder<ConfiguredFeature<?, ?>> TALL_ASPEN_TREE_BEES = holdergetter.getOrThrow(NatureHorizonsTreeFeatures.TALL_ASPEN_TREE_BEES);
        Holder<ConfiguredFeature<?, ?>> BALSA_TREE = holdergetter.getOrThrow(NatureHorizonsTreeFeatures.BALSA_TREE);
        Holder<ConfiguredFeature<?, ?>> BLACK_WALNUT_TREE = holdergetter.getOrThrow(NatureHorizonsTreeFeatures.BLACK_WALNUT_TREE);
        Holder<ConfiguredFeature<?, ?>> BLACKWOOD_TREE = holdergetter.getOrThrow(NatureHorizonsTreeFeatures.BLACKWOOD_TREE);
        Holder<ConfiguredFeature<?, ?>> PINK_IPE_TREE = holdergetter.getOrThrow(NatureHorizonsTreeFeatures.PINK_IPE_TREE);
        Holder<ConfiguredFeature<?, ?>> GOLDEN_IPE_TREE = holdergetter.getOrThrow(NatureHorizonsTreeFeatures.GOLDEN_IPE_TREE);
        Holder<ConfiguredFeature<?, ?>> WHITE_IPE_TREE = holdergetter.getOrThrow(NatureHorizonsTreeFeatures.WHITE_IPE_TREE);
        Holder<ConfiguredFeature<?, ?>> JAPANESE_MAPLE_TREE = holdergetter.getOrThrow(NatureHorizonsTreeFeatures.JAPANESE_MAPLE_TREE);
        Holder<ConfiguredFeature<?, ?>> CRIMSON_JAPANESE_MAPLE_TREE = holdergetter.getOrThrow(NatureHorizonsTreeFeatures.CRIMSON_JAPANESE_MAPLE_TREE);
        Holder<ConfiguredFeature<?, ?>> ORANGE_JAPANESE_MAPLE_TREE = holdergetter.getOrThrow(NatureHorizonsTreeFeatures.ORANGE_JAPANESE_MAPLE_TREE);
        Holder<ConfiguredFeature<?, ?>> JUNIPER_TREE = holdergetter.getOrThrow(NatureHorizonsTreeFeatures.JUNIPER_TREE);
        Holder<ConfiguredFeature<?, ?>> MAHOGANY_TREE = holdergetter.getOrThrow(NatureHorizonsTreeFeatures.MAHOGANY_TREE);
        Holder<ConfiguredFeature<?, ?>> REDWOOD_TREE = holdergetter.getOrThrow(NatureHorizonsTreeFeatures.REDWOOD_TREE);
        Holder<ConfiguredFeature<?, ?>> GIANT_REDWOOD_TREE = holdergetter.getOrThrow(NatureHorizonsTreeFeatures.GIANT_REDWOOD_TREE);
        Holder<ConfiguredFeature<?, ?>> WILLOW_TREE = holdergetter.getOrThrow(NatureHorizonsTreeFeatures.WILLOW_TREE);

        registerSaplingCheck(context, ASPEN_CHECKED, ASPEN_TREE, NatureHorizonsBlocks.ASPEN_SAPLING);
        registerSaplingCheck(context, ASPEN_BEES_CHECKED, ASPEN_TREE_BEES, NatureHorizonsBlocks.ASPEN_SAPLING);
        registerSaplingCheck(context, TALL_ASPEN_CHECKED, TALL_ASPEN_TREE, NatureHorizonsBlocks.ASPEN_SAPLING);
        registerSaplingCheck(context, TALL_ASPEN_BEES_CHECKED, TALL_ASPEN_TREE_BEES, NatureHorizonsBlocks.ASPEN_SAPLING);
        registerSaplingCheck(context, BALSA_CHECKED, BALSA_TREE, NatureHorizonsBlocks.BALSA_SAPLING);
        registerSaplingCheck(context, BLACK_WALNUT_CHECKED, BLACK_WALNUT_TREE, NatureHorizonsBlocks.BLACK_WALNUT_SAPLING);
        registerSaplingCheck(context, BLACKWOOD_CHECKED, BLACKWOOD_TREE, NatureHorizonsBlocks.BLACKWOOD_SAPLING);
        registerSaplingCheck(context, PINK_IPE_CHECKED, PINK_IPE_TREE, NatureHorizonsBlocks.PINK_IPE_SAPLING);
        registerSaplingCheck(context, GOLDEN_IPE_CHECKED, GOLDEN_IPE_TREE, NatureHorizonsBlocks.GOLDEN_IPE_SAPLING);
        registerSaplingCheck(context, WHITE_IPE_CHECKED, WHITE_IPE_TREE, NatureHorizonsBlocks.WHITE_IPE_SAPLING);
        registerSaplingCheck(context, JAPANESE_MAPLE_CHECKED, JAPANESE_MAPLE_TREE, NatureHorizonsBlocks.JAPANESE_MAPLE_SAPLING);
        registerSaplingCheck(context, CRIMSON_JAPANESE_MAPLE_CHECKED, CRIMSON_JAPANESE_MAPLE_TREE, NatureHorizonsBlocks.CRIMSON_JAPANESE_MAPLE_SAPLING);
        registerSaplingCheck(context, ORANGE_JAPANESE_MAPLE_CHECKED, ORANGE_JAPANESE_MAPLE_TREE, NatureHorizonsBlocks.ORANGE_JAPANESE_MAPLE_SAPLING);
        registerSaplingCheck(context, JUNIPER_CHECKED, JUNIPER_TREE, NatureHorizonsBlocks.JUNIPER_SAPLING);
        registerSaplingCheck(context, MAHOGANY_CHECKED, MAHOGANY_TREE, NatureHorizonsBlocks.MAHOGANY_SAPLING);
        registerSaplingCheck(context, NANMU_CHECKED, NANMU_TREE, NatureHorizonsBlocks.NANMU_SAPLING);
        registerSaplingCheck(context, REDWOOD_CHECKED, REDWOOD_TREE, NatureHorizonsBlocks.REDWOOD_SAPLING);
        registerSaplingCheck(context, GIANT_REDWOOD_CHECKED, GIANT_REDWOOD_TREE, NatureHorizonsBlocks.REDWOOD_SAPLING);
        registerSaplingCheck(context, WILLOW_CHECKED, WILLOW_TREE, NatureHorizonsBlocks.WILLOW_SAPLING);
    }

    public static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> placedFeatureKey, Holder<ConfiguredFeature<?, ?>> configuredFeatureHolder, List<PlacementModifier> modifiers) {
        context.register(placedFeatureKey, new PlacedFeature(configuredFeatureHolder, List.copyOf(modifiers)));
    }

    public static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> placedFeatureResourceKey, Holder<ConfiguredFeature<?, ?>> configuredFeatureHolder, PlacementModifier... modifiers) {
        register(context, placedFeatureResourceKey, configuredFeatureHolder, List.of(modifiers));
    }

    private static void registerSaplingCheck(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> placedFeatureKey, Holder<ConfiguredFeature<?, ?>> configuredFeatureHolder, Supplier<? extends SaplingBlock> saplingBlockSupplier) {
        register(context, placedFeatureKey, configuredFeatureHolder, wouldSurviveSapling(saplingBlockSupplier));
    }

    private static PlacementModifier wouldSurviveSapling(Supplier<? extends SaplingBlock> saplingBlockSupplier) {
        return PlacementUtils.filteredByBlockSurvival(saplingBlockSupplier.get());
    }
}
