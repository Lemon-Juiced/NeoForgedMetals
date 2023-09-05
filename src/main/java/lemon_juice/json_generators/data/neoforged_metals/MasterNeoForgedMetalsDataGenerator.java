package lemon_juice.json_generators.data.neoforged_metals;

import lemon_juice.json_generators.data.neoforged_metals.loot_tables.blocks.LootTableBlockGenerator;
import lemon_juice.json_generators.data.neoforged_metals.recipes.blasting.BlastingRecipeGenerator;
import lemon_juice.json_generators.data.neoforged_metals.recipes.crafting.*;
import lemon_juice.json_generators.data.neoforged_metals.recipes.smelting.SmeltingRecipeGenerator;

public class MasterNeoForgedMetalsDataGenerator {
    public static void masterNeoForgedMetalsDataGenerator(){
        LootTableBlockGenerator.lootTableBlockGenerator();

        BlastingRecipeGenerator.blastingRecipeGenerator();

        ArmorCraftingRecipeGenerator.armorCraftingRecipeGenerator();
        BaseMetalsCraftingRecipeGenerator.baseMetalsCraftingRecipeGenerator();
        CompactingCraftingRecipeGenerator.compactingCraftingRecipeGenerator();
        DecompactingCraftingRecipeGenerator.decompactingCraftingRecipeGenerator();
        PreciousMetalsCraftingRecipeGenerator.preciousMetalsCraftingRecipeGenerator();
        ToolsCraftingRecipeGenerator.toolsCraftingRecipeGenerator();

        SmeltingRecipeGenerator.smeltingRecipeGenerator();
    }
}
