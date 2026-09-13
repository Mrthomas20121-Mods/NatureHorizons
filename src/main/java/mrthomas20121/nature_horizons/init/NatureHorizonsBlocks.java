package mrthomas20121.nature_horizons.init;

import mrthomas20121.nature_horizons.NatureHorizons;
import mrthomas20121.nature_horizons.block.SandSaplingBlock;
import mrthomas20121.nature_horizons.worldgen.tree.*;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import slimeknights.mantle.registration.deferred.BlockDeferredRegister;
import slimeknights.mantle.registration.object.ItemObject;
import slimeknights.mantle.registration.object.WoodBlockObject;

import java.util.List;

public class NatureHorizonsBlocks {

    public static BlockDeferredRegister BLOCKS = new BlockDeferredRegister(NatureHorizons.MOD_ID);

    public static ItemObject<LeavesBlock> ASPEN_LEAVES = BLOCKS.register("aspen_leaves", () -> leaves(SoundType.GRASS),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static ItemObject<SaplingBlock> ASPEN_SAPLING = BLOCKS.register("aspen_sapling", () -> sapling(new AspenTreeGrower()),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static WoodBlockObject ASPEN = BLOCKS.registerWood("aspen",
            (wood -> BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.WOOD).ignitedByLava()), true);

    public static ItemObject<LeavesBlock> BLACK_WALNUT_LEAVES = BLOCKS.register("black_walnut_leaves", () -> leaves(SoundType.GRASS),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static ItemObject<SaplingBlock> BLACK_WALNUT_SAPLING = BLOCKS.register("black_walnut_sapling", () -> sapling(new BlackWalnutTreeGrower()),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static WoodBlockObject BLACK_WALNUT = BLOCKS.registerWood("black_walnut",
            (wood -> BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).sound(SoundType.WOOD).ignitedByLava()), true);

    public static ItemObject<LeavesBlock> BLACKWOOD_LEAVES = BLOCKS.register("blackwood_leaves", () -> leaves(SoundType.GRASS),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static ItemObject<SaplingBlock> BLACKWOOD_SAPLING = BLOCKS.register("blackwood_sapling", () -> sapling(new BlackwoodTreeGrower()),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static WoodBlockObject BLACKWOOD = BLOCKS.registerWood("blackwood",
            (wood -> BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK).sound(SoundType.WOOD).ignitedByLava()), true);

    public static ItemObject<LeavesBlock> JAPANESE_MAPLE_LEAVES = BLOCKS.register("japanese_maple_leaves", () -> leaves(SoundType.GRASS),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static ItemObject<SaplingBlock> JAPANESE_MAPLE_SAPLING = BLOCKS.register("japanese_maple_sapling", () -> sapling(new JapaneseMapleTreeGrower()),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static ItemObject<LeavesBlock> CRIMSON_JAPANESE_MAPLE_LEAVES = BLOCKS.register("crimson_japanese_maple_leaves", () -> leaves(SoundType.GRASS),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static ItemObject<SaplingBlock> CRIMSON_JAPANESE_MAPLE_SAPLING = BLOCKS.register("crimson_japanese_maple_sapling", () -> sapling(new CrismonJapaneseMapleTreeGrower()),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static ItemObject<LeavesBlock> ORANGE_JAPANESE_MAPLE_LEAVES = BLOCKS.register("orange_japanese_maple_leaves", () -> leaves(SoundType.GRASS),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static ItemObject<SaplingBlock> ORANGE_JAPANESE_MAPLE_SAPLING = BLOCKS.register("orange_japanese_maple_sapling", () -> sapling(new ORangeJapaneseMapleTreeGrower()),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static WoodBlockObject JAPANESE_MAPLE = BLOCKS.registerWood("japanese_maple",
            (wood -> BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).sound(SoundType.WOOD).ignitedByLava()), true);

    public static ItemObject<LeavesBlock> JUNIPER_LEAVES = BLOCKS.register("juniper_leaves", () -> leaves(SoundType.GRASS),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static ItemObject<SaplingBlock> JUNIPER_SAPLING = BLOCKS.register("juniper_sapling", () -> sapling(new JuniperTreeGrower()),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static WoodBlockObject JUNIPER = BLOCKS.registerWood("juniper",
            (wood -> BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).ignitedByLava()), true);

    public static ItemObject<LeavesBlock> AURIC_LEAVES = BLOCKS.register("auric_leaves", () -> leaves(SoundType.GRASS),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static ItemObject<SandSaplingBlock> AURIC_SAPLING = BLOCKS.register("auric_sapling", () -> sandSapling(new AuricTreeGrower()),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static WoodBlockObject AURIC = BLOCKS.registerWood("auric",
            (wood -> BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).sound(SoundType.WOOD).ignitedByLava()), true);

    public static ItemObject<LeavesBlock> PINE_LEAVES = BLOCKS.register("pine_leaves", () -> leaves(SoundType.GRASS),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static ItemObject<SaplingBlock> PINE_SAPLING = BLOCKS.register("pine_sapling", () -> sapling(new PineTreeGrower()),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static WoodBlockObject PINE = BLOCKS.registerWood("pine",
            (wood -> BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).sound(SoundType.WOOD).ignitedByLava()), true);

    public static ItemObject<LeavesBlock> REDWOOD_LEAVES = BLOCKS.register("redwood_leaves", () -> leaves(SoundType.GRASS),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static ItemObject<SaplingBlock> REDWOOD_SAPLING = BLOCKS.register("redwood_sapling", () -> sapling(new RedwoodTreeGrower()),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static WoodBlockObject REDWOOD = BLOCKS.registerWood("redwood",
            (wood -> BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).sound(SoundType.WOOD).ignitedByLava()), true);

    public static List<WoodBlockObject> WOODS = List.of(ASPEN, BLACK_WALNUT, BLACKWOOD, JUNIPER, AURIC, PINE, REDWOOD, JAPANESE_MAPLE);

    public static void initCompostable() {
        addCompostableWithSameChance(0.3f, ASPEN_SAPLING, ASPEN_LEAVES);
        addCompostableWithSameChance(0.3f, BLACK_WALNUT_SAPLING, BLACK_WALNUT_LEAVES);
        addCompostable(0.75f, NatureHorizonsItems.WALNUT);
        addCompostable(0.55f, NatureHorizonsItems.HARD_WALNUT);
        addCompostableWithSameChance(0.3f, BLACKWOOD_SAPLING, BLACKWOOD_SAPLING);
        addCompostableWithSameChance(0.3f,
                JAPANESE_MAPLE_LEAVES, JAPANESE_MAPLE_SAPLING,
                CRIMSON_JAPANESE_MAPLE_LEAVES, CRIMSON_JAPANESE_MAPLE_SAPLING,
                ORANGE_JAPANESE_MAPLE_LEAVES, ORANGE_JAPANESE_MAPLE_SAPLING);
        addCompostableWithSameChance(0.3f, JUNIPER_SAPLING, JUNIPER_LEAVES);
        addCompostable(0.65f, NatureHorizonsItems.JUNIPER_BERRY);
        addCompostableWithSameChance(0.3f, AURIC_SAPLING, AURIC_LEAVES);
        addCompostableWithSameChance(0.3f, PINE_SAPLING, PINE_LEAVES);
        addCompostableWithSameChance(0.3f, REDWOOD_SAPLING, REDWOOD_LEAVES);
    }

    private static void addCompostable(float chance, ItemLike itemLike) {
        ComposterBlock.COMPOSTABLES.put(itemLike.asItem(), chance);
    }

    private static void addCompostableWithSameChance(float chance, ItemLike... items) {
        for(ItemLike item: items) {
            addCompostable(chance, item);
        }
    }

    private static SaplingBlock sapling(AbstractTreeGrower grower) {
        return new SaplingBlock(grower, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY));
    }

    private static SandSaplingBlock sandSapling(AbstractTreeGrower grower) {
        return new SandSaplingBlock(grower, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY));
    }

    private static LeavesBlock leaves(SoundType p_152615_) {
        return new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.2F).randomTicks().sound(p_152615_).noOcclusion().isValidSpawn(NatureHorizonsBlocks::ocelotOrParrot).isSuffocating(NatureHorizonsBlocks::never).isViewBlocking(NatureHorizonsBlocks::never).ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor(NatureHorizonsBlocks::never));
    }

    private static boolean never(BlockState p_50806_, BlockGetter p_50807_, BlockPos p_50808_) {
        return false;
    }

    private static Boolean ocelotOrParrot(BlockState p_50822_, BlockGetter p_50823_, BlockPos p_50824_, EntityType<?> p_50825_) {
        return p_50825_ == EntityType.OCELOT || p_50825_ == EntityType.PARROT;
    }
}
