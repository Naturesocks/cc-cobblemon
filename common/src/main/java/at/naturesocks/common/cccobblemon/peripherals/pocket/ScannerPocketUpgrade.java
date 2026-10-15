package at.naturesocks.common.cccobblemon.peripherals.pocket;

import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.pocket.AbstractPocketUpgrade;
import dan200.computercraft.api.pocket.IPocketAccess;
import dan200.computercraft.api.pocket.IPocketUpgrade;
import dan200.computercraft.api.upgrades.UpgradeType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.Nullable;

public class ScannerPocketUpgrade extends AbstractPocketUpgrade {

    private IPocketAccess access;

    protected ScannerPocketUpgrade(ItemStack stack) {
        super(Component.literal("scanner"), stack);
    }

    @Override
    public UpgradeType<? extends IPocketUpgrade> getType() {
        return CommonPocketUpgrade.SCANNER_POCKET_UPGRADE;
    }

    @Override
    public @Nullable IPeripheral createPeripheral(IPocketAccess access) {
        return new ScannerPocketPeripheral(access);
    }
}
