package lemon_juice.metal_data.statistics;

import lemon_juice.neoforged_metals.tag.NFMTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.ArrayList;

public class MetalToolStatisticsGenerator {
    public static ArrayList<MetalToolStatistic> generateMetalToolStatistics(){
        ArrayList<MetalToolStatistic> metalToolStatistics = new ArrayList<>();

        /* Tier Reference: level, uses, speed, damage, enchantmentValue, repairIngredient
         *           Wood:     0,   59,  2.0F,   0.0F,               15, Ingredient.of(ItemTags.PLANKS)
         *           Gold:     0,   32, 12.0F,   0.0F,               22, Ingredient.of(Items.GOLD_INGOT)
         *          Stone:     1,  131,  4.0F,   1.0F,                5, Ingredient.of(ItemTags.STONE_TOOL_MATERIALS)
         *           Iron:     2,  250,  6.0F,   2.0F,               14, Ingredient.of(Items.IRON_INGOT)
         *        Diamond:     3, 1561,  8.0F,   3.0F,               10, Ingredient.of(Items.DIAMOND)
         *      Netherite:     4, 2031,  9.0F,   4.0F,               15, Ingredient.of(Items.NETHERITE_INGOT)
         */

        // Statistics for Materials in Vanilla (That Need Use)
        MetalToolStatistic copperToolStatistic = new MetalToolStatistic("copper", 2, 131, 4.0F, 3.0F, 9, Ingredient.of(Items.COPPER_INGOT));
        MetalToolStatistic goldToolStatistic = new MetalToolStatistic("gold", 0, 32, 12.0F, 0.0F, 22, Ingredient.of(Items.GOLD_INGOT));
        MetalToolStatistic ironToolStatistic = new MetalToolStatistic("iron", 2, 250, 6.0F, 2.0F, 14, Ingredient.of(Items.IRON_INGOT));
        MetalToolStatistic netheriteToolStatistic = new MetalToolStatistic("netherite", 4, 2031, 9.0F, 4.0F, 15, Ingredient.of(Items.NETHERITE_INGOT));

        // Base Metals
        MetalToolStatistic manganeseToolStatistic = new MetalToolStatistic("manganese", 2, 750, 6.0F, 2.0F, 16, Ingredient.of(NFMTags.Items.INGOTS_MANGANESE));
        MetalToolStatistic tinToolStatistic = new MetalToolStatistic("tin", 2, 131, 4.0F, 2.0F, 9, Ingredient.of(NFMTags.Items.INGOTS_TIN));
        MetalToolStatistic angmallenToolStatistic = alloyToolStatisticAverager("angmallen", goldToolStatistic, ironToolStatistic);
        MetalToolStatistic bronzeToolStatistic = alloyToolStatisticAverager("bronze", copperToolStatistic, tinToolStatistic);
        MetalToolStatistic damascusSteelToolStatistic = alloyToolStatisticAverager("damascus_steel", bronzeToolStatistic, ironToolStatistic);
        MetalToolStatistic hepatizonToolStatistic = alloyToolStatisticAverager("hepatizon", copperToolStatistic, goldToolStatistic);
        MetalToolStatistic steelToolStatistic = alloyToolStatisticAverager("steel", ironToolStatistic, manganeseToolStatistic);

        metalToolStatistics.add(angmallenToolStatistic);
        metalToolStatistics.add(bronzeToolStatistic);
        metalToolStatistics.add(damascusSteelToolStatistic);
        metalToolStatistics.add(hepatizonToolStatistic);
        metalToolStatistics.add(steelToolStatistic);

        // Precious Metals

        // Fantasy Metals

        // Utility Metals

        // Nether Metals

        // End Metals

        return metalToolStatistics;
    }

    public static MetalToolStatistic alloyToolStatisticAverager(String name, MetalToolStatistic metal1, MetalToolStatistic metal2){
        return weightedAlloyToolStatisticAverager(name, metal1, metal2, 1 ,1);
    }

    public static MetalToolStatistic weightedAlloyToolStatisticAverager(String name, MetalToolStatistic metal1, MetalToolStatistic metal2, int weight1, int weight2){
        int totalWeight = weight1 + weight2;

        int level = (int) (double) ((metal1.level() + metal2.level()) / totalWeight);
        int uses = (int) (double) ((metal1.uses() + metal2.uses()) / totalWeight);
        float speed = (metal1.speed() + metal2.speed())/ totalWeight;
        float damage = (metal1.damage() + metal2.damage()) / totalWeight;
        int enchantmentValue = (int) (double) ((metal1.enchantmentValue() + metal2.enchantmentValue()) / totalWeight);
        Ingredient repairIngredient = switch (name) {
            case "angamllen" -> Ingredient.of(NFMTags.Items.INGOTS_ANGMALLEN);
            case "bronze" -> Ingredient.of(NFMTags.Items.INGOTS_BRONZE);
            case "damascus_steel" -> Ingredient.of(NFMTags.Items.INGOTS_DAMASCUS_STEEL);
            case "hepatizon" -> Ingredient.of(NFMTags.Items.INGOTS_HEPATIZON);
            case "steel" -> Ingredient.of(NFMTags.Items.INGOTS_STEEL);
            default -> Ingredient.EMPTY;
        };

        return new MetalToolStatistic(name, level, uses, speed, damage, enchantmentValue, repairIngredient);
    }
}
