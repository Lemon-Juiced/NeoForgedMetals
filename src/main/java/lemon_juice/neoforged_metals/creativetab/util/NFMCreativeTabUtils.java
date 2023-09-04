package lemon_juice.neoforged_metals.creativetab.util;

import lemon_juice.neoforged_metals.item.NFMItems;
import lemon_juice.neoforged_metals.item.custom.item.IngotItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.registries.RegistryObject;

import static lemon_juice.neoforged_metals.creativetab.NFMCreativeTabs.metalTabType;
import static lemon_juice.neoforged_metals.creativetab.NFMCreativeTabs.toolsTabType;

public class NFMCreativeTabUtils {

    /**
     * Returns an Item of a type that the tab represents
     *
     * @param tabType The type of tab the Item will represent
     * @return an Item of a type that the tab represents
     */
    public static Item getFirstItem(String tabType){
        Item tabItem = null;
        for(RegistryObject<Item> item : NFMItems.ITEMS.getEntries()) {
            if (tabType.equals(metalTabType)) {
                if (item.get() instanceof IngotItem) {
                    tabItem = item.get();
                    break; //Out of the for-loop
                }
            } else if (tabType.equals(toolsTabType)) {
                if (item.get() instanceof SwordItem) { // Will be switched to SwordItem
                    tabItem = item.get();
                    break; //Out of the for-loop
                }
            }
        }

        return tabItem;
    }
}
