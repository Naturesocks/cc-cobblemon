package at.naturesocks.common.cccobblemonmod.peripherals.pocket;

import at.naturesocks.common.cccobblemonmod.CommonCCCobblemonMod;
import dan200.computercraft.api.pocket.IPocketUpgrade;
import dan200.computercraft.api.upgrades.UpgradeType;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class CommonPocketUpgrade {

    public static final Registry registry = BuiltInRegistries.REGISTRY.get(IPocketUpgrade.typeRegistry().location());

    public static Map<ResourceLocation, UpgradeType> QUEUE = new HashMap<>();

    public static final UpgradeType<ScannerPocketUpgrade> SCANNER_POCKET_UPGRADE = create("scanner_pocket_upgrade",
            () -> UpgradeType.simpleWithCustomItem(ScannerPocketUpgrade::new)
    );

    public static UpgradeType create(String name, Supplier<UpgradeType> supplier)
    {
        UpgradeType type = supplier.get();
        QUEUE.put(CommonCCCobblemonMod.resource(name), type);
        return type;
    }

    public static void register(BiConsumer<ResourceLocation, UpgradeType> consumer)
    {
        QUEUE.forEach(consumer);
    }

}
