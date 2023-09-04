package lemon_juice.neoforged_metals.item;

import lemon_juice.metal_resources.MetalResource;
import lemon_juice.metal_resources.MetalResourcesGenerator;
import lemon_juice.neoforged_metals.NeoForgedMetals;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;

import static lemon_juice.neoforged_metals.registry.ItemRegistry.registerMetalItemGroup;

public class NFMItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NeoForgedMetals.MOD_ID);

    public static void register(IEventBus eventBus){
        ArrayList<MetalResource> metalResources = MetalResourcesGenerator.generateMetalResources();
        for (int i = 0; i < metalResources.size(); i++) {
            MetalResource currentIndex = metalResources.get(i);
            registerMetalItemGroup(currentIndex.name(), currentIndex.oreGroup(), currentIndex.isAlloy(), currentIndex.hasTools(), currentIndex.hasArmor());
        }

        ITEMS.register(eventBus);
    }
}
