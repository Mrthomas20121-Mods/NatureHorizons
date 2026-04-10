package mrthomas20121.nature_horizons.client.renderer;

import com.mojang.datafixers.util.Pair;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import org.jetbrains.annotations.NotNull;

public class NatureHorizonsBoatRenderer extends BoatRenderer {
    private final Pair<ResourceLocation, ListModel<Boat>> boatResourcePair;

    public NatureHorizonsBoatRenderer(EntityRendererProvider.Context context, boolean chest, ResourceLocation chestBoat, ResourceLocation boat, ModelLayerLocation chestBoatModel, ModelLayerLocation boatModel) {
        super(context, chest);
        this.boatResourcePair = Pair.of(chest ? chestBoat : boat, chest ? new ChestBoatModel(context.bakeLayer(chestBoatModel)) : new BoatModel(context.bakeLayer(boatModel)));
    }

    @Override
    public Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(@NotNull Boat boat) {
        return this.boatResourcePair;
    }
}
