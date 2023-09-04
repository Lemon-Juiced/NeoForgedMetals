package lemon_juice.neoforged_metals.item.custom.blockitem;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AbstractTooltippedBlockItem extends BlockItem {
    private final String tooltipInfo;

    public AbstractTooltippedBlockItem(Block block, Properties properties, String tooltipInfo) {
        super(block, properties);
        this.tooltipInfo = tooltipInfo;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        if(tooltipInfo.equals("base")) components.add(Component.translatable("tooltip.neoforged_metals.base_metals"));
        if(tooltipInfo.equals("precious")) components.add(Component.translatable("tooltip.neoforged_metals.precious_metals"));
        if(tooltipInfo.equals("fantasy")) components.add(Component.translatable("tooltip.neoforged_metals.fantasy_metals"));
        if(tooltipInfo.equals("utility")) components.add(Component.translatable("tooltip.neoforged_metals.utility_metals"));
        if(tooltipInfo.equals("nether")) components.add(Component.translatable("tooltip.neoforged_metals.nether_metals"));
        if(tooltipInfo.equals("end")) components.add(Component.translatable("tooltip.neoforged_metals.end_metals"));

        super.appendHoverText(itemStack, level, components, tooltipFlag);
    }
}
