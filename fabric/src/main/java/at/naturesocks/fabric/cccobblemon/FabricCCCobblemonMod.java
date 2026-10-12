package at.naturesocks.fabric.cccobblemon;

import at.naturesocks.common.cccobblemon.ExampleCommandRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

public class FabricCCCobblemonMod implements ModInitializer {

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register(ExampleCommandRegistry::registerCommands);
    }

}
