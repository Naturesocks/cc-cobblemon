package at.naturesocks.common.cccobblemon.block;

import at.naturesocks.common.cccobblemon.CommonCCCobblemonMod;
import kotlin.Unit;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class CommonModBlocks {

    public static ResourceKey<Registry<Block>> resourceKey = Registries.BLOCK;

    public static Map<ResourceLocation, Block> QUEUE = new HashMap<>();

    public static final Block SCANER_BLOCK = create("scaner", new Block(
            BlockBehaviour.Properties.of()
                    .destroyTime(2.0f)
                    .sound(SoundType.STONE)
    ));

    public static Block create(String name, Block block)
    {
        QUEUE.put(ResourceLocation.fromNamespaceAndPath(CommonCCCobblemonMod.MOD_ID, name), block);
        return block;
    }

    public static void register(BiConsumer<ResourceLocation, Block> consumer)
    {
        QUEUE.forEach(consumer);
    }
}
