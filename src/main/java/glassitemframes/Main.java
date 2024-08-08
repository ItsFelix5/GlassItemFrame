package glassitemframes;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFrameItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Main implements ModInitializer {
    public static final Item GLASS_ITEM_FRAME;
    public static final Item GLOW_GLASS_ITEM_FRAME;

    static {
        NbtCompound nbt = new NbtCompound();
        nbt.putBoolean("Invisible", true);
        nbt.putString("id", "item_frame");

        GLASS_ITEM_FRAME = Registry.register(Registries.ITEM, Identifier.of("glassitemframes", "glass_item_frame"),
                new ItemFrameItem(EntityType.ITEM_FRAME, new Item.Settings().component(DataComponentTypes.ENTITY_DATA, NbtComponent.of(nbt))));

        nbt.putString("id", "glow_item_frame");

        GLOW_GLASS_ITEM_FRAME = Registry.register(Registries.ITEM, Identifier.of("glassitemframes", "glow_glass_item_frame"),
                new ItemFrameItem(EntityType.GLOW_ITEM_FRAME, new Item.Settings().component(DataComponentTypes.ENTITY_DATA, NbtComponent.of(nbt))));
    }

    @Override
    public void onInitialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(group->{
            group.add(GLASS_ITEM_FRAME);
            group.add(GLOW_GLASS_ITEM_FRAME);
        });
    }
}