package lemon_juice.json_generators.data.neoforged_metals.recipes.crafting;

import lemon_juice.metal_resources.MetalResource;
import lemon_juice.metal_resources.MetalResourcesGenerator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DecompactingCraftingRecipeGenerator {
    public static void decompactingCraftingRecipeGenerator(){
    ArrayList<MetalResource> metalResources = MetalResourcesGenerator.generateMetalResources();
        for (int i = 0; i < metalResources.size(); i++) {
        MetalResource currentIndex = metalResources.get(i);

        File blockFile = new File(generateBlockRecipeName(currentIndex.name()));
        File ingotFile = new File(generateIngotRecipeName(currentIndex.name()));
        File rawBlockFile = new File(generateRawBlockRecipeName(currentIndex.name()));
        writeBlockFile(blockFile, currentIndex.name());
        writeIngotFile(ingotFile, currentIndex.name());
        writeRawBlockFile(rawBlockFile, currentIndex.name());
    }
}

    public static String generateBlockRecipeName(String name){
        return "src/main/resources/data/neoforged_metals/recipes/crafting/decompacting/" + name + "_block.json";
    }

    public static String generateIngotRecipeName(String name){
        return "src/main/resources/data/neoforged_metals/recipes/crafting/decompacting/" + name + "_ingot.json";
    }

    public static String generateRawBlockRecipeName(String name){
        return "src/main/resources/data/neoforged_metals/recipes/crafting/decompacting/raw_" + name + "_block.json";
    }

    public static void writeBlockFile(File file, String name){
        try {
            if (!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "    \"type\": \"minecraft:crafting_shapeless\",\n" +
                    "    \"ingredients\": [\n" +
                    "        {\n" +
                    "            \"tag\": \"forge:storage_blocks/" + name + "\"\n" +
                    "        }\n" +
                    "    ],\n" +
                    "    \"result\": {\n" +
                    "        \"item\": \"neoforged_metals:" + name + "_ingot\",\n" +
                    "        \"count\": 9\n" +
                    "    }\n" +
                    "}");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeIngotFile(File file, String name){
        try {
            if (!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "    \"type\": \"minecraft:crafting_shapeless\",\n" +
                    "    \"ingredients\": [\n" +
                    "        {\n" +
                    "            \"tag\": \"forge:ingots/" + name + "\"\n" +
                    "        }\n" +
                    "    ],\n" +
                    "    \"result\": {\n" +
                    "        \"item\": \"neoforged_metals:" + name + "_nugget\",\n" +
                    "        \"count\": 9\n" +
                    "    }\n" +
                    "}");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeRawBlockFile(File file, String name){
        try {
            if (!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "    \"type\": \"minecraft:crafting_shapeless\",\n" +
                    "    \"ingredients\": [\n" +
                    "        {\n" +
                    "            \"tag\": \"forge:storage_blocks/raw_" + name + "\"\n" +
                    "        }\n" +
                    "    ],\n" +
                    "    \"result\": {\n" +
                    "        \"item\": \"neoforged_metals:raw_" + name + "\",\n" +
                    "        \"count\": 9\n" +
                    "    }\n" +
                    "}");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
