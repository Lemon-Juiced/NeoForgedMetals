package lemon_juice.metal_data.statistics;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;

public record MetalArmorStatistic(String name, int durabilityMultiplier, EnumMap<ArmorItem.Type, Integer> protectionForFunctionType, int enchantmentValue, float toughness, float knockbackResistance, Ingredient repairIngredient){}
