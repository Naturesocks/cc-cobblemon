package at.naturesocks.forge.ccobblemon;

import at.naturesocks.common.cccobblemon.CommonCCCobblemonMod;
import at.naturesocks.common.cccobblemon.ExampleCommandRegistry;
import at.naturesocks.common.cccobblemon.block.CommonModBlocks;
import at.naturesocks.common.cccobblemon.block.entities.CommonModBlockEntities;
import at.naturesocks.common.cccobblemon.block.entities.ScannerBlockEntity;
import at.naturesocks.common.cccobblemon.item.CommonModItems;
import at.naturesocks.common.cccobblemon.peripherals.ModPeripherals;
import at.naturesocks.common.cccobblemon.peripherals.ScannerPeripheral;
import dan200.computercraft.api.peripheral.PeripheralCapability;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(CommonCCCobblemonMod.MOD_ID)
public class ForgeCCCobblemonMod {

    public ForgeCCCobblemonMod(IEventBus modBus) {
        NeoForge.EVENT_BUS.register(this);
        registerBlocks(modBus);
        registerItems(modBus);
        registerBlockEntites(modBus);
        registerPeripherals(modBus);
//        ModPeripherals.load();

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
        });
    }

    @SubscribeEvent
    public void onCommandRegistration(RegisterCommandsEvent event) {
        ExampleCommandRegistry.registerCommands(event.getDispatcher(), event.getBuildContext(), event.getCommandSelection());
    }
}
