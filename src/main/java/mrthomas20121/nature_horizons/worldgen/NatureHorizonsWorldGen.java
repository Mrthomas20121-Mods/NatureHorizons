package mrthomas20121.nature_horizons.worldgen;

import com.terraformersmc.biolith.api.biome.BiomePlacement;
import com.terraformersmc.biolith.api.surface.SurfaceGeneration;
import mrthomas20121.nature_horizons.NatureHorizons;
import mrthomas20121.nature_horizons.init.NatureHorizonsBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;

import java.util.function.Supplier;

public class NatureHorizonsWorldGen {

    private static final SurfaceRules.RuleSource STONE = makeStateRule(Blocks.STONE);
    private static final Supplier<SurfaceRules.RuleSource> ROCKSALT = () -> makeStateRule(NatureHorizonsBlocks.ROCKSALT.get());

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }

    private static final Climate.Parameter FULL_RANGE = Climate.Parameter.span(-1.0F, 1.0F);

    public static void init() {

        //SurfaceGeneration.addOverworldSurfaceRules(NatureHorizons.getResource("salt_caves"), saltCaveRules());

        BiomePlacement.replaceOverworld(Biomes.BIRCH_FOREST, NatureHorizonsBiomes.ASPEN_FOREST, 0.325D);
        BiomePlacement.replaceOverworld(Biomes.OLD_GROWTH_BIRCH_FOREST, NatureHorizonsBiomes.OLD_GROWTH_ASPEN_FOREST, 0.325D);
        BiomePlacement.replaceOverworld(Biomes.FOREST, NatureHorizonsBiomes.JAPANESE_MAPLE_FOREST, 0.325D);
        BiomePlacement.replaceOverworld(Biomes.WINDSWEPT_FOREST, NatureHorizonsBiomes.JAPANESE_MAPLE_FOREST, 0.325D);
        BiomePlacement.replaceOverworld(Biomes.OLD_GROWTH_SPRUCE_TAIGA, NatureHorizonsBiomes.OLD_GROWTH_REDWOOD_TAIGA, 0.325D);
        BiomePlacement.replaceOverworld(Biomes.OLD_GROWTH_PINE_TAIGA, NatureHorizonsBiomes.OLD_GROWTH_REDWOOD_TAIGA, 0.325D);
        BiomePlacement.addOverworld(NatureHorizonsBiomes.SALT_CAVE, Climate.parameters(FULL_RANGE, Climate.Parameter.span(0F, 1F), Climate.Parameter.span(0.6F, 1F), FULL_RANGE, Climate.Parameter.span(0.2F, 0.9F), FULL_RANGE, 0.0f));
    }

    public static SurfaceRules.RuleSource saltCaveRules() {
        return SurfaceRules.ifTrue(SurfaceRules.isBiome(NatureHorizonsBiomes.SALT_CAVE),
                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.ICE, 0.5), ROCKSALT.get())
        );
    }
}
