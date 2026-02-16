package net.ziemniak.whythereisasushi.block.entity;

import net.minecraft.block.entity.*;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.text.Text;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.*;
import net.ziemniak.whythereisasushi.screen.SushiTrayScreenHandler;

public class SushiTrayBlockEntity extends BlockEntity implements NamedScreenHandlerFactory {

    public SushiTrayBlockEntity(BlockPos pos, BlockState state) {
        super(SushiBlockEntities.SUSHI_TRAY_ENTITY, pos, state);
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Sushi Tray");
    }

    @Override
    public ScreenHandler createMenu(int syncId,
                                    PlayerInventory playerInventory,
                                    net.minecraft.entity.player.PlayerEntity player) {
        return new SushiTrayScreenHandler(syncId, playerInventory);
    }

}
