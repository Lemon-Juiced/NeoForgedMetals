package lemon_juice.json_generators;

import lemon_juice.json_generators.assets.MasterAssetGenerator;
import lemon_juice.json_generators.data.MasterDataGenerator;

public class MasterJSONGenerator {
    public static void main(String[] args) {
        MasterAssetGenerator.masterAssetGenerator();
        MasterDataGenerator.masterDataGenerator();
    }
}
