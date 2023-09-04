package lemon_juice.json_generators.data.minecraft;

import lemon_juice.json_generators.data.minecraft.tags.block.*;
import lemon_juice.json_generators.data.minecraft.tags.item.BeaconPaymentItemsGenerator;

public class MasterMinecraftDataGenerator {
    public static void masterMinecraftDataGenerator(){
        BeaconBaseBlocksGenerator.beaconBaseBlocksGenerator();
        MineableGenerator.mineableGenerator();
        NeedsDiamondToolGenerator.needsDiamondToolGenerator();
        NeedsIronToolGenerator.needsIronToolGenerator();
        NeedsStoneToolGenerator.needsStoneToolGenerator();

        BeaconPaymentItemsGenerator.beaconPaymentItemsGenerator();
    }
}
