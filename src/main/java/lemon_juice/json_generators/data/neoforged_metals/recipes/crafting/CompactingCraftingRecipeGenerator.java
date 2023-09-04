package lemon_juice.json_generators.data.neoforged_metals.recipes.crafting;

import lemon_juice.metal_resources.MetalResource;
import lemon_juice.metal_resources.MetalResourcesGenerator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CompactingCraftingRecipeGenerator {
    public static void compactingCraftingRecipeGenerator(){
        ArrayList<MetalResource> metalResources = MetalResourcesGenerator.generateMetalResources();
        for (int i = 0; i < metalResources.size(); i++) {
            MetalResource currentIndex = metalResources.get(i);

            File ingotFile = new File(generateIngotRecipeName(currentIndex.name()));
            File nuggetFile = new File(generateNuggetRecipeName(currentIndex.name()));
            File rawFile = new File(generateRawRecipeName(currentIndex.name()));
            writeIngotFile(ingotFile, currentIndex.name());
            writeNuggetFile(nuggetFile, currentIndex.name());
            writeRawFile(rawFile, currentIndex.name());
        }
    }

    public static String generateIngotRecipeName(String name){
        return "src/main/resources/data/neoforged_metals/recipes/crafting/compacting/" + name + "_ingot.json";
    }

    public static String generateNuggetRecipeName(String name){
        return "src/main/resources/data/neoforged_metals/recipes/crafting/compacting/" + name + "_nugget.json";
    }

    public static String generateRawRecipeName(String name){
        return "src/main/resources/data/neoforged_metals/recipes/crafting/compacting/raw_" + name + ".json";
    }

    public static void writeIngotFile(File file, String name){
        try {
            if (!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "  \"type\": \"minecraft:crafting_shaped\",\n" +
                    "  \"pattern\": [\n" +
                    "    \"###\",\n" +
                    "    \"###\",\n" +
                    "    \"###\"\n" +
                    "  ],\n" +
                    "  \"key\": {\n" +
                    "    \"#\": {\n" +
                    "      \"tag\": \"forge:ingots/" + name + "\"\n" +
                    "    }\n" +
                    "  },\n" +
                    "  \"result\": {\n" +
                    "    \"item\": \"neoforged_metals:" + name + "_block\",\n" +
                    "    \"count\": 1\n" +
                    "  }\n" +
                    "}");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeNuggetFile(File file, String name){
        try {
            if (!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "  \"type\": \"minecraft:crafting_shaped\",\n" +
                    "  \"pattern\": [\n" +
                    "    \"###\",\n" +
                    "    \"###\",\n" +
                    "    \"###\"\n" +
                    "  ],\n" +
                    "  \"key\": {\n" +
                    "    \"#\": {\n" +
                    "      \"tag\": \"forge:nuggets/" + name + "\"\n" +
                    "    }\n" +
                    "  },\n" +
                    "  \"result\": {\n" +
                    "    \"item\": \"neoforged_metals:" + name + "_ingot\",\n" +
                    "    \"count\": 1\n" +
                    "  }\n" +
                    "}");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeRawFile(File file, String name){
        try {
            if (!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "  \"type\": \"minecraft:crafting_shaped\",\n" +
                    "  \"pattern\": [\n" +
                    "    \"###\",\n" +
                    "    \"###\",\n" +
                    "    \"###\"\n" +
                    "  ],\n" +
                    "  \"key\": {\n" +
                    "    \"#\": {\n" +
                    "      \"tag\": \"forge:raw_materials/" + name + "\"\n" +
                    "    }\n" +
                    "  },\n" +
                    "  \"result\": {\n" +
                    "    \"item\": \"neoforged_metals:raw_" + name + "_block\",\n" +
                    "    \"count\": 1\n" +
                    "  }\n" +
                    "}");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
