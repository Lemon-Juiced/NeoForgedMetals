package lemon_juice.json_generators.data.neoforged_metals.recipes.crafting;

import lemon_juice.metal_data.resources.MetalResource;
import lemon_juice.metal_data.resources.MetalResourcesGenerator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PreciousMetalsCraftingRecipeGenerator {
    public static void preciousMetalsCraftingRecipeGenerator(){
        ArrayList<MetalResource> metalResources = MetalResourcesGenerator.generateMetalResources();
        for (int i = 0; i < metalResources.size(); i++) {
            MetalResource currentIndex = metalResources.get(i);
            if(currentIndex.oreGroup().equals("precious")){
                File boosterRailsFile = new File(generateBoosterRailsRecipeName(currentIndex.name()));
                writeBoosterRailsFile(boosterRailsFile, currentIndex.name());
            }
        }
    }

    public static String generateBoosterRailsRecipeName(String name){
        return "src/main/resources/data/neoforged_metals/recipes/crafting/precious_metals/booster_rails/" + name + ".json";
    }

    public static void writeBoosterRailsFile(File file, String name){
        try {
            if (!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "  \"type\": \"minecraft:crafting_shaped\",\n" +
                    "  \"pattern\": [\n" +
                    "    \"# #\",\n" +
                    "    \"#/#\",\n" +
                    "    \"#r#\"\n" +
                    "  ],\n" +
                    "  \"key\": {\n" +
                    "    \"#\": {\n" +
                    "      \"tag\": \"forge:ingots/" + name + "\"\n" +
                    "    },\n" +
                    "    \"/\": {\n" +
                    "      \"item\": \"minecraft:stick\"\n" +
                    "    },\n" +
                    "    \"r\": {\n" +
                    "      \"item\": \"minecraft:redstone\"\n" +
                    "    }\n" +
                    "  },\n" +
                    "  \"result\": {\n" +
                    "    \"item\": \"minecraft:golden_rail\",\n" +
                    "    \"count\": 6\n" +
                    "  }\n" +
                    "}");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
