package at.naturesocks.forge.ccobblemon;

import at.naturesocks.common.cccobblemon.CommonCCCobblemonMod;
import at.naturesocks.common.cccobblemon.ExampleCommandRegistry;
import at.naturesocks.common.cccobblemon.block.CommonModBlocks;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(CommonCCCobblemonMod.MOD_ID)
public class ForgeCCCobblemonMod {

    public ForgeCCCobblemonMod(IEventBus modBus) {
        NeoForge.EVENT_BUS.register(this);
        registerBlocks(modBus);
    }

    public void registerBlocks(IEventBus modBus)
    {
        modBus.addListener((RegisterEvent event) -> {
            event.register(CommonModBlocks.resourceKey, (RegisterEvent.RegisterHelper<Block> helper) -> {
                CommonModBlocks.register(helper::register);
            });
        });
    }

    @SubscribeEvent
    public void onCommandRegistration(RegisterCommandsEvent event) {
        ExampleCommandRegistry.registerCommands(event.getDispatcher(), event.getBuildContext(), event.getCommandSelection());
    }
}
