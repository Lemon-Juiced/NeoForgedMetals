package lemon_juice.neoforged_metals.registry;

import lemon_juice.metal_data.statistics.MetalToolStatistic;
import lemon_juice.neoforged_metals.NeoForgedMetals;
import lemon_juice.neoforged_metals.tag.NFMTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class TierRegistry {
    /**
     * Generates a metal tier given its <code>MetalToolStatistic</code>
     *
     * @param mts The <code>MetalToolStatistic</code>
     * @return The metal tier
     */
    public static Tier generateMetalTier(MetalToolStatistic mts){
        Tier generatedTier =
                TierSortingRegistry.registerTier(new ForgeTier(mts.level(), mts.uses(), mts.speed(), mts.damage(), mts.enchantmentValue(),
                        getAssociatedLevelBlockTags(mts.level()), () -> mts.repairIngredient()),
                        new ResourceLocation(NeoForgedMetals.MOD_ID, mts.name()),
                        List.of(getAssociatedTier(mts.level() - 1)),
                        List.of(getAssociatedTier(mts.level() + 1)));

        return generatedTier;
    }

    public static TagKey<Block> getAssociatedLevelBlockTags(int level){
        if(level == 1) return BlockTags.NEEDS_STONE_TOOL;
        else if(level == 2) return BlockTags.NEEDS_IRON_TOOL;
        else if(level == 3) return BlockTags.NEEDS_DIAMOND_TOOL;
        else if(level == 4) return NFMTags.Blocks.NEEDS_NETHERITE_TOOL;
        else return BlockTags.SWORD_EFFICIENT; //Closest analog to wood/gold
    }

    public static Tier getAssociatedTier(int level){
        if(level == 1) return Tiers.STONE;
        else if(level == 2) return Tiers.IRON;
        else if(level == 3) return Tiers.DIAMOND;
        else if(level == 4) return Tiers.NETHERITE;
        else return Tiers.WOOD;
    }
}
