package lemon_juice.neoforged_metals.block;

import lemon_juice.neoforged_metals.NeoForgedMetals;
import lemon_juice.neoforged_metals.item.NFMItems;
import lemon_juice.neoforged_metals.item.custom.blockitem.AbstractTooltippedBlockItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class NFMBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NeoForgedMetals.MOD_ID);

    /******************************** Registry ********************************/
    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, String oreGroup) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, oreGroup);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, String oreGroup) {
        return NFMItems.ITEMS.register(name, () -> new AbstractTooltippedBlockItem(block.get(), new Item.Properties(), oreGroup));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
