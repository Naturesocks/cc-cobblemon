package at.naturesocks.common.cccobblemon.mixin;

import at.naturesocks.common.cccobblemon.misc.PokemonHelper;
import at.naturesocks.common.cccobblemon.peripherals.HealingMachinePeripheral;
import com.cobblemon.mod.common.api.storage.party.PartyStore;
import com.cobblemon.mod.common.block.entity.HealingMachineBlockEntity;
import dan200.computercraft.api.peripheral.IComputerAccess;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Mixin(HealingMachineBlockEntity.class)
public class HealingMachineBlockEntityMixin {

    @Inject(method = "activate", at = @At("TAIL"), remap = false)
    public void activate(UUID uuid, PartyStore partyStore, CallbackInfo ci)
    {
        HealingMachineBlockEntity entity = (HealingMachineBlockEntity) (Object) this;

        if (!HealingMachinePeripheral.COMPUTER_MAP.containsKey(entity.getBlockPos()))
        {
            return;
        }

        IComputerAccess computer = HealingMachinePeripheral.COMPUTER_MAP.get(entity.getBlockPos());

        assert entity.getLevel() != null;
        ServerPlayer player = entity.getLevel().getServer().getPlayerList().getPlayer(uuid);


        Map<String, Object> eventData = new HashMap<>();
        eventData.put("trainer", player.getName().getString());
        var data = PokemonHelper.getMultiplePokemonData(partyStore);
        eventData.put("team", data);
        computer.queueEvent("healing_machine_used", eventData);
    }
}
