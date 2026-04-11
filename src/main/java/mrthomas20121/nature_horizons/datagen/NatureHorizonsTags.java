package mrthomas20121.nature_horizons.datagen;

import mrthomas20121.nature_horizons.NatureHorizons;
import mrthomas20121.nature_horizons.init.NatureHorizonsBlocks;
import mrthomas20121.nature_horizons.init.NatureHorizonsItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.registration.object.WoodBlockObject;

import java.util.concurrent.CompletableFuture;

public class NatureHorizonsTags {

    public static TagKey<Block> CAN_BREAK_HARD_WALNUT = BlockTags.create(NatureHorizons.getResource("can_break_hard_walnut"));

    public static void init() {}

    public static class Blocks extends BlockTagsProvider {

        public Blocks(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, lookupProvider, NatureHorizons.MOD_ID, existingFileHelper);
        }

        @Override
        @SuppressWarnings("unchecked")
        protected void addTags(HolderLookup.Provider provider) {

            tag(BlockTags.LEAVES).add(
                    NatureHorizonsBlocks.ASPEN_LEAVES.get(), NatureHorizonsBlocks.BLACKWOOD_LEAVES.get(), NatureHorizonsBlocks.JUNIPER_LEAVES.get(), NatureHorizonsBlocks.PINE_LEAVES.get());

            tag(CAN_BREAK_HARD_WALNUT).addTags(Tags.Blocks.STONE, Tags.Blocks.COBBLESTONE, BlockTags.OVERWORLD_NATURAL_LOGS);

            for(WoodBlockObject blockObject: NatureHorizonsBlocks.WOODS) {
                tag(CAN_BREAK_HARD_WALNUT).addTag(blockObject.getLogBlockTag());
                tag(BlockTags.MINEABLE_WITH_AXE).add(blockObject.getFenceGate(), blockObject.getPressurePlate(), blockObject.getSign(), blockObject.getHangingSign()).addTag(blockObject.getLogBlockTag());
                tag(BlockTags.WOODEN_FENCES).add(blockObject.getFence());
                tag(BlockTags.FENCES).add(blockObject.getFence());
                tag(BlockTags.WOODEN_BUTTONS).add(blockObject.getButton());
                tag(BlockTags.WOODEN_DOORS).add(blockObject.getDoor());
                tag(BlockTags.WOODEN_TRAPDOORS).add(blockObject.getTrapdoor());
                tag(BlockTags.WOODEN_SLABS).add(blockObject.getSlab());
                tag(BlockTags.WOODEN_STAIRS).add(blockObject.getStairs());
                tag(BlockTags.PLANKS).add(blockObject.get());
                tag(BlockTags.LOGS_THAT_BURN).add(blockObject.getLog(), blockObject.getStrippedLog());
                tag(blockObject.getLogBlockTag()).add(blockObject.getLog(), blockObject.getStrippedLog(), blockObject.getWood(), blockObject.getStrippedWood());
                tag(BlockTags.OVERWORLD_NATURAL_LOGS).addTag(blockObject.getLogBlockTag());
            }
        }
    }

    public static class Items extends ItemTagsProvider {

        public Items(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
            super(p_275343_, p_275729_, p_275322_, NatureHorizons.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {

            tag(ItemTags.PIGLIN_LOVED).add(NatureHorizonsItems.GOLDEN_WALNUT.get(), NatureHorizonsItems.GOLDEN_JUNIPER_BERRY.get());

            for(WoodBlockObject blockObject: NatureHorizonsBlocks.WOODS) {
                tag(ItemTags.WOODEN_FENCES).add(blockObject.getFence().asItem());
                tag(ItemTags.FENCES).add(blockObject.getFence().asItem());

                tag(ItemTags.WOODEN_BUTTONS).add(blockObject.getButton().asItem());
                tag(ItemTags.WOODEN_DOORS).add(blockObject.getDoor().asItem());
                tag(ItemTags.WOODEN_TRAPDOORS).add(blockObject.getTrapdoor().asItem());
                tag(ItemTags.SLABS).add(blockObject.getSlab().asItem());
                tag(ItemTags.WOODEN_STAIRS).add(blockObject.getStairs().asItem());
                tag(ItemTags.PLANKS).add(blockObject.get().asItem());
                tag(ItemTags.LOGS_THAT_BURN).add(blockObject.getLog().asItem(), blockObject.getStrippedLog().asItem());
                tag(blockObject.getLogItemTag()).add(blockObject.getLog().asItem(), blockObject.getStrippedLog().asItem(), blockObject.getWood().asItem(), blockObject.getStrippedWood().asItem());
            }
        }
    }
}
