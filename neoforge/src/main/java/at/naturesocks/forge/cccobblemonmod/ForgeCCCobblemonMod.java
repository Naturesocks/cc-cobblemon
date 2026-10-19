package at.naturesocks.forge.cccobblemonmod;

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
import dan200.computercraft.api.peripheral.PeripheralCapability;
import dan200.computercraft.api.pocket.IPocketUpgrade;
import dan200.computercraft.api.turtle.ITurtleUpgrade;
import net.minecraft.world.item.CreativeModeTab;
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
        registerCreativeModeTabs(modBus);
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

    private void registerCreativeModeTabs(IEventBus modBus) {
        modBus.addListener((RegisterEvent event) -> {
            event.register(ModCreativeModeTab.resourceKey, (RegisterEvent.RegisterHelper<CreativeModeTab> helper) -> {
                ModCreativeModeTab.register(helper::register);
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
