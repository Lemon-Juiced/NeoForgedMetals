package lemon_juice.json_generators.data.neoforged_metals.loot_tables.blocks;

import lemon_juice.metal_resources.MetalResource;
import lemon_juice.metal_resources.MetalResourcesGenerator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class LootTableBlockGenerator {
    public static void lootTableBlockGenerator(){
        ArrayList<MetalResource> metalResources = MetalResourcesGenerator.generateMetalResources();
        for (int i = 0; i < metalResources.size(); i++) {
            MetalResource currentIndex = metalResources.get(i);

            File blockFile = new File(generateLootTableFileName("", currentIndex.name(), "block"));
            writeLootTableFile(blockFile, "", currentIndex.name(), "block");

            if(!currentIndex.isAlloy()){ //If not alloy raw metal block and ore block
                File rawBlockFile = new File(generateLootTableFileName("raw", currentIndex.name(), "block"));
                File oreFile = new File(generateLootTableFileName("", currentIndex.name(), "ore"));
                writeLootTableFile(rawBlockFile, "raw", currentIndex.name(), "block");
                writeLootTableFile(oreFile, "", currentIndex.name(), "ore");

                if(!currentIndex.oreGroup().equals("nether") || !currentIndex.oreGroup().equals("end")){ //If not nether or end deepslate ore block
                    File deepslateOreFile = new File(generateLootTableFileName("deepslate", currentIndex.name(), "ore"));
                    writeLootTableFile(deepslateOreFile, "deepslate", currentIndex.name(), "ore");
                }
            }
        }
    }

    /**
     * Generates a file name and location for a specific loot table
     *
     * @param prefix The prefix of the file name if there is one
     * @param name The metal type for the file
     * @param type The item type for the file
     * @return a file name and location for a specific file
     */
    public static String generateLootTableFileName(String prefix, String name, String type){
        String location = "src/main/resources/data/neoforged_metals/loot_tables/blocks/";
        if(prefix.equals("")) return location + name + "_" + type + ".json";
        else return location + prefix + "_" + name + "_" + type + ".json";
    }

    /**
     * Generates a JSON file for the loot table
     *
     * @param file The file itself
     * @param prefix The prefix of the file name if there is one
     * @param name The metal type for the file
     * @param type The item type for the file
     */
    public static void writeLootTableFile(File file, String prefix, String name, String type) {
        if (type.equals("block")) writeBlockLootTableFile(file, prefix, name);
        if (type.equals("ore")) writeOreLootTableFile(file, prefix, name);
    }

    /**
     * Generates a JSON file for the loot table (of a block of metal or raw metal)
     *
     * @param prefix The prefix of the file name if there is one
     * @param file The file itself
     * @param name The metal type for the file
     */
    public static void writeBlockLootTableFile(File file, String prefix, String name) {
        try{
            if(!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
            "  \"type\": \"minecraft:block\",\n" +
            "  \"pools\": [\n" +
            "    {\n" +
            "      \"bonus_rolls\": 0.0,\n" +
            "      \"conditions\": [\n" +
            "        {\n" +
            "          \"condition\": \"minecraft:survives_explosion\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"entries\": [\n" +
            "        {\n" +
            "          \"type\": \"minecraft:item\",");

            if(prefix.equals("")){
                writer.println("          \"name\": \"neoforged_metals:" + name + "_block\"");
            } else {
                writer.println("          \"name\": \"neoforged_metals:raw_" + name + "_block\"");
            }

            writer.println("        }\n" +
            "      ],\n" +
            "      \"rolls\": 1.0\n" +
            "    }\n" +
            "  ],\n");

            if(prefix.equals("")){
                writer.println("  \"random_sequence\": \"neoforged_metals:" + name + "_block\"");
            } else {
                writer.println("  \"random_sequence\": \"neoforged_metals:raw_" + name + "_block\"");
            }

            writer.println("}");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Generates a JSON file for the loot table (of a block of ore and deepslate ore)
     *
     * @param prefix The prefix of the file name if there is one
     * @param file The file itself
     * @param name The metal type for the file
     */
    public static void writeOreLootTableFile(File file, String prefix, String name) {
        try{
            if(!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
            "  \"type\": \"minecraft:block\",\n" +
            "  \"pools\": [\n" +
            "    {\n" +
            "      \"bonus_rolls\": 0.0,\n" +
            "      \"entries\": [\n" +
            "        {\n" +
            "          \"type\": \"minecraft:alternatives\",\n" +
            "          \"children\": [\n" +
            "            {\n" +
            "              \"type\": \"minecraft:item\",\n" +
            "              \"conditions\": [\n" +
            "                {\n" +
            "                  \"condition\": \"minecraft:match_tool\",\n" +
            "                  \"predicate\": {\n" +
            "                    \"enchantments\": [\n" +
            "                      {\n" +
            "                        \"enchantment\": \"minecraft:silk_touch\",\n" +
            "                        \"levels\": {\n" +
            "                          \"min\": 1\n" +
            "                        }\n" +
            "                      }\n" +
            "                    ]\n" +
            "                  }\n" +
            "                }\n" +
            "              ],");

            if(prefix.equals("")){
                writer.println("              \"name\": \"neoforged_metals:" + name + "_ore\"");
            } else {
                writer.println("              \"name\": \"neoforged_metals:deepslate_" + name + "_ore\"");
            }

            writer.println("            },\n" +
            "            {\n" +
            "              \"type\": \"minecraft:item\",\n" +
            "              \"functions\": [\n" +
            "                {\n" +
            "                  \"enchantment\": \"minecraft:fortune\",\n" +
            "                  \"formula\": \"minecraft:ore_drops\",\n" +
            "                  \"function\": \"minecraft:apply_bonus\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"function\": \"minecraft:explosion_decay\"\n" +
            "                }\n" +
            "              ],\n" +
            "              \"name\": \"neoforged_metals:raw_" + name + "\"\n" +
            "            }\n" +
            "          ]\n" +
            "        }\n" +
            "      ],\n" +
            "      \"rolls\": 1.0\n" +
            "    }\n" +
            "  ],");

            if(prefix.equals("")){
                writer.println("  \"random_sequence\": \"neoforged_metals:blocks/" + name + "_ore\"");
            } else {
                writer.println("  \"random_sequence\": \"neoforged_metals:blocks/deepslate_" + name + "_ore\"");
            }

            writer.println("}");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
