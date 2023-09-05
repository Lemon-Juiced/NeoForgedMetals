package lemon_juice.metal_data.statistics;

import lemon_juice.metal_data.statistics.util.GetRepairIngredient;
import lemon_juice.neoforged_metals.tag.NFMTags;
import net.minecraft.Util;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.ArrayList;
import java.util.EnumMap;

public class MetalArmorStatisticsGenerator {
    public static ArrayList<MetalArmorStatistic> generateMetalArmorStatistics(){
        ArrayList<MetalArmorStatistic> metalArmorStatistics = new ArrayList<>();

        /* metalArmorStatistics
         * Tier Reference: durabilityMultiplier, enchantmentValue, toughness, knockbackResistance, repairIngredient
         *        Leather:                    5,               15,      0.0F,                0.0F, Ingredient.of(Items.LEATHER)
         *           Gold:                    7,               25,      0.0F,                0.0F, Ingredient.of(Items.GOLD_INGOT)
         *      Chainmail:                   15,               12,      0.0F,                0.0F, Ingredient.of(Items.IRON_INGOT)
         *           Iron:                   15,                9,      0.0F,                0.0F, Ingredient.of(Items.IRON_INGOT)
         *        Diamond:                   33,               10,      2.0F,                0.0F, Ingredient.of(Items.DIAMOND)
         *      Netherite:                   37,               15,      3.0F,                0.1F, Ingredient.of(Items.NETHERITE_INGOT)
         */

        /* protectionForFunctionType
         * Tier Reference: boots, leggings, chestplate, helmet
         *        Leather:     1,        2,          3,      1
         *      Chainmail:     1,        4,          5,      2
         *           Gold:     1,        3,          5,      2
         *           Iron:     2,        5,          6,      2
         *        Diamond:     3,        6,          8,      3
         *      Netherite:     3,        6,          8,      3
         */

        // Statistics for Materials in Vanilla (That Need Use)
        MetalArmorStatistic copperArmorStatistic = new MetalArmorStatistic("copper", 15,
                Util.make(new EnumMap<>(ArmorItem.Type.class), (protectionForFunctionType) -> {
                    protectionForFunctionType.put(ArmorItem.Type.BOOTS, 1);
                    protectionForFunctionType.put(ArmorItem.Type.LEGGINGS, 4);
                    protectionForFunctionType.put(ArmorItem.Type.CHESTPLATE, 5);
                    protectionForFunctionType.put(ArmorItem.Type.HELMET, 2);
                }), 12, 0.0F, 0.0F, Ingredient.of(Items.COPPER_INGOT));

        MetalArmorStatistic goldArmorStatistic = new MetalArmorStatistic("gold", 7,
                Util.make(new EnumMap<>(ArmorItem.Type.class), (protectionForFunctionType) -> {
                    protectionForFunctionType.put(ArmorItem.Type.BOOTS, 1);
                    protectionForFunctionType.put(ArmorItem.Type.LEGGINGS, 3);
                    protectionForFunctionType.put(ArmorItem.Type.CHESTPLATE, 5);
                    protectionForFunctionType.put(ArmorItem.Type.HELMET, 2);
                }), 25, 0.0F, 0.0F, Ingredient.of(Items.GOLD_INGOT));

        MetalArmorStatistic ironArmorStatistic = new MetalArmorStatistic("iron", 15,
                Util.make(new EnumMap<>(ArmorItem.Type.class), (protectionForFunctionType) -> {
                    protectionForFunctionType.put(ArmorItem.Type.BOOTS, 2);
                    protectionForFunctionType.put(ArmorItem.Type.LEGGINGS, 5);
                    protectionForFunctionType.put(ArmorItem.Type.CHESTPLATE, 6);
                    protectionForFunctionType.put(ArmorItem.Type.HELMET, 2);
                }), 9, 0.0F, 0.0F, Ingredient.of(Items.IRON_INGOT));

        MetalArmorStatistic netheriteArmorStatistic = new MetalArmorStatistic("netherite", 37,
                Util.make(new EnumMap<>(ArmorItem.Type.class), (protectionForFunctionType) -> {
                    protectionForFunctionType.put(ArmorItem.Type.BOOTS, 3);
                    protectionForFunctionType.put(ArmorItem.Type.LEGGINGS, 6);
                    protectionForFunctionType.put(ArmorItem.Type.CHESTPLATE, 8);
                    protectionForFunctionType.put(ArmorItem.Type.HELMET, 3);
                }), 15, 3.0F, 0.1F, Ingredient.of(Items.NETHERITE_INGOT));

        // Base Metals
        MetalArmorStatistic manganeseArmorStatistic = new MetalArmorStatistic("manganese", 20,
                Util.make(new EnumMap<>(ArmorItem.Type.class), (protectionForFunctionType) -> {
                    protectionForFunctionType.put(ArmorItem.Type.BOOTS, 2);
                    protectionForFunctionType.put(ArmorItem.Type.LEGGINGS, 5);
                    protectionForFunctionType.put(ArmorItem.Type.CHESTPLATE, 6);
                    protectionForFunctionType.put(ArmorItem.Type.HELMET, 2);
                }), 9, 0.0F, 0.0F, Ingredient.of(NFMTags.Items.INGOTS_MANGANESE));
        MetalArmorStatistic tinArmorStatistic = new MetalArmorStatistic("tin", 15,
                Util.make(new EnumMap<>(ArmorItem.Type.class), (protectionForFunctionType) -> {
                    protectionForFunctionType.put(ArmorItem.Type.BOOTS, 1);
                    protectionForFunctionType.put(ArmorItem.Type.LEGGINGS, 3);
                    protectionForFunctionType.put(ArmorItem.Type.CHESTPLATE, 5);
                    protectionForFunctionType.put(ArmorItem.Type.HELMET, 2);
                }), 12, 0.0F, 0.0F, Ingredient.of(NFMTags.Items.INGOTS_TIN));

        MetalArmorStatistic angmallenArmorStatistic = alloyArmorStatisticAverager("angmallen", goldArmorStatistic, ironArmorStatistic);
        MetalArmorStatistic bronzeArmorStatistic = alloyArmorStatisticAverager("bronze", copperArmorStatistic, tinArmorStatistic);
        MetalArmorStatistic damascusSteelArmorStatistic = alloyArmorStatisticAverager("damascus_steel", bronzeArmorStatistic, ironArmorStatistic);
        MetalArmorStatistic hepatizonArmorStatistic = alloyArmorStatisticAverager("hepatizon", copperArmorStatistic, goldArmorStatistic);
        MetalArmorStatistic steelArmorStatistic = alloyArmorStatisticAverager("steel", ironArmorStatistic, manganeseArmorStatistic);

        metalArmorStatistics.add(angmallenArmorStatistic);
        metalArmorStatistics.add(bronzeArmorStatistic);
        metalArmorStatistics.add(damascusSteelArmorStatistic);
        metalArmorStatistics.add(hepatizonArmorStatistic);
        metalArmorStatistics.add(steelArmorStatistic);

        // Precious Metals
        MetalArmorStatistic platinumArmorStatistic = new MetalArmorStatistic("platinum", 20,
                Util.make(new EnumMap<>(ArmorItem.Type.class), (protectionForFunctionType) -> {
                    protectionForFunctionType.put(ArmorItem.Type.BOOTS, 2);
                    protectionForFunctionType.put(ArmorItem.Type.LEGGINGS, 5);
                    protectionForFunctionType.put(ArmorItem.Type.CHESTPLATE, 6);
                    protectionForFunctionType.put(ArmorItem.Type.HELMET, 2);
                }), 11, 0.5F, 0.0F, Ingredient.of(NFMTags.Items.INGOTS_PLATINUM));
        MetalArmorStatistic silverArmorStatistic = new MetalArmorStatistic("silver", 11,
                Util.make(new EnumMap<>(ArmorItem.Type.class), (protectionForFunctionType) -> {
                    protectionForFunctionType.put(ArmorItem.Type.BOOTS, 1);
                    protectionForFunctionType.put(ArmorItem.Type.LEGGINGS, 3);
                    protectionForFunctionType.put(ArmorItem.Type.CHESTPLATE, 5);
                    protectionForFunctionType.put(ArmorItem.Type.HELMET, 2);
                }), 22, 0.0F, 0.0F, Ingredient.of(NFMTags.Items.INGOTS_SILVER));
        MetalArmorStatistic zincArmorStatistic = new MetalArmorStatistic("zinc", 20,
                Util.make(new EnumMap<>(ArmorItem.Type.class), (protectionForFunctionType) -> {
                    protectionForFunctionType.put(ArmorItem.Type.BOOTS, 1);
                    protectionForFunctionType.put(ArmorItem.Type.LEGGINGS, 4);
                    protectionForFunctionType.put(ArmorItem.Type.CHESTPLATE, 5);
                    protectionForFunctionType.put(ArmorItem.Type.HELMET, 2);
                }), 8, 0.0F, 0.0F, Ingredient.of(NFMTags.Items.INGOTS_ZINC));

        MetalArmorStatistic brassArmorStatistic = alloyArmorStatisticAverager("brass", copperArmorStatistic, zincArmorStatistic);
        MetalArmorStatistic electrumArmorStatistic = alloyArmorStatisticAverager("electrum", goldArmorStatistic, silverArmorStatistic);

        metalArmorStatistics.add(platinumArmorStatistic);
        metalArmorStatistics.add(silverArmorStatistic);
        metalArmorStatistics.add(zincArmorStatistic);
        metalArmorStatistics.add(brassArmorStatistic);
        metalArmorStatistics.add(electrumArmorStatistic);

        // Fantasy Metals

        // Utility Metals

        // Nether Metals

        // End Metals

        return metalArmorStatistics;
    }


