package glassitemframes;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFrameItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.GameRules;

public class Main implements ModInitializer {
    public static final GameRules.Key<GameRules.BooleanRule> ALLOW_FLOATING_FRAMES = GameRuleRegistry.register("allowFloatingFrames", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(false));

    public static final Item GLASS_ITEM_FRAME  = Registry.register(Registries.ITEM, Identifier.of("glassitemframes", "glass_item_frame"), new ItemFrameItem(EntityType.ITEM_FRAME, new Item.Settings()));
    public static final Item GLOW_GLASS_ITEM_FRAME  = Registry.register(Registries.ITEM, Identifier.of("glassitemframes", "glow_glass_item_frame"), new ItemFrameItem(EntityType.GLOW_ITEM_FRAME, new Item.Settings()));

    @Override
    public void onInitialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(group -> {
            group.add(GLASS_ITEM_FRAME);
            group.add(GLOW_GLASS_ITEM_FRAME);
        });
    }
}
