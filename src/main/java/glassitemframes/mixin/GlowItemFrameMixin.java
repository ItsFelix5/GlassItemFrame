package glassitemframes.mixin;

import glassitemframes.Main;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.AbstractDecorationEntity;
import net.minecraft.entity.decoration.GlowItemFrameEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GlowItemFrameEntity.class)
public abstract class GlowItemFrameMixin extends AbstractDecorationEntity {
    protected GlowItemFrameMixin(EntityType<? extends AbstractDecorationEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "getAsItemStack", at = @At("HEAD"), cancellable = true)
    private void dropCorrectItem(CallbackInfoReturnable<ItemStack> cir) {
        if (isInvisible()) cir.setReturnValue(new ItemStack(Main.GLOW_GLASS_ITEM_FRAME));
    }
}
