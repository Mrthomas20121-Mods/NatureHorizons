package mrthomas20121.nature_horizons.init;

import mrthomas20121.nature_horizons.NatureHorizons;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.mantle.registration.object.WoodBlockObject;

public class NatureHorizonsItems {

    public static DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NatureHorizons.MOD_ID);

    public static RegistryObject<CreativeModeTab> WOOD_TAB = CREATIVE_TABS.register("wood",
            () -> CreativeModeTab.builder()
                    .title(NatureHorizons.makeTranslation("itemGroup", "wood"))
                    .icon(() -> new ItemStack(NatureHorizonsBlocks.ASPEN.get()))
                    .displayItems((CreativeModeTab.ItemDisplayParameters itemDisplayParameters, CreativeModeTab.Output output) -> {
                        accept(NatureHorizonsBlocks.ASPEN, output);
                        accept(NatureHorizonsBlocks.BLACKWOOD, output);
                        accept(NatureHorizonsBlocks.JUNIPER, output);
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
