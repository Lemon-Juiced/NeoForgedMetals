package lemon_juice.json_generators.data.neoforged_metals;

import lemon_juice.json_generators.data.neoforged_metals.loot_tables.blocks.LootTableBlockGenerator;
import lemon_juice.json_generators.data.neoforged_metals.recipes.blasting.BlastingRecipeGenerator;
import lemon_juice.json_generators.data.neoforged_metals.recipes.crafting.BaseMetalsCraftingRecipeGenerator;
import lemon_juice.json_generators.data.neoforged_metals.recipes.crafting.CompactingCraftingRecipeGenerator;
import lemon_juice.json_generators.data.neoforged_metals.recipes.crafting.DecompactingCraftingRecipeGenerator;
import lemon_juice.json_generators.data.neoforged_metals.recipes.smelting.SmeltingRecipeGenerator;

public class MasterNeoForgedMetalsDataGenerator {
    public static void masterNeoForgedMetalsDataGenerator(){
        LootTableBlockGenerator.lootTableBlockGenerator();

        BlastingRecipeGenerator.blastingRecipeGenerator();

        BaseMetalsCraftingRecipeGenerator.baseMetalsCraftingRecipeGenerator();
        CompactingCraftingRecipeGenerator.compactingCraftingRecipeGenerator();
        DecompactingCraftingRecipeGenerator.decompactingCraftingRecipeGenerator();

        SmeltingRecipeGenerator.smeltingRecipeGenerator();
    }
}
