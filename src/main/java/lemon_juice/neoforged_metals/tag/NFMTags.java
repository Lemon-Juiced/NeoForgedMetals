package lemon_juice.neoforged_metals.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class NFMTags {
    public static void init() {
        Items.init();
        Blocks.init();
    }

    private NFMTags() {}

    public static class Items {
        private static void init() {}
        private Items() {}
        //Base Metals
        public static final TagKey<Item> INGOTS_MANGANESE = forgeTag("ingots/manganese");
        public static final TagKey<Item> INGOTS_TIN = forgeTag("ingots/tin");
        public static final TagKey<Item> INGOTS_ANGMALLEN = forgeTag("ingots/angmallen");
        public static final TagKey<Item> INGOTS_BRONZE = forgeTag("ingots/bronze");
        public static final TagKey<Item> INGOTS_DAMASCUS_STEEL = forgeTag("ingots/damascus_steel");
        public static final TagKey<Item> INGOTS_HEPATIZON = forgeTag("ingots/hepatizon");
        public static final TagKey<Item> INGOTS_STEEL = forgeTag("ingots/steel");

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Blocks {
        private static void init() {}
        private Blocks() {}
        //Base Metals
        public static final TagKey<Block> NEEDS_NETHERITE_TOOL = forgeTag("needs_netherite_tool");

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }
}
