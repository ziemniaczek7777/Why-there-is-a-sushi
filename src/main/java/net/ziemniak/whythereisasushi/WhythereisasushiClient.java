package net.ziemniak.whythereisasushi;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.BlockRenderLayer;
import net.ziemniak.whythereisasushi.block.ModBlocks;


public class WhythereisasushiClient implements ClientModInitializer {
    @Override
    public void onInitializeClient(){
        BlockRenderLayerMap.putBlock(ModBlocks.RICE_CROP, BlockRenderLayer.CUTOUT);

    }
}
