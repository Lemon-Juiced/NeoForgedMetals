package lemon_juice.neoforged_metals.item.custom.armor;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class NFMArmorItem extends ArmorItem {
    private final String tooltipInfo;

    public NFMArmorItem(ArmorMaterial armorMaterial, Type type, Properties properties, String tooltipInfo) {
        super(armorMaterial, type, properties);
        this.tooltipInfo = tooltipInfo;
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

        super.appendHoverText(itemStack, level, components, tooltipFlag);
    }
}
