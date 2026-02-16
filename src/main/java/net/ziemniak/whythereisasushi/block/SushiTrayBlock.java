package net.ziemniak.whythereisasushi.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.ziemniak.whythereisasushi.block.entity.SushiTrayBlockEntity;

public class SushiTrayBlock extends BlockWithEntity {

    public SushiTrayBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new SushiTrayBlockEntity(pos, state);
    }

    @Override
    public ActionResult onUse(BlockState state,
                              World world,
                              BlockPos pos,
                              PlayerEntity player,
                              BlockHitResult hit) {

        if (!world.isClient()) {
            NamedScreenHandlerFactory factory =
                    state.createScreenHandlerFactory(world, pos);

            if (factory != null) {
                player.openHandledScreen(factory);
            }
        }

        return ActionResult.SUCCESS;
    }
    
}
