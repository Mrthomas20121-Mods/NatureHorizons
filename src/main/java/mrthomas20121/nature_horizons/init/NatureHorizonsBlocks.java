package mrthomas20121.nature_horizons.init;

import mrthomas20121.nature_horizons.NatureHorizons;
import mrthomas20121.nature_horizons.worldgen.tree.*;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
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

    public static ItemObject<Block> ROCKSALT = BLOCKS.register("rocksalt", () -> new HalfTransparentBlock(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.CLAY).sound(SoundType.AMETHYST)),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static ItemObject<LeavesBlock> ASPEN_LEAVES = BLOCKS.register("aspen_leaves", () -> leaves(SoundType.GRASS),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static ItemObject<SaplingBlock> ASPEN_SAPLING = BLOCKS.register("aspen_sapling", () -> sapling(new AspenTreeGrower()),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static WoodBlockObject ASPEN = BLOCKS.registerWood("aspen",
            (wood -> BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.WOOD).ignitedByLava()), true);

    public static ItemObject<LeavesBlock> BALSA_LEAVES = BLOCKS.register("balsa_leaves", () -> leaves(SoundType.GRASS),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static ItemObject<SaplingBlock> BALSA_SAPLING = BLOCKS.register("balsa_sapling", () -> sapling(new BalsaTreeGrower()),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static WoodBlockObject BALSA = BLOCKS.registerWood("balsa",
            (wood -> BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).ignitedByLava()), true);

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

    public static ItemObject<LeavesBlock> WHITE_IPE_LEAVES = BLOCKS.register("white_ipe_leaves", () -> leaves(SoundType.GRASS),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static ItemObject<SaplingBlock> WHITE_IPE_SAPLING = BLOCKS.register("white_ipe_sapling", () -> sapling(new WhiteIpeTreeGrower()),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static ItemObject<LeavesBlock> GOLDEN_IPE_LEAVES = BLOCKS.register("golden_ipe_leaves", () -> leaves(SoundType.GRASS),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static ItemObject<SaplingBlock> GOLDEN_IPE_SAPLING = BLOCKS.register("golden_ipe_sapling", () -> sapling(new GoldenIpeTreeGrower()),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static ItemObject<LeavesBlock> PINK_IPE_LEAVES = BLOCKS.register("pink_ipe_leaves", () -> leaves(SoundType.GRASS),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static ItemObject<SaplingBlock> PINK_IPE_SAPLING = BLOCKS.register("pink_ipe_sapling", () -> sapling(new PinkIpeTreeGrower()),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static WoodBlockObject IPE = BLOCKS.registerWood("ipe",
            (wood -> BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).ignitedByLava()), true);

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

    public static ItemObject<SaplingBlock> ORANGE_JAPANESE_MAPLE_SAPLING = BLOCKS.register("orange_japanese_maple_sapling", () -> sapling(new OrangeJapaneseMapleTreeGrower()),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static WoodBlockObject JAPANESE_MAPLE = BLOCKS.registerWood("japanese_maple",
            (wood -> BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).sound(SoundType.WOOD).ignitedByLava()), true);

    public static ItemObject<LeavesBlock> JUNIPER_LEAVES = BLOCKS.register("juniper_leaves", () -> leaves(SoundType.GRASS),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static ItemObject<SaplingBlock> JUNIPER_SAPLING = BLOCKS.register("juniper_sapling", () -> sapling(new JuniperTreeGrower()),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static WoodBlockObject JUNIPER = BLOCKS.registerWood("juniper",
            (wood -> BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).ignitedByLava()), true);

    public static ItemObject<LeavesBlock> MAHOGANY_LEAVES = BLOCKS.register("mahogany_leaves", () -> leaves(SoundType.GRASS),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static ItemObject<SaplingBlock> MAHOGANY_SAPLING = BLOCKS.register("mahogany_sapling", () -> sapling(new MahoganyTreeGrower()),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static WoodBlockObject MAHOGANY = BLOCKS.registerWood("mahogany",
            (wood -> BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).ignitedByLava()), true);

    public static ItemObject<LeavesBlock> NANMU_LEAVES = BLOCKS.register("nanmu_leaves", () -> leaves(SoundType.GRASS),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static ItemObject<SaplingBlock> NANMU_SAPLING = BLOCKS.register("nanmu_sapling", () -> sapling(new NanmuTreeGrower()),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static WoodBlockObject NANMU = BLOCKS.registerWood("nanmu",
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

    public static ItemObject<LeavesBlock> WILLOW_LEAVES = BLOCKS.register("willow_leaves", () -> leaves(SoundType.GRASS),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static ItemObject<SaplingBlock> WILLOW_SAPLING = BLOCKS.register("willow_sapling", () -> sapling(new RedwoodTreeGrower()),
            (block) -> new BlockItem(block, new Item.Properties()));

    public static WoodBlockObject WILLOW = BLOCKS.registerWood("willow",
            (wood -> BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).ignitedByLava()), true);

    public static List<WoodBlockObject> WOODS = List.of(ASPEN, BALSA, BLACK_WALNUT, BLACKWOOD, IPE, JAPANESE_MAPLE, JUNIPER, MAHOGANY, NANMU, PINE, REDWOOD, WILLOW);

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
        addCompostableWithSameChance(0.3f, NANMU_SAPLING, NANMU_LEAVES);
        addCompostableWithSameChance(0.3f, PINE_SAPLING, PINE_LEAVES);
        addCompostableWithSameChance(0.3f, REDWOOD_SAPLING, REDWOOD_LEAVES);
        addCompostableWithSameChance(0.3f, WILLOW_SAPLING, WILLOW_LEAVES);
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
