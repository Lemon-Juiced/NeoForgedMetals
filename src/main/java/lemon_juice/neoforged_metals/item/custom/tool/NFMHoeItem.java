package lemon_juice.neoforged_metals.item.custom.tool;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class NFMHoeItem extends HoeItem {
    private final int level;
    private final String tooltipInfo;

    public NFMHoeItem(Tier tier, int speed, float damage, Properties properties, String tooltipInfo, int level) {
        super(tier, speed, damage, properties);
        this.tooltipInfo = tooltipInfo;
        this.level = level;
    }

    public String getTooltipInfo() {
        return tooltipInfo;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        if(tooltipInfo.equals("base")) components.add(Component.translatable("tooltip.neoforged_metals.base_metals"));
        if(tooltipInfo.equals("precious")) components.add(Component.translatable("tooltip.neoforged_metals.precious_metals"));
        if(tooltipInfo.equals("fantasy")) components.add(Component.translatable("tooltip.neoforged_metals.fantasy_metals"));
        if(tooltipInfo.equals("utility")) components.add(Component.translatable("tooltip.neoforged_metals.utility_metals"));
        if(tooltipInfo.equals("nether")) components.add(Component.translatable("tooltip.neoforged_metals.nether_metals"));
        if(tooltipInfo.equals("end")) components.add(Component.translatable("tooltip.neoforged_metals.end_metals"));

        components.add(Component.translatable("tooltip.neoforged_metals.level").append(String.valueOf(this.level)));

        super.appendHoverText(itemStack, level, components, tooltipFlag);
    }
}
