package net.ziemniak.whythereisasushi.mixin;

import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.ziemniak.whythereisasushi.item.ModItems;

@Mixin(LivingEntity.class)
public abstract class ItemUsageMixin {

    @Shadow protected int itemUseTimeLeft;

    @Inject(method = "setCurrentHand", at = @At("TAIL"))
    private void speedUpEating(CallbackInfo ci) {
        LivingEntity entity = (LivingEntity) (Object) this;

        boolean hasChopsticks = entity.getMainHandStack().isOf(ModItems.CHOPSTICKS) ||
                entity.getOffHandStack().isOf(ModItems.CHOPSTICKS);

        if (hasChopsticks && entity.isUsingItem()) {
            this.itemUseTimeLeft = (int) (this.itemUseTimeLeft * 0.6);
        }
    }
}