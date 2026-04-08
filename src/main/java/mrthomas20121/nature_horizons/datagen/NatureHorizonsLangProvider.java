package mrthomas20121.nature_horizons.datagen;

import mrthomas20121.nature_horizons.NatureHorizons;
import mrthomas20121.nature_horizons.init.NatureHorizonsBlocks;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class NatureHorizonsLangProvider extends LanguageProvider {

    public NatureHorizonsLangProvider(PackOutput output) {
        super(output, NatureHorizons.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.nature_horizons.wood", "Nature Horizons Blocks");

        add(NatureHorizonsBlocks.ASPEN_LEAVES.get(), "Aspen Leaves");
        add(NatureHorizonsBlocks.ASPEN_SAPLING.get(), "Aspen Sapling");
        add(NatureHorizonsBlocks.BLACKWOOD_LEAVES.get(), "Blackwood Leaves");
        add(NatureHorizonsBlocks.BLACKWOOD_SAPLING.get(), "Blackwood Sapling");
        add(NatureHorizonsBlocks.JUNIPER_LEAVES.get(), "Juniper Leaves");
        add(NatureHorizonsBlocks.JUNIPER_SAPLING.get(), "Juniper Sapling");
        add(NatureHorizonsBlocks.PINE_LEAVES.get(), "Pine Leaves");
        add(NatureHorizonsBlocks.PINE_SAPLING.get(), "Pine Sapling");
    }
}
