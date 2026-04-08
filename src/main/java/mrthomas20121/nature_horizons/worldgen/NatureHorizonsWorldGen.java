package mrthomas20121.nature_horizons.worldgen;

import com.terraformersmc.biolith.api.biome.BiomePlacement;
import com.terraformersmc.biolith.api.biome.SubBiomeMatcher;
import net.minecraft.world.level.biome.Biomes;

public class NatureHorizonsWorldGen {

    public static void init() {

        BiomePlacement.addSubOverworld(Biomes.BIRCH_FOREST, NatureHorizonsBiomes.ASPEN_FOREST, SubBiomeMatcher.of(SubBiomeMatcher.NEAR_INTERIOR));
        BiomePlacement.addSubOverworld(Biomes.OLD_GROWTH_BIRCH_FOREST, NatureHorizonsBiomes.OLD_GROWTH_ASPEN_FOREST, SubBiomeMatcher.of(SubBiomeMatcher.NEAR_INTERIOR));
    }
}
