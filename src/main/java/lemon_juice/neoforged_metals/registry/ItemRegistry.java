package lemon_juice.neoforged_metals.registry;

import lemon_juice.neoforged_metals.item.NFMItems;
import lemon_juice.neoforged_metals.item.custom.item.DustItem;
import lemon_juice.neoforged_metals.item.custom.item.IngotItem;
import lemon_juice.neoforged_metals.item.custom.item.NuggetItem;
import net.minecraft.world.item.Item;

import static lemon_juice.neoforged_metals.registry.BlockRegistry.registerMetalBlockGroup;

public class ItemRegistry {

    /**
     * Registers a group of Items associated for a metal (automatically assumes the metal has both tools and armor)
     *
     * @param name The name of the metal
     * @param oreGroup The oreGroup of the metal (and by derivative its dimension)
     *                 Overworld: "base", "precious", "fantasy", "utility"
     *                 Nether: "nether"
     *                 End: "end"
     * @param isAlloy true if the resource is an alloy, false otherwise
     */
    public static void registerMetalItemGroup(String name, String oreGroup, boolean isAlloy){
        registerMetalItemGroup(name, oreGroup, isAlloy, true, true);
    }

    /**
     * Registers a group of Items associated for a metal
     *
     * @param name The name of the metal
     * @param oreGroup The oreGroup of the metal (and by derivative its dimension)
     *                 Overworld: "base", "precious", "fantasy", "utility"
     *                 Nether: "nether"
     *                 End: "end"
     * @param isAlloy true if the resource is an alloy, false otherwise
     * @param hasTools true if the metal has tools, false otherwise
     * @param hasArmor true if the metal has armor, false otherwise
     */
    public static void registerMetalItemGroup(String name, String oreGroup, boolean isAlloy, boolean hasTools, boolean hasArmor){
        NFMItems.ITEMS.register(name + "_ingot", () -> new IngotItem(new Item.Properties(), oreGroup));
        NFMItems.ITEMS.register(name + "_nugget", () -> new NuggetItem(new Item.Properties(), oreGroup));
        NFMItems.ITEMS.register(name + "_dust", () -> new DustItem(new Item.Properties(), oreGroup));

        if(hasTools){}
        if(hasArmor){}

        registerMetalBlockGroup(name, oreGroup, isAlloy);
    }
}