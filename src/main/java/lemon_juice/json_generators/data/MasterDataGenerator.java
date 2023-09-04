package lemon_juice.json_generators.data;

import lemon_juice.json_generators.data.forge.MasterForgeDataGenerator;
import lemon_juice.json_generators.data.minecraft.MasterMinecraftDataGenerator;
import lemon_juice.json_generators.data.neoforged_metals.MasterNeoForgedMetalsDataGenerator;

public class MasterDataGenerator {
    public static void masterDataGenerator(){
        MasterForgeDataGenerator.masterForgeDataGenerator();
        MasterMinecraftDataGenerator.masterMinecraftDataGenerator();
        MasterNeoForgedMetalsDataGenerator.masterNeoForgedMetalsDataGenerator();
    }
}
