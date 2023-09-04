package lemon_juice.json_generators.data.neoforged_metals.recipes.crafting;

import lemon_juice.metal_resources.MetalResource;
import lemon_juice.metal_resources.MetalResourcesGenerator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class BaseMetalsCraftingRecipeGenerator {
    public static void baseMetalsCraftingRecipeGenerator(){
        ArrayList<MetalResource> metalResources = MetalResourcesGenerator.generateMetalResources();
        for (int i = 0; i < metalResources.size(); i++) {
            MetalResource currentIndex = metalResources.get(i);
            if(currentIndex.oreGroup().equals("base")){
                File bucketFile = new File(generateBucketRecipeName(currentIndex.name()));
                File railsFile = new File(generateRailsRecipeName(currentIndex.name()));
                File shearsFile = new File(generateShearsRecipeName(currentIndex.name()));
                writeBucketFile(bucketFile, currentIndex.name());
                writeRailsFile(railsFile, currentIndex.name());
                writeShearsFile(shearsFile, currentIndex.name());
            }
        }
    }

    public static String generateBucketRecipeName(String name){
        return "src/main/resources/data/neoforged_metals/recipes/crafting/base_metals/buckets/" + name + ".json";
    }

    public static String generateRailsRecipeName(String name){
        return "src/main/resources/data/neoforged_metals/recipes/crafting/base_metals/rails/" + name + ".json";
    }

    public static String generateShearsRecipeName(String name){
        return "src/main/resources/data/neoforged_metals/recipes/crafting/base_metals/shears/" + name + ".json";
    }

    public static void writeBucketFile(File file, String name){
        try {
            if (!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "  \"type\": \"minecraft:crafting_shaped\",\n" +
                    "  \"pattern\": [\n" +
                    "    \"# #\",\n" +
                    "    \" # \"\n" +
                    "  ],\n" +
                    "  \"key\": {\n" +
                    "    \"#\": {\n" +
                    "      \"tag\": \"forge:ingots/" + name + "\"\n" +
                    "    }\n" +
                    "  },\n" +
                    "  \"result\": {\n" +
                    "    \"item\": \"minecraft:bucket\",\n" +
                    "    \"count\": 1\n" +
                    "  }\n" +
                    "}");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeRailsFile(File file, String name){
        try {
            if (!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "  \"type\": \"minecraft:crafting_shaped\",\n" +
                    "  \"pattern\": [\n" +
                    "    \"# #\",\n" +
                    "    \"#/#\",\n" +
                    "    \"# #\"\n" +
                    "  ],\n" +
                    "  \"key\": {\n" +
                    "    \"#\": {\n" +
                    "      \"tag\": \"forge:ingots/" + name + "\"\n" +
                    "    },\n" +
                    "    \"/\": {\n" +
                    "      \"item\": \"minecraft:stick\"\n" +
                    "    }\n" +
                    "  },\n" +
                    "  \"result\": {\n" +
                    "    \"item\": \"minecraft:rail\",\n" +
                    "    \"count\": 16\n" +
                    "  }\n" +
                    "}");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeShearsFile(File file, String name){
        try {
            if (!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "  \"type\": \"minecraft:crafting_shaped\",\n" +
                    "  \"pattern\": [\n" +
                    "    \" #\",\n" +
                    "    \"# \"\n" +
                    "  ],\n" +
                    "  \"key\": {\n" +
                    "    \"#\": {\n" +
                    "      \"tag\": \"forge:ingots/" + name + "\"\n" +
                    "    }\n" +
                    "  },\n" +
                    "  \"result\": {\n" +
                    "    \"item\": \"minecraft:shears\",\n" +
                    "    \"count\": 1\n" +
                    "  }\n" +
                    "}");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
