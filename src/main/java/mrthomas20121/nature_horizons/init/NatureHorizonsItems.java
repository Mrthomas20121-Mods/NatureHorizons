package mrthomas20121.nature_horizons.init;

import mrthomas20121.nature_horizons.NatureHorizons;
import mrthomas20121.nature_horizons.item.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.mantle.registration.deferred.ItemDeferredRegister;
import slimeknights.mantle.registration.object.ItemObject;
import slimeknights.mantle.registration.object.WoodBlockObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = NatureHorizons.MOD_ID, value = Dist.CLIENT)
public class NatureHorizonsItems {

    public static ItemDeferredRegister ITEMS = new ItemDeferredRegister(NatureHorizons.MOD_ID);

    public static ItemObject<HardWalnutItem> HARD_WALNUT = ITEMS.register("hard_walnut", HardWalnutItem::new);
    public static ItemObject<Item> WALNUT = ITEMS.register("walnut", new Item.Properties().food(NatureHorizonsFood.WALNUT));
    public static ItemObject<Item> ROASTED_WALNUT = ITEMS.register("roasted_walnut", new Item.Properties().food(NatureHorizonsFood.ROASTED_WALNUT));
    public static ItemObject<Item> GOLDEN_WALNUT = ITEMS.register("golden_walnut", new Item.Properties().food(NatureHorizonsFood.GOLDEN_WALNUT));
    public static ItemObject<Item> JUNIPER_BERRY = ITEMS.register("juniper_berry", new Item.Properties().food(NatureHorizonsFood.JUNIPER_BERRY));
    public static ItemObject<Item> GRILLED_JUNIPER_BERRY = ITEMS.register("grilled_juniper_berry", new Item.Properties().food(NatureHorizonsFood.GRILLED_JUNIPER_BERRY));
    public static ItemObject<Item> GOLDEN_JUNIPER_BERRY = ITEMS.register("golden_juniper_berry", new Item.Properties().food(NatureHorizonsFood.GOLDEN_JUNIPER_BERRY));
    public static ItemObject<AspenBoatItem> ASPEN_BOAT = ITEMS.register("aspen_boat", () -> new AspenBoatItem(false));
    public static ItemObject<AspenBoatItem> ASPEN_CHEST_BOAT = ITEMS.register("aspen_chest_boat", () -> new AspenBoatItem(true));
    public static ItemObject<BlackWalnutBoatItem> BLACK_WALNUT_BOAT = ITEMS.register("black_walnut_boat", () -> new BlackWalnutBoatItem(false));
    public static ItemObject<BlackWalnutBoatItem> BLACK_WALNUT_CHEST_BOAT = ITEMS.register("black_walnut_chest_boat", () -> new BlackWalnutBoatItem(true));
    public static ItemObject<BlackwoodBoatItem> BLACKWOOD_BOAT = ITEMS.register("blackwood_boat", () -> new BlackwoodBoatItem(false));
    public static ItemObject<BlackwoodBoatItem> BLACKWOOD_CHEST_BOAT = ITEMS.register("blackwood_chest_boat", () -> new BlackwoodBoatItem(true));
    public static ItemObject<JapaneseMapleBoatItem> JAPANESE_MAPLE_BOAT = ITEMS.register("japanese_maple_boat", () -> new JapaneseMapleBoatItem(false));
    public static ItemObject<JapaneseMapleBoatItem> JAPANESE_MAPLE_CHEST_BOAT = ITEMS.register("japanese_maple_chest_boat", () -> new JapaneseMapleBoatItem(true));
    public static ItemObject<JuniperBoatItem> JUNIPER_BOAT = ITEMS.register("juniper_boat", () -> new JuniperBoatItem(false));
    public static ItemObject<JuniperBoatItem> JUNIPER_CHEST_BOAT = ITEMS.register("juniper_chest_boat", () -> new JuniperBoatItem(true));
    public static ItemObject<AuricBoatItem> AURIC_BOAT = ITEMS.register("auric_boat", () -> new AuricBoatItem(false));
    public static ItemObject<AuricBoatItem> AURIC_CHEST_BOAT = ITEMS.register("auric_chest_boat", () -> new AuricBoatItem(true));
    public static ItemObject<PineBoatItem> PINE_BOAT = ITEMS.register("pine_boat", () -> new PineBoatItem(false));
    public static ItemObject<PineBoatItem> PINE_CHEST_BOAT = ITEMS.register("pine_chest_boat", () -> new PineBoatItem(true));
    public static ItemObject<RedwoodBoatItem> REDWOOD_BOAT = ITEMS.register("redwood_boat", () -> new RedwoodBoatItem(false));
    public static ItemObject<RedwoodBoatItem> REDWOOD_CHEST_BOAT = ITEMS.register("redwood_chest_boat", () -> new RedwoodBoatItem(true));

