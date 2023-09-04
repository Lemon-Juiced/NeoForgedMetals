package lemon_juice.json_generators.data.forge;

import lemon_juice.json_generators.data.forge.tags.blocks.NeedsNetheriteToolGenerator;
import lemon_juice.json_generators.data.forge.tags.items.*;

public class MasterForgeDataGenerator {
    public static void masterForgeDataGenerator(){
        NeedsNetheriteToolGenerator.needsNetheriteToolGenerator();
        DustsGenerator.dustsGenerator();
        IngotsGenerator.ingotsGenerator();
        NuggetsGenerator.nuggetsGenerator();
        OresGenerator.oresGenerator();
        RawMaterialsGenerator.rawMaterialsGenerator();
        StorageBlocksGenerator.storageBlocksGenerator();
    }
}
