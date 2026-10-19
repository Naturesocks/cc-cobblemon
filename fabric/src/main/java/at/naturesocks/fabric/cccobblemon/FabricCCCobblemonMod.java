package at.naturesocks.fabric.cccobblemon;

import at.naturesocks.common.cccobblemon.block.CommonModBlocks;
import at.naturesocks.common.cccobblemon.block.entities.CommonModBlockEntities;
import at.naturesocks.common.cccobblemon.block.entities.ScannerBlockEntity;
import at.naturesocks.common.cccobblemon.item.CommonModItems;
import at.naturesocks.common.cccobblemon.peripherals.computer.HealingMachinePeripheral;
import at.naturesocks.common.cccobblemon.peripherals.computer.ScannerPeripheral;
import at.naturesocks.common.cccobblemon.peripherals.pocket.CommonPocketUpgrade;
import at.naturesocks.common.cccobblemon.peripherals.turtle.CommonTurtleUpgrade;
import com.cobblemon.mod.common.CobblemonBlockEntities;
import com.cobblemon.mod.common.block.entity.HealingMachineBlockEntity;
import dan200.computercraft.api.peripheral.PeripheralLookup;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;

public class FabricCCCobblemonMod implements ModInitializer {

    @Override
    public void onInitialize() {
        CommonModBlocks.register((identifier, item) -> Registry.register(CommonModBlocks.registry, identifier, item));
        CommonModBlockEntities.register((identifier, item) -> Registry.register(CommonModBlockEntities.registry, identifier, item));
        CommonModItems.register((identifier, item) -> Registry.register(CommonModItems.registry, identifier, item));

        PeripheralLookup.get().registerForBlockEntity((f, s) -> new ScannerPeripheral((ScannerBlockEntity) f), CommonModBlockEntities.SCANNER_BLOCK);
        PeripheralLookup.get().registerForBlockEntity((f, s) -> new HealingMachinePeripheral((HealingMachineBlockEntity) f, s), CobblemonBlockEntities.HEALING_MACHINE);

        CommonTurtleUpgrade.register((identifier, upgradeType) -> Registry.register(CommonTurtleUpgrade.registry, identifier, upgradeType));

        CommonPocketUpgrade.register((identifier, upgradeType) -> Registry.register(CommonPocketUpgrade.registry, identifier, upgradeType));

    }
}
