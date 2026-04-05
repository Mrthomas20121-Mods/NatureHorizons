package mrthomas20121.nature_horizons.datagen;

import mrthomas20121.nature_horizons.NatureHorizons;
import mrthomas20121.nature_horizons.init.NatureHorizonsBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.registration.object.WoodBlockObject;

import java.util.concurrent.CompletableFuture;

public class NatureHorizonsTags {

    public static class Blocks extends BlockTagsProvider {

        public Blocks(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, lookupProvider, NatureHorizons.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            for(WoodBlockObject blockObject: NatureHorizonsBlocks.WOODS) {
                tag(BlockTags.WOODEN_FENCES).add(blockObject.getFence());
                tag(BlockTags.FENCES).add(blockObject.getFence());

                tag(BlockTags.WOODEN_BUTTONS).add(blockObject.getButton());
                tag(BlockTags.WOODEN_DOORS).add(blockObject.getDoor());
                tag(BlockTags.WOODEN_TRAPDOORS).add(blockObject.getTrapdoor());
                tag(BlockTags.SLABS).add(blockObject.getSlab());
                tag(BlockTags.WOODEN_STAIRS).add(blockObject.getStairs());
                tag(BlockTags.PLANKS).add(blockObject.get());
            }
        }
    }

    public static class Items extends ItemTagsProvider {

        public Items(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
            super(p_275343_, p_275729_, p_275322_, NatureHorizons.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {}
    }
}
