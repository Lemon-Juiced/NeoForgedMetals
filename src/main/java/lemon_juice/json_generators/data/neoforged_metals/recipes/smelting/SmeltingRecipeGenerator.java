package lemon_juice.json_generators.data.neoforged_metals.recipes.smelting;

import lemon_juice.metal_resources.MetalResource;
import lemon_juice.metal_resources.MetalResourcesGenerator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SmeltingRecipeGenerator {
    public static void smeltingRecipeGenerator(){
        ArrayList<MetalResource> metalResources = MetalResourcesGenerator.generateMetalResources();
        for (int i = 0; i < metalResources.size(); i++) {
            MetalResource currentIndex = metalResources.get(i);

            File dustFile = new File(generateDustRecipeName(currentIndex.name()));
            writeDustFile(dustFile, currentIndex.name());

            if(!currentIndex.isAlloy()){ //If not alloy raw metal and ore
                File oreFile = new File(generateOreRecipeName(currentIndex.name()));
                File rawFile = new File(generateRawRecipeName(currentIndex.name()));
                writeOreFile(oreFile, currentIndex.name());
                writeRawFile(rawFile, currentIndex.name());
            }
        }
    }

    public static String generateDustRecipeName(String name){
        return "src/main/resources/data/neoforged_metals/recipes/smelting/dust/" + name + ".json";
    }

    public static String generateOreRecipeName(String name){
        return "src/main/resources/data/neoforged_metals/recipes/smelting/ore/" + name + ".json";
    }

    public static String generateRawRecipeName(String name){
        return "src/main/resources/data/neoforged_metals/recipes/smelting/raw/" + name + ".json";
    }

    public static void writeDustFile(File file, String name){
        try {
            if (!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "  \"type\": \"minecraft:smelting\",\n" +
                    "  \"ingredient\": {\n" +
                    "    \"tag\": \"forge:dusts/" + name + "\"\n" +
                    "  },\n" +
                    "  \"result\": \"neoforged_metals:" + name + "_ingot\",\n" +
                    "  \"experience\": 0.1,\n" +
                    "  \"cookingtime\": 200\n" +
                    "}");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeOreFile(File file, String name){
        try {
            if (!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "  \"type\": \"minecraft:smelting\",\n" +
                    "  \"ingredient\": {\n" +
                    "    \"tag\": \"forge:ores/" + name + "\"\n" +
                    "  },\n" +
                    "  \"result\": \"neoforged_metals:" + name + "_ingot\",\n" +
                    "  \"experience\": 0.1,\n" +
                    "  \"cookingtime\": 200\n" +
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
                    "  \"type\": \"minecraft:smelting\",\n" +
                    "  \"ingredient\": {\n" +
                    "    \"tag\": \"forge:raw_materials/" + name + "\"\n" +
                    "  },\n" +
                    "  \"result\": \"neoforged_metals:" + name + "_ingot\",\n" +
                    "  \"experience\": 0.1,\n" +
                    "  \"cookingtime\": 200\n" +
                    "}");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
