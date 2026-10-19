package at.naturesocks.common.cccobblemonmod.peripherals.turtle;

import at.naturesocks.common.cccobblemonmod.peripherals.ScannerBase;
import dan200.computercraft.api.lua.LuaFunction;
import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.turtle.ITurtleAccess;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public class ScannerTurtlePeripheral implements ScannerBase, IPeripheral {

    private final ITurtleAccess access;
    private int range = 1;

    public ScannerTurtlePeripheral(ITurtleAccess access) {
        this.access = access;
    }

    // Peripheral
    @Override
    public BlockPos getBlockPos() {
        return this.access.getPosition();
    }

    @Override
    public Level getLevel() {
        return this.access.getLevel();
    }

    @Override
    public @NonNull String getType() {
        return "scanner";
    }

    @Override
    public boolean equals(@Nullable IPeripheral other) {
        return other instanceof ScannerTurtlePeripheral o && access == o.access;
    }

    // Lua Functions
    @Override
    @LuaFunction
    public final void setScannerRange(int range) {
        this.range = Math.clamp(range, 1, 10);
    }

    @Override
    @LuaFunction
    public final int getScannerRange() {
        return this.range;
    }
}
