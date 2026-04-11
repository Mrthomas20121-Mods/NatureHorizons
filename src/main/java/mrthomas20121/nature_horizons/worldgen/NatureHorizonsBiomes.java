package mrthomas20121.nature_horizons.worldgen;

import mrthomas20121.nature_horizons.NatureHorizons;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

public class NatureHorizonsBiomes {

    public static ResourceKey<Biome> ASPEN_FOREST = biome("aspen_forest");
    public static ResourceKey<Biome> OLD_GROWTH_ASPEN_FOREST = biome("old_growth_aspen_forest");
    public static ResourceKey<Biome> OLD_GROWTH_REDWOOD_TAIGA = biome("old_growth_redwood_taiga");

    private static ResourceKey<Biome> biome(String name) {
        return ResourceKey.create(Registries.BIOME, NatureHorizons.getResource(name));
    }
}
