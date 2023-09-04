package lemon_juice.json_generators.assets;

import lemon_juice.json_generators.assets.blockstates.BlockstateGenerator;
import lemon_juice.json_generators.assets.models_blocks.BlockModelGenerator;
import lemon_juice.json_generators.assets.models_items.ItemModelGenerator;

public class MasterAssetGenerator {
    public static void main(String[] args) {
        masterAssetGenerator();
    }

    public static void masterAssetGenerator(){
        BlockstateGenerator.blockStateGenerator();
        BlockModelGenerator.blockModelGenerator();
        ItemModelGenerator.itemModelGenerator();
    }
}
