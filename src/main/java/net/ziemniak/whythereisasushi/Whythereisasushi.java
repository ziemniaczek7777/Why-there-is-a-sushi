package net.ziemniak.whythereisasushi;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.ComposterBlock;
import net.ziemniak.whythereisasushi.block.ModBlocks;
import net.ziemniak.whythereisasushi.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Whythereisasushi implements ModInitializer {
	public static final String MOD_ID = "whythereisasushi";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(
				ModItems.RICE_SEEDS,0.3F

		);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(
				ModItems.RICE,0.5F

		);
	}
}