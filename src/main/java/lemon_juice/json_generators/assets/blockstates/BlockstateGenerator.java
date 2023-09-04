package lemon_juice.json_generators.assets.blockstates;

import lemon_juice.metal_data.resources.MetalResource;
import lemon_juice.metal_data.resources.MetalResourcesGenerator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class BlockstateGenerator {
    public static void blockStateGenerator(){
        ArrayList<MetalResource> metalResources = MetalResourcesGenerator.generateMetalResources();
        for (int i = 0; i < metalResources.size(); i++) {
            MetalResource currentIndex = metalResources.get(i);

            File blockFile = new File(generateBlockstateFileName("", currentIndex.name(), "block"));
            writeBlockstateFile(blockFile, "", currentIndex.name(), "block");

            if(!currentIndex.isAlloy()){ //If not alloy raw metal block and ore block
                File rawBlockFile = new File(generateBlockstateFileName("raw", currentIndex.name(), "block"));
                File oreFile = new File(generateBlockstateFileName("", currentIndex.name(), "ore"));
                writeBlockstateFile(rawBlockFile, "raw", currentIndex.name(), "block");
                writeBlockstateFile(oreFile, "", currentIndex.name(), "ore");

                if(!currentIndex.oreGroup().equals("nether") || !currentIndex.oreGroup().equals("end")){ //If not nether or end deepslate ore block
                    File deepslateOreFile = new File(generateBlockstateFileName("deepslate", currentIndex.name(), "ore"));
                    writeBlockstateFile(deepslateOreFile, "deepslate", currentIndex.name(), "ore");
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
    public static String generateBlockstateFileName(String prefix, String name, String type){
        String location = "src/main/resources/assets/neoforged_metals/blockstates/";
        if(prefix.equals("")) return location + name + "_" + type + ".json";
        else return location + prefix + "_" + name + "_" + type + ".json";
    }

    /**
     * Generates a JSON file for the blockstate
     *
     * @param prefix The prefix of the file name if there is one
     * @param file The file itself
     * @param name The metal type for the file
     * @param type The item type for the file
     */
    public static void writeBlockstateFile(File file, String prefix, String name, String type){
        try{
            if(!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{");
            writer.println("    \"variants\": {");
            if(prefix.equals("")) writer.println("        \"\": { \"model\": \"neoforged_metals:block/" + name + "_" + type + "\" }");
            else writer.println("        \"\": { \"model\": \"neoforged_metals:block/" + prefix + "_" + name + "_" + type + "\" }");
            writer.println("    }");
            writer.println("}");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
