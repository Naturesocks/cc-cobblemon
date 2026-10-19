package at.naturesocks.common.cccobblemonmod.peripherals.turtle;

import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.turtle.*;
import dan200.computercraft.api.upgrades.UpgradeType;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.Nullable;

public class ScannerTurtleUpgrade extends AbstractTurtleUpgrade {

    protected ScannerTurtleUpgrade(ItemStack stack) {
        super(TurtleUpgradeType.PERIPHERAL, "cccobblemonmod.turtle.scanner", stack);
    }

    @Override
    public UpgradeType<? extends ITurtleUpgrade> getType() {
        return CommonTurtleUpgrade.SCANNER_TURTLE_UPGRADE;
    }

    @Override
    public @Nullable IPeripheral createPeripheral(ITurtleAccess turtle, TurtleSide side) {
        return new ScannerTurtlePeripheral(turtle);
    }
}
