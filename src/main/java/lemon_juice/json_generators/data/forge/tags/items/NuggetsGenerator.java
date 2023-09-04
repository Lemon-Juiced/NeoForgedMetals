package lemon_juice.json_generators.data.forge.tags.items;

import lemon_juice.metal_resources.MetalResource;
import lemon_juice.metal_resources.MetalResourcesGenerator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class NuggetsGenerator {
    public static void nuggetsGenerator(){
        ArrayList<MetalResource> metalResources = MetalResourcesGenerator.generateMetalResources();
        File file = new File("src/main/resources/data/forge/tags/items/nuggets.json");
        try {
            if(!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "  \"replace\": false,\n" +
                    "  \"values\": [\n" +
                    "    \"#forge:nuggets/copper\",\n" +
                    "    \"#forge:nuggets/netherite\",");

            for (int i = 0; i < metalResources.size(); i++) {
                MetalResource currentIndex = metalResources.get(i);

                // Register the items to their own individual files
                File folderFile = new File("src/main/resources/data/forge/tags/items/nuggets/" + currentIndex.name() + ".json");
                registerFolderFile(folderFile, currentIndex.name());

                if (i != metalResources.size() - 1) writer.println("    \"#forge:nuggets/" + currentIndex.name() + "\",");
                else writer.print("    \"#forge:nuggets/" + currentIndex.name() + "\"");
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
                    "    \"neoforged_metals:" + name + "_nugget\"\n" +
                    "  ]\n" +
                    "}");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
