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

    public static final RegistryObject<EntityType<JapaneseMapleBoat>> JAPANESE_MAPLE_BOAT = ENTITY_TYPES.register("japanese_maple_boat",
            () -> EntityType.Builder.<JapaneseMapleBoat>of(JapaneseMapleBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10));

    public static final RegistryObject<EntityType<JapaneseMapleChestBoat>> JAPANESE_MAPLE_CHEST_BOAT = ENTITY_TYPES.register("japanese_maple_chest_boat",
            () -> EntityType.Builder.<JapaneseMapleChestBoat>of(JapaneseMapleChestBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10));

    public static final RegistryObject<EntityType<JuniperBoat>> JUNIPER_BOAT = ENTITY_TYPES.register("juniper_boat",
            () -> EntityType.Builder.<JuniperBoat>of(JuniperBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10));

    public static final RegistryObject<EntityType<JuniperChestBoat>> JUNIPER_CHEST_BOAT = ENTITY_TYPES.register("juniper_chest_boat",
            () -> EntityType.Builder.<JuniperChestBoat>of(JuniperChestBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10));

    public static final RegistryObject<EntityType<PineBoat>> PINE_BOAT = ENTITY_TYPES.register("pine_boat",
            () -> EntityType.Builder.<PineBoat>of(PineBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10));

    public static final RegistryObject<EntityType<PineChestBoat>> PINE_CHEST_BOAT = ENTITY_TYPES.register("pine_chest_boat",
            () -> EntityType.Builder.<PineChestBoat>of(PineChestBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10));

    public static final RegistryObject<EntityType<RedwoodBoat>> REDWOOD_BOAT = ENTITY_TYPES.register("redwood_boat",
            () -> EntityType.Builder.<RedwoodBoat>of(RedwoodBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10));

    public static final RegistryObject<EntityType<RedwoodChestBoat>> REDWOOD_CHEST_BOAT = ENTITY_TYPES.register("redwood_chest_boat",
            () -> EntityType.Builder.<RedwoodChestBoat>of(RedwoodChestBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10));
}
