package at.naturesocks.common.cccobblemonmod.block.entities

import at.naturesocks.common.cccobblemonmod.block.CommonModBlocks
import net.minecraft.world.level.block.entity.BlockEntityType

object CommonModBlockEntitiesHelper {

    // strange workaround that the build.of function allows the BlockEntitySupplier to be seen as public
    var scanner = BlockEntityType.Builder.of<ScannerBlockEntity>(::ScannerBlockEntity, CommonModBlocks.SCANNER_BLOCK).build(null)
}