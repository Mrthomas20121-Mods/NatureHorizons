package mrthomas20121.nature_horizons.item;

import mrthomas20121.nature_horizons.datagen.NatureHorizonsTags;
import mrthomas20121.nature_horizons.init.NatureHorizonsItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HardWalnutItem extends Item {

    public HardWalnutItem() {
        super(new Properties());
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> tooltip, TooltipFlag tooltipFlag) {
        tooltip.add(Component.translatable("item.nature_horizons.hard_walnut_item.tooltip"));
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        BlockPos clickedPos = context.getClickedPos();
        BlockState blockState = context.getLevel().getBlockState(clickedPos);
        Player player = context.getPlayer();
        if(blockState.is(NatureHorizonsTags.CAN_BREAK_HARD_WALNUT) && player != null) {
            ItemStack mainHandItem = player.getMainHandItem();
            if(mainHandItem.is(NatureHorizonsItems.HARD_WALNUT.get())) {
                if(!player.isCreative()) {
                    mainHandItem.shrink(1);
                }
                player.getInventory().add(new ItemStack(NatureHorizonsItems.WALNUT.get()));
                if(!context.getLevel().isClientSide) {
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return super.useOn(context);
    }
}
