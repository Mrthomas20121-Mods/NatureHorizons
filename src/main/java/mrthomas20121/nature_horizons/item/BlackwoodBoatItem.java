package mrthomas20121.nature_horizons.item;

import mrthomas20121.nature_horizons.entity.AspenBoat;
import mrthomas20121.nature_horizons.entity.AspenChestBoat;
import mrthomas20121.nature_horizons.entity.BlackwoodBoat;
import mrthomas20121.nature_horizons.entity.BlackwoodChestBoat;
import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.function.Predicate;

public class BlackwoodBoatItem extends NatureBoatItem {

    public BlackwoodBoatItem(boolean hasChest) {
        super(hasChest);
    }

    /**
     * Gets a Boat dependent on {@link BlackwoodBoatItem#hasChest}.
     * @param level The {@link Level} of the boat.
     * @param hitResult The {@link HitResult} of attempting to place the boat.
     * @return The type of {@link Boat}, either a {@link net.minecraft.world.entity.vehicle.ChestBoat} or a {@link Boat}.
     */
    public Boat getBoat(Level level, HitResult hitResult) {
        return this.hasChest ? new BlackwoodChestBoat(level, hitResult.getLocation().x, hitResult.getLocation().y, hitResult.getLocation().z) : new BlackwoodBoat(level, hitResult.getLocation().x, hitResult.getLocation().y, hitResult.getLocation().z);
    }
}
