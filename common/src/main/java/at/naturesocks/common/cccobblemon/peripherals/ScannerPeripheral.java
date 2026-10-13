package at.naturesocks.common.cccobblemon.peripherals;

import at.naturesocks.common.cccobblemon.block.entities.ScannerBlockEntity;
import dan200.computercraft.api.lua.LuaFunction;
import dan200.computercraft.api.peripheral.IPeripheral;
import org.jspecify.annotations.Nullable;

public class ScannerPeripheral implements IPeripheral {

    private final ScannerBlockEntity scannerBlockEntity;

    public ScannerPeripheral(ScannerBlockEntity scannerBlockEntity) {
        this.scannerBlockEntity = scannerBlockEntity;
    }

    @Override
    public String getType() {
        return "scanner";
    }

    @Override
    public boolean equals(@Nullable IPeripheral other) {
        return other instanceof ScannerPeripheral o && scannerBlockEntity == o.scannerBlockEntity;
    }

    @LuaFunction
    public final int test()
    {
        return 10;
    }
}
