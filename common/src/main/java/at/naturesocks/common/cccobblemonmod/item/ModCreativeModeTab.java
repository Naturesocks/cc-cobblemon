package at.naturesocks.common.cccobblemonmod.item;

import at.naturesocks.common.cccobblemonmod.CommonCCCobblemonMod;
import dan200.computercraft.api.pocket.IPocketUpgrade;
import dan200.computercraft.api.turtle.ITurtleUpgrade;
import dan200.computercraft.api.upgrades.UpgradeBase;
import dan200.computercraft.shared.ModRegistry;
import dan200.computercraft.shared.pocket.items.PocketComputerItem;
import dan200.computercraft.shared.turtle.items.TurtleItem;
import dan200.computercraft.shared.util.DataComponentUtil;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import dan200.computercraft.api.upgrades.UpgradeData;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;

public class ModCreativeModeTab {

    public static ResourceKey resourceKey = Registries.CREATIVE_MODE_TAB;
    public static Registry<CreativeModeTab> registry = BuiltInRegistries.CREATIVE_MODE_TAB;

    public static Map<ResourceLocation, CreativeModeTab> QUEUE = new HashMap<>();

    public static final CreativeModeTab CCCOBBLEMON_TAB = create("cccoblemon_tab", CreativeModeTab.builder(CreativeModeTab.Row.TOP, 1)
            .icon(() -> new ItemStack(CommonModItems.SCANNER_BLOCK))
            .title(Component.translatable("cccobblemonmod.cccobblemon_tab"))
            .displayItems(((itemDisplayParameters, output) -> {
                output.accept(CommonModItems.SCANNER_BLOCK);

                addTurtle(output, ModRegistry.Items.TURTLE_NORMAL.get(), itemDisplayParameters.holders());
                addTurtle(output, ModRegistry.Items.TURTLE_ADVANCED.get(), itemDisplayParameters.holders());
                addPocket(output, ModRegistry.Items.POCKET_COMPUTER_NORMAL.get(), itemDisplayParameters.holders());
                addPocket(output, ModRegistry.Items.POCKET_COMPUTER_ADVANCED.get(), itemDisplayParameters.holders());
            }))
            .build());

    private static void addTurtle(CreativeModeTab.Output output, TurtleItem turtle, HolderLookup.Provider holders) {
        holders.lookupOrThrow(ITurtleUpgrade.REGISTRY).listElements()
                .filter((upgradeReference) -> {
                    return ModCreativeModeTab.checkNamespace(upgradeReference);
                })
                .map(x -> {
                    return DataComponentUtil.createStack(turtle, ModRegistry.DataComponents.RIGHT_TURTLE_UPGRADE.get(), UpgradeData.ofDefault(x));
                })
                .forEach(output::accept);
    }

    private static void addPocket(CreativeModeTab.Output output, PocketComputerItem pocket, HolderLookup.Provider holders) {
        Optional<ItemStack> stack = holders.lookupOrThrow(IPocketUpgrade.REGISTRY).listElements()
                .filter((upgradeReference) -> upgradeReference.key().location().getNamespace().equals(CommonCCCobblemonMod.MOD_ID))
                .map(x -> DataComponentUtil.createStack(pocket, ModRegistry.DataComponents.POCKET_UPGRADE.get(), UpgradeData.ofDefault(x)))
                .findFirst();
        stack.ifPresent(output::accept);
    }

    private static boolean checkNamespace(Holder.Reference<? extends UpgradeBase> upgradeReference)
    {
        String namespace = upgradeReference.key().location().getNamespace();
        return namespace.equals(CommonCCCobblemonMod.MOD_ID);
    }

    public static CreativeModeTab create(String name, CreativeModeTab tab)
    {
        QUEUE.put(CommonCCCobblemonMod.resource(name), tab);
        return tab;
    }

    public static void register(BiConsumer<ResourceLocation, CreativeModeTab> consumer)
    {
        QUEUE.forEach(consumer);
    }
}
