package mrthomas20121.nature_horizons.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;

import java.util.HashSet;
import java.util.List;
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
        generator.addProvider(client, new NatureHorizonsItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(client, new NatureHorizonsLangProvider(packOutput));

        NatureHorizonsTags.Blocks blockTags = new NatureHorizonsTags.Blocks(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(server, blockTags);
        generator.addProvider(server, new NatureHorizonsTags.Items(packOutput, lookupProvider, blockTags.contentsGetter(), existingFileHelper));
        generator.addProvider(server, new NatureHorizonsRegistrySets(packOutput, lookupProvider));
        generator.addProvider(server, loot(packOutput));
        generator.addProvider(server, new NatureHorizonsRecipeProvider(packOutput));
    }

    public static LootTableProvider loot(PackOutput output) {
        return new LootTableProvider(output, new HashSet<>(), List.of(
                new LootTableProvider.SubProviderEntry(NatureHorizonsBlockLoot::new, LootContextParamSets.BLOCK)
        ));
    }
}
