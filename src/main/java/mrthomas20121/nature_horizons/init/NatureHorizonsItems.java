package mrthomas20121.nature_horizons.init;

import mrthomas20121.nature_horizons.NatureHorizons;
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

    public static ItemObject<Item> JUNIPER_BERRY = ITEMS.register("juniper_berry", new Item.Properties().food(NatureHorizonsFood.JUNIPER_BERRY));
    public static ItemObject<Item> GRILLED_JUNIPER_BERRY = ITEMS.register("grilled_juniper_berry", new Item.Properties().food(NatureHorizonsFood.GRILLED_JUNIPER_BERRY));
    public static ItemObject<Item> GOLDEN_JUNIPER_BERRY = ITEMS.register("golden_juniper_berry", new Item.Properties().food(NatureHorizonsFood.GOLDEN_JUNIPER_BERRY));

    @SubscribeEvent
    public static void creativeTabEvent(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
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
                        output.accept(NatureHorizonsBlocks.ASPEN_LEAVES);
                        output.accept(NatureHorizonsBlocks.ASPEN_SAPLING);
                        accept(NatureHorizonsBlocks.ASPEN, output);
                        output.accept(NatureHorizonsBlocks.BLACKWOOD_LEAVES);
                        output.accept(NatureHorizonsBlocks.BLACKWOOD_SAPLING);
                        accept(NatureHorizonsBlocks.BLACKWOOD, output);
                        output.accept(NatureHorizonsBlocks.JUNIPER_LEAVES);
                        output.accept(NatureHorizonsBlocks.JUNIPER_SAPLING);
                        accept(NatureHorizonsBlocks.JUNIPER, output);
                        output.accept(NatureHorizonsBlocks.PINE_LEAVES);
                        output.accept(NatureHorizonsBlocks.PINE_SAPLING);
                        accept(NatureHorizonsBlocks.PINE, output);
                    })
                    .build()
    );

    private static void accept(WoodBlockObject woodBlockObject, CreativeModeTab.Output output) {
        output.accept(woodBlockObject.get());
        output.accept(woodBlockObject.getStairs());
        output.accept(woodBlockObject.getSlab());
        output.accept(woodBlockObject.getLog());
        output.accept(woodBlockObject.getWood());
        output.accept(woodBlockObject.getStrippedLog());
        output.accept(woodBlockObject.getStrippedWood());
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
