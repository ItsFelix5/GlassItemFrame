package glassitemframes.mixin;

import net.minecraft.client.render.entity.ItemFrameEntityRenderer;
import net.minecraft.client.render.entity.state.ItemFrameEntityRenderState;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ItemFrameEntityRenderer.class)
public class ItemFrameEntityRendererMixin {
    @Redirect(method = "render(Lnet/minecraft/client/render/entity/state/ItemFrameEntityRenderState;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;" +
            "I)V", at = @At(value = "FIELD", target = "Lnet/minecraft/client/render/entity/state/ItemFrameEntityRenderState;invisible:Z", opcode = Opcodes.GETFIELD))
    private boolean visible(ItemFrameEntityRenderState state) {
        return state.invisible && !state.itemRenderState.isEmpty();
    }
}
