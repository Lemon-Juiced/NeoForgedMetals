package lemon_juice.metal_data.resources;

import java.util.ArrayList;

public class MetalResourcesGenerator {
    public static ArrayList<MetalResource> generateMetalResources(){
        ArrayList<MetalResource> metalResources = new ArrayList<>();

        /*
        Tier Reference:
        0. Wood
        1. Stone (Copper)
        2. Iron (Gold)
        3. Diamond
        4. Netherite
        5+ Modded Materials
        */

        // Base Metals
        metalResources.add(new MetalResource("manganese", "base", 2, false, false, false));
        metalResources.add(new MetalResource("tin", "base", 1, false, false, false));
        metalResources.add(new MetalResource("angmallen", "base", 2,true, true, true));
        metalResources.add(new MetalResource("bronze", "base", 1, true, true, true));
        metalResources.add(new MetalResource("damascus_steel", "base", 2, true, true, true));
        metalResources.add(new MetalResource("hepatizon", "base", 2, true, true, true));
        metalResources.add(new MetalResource("steel", "base", 2, true, true, true));

        // Precious Metals
        metalResources.add(new MetalResource("platinum", "precious", 3, false, true, true));
        metalResources.add(new MetalResource("silver", "precious", 2, false, true, true));
        metalResources.add(new MetalResource("zinc", "precious", 1, false, false, false));
        metalResources.add(new MetalResource("brass", "precious", 1, true, true, true));
        metalResources.add(new MetalResource("electrum", "precious", 2, true, true, true));

        // Fantasy Metals

        // Utility Metals

        // Nether Metals

        // End Metals

        return metalResources;
    }
}
