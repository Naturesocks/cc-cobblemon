package at.naturesocks.common.cccobblemonmod.block.entities;

import at.naturesocks.common.cccobblemonmod.CommonCCCobblemonMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;


public class CommonModBlockEntities {

    public static ResourceKey resourceKey = Registries.BLOCK_ENTITY_TYPE;
    public static Registry<BlockEntityType<?>> registry = BuiltInRegistries.BLOCK_ENTITY_TYPE;

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
