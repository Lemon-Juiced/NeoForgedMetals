package lemon_juice.metal_resources;

import java.util.ArrayList;

public class MetalResourcesGenerator {
    public static ArrayList<MetalResource> generateMetalResources(){
        ArrayList<MetalResource> metalResources = new ArrayList<>();

        // Base Metals
        metalResources.add(new MetalResource("hepatizon", "base", false, true, true));
        metalResources.add(new MetalResource("manganese", "base", false, true, true));
        metalResources.add(new MetalResource("tin", "base", false, true, true));
        metalResources.add(new MetalResource("angmallen", "base", true, true, true));
        metalResources.add(new MetalResource("bronze", "base", true, true, true));
        metalResources.add(new MetalResource("damascus_steel", "base", true, true, true));
        metalResources.add(new MetalResource("steel", "base", true, true, true));

        // Precious Metals

        // Fantasy Metals

        // Utility Metals

        // Nether Metals

        // End Metals

        return metalResources;
    }
}
