package at.naturesocks.fabric.cccobblemonmod;

import at.naturesocks.common.cccobblemonmod.CommonCCCobblemonMod;
import at.naturesocks.common.cccobblemonmod.block.CommonModBlocks;
import at.naturesocks.common.cccobblemonmod.block.entities.CommonModBlockEntities;
import at.naturesocks.common.cccobblemonmod.block.entities.ScannerBlockEntity;
import at.naturesocks.common.cccobblemonmod.item.CommonModItems;
import at.naturesocks.common.cccobblemonmod.item.ModCreativeModeTab;
import at.naturesocks.common.cccobblemonmod.peripherals.computer.HealingMachinePeripheral;
import at.naturesocks.common.cccobblemonmod.peripherals.computer.PasturePeripheral;
import at.naturesocks.common.cccobblemonmod.peripherals.computer.ScannerPeripheral;
import at.naturesocks.common.cccobblemonmod.peripherals.pocket.CommonPocketUpgrade;
import at.naturesocks.common.cccobblemonmod.peripherals.turtle.CommonTurtleUpgrade;
import com.cobblemon.mod.common.CobblemonBlockEntities;
import com.cobblemon.mod.common.block.entity.HealingMachineBlockEntity;
import com.cobblemon.mod.common.block.entity.PokemonPastureBlockEntity;
import dan200.computercraft.api.client.FabricComputerCraftAPIClient;
import dan200.computercraft.api.client.turtle.TurtleUpgradeModeller;
import dan200.computercraft.api.peripheral.PeripheralLookup;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;

public class FabricCCCobblemonMod implements ModInitializer {

    @Override
    public void onInitialize() {
        CommonModBlocks.register((identifier, block) -> Registry.register(CommonModBlocks.registry, identifier, block));
        CommonModItems.register((identifier, item) -> Registry.register(CommonModItems.registry, identifier, item));
        CommonModBlockEntities.register((identifier, blockEntity) -> Registry.register(CommonModBlockEntities.registry, identifier, blockEntity));
        ModCreativeModeTab.register((identifier, creativeModeTab) -> Registry.register(ModCreativeModeTab.registry, identifier, creativeModeTab));


        PeripheralLookup.get().registerForBlockEntity((f, s) -> new ScannerPeripheral((ScannerBlockEntity) f), CommonModBlockEntities.SCANNER_BLOCK);
        PeripheralLookup.get().registerForBlockEntity((f, s) -> new HealingMachinePeripheral((HealingMachineBlockEntity) f, s), CobblemonBlockEntities.HEALING_MACHINE);
        PeripheralLookup.get().registerForBlockEntity((f, s) -> new PasturePeripheral((PokemonPastureBlockEntity) f, s), CobblemonBlockEntities.PASTURE);


        CommonTurtleUpgrade.register((identifier, upgradeType) -> Registry.register(CommonTurtleUpgrade.registry, identifier, upgradeType));
        CommonPocketUpgrade.register((identifier, upgradeType) -> Registry.register(CommonPocketUpgrade.registry, identifier, upgradeType));

        FabricComputerCraftAPIClient.registerTurtleUpgradeModeller(CommonTurtleUpgrade.SCANNER_TURTLE_UPGRADE, TurtleUpgradeModeller.sided(CommonCCCobblemonMod.resource("block/turtle_scanner_left"), CommonCCCobblemonMod.resource("block/turtle_scanner_right")));
    }
}
