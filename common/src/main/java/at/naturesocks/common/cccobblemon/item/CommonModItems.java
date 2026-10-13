package at.naturesocks.common.cccobblemon.item;

import at.naturesocks.common.cccobblemon.CommonCCCobblemonMod;
import at.naturesocks.common.cccobblemon.block.CommonModBlocks;
import com.cobblemon.mod.common.pokemon.ai.ItemBehavior;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class CommonModItems {

    public static ResourceKey resourceKey = Registries.ITEM;

    public static Map<ResourceLocation, Item> QUEUE = new HashMap<>();

    public static final Item SCANNER_BLOCK = create("scanner", new BlockItem(CommonModBlocks.SCANNER_BLOCK, new Item.Properties()));

    public static Item create(String name, Item item)
    {
        QUEUE.put(ResourceLocation.fromNamespaceAndPath(CommonCCCobblemonMod.MOD_ID, name), item);
        return item;
    }

    public static void register(BiConsumer<ResourceLocation, Item> consumer)
    {
        QUEUE.forEach(consumer);
    }

    public static void load()
    {

    }
}
