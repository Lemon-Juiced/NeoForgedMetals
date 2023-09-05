package lemon_juice.json_generators.data.neoforged_metals.recipes.crafting;

import lemon_juice.metal_data.resources.MetalResource;
import lemon_juice.metal_data.resources.MetalResourcesGenerator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ArmorCraftingRecipeGenerator {
    public static void armorCraftingRecipeGenerator(){
        ArrayList<MetalResource> metalResources = MetalResourcesGenerator.generateMetalResources();
        for (int i = 0; i < metalResources.size(); i++) {
            MetalResource currentIndex = metalResources.get(i);
            if(currentIndex.hasTools()){
                File helmetFile = new File(generateArmorRecipeName(currentIndex.name(), "helmet"));
                File chestplateFile = new File(generateArmorRecipeName(currentIndex.name(), "chestplate"));
                File leggingsFile = new File(generateArmorRecipeName(currentIndex.name(), "leggings"));
                File bootsFile = new File(generateArmorRecipeName(currentIndex.name(), "boots"));
                writeHelmetFile(helmetFile, currentIndex.name());
                writeChestplateFile(chestplateFile, currentIndex.name());
                writeLeggingsFile(leggingsFile, currentIndex.name());
                writeBootsFile(bootsFile, currentIndex.name());
            }
        }
    }

    public static String generateArmorRecipeName(String name, String type){
        return "src/main/resources/data/neoforged_metals/recipes/crafting/armor/" + name + "_" + type + ".json";
    }

    public static void writeHelmetFile(File file, String name){
        try {
            if (!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "  \"type\": \"minecraft:crafting_shaped\",\n" +
                    "  \"pattern\": [\n" +
                    "    \"###\",\n" +
                    "    \"# #\"\n" +
                    "  ],\n" +
                    "  \"key\": {\n" +
                    "    \"#\": {\n" +
                    "      \"tag\": \"forge:ingots/" + name + "\"\n" +
                    "    }\n" +
                    "  },\n" +
                    "  \"result\": {\n" +
                    "    \"item\": \"neoforged_metals:" + name + "_helmet\",\n" +
                    "    \"count\": 1\n" +
                    "  }\n" +
                    "}");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeChestplateFile(File file, String name){
        try {
            if (!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "  \"type\": \"minecraft:crafting_shaped\",\n" +
                    "  \"pattern\": [\n" +
                    "    \"# #\",\n" +
                    "    \"###\",\n" +
                    "    \"###\"\n" +
                    "  ],\n" +
                    "  \"key\": {\n" +
                    "    \"#\": {\n" +
                    "      \"tag\": \"forge:ingots/" + name + "\"\n" +
                    "    }\n" +
                    "  },\n" +
                    "  \"result\": {\n" +
                    "    \"item\": \"neoforged_metals:" + name + "_chestplate\",\n" +
                    "    \"count\": 1\n" +
                    "  }\n" +
                    "}");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeLeggingsFile(File file, String name){
        try {
            if (!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "  \"type\": \"minecraft:crafting_shaped\",\n" +
                    "  \"pattern\": [\n" +
                    "    \"###\",\n" +
                    "    \"# #\",\n" +
                    "    \"# #\"\n" +
                    "  ],\n" +
                    "  \"key\": {\n" +
                    "    \"#\": {\n" +
                    "      \"tag\": \"forge:ingots/" + name + "\"\n" +
                    "    }\n" +
                    "  },\n" +
                    "  \"result\": {\n" +
                    "    \"item\": \"neoforged_metals:" + name + "_leggings\",\n" +
                    "    \"count\": 1\n" +
                    "  }\n" +
                    "}");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeBootsFile(File file, String name){
        try {
            if (!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "  \"type\": \"minecraft:crafting_shaped\",\n" +
                    "  \"pattern\": [\n" +
                    "    \"# #\",\n" +
                    "    \"# #\"\n" +
                    "  ],\n" +
                    "  \"key\": {\n" +
                    "    \"#\": {\n" +
                    "      \"tag\": \"forge:ingots/" + name + "\"\n" +
                    "    }\n" +
                    "  },\n" +
                    "  \"result\": {\n" +
                    "    \"item\": \"neoforged_metals:" + name + "_boots\",\n" +
                    "    \"count\": 1\n" +
                    "  }\n" +
                    "}");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}