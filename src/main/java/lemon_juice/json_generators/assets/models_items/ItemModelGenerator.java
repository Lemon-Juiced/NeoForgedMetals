package lemon_juice.json_generators.assets.models_items;

import lemon_juice.metal_data.resources.MetalResource;
import lemon_juice.metal_data.resources.MetalResourcesGenerator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

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

            if(!currentIndex.isAlloy()) { //If not alloy raw metal
                File rawMetalFile = new File(generateItemFileName(currentIndex.name(), "raw"));
                writeItemFile(rawMetalFile, currentIndex.name(), "raw");
            }

            if(currentIndex.hasTools()) {
                File swordFile = new File(generateItemFileName(currentIndex.name(), "sword"));
                File pickaxeFile = new File(generateItemFileName(currentIndex.name(), "pickaxe"));
                File axeFile = new File(generateItemFileName(currentIndex.name(), "axe"));
                File shovelFile = new File(generateItemFileName(currentIndex.name(), "shovel"));
                File hoeFile = new File(generateItemFileName(currentIndex.name(), "hoe"));
                writeHandheldItemFile(swordFile, currentIndex.name(), "sword");
                writeHandheldItemFile(pickaxeFile, currentIndex.name(), "pickaxe");
                writeHandheldItemFile(axeFile, currentIndex.name(), "axe");
                writeHandheldItemFile(shovelFile, currentIndex.name(), "shovel");
                writeHandheldItemFile(hoeFile, currentIndex.name(), "hoe");
            }

            if(currentIndex.hasArmor()) {
                File helmetFile = new File(generateItemFileName(currentIndex.name(), "helmet"));
                File chestplateFile = new File(generateItemFileName(currentIndex.name(), "chestplate"));
                File leggingsFile = new File(generateItemFileName(currentIndex.name(), "leggings"));
                File bootsFile = new File(generateItemFileName(currentIndex.name(), "boots"));
                writeArmorItemFile(helmetFile, currentIndex.name(), "helmet");
                writeArmorItemFile(chestplateFile, currentIndex.name(), "chestplate");
                writeArmorItemFile(leggingsFile, currentIndex.name(), "leggings");
                writeArmorItemFile(bootsFile, currentIndex.name(), "boots");

                File helmetAmethystTrimFile = new File(generateItemFileName(currentIndex.name(), "helmet_amethyst_trim"));
                File helmetCopperTrimFile = new File(generateItemFileName(currentIndex.name(), "helmet_copper_trim"));
                File helmetDiamondTrimFile = new File(generateItemFileName(currentIndex.name(), "helmet_diamond_trim"));
                File helmetEmeraldTrimFile = new File(generateItemFileName(currentIndex.name(), "helmet_emerald_trim"));
                File helmetGoldTrimFile = new File(generateItemFileName(currentIndex.name(), "helmet_gold_trim"));
                File helmetIronTrimFile = new File(generateItemFileName(currentIndex.name(), "helmet_iron_trim"));
                File helmetLapisTrimFile = new File(generateItemFileName(currentIndex.name(), "helmet_lapis_trim"));
                File helmetNetheriteTrimFile = new File(generateItemFileName(currentIndex.name(), "helmet_netherite_trim"));
                File helmetQuartzTrimFile = new File(generateItemFileName(currentIndex.name(), "helmet_quartz_trim"));
                File helmetRedstoneTrimFile = new File(generateItemFileName(currentIndex.name(), "helmet_redstone_trim"));
                writeTrimmedArmorItemFile(helmetAmethystTrimFile, currentIndex.name(), "helmet", "amethyst");
                writeTrimmedArmorItemFile(helmetCopperTrimFile, currentIndex.name(), "helmet", "copper");
                writeTrimmedArmorItemFile(helmetDiamondTrimFile, currentIndex.name(), "helmet", "diamond");
                writeTrimmedArmorItemFile(helmetEmeraldTrimFile, currentIndex.name(), "helmet", "emerald");
                writeTrimmedArmorItemFile(helmetGoldTrimFile, currentIndex.name(), "helmet", "gold");
                writeTrimmedArmorItemFile(helmetIronTrimFile, currentIndex.name(), "helmet", "iron");
                writeTrimmedArmorItemFile(helmetLapisTrimFile, currentIndex.name(), "helmet", "lapis");
                writeTrimmedArmorItemFile(helmetNetheriteTrimFile, currentIndex.name(), "helmet", "netherite");
                writeTrimmedArmorItemFile(helmetQuartzTrimFile, currentIndex.name(), "helmet", "quartz");
                writeTrimmedArmorItemFile(helmetRedstoneTrimFile, currentIndex.name(), "helmet", "redstone");

                File chestplateAmethystTrimFile = new File(generateItemFileName(currentIndex.name(), "chestplate_amethyst_trim"));
                File chestplateCopperTrimFile = new File(generateItemFileName(currentIndex.name(), "chestplate_copper_trim"));
                File chestplateDiamondTrimFile = new File(generateItemFileName(currentIndex.name(), "chestplate_diamond_trim"));
                File chestplateEmeraldTrimFile = new File(generateItemFileName(currentIndex.name(), "chestplate_emerald_trim"));
                File chestplateGoldTrimFile = new File(generateItemFileName(currentIndex.name(), "chestplate_gold_trim"));
                File chestplateIronTrimFile = new File(generateItemFileName(currentIndex.name(), "chestplate_iron_trim"));
                File chestplateLapisTrimFile = new File(generateItemFileName(currentIndex.name(), "chestplate_lapis_trim"));
                File chestplateNetheriteTrimFile = new File(generateItemFileName(currentIndex.name(), "chestplate_netherite_trim"));
                File chestplateQuartzTrimFile = new File(generateItemFileName(currentIndex.name(), "chestplate_quartz_trim"));
                File chestplateRedstoneTrimFile = new File(generateItemFileName(currentIndex.name(), "chestplate_redstone_trim"));
                writeTrimmedArmorItemFile(chestplateAmethystTrimFile, currentIndex.name(), "chestplate", "amethyst");
                writeTrimmedArmorItemFile(chestplateCopperTrimFile, currentIndex.name(), "chestplate", "copper");
                writeTrimmedArmorItemFile(chestplateDiamondTrimFile, currentIndex.name(), "chestplate", "diamond");
                writeTrimmedArmorItemFile(chestplateEmeraldTrimFile, currentIndex.name(), "chestplate", "emerald");
                writeTrimmedArmorItemFile(chestplateGoldTrimFile, currentIndex.name(), "chestplate", "gold");
                writeTrimmedArmorItemFile(chestplateIronTrimFile, currentIndex.name(), "chestplate", "iron");
                writeTrimmedArmorItemFile(chestplateLapisTrimFile, currentIndex.name(), "chestplate", "lapis");
                writeTrimmedArmorItemFile(chestplateNetheriteTrimFile, currentIndex.name(), "chestplate", "netherite");
                writeTrimmedArmorItemFile(chestplateQuartzTrimFile, currentIndex.name(), "chestplate", "quartz");
                writeTrimmedArmorItemFile(chestplateRedstoneTrimFile, currentIndex.name(), "chestplate", "redstone");

                File leggingsAmethystTrimFile = new File(generateItemFileName(currentIndex.name(), "leggings_amethyst_trim"));
                File leggingsCopperTrimFile = new File(generateItemFileName(currentIndex.name(), "leggings_copper_trim"));
                File leggingsDiamondTrimFile = new File(generateItemFileName(currentIndex.name(), "leggings_diamond_trim"));
                File leggingsEmeraldTrimFile = new File(generateItemFileName(currentIndex.name(), "leggings_emerald_trim"));
                File leggingsGoldTrimFile = new File(generateItemFileName(currentIndex.name(), "leggings_gold_trim"));
                File leggingsIronTrimFile = new File(generateItemFileName(currentIndex.name(), "leggings_iron_trim"));
                File leggingsLapisTrimFile = new File(generateItemFileName(currentIndex.name(), "leggings_lapis_trim"));
                File leggingsNetheriteTrimFile = new File(generateItemFileName(currentIndex.name(), "leggings_netherite_trim"));
                File leggingsQuartzTrimFile = new File(generateItemFileName(currentIndex.name(), "leggings_quartz_trim"));
                File leggingsRedstoneTrimFile = new File(generateItemFileName(currentIndex.name(), "leggings_redstone_trim"));
                writeTrimmedArmorItemFile(leggingsAmethystTrimFile, currentIndex.name(), "leggings", "amethyst");
                writeTrimmedArmorItemFile(leggingsCopperTrimFile, currentIndex.name(), "leggings", "copper");
                writeTrimmedArmorItemFile(leggingsDiamondTrimFile, currentIndex.name(), "leggings", "diamond");
                writeTrimmedArmorItemFile(leggingsEmeraldTrimFile, currentIndex.name(), "leggings", "emerald");
                writeTrimmedArmorItemFile(leggingsGoldTrimFile, currentIndex.name(), "leggings", "gold");
                writeTrimmedArmorItemFile(leggingsIronTrimFile, currentIndex.name(), "leggings", "iron");
                writeTrimmedArmorItemFile(leggingsLapisTrimFile, currentIndex.name(), "leggings", "lapis");
                writeTrimmedArmorItemFile(leggingsNetheriteTrimFile, currentIndex.name(), "leggings", "netherite");
                writeTrimmedArmorItemFile(leggingsQuartzTrimFile, currentIndex.name(), "leggings", "quartz");
                writeTrimmedArmorItemFile(leggingsRedstoneTrimFile, currentIndex.name(), "leggings", "redstone");

                File bootsAmethystTrimFile = new File(generateItemFileName(currentIndex.name(), "boots_amethyst_trim"));
                File bootsCopperTrimFile = new File(generateItemFileName(currentIndex.name(), "boots_copper_trim"));
                File bootsDiamondTrimFile = new File(generateItemFileName(currentIndex.name(), "boots_diamond_trim"));
                File bootsEmeraldTrimFile = new File(generateItemFileName(currentIndex.name(), "boots_emerald_trim"));
                File bootsGoldTrimFile = new File(generateItemFileName(currentIndex.name(), "boots_gold_trim"));
                File bootsIronTrimFile = new File(generateItemFileName(currentIndex.name(), "boots_iron_trim"));
                File bootsLapisTrimFile = new File(generateItemFileName(currentIndex.name(), "boots_lapis_trim"));
                File bootsNetheriteTrimFile = new File(generateItemFileName(currentIndex.name(), "boots_netherite_trim"));
                File bootsQuartzTrimFile = new File(generateItemFileName(currentIndex.name(), "boots_quartz_trim"));
                File bootsRedstoneTrimFile = new File(generateItemFileName(currentIndex.name(), "boots_redstone_trim"));
                writeTrimmedArmorItemFile(bootsAmethystTrimFile, currentIndex.name(), "boots", "amethyst");
                writeTrimmedArmorItemFile(bootsCopperTrimFile, currentIndex.name(), "boots", "copper");
                writeTrimmedArmorItemFile(bootsDiamondTrimFile, currentIndex.name(), "boots", "diamond");
                writeTrimmedArmorItemFile(bootsEmeraldTrimFile, currentIndex.name(), "boots", "emerald");
                writeTrimmedArmorItemFile(bootsGoldTrimFile, currentIndex.name(), "boots", "gold");
                writeTrimmedArmorItemFile(bootsIronTrimFile, currentIndex.name(), "boots", "iron");
                writeTrimmedArmorItemFile(bootsLapisTrimFile, currentIndex.name(), "boots", "lapis");
                writeTrimmedArmorItemFile(bootsNetheriteTrimFile, currentIndex.name(), "boots", "netherite");
                writeTrimmedArmorItemFile(bootsQuartzTrimFile, currentIndex.name(), "boots", "quartz");
                writeTrimmedArmorItemFile(bootsRedstoneTrimFile, currentIndex.name(), "boots", "redstone");
            }

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

        // Register Vanilla Parity Items As Well
        ArrayList<String> parityResources = new ArrayList<>(Arrays.asList("copper", "gold", "iron", "netherite"));
        for (int i = 0; i < parityResources.size(); i++) {
            File dustFile = new File(generateItemFileName(parityResources.get(i), "dust"));
            writeItemFile(dustFile, parityResources.get(i), "dust");

            if(parityResources.get(i).equals("copper") || parityResources.get(i).equals("netherite")){
                File nuggetFile = new File(generateItemFileName(parityResources.get(i), "nugget"));
                writeItemFile(nuggetFile, parityResources.get(i), "nugget");
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
        if(type.equals("raw"))return "src/main/resources/assets/neoforged_metals/models/item/" + type + "_" + name + ".json";
        else return "src/main/resources/assets/neoforged_metals/models/item/" + name + "_" + type + ".json";
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

            if(type.equals("raw")){
                writer.println("        \"layer0\": \"neoforged_metals:item/" + type + "_" + name + "\"");
            } else {
                writer.println("        \"layer0\": \"neoforged_metals:item/" + name + "_" + type + "\"");
            }

            writer.println("    }");
            writer.println("}");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Generates a handheld item JSON file
     *
     * @param file The file itself
     * @param name The metal type for the file
     * @param type The item type for the file
     */
    public static void writeHandheldItemFile(File file, String name, String type){
        try{
            if(!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{");
            writer.println("    \"parent\": \"item/handheld\",");
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
     * Generates a JSON file for a piece of armor
     *
     * @param file The file itself
     * @param name The metal type for the file
     * @param type The armor type for the file
     */
    public static void writeArmorItemFile(File file, String name, String type){
        try{
            if(!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "  \"parent\": \"minecraft:item/generated\",\n" +
                    "  \"overrides\": [\n" +
                    "    {\n" +
                    "      \"model\": \"neoforged_metals:item/" + name + "_" + type + "_quartz_trim\",\n" +
                    "      \"predicate\": {\n" +
                    "        \"trim_type\": 0.1\n" +
                    "      }\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"model\": \"neoforged_metals:item/" + name + "_" + type + "_iron_trim\",\n" +
                    "      \"predicate\": {\n" +
                    "        \"trim_type\": 0.2\n" +
                    "      }\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"model\": \"neoforged_metals:item/" + name + "_" + type + "_netherite_trim\",\n" +
                    "      \"predicate\": {\n" +
                    "        \"trim_type\": 0.3\n" +
                    "      }\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"model\": \"neoforged_metals:item/" + name + "_" + type + "_redstone_trim\",\n" +
                    "      \"predicate\": {\n" +
                    "        \"trim_type\": 0.4\n" +
                    "      }\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"model\": \"neoforged_metals:item/" + name + "_" + type + "_copper_trim\",\n" +
                    "      \"predicate\": {\n" +
                    "        \"trim_type\": 0.5\n" +
                    "      }\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"model\": \"neoforged_metals:item/" + name + "_" + type + "_gold_trim\",\n" +
                    "      \"predicate\": {\n" +
                    "        \"trim_type\": 0.6\n" +
                    "      }\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"model\": \"neoforged_metals:item/" + name + "_" + type + "_emerald_trim\",\n" +
                    "      \"predicate\": {\n" +
                    "        \"trim_type\": 0.7\n" +
                    "      }\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"model\": \"neoforged_metals:item/" + name + "_" + type + "_diamond_trim\",\n" +
                    "      \"predicate\": {\n" +
                    "        \"trim_type\": 0.8\n" +
                    "      }\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"model\": \"neoforged_metals:item/" + name + "_" + type + "_lapis_trim\",\n" +
                    "      \"predicate\": {\n" +
                    "        \"trim_type\": 0.9\n" +
                    "      }\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"model\": \"neoforged_metals:item/" + name + "_" + type + "_amethyst_trim\",\n" +
                    "      \"predicate\": {\n" +
                    "        \"trim_type\": 1.0\n" +
                    "      }\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"textures\": {\n" +
                    "    \"layer0\": \"neoforged_metals:item/" + name + "_" + type + "\"\n" +
                    "  }\n" +
                    "}");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Generates a JSON file for a piece of armor with a trim
     *
     * @param file The file itself
     * @param name The metal type for the file
     * @param type The armor type for the file
     */
    public static void writeTrimmedArmorItemFile(File file, String name, String type, String trim){
        try{
            if(!file.exists()) file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            writer.println("{\n" +
                    "  \"parent\": \"minecraft:item/generated\",\n" +
                    "  \"textures\": {\n" +
                    "    \"layer0\": \"neoforged_metals:item/" + name + "_" + type + "\",\n" +
                    "    \"layer1\": \"minecraft:trims/items/" + type + "_trim_" + trim + "\"\n" +
                    "  }\n" +
                    "}");

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
