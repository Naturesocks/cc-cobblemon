package at.naturesocks.forge.cccobblemon;

import at.naturesocks.common.cccobblemon.CommonCCCobblemonMod;
import at.naturesocks.common.cccobblemon.block.CommonModBlocks;
import at.naturesocks.common.cccobblemon.block.entities.CommonModBlockEntities;
import at.naturesocks.common.cccobblemon.block.entities.ScannerBlockEntity;
import at.naturesocks.common.cccobblemon.item.CommonModItems;
import at.naturesocks.common.cccobblemon.peripherals.computer.HealingMachinePeripheral;
import at.naturesocks.common.cccobblemon.peripherals.computer.PasturePeripheral;
import at.naturesocks.common.cccobblemon.peripherals.computer.ScannerPeripheral;
import at.naturesocks.common.cccobblemon.peripherals.pocket.CommonPocketUpgrade;
import at.naturesocks.common.cccobblemon.peripherals.turtle.CommonTurtleUpgrade;
import com.cobblemon.mod.common.CobblemonBlockEntities;
import dan200.computercraft.api.peripheral.PeripheralCapability;
import dan200.computercraft.api.pocket.IPocketUpgrade;
import dan200.computercraft.api.turtle.ITurtleUpgrade;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(CommonCCCobblemonMod.MOD_ID)
public class ForgeCCCobblemonMod {

    public ForgeCCCobblemonMod(IEventBus modBus) {
        registerBlocks(modBus);
        registerItems(modBus);
        registerBlockEntites(modBus);
        registerPeripherals(modBus);
        registerTurtleUpgrades(modBus);
        registerPocketUpgrade(modBus);
    }

    public void registerBlocks(IEventBus modBus)
    {
        modBus.addListener((RegisterEvent event) -> {
            event.register(CommonModBlocks.resourceKey, (RegisterEvent.RegisterHelper<Block> helper) -> {
                CommonModBlocks.register(helper::register);
            });
        });
    }

    public void registerItems(IEventBus modBus) {
        modBus.addListener((RegisterEvent event) -> {
            event.register(CommonModItems.resourceKey, (RegisterEvent.RegisterHelper<Item> helper) -> {
                CommonModItems.register(helper::register);
            });
        });
    }

    private void registerBlockEntites(IEventBus modBus) {
        modBus.addListener((RegisterEvent event) -> {
            event.register(CommonModBlockEntities.resourceKey, (RegisterEvent.RegisterHelper<BlockEntityType> helper) -> {
                CommonModBlockEntities.register(helper::register);
            });
        });
    }

    private void registerPeripherals(IEventBus modBus) {
        modBus.addListener((RegisterCapabilitiesEvent event) -> {
            event.registerBlockEntity(PeripheralCapability.get(), CommonModBlockEntities.SCANNER_BLOCK, (b, d) -> new ScannerPeripheral((ScannerBlockEntity) b));
            event.registerBlockEntity(PeripheralCapability.get(), CobblemonBlockEntities.HEALING_MACHINE, HealingMachinePeripheral::new);
            event.registerBlockEntity(PeripheralCapability.get(), CobblemonBlockEntities.PASTURE, PasturePeripheral::new);

        });
    }

    private void registerTurtleUpgrades(IEventBus modBus) {
        modBus.addListener((RegisterEvent event) -> {
            CommonTurtleUpgrade.register((indentifier, upgrade) -> {
                event.register(
                        ITurtleUpgrade.typeRegistry(),
                        indentifier,
                        () -> upgrade
                );
            });
        });
    }

    private void registerPocketUpgrade(IEventBus modBus) {
        modBus.addListener((RegisterEvent event) -> {
            CommonPocketUpgrade.register((indentifier, upgrade) -> {
                event.register(
                        IPocketUpgrade.typeRegistry(),
                        indentifier,
                        () -> upgrade
                );
            });

        });
    }
}
