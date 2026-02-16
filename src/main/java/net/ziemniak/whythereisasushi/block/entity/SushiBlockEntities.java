package net.ziemniak.whythereisasushi.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;
import net.ziemniak.whythereisasushi.block.ModBlocks;

public class SushiBlockEntities {

    public static final BlockEntityType<SushiTrayBlockEntity> SUSHI_TRAY_ENTITY =
            Registry.register(
                    Registries.BLOCK_ENTITY_TYPE,
                    Identifier.of("whythereisasushi", "sushi_tray_entity"),
                    FabricBlockEntityTypeBuilder
                            .create(SushiTrayBlockEntity::new, ModBlocks.SUSHI_TRAY)
                            .build()
            );

    public static void init() {}
}
