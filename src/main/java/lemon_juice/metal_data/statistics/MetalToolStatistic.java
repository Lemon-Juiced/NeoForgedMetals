package lemon_juice.metal_data.statistics;

import net.minecraft.world.item.crafting.Ingredient;

public record MetalToolStatistic(String name, int level, int uses, float speed, float damage, int enchantmentValue, Ingredient repairIngredient) {}