        public static MetalArmorStatistic alloyArmorStatisticAverager(String name, MetalArmorStatistic metal1, MetalArmorStatistic metal2){
        return weightedAlloyArmorStatisticAverager(name, metal1, metal2, 1 ,1);
    }

    public static MetalArmorStatistic weightedAlloyArmorStatisticAverager(String name, MetalArmorStatistic metal1, MetalArmorStatistic metal2, int weight1, int weight2){
        int totalWeight = weight1 + weight2;

        int durabilityMultiplier = (int) (double) ((metal1.durabilityMultiplier() + metal2.durabilityMultiplier()) / totalWeight);
        EnumMap<ArmorItem.Type, Integer> enumMap = Util.make(new EnumMap<>(ArmorItem.Type.class), (protectionForFunctionType) -> {
            protectionForFunctionType.put(ArmorItem.Type.BOOTS,
                    (metal1.protectionForFunctionType().get(ArmorItem.Type.BOOTS).intValue() +
                            metal2.protectionForFunctionType().get(ArmorItem.Type.BOOTS).intValue()) / totalWeight);
            protectionForFunctionType.put(ArmorItem.Type.LEGGINGS,
                    (metal1.protectionForFunctionType().get(ArmorItem.Type.LEGGINGS).intValue() +
                            metal2.protectionForFunctionType().get(ArmorItem.Type.LEGGINGS).intValue()) / totalWeight);
            protectionForFunctionType.put(ArmorItem.Type.CHESTPLATE,
                    (metal1.protectionForFunctionType().get(ArmorItem.Type.CHESTPLATE).intValue() +
                            metal2.protectionForFunctionType().get(ArmorItem.Type.CHESTPLATE).intValue()) / totalWeight);
            protectionForFunctionType.put(ArmorItem.Type.HELMET,
                    (metal1.protectionForFunctionType().get(ArmorItem.Type.HELMET).intValue() +
                            metal2.protectionForFunctionType().get(ArmorItem.Type.HELMET).intValue()) / totalWeight);
        });
        int enchantmentValue = (int) (double) ((metal1.enchantmentValue() + metal2.enchantmentValue()) / totalWeight);
        float toughness = (metal1.toughness() + metal2.toughness()) / totalWeight;
        float knockbackResistance = (metal1.knockbackResistance() + metal2.knockbackResistance()) / totalWeight;
        Ingredient repairIngredient = GetRepairIngredient.getRepairIngredient(name);

        return new MetalArmorStatistic(name, durabilityMultiplier, enumMap, enchantmentValue, toughness, knockbackResistance, repairIngredient);
    }
}
