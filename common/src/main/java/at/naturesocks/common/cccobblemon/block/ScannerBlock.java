package at.naturesocks.common.cccobblemon.block;

import at.naturesocks.common.cccobblemon.block.entities.ScannerBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.Nullable;

public class ScannerBlock extends Block implements EntityBlock {
    public ScannerBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new ScannerBlockEntity(blockPos, blockState);
    }
}
