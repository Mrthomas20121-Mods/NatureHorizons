package mrthomas20121.nature_horizons.init;

import mrthomas20121.nature_horizons.NatureHorizons;
import mrthomas20121.nature_horizons.entity.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.mantle.registration.deferred.EntityTypeDeferredRegister;

public class NatureHorizonsEntityTypes {

    public static EntityTypeDeferredRegister ENTITY_TYPES = new EntityTypeDeferredRegister(NatureHorizons.MOD_ID);

    public static final RegistryObject<EntityType<AspenBoat>> ASPEN_BOAT = ENTITY_TYPES.register("aspen_boat",
            () -> EntityType.Builder.<AspenBoat>of(AspenBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10));

    public static final RegistryObject<EntityType<AspenChestBoat>> ASPEN_CHEST_BOAT = ENTITY_TYPES.register("aspen_chest_boat",
            () -> EntityType.Builder.<AspenChestBoat>of(AspenChestBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10));

    public static final RegistryObject<EntityType<BlackWalnutBoat>> BLACK_WALNUT_BOAT = ENTITY_TYPES.register("black_walnut_boat",
            () -> EntityType.Builder.<BlackWalnutBoat>of(BlackWalnutBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10));

    public static final RegistryObject<EntityType<BlackWalnutChestBoat>> BLACK_WALNUT_CHEST_BOAT = ENTITY_TYPES.register("black_walnut_chest_boat",
            () -> EntityType.Builder.<BlackWalnutChestBoat>of(BlackWalnutChestBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10));

    public static final RegistryObject<EntityType<BlackwoodBoat>> BLACKWOOD_BOAT = ENTITY_TYPES.register("blackwood_boat",
            () -> EntityType.Builder.<BlackwoodBoat>of(BlackwoodBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10));

    public static final RegistryObject<EntityType<BlackwoodChestBoat>> BLACKWOOD_CHEST_BOAT = ENTITY_TYPES.register("blackwood_chest_boat",
            () -> EntityType.Builder.<BlackwoodChestBoat>of(BlackwoodChestBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10));

    public static final RegistryObject<EntityType<AspenBoat>> JUNIPER_BOAT = ENTITY_TYPES.register("juniper_boat",
            () -> EntityType.Builder.<AspenBoat>of(AspenBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10));

    public static final RegistryObject<EntityType<AspenChestBoat>> JUNIPER_CHEST_BOAT = ENTITY_TYPES.register("juniper_chest_boat",
            () -> EntityType.Builder.<AspenChestBoat>of(AspenChestBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10));

    public static final RegistryObject<EntityType<AspenBoat>> PINE_BOAT = ENTITY_TYPES.register("pine_boat",
            () -> EntityType.Builder.<AspenBoat>of(AspenBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10));

    public static final RegistryObject<EntityType<AspenChestBoat>> PINE_CHEST_BOAT = ENTITY_TYPES.register("pine_chest_boat",
            () -> EntityType.Builder.<AspenChestBoat>of(AspenChestBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10));
}
