package lemon_juice.neoforged_metals.registry;

import lemon_juice.neoforged_metals.item.NFMItems;
import lemon_juice.neoforged_metals.item.custom.item.DustItem;
import lemon_juice.neoforged_metals.item.custom.item.NuggetItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class ParityRegistry {

    public static RegistryObject<Item> COPPER_NUGGET = NFMItems.ITEMS.register("copper_nugget", () -> new NuggetItem(new Item.Properties(), "vanilla"));
    public static RegistryObject<Item> COPPER_DUST = NFMItems.ITEMS.register("copper_dust", () -> new DustItem(new Item.Properties(), "vanilla"));

    public static RegistryObject<Item> GOLD_DUST = NFMItems.ITEMS.register("gold_dust", () -> new DustItem(new Item.Properties(), "vanilla"));
    public static RegistryObject<Item> IRON_DUST = NFMItems.ITEMS.register("iron_dust", () -> new DustItem(new Item.Properties(), "vanilla"));

    public static RegistryObject<Item> NETHERITE_NUGGET = NFMItems.ITEMS.register("netherite_nugget", () -> new NuggetItem(new Item.Properties(), "vanilla"));
    public static RegistryObject<Item> NETHERITE_DUST = NFMItems.ITEMS.register("netherite_dust", () -> new DustItem(new Item.Properties(), "vanilla"));

    public static void registerParity(){ /* Does nothing other than register all the above items */ }
}