package at.naturesocks.forge.cccobblemonmod;

import at.naturesocks.common.cccobblemonmod.CommonCCCobblemonMod;
import at.naturesocks.common.cccobblemonmod.peripherals.turtle.CommonTurtleUpgrade;
import dan200.computercraft.api.client.turtle.RegisterTurtleModellersEvent;
import dan200.computercraft.api.client.turtle.TurtleUpgradeModeller;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber(modid = CommonCCCobblemonMod.MOD_ID, value = Dist.CLIENT)
public class NeoForgeClientCCCobblemonMod {

    @SubscribeEvent
    public static void onUpgradeModeller(RegisterTurtleModellersEvent event) {
        event.register(CommonTurtleUpgrade.SCANNER_TURTLE_UPGRADE, TurtleUpgradeModeller.sided(CommonCCCobblemonMod.resource("block/turtle_scanner_left"), CommonCCCobblemonMod.resource("block/turtle_scanner_right")));
    }
}
