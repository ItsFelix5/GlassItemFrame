package glassitemframes.mixin;

import net.minecraft.client.render.entity.ItemFrameEntityRenderer;
import net.minecraft.entity.decoration.ItemFrameEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ItemFrameEntityRenderer.class)
public class ItemFrameEntityRendererMixin {
    @Redirect(method = "render(Lnet/minecraft/entity/decoration/ItemFrameEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V", at =
    @At(value = "INVOKE", target = "Lnet/minecraft/entity/decoration/ItemFrameEntity;isInvisible()Z"))
    private boolean visible(ItemFrameEntity instance) {
        return instance.isInvisible() && !instance.getHeldItemStack().isEmpty();
    }
}
