package mrthomas20121.nature_horizons.worldgen;

import com.terraformersmc.biolith.api.biome.BiomePlacement;
import net.minecraft.world.level.biome.Biomes;

public class NatureHorizonsWorldGen {

    public static void init() {

        BiomePlacement.replaceOverworld(Biomes.FOREST, NatureHorizonsBiomes.ASPEN_FOREST, 0.1f);
        BiomePlacement.replaceOverworld(Biomes.BIRCH_FOREST, NatureHorizonsBiomes.ASPEN_FOREST, 0.3f);
        BiomePlacement.replaceOverworld(Biomes.OLD_GROWTH_BIRCH_FOREST, NatureHorizonsBiomes.OLD_GROWTH_ASPEN_FOREST, 0.3f);
    }
}
