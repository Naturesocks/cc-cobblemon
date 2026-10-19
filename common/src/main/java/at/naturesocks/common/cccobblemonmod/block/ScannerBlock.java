package at.naturesocks.common.cccobblemonmod.block;

import at.naturesocks.common.cccobblemonmod.block.entities.ScannerBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ScannerBlock extends Block implements EntityBlock {
    public ScannerBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new ScannerBlockEntity(blockPos, blockState);
    }
}
