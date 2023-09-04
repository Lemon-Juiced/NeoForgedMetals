package lemon_juice.json_generators.data.forge.tags.blocks;

import lemon_juice.metal_resources.MetalResource;
import lemon_juice.metal_resources.MetalResourcesGenerator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class NeedsNetheriteToolGenerator {
    public static void needsNetheriteToolGenerator(){
        ArrayList<MetalResource> metalResources = MetalResourcesGenerator.generateMetalResources();
        File file = new File("src/main/resources/data/forge/tags/blocks/needs_netherite_tool.json");
        try {
            if(!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "  \"replace\": false,\n" +
                    "  \"values\": [");

            ArrayList<MetalResource> netheriteLevelResources = new ArrayList<>();
            for (int i = 0; i < metalResources.size(); i++) {
                MetalResource currentIndex = metalResources.get(i);
                if (currentIndex.tier() == 4) netheriteLevelResources.add(currentIndex);
            }

            for (int i = 0; i < netheriteLevelResources.size(); i++) {
                MetalResource currentIndex = netheriteLevelResources.get(i);

                if(!currentIndex.isAlloy()){ //If not alloy raw metal block and ore block
                    writer.print("    \"neoforged_metals:raw_" + currentIndex.name() + "_block\",\n");
                    writer.print("    \"neoforged_metals:" + currentIndex.name() + "_ore\",\n");

                    if(!currentIndex.oreGroup().equals("nether") || !currentIndex.oreGroup().equals("end")){ //If not nether or end deepslate ore block
                        writer.print("    \"neoforged_metals:deepslate_" + currentIndex.name() + "_ore\",\n");
                    }
                }

                if (i != netheriteLevelResources.size() - 1) writer.println("    \"neoforged_metals:" + currentIndex.name() + "_block\",");
                else writer.print("    \"neoforged_metals:" + currentIndex.name() + "_block\"");
            }

            writer.println("\n  ]\n" +
                    "}");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
