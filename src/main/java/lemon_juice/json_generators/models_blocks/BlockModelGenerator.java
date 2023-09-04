package lemon_juice.json_generators.models_blocks;

import lemon_juice.metal_resources.MetalResource;
import lemon_juice.metal_resources.MetalResourcesGenerator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class BlockModelGenerator {
    public static void main(String[] args){
        ArrayList<MetalResource> metalResources = MetalResourcesGenerator.generateMetalResources();
        for (int i = 0; i < metalResources.size(); i++) {
            MetalResource currentIndex = metalResources.get(i);

            File blockFile = new File(generateBlockFileName("", currentIndex.name(), "block"));
            writeBlockModelFile(blockFile, "", currentIndex.name(), "block", currentIndex.oreGroup());

            if(!currentIndex.isAlloy()){ //If not alloy raw metal block and ore block
                File rawBlockFile = new File(generateBlockFileName("raw", currentIndex.name(), "block"));
                File oreFile = new File(generateBlockFileName("", currentIndex.name(), "ore"));
                writeBlockModelFile(rawBlockFile, "raw", currentIndex.name(), "block", currentIndex.oreGroup());
                writeBlockModelFile(oreFile, "", currentIndex.name(), "ore", currentIndex.oreGroup());

                if(!currentIndex.oreGroup().equals("nether") || !currentIndex.oreGroup().equals("end")){ //If not nether or end deepslate ore block
                    File deepslateOreFile = new File(generateBlockFileName("deepslate", currentIndex.name(), "ore"));
                    writeBlockModelFile(deepslateOreFile, "deepslate", currentIndex.name(), "ore", currentIndex.oreGroup());
                }
            }
        }
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
        String location = "src/main/resources/assets/neoforged_metals/models/block/";
        if(prefix.equals("")) return location + name + "_" + type + ".json";
        else return location + prefix + "_" + name + "_" + type + ".json";
    }

    /**
     * Generates a JSON file for the block model
     *
     * @param prefix The prefix of the file name if there is one
     * @param file The file itself
     * @param name The metal type for the file
     * @param type The item type for the file
     * @param oreGroup The oreGroup for the metal of the file
     */
    public static void writeBlockModelFile(File file, String prefix, String name, String type, String oreGroup){
        try{
            if(!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{");
            writer.println("    \"parent\": \"block/cube_all\",");
            writer.println("    \"textures\": {");


            if(prefix.equals("")) writer.println("        \"all\": \"neoforged_metals:block/" + name + "_" + type + "\"");
            else writer.println("        \"all\": \"neoforged_metals:block/" + prefix + "_" + name + "_" + type + "\"");

            writer.println("    }");
            writer.println("}");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
