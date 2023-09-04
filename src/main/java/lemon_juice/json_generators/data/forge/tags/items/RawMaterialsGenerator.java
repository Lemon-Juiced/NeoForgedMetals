package lemon_juice.json_generators.data.forge.tags.items;

import lemon_juice.metal_data.resources.MetalResource;
import lemon_juice.metal_data.resources.MetalResourcesGenerator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class RawMaterialsGenerator {
    public static void rawMaterialsGenerator(){
        ArrayList<MetalResource> metalResources = MetalResourcesGenerator.generateMetalResources();
        File file = new File("src/main/resources/data/forge/tags/items/raw_materials.json");
        try {
            if(!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "  \"replace\": false,\n" +
                    "  \"values\": [");

            ArrayList<MetalResource> nonAlloyResources = new ArrayList<>();
            for (int i = 0; i < metalResources.size(); i++) {
                MetalResource currentIndex = metalResources.get(i);
                if (!currentIndex.isAlloy()) nonAlloyResources.add(currentIndex);
            }

            for (int i = 0; i < nonAlloyResources.size(); i++) {
                MetalResource currentIndex = nonAlloyResources.get(i);

                // Register the items to their own individual files
                File folderFile = new File("src/main/resources/data/forge/tags/items/raw_materials/" + currentIndex.name() + ".json");
                registerFolderFile(folderFile, currentIndex.name());

                if (i != nonAlloyResources.size() - 1) writer.println("    \"#forge:raw_materials/" + currentIndex.name() + "\",");
                else writer.print("    \"#forge:raw_materials/" + currentIndex.name() + "\"");
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
                    "    \"neoforged_metals:raw_" + name + "\"\n" +
                    "  ]\n" +
                    "}");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