    @SubscribeEvent
    public static void creativeTabEvent(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(HARD_WALNUT.get());
            event.accept(WALNUT.get());
            event.accept(ROASTED_WALNUT.get());
            event.accept(GOLDEN_WALNUT.get());
            event.accept(JUNIPER_BERRY.get());
            event.accept(GRILLED_JUNIPER_BERRY.get());
            event.accept(GOLDEN_JUNIPER_BERRY.get());
        }
    }

    public static DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NatureHorizons.MOD_ID);

    public static RegistryObject<CreativeModeTab> WOOD_TAB = CREATIVE_TABS.register("wood",
            () -> CreativeModeTab.builder()
                    .title(NatureHorizons.makeTranslation("itemGroup", "wood"))
                    .icon(() -> new ItemStack(NatureHorizonsBlocks.ASPEN.get()))
                    .displayItems((CreativeModeTab.ItemDisplayParameters itemDisplayParameters, CreativeModeTab.Output output) -> {
                        output.accept(NatureHorizonsItems.ASPEN_BOAT.get());
                        output.accept(NatureHorizonsItems.ASPEN_CHEST_BOAT.get());
                        output.accept(NatureHorizonsBlocks.ASPEN_LEAVES);
                        output.accept(NatureHorizonsBlocks.ASPEN_SAPLING);
                        accept(NatureHorizonsBlocks.ASPEN, output);
                        output.accept(NatureHorizonsItems.BLACK_WALNUT_BOAT.get());
                        output.accept(NatureHorizonsItems.BLACK_WALNUT_CHEST_BOAT.get());
                        output.accept(NatureHorizonsBlocks.BLACK_WALNUT_LEAVES);
                        output.accept(NatureHorizonsBlocks.BLACK_WALNUT_SAPLING);
                        accept(NatureHorizonsBlocks.BLACK_WALNUT, output);
                        output.accept(NatureHorizonsItems.BLACKWOOD_BOAT.get());
                        output.accept(NatureHorizonsItems.BLACKWOOD_CHEST_BOAT.get());
                        output.accept(NatureHorizonsBlocks.BLACKWOOD_LEAVES);
                        output.accept(NatureHorizonsBlocks.BLACKWOOD_SAPLING);
                        accept(NatureHorizonsBlocks.BLACKWOOD, output);
                        output.accept(NatureHorizonsItems.JAPANESE_MAPLE_BOAT.get());
                        output.accept(NatureHorizonsItems.JAPANESE_MAPLE_CHEST_BOAT.get());
                        output.accept(NatureHorizonsBlocks.JAPANESE_MAPLE_LEAVES);
                        output.accept(NatureHorizonsBlocks.JAPANESE_MAPLE_SAPLING);
                        output.accept(NatureHorizonsBlocks.CRIMSON_JAPANESE_MAPLE_LEAVES);
                        output.accept(NatureHorizonsBlocks.CRIMSON_JAPANESE_MAPLE_SAPLING);
                        output.accept(NatureHorizonsBlocks.ORANGE_JAPANESE_MAPLE_LEAVES);
                        output.accept(NatureHorizonsBlocks.ORANGE_JAPANESE_MAPLE_SAPLING);
                        accept(NatureHorizonsBlocks.JAPANESE_MAPLE, output);
                        output.accept(NatureHorizonsItems.JUNIPER_BOAT.get());
                        output.accept(NatureHorizonsItems.JUNIPER_CHEST_BOAT.get());
                        output.accept(NatureHorizonsBlocks.JUNIPER_LEAVES);
                        output.accept(NatureHorizonsBlocks.JUNIPER_SAPLING);
                        accept(NatureHorizonsBlocks.JUNIPER, output);
                        output.accept(NatureHorizonsItems.AURIC_BOAT.get());
                        output.accept(NatureHorizonsItems.AURIC_CHEST_BOAT.get());
                        output.accept(NatureHorizonsBlocks.AURIC_LEAVES);
                        output.accept(NatureHorizonsBlocks.AURIC_SAPLING);
                        accept(NatureHorizonsBlocks.AURIC, output);
                        output.accept(NatureHorizonsItems.PINE_BOAT.get());
                        output.accept(NatureHorizonsItems.PINE_CHEST_BOAT.get());
                        output.accept(NatureHorizonsBlocks.PINE_LEAVES);
                        output.accept(NatureHorizonsBlocks.PINE_SAPLING);
                        accept(NatureHorizonsBlocks.PINE, output);
                        output.accept(NatureHorizonsItems.REDWOOD_BOAT.get());
                        output.accept(NatureHorizonsItems.REDWOOD_CHEST_BOAT.get());
                        output.accept(NatureHorizonsBlocks.REDWOOD_LEAVES);
                        output.accept(NatureHorizonsBlocks.REDWOOD_SAPLING);
                        accept(NatureHorizonsBlocks.REDWOOD, output);
                    })
                    .build()
    );

    private static void accept(WoodBlockObject woodBlockObject, CreativeModeTab.Output output) {
        output.accept(woodBlockObject.get());
        output.accept(woodBlockObject.getLog());
        output.accept(woodBlockObject.getWood());
        output.accept(woodBlockObject.getStrippedLog());
        output.accept(woodBlockObject.getStrippedWood());
        output.accept(woodBlockObject.getStairs());
        output.accept(woodBlockObject.getSlab());
        output.accept(woodBlockObject.getFence());
        output.accept(woodBlockObject.getFenceGate());
        output.accept(woodBlockObject.getDoor());
        output.accept(woodBlockObject.getTrapdoor());
        output.accept(woodBlockObject.getButton());
        output.accept(woodBlockObject.getPressurePlate());
        output.accept(woodBlockObject.getSign());
        output.accept(woodBlockObject.getHangingSign());
    }
}
