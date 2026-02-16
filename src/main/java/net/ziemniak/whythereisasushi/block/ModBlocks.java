package net.ziemniak.whythereisasushi.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.ziemniak.whythereisasushi.Whythereisasushi;
import net.ziemniak.whythereisasushi.item.ModItems;

import java.util.function.Function;

public class ModBlocks {

    public static final Block RICE_CROP = registerBlock("rice_crop",
            settings -> new CropBlock(settings) {
                @Override
                protected ItemConvertible getSeedsItem() {
                    return ModItems.RICE_SEEDS;
                }
            }, AbstractBlock.Settings.copy(Blocks.WHEAT));
    public static final SushiTrayBlock SUSHI_TRAY = register(
            "sushi_tray",
            SushiTrayBlock::new,
            Block.Settings.create().strength(2.0f)
    );

    private static <T extends Block> T register(String name,
                                                Function<Block.Settings, T> factory,
                                                Block.Settings settings) {
        Identifier id = Identifier.of("whythereisasushi", name);
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, id);

        // rzutowanie fabryki do Function<Settings, Block>
        Block block = Blocks.register(key, s -> (Block) factory.apply(s), settings);

        // rejestrujemy odpowiadający BlockItem
        Items.register(block);

        return (T) block;
    }


    // Ta metoda najpierw tworzy klucz, a potem tworzy blok
    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Whythereisasushi.MOD_ID, name));

        // Ważne: musimy ustawić klucz w ustawieniach (settings), żeby blok go znał od startu
        return Registry.register(Registries.BLOCK, key, factory.apply(settings.registryKey(key)));
    }

    public static void registerModBlocks() {
        Whythereisasushi.LOGGER.info("Registering Blocks for " + Whythereisasushi.MOD_ID);
    }
}