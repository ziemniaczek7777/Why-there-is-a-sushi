package net.ziemniak.whythereisasushi;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.BlockRenderLayer;
import net.ziemniak.whythereisasushi.block.ModBlocks;
import net.ziemniak.whythereisasushi.screen.SushiScreenHandlers;
import net.ziemniak.whythereisasushi.screen.SushiTrayScreen;
import net.ziemniak.whythereisasushi.screen.SushiTrayScreenHandler;


public class WhythereisasushiClient implements ClientModInitializer {
    @Override
    public void onInitializeClient(){
        BlockRenderLayerMap.putBlock(ModBlocks.RICE_CROP, BlockRenderLayer.CUTOUT);
        HandledScreens.register(
                SushiScreenHandlers.SUSHI_TRAY,
                SushiTrayScreen::new
        );
    }
}
