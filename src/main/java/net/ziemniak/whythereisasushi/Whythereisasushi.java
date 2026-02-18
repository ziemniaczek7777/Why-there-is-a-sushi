package net.ziemniak.whythereisasushi;

import net.fabricmc.api.ModInitializer;
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
		net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback.EVENT.register((stack, context, type, lines) -> {
			if (stack.isOf(ModItems.CHOPSTICKS)) {
				lines.add(net.minecraft.text.Text.translatable("item.whythereisasushi.chopsticks.description")
						.formatted(net.minecraft.util.Formatting.GRAY, net.minecraft.util.Formatting.ITALIC));
			}
			if (stack.isOf(ModItems.PUFFERFISH_MAKI)) {
				lines.add(net.minecraft.text.Text.translatable("item.whythereisasushi.pufferfish.description")
						.formatted(net.minecraft.util.Formatting.GRAY, net.minecraft.util.Formatting.ITALIC));
			}
			if (stack.isOf(ModItems.NIGIRI_PUFFERFISH)) {
				lines.add(net.minecraft.text.Text.translatable("item.whythereisasushi.pufferfish.description")
						.formatted(net.minecraft.util.Formatting.GRAY, net.minecraft.util.Formatting.ITALIC));
			}
			if (stack.isOf(ModItems.MAGMA_MAKI)) {
				lines.add(net.minecraft.text.Text.translatable("item.whythereisasushi.magma.description")
						.formatted(net.minecraft.util.Formatting.GRAY, net.minecraft.util.Formatting.ITALIC));
			}
			if (stack.isOf(ModItems.NIGIRI_MAGMA)) {
				lines.add(net.minecraft.text.Text.translatable("item.whythereisasushi.magma.description")
						.formatted(net.minecraft.util.Formatting.GRAY, net.minecraft.util.Formatting.ITALIC));
			}
			if (stack.isOf(ModItems.RABBIT_MAKI)) {
				lines.add(net.minecraft.text.Text.translatable("item.whythereisasushi.rabbit.description")
						.formatted(net.minecraft.util.Formatting.GRAY, net.minecraft.util.Formatting.ITALIC));
			}
			if (stack.isOf(ModItems.NIGIRI_RABBIT)) {
				lines.add(net.minecraft.text.Text.translatable("item.whythereisasushi.rabbit.description")
						.formatted(net.minecraft.util.Formatting.GRAY, net.minecraft.util.Formatting.ITALIC));
			}
			if (stack.isOf(ModItems.GLOW_MAKI)) {
				lines.add(net.minecraft.text.Text.translatable("item.whythereisasushi.glow.description")
						.formatted(net.minecraft.util.Formatting.GRAY, net.minecraft.util.Formatting.ITALIC));
			}
			if (stack.isOf(ModItems.NIGIRI_GLOW)) {
				lines.add(net.minecraft.text.Text.translatable("item.whythereisasushi.glow.description")
						.formatted(net.minecraft.util.Formatting.GRAY, net.minecraft.util.Formatting.ITALIC));
			}
			if (stack.isOf(ModItems.CHORUS_MAKI)) {
				lines.add(net.minecraft.text.Text.translatable("item.whythereisasushi.chorus.description")
						.formatted(net.minecraft.util.Formatting.GRAY, net.minecraft.util.Formatting.ITALIC));
			}
			if (stack.isOf(ModItems.NIGIRI_CHORUS)) {
				lines.add(net.minecraft.text.Text.translatable("item.whythereisasushi.chorus.description")
						.formatted(net.minecraft.util.Formatting.GRAY, net.minecraft.util.Formatting.ITALIC));
			}
			if (stack.isOf(ModItems.HONEY_MAKI)) {
				lines.add(net.minecraft.text.Text.translatable("item.whythereisasushi.honey.description")
						.formatted(net.minecraft.util.Formatting.GRAY, net.minecraft.util.Formatting.ITALIC));
			}
			if (stack.isOf(ModItems.NIGIRI_HONEY)) {
				lines.add(net.minecraft.text.Text.translatable("item.whythereisasushi.honey.description")
						.formatted(net.minecraft.util.Formatting.GRAY, net.minecraft.util.Formatting.ITALIC));
			}
			if (stack.isOf(ModItems.PHANTOM_MAKI)) {
				lines.add(net.minecraft.text.Text.translatable("item.whythereisasushi.phantom.description")
						.formatted(net.minecraft.util.Formatting.GRAY, net.minecraft.util.Formatting.ITALIC));
			}
			if (stack.isOf(ModItems.NIGIRI_PHANTOM)) {
				lines.add(net.minecraft.text.Text.translatable("item.whythereisasushi.phantom.description")
						.formatted(net.minecraft.util.Formatting.GRAY, net.minecraft.util.Formatting.ITALIC));
			}
			if (stack.isOf(ModItems.GOLDEN_MAKI)) {
				lines.add(net.minecraft.text.Text.translatable("item.whythereisasushi.golden.description")
						.formatted(net.minecraft.util.Formatting.GRAY, net.minecraft.util.Formatting.ITALIC));
			}
			if (stack.isOf(ModItems.NIGIRI_GOLDEN)) {
				lines.add(net.minecraft.text.Text.translatable("item.whythereisasushi.golden.description")
						.formatted(net.minecraft.util.Formatting.GRAY, net.minecraft.util.Formatting.ITALIC));
			}
			if (stack.isOf(ModItems.HEALTH_MAKI)) {
				lines.add(net.minecraft.text.Text.translatable("item.whythereisasushi.health.description")
						.formatted(net.minecraft.util.Formatting.GRAY, net.minecraft.util.Formatting.ITALIC));
			}
			if (stack.isOf(ModItems.NIGIRI_HEALTH)) {
				lines.add(net.minecraft.text.Text.translatable("item.whythereisasushi.health.description")
						.formatted(net.minecraft.util.Formatting.GRAY, net.minecraft.util.Formatting.ITALIC));
			}
			if (stack.isOf(ModItems.NAUTILUS_MAKI)) {
				lines.add(net.minecraft.text.Text.translatable("item.whythereisasushi.nautilus.description")
						.formatted(net.minecraft.util.Formatting.GRAY, net.minecraft.util.Formatting.ITALIC));
			}
			if (stack.isOf(ModItems.NIGIRI_NAUTILUS)) {
				lines.add(net.minecraft.text.Text.translatable("item.whythereisasushi.nautilus.description")
						.formatted(net.minecraft.util.Formatting.GRAY, net.minecraft.util.Formatting.ITALIC));
			}









		});
		ModBlocks.registerModBlocks();
	}
}