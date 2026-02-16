package net.ziemniak.whythereisasushi;

import net.fabricmc.api.ModInitializer;
import net.ziemniak.whythereisasushi.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Whythereisasushi implements ModInitializer {
	public static final String MOD_ID = "whythereisasushi";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback.EVENT.register((stack, context, type, lines) -> {
			if (stack.isOf(ModItems.CHOPSTICKS)) {
				lines.add(net.minecraft.text.Text.translatable("item.whythereisasushi.chopsticks.description")
						.formatted(net.minecraft.util.Formatting.GRAY, net.minecraft.util.Formatting.ITALIC));
			}
		});
	}
}