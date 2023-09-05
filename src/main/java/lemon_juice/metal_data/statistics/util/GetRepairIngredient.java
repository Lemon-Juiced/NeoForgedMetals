package lemon_juice.metal_data.statistics.util;

import lemon_juice.neoforged_metals.tag.NFMTags;
import net.minecraft.world.item.crafting.Ingredient;

public class GetRepairIngredient {
    public static Ingredient getRepairIngredient(String name){
        Ingredient repairIngredient = switch (name) {
            case "angamllen" -> Ingredient.of(NFMTags.Items.INGOTS_ANGMALLEN);
            case "bronze" -> Ingredient.of(NFMTags.Items.INGOTS_BRONZE);
            case "damascus_steel" -> Ingredient.of(NFMTags.Items.INGOTS_DAMASCUS_STEEL);
            case "hepatizon" -> Ingredient.of(NFMTags.Items.INGOTS_HEPATIZON);
            case "steel" -> Ingredient.of(NFMTags.Items.INGOTS_STEEL);
            default -> Ingredient.EMPTY;
        };

        return repairIngredient;
    }
}
