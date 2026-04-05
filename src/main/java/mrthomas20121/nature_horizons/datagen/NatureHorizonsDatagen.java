package mrthomas20121.nature_horizons.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

public class NatureHorizonsDatagen {

    public static void init(GatherDataEvent event) {

        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        boolean client = event.includeClient();
        boolean server = event.includeServer();

        generator.addProvider(client, new NatureHorizonsBlockstateProvider(packOutput, existingFileHelper));

        generator.addProvider(server, new NatureHorizonsTags.Blocks(packOutput, lookupProvider, existingFileHelper));
    }
}
