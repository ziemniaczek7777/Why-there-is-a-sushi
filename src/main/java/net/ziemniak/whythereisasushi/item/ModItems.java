package net.ziemniak.whythereisasushi.item;

import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.ziemniak.whythereisasushi.Whythereisasushi;
import net.ziemniak.whythereisasushi.block.ModBlocks;
import org.spongepowered.asm.mixin.injection.selectors.ElementNode;

import java.util.function.Function;

public class ModItems {

    public static final ConsumableComponent PUFFERFISH_CONSUMABLE = ConsumableComponent.builder()
            .consumeEffect(new ApplyEffectsConsumeEffect(
                    new StatusEffectInstance(StatusEffects.NAUSEA, 400, 0), 0.5f))
            .build();
    public static final ConsumableComponent MAGMA_CONSUMABLE = ConsumableComponent.builder()
            .consumeEffect(new ApplyEffectsConsumeEffect(
                    new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 600, 0), 1f))
            .consumeEffect(new ApplyEffectsConsumeEffect(
                    new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 10, 0), 1f))
            .build();
    public static final ConsumableComponent RABBIT_CONSUMABLE = ConsumableComponent.builder()
            .consumeEffect(new ApplyEffectsConsumeEffect(
                    new StatusEffectInstance(StatusEffects.JUMP_BOOST, 300, 1), 1f))
            .build();
    public static final ConsumableComponent GLOW_CONSUMABLE = ConsumableComponent.builder()
            .consumeEffect(new ApplyEffectsConsumeEffect(
                    new StatusEffectInstance(StatusEffects.NIGHT_VISION, 800, 0), 1f))
            .build();
    public static final ConsumableComponent CHORUS_CONSUMABLE = ConsumableComponent.builder()
            .consumeEffect(new net.minecraft.item.consume.TeleportRandomlyConsumeEffect())
            .build();
    public static final ConsumableComponent HONEY_CONSUMABLE = ConsumableComponent.builder()
            .consumeEffect(new net.minecraft.item.consume.RemoveEffectsConsumeEffect(StatusEffects.POISON))
            .consumeEffect(new net.minecraft.item.consume.RemoveEffectsConsumeEffect(StatusEffects.BLINDNESS))
            .consumeEffect(new net.minecraft.item.consume.RemoveEffectsConsumeEffect(StatusEffects.BAD_OMEN))
            .consumeEffect(new net.minecraft.item.consume.RemoveEffectsConsumeEffect(StatusEffects.DARKNESS))
            .consumeEffect(new net.minecraft.item.consume.RemoveEffectsConsumeEffect(StatusEffects.HUNGER))
            .consumeEffect(new net.minecraft.item.consume.RemoveEffectsConsumeEffect(StatusEffects.INFESTED))
            .consumeEffect(new net.minecraft.item.consume.RemoveEffectsConsumeEffect(StatusEffects.MINING_FATIGUE))
            .consumeEffect(new net.minecraft.item.consume.RemoveEffectsConsumeEffect(StatusEffects.DARKNESS))
            .consumeEffect(new net.minecraft.item.consume.RemoveEffectsConsumeEffect(StatusEffects.NAUSEA))
            .consumeEffect(new net.minecraft.item.consume.RemoveEffectsConsumeEffect(StatusEffects.OOZING))
            .consumeEffect(new net.minecraft.item.consume.RemoveEffectsConsumeEffect(StatusEffects.UNLUCK))
            .consumeEffect(new net.minecraft.item.consume.RemoveEffectsConsumeEffect(StatusEffects.WEAKNESS))
            .consumeEffect(new net.minecraft.item.consume.RemoveEffectsConsumeEffect(StatusEffects.WEAVING))
            .consumeEffect(new net.minecraft.item.consume.RemoveEffectsConsumeEffect(StatusEffects.WITHER))
            .build();
    public static final ConsumableComponent PHANTOM_CONSUMABLE = ConsumableComponent.builder()
            .consumeEffect(new ApplyEffectsConsumeEffect(
                    new StatusEffectInstance(StatusEffects.SLOW_FALLING, 400, 0), 1f))
            .build();
    public static final ConsumableComponent GOLDEN_CONSUMABLE = ConsumableComponent.builder()
            .consumeEffect(new ApplyEffectsConsumeEffect(
                    new StatusEffectInstance(StatusEffects.ABSORPTION, 1200, 1), 1f))
            .consumeEffect(new ApplyEffectsConsumeEffect(
                    new StatusEffectInstance(StatusEffects.REGENERATION, 400, 1), 1f))
            .build();
    public static final ConsumableComponent HEALTH_CONSUMABLE = ConsumableComponent.builder()
            .consumeEffect(new ApplyEffectsConsumeEffect(
                    new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 6000, 2), 1f))
            .consumeEffect(new ApplyEffectsConsumeEffect(
                    new StatusEffectInstance(StatusEffects.REGENERATION, 200, 1), 1f))
            .build();
    public static final ConsumableComponent UNDER_CONSUMABLE = ConsumableComponent.builder()
            .consumeEffect(new ApplyEffectsConsumeEffect(
                    new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 2400, 0), 1f))
            .build();


    public static final Item CHOPSTICKS = registerItem("chopsticks",
            settings -> new Item(settings.maxCount(1)),
            new Item.Settings());
    public static final Item MAGMA_MAKI = registerItem("magma_maki",
            settings -> new Item(settings
                    .food(new FoodComponent.Builder().nutrition(4).saturationModifier(0.7f).alwaysEdible().build())
                    .component(net.minecraft.component.DataComponentTypes.CONSUMABLE, MAGMA_CONSUMABLE)
            ), new Item.Settings());

    public static final Item HEALTH_MAKI = registerItem("health_maki",
            settings -> new Item(settings
                    .food(new FoodComponent.Builder().nutrition(4).saturationModifier(0.7f).alwaysEdible().build())
                    .component(net.minecraft.component.DataComponentTypes.CONSUMABLE, HEALTH_CONSUMABLE)
            ), new Item.Settings());


    public static final Item RABBIT_MAKI = registerItem("rabbit_maki",
            settings -> new Item(settings
                    .food(new FoodComponent.Builder().nutrition(5).saturationModifier(0.7f).alwaysEdible().build())
                    .component(net.minecraft.component.DataComponentTypes.CONSUMABLE, RABBIT_CONSUMABLE)
            ), new Item.Settings());

    public static final Item GLOW_MAKI = registerItem("glow_maki",
            settings -> new Item(settings
                    .food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.4f).alwaysEdible().build())
                    .component(net.minecraft.component.DataComponentTypes.CONSUMABLE, GLOW_CONSUMABLE)
            ), new Item.Settings());

    public static final Item CHORUS_MAKI = registerItem("chorus_maki",
            settings -> new Item(settings
                    .food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.6f).alwaysEdible().build())
                    .component(net.minecraft.component.DataComponentTypes.CONSUMABLE, CHORUS_CONSUMABLE)
            ), new Item.Settings());

    public static final Item HONEY_MAKI = registerItem("honey_maki",
            settings -> new Item(settings
                    .food(new FoodComponent.Builder().nutrition(5).saturationModifier(0.7f).alwaysEdible().build())
                    .component(net.minecraft.component.DataComponentTypes.CONSUMABLE, HONEY_CONSUMABLE)
            ), new Item.Settings());

    public static final Item PHANTOM_MAKI = registerItem("phantom_maki",
            settings -> new Item(settings
                    .food(new FoodComponent.Builder().nutrition(4).saturationModifier(0.5f).alwaysEdible().build())
                    .component(net.minecraft.component.DataComponentTypes.CONSUMABLE, PHANTOM_CONSUMABLE)
            ), new Item.Settings());

    public static final Item GOLDEN_MAKI = registerItem("golden_maki",
            settings -> new Item(settings
                    .food(new FoodComponent.Builder().nutrition(4).saturationModifier(0.8f).alwaysEdible().build())
                    .component(net.minecraft.component.DataComponentTypes.CONSUMABLE, GOLDEN_CONSUMABLE)
            ), new Item.Settings());

    public static final Item NAUTILUS_MAKI = registerItem("nautilus_maki",
            settings -> new Item(settings
                    .food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).alwaysEdible().build())
                    .component(net.minecraft.component.DataComponentTypes.CONSUMABLE, UNDER_CONSUMABLE)
            ), new Item.Settings());

    public static final Item NORI_SHEET = registerItem("nori_sheet", Item::new, new Item.Settings());

    public static final Item RICE_SEEDS = registerItem("rice_seeds",
            settings -> new BlockItem(ModBlocks.RICE_CROP, settings), new Item.Settings());

    public static final Item RICE = registerItem("rice",
            settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(1).saturationModifier(0.2f).alwaysEdible().build())), new Item.Settings());

    public static final Item COOKED_RICE = registerItem("cooked_rice",
            settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(2).saturationModifier(0.4f).alwaysEdible().build())), new Item.Settings());

    public static final Item SHARI_MAKI = registerItem("shari_maki",
            settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(4).saturationModifier(0.5f).alwaysEdible().build())), new Item.Settings());

    public static final Item SAKE_MAKI = registerItem("sake_maki",
            settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(7).saturationModifier(0.7f).alwaysEdible().build())), new Item.Settings());

    public static final Item TROPICAL_MAKI = registerItem("tropical_maki",
            settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(5).saturationModifier(0.6f).alwaysEdible().build())), new Item.Settings());

    public static final Item PUFFERFISH_MAKI = registerItem("pufferfish_maki",
            settings -> new Item(settings
                    .food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.9f).alwaysEdible().build())
                    .component(net.minecraft.component.DataComponentTypes.CONSUMABLE, PUFFERFISH_CONSUMABLE)
            ), new Item.Settings());

    public static final Item COD_MAKI = registerItem("cod_maki",
            settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.7f).alwaysEdible().build())), new Item.Settings());
    public static final Item FUTOMAKI = registerItem("futomaki",
            settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(10).saturationModifier(1.1f).alwaysEdible().build())), new Item.Settings());

    public static final Item NIGIRI_SAKE = registerItem("nigiri_sake",
            settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).alwaysEdible().build())), new Item.Settings());

    public static final Item NIGIRI_TROPICAL = registerItem("nigiri_tropical",
            settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(5).saturationModifier(0.5f).alwaysEdible().build())), new Item.Settings());

    public static final Item NIGIRI_PUFFERFISH = registerItem("nigiri_pufferfish",
            settings -> new Item(settings
                    .food(new FoodComponent.Builder().nutrition(5).saturationModifier(0.8f).alwaysEdible().build())
                    .component(net.minecraft.component.DataComponentTypes.CONSUMABLE, PUFFERFISH_CONSUMABLE)
            ), new Item.Settings());

    public static final Item NIGIRI_COD = registerItem("nigiri_cod",
            settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(5).saturationModifier(0.6f).alwaysEdible().build())), new Item.Settings());
    public static final Item NIGIRI_NAUTILUS = registerItem("nigiri_nautilus",
            settings -> new Item(settings
                    .food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).alwaysEdible().build())
                    .component(net.minecraft.component.DataComponentTypes.CONSUMABLE, UNDER_CONSUMABLE)
            ), new Item.Settings());
    public static final Item NIGIRI_GOLDEN = registerItem("nigiri_golden",
            settings -> new Item(settings
                    .food(new FoodComponent.Builder().nutrition(4).saturationModifier(0.8f).alwaysEdible().build())
                    .component(net.minecraft.component.DataComponentTypes.CONSUMABLE, GOLDEN_CONSUMABLE)
            ), new Item.Settings());
    public static final Item NIGIRI_PHANTOM = registerItem("nigiri_phantom",
            settings -> new Item(settings
                    .food(new FoodComponent.Builder().nutrition(4).saturationModifier(0.5f).alwaysEdible().build())
                    .component(net.minecraft.component.DataComponentTypes.CONSUMABLE, PHANTOM_CONSUMABLE)
            ), new Item.Settings());
    public static final Item NIGIRI_HONEY = registerItem("nigiri_honey",
            settings -> new Item(settings
                    .food(new FoodComponent.Builder().nutrition(5).saturationModifier(0.7f).alwaysEdible().build())
                    .component(net.minecraft.component.DataComponentTypes.CONSUMABLE, HONEY_CONSUMABLE)
            ), new Item.Settings());
    public static final Item NIGIRI_CHORUS = registerItem("nigiri_chorus",
            settings -> new Item(settings
                    .food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.6f).alwaysEdible().build())
                    .component(net.minecraft.component.DataComponentTypes.CONSUMABLE, CHORUS_CONSUMABLE)
            ), new Item.Settings());
    public static final Item NIGIRI_GLOW = registerItem("nigiri_glow",
            settings -> new Item(settings
                    .food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.4f).alwaysEdible().build())
                    .component(net.minecraft.component.DataComponentTypes.CONSUMABLE, GLOW_CONSUMABLE)
            ), new Item.Settings());
    public static final Item NIGIRI_RABBIT = registerItem("nigiri_rabbit",
            settings -> new Item(settings
                    .food(new FoodComponent.Builder().nutrition(5).saturationModifier(0.7f).alwaysEdible().build())
                    .component(net.minecraft.component.DataComponentTypes.CONSUMABLE, RABBIT_CONSUMABLE)
            ), new Item.Settings());
    public static final Item NIGIRI_HEALTH = registerItem("nigiri_health",
            settings -> new Item(settings
                    .food(new FoodComponent.Builder().nutrition(4).saturationModifier(0.7f).alwaysEdible().build())
                    .component(net.minecraft.component.DataComponentTypes.CONSUMABLE, HEALTH_CONSUMABLE)
            ), new Item.Settings());
    public static final Item NIGIRI_MAGMA = registerItem("nigiri_magma",
            settings -> new Item(settings
                    .food(new FoodComponent.Builder().nutrition(4).saturationModifier(0.7f).alwaysEdible().build())
                    .component(net.minecraft.component.DataComponentTypes.CONSUMABLE, MAGMA_CONSUMABLE)
            ), new Item.Settings());

    public static final Item ONIGIRI = registerItem("onigiri",
            settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).alwaysEdible().build())), new Item.Settings());


    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Whythereisasushi.MOD_ID, name));
        return Items.register(key, factory, settings);
    }

    public static void registerModItems() {
        Whythereisasushi.LOGGER.info("Registering Mod Items for " + Whythereisasushi.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(RICE);
            entries.add(COOKED_RICE);
            entries.add(SHARI_MAKI);
            entries.add(SAKE_MAKI);
            entries.add(TROPICAL_MAKI);
            entries.add(PUFFERFISH_MAKI);
            entries.add(COD_MAKI);
            entries.add(NIGIRI_SAKE);
            entries.add(NIGIRI_TROPICAL);
            entries.add(NIGIRI_PUFFERFISH);
            entries.add(NIGIRI_COD);
            entries.add(ONIGIRI);
            entries.add(MAGMA_MAKI);
            entries.add(RABBIT_MAKI);
            entries.add(GLOW_MAKI);
            entries.add(CHORUS_MAKI);
            entries.add(HONEY_MAKI);
            entries.add(PHANTOM_MAKI);
            entries.add(GOLDEN_MAKI);
            entries.add(HEALTH_MAKI);
            entries.add(NIGIRI_MAGMA);
            entries.add(NIGIRI_HEALTH);
            entries.add(NIGIRI_RABBIT);
            entries.add(NIGIRI_GLOW);
            entries.add(NIGIRI_CHORUS);
            entries.add(NIGIRI_HONEY);
            entries.add(NIGIRI_PHANTOM);
            entries.add(NIGIRI_GOLDEN);
            entries.add(NIGIRI_NAUTILUS);
            entries.add(NAUTILUS_MAKI);
            entries.add(FUTOMAKI);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(RICE_SEEDS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(NORI_SHEET);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(CHOPSTICKS);
        });
    }
    public static final ItemGroup SUSHI_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Whythereisasushi.MOD_ID, "sushi_group"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.sushi_group"))
                    .icon(() -> new ItemStack(ModItems.NIGIRI_SAKE)) // Ikona zakładki
                    .entries((displayContext, entries) -> {
                        entries.add(NORI_SHEET);
                        entries.add(RICE_SEEDS);
                        entries.add(RICE);
                        entries.add(COOKED_RICE);
                        entries.add(SHARI_MAKI);
                        entries.add(SAKE_MAKI);
                        entries.add(TROPICAL_MAKI);
                        entries.add(PUFFERFISH_MAKI);
                        entries.add(COD_MAKI);
                        entries.add(NIGIRI_SAKE);
                        entries.add(NIGIRI_TROPICAL);
                        entries.add(NIGIRI_PUFFERFISH);
                        entries.add(NIGIRI_COD);
                        entries.add(ONIGIRI);
                        entries.add(MAGMA_MAKI);
                        entries.add(RABBIT_MAKI);
                        entries.add(GLOW_MAKI);
                        entries.add(CHORUS_MAKI);
                        entries.add(HONEY_MAKI);
                        entries.add(PHANTOM_MAKI);
                        entries.add(GOLDEN_MAKI);
                        entries.add(CHOPSTICKS);
                        entries.add(HEALTH_MAKI);
                        entries.add(NIGIRI_MAGMA);
                        entries.add(NIGIRI_HEALTH);
                        entries.add(NIGIRI_RABBIT);
                        entries.add(NIGIRI_GLOW);
                        entries.add(NIGIRI_CHORUS);
                        entries.add(NIGIRI_HONEY);
                        entries.add(NIGIRI_PHANTOM);
                        entries.add(NIGIRI_GOLDEN);
                        entries.add(NIGIRI_NAUTILUS);
                        entries.add(NAUTILUS_MAKI);
                        entries.add(FUTOMAKI);
                    }).build());


}