package lemon_juice.neoforged_metals.registry;

import lemon_juice.metal_data.statistics.MetalArmorStatistic;
import lemon_juice.neoforged_metals.NeoForgedMetals;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;

public class MaterialRegistry{

    /**
     * Generates a metal material given its <code>MetalArmorStatistic</code>
     *
     * @param mas The <code>MetalArmorStatistic</code>
     * @return The metal material
     */
    public static ArmorMaterial generateMetalArmorMaterial(MetalArmorStatistic mas){
        ArmorMaterial generatedMaterial = new ArmorMaterial() {
            private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), (healthFunction) -> {
                healthFunction.put(ArmorItem.Type.BOOTS, 13);
                healthFunction.put(ArmorItem.Type.LEGGINGS, 15);
                healthFunction.put(ArmorItem.Type.CHESTPLATE, 16);
                healthFunction.put(ArmorItem.Type.HELMET, 11);
            });

            @Override
            public int getDurabilityForType(ArmorItem.Type type) {
                return HEALTH_FUNCTION_FOR_TYPE.get(type) * mas.durabilityMultiplier();
            }

            @Override
            public int getDefenseForType(ArmorItem.Type type) {
                return mas.protectionForFunctionType().get(type);
            }

            @Override
            public int getEnchantmentValue() {
                return mas.enchantmentValue();
            }

            @Override
            public SoundEvent getEquipSound() {
                return SoundEvents.ARMOR_EQUIP_GENERIC;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return mas.repairIngredient();
            }

            @Override
            public String getName() {
                return NeoForgedMetals.MOD_ID + ":" + mas.name();
            }

            @Override
            public float getToughness() {
                return mas.toughness();
            }

            @Override
            public float getKnockbackResistance() {
                return mas.durabilityMultiplier();
            }
        };
        return generatedMaterial;
    }

}
