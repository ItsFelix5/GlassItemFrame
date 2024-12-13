package glassitemframes.mixin;

import glassitemframes.Main;
import net.minecraft.item.DecorationItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DecorationItem.class)
public class DecorationItemMixin {
    @Redirect(method = "useOnBlock", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;getNbt()Lnet/minecraft/nbt/NbtCompound;"))
    private NbtCompound useOnBlock(ItemStack stack) {
        NbtCompound nbt = stack.getNbt();
        if(stack.getItem() == Main.GLASS_ITEM_FRAME || stack.getItem() == Main.GLOW_GLASS_ITEM_FRAME) {
            if(nbt == null) nbt = new NbtCompound();
            NbtCompound entityTag = new NbtCompound();
            entityTag.putBoolean("Invisible", true);
            nbt.put("EntityTag", entityTag);
        }
        return nbt;
    }
}
