package mrthomas20121.nature_horizons.worldgen;

import com.terraformersmc.biolith.api.biome.BiomePlacement;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;

public class NatureHorizonsWorldGen {

    private static final Climate.Parameter FULL_RANGE = Climate.Parameter.span(-1.0F, 1.0F);

    public static void init() {

        BiomePlacement.replaceOverworld(Biomes.BIRCH_FOREST, NatureHorizonsBiomes.ASPEN_FOREST, 0.325D);
        BiomePlacement.replaceOverworld(Biomes.TAIGA, NatureHorizonsBiomes.ASPEN_FOREST, 0.325D);
        BiomePlacement.replaceOverworld(Biomes.OLD_GROWTH_BIRCH_FOREST, NatureHorizonsBiomes.OLD_GROWTH_ASPEN_FOREST, 0.325D);
        BiomePlacement.replaceOverworld(Biomes.OLD_GROWTH_SPRUCE_TAIGA, NatureHorizonsBiomes.OLD_GROWTH_REDWOOD_TAIGA, 0.325D);
        BiomePlacement.replaceOverworld(Biomes.OLD_GROWTH_PINE_TAIGA, NatureHorizonsBiomes.OLD_GROWTH_REDWOOD_TAIGA, 0.325D);
        BiomePlacement.replaceOverworld(Biomes.JUNGLE, NatureHorizonsBiomes.TROPICAL_FOREST, 0.325D);
        BiomePlacement.replaceOverworld(Biomes.DARK_FOREST, NatureHorizonsBiomes.WOODLAND, 0.325D);
        BiomePlacement.addOverworld(NatureHorizonsBiomes.SALT_CAVE, Climate.parameters(FULL_RANGE, Climate.Parameter.span(0F, 1F), Climate.Parameter.span(0.6F, 1F), FULL_RANGE, Climate.Parameter.span(0.2F, 0.9F), FULL_RANGE, 0.0f));
    }
}
