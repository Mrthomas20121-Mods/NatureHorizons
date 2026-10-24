package mrthomas20121.nature_horizons.datagen.feature;

import mrthomas20121.nature_horizons.NatureHorizons;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class NatureHorizonsConfiguredFeatures {

    public static ResourceKey<ConfiguredFeature<?, ?>> feature(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, NatureHorizons.getResource(name));
    }

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        NatureHorizonsCaveFeatures.bootstrap(context);
        NatureHorizonsTreeFeatures.bootstrap(context);
        NatureHorizonsVegetationFeatures.bootstrap(context);
    }
}
