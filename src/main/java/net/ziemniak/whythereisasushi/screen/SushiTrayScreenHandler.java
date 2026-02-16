package net.ziemniak.whythereisasushi.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.item.ItemStack;

public class SushiTrayScreenHandler extends ScreenHandler {

    public final Inventory inputInventory = new SimpleInventory(3);
    public final Inventory outputInventory = new SimpleInventory(1);

    public SushiTrayScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(SushiScreenHandlers.SUSHI_TRAY, syncId);

        // ------------------
        // Sloty input
        // ------------------
        int startX = 31;
        int startY = 31; // zmienione, żeby niżej
        for (int i = 0; i < 3; i++) {
            this.addSlot(new Slot(inputInventory, i, startX + i * 18, startY));
        }

        // ------------------
        // Slot output
        // ------------------
        this.addSlot(new Slot(outputInventory, 0, 121, 31) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return false;
            }
        });

        // ------------------
        // Inventory gracza
        // ------------------
        int playerStartX = 8;
        int playerStartY = 84; // zmienione, żeby niżej

        // główna część
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9,
                        playerStartX + col * 18, playerStartY + row * 18));
            }
        }

        // hotbar
        for (int col = 0; col < 9; ++col) {
            this.addSlot(new Slot(playerInventory, col, playerStartX + col * 18, playerStartY + 58));
        }
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int index) {
        return ItemStack.EMPTY;
    }
}