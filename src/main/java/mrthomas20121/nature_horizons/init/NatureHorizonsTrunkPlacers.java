package mrthomas20121.nature_horizons.init;

import mrthomas20121.nature_horizons.NatureHorizons;
import mrthomas20121.nature_horizons.worldgen.feature.trunkplacers.MegaGiantTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class NatureHorizonsTrunkPlacers {

    public static DeferredRegister<TrunkPlacerType<?>> FOLIAGE_PLACERS = DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, NatureHorizons.MOD_ID);

    public static RegistryObject<TrunkPlacerType<MegaGiantTrunkPlacer>> MEGA_GIANT_TRUNK_PLACER = FOLIAGE_PLACERS.register("mega_giant_trunk_placer", () -> new TrunkPlacerType<>(MegaGiantTrunkPlacer.CODEC));
}
