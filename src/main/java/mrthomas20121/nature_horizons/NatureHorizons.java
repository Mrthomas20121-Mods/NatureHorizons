package mrthomas20121.nature_horizons;

import mrthomas20121.nature_horizons.datagen.NatureHorizonsDatagen;
import mrthomas20121.nature_horizons.datagen.NatureHorizonsTags;
import mrthomas20121.nature_horizons.init.*;
import mrthomas20121.nature_horizons.worldgen.NatureHorizonsWorldGen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.Nullable;

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
	}

	public void setup(FMLCommonSetupEvent event) {

		NatureHorizonsWorldGen.init();
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
