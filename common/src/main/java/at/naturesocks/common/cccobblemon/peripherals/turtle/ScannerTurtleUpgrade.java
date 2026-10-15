package at.naturesocks.common.cccobblemon.peripherals.turtle;

import at.naturesocks.common.cccobblemon.misc.PokemonHelper;
import at.naturesocks.common.cccobblemon.peripherals.ScannerBase;
import at.naturesocks.common.cccobblemon.peripherals.computer.ScannerPeripheral;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.pokemon.Pokemon;
import dan200.computercraft.api.lua.LuaFunction;
import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.turtle.*;
import dan200.computercraft.api.upgrades.UpgradeType;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.Nullable;

public class ScannerTurtleUpgrade extends AbstractTurtleUpgrade implements ScannerBase {

    private int range = 1;

    private ITurtleAccess turtleAccess;

    protected ScannerTurtleUpgrade(ItemStack stack) {
        super(TurtleUpgradeType.PERIPHERAL, "scanner", stack);
    }

    @Override
    public UpgradeType<? extends ITurtleUpgrade> getType() {
        return CommonTurtleUpgrade.SCANNER_TURTLE_UPGRADE;
    }

    @Override
    public @Nullable IPeripheral createPeripheral(ITurtleAccess turtle, TurtleSide side) {
        return new ScannerTurtlePeripheral(turtle);
    }

    @Override
    public BlockPos getBlockPos() {
        return this.turtleAccess.getPosition();
    }

    @Override
    public Level getLevel() {
        return this.turtleAccess.getLevel();
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
