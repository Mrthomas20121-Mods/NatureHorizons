package mrthomas20121.nature_horizons.datagen;

import mrthomas20121.nature_horizons.NatureHorizons;
import mrthomas20121.nature_horizons.init.NatureHorizonsItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class NatureHorizonsItemModelProvider extends ItemModelProvider {

    public NatureHorizonsItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, NatureHorizons.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(NatureHorizonsItems.JUNIPER_BERRY.get());
        basicItem(NatureHorizonsItems.GRILLED_JUNIPER_BERRY.get());
        basicItem(NatureHorizonsItems.GOLDEN_JUNIPER_BERRY.get());
    }
}
