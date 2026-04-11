package mrthomas20121.nature_horizons.datagen;

import mrthomas20121.nature_horizons.NatureHorizons;
import mrthomas20121.nature_horizons.init.NatureHorizonsBlocks;
import mrthomas20121.nature_horizons.init.NatureHorizonsEntityTypes;
import mrthomas20121.nature_horizons.init.NatureHorizonsItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import slimeknights.mantle.registration.object.WoodBlockObject;

public class NatureHorizonsLangProvider extends LanguageProvider {

    public NatureHorizonsLangProvider(PackOutput output) {
        super(output, NatureHorizons.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.nature_horizons.wood", "Nature Horizons Blocks");

        add("item.nature_horizons.hard_walnut_item.tooltip", "Right click on a hard block to open");

        wood(NatureHorizonsBlocks.ASPEN, "Aspen");
        wood(NatureHorizonsBlocks.BLACK_WALNUT, "Black Walnut");
        wood(NatureHorizonsBlocks.BLACKWOOD, "Blackwood");
        wood(NatureHorizonsBlocks.JUNIPER, "Juniper");
        wood(NatureHorizonsBlocks.PINE, "Pine");

        add(NatureHorizonsBlocks.ASPEN_LEAVES.get(), "Aspen Leaves");
        add(NatureHorizonsBlocks.ASPEN_SAPLING.get(), "Aspen Sapling");
        add(NatureHorizonsBlocks.BLACK_WALNUT_LEAVES.get(), "Black Walnut Leaves");
        add(NatureHorizonsBlocks.BLACK_WALNUT_SAPLING.get(), "Black Walnut Sapling");
        add(NatureHorizonsBlocks.BLACKWOOD_LEAVES.get(), "Blackwood Leaves");
        add(NatureHorizonsBlocks.BLACKWOOD_SAPLING.get(), "Blackwood Sapling");
        add(NatureHorizonsBlocks.JUNIPER_LEAVES.get(), "Juniper Leaves");
        add(NatureHorizonsBlocks.JUNIPER_SAPLING.get(), "Juniper Sapling");
        add(NatureHorizonsBlocks.PINE_LEAVES.get(), "Pine Leaves");
        add(NatureHorizonsBlocks.PINE_SAPLING.get(), "Pine Sapling");

        addItem(NatureHorizonsItems.HARD_WALNUT, "Hard Walnut");
        addItem(NatureHorizonsItems.WALNUT, "Walnut");
        addItem(NatureHorizonsItems.ROASTED_WALNUT, "Roasted Walnut");
        addItem(NatureHorizonsItems.GOLDEN_WALNUT, "Golden Walnut");
        addItem(NatureHorizonsItems.JUNIPER_BERRY, "Juniper Berry");
        addItem(NatureHorizonsItems.GRILLED_JUNIPER_BERRY, "Grilled Juniper Berry");
        addItem(NatureHorizonsItems.GOLDEN_JUNIPER_BERRY, "Golden Juniper Berry");
        addItem(NatureHorizonsItems.ASPEN_BOAT, "Aspen Boat");
        addItem(NatureHorizonsItems.ASPEN_CHEST_BOAT, "Aspen Chest Boat");
        addItem(NatureHorizonsItems.BLACK_WALNUT_BOAT, "Black Walnut Boat");
        addItem(NatureHorizonsItems.BLACK_WALNUT_CHEST_BOAT, "Black Walnut Chest Boat");
        addItem(NatureHorizonsItems.BLACKWOOD_BOAT, "Blackwood Boat");
        addItem(NatureHorizonsItems.BLACKWOOD_CHEST_BOAT, "Blackwood Chest Boat");
        addItem(NatureHorizonsItems.JUNIPER_BOAT, "Juniper Boat");
        addItem(NatureHorizonsItems.JUNIPER_CHEST_BOAT, "Juniper Chest Boat");
        addItem(NatureHorizonsItems.PINE_BOAT, "Pine Boat");
        addItem(NatureHorizonsItems.PINE_CHEST_BOAT, "Pine Chest Boat");

        addEntityType(NatureHorizonsEntityTypes.ASPEN_BOAT, "Aspen Boat");
        addEntityType(NatureHorizonsEntityTypes.ASPEN_CHEST_BOAT, "Aspen Chest Boat");
        addEntityType(NatureHorizonsEntityTypes.BLACK_WALNUT_BOAT, "Black Walnut Boat");
        addEntityType(NatureHorizonsEntityTypes.BLACK_WALNUT_CHEST_BOAT, "Black Walnut Chest Boat");
        addEntityType(NatureHorizonsEntityTypes.BLACKWOOD_BOAT, "Blackwood Boat");
        addEntityType(NatureHorizonsEntityTypes.BLACKWOOD_CHEST_BOAT, "Blackwood Chest Boat");
        addEntityType(NatureHorizonsEntityTypes.JUNIPER_BOAT, "Juniper Boat");
        addEntityType(NatureHorizonsEntityTypes.JUNIPER_CHEST_BOAT, "Juniper Chest Boat");
        addEntityType(NatureHorizonsEntityTypes.PINE_BOAT, "Pine Boat");
        addEntityType(NatureHorizonsEntityTypes.PINE_CHEST_BOAT, "Pine Chest Boat");
    }

    private void wood(WoodBlockObject wood, String name) {
        add(wood.get(), name + " Planks");
        add(wood.getButton(), name + " Buttons");
        add(wood.getPressurePlate(), name + " Pressure Plate");
        add(wood.getDoor(), name + " Door");
        add(wood.getTrapdoor(), name + " Trapdoor");
        add(wood.getFence(), name + " Fence");
        add(wood.getFenceGate(), name + " Fence Gate");
        add(wood.getSign(), name + " Sign");
        add(wood.getHangingSign(), name + " Hanging Sign");
        add(wood.getLog(), name +  " Log");
        add(wood.getStrippedLog(), "Stripped " +name + " Log");
        add(wood.getWood(), name +  " Wood");
        add(wood.getStrippedWood(), "Stripped " +name + " Wood");
        add(wood.getSlab(), name +  " Slab");
        add(wood.getStairs(), name +  " Stairs");
    }
}
