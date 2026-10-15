package at.naturesocks.common.cccobblemon.peripherals.computer;

import at.naturesocks.common.cccobblemon.block.entities.ScannerBlockEntity;
import at.naturesocks.common.cccobblemon.peripherals.ScannerBase;
import dan200.computercraft.api.lua.LuaFunction;
import dan200.computercraft.api.peripheral.IPeripheral;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public class ScannerPeripheral implements ScannerBase, IPeripheral {

    private final ScannerBlockEntity scannerBlockEntity;

    private int range = 1;

    public ScannerPeripheral(ScannerBlockEntity scannerBlockEntity) {
        this.scannerBlockEntity = scannerBlockEntity;
    }

    @Override
    public @NonNull String getType() {
        return "scanner";
    }

    @Override
    public boolean equals(@Nullable IPeripheral other) {
        return other instanceof ScannerPeripheral o && scannerBlockEntity == o.scannerBlockEntity;
    }

    @Override
    public BlockPos getBlockPos() {
        return this.scannerBlockEntity.getBlockPos();
    }

    @Override
    public Level getLevel() {
        return this.scannerBlockEntity.getLevel();
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
}
