package mrthomas20121.nature_horizons.init;

import mrthomas20121.nature_horizons.NatureHorizons;
import mrthomas20121.nature_horizons.worldgen.LargeRocksaltFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LargeDripstoneFeature;
import net.minecraft.world.level.levelgen.feature.configurations.LargeDripstoneConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class NatureHorizonsFeatures {

    public static DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, NatureHorizons.MOD_ID);

    public static RegistryObject<LargeRocksaltFeature> LARGE_ROCKSALT = FEATURES.register("large_rocksalt", () -> new LargeRocksaltFeature(LargeDripstoneConfiguration.CODEC));
}
