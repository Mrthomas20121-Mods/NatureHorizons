package mrthomas20121.nature_horizons.client;


import mrthomas20121.nature_horizons.NatureHorizons;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class NatureHorizonsModelLayers {

    public static final ModelLayerLocation ASPEN_CHEST_BOAT = register("aspen_chest_boat");
    public static final ModelLayerLocation ASPEN_BOAT = register("aspen_boat");

    public static final ModelLayerLocation BLACK_WALNUT_CHEST_BOAT = register("black_walnut_chest_boat");
    public static final ModelLayerLocation BLACK_WALNUT_BOAT = register("black_walnut_boat");

    public static final ModelLayerLocation BLACKWOOD_CHEST_BOAT = register("blackwood_chest_boat");
    public static final ModelLayerLocation BLACKWOOD_BOAT = register("blackwood_boat");

    public static final ModelLayerLocation JUNIPER_CHEST_BOAT = register("juniper_chest_boat");
    public static final ModelLayerLocation JUNIPER_BOAT = register("juniper_boat");

    public static final ModelLayerLocation PINE_CHEST_BOAT = register("pine_chest_boat");
    public static final ModelLayerLocation PINE_BOAT = register("pine_boat");

    public static final ModelLayerLocation REDWOOD_CHEST_BOAT = register("redwood_chest_boat");
    public static final ModelLayerLocation REDWOOD_BOAT = register("redwood_boat");

    private static ModelLayerLocation register(String name) {
        return register(name, "main");
    }

    private static ModelLayerLocation register(String name, String type) {
        return register(NatureHorizons.getResource(name), type);
    }

    private static ModelLayerLocation register(ResourceLocation identifier, String type) {
        return new ModelLayerLocation(identifier, type);
    }
}
