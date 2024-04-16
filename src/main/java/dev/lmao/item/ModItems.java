package dev.lmao.item;

import dev.lmao.LmaoMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    // Custom items
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));

    // Add items to the "ingredients" tab on the creative menu
    private static void addItemsToIngredientTabGroup(FabricItemGroupEntries entries) {
        entries.add(RUBY);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(LmaoMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        LmaoMod.LOGGER.info(String.format("Registering Mod items for %s.", LmaoMod.MOD_ID));

        // idk what this does, my best guess is that there is some event in which items are loaded into the appropriate
        // creative tabs, and this somehow injects the function from earlier into it.
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabGroup);
    }

}
