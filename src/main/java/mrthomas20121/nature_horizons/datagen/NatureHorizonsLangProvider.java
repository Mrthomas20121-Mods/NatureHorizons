package mrthomas20121.nature_horizons.datagen;

import mrthomas20121.nature_horizons.NatureHorizons;
import mrthomas20121.nature_horizons.init.NatureHorizonsBlocks;
import mrthomas20121.nature_horizons.init.NatureHorizonsEntityTypes;
import mrthomas20121.nature_horizons.init.NatureHorizonsItems;
import mrthomas20121.nature_horizons.worldgen.NatureHorizonsBiomes;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.data.LanguageProvider;
import slimeknights.mantle.registration.object.WoodBlockObject;

public class NatureHorizonsLangProvider extends LanguageProvider {

    public NatureHorizonsLangProvider(PackOutput output) {
        super(output, NatureHorizons.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.nature_horizons.wood", "Nature Horizons Wood Blocks");
        add("itemGroup.nature_horizons.sand", "Nature Horizons Sand Blocks");

        add("item.nature_horizons.hard_walnut_item.tooltip", "Right click on a hard block to open");

        addBlock(NatureHorizonsBlocks.ROCKSALT, "Rocksalt");

        wood(NatureHorizonsBlocks.ASPEN, "Aspen");
        add(NatureHorizonsBlocks.ASPEN_LEAVES.get(), "Aspen Leaves");
        add(NatureHorizonsBlocks.ASPEN_SAPLING.get(), "Aspen Sapling");

        wood(NatureHorizonsBlocks.BALSA, "Balsa");
        add(NatureHorizonsBlocks.BALSA_LEAVES.get(), "Balsa Leaves");
        add(NatureHorizonsBlocks.BALSA_SAPLING.get(), "Balsa Sapling");

        wood(NatureHorizonsBlocks.BLACK_WALNUT, "Black Walnut");
        add(NatureHorizonsBlocks.BLACK_WALNUT_LEAVES.get(), "Black Walnut Leaves");
        add(NatureHorizonsBlocks.BLACK_WALNUT_SAPLING.get(), "Black Walnut Sapling");

        wood(NatureHorizonsBlocks.BLACKWOOD, "Blackwood");
        add(NatureHorizonsBlocks.BLACKWOOD_LEAVES.get(), "Blackwood Leaves");
        add(NatureHorizonsBlocks.BLACKWOOD_SAPLING.get(), "Blackwood Sapling");

        wood(NatureHorizonsBlocks.IPE, "Ipe");
        add(NatureHorizonsBlocks.PINK_IPE_LEAVES.get(), "Pink Ipe Leaves");
        add(NatureHorizonsBlocks.PINK_IPE_SAPLING.get(), "Pink Ipe Sapling");
        add(NatureHorizonsBlocks.GOLDEN_IPE_LEAVES.get(), "Golden Ipe Leaves");
        add(NatureHorizonsBlocks.GOLDEN_IPE_SAPLING.get(), "Golden Ipe Sapling");
        add(NatureHorizonsBlocks.WHITE_IPE_LEAVES.get(), "White Ipe Leaves");
        add(NatureHorizonsBlocks.WHITE_IPE_SAPLING.get(), "White Ipe Sapling");

        wood(NatureHorizonsBlocks.JAPANESE_MAPLE, "Japanese Maple");
        add(NatureHorizonsBlocks.JAPANESE_MAPLE_LEAVES.get(), "Japanese Maple Leaves");
        add(NatureHorizonsBlocks.JAPANESE_MAPLE_SAPLING.get(), "Japanese Maple Sapling");
        add(NatureHorizonsBlocks.CRIMSON_JAPANESE_MAPLE_LEAVES.get(), "Crimson Japanese Maple Leaves");
        add(NatureHorizonsBlocks.CRIMSON_JAPANESE_MAPLE_SAPLING.get(), "Crimson Japanese Maple Sapling");
        add(NatureHorizonsBlocks.ORANGE_JAPANESE_MAPLE_LEAVES.get(), "Orange Japanese Maple Leaves");
        add(NatureHorizonsBlocks.ORANGE_JAPANESE_MAPLE_SAPLING.get(), "Orange Japanese Maple Sapling");

        wood(NatureHorizonsBlocks.JUNIPER, "Juniper");
        add(NatureHorizonsBlocks.JUNIPER_LEAVES.get(), "Juniper Leaves");
        add(NatureHorizonsBlocks.JUNIPER_SAPLING.get(), "Juniper Sapling");

        wood(NatureHorizonsBlocks.MAHOGANY, "Mahogany");
        add(NatureHorizonsBlocks.MAHOGANY_LEAVES.get(), "Mahogany Leaves");
        add(NatureHorizonsBlocks.MAHOGANY_SAPLING.get(), "Mahogany Sapling");

        wood(NatureHorizonsBlocks.NANMU, "Nanmu");
        add(NatureHorizonsBlocks.NANMU_LEAVES.get(), "Nanmu Leaves");
        add(NatureHorizonsBlocks.NANMU_SAPLING.get(), "Nanmu Sapling");

        wood(NatureHorizonsBlocks.PINE, "Pine");
        add(NatureHorizonsBlocks.PINE_LEAVES.get(), "Pine Leaves");
        add(NatureHorizonsBlocks.PINE_SAPLING.get(), "Pine Sapling");

        wood(NatureHorizonsBlocks.REDWOOD, "Redwood");
        add(NatureHorizonsBlocks.REDWOOD_LEAVES.get(), "Redwood Leaves");
        add(NatureHorizonsBlocks.REDWOOD_SAPLING.get(), "Redwood Sapling");

        wood(NatureHorizonsBlocks.WILLOW, "Willow");
        add(NatureHorizonsBlocks.WILLOW_LEAVES.get(), "Willow Leaves");
        add(NatureHorizonsBlocks.WILLOW_SAPLING.get(), "Willow Sapling");

        addItem(NatureHorizonsItems.HARD_WALNUT, "Hard Walnut");
        addItem(NatureHorizonsItems.WALNUT, "Walnut");
        addItem(NatureHorizonsItems.ROASTED_WALNUT, "Roasted Walnut");
        addItem(NatureHorizonsItems.GOLDEN_WALNUT, "Golden Walnut");
        addItem(NatureHorizonsItems.JUNIPER_BERRY, "Juniper Berry");
        addItem(NatureHorizonsItems.GRILLED_JUNIPER_BERRY, "Grilled Juniper Berry");
        addItem(NatureHorizonsItems.GOLDEN_JUNIPER_BERRY, "Golden Juniper Berry");
        addItem(NatureHorizonsItems.ASPEN_BOAT, "Aspen Boat");
        addItem(NatureHorizonsItems.ASPEN_CHEST_BOAT, "Aspen Chest Boat");
        addItem(NatureHorizonsItems.BALSA_BOAT, "Balsa Boat");
        addItem(NatureHorizonsItems.BALSA_CHEST_BOAT, "Balsa Chest Boat");
        addItem(NatureHorizonsItems.BLACK_WALNUT_BOAT, "Black Walnut Boat");
        addItem(NatureHorizonsItems.BLACK_WALNUT_CHEST_BOAT, "Black Walnut Chest Boat");
        addItem(NatureHorizonsItems.BLACKWOOD_BOAT, "Blackwood Boat");
        addItem(NatureHorizonsItems.BLACKWOOD_CHEST_BOAT, "Blackwood Chest Boat");
        addItem(NatureHorizonsItems.IPE_BOAT, "Ipe Boat");
        addItem(NatureHorizonsItems.IPE_CHEST_BOAT, "Ipe Chest Boat");
        addItem(NatureHorizonsItems.JAPANESE_MAPLE_BOAT, "Japanese Maple Boat");
        addItem(NatureHorizonsItems.JAPANESE_MAPLE_CHEST_BOAT, "Japanese Maple Chest Boat");
        addItem(NatureHorizonsItems.JUNIPER_BOAT, "Juniper Boat");
        addItem(NatureHorizonsItems.JUNIPER_CHEST_BOAT, "Juniper Chest Boat");
        addItem(NatureHorizonsItems.MAHOGANY_BOAT, "Mahogany Boat");
        addItem(NatureHorizonsItems.MAHOGANY_CHEST_BOAT, "Mahogany Chest Boat");
        addItem(NatureHorizonsItems.NANMU_BOAT, "Auric Boat");
        addItem(NatureHorizonsItems.NANMU_CHEST_BOAT, "Auric Chest Boat");
        addItem(NatureHorizonsItems.PINE_BOAT, "Pine Boat");
        addItem(NatureHorizonsItems.PINE_CHEST_BOAT, "Pine Chest Boat");
        addItem(NatureHorizonsItems.REDWOOD_BOAT, "Redwood Boat");
        addItem(NatureHorizonsItems.REDWOOD_CHEST_BOAT, "Redwood Chest Boat");
        addItem(NatureHorizonsItems.WILLOW_BOAT, "Willow Boat");
        addItem(NatureHorizonsItems.WILLOW_CHEST_BOAT, "Willow Chest Boat");

        addEntityType(NatureHorizonsEntityTypes.ASPEN_BOAT, "Aspen Boat");
        addEntityType(NatureHorizonsEntityTypes.ASPEN_CHEST_BOAT, "Aspen Chest Boat");
        addEntityType(NatureHorizonsEntityTypes.BALSA_BOAT, "Balsa Boat");
        addEntityType(NatureHorizonsEntityTypes.BALSA_CHEST_BOAT, "Balsa Chest Boat");
        addEntityType(NatureHorizonsEntityTypes.BLACK_WALNUT_BOAT, "Black Walnut Boat");
        addEntityType(NatureHorizonsEntityTypes.BLACK_WALNUT_CHEST_BOAT, "Black Walnut Chest Boat");
        addEntityType(NatureHorizonsEntityTypes.BLACKWOOD_BOAT, "Blackwood Boat");
        addEntityType(NatureHorizonsEntityTypes.BLACKWOOD_CHEST_BOAT, "Blackwood Chest Boat");
        addEntityType(NatureHorizonsEntityTypes.JAPANESE_MAPLE_BOAT, "Japanese Maple Boat");
        addEntityType(NatureHorizonsEntityTypes.IPE_BOAT, "Ipe Boat");
        addEntityType(NatureHorizonsEntityTypes.IPE_CHEST_BOAT, "Ipe Chest Boat");
        addEntityType(NatureHorizonsEntityTypes.JAPANESE_MAPLE_CHEST_BOAT, "Japanese Maple Chest Boat");
        addEntityType(NatureHorizonsEntityTypes.JUNIPER_BOAT, "Juniper Boat");
        addEntityType(NatureHorizonsEntityTypes.JUNIPER_CHEST_BOAT, "Juniper Chest Boat");
        addEntityType(NatureHorizonsEntityTypes.MAHOGANY_BOAT, "Mahogany Boat");
        addEntityType(NatureHorizonsEntityTypes.MAHOGANY_CHEST_BOAT, "Mahogany Chest Boat");
        addEntityType(NatureHorizonsEntityTypes.NANMU_BOAT, "Auric Boat");
        addEntityType(NatureHorizonsEntityTypes.NANMU_CHEST_BOAT, "Auric Chest Boat");
        addEntityType(NatureHorizonsEntityTypes.PINE_BOAT, "Pine Boat");
        addEntityType(NatureHorizonsEntityTypes.PINE_CHEST_BOAT, "Pine Chest Boat");
        addEntityType(NatureHorizonsEntityTypes.REDWOOD_BOAT, "Redwood Boat");
        addEntityType(NatureHorizonsEntityTypes.REDWOOD_CHEST_BOAT, "Redwood Chest Boat");
        addEntityType(NatureHorizonsEntityTypes.WILLOW_BOAT, "Willow Boat");
        addEntityType(NatureHorizonsEntityTypes.WILLOW_CHEST_BOAT, "Willow Chest Boat");

        add(NatureHorizonsBiomes.ASPEN_FOREST, "Aspen Forest");
        add(NatureHorizonsBiomes.JAPANESE_MAPLE_FOREST, "Japanese Maple Forest");
        add(NatureHorizonsBiomes.OLD_GROWTH_ASPEN_FOREST, "Old Growth Aspen Forest");
        add(NatureHorizonsBiomes.OLD_GROWTH_REDWOOD_TAIGA, "Old Growth Redwood Taiga");
        add(NatureHorizonsBiomes.SALT_CAVE, "Salt Cave");
        add(NatureHorizonsBiomes.TROPICAL_FOREST, "Tropical Forest");
        add(NatureHorizonsBiomes.WOODLAND, "Woodland");
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

    private void add(ResourceKey<Biome> key, String name) {
        ResourceLocation location = key.location();
        add("biome."+ location.getNamespace() +"."+ location.getPath(), name);
    };
}
