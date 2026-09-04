package mrthomas20121.nature_horizons.worldgen;

import com.terraformersmc.biolith.api.biome.BiomePlacement;
import com.terraformersmc.biolith.api.biome.SubBiomeMatcher;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;

public class NatureHorizonsWorldGen {

    private static final Climate.Parameter FULL_RANGE = Climate.Parameter.span(-1.0F, 1.0F);

    public static void init() {

        BiomePlacement.replaceOverworld(Biomes.BIRCH_FOREST, NatureHorizonsBiomes.ASPEN_FOREST, 0.325D);
        BiomePlacement.replaceOverworld(Biomes.OLD_GROWTH_BIRCH_FOREST, NatureHorizonsBiomes.OLD_GROWTH_ASPEN_FOREST, 0.325D);
        BiomePlacement.replaceOverworld(Biomes.FOREST, NatureHorizonsBiomes.JAPANESE_MAPLE_FOREST, 0.325D);
        BiomePlacement.replaceOverworld(Biomes.WINDSWEPT_FOREST, NatureHorizonsBiomes.JAPANESE_MAPLE_FOREST, 0.325D);
        BiomePlacement.replaceOverworld(Biomes.OLD_GROWTH_SPRUCE_TAIGA, NatureHorizonsBiomes.OLD_GROWTH_REDWOOD_TAIGA, 0.325D);
        BiomePlacement.replaceOverworld(Biomes.OLD_GROWTH_PINE_TAIGA, NatureHorizonsBiomes.OLD_GROWTH_REDWOOD_TAIGA, 0.325D);
    }
}
