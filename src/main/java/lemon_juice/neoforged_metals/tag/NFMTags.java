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

        // Precious Metals
        public static final TagKey<Item> INGOTS_PLATINUM = forgeTag("ingots/platinum");
        public static final TagKey<Item> INGOTS_SILVER = forgeTag("ingots/silver");
        public static final TagKey<Item> INGOTS_ZINC = forgeTag("ingots/zinc");
        public static final TagKey<Item> INGOTS_BRASS = forgeTag("ingots/brass");
        public static final TagKey<Item> INGOTS_ELECTRUM = forgeTag("ingots/electrum");

        // Fantasy Metals
        public static final TagKey<Item> INGOTS_ADAMANTINE = forgeTag("ingots/adamantine");
        public static final TagKey<Item> INGOTS_AREDRITE = forgeTag("ingots/aredrite");
        public static final TagKey<Item> INGOTS_ASTRAL_SILVER = forgeTag("ingots/astral_silver");
        public static final TagKey<Item> INGOTS_ATLARUS = forgeTag("ingots/atlarus");
        public static final TagKey<Item> INGOTS_CARMOT = forgeTag("ingots/carmot");
        public static final TagKey<Item> INGOTS_DEEP_IRON = forgeTag("ingots/deep_iron");
        public static final TagKey<Item> INGOTS_INFUSCOLIUM = forgeTag("ingots/infuscolium");
        public static final TagKey<Item> INGOTS_MITHRIL = forgeTag("ingots/mithril");
        public static final TagKey<Item> INGOTS_ORICHALCUM = forgeTag("ingots/orichalcum");
        public static final TagKey<Item> INGOTS_OURECLASE = forgeTag("ingots/oureclase");
        public static final TagKey<Item> INGOTS_PROMETHEUM = forgeTag("ingots/prometheum");
        public static final TagKey<Item> INGOTS_RUBRACIUM = forgeTag("ingots/rubracium");

        public static final TagKey<Item> INGOTS_BLACK_STEEL = forgeTag("ingots/black_steel");
        public static final TagKey<Item> INGOTS_CENEGIL = forgeTag("ingots/cenegil");
        public static final TagKey<Item> INGOTS_HADEROTH = forgeTag("ingots/haderoth");
        public static final TagKey<Item> INGOTS_QUICKSILVER = forgeTag("ingots/quicksilver");
        public static final TagKey<Item> INGOTS_TARTARITE = forgeTag("ingots/tartarite");

        // Utility Metals
        public static final TagKey<Item> GEMS_BITUMEN = forgeTag("gems/bitumen");
        public static final TagKey<Item> GEMS_MAGNESIUM = forgeTag("gems/magnesium");
        public static final TagKey<Item> GEMS_PHOSPHORITE = forgeTag("gems/phosphorite");
        public static final TagKey<Item> GEMS_POTASH = forgeTag("gems/potash");
        public static final TagKey<Item> GEMS_SALTPETER = forgeTag("gems/saltpeter");
        public static final TagKey<Item> GEMS_SULFUR = forgeTag("gems/sulfur");

        // Nether Metals
        public static final TagKey<Item> INGOTS_ADLUORITE = forgeTag("ingots/adluorite");
        public static final TagKey<Item> INGOTS_CERUCLASE = forgeTag("ingots/ceruclase");
        public static final TagKey<Item> INGOTS_IGNATIUS = forgeTag("ingots/ignatius");
        public static final TagKey<Item> INGOTS_KALENDRITE = forgeTag("ingots/kalendrite");
        public static final TagKey<Item> INGOTS_LEMURITE = forgeTag("ingots/lemurite");
        public static final TagKey<Item> INGOTS_MIDASIUM = forgeTag("ingots/midasium");
        public static final TagKey<Item> INGOTS_SANGUINITE = forgeTag("ingots/sanguinite");
        public static final TagKey<Item> INGOTS_SHADOW_IRON = forgeTag("ingots/shadow_iron");
        public static final TagKey<Item> INGOTS_VULCANITE = forgeTag("ingots/vulcanite");
        public static final TagKey<Item> INGOTS_VYROXERES = forgeTag("ingots/vyroxeres");

        public static final TagKey<Item> INGOTS_AMORDRINE = forgeTag("ingots/amordrine");
        public static final TagKey<Item> INGOTS_INOLASHITE = forgeTag("ingots/inolashite");
        public static final TagKey<Item> INGOTS_SHADOW_STEEL = forgeTag("ingots/shadow_steel");

        // End Metals
        public static final TagKey<Item> INGOTS_EXIMITE = forgeTag("ingots/eximite");
        public static final TagKey<Item> INGOTS_MEUTOITE = forgeTag("ingots/meutoite");

        public static final TagKey<Item> INGOTS_DESICHALKOS = forgeTag("ingots/desichalkos");

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
