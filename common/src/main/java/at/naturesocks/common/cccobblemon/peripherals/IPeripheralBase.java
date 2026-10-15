package at.naturesocks.common.cccobblemon.peripherals;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public interface IPeripheralBase {

    BlockPos getBlockPos();
    Level getLevel();
}
