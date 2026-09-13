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

        basicItem(NatureHorizonsItems.HARD_WALNUT.get());
        basicItem(NatureHorizonsItems.WALNUT.get());
        basicItem(NatureHorizonsItems.ROASTED_WALNUT.get());
        basicItem(NatureHorizonsItems.GOLDEN_WALNUT.get());

        basicItem(NatureHorizonsItems.ASPEN_BOAT.get());
        basicItem(NatureHorizonsItems.ASPEN_CHEST_BOAT.get());
        basicItem(NatureHorizonsItems.BLACK_WALNUT_BOAT.get());
        basicItem(NatureHorizonsItems.BLACK_WALNUT_CHEST_BOAT.get());
        basicItem(NatureHorizonsItems.BLACKWOOD_BOAT.get());
        basicItem(NatureHorizonsItems.BLACKWOOD_CHEST_BOAT.get());
        basicItem(NatureHorizonsItems.JAPANESE_MAPLE_BOAT.get());
        basicItem(NatureHorizonsItems.JAPANESE_MAPLE_CHEST_BOAT.get());
        basicItem(NatureHorizonsItems.JUNIPER_BOAT.get());
        basicItem(NatureHorizonsItems.JUNIPER_CHEST_BOAT.get());
        basicItem(NatureHorizonsItems.AURIC_BOAT.get());
        basicItem(NatureHorizonsItems.AURIC_CHEST_BOAT.get());
        basicItem(NatureHorizonsItems.PINE_BOAT.get());
        basicItem(NatureHorizonsItems.PINE_CHEST_BOAT.get());
        basicItem(NatureHorizonsItems.REDWOOD_BOAT.get());
        basicItem(NatureHorizonsItems.REDWOOD_CHEST_BOAT.get());
    }
}
