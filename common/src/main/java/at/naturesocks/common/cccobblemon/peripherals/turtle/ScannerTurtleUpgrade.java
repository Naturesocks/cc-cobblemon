package at.naturesocks.common.cccobblemon.peripherals.turtle;

import dan200.computercraft.api.turtle.AbstractTurtleUpgrade;
import dan200.computercraft.api.turtle.ITurtleUpgrade;
import dan200.computercraft.api.turtle.TurtleUpgradeType;
import dan200.computercraft.api.upgrades.UpgradeType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

public class ScannerTurtleUpgrade extends AbstractTurtleUpgrade {
    protected ScannerTurtleUpgrade(ItemStack stack) {
        super(TurtleUpgradeType.PERIPHERAL, "scanner", stack);
    }

    @Override
    public UpgradeType<? extends ITurtleUpgrade> getType() {
        return CommonTurtleUpgrade.SCANNER_TURTLE_UPGRADE;
    }
}
