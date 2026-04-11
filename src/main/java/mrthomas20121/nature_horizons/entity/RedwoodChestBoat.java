package mrthomas20121.nature_horizons.entity;

import mrthomas20121.nature_horizons.init.NatureHorizonsBlocks;
import mrthomas20121.nature_horizons.init.NatureHorizonsEntityTypes;
import mrthomas20121.nature_horizons.init.NatureHorizonsItems;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

public class RedwoodChestBoat extends BaseChestBoat {

    public RedwoodChestBoat(EntityType<? extends Boat> p_38290_, Level p_38291_) {
        super(p_38290_, p_38291_);
    }

    public RedwoodChestBoat(Level level, double x, double y, double z) {
        this(NatureHorizonsEntityTypes.REDWOOD_CHEST_BOAT.get(), level);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    @Override
    Block getPlanks() {
        return NatureHorizonsBlocks.REDWOOD.get();
    }

    @Override
    public Item getDropItem() {
        return NatureHorizonsItems.REDWOOD_CHEST_BOAT.get();
    }

    @NotNull
    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
