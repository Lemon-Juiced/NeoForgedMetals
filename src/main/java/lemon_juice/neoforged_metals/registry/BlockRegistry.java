package lemon_juice.neoforged_metals.registry;

import lemon_juice.neoforged_metals.block.NFMBlocks;
import lemon_juice.neoforged_metals.block.custom.DeepslateOreBlock;
import lemon_juice.neoforged_metals.block.custom.MetalBlock;
import lemon_juice.neoforged_metals.block.custom.OreBlock;
import lemon_juice.neoforged_metals.block.custom.RawMetalBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BlockRegistry {

    /**
     * Registers a group of Items associated for a metal
     *
     * @param name The name of the metal
     * @param oreGroup The oreGroup of the metal (and by derivative its dimension)
     *                 Overworld: "base", "precious", "fantasy", "utility"
     *                 Nether: "nether"
     *                 End: "end"
     * @param isAlloy true if the resource is an alloy, false otherwise
     */
    public static void registerMetalBlockGroup(String name, String oreGroup, boolean isAlloy){
        NFMBlocks.registerBlock(name + "_block", () -> new MetalBlock((BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL))), oreGroup);


        if(isAlloy) registerAlloyMetalBlockGroup(name, oreGroup);
        else {
            if(oreGroup.equals("base") || oreGroup.equals("precious") || oreGroup.equals("fantasy") || oreGroup.equals("utility")) registerOverworldMetalBlockGroup(name, oreGroup);
            else registerDimensionalMetalBlockGroup(name, oreGroup);
        }
    }

    public static void registerOverworldMetalBlockGroup(String name, String oreGroup){
        NFMBlocks.registerBlock("raw_" + name + "_block", () -> new RawMetalBlock((BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL))), oreGroup);
        NFMBlocks.registerBlock(name + "_ore", () -> new OreBlock((BlockBehaviour.Properties.copy(Blocks.IRON_ORE).requiresCorrectToolForDrops().strength(3.0F, 3.0F).sound(SoundType.METAL))), oreGroup);
        NFMBlocks.registerBlock("deepslate_" + name + "_ore", () -> new DeepslateOreBlock((BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.METAL))), oreGroup);

    }

    public static void registerDimensionalMetalBlockGroup(String name, String oreGroup){
        NFMBlocks.registerBlock("raw_" + name + "_block", () -> new RawMetalBlock((BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL))), oreGroup);
        NFMBlocks.registerBlock(name + "_ore", () -> new OreBlock((BlockBehaviour.Properties.copy(Blocks.IRON_ORE).requiresCorrectToolForDrops().strength(3.0F, 3.0F).sound(SoundType.METAL))), oreGroup);
    }

    public static void registerAlloyMetalBlockGroup(String name, String oreGroup){/* Empty for now (might be used later) */}
}
