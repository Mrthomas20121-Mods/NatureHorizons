package mrthomas20121.nature_horizons.item;

import mrthomas20121.nature_horizons.entity.PineBoat;
import mrthomas20121.nature_horizons.entity.PineChestBoat;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class PineBoatItem extends NatureBoatItem {

    public PineBoatItem(boolean hasChest) {
        super(hasChest);
    }

    /**
     * Gets a Boat dependent on {@link PineBoatItem#hasChest}.
     * @param level The {@link Level} of the boat.
     * @param hitResult The {@link HitResult} of attempting to place the boat.
     * @return The type of {@link Boat}, either a {@link net.minecraft.world.entity.vehicle.ChestBoat} or a {@link Boat}.
     */
    public Boat getBoat(Level level, HitResult hitResult) {
        return this.hasChest ? new PineChestBoat(level, hitResult.getLocation().x, hitResult.getLocation().y, hitResult.getLocation().z) : new PineBoat(level, hitResult.getLocation().x, hitResult.getLocation().y, hitResult.getLocation().z);
    }
}
