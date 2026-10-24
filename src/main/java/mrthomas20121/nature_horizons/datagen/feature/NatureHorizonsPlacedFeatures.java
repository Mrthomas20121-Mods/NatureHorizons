package mrthomas20121.nature_horizons.datagen.feature;

import mrthomas20121.nature_horizons.NatureHorizons;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class NatureHorizonsPlacedFeatures {

    public static ResourceKey<PlacedFeature> feature(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, NatureHorizons.getResource(name));
    }

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        NatureHorizonsCavePlacements.bootstrap(context);
        NatureHorizonsTreePlacements.bootstrap(context);
        NatureHorizonsVegetationPlacements.bootstrap(context);
    }
}
