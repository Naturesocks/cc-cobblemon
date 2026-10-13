package at.naturesocks.common.cccobblemon.block.entities;

import at.naturesocks.common.cccobblemon.CommonCCCobblemonMod;
import at.naturesocks.common.cccobblemon.block.CommonModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;


public class CommonModBlockEntities {

    public static ResourceKey resourceKey = Registries.BLOCK_ENTITY_TYPE;

    public static Map<ResourceLocation, BlockEntityType> QUEUE = new HashMap<>();

    public static BlockEntityType SCANNER_BLOCK = create("scanner",
            CommonModBlockEntitiesHelper.INSTANCE.getScanner());

    public static BlockEntityType create(String name, BlockEntityType type) {
        QUEUE.put(ResourceLocation.fromNamespaceAndPath(CommonCCCobblemonMod.MOD_ID, name), type);
        return type;
    }

    public static void register(BiConsumer<ResourceLocation, BlockEntityType> consumer)
    {
        QUEUE.forEach(consumer);
    }
}
