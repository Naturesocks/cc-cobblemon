package at.naturesocks.common.cccobblemon.peripherals;

import at.naturesocks.common.cccobblemon.CommonCCCobblemonMod;
import at.naturesocks.common.cccobblemon.block.entities.CommonModBlockEntities;
import at.naturesocks.common.cccobblemon.block.entities.ScannerBlockEntity;
import dan200.computercraft.api.lua.LuaFunction;
import dan200.computercraft.api.peripheral.GenericPeripheral;
import dan200.computercraft.api.peripheral.IPeripheral;
import net.minecraft.resources.ResourceLocation;
import org.jspecify.annotations.Nullable;

public class GenericScannerPeripheral implements GenericPeripheral {

    @Override
    public String id() {
        return ResourceLocation.fromNamespaceAndPath(CommonCCCobblemonMod.MOD_ID, "scanner").toString();
    }

    @LuaFunction
    public final int getTest(ScannerBlockEntity entity)
    {
        return 10;
    }
}
