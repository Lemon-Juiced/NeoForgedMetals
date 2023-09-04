package lemon_juice.json_generators.data.forge.tags.items;

import lemon_juice.metal_resources.MetalResource;
import lemon_juice.metal_resources.MetalResourcesGenerator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DustsGenerator {
    public static void dustsGenerator(){
        ArrayList<MetalResource> metalResources = MetalResourcesGenerator.generateMetalResources();
        File file = new File("src/main/resources/data/forge/tags/items/dusts.json");
        try {
            if(!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "  \"replace\": false,\n" +
                    "  \"values\": [\n" +
                    "    \"#forge:dusts/copper\",\n" +
                    "    \"#forge:dusts/gold\",\n" +
                    "    \"#forge:dusts/iron\",\n" +
                    "    \"#forge:dusts/netherite\",");

            for (int i = 0; i < metalResources.size(); i++) {
                MetalResource currentIndex = metalResources.get(i);

                // Register the items to their own individual files
                File folderFile = new File("src/main/resources/data/forge/tags/items/dusts/" + currentIndex.name() + ".json");
                registerFolderFile(folderFile, currentIndex.name());

                if (i != metalResources.size() - 1) writer.println("    \"#forge:dusts/" + currentIndex.name() + "\",");
                else writer.print("    \"#forge:dusts/" + currentIndex.name() + "\"");
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
                    "    \"neoforged_metals:" + name + "_dust\"\n" +
                    "  ]\n" +
                    "}");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
