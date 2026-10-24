package mrthomas20121.nature_horizons.init;

import mrthomas20121.nature_horizons.NatureHorizons;
import mrthomas20121.nature_horizons.worldgen.feature.foliageplacers.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class NatureHorizonsFoliagePlacers {

    public static DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS = DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, NatureHorizons.MOD_ID);

    public static RegistryObject<FoliagePlacerType<MegaRedwoodFoliagePlacer>> MEGA_REDWOOD = FOLIAGE_PLACERS.register("mega_redwood_foliage_placer", () -> new FoliagePlacerType<>(MegaRedwoodFoliagePlacer.CODEC));
    public static RegistryObject<FoliagePlacerType<WillowFoliagePlacer>> WILLOW_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("willow_foliage_placer", () -> new FoliagePlacerType<>(WillowFoliagePlacer.CODEC));
    public static RegistryObject<FoliagePlacerType<BalsaFoliagePlacer>> BALSA_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("balsa_foliage_placer", () -> new FoliagePlacerType<>(BalsaFoliagePlacer.CODEC));
    public static RegistryObject<FoliagePlacerType<AspenFoliagePlacer>> ASPEN_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("aspen_foliage_placer", () -> new FoliagePlacerType<>(AspenFoliagePlacer.CODEC));
    public static RegistryObject<FoliagePlacerType<TallAspenFoliagePlacer>> TALL_ASPEN_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("tall_aspen_foliage_placer", () -> new FoliagePlacerType<>(TallAspenFoliagePlacer.CODEC));
    public static RegistryObject<FoliagePlacerType<BlackwoodFoliagePlacer>> BLACKWOOD_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("blackwood_foliage_placer", () -> new FoliagePlacerType<>(BlackwoodFoliagePlacer.CODEC));
    public static RegistryObject<FoliagePlacerType<BlackWalnutFoliagePlacer>> BLACK_WALNUT_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("black_walnut_foliage_placer", () -> new FoliagePlacerType<>(BlackWalnutFoliagePlacer.CODEC));
    public static RegistryObject<FoliagePlacerType<IpeFoliagePlacer>> IPE_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("ipe_foliage_placer", () -> new FoliagePlacerType<>(IpeFoliagePlacer.CODEC));
    public static RegistryObject<FoliagePlacerType<JapaneseMapleFoliagePlacer>> JAPANESE_MAPLE_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("japanese_maple_foliage_placer", () -> new FoliagePlacerType<>(JapaneseMapleFoliagePlacer.CODEC));
    public static RegistryObject<FoliagePlacerType<JuniperFoliagePlacer>> JUNIPER_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("juniper_foliage_placer", () -> new FoliagePlacerType<>(JuniperFoliagePlacer.CODEC));
    public static RegistryObject<FoliagePlacerType<MahoganyFoliagePlacer>> MAHOGANY_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("mahogany_foliage_placer", () -> new FoliagePlacerType<>(MahoganyFoliagePlacer.CODEC));
    public static RegistryObject<FoliagePlacerType<NanmuFoliagePlacer>> NANMU_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("nanmu_foliage_placer", () -> new FoliagePlacerType<>(NanmuFoliagePlacer.CODEC));
}
