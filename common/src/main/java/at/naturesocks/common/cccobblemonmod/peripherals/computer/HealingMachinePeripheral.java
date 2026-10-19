package at.naturesocks.common.cccobblemonmod.peripherals.computer;

import com.cobblemon.mod.common.block.entity.HealingMachineBlockEntity;
import dan200.computercraft.api.lua.LuaFunction;
import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.peripheral.IPeripheral;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class HealingMachinePeripheral implements IPeripheral {

    public static Map<BlockPos, IComputerAccess> COMPUTER_MAP = new HashMap<>();

    private final HealingMachineBlockEntity entity;

    public HealingMachinePeripheral(HealingMachineBlockEntity entity, Direction direction)
    {
        this.entity = entity;
    }

    // Peripheral
    @Override
    public @NonNull String getType() {
        return "healing_machine";
    }

    @Override
    public boolean equals(@Nullable IPeripheral other) {
        return other instanceof HealingMachinePeripheral o && entity == o.entity;
    }

    @Override
    public void attach(@NonNull IComputerAccess computer) {
        COMPUTER_MAP.put(this.entity.getBlockPos(), computer);
    }

    @Override
    public void detach(@NonNull IComputerAccess computer) {
        COMPUTER_MAP.remove(this.entity.getBlockPos());
    }

    // Lua Functions
    @LuaFunction
    public final float getCharge()
    {
        return this.entity.getHealingCharge();
    }

    @LuaFunction
    public final float getMaxCharge()
    {
        return this.entity.getMaxCharge();
    }
}
