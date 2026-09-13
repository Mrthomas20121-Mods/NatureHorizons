package mrthomas20121.nature_horizons.datagen;

import mrthomas20121.nature_horizons.NatureHorizons;
import mrthomas20121.nature_horizons.init.NatureHorizonsBlocks;
import mrthomas20121.nature_horizons.init.NatureHorizonsItems;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import slimeknights.mantle.registration.object.WoodBlockObject;

import java.util.Map;
import java.util.Set;

public class NatureHorizonsBlockLoot extends BlockLootSubProvider {

    protected static final LootItemCondition.Builder HAS_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))));
    protected static final LootItemCondition.Builder HAS_NO_SILK_TOUCH = HAS_SILK_TOUCH.invert();
    protected static final LootItemCondition.Builder HAS_SHEARS = MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS));
    private static final LootItemCondition.Builder HAS_SHEARS_OR_SILK_TOUCH = HAS_SHEARS.or(HAS_SILK_TOUCH);
    private static final LootItemCondition.Builder HAS_NO_SHEARS_OR_SILK_TOUCH = HAS_SHEARS_OR_SILK_TOUCH.invert();

    protected NatureHorizonsBlockLoot() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getEntries().stream()
                .filter((entry) -> entry.getKey().location().getNamespace().equals(NatureHorizons.MOD_ID))
                .map(Map.Entry::getValue).toList();
    }

    @Override
    protected void generate() {

        this.add(NatureHorizonsBlocks.ASPEN_LEAVES.get(), (block) -> createLeavesDrops(block, NatureHorizonsBlocks.ASPEN_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(NatureHorizonsBlocks.BLACK_WALNUT_LEAVES.get(), (block) -> createFruitLeavesDrops(block, NatureHorizonsBlocks.BLACK_WALNUT_SAPLING.get(), NatureHorizonsItems.HARD_WALNUT.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(NatureHorizonsBlocks.BLACKWOOD_LEAVES.get(), (block) -> createLeavesDrops(block, NatureHorizonsBlocks.BLACKWOOD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(NatureHorizonsBlocks.JAPANESE_MAPLE_LEAVES.get(), (block) -> createLeavesDrops(block, NatureHorizonsBlocks.JAPANESE_MAPLE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(NatureHorizonsBlocks.CRIMSON_JAPANESE_MAPLE_LEAVES.get(), (block) -> createLeavesDrops(block, NatureHorizonsBlocks.CRIMSON_JAPANESE_MAPLE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(NatureHorizonsBlocks.ORANGE_JAPANESE_MAPLE_LEAVES.get(), (block) -> createLeavesDrops(block, NatureHorizonsBlocks.ORANGE_JAPANESE_MAPLE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(NatureHorizonsBlocks.JUNIPER_LEAVES.get(), (block) -> createFruitLeavesDrops(block, NatureHorizonsBlocks.JUNIPER_SAPLING.get(), NatureHorizonsItems.JUNIPER_BERRY.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(NatureHorizonsBlocks.AURIC_LEAVES.get(), (block) -> createLeavesDrops(block, NatureHorizonsBlocks.AURIC_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(NatureHorizonsBlocks.PINE_LEAVES.get(), (block) -> createLeavesDrops(block, NatureHorizonsBlocks.PINE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(NatureHorizonsBlocks.REDWOOD_LEAVES.get(), (block) -> createLeavesDrops(block, NatureHorizonsBlocks.REDWOOD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(NatureHorizonsBlocks.ASPEN_SAPLING.get());
        this.dropSelf(NatureHorizonsBlocks.BLACK_WALNUT_SAPLING.get());
        this.dropSelf(NatureHorizonsBlocks.BLACKWOOD_SAPLING.get());
        this.dropSelf(NatureHorizonsBlocks.JAPANESE_MAPLE_SAPLING.get());
        this.dropSelf(NatureHorizonsBlocks.CRIMSON_JAPANESE_MAPLE_SAPLING.get());
        this.dropSelf(NatureHorizonsBlocks.ORANGE_JAPANESE_MAPLE_SAPLING.get());
        this.dropSelf(NatureHorizonsBlocks.JUNIPER_SAPLING.get());
        this.dropSelf(NatureHorizonsBlocks.AURIC_SAPLING.get());
        this.dropSelf(NatureHorizonsBlocks.PINE_SAPLING.get());
        this.dropSelf(NatureHorizonsBlocks.REDWOOD_SAPLING.get());

        wood(NatureHorizonsBlocks.ASPEN);
        wood(NatureHorizonsBlocks.BLACK_WALNUT);
        wood(NatureHorizonsBlocks.BLACKWOOD);
        wood(NatureHorizonsBlocks.JAPANESE_MAPLE);
        wood(NatureHorizonsBlocks.JUNIPER);
        wood(NatureHorizonsBlocks.AURIC);
        wood(NatureHorizonsBlocks.PINE);
        wood(NatureHorizonsBlocks.REDWOOD);
    }

    private void wood(WoodBlockObject wood) {
        dropSelf(wood.get());
        dropSelf(wood.getButton());
        dropSelf(wood.getPressurePlate());
        this.add(wood.getDoor(), this::createDoorTable);
        dropSelf(wood.getTrapdoor());
        dropSelf(wood.getFence());
        dropSelf(wood.getFenceGate());
        dropSelf(wood.getSign());
        dropSelf(wood.getHangingSign());
        dropSelf(wood.getLog());
        dropSelf(wood.getStrippedLog());
        dropSelf(wood.getWood());
        dropSelf(wood.getStrippedWood());
        dropSelf(wood.getSlab());
        dropSelf(wood.getStairs());
    }

    protected LootTable.Builder createFruitLeavesDrops(Block p_249535_, Block p_251505_, Item fruit, float... p_250753_) {
        return this.createLeavesDrops(p_249535_, p_251505_, p_250753_).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(HAS_NO_SHEARS_OR_SILK_TOUCH).add(this.applyExplosionCondition(p_249535_, LootItem.lootTableItem(fruit)).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F))));
    }
}
