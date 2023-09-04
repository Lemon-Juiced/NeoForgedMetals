package lemon_juice.json_generators.assets.models_items;

import lemon_juice.metal_resources.MetalResource;
import lemon_juice.metal_resources.MetalResourcesGenerator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Generates Item modem JSONs for all metals
 */
public class ItemModelGenerator {
    public static void itemModelGenerator(){
        ArrayList<MetalResource> metalResources = MetalResourcesGenerator.generateMetalResources();
        for (int i = 0; i < metalResources.size(); i++) {
            MetalResource currentIndex = metalResources.get(i);

            // Items
            File ingotFile = new File(generateItemFileName(currentIndex.name(), "ingot"));
            File nuggetFile = new File(generateItemFileName(currentIndex.name(), "nugget"));
            File dustFile = new File(generateItemFileName(currentIndex.name(), "dust"));
            writeItemFile(ingotFile, currentIndex.name(), "ingot");
            writeItemFile(nuggetFile, currentIndex.name(), "nugget");
            writeItemFile(dustFile, currentIndex.name(), "dust");

            // Blocks
            File blockFile = new File(generateBlockFileName("", currentIndex.name(), "block"));
            writeBlockFile(blockFile, "", currentIndex.name(), "block");

            if(!currentIndex.isAlloy()){ //If not alloy raw metal block and ore block
                File rawBlockFile = new File(generateBlockFileName("raw", currentIndex.name(), "block"));
                File oreFile = new File(generateBlockFileName("", currentIndex.name(), "ore"));
                writeBlockFile(rawBlockFile, "raw", currentIndex.name(), "block");
                writeBlockFile(oreFile, "", currentIndex.name(), "ore");

                if(!currentIndex.oreGroup().equals("nether") || !currentIndex.oreGroup().equals("end")){ //If not nether or end deepslate ore block
                    File deepslateOreFile = new File(generateBlockFileName("deepslate", currentIndex.name(), "ore"));
                    writeBlockFile(deepslateOreFile, "deepslate", currentIndex.name(), "ore");
                }
            }
        }
    }

    /**
     * Generates a file name and location for a specific file (item only)
     *
     * @param name The metal type for the file
     * @param type The item type for the file
     * @return a file name and location for a specific file
     */
    public static String generateItemFileName(String name, String type){
        return "src/main/resources/assets/neoforged_metals/models/item/" + name + "_" + type + ".json";
    }

    /**
     * Generates a file name and location for a specific file (block only)
     *
     * @param prefix The prefix of the file name if there is one
     * @param name The metal type for the file
     * @param type The item type for the file
     * @return a file name and location for a specific file
     */
    public static String generateBlockFileName(String prefix, String name, String type){
        String location = "src/main/resources/assets/neoforged_metals/models/item/";
        if(prefix.equals("")) return location + name + "_" + type + ".json";
        else return location + prefix + "_" + name + "_" + type + ".json";
    }

    /**
     * Generates a JSON file (item only)
     *
     * @param file The file itself
     * @param name The metal type for the file
     * @param type The item type for the file
     */
    public static void writeItemFile(File file, String name, String type){
        try{
            if(!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{");
            writer.println("    \"parent\": \"item/generated\",");
            writer.println("    \"textures\": {");
            writer.println("        \"layer0\": \"neoforged_metals:item/" + name + "_" + type + "\"");
            writer.println("    }");
            writer.println("}");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Generates a JSON file (block only)
     *
     * @param prefix The prefix of the file name if there is one
     * @param file The file itself
     * @param name The metal type for the file
     * @param type The item type for the file
     */
    public static void writeBlockFile(File file, String prefix, String name, String type){
        try{
            if(!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{");
            if(prefix.equals("")) writer.println("    \"parent\": \"neoforged_metals:block/" + name + "_" + type + "\"");
            else writer.println("    \"parent\": \"neoforged_metals:block/" + prefix + "_" + name + "_" + type + "\"");
            writer.println("}");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
