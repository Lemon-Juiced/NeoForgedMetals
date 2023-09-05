package lemon_juice.json_generators.data.neoforged_metals.recipes.crafting;

import lemon_juice.metal_data.resources.MetalResource;
import lemon_juice.metal_data.resources.MetalResourcesGenerator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ToolsCraftingRecipeGenerator {
    public static void toolsCraftingRecipeGenerator(){
        ArrayList<MetalResource> metalResources = MetalResourcesGenerator.generateMetalResources();
        for (int i = 0; i < metalResources.size(); i++) {
            MetalResource currentIndex = metalResources.get(i);
            if(currentIndex.hasTools()){
                File swordFile = new File(generateToolsRecipeName(currentIndex.name(), "sword"));
                File pickaxeFile = new File(generateToolsRecipeName(currentIndex.name(), "pickaxe"));
                File axeFile = new File(generateToolsRecipeName(currentIndex.name(), "axe"));
                File shovelFile = new File(generateToolsRecipeName(currentIndex.name(), "shovel"));
                File hoeFile = new File(generateToolsRecipeName(currentIndex.name(), "hoe"));
                writeSwordFile(swordFile, currentIndex.name());
                writePickaxeFile(pickaxeFile, currentIndex.name());
                writeAxeFile(axeFile, currentIndex.name());
                writeShovelFile(shovelFile, currentIndex.name());
                writeHoeFile(hoeFile, currentIndex.name());
            }
        }
    }

    public static String generateToolsRecipeName(String name, String type){
        return "src/main/resources/data/neoforged_metals/recipes/crafting/tools/" + name + "_" + type + ".json";
    }

    public static void writeSwordFile(File file, String name){
        try {
            if (!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "  \"type\": \"minecraft:crafting_shaped\",\n" +
                    "  \"pattern\": [\n" +
                    "    \"#\",\n" +
                    "    \"#\",\n" +
                    "    \"/\"\n" +
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
                    "    \"item\": \"neoforged_metals:" + name + "_sword\",\n" +
                    "    \"count\": 1\n" +
                    "  }\n" +
                    "}");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writePickaxeFile(File file, String name){
        try {
            if (!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "  \"type\": \"minecraft:crafting_shaped\",\n" +
                    "  \"pattern\": [\n" +
                    "    \"###\",\n" +
                    "    \" / \",\n" +
                    "    \" / \"\n" +
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
                    "    \"item\": \"neoforged_metals:" + name + "_pickaxe\",\n" +
                    "    \"count\": 1\n" +
                    "  }\n" +
                    "}");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeAxeFile(File file, String name){
        try {
            if (!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "  \"type\": \"minecraft:crafting_shaped\",\n" +
                    "  \"pattern\": [\n" +
                    "    \"##\",\n" +
                    "    \"#/\",\n" +
                    "    \" /\"\n" +
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
                    "    \"item\": \"neoforged_metals:" + name + "_axe\",\n" +
                    "    \"count\": 1\n" +
                    "  }\n" +
                    "}");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeShovelFile(File file, String name){
        try {
            if (!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "  \"type\": \"minecraft:crafting_shaped\",\n" +
                    "  \"pattern\": [\n" +
                    "    \"#\",\n" +
                    "    \"/\",\n" +
                    "    \"/\"\n" +
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
                    "    \"item\": \"neoforged_metals:" + name + "_shovel\",\n" +
                    "    \"count\": 1\n" +
                    "  }\n" +
                    "}");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeHoeFile(File file, String name){
        try {
            if (!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "  \"type\": \"minecraft:crafting_shaped\",\n" +
                    "  \"pattern\": [\n" +
                    "    \"##\",\n" +
                    "    \" /\",\n" +
                    "    \" /\"\n" +
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
                    "    \"item\": \"neoforged_metals:" + name + "_hoe\",\n" +
                    "    \"count\": 1\n" +
                    "  }\n" +
                    "}");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}