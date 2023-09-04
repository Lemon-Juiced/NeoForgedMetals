package lemon_juice.json_generators.data.minecraft.tags.block;

import lemon_juice.metal_data.resources.MetalResource;
import lemon_juice.metal_data.resources.MetalResourcesGenerator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class NeedsStoneToolGenerator {
    public static void needsStoneToolGenerator(){
        ArrayList<MetalResource> metalResources = MetalResourcesGenerator.generateMetalResources();
        File file = new File("src/main/resources/data/minecraft/tags/blocks/needs_stone_tool.json");
        try {
            if(!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "  \"replace\": false,\n" +
                    "  \"values\": [");

            ArrayList<MetalResource> stoneLevelResources = new ArrayList<>();
            for (int i = 0; i < metalResources.size(); i++) {
                MetalResource currentIndex = metalResources.get(i);
                if (currentIndex.tier() == 1) stoneLevelResources.add(currentIndex);
            }

            for (int i = 0; i < stoneLevelResources.size(); i++) {
                MetalResource currentIndex = stoneLevelResources.get(i);

                if(!currentIndex.isAlloy()){ //If not alloy raw metal block and ore block
                    writer.print("    \"neoforged_metals:raw_" + currentIndex.name() + "_block\",\n");
                    writer.print("    \"neoforged_metals:" + currentIndex.name() + "_ore\",\n");

                    if(!currentIndex.oreGroup().equals("nether") || !currentIndex.oreGroup().equals("end")){ //If not nether or end deepslate ore block
                        writer.print("    \"neoforged_metals:deepslate_" + currentIndex.name() + "_ore\",\n");
                    }
                }

                if (i != stoneLevelResources.size() - 1) writer.println("    \"neoforged_metals:" + currentIndex.name() + "_block\",");
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
