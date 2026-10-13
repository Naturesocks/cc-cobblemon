package at.naturesocks.common.cccobblemon.peripherals;

import dan200.computercraft.api.ComputerCraftAPI;

public class ModPeripherals {

    public static void load()
    {
        ComputerCraftAPI.registerGenericSource(new GenericScannerPeripheral());
    }
}
