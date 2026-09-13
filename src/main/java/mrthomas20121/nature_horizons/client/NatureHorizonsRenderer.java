package mrthomas20121.nature_horizons.client;

import mrthomas20121.nature_horizons.NatureHorizons;
import mrthomas20121.nature_horizons.client.renderer.NatureHorizonsBoatRenderer;
import mrthomas20121.nature_horizons.init.NatureHorizonsEntityTypes;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NatureHorizons.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NatureHorizonsRenderer {

    private static final ResourceLocation ASPEN_BOAT = new ResourceLocation(NatureHorizons.MOD_ID, "textures/entity/boat/aspen.png");
    private static final ResourceLocation ASPEN_CHEST_BOAT = new ResourceLocation(NatureHorizons.MOD_ID, "textures/entity/chest_boat/aspen.png");
    private static final ResourceLocation BLACK_WALNUT_BOAT = new ResourceLocation(NatureHorizons.MOD_ID, "textures/entity/boat/black_walnut.png");
    private static final ResourceLocation BLACK_WALNUT_CHEST_BOAT = new ResourceLocation(NatureHorizons.MOD_ID, "textures/entity/chest_boat/black_walnut.png");
    private static final ResourceLocation BLACKWOOD_BOAT = new ResourceLocation(NatureHorizons.MOD_ID, "textures/entity/boat/blackwood.png");
    private static final ResourceLocation BLACKWOOD_CHEST_BOAT = new ResourceLocation(NatureHorizons.MOD_ID, "textures/entity/chest_boat/blackwood.png");
    private static final ResourceLocation JAPANESE_MAPLE_BOAT = new ResourceLocation(NatureHorizons.MOD_ID, "textures/entity/boat/japanese_maple.png");
    private static final ResourceLocation JAPANESE_MAPLE_CHEST_BOAT = new ResourceLocation(NatureHorizons.MOD_ID, "textures/entity/chest_boat/japanese_maple.png");
    private static final ResourceLocation JUNIPER_BOAT = new ResourceLocation(NatureHorizons.MOD_ID, "textures/entity/boat/juniper.png");
    private static final ResourceLocation JUNIPER_CHEST_BOAT = new ResourceLocation(NatureHorizons.MOD_ID, "textures/entity/chest_boat/juniper.png");
    private static final ResourceLocation AURIC_BOAT = new ResourceLocation(NatureHorizons.MOD_ID, "textures/entity/boat/auric.png");
    private static final ResourceLocation AURIC_CHEST_BOAT = new ResourceLocation(NatureHorizons.MOD_ID, "textures/entity/chest_boat/auric.png");
    private static final ResourceLocation PINE_BOAT = new ResourceLocation(NatureHorizons.MOD_ID, "textures/entity/boat/pine.png");
    private static final ResourceLocation PINE_CHEST_BOAT = new ResourceLocation(NatureHorizons.MOD_ID, "textures/entity/chest_boat/pine.png");
    private static final ResourceLocation REDWOOD_BOAT = new ResourceLocation(NatureHorizons.MOD_ID, "textures/entity/boat/redwood.png");
    private static final ResourceLocation REDWOOD_CHEST_BOAT = new ResourceLocation(NatureHorizons.MOD_ID, "textures/entity/chest_boat/redwood.png");

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(NatureHorizonsEntityTypes.ASPEN_BOAT.get(),
                (context) -> new NatureHorizonsBoatRenderer(context, false, ASPEN_CHEST_BOAT, ASPEN_BOAT, NatureHorizonsModelLayers.ASPEN_CHEST_BOAT, NatureHorizonsModelLayers.ASPEN_BOAT));
        event.registerEntityRenderer(NatureHorizonsEntityTypes.ASPEN_CHEST_BOAT.get(),
                (context) -> new NatureHorizonsBoatRenderer(context, true, ASPEN_CHEST_BOAT, ASPEN_BOAT, NatureHorizonsModelLayers.ASPEN_CHEST_BOAT, NatureHorizonsModelLayers.ASPEN_BOAT));
        event.registerEntityRenderer(NatureHorizonsEntityTypes.BLACK_WALNUT_BOAT.get(),
                (context) -> new NatureHorizonsBoatRenderer(context, false, BLACK_WALNUT_CHEST_BOAT, BLACK_WALNUT_BOAT, NatureHorizonsModelLayers.BLACK_WALNUT_CHEST_BOAT, NatureHorizonsModelLayers.BLACK_WALNUT_BOAT));
        event.registerEntityRenderer(NatureHorizonsEntityTypes.BLACK_WALNUT_CHEST_BOAT.get(),
                (context) -> new NatureHorizonsBoatRenderer(context, true, BLACK_WALNUT_CHEST_BOAT, BLACK_WALNUT_BOAT, NatureHorizonsModelLayers.BLACK_WALNUT_CHEST_BOAT, NatureHorizonsModelLayers.BLACK_WALNUT_BOAT));
        event.registerEntityRenderer(NatureHorizonsEntityTypes.BLACKWOOD_BOAT.get(),
                (context) -> new NatureHorizonsBoatRenderer(context, false, BLACKWOOD_CHEST_BOAT, BLACKWOOD_BOAT, NatureHorizonsModelLayers.BLACKWOOD_CHEST_BOAT, NatureHorizonsModelLayers.BLACKWOOD_BOAT));
        event.registerEntityRenderer(NatureHorizonsEntityTypes.BLACKWOOD_CHEST_BOAT.get(),
                (context) -> new NatureHorizonsBoatRenderer(context, true, BLACKWOOD_CHEST_BOAT, BLACKWOOD_BOAT, NatureHorizonsModelLayers.BLACKWOOD_CHEST_BOAT, NatureHorizonsModelLayers.BLACKWOOD_BOAT));
        event.registerEntityRenderer(NatureHorizonsEntityTypes.JAPANESE_MAPLE_BOAT.get(),
                (context) -> new NatureHorizonsBoatRenderer(context, false, JAPANESE_MAPLE_CHEST_BOAT, JAPANESE_MAPLE_BOAT, NatureHorizonsModelLayers.JAPANESE_MAPLE_CHEST_BOAT, NatureHorizonsModelLayers.JAPANESE_MAPLE_BOAT));
        event.registerEntityRenderer(NatureHorizonsEntityTypes.JAPANESE_MAPLE_CHEST_BOAT.get(),
                (context) -> new NatureHorizonsBoatRenderer(context, true, JAPANESE_MAPLE_CHEST_BOAT, JAPANESE_MAPLE_BOAT, NatureHorizonsModelLayers.JAPANESE_MAPLE_CHEST_BOAT, NatureHorizonsModelLayers.JAPANESE_MAPLE_BOAT));
        event.registerEntityRenderer(NatureHorizonsEntityTypes.JUNIPER_BOAT.get(),
                (context) -> new NatureHorizonsBoatRenderer(context, false, JUNIPER_CHEST_BOAT, JUNIPER_BOAT, NatureHorizonsModelLayers.JUNIPER_CHEST_BOAT, NatureHorizonsModelLayers.JUNIPER_BOAT));
        event.registerEntityRenderer(NatureHorizonsEntityTypes.JUNIPER_CHEST_BOAT.get(),
                (context) -> new NatureHorizonsBoatRenderer(context, true, JUNIPER_CHEST_BOAT, JUNIPER_BOAT, NatureHorizonsModelLayers.JUNIPER_CHEST_BOAT, NatureHorizonsModelLayers.JUNIPER_BOAT));
        event.registerEntityRenderer(NatureHorizonsEntityTypes.AURIC_BOAT.get(),
                (context) -> new NatureHorizonsBoatRenderer(context, false, AURIC_CHEST_BOAT, AURIC_BOAT, NatureHorizonsModelLayers.AURIC_CHEST_BOAT, NatureHorizonsModelLayers.AURIC_BOAT));
        event.registerEntityRenderer(NatureHorizonsEntityTypes.AURIC_CHEST_BOAT.get(),
                (context) -> new NatureHorizonsBoatRenderer(context, true, AURIC_CHEST_BOAT, AURIC_BOAT, NatureHorizonsModelLayers.AURIC_CHEST_BOAT, NatureHorizonsModelLayers.AURIC_BOAT));
        event.registerEntityRenderer(NatureHorizonsEntityTypes.PINE_BOAT.get(),
                (context) -> new NatureHorizonsBoatRenderer(context, false, PINE_CHEST_BOAT, PINE_BOAT, NatureHorizonsModelLayers.PINE_CHEST_BOAT, NatureHorizonsModelLayers.PINE_BOAT));
        event.registerEntityRenderer(NatureHorizonsEntityTypes.PINE_CHEST_BOAT.get(),
                (context) -> new NatureHorizonsBoatRenderer(context, true, PINE_CHEST_BOAT, PINE_BOAT, NatureHorizonsModelLayers.PINE_CHEST_BOAT, NatureHorizonsModelLayers.PINE_BOAT));
        event.registerEntityRenderer(NatureHorizonsEntityTypes.REDWOOD_BOAT.get(),
                (context) -> new NatureHorizonsBoatRenderer(context, false, REDWOOD_CHEST_BOAT, REDWOOD_BOAT, NatureHorizonsModelLayers.REDWOOD_CHEST_BOAT, NatureHorizonsModelLayers.REDWOOD_BOAT));
        event.registerEntityRenderer(NatureHorizonsEntityTypes.REDWOOD_CHEST_BOAT.get(),
                (context) -> new NatureHorizonsBoatRenderer(context, true, REDWOOD_CHEST_BOAT, REDWOOD_BOAT, NatureHorizonsModelLayers.REDWOOD_CHEST_BOAT, NatureHorizonsModelLayers.REDWOOD_BOAT));
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(NatureHorizonsModelLayers.ASPEN_BOAT, BoatModel::createBodyModel);
        event.registerLayerDefinition(NatureHorizonsModelLayers.ASPEN_CHEST_BOAT, ChestBoatModel::createBodyModel);
        event.registerLayerDefinition(NatureHorizonsModelLayers.BLACK_WALNUT_BOAT, BoatModel::createBodyModel);
        event.registerLayerDefinition(NatureHorizonsModelLayers.BLACK_WALNUT_CHEST_BOAT, ChestBoatModel::createBodyModel);
        event.registerLayerDefinition(NatureHorizonsModelLayers.BLACKWOOD_BOAT, BoatModel::createBodyModel);
        event.registerLayerDefinition(NatureHorizonsModelLayers.BLACKWOOD_CHEST_BOAT, ChestBoatModel::createBodyModel);
        event.registerLayerDefinition(NatureHorizonsModelLayers.JAPANESE_MAPLE_BOAT, BoatModel::createBodyModel);
        event.registerLayerDefinition(NatureHorizonsModelLayers.JAPANESE_MAPLE_CHEST_BOAT, ChestBoatModel::createBodyModel);
        event.registerLayerDefinition(NatureHorizonsModelLayers.JUNIPER_BOAT, BoatModel::createBodyModel);
        event.registerLayerDefinition(NatureHorizonsModelLayers.JUNIPER_CHEST_BOAT, ChestBoatModel::createBodyModel);
        event.registerLayerDefinition(NatureHorizonsModelLayers.AURIC_BOAT, BoatModel::createBodyModel);
        event.registerLayerDefinition(NatureHorizonsModelLayers.AURIC_CHEST_BOAT, ChestBoatModel::createBodyModel);
        event.registerLayerDefinition(NatureHorizonsModelLayers.PINE_BOAT, BoatModel::createBodyModel);
        event.registerLayerDefinition(NatureHorizonsModelLayers.PINE_CHEST_BOAT, ChestBoatModel::createBodyModel);
        event.registerLayerDefinition(NatureHorizonsModelLayers.REDWOOD_BOAT, BoatModel::createBodyModel);
        event.registerLayerDefinition(NatureHorizonsModelLayers.REDWOOD_CHEST_BOAT, ChestBoatModel::createBodyModel);
    }
}
