package lemon_juice.json_generators.data.minecraft.tags.item;

import lemon_juice.metal_data.resources.MetalResource;
import lemon_juice.metal_data.resources.MetalResourcesGenerator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TrimmableArmorGenerator {
    public static void trimmmableArmorGenerator(){
        ArrayList<MetalResource> metalResources = MetalResourcesGenerator.generateMetalResources();
        File file = new File("src/main/resources/data/minecraft/tags/items/trimmable_armor.json");
        try {
            if(!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "  \"replace\": false,\n" +
                    "  \"values\": [");

            for (int i = 0; i < metalResources.size(); i++) {
                MetalResource currentIndex = metalResources.get(i);
                if(currentIndex.hasArmor()){
                    writer.print("    \"neoforged_metals:" + currentIndex.name() + "_helmet\",\n");
                    writer.print("    \"neoforged_metals:" + currentIndex.name() + "_chestplate\",\n");
                    writer.print("    \"neoforged_metals:" + currentIndex.name() + "_leggings\",\n");
                    writer.print("    \"neoforged_metals:" + currentIndex.name() + "_boots\"");
                    if(i < metalResources.size() - 1) writer.println(",");
                }
            }

            writer.println("\n  ]\n" +
                    "}");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
