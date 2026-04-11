package mrthomas20121.nature_horizons;

import mrthomas20121.nature_horizons.datagen.NatureHorizonsDatagen;
import mrthomas20121.nature_horizons.datagen.NatureHorizonsTags;
import mrthomas20121.nature_horizons.init.*;
import mrthomas20121.nature_horizons.worldgen.NatureHorizonsWorldGen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;

@Mod(NatureHorizons.MOD_ID)
public class NatureHorizons {

	public static final String MOD_ID = "nature_horizons";

	public NatureHorizons() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		// init tags
		NatureHorizonsTags.init();

		NatureHorizonsBlocks.BLOCKS.register(bus);
		NatureHorizonsItems.ITEMS.register(bus);
		NatureHorizonsEntityTypes.ENTITY_TYPES.register(bus);
		NatureHorizonsItems.CREATIVE_TABS.register(bus);

		bus.addListener(NatureHorizonsDatagen::init);
		bus.addListener(this::setup);
		MinecraftForge.EVENT_BUS.addListener(this::onRightClickBlock);
	}

	public void setup(FMLCommonSetupEvent event) {

		NatureHorizonsWorldGen.init();
	}

	public void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if(!event.isCanceled()) {
			Event.Result result = event.getUseBlock();
			if(result.equals(Event.Result.DEFAULT) || result.equals(Event.Result.ALLOW)) {
				BlockHitResult hitVec = event.getHitVec();
				BlockState blockState = event.getLevel().getBlockState(hitVec.getBlockPos());
				Player player = event.getEntity();
				ItemStack mainHandItem = player.getMainHandItem();
				if(blockState.is(NatureHorizonsTags.CAN_BREAK_HARD_WALNUT) && mainHandItem.is(NatureHorizonsItems.HARD_WALNUT.get())) {
					mainHandItem.shrink(1);
					player.addItem(new ItemStack(NatureHorizonsItems.WALNUT));
				}
			}
		}
	}

	/**
	 * Gets a resource location for Nature Horizons
	 * @param name  Resource path
	 * @return  Location
	 */
	public static ResourceLocation getResource(String name) {
		return new ResourceLocation(MOD_ID, name);
	}

	/**
	 * Returns the given Resource prefixed with resource location. Use this function instead of hardcoding
	 * resource locations.
	 */
	public static String resourceString(String res) {
		return String.format("%s:%s", MOD_ID, res);
	}

	/**
	 * Makes a translation key for the given name
	 * @param base  Base name, such as "block" or "gui"
	 * @param name  Object name
	 * @return  Translation key
	 */
	public static String makeTranslationKey(String base, String name) {
		return makeTranslationKey(base, getResource(name));
	}

	/**
	 * Makes a translation key for the given name, redirect to the vanilla method
	 * @param base  Base name, such as "block" or "gui"
	 * @param name  Object name
	 * @return  Translation key
	 */
	public static String makeTranslationKey(String base, @Nullable ResourceLocation name) {
		return net.minecraft.Util.makeDescriptionId(base, name);
	}

	/**
	 * Makes a translation text component for the given name
	 * @param base  Base name, such as "block" or "gui"
	 * @param name  Object name
	 * @return  Translation key
	 */
	public static MutableComponent makeTranslation(String base, String name) {
		return Component.translatable(makeTranslationKey(base, name));
	}

	/**
	 * Makes a translation text component for the given name
	 * @param base       Base name, such as "block" or "gui"
	 * @param name       Object name
	 * @param arguments  Additional arguments to the translation
	 * @return  Translation key
	 */
	public static MutableComponent makeTranslation(String base, String name, Object... arguments) {
		return Component.translatable(makeTranslationKey(base, name), arguments);
	}

}
