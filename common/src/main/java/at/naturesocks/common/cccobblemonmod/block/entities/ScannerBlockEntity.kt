package at.naturesocks.common.cccobblemonmod.block.entities

import net.minecraft.core.BlockPos
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState

@Suppress("MemberVisibilityCanBePrivate", "unused")
class ScannerBlockEntity(
    blockPos: BlockPos,
    blockState: BlockState
) : BlockEntity(CommonModBlockEntities.SCANNER_BLOCK, blockPos, blockState) {
}