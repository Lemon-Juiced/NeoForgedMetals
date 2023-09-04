package lemon_juice.json_generators.data.minecraft.tags.block;

import lemon_juice.metal_data.resources.MetalResource;
import lemon_juice.metal_data.resources.MetalResourcesGenerator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MineableGenerator {
    public static void mineableGenerator(){
        ArrayList<MetalResource> metalResources = MetalResourcesGenerator.generateMetalResources();
        File file = new File("src/main/resources/data/minecraft/tags/blocks/mineable/pickaxe.json");
        try {
            if(!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "  \"replace\": false,\n" +
                    "  \"values\": [");

            for (int i = 0; i < metalResources.size(); i++) {
                MetalResource currentIndex = metalResources.get(i);

                if(!currentIndex.isAlloy()){ //If not alloy raw metal block and ore block
                    writer.print("    \"neoforged_metals:raw_" + currentIndex.name() + "_block\"");
                    writer.print("    \"neoforged_metals:" + currentIndex.name() + "_ore\"");

                    if(!currentIndex.oreGroup().equals("nether") || !currentIndex.oreGroup().equals("end")){ //If not nether or end deepslate ore block
                        writer.print("    \"neoforged_metals:deepslate_" + currentIndex.name() + "_ore\"");
                    }
                }

                writer.print("    \"neoforged_metals:" + currentIndex.name() + "_block\"");
                if(i < metalResources.size() - 1) writer.println(",");
            }

            writer.println("\n  ]\n" +
                    "}");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
