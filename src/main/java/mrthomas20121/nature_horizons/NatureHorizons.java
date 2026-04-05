package mrthomas20121.nature_horizons;

import mrthomas20121.nature_horizons.datagen.NatureHorizonsDatagen;
import mrthomas20121.nature_horizons.init.*;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
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

		NatureHorizonsBlocks.BLOCKS.register(bus);

		bus.addListener(NatureHorizonsDatagen::init);
		bus.addListener(this::setup);
	}

	public void setup(FMLCommonSetupEvent event) {

		//NatureHorizonsWorldGen.init();
	}

	/**
	 * Gets a resource location for Tinkers
	 * @param name  Resource path
	 * @return  Location for tinkers
	 */
	public static ResourceLocation getResource(String name) {
		return new ResourceLocation(MOD_ID, name);
	}

	/**
	 * Returns the given Resource prefixed with tinkers resource location. Use this function instead of hardcoding
	 * resource locations.
	 */
	public static String resourceString(String res) {
		return String.format("%s:%s", MOD_ID, res);
	}

	/**
	 * Prefixes the given unlocalized name with tinkers prefix. Use this when passing unlocalized names for a uniform
	 * namespace.
	 */
	public static String prefix(String name) {
		return MOD_ID + "." + name.toLowerCase(Locale.US);
	}

	/** Makes a Tinker's description ID */
	public static String makeDescriptionId(String type, String name) {
		return type + "." + MOD_ID + "." + name;
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
