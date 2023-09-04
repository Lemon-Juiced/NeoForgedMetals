package lemon_juice.neoforged_metals.creativetab;

import lemon_juice.neoforged_metals.NeoForgedMetals;
import lemon_juice.neoforged_metals.block.NFMBlocks;
import lemon_juice.neoforged_metals.block.custom.MetalBlock;
import lemon_juice.neoforged_metals.block.custom.OreBlock;
import lemon_juice.neoforged_metals.block.custom.RawMetalBlock;
import lemon_juice.neoforged_metals.item.NFMItems;
import lemon_juice.neoforged_metals.item.custom.item.DustItem;
import lemon_juice.neoforged_metals.item.custom.item.IngotItem;
import lemon_juice.neoforged_metals.item.custom.item.NuggetItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static lemon_juice.neoforged_metals.creativetab.util.NFMCreativeTabUtils.getFirstItem;

public class NFMCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NeoForgedMetals.MOD_ID);

    public static String metalTabType = "metal";
    public static String toolsTabType = "tools";

    public static final RegistryObject<CreativeModeTab> NEOFORGED_METALS_METALS_TAB = CREATIVE_MODE_TABS.register("neoforged_metals_metals", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.neoforged_metals.neoforged_metals_metals_tab"))
            .icon(() -> new ItemStack(getFirstItem(metalTabType)))
            .build());

    public static final RegistryObject<CreativeModeTab> NEOFORGED_METALS_TOOLS_TAB = CREATIVE_MODE_TABS.register("neoforged_metals_tools", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.neoforged_metals.neoforged_metals_tools_tab"))
            .icon(() -> new ItemStack(getFirstItem(toolsTabType)))
            .build());

    public static void registerTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == NEOFORGED_METALS_METALS_TAB.get()) {
            for (RegistryObject<Item> item : NFMItems.ITEMS.getEntries())
                if(item.get() instanceof IngotItem || item.get() instanceof NuggetItem || item.get() instanceof DustItem)
                    event.accept(item.get());

            for (RegistryObject<Block> blockItem : NFMBlocks.BLOCKS.getEntries())
                if (blockItem.get() instanceof OreBlock || blockItem.get() instanceof MetalBlock || blockItem.get() instanceof RawMetalBlock)
                    event.accept(blockItem.get());
        }

        if (event.getTab() == NEOFORGED_METALS_TOOLS_TAB.get()) {
            /*
            for (RegistryObject<Item> item : NFMItems.ITEMS.getEntries())
                if(item.get() instanceof IngotItem || item.get() instanceof NuggetItem || item.get() instanceof DustItem)
                    event.accept(item.get());

            for (RegistryObject<Block> blockItem : NFMBlocks.BLOCKS.getEntries())
                if (blockItem.get() instanceof OreBlock || blockItem.get() instanceof MetalBlock || blockItem.get() instanceof RawMetalBlock)
                    event.accept(blockItem.get());
            */
        }
    }

    /******************************** Registry ********************************/
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
