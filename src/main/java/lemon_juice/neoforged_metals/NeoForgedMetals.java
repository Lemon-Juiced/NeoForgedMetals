package lemon_juice.neoforged_metals;

import lemon_juice.neoforged_metals.block.NFMBlocks;
import lemon_juice.neoforged_metals.creativetab.NFMCreativeTabs;
import lemon_juice.neoforged_metals.item.NFMItems;
import lemon_juice.neoforged_metals.tag.NFMTags;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(NeoForgedMetals.MOD_ID)
public class NeoForgedMetals {
    public static final String MOD_ID = "neoforged_metals";

    public NeoForgedMetals() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register Items
        NFMItems.register(modEventBus);
        NFMBlocks.register(modEventBus);

        // Register Creative Tab
        NFMCreativeTabs.register(modEventBus);
        modEventBus.addListener(NFMCreativeTabs::registerTabs);

        // Register Tags
        NFMTags.init();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {}

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {}

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {}
    }
}
