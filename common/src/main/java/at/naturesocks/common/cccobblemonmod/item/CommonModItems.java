package at.naturesocks.common.cccobblemonmod.item;

import at.naturesocks.common.cccobblemonmod.CommonCCCobblemonMod;
import at.naturesocks.common.cccobblemonmod.block.CommonModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class CommonModItems {

    public static ResourceKey resourceKey = Registries.ITEM;
    public static Registry<Item> registry = BuiltInRegistries.ITEM;

    public static Map<ResourceLocation, Item> QUEUE = new HashMap<>();

    public static final Item SCANNER_BLOCK = create("scanner", new BlockItem(CommonModBlocks.SCANNER_BLOCK, new Item.Properties()));

    public static Item create(String name, Item item)
    {
        QUEUE.put(CommonCCCobblemonMod.resource(name), item);
        return item;
    }

    public static void register(BiConsumer<ResourceLocation, Item> consumer)
    {
        QUEUE.forEach(consumer);
    }
}
