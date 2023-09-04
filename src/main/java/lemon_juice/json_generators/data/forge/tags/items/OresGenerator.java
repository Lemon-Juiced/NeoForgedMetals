package lemon_juice.json_generators.data.forge.tags.items;

import lemon_juice.metal_data.resources.MetalResource;
import lemon_juice.metal_data.resources.MetalResourcesGenerator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class OresGenerator {
    public static void oresGenerator(){
        ArrayList<MetalResource> metalResources = MetalResourcesGenerator.generateMetalResources();
        File file = new File("src/main/resources/data/forge/tags/items/ores.json");
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

                File folderFile = new File("src/main/resources/data/forge/tags/items/ores/" + currentIndex.name() + ".json");
                if(!currentIndex.oreGroup().equals("nether") || !currentIndex.oreGroup().equals("end")){
                    registerDeepslateFolderFile(folderFile, currentIndex.name());
                } else {
                    registerFolderFile(folderFile, currentIndex.name());
                }

                if (i != nonAlloyResources.size() - 1) writer.println("    \"#forge:ores/" + currentIndex.name() + "\",");
                else writer.print("    \"#forge:ores/" + currentIndex.name() + "\"");
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
                    "    \"neoforged_metals:" + name + "_ore\"\n" +
                    "  ]\n" +
                    "}");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void registerDeepslateFolderFile(File file, String name){
        try {
            if(!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "  \"replace\": false,\n" +
                    "  \"values\": [\n" +
                    "    \"neoforged_metals:deepslate_" + name + "_ore\",\n" +
                    "    \"neoforged_metals:" + name + "_ore\"\n" +
                    "  ]\n" +
                    "}");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
