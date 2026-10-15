package at.naturesocks.common.cccobblemon.peripherals.pocket;

import at.naturesocks.common.cccobblemon.peripherals.ScannerBase;
import dan200.computercraft.api.lua.LuaFunction;
import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.pocket.IPocketAccess;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

public class ScannerPocketPeripheral implements ScannerBase, IPeripheral {

    private int range = 1;

    private IPocketAccess access;

    public ScannerPocketPeripheral(IPocketAccess access) {
        this.access = access;
    }

    @Override
    @LuaFunction
    public void setScannerRange(int range) {
        this.range = Math.clamp(range, 1, 10);
    }

    @Override
    @LuaFunction
    public int getScannerRange() {
        return this.range;
    }

    @Override
    public BlockPos getBlockPos() {
        Vec3 vector = this.access.getPosition();
        return new BlockPos((int) vector.x, (int) vector.y, (int) vector.z);
    }

    @Override
    public Level getLevel() {
        return this.access.getLevel();
    }

    @Override
    public String getType() {
        return "scanner";
    }

    @Override
    public boolean equals(@Nullable IPeripheral other) {
        return other instanceof ScannerPocketPeripheral o && access == o.access;
    }
}
