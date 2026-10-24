package mrthomas20121.nature_horizons.item;

import mrthomas20121.nature_horizons.entity.AspenBoat;
import mrthomas20121.nature_horizons.entity.AspenChestBoat;
import mrthomas20121.nature_horizons.entity.MahoganyBoat;
import mrthomas20121.nature_horizons.entity.MahoganyChestBoat;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class MahoganyBoatItem extends NatureBoatItem {

    public MahoganyBoatItem(boolean hasChest) {
        super(hasChest);
    }

    /**
     * Gets a Boat dependent on {@link MahoganyBoatItem#hasChest}.
     * @param level The {@link Level} of the boat.
     * @param hitResult The {@link HitResult} of attempting to place the boat.
     * @return The type of {@link Boat}, either a {@link net.minecraft.world.entity.vehicle.ChestBoat} or a {@link Boat}.
     */
    public Boat getBoat(Level level, HitResult hitResult) {
        return this.hasChest ? new MahoganyChestBoat(level, hitResult.getLocation().x, hitResult.getLocation().y, hitResult.getLocation().z) : new MahoganyBoat(level, hitResult.getLocation().x, hitResult.getLocation().y, hitResult.getLocation().z);
    }
}
