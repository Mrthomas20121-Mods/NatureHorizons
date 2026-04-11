package mrthomas20121.nature_horizons.datagen;

import mrthomas20121.nature_horizons.worldgen.NatureHorizonsBiomes;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import javax.annotation.Nullable;

public class NatureHorizonsBiomeProvider {

    public static void bootstrap(BootstapContext<Biome> context) {
        HolderGetter<PlacedFeature> placedFeatureHolderGetter = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarverHolderGetter = context.lookup(Registries.CONFIGURED_CARVER);
        context.register(NatureHorizonsBiomes.ASPEN_FOREST, aspenForest(placedFeatureHolderGetter, configuredWorldCarverHolderGetter, false));
        context.register(NatureHorizonsBiomes.OLD_GROWTH_ASPEN_FOREST, aspenForest(placedFeatureHolderGetter, configuredWorldCarverHolderGetter, true));
        context.register(NatureHorizonsBiomes.OLD_GROWTH_REDWOOD_TAIGA, oldGrowthTaiga(placedFeatureHolderGetter, configuredWorldCarverHolderGetter));
    }

    public static Biome oldGrowthTaiga(HolderGetter<PlacedFeature> p_255849_, HolderGetter<ConfiguredWorldCarver<?>> p_256578_) {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.farmAnimals(mobspawnsettings$builder);
        mobspawnsettings$builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4));
        mobspawnsettings$builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));
        mobspawnsettings$builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
        BiomeDefaultFeatures.commonSpawns(mobspawnsettings$builder);

        BiomeGenerationSettings.Builder biomegenerationsettings$builder = new BiomeGenerationSettings.Builder(p_255849_, p_256578_);
        globalOverworldGeneration(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addMossyStoneBlock(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addFerns(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        biomegenerationsettings$builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NatureHorizonsPlacedFeatures.OLD_GROWTH_REDWOOD_TAIGA);
        BiomeDefaultFeatures.addDefaultFlowers(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addGiantTaigaVegetation(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addCommonBerryBushes(biomegenerationsettings$builder);
        Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_OLD_GROWTH_TAIGA);
        return biome(true, 0.25F, 0.8F, mobspawnsettings$builder, biomegenerationsettings$builder, music);
    }

    private static Biome aspenForest(HolderGetter<PlacedFeature> p_255788_, HolderGetter<ConfiguredWorldCarver<?>> p_256461_, boolean tallAspen) {
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = new BiomeGenerationSettings.Builder(p_255788_, p_256461_);
        globalOverworldGeneration(biomegenerationsettings$builder);
        Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FOREST);
        BiomeDefaultFeatures.addForestFlowers(biomegenerationsettings$builder);

        BiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        if (tallAspen) {
            biomegenerationsettings$builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NatureHorizonsPlacedFeatures.TALL_ASPEN_TREE);
        } else {
            biomegenerationsettings$builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NatureHorizonsPlacedFeatures.ASPEN_FOREST_TREES);
        }

        BiomeDefaultFeatures.addDefaultFlowers(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addForestGrass(biomegenerationsettings$builder);

        BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomegenerationsettings$builder);
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.farmAnimals(mobspawnsettings$builder);
        BiomeDefaultFeatures.commonSpawns(mobspawnsettings$builder);

        return biome(true, 0.6f, 0.6F, mobspawnsettings$builder, biomegenerationsettings$builder, music);
    }

    private static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }

    protected static int calculateSkyColor(float p_194844_) {
        float $$1 = p_194844_ / 3.0F;
        $$1 = Mth.clamp($$1, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
    }

    private static Biome biome(boolean p_265746_, float p_265800_, float p_265276_, MobSpawnSettings.Builder p_265425_, BiomeGenerationSettings.Builder p_265371_, @Nullable Music p_265636_) {
        return biome(p_265746_, p_265800_, p_265276_, 4159204, 329011, 13884799, null, p_265425_, p_265371_, p_265636_);
    }

    private static Biome biome(boolean p_273483_, float p_272621_, float p_273588_, int p_273605_, int p_272756_, @Nullable Integer p_272889_, @Nullable Integer p_272657_, MobSpawnSettings.Builder p_273300_, BiomeGenerationSettings.Builder p_272700_, @Nullable Music p_272996_) {
        BiomeSpecialEffects.Builder biomespecialeffects$builder = (new BiomeSpecialEffects.Builder()).waterColor(p_273605_).waterFogColor(p_272756_).fogColor(12638463).skyColor(calculateSkyColor(p_272621_)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(p_272996_);
        if (p_272889_ != null) {
            biomespecialeffects$builder.grassColorOverride(p_272889_);
        }

        if (p_272657_ != null) {
            biomespecialeffects$builder.foliageColorOverride(p_272657_);
        }

        return (new Biome.BiomeBuilder()).hasPrecipitation(p_273483_).temperature(p_272621_).downfall(p_273588_).specialEffects(biomespecialeffects$builder.build()).mobSpawnSettings(p_273300_.build()).generationSettings(p_272700_.build()).build();
    }
}
