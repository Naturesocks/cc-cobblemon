package at.naturesocks.common.cccobblemon.peripherals.turtle;

import at.naturesocks.common.cccobblemon.CommonCCCobblemonMod;
import dan200.computercraft.api.turtle.ITurtleUpgrade;
import dan200.computercraft.api.upgrades.UpgradeType;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class CommonTurtleUpgrade {

    public static final Registry registry = BuiltInRegistries.REGISTRY.get(ITurtleUpgrade.typeRegistry().location());

    public static Map<ResourceLocation, UpgradeType> QUEUE = new HashMap<>();

    public static final UpgradeType<ScannerTurtleUpgrade> SCANNER_TURTLE_UPGRADE = create("scanner_turtle_upgrade",
            () -> UpgradeType.simpleWithCustomItem(ScannerTurtleUpgrade::new)
    );

    public static UpgradeType create(String name, Supplier<UpgradeType> supplier)
    {
        UpgradeType type = supplier.get();
        QUEUE.put(ResourceLocation.fromNamespaceAndPath(CommonCCCobblemonMod.MOD_ID, name), type);
        return type;
    }

    public static void register(BiConsumer<ResourceLocation, UpgradeType> consumer)
    {
        QUEUE.forEach(consumer);
    }
}
