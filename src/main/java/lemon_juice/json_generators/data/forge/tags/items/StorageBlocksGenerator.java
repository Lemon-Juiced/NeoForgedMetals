package lemon_juice.json_generators.data.forge.tags.items;

import lemon_juice.metal_data.resources.MetalResource;
import lemon_juice.metal_data.resources.MetalResourcesGenerator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class StorageBlocksGenerator {
    public static void storageBlocksGenerator(){
        ArrayList<MetalResource> metalResources = MetalResourcesGenerator.generateMetalResources();
        File file = new File("src/main/resources/data/forge/tags/items/storage_blocks.json");
        try {
            if(!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "  \"replace\": false,\n" +
                    "  \"values\": [");

            for (int i = 0; i < metalResources.size(); i++) {
                MetalResource currentIndex = metalResources.get(i);

                if(!currentIndex.isAlloy()){
                    File rawFolderFile = new File("src/main/resources/data/forge/tags/items/storage_blocks/raw_" + currentIndex.name() + ".json");
                    registerRawFolderFile(rawFolderFile, currentIndex.name());
                    writer.println("    \"#forge:storage_blocks/raw_" + currentIndex.name() + "\",");
                }

                // Register the items to their own individual files
                File folderFile = new File("src/main/resources/data/forge/tags/items/storage_blocks/" + currentIndex.name() + ".json");
                registerFolderFile(folderFile, currentIndex.name());

                if (i != metalResources.size() - 1) writer.println("    \"#forge:storage_blocks/" + currentIndex.name() + "\",");
                else writer.print("    \"#forge:storage_blocks/" + currentIndex.name() + "\"");
            }

            writer.println("\n  ]\n" +
                    "}");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void registerFolderFile(File file, String name){
        try {
            if(!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "  \"replace\": false,\n" +
                    "  \"values\": [\n" +
                    "    \"neoforged_metals:" + name + "_block\"\n" +
                    "  ]\n" +
                    "}");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void registerRawFolderFile(File file, String name){
        try {
            if(!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "  \"replace\": false,\n" +
                    "  \"values\": [\n" +
                    "    \"neoforged_metals:raw_" + name + "_block\"\n" +
                    "  ]\n" +
                    "}");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
