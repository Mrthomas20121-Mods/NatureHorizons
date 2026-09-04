package mrthomas20121.nature_horizons.datagen;

import mrthomas20121.nature_horizons.NatureHorizons;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class NatureHorizonsBiomeModifierProvider {

    public static ResourceKey<BiomeModifier> REMOVE_OAK_BADLANDS = modifier("remove_oak_badlands");
    public static ResourceKey<BiomeModifier> BADLANDS_JUNIPER = modifier("badlands_juniper");

    private static ResourceKey<BiomeModifier> modifier(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, NatureHorizons.getResource(name));
    }

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        HolderGetter<Biome> biomeHolderGetter = context.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> featureHolderGetter = context.lookup(Registries.PLACED_FEATURE);

        context.register(REMOVE_OAK_BADLANDS, ForgeBiomeModifiers.RemoveFeaturesBiomeModifier.allSteps(
                biomeHolderGetter.getOrThrow(BiomeTags.IS_BADLANDS),
                HolderSet.direct(featureHolderGetter.getOrThrow(VegetationPlacements.TREES_BADLANDS))));

        context.register(BADLANDS_JUNIPER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomeHolderGetter.getOrThrow(BiomeTags.IS_BADLANDS),
                HolderSet.direct(featureHolderGetter.getOrThrow(NatureHorizonsPlacedFeatures.JUNIPER_TREE)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
    }
}
