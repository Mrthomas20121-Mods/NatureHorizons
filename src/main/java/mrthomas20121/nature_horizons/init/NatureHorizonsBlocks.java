package mrthomas20121.nature_horizons.init;

import mrthomas20121.nature_horizons.NatureHorizons;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import slimeknights.mantle.registration.deferred.BlockDeferredRegister;
import slimeknights.mantle.registration.object.WoodBlockObject;

import java.util.List;

public class NatureHorizonsBlocks {

    public static BlockDeferredRegister BLOCKS = new BlockDeferredRegister(NatureHorizons.MOD_ID);

    public static WoodBlockObject ASPEN = BLOCKS.registerWood("aspen",
            (wood -> BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.WOOD).ignitedByLava()), true);

    public static WoodBlockObject BLACKWOOD = BLOCKS.registerWood("blackwood",
            (wood -> BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.WOOD).ignitedByLava()), true);

    public static WoodBlockObject JUNIPER = BLOCKS.registerWood("juniper",
            (wood -> BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.WOOD).ignitedByLava()), true);

    public static WoodBlockObject PINE = BLOCKS.registerWood("pine",
            (wood -> BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.WOOD).ignitedByLava()), true);

    public static List<WoodBlockObject> WOODS = List.of(ASPEN, BLACKWOOD, JUNIPER, PINE);
}
