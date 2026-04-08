package mrthomas20121.nature_horizons.datagen;

import mrthomas20121.nature_horizons.NatureHorizons;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class NatureHorizonsRegistrySets extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
        .add(Registries.CONFIGURED_FEATURE, NatureHorizonsConfiguredFeatures::bootstrap)
        .add(Registries.PLACED_FEATURE, NatureHorizonsPlacedFeatures::bootstrap)
        .add(Registries.BIOME, NatureHorizonsBiomeProvider::bootstrap)
        .add(ForgeRegistries.Keys.BIOME_MODIFIERS, NatureHorizonsBiomeModifierProvider::bootstrap);

    public NatureHorizonsRegistrySets(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(NatureHorizons.MOD_ID));
    }
}
