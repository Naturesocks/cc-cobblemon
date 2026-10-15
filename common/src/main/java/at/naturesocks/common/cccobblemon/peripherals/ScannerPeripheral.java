package at.naturesocks.common.cccobblemon.peripherals;

import at.naturesocks.common.cccobblemon.block.entities.ScannerBlockEntity;
import at.naturesocks.common.cccobblemon.misc.PokemonHelper;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.pokemon.Pokemon;
import dan200.computercraft.api.lua.LuaFunction;
import dan200.computercraft.api.peripheral.IPeripheral;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.*;

public class ScannerPeripheral implements IPeripheral {

//    public static Map<UUID, IComputerAccess> BATTLE_IDS_COMPUTER = new HashMap<>();
//    public static Map<IComputerAccess, UUID> COMPUTER_BATTLE_IDS = new HashMap<>();

    private final ScannerBlockEntity scannerBlockEntity;
//    private IComputerAccess computer;

    private int range = 0;

    public ScannerPeripheral(ScannerBlockEntity scannerBlockEntity) {
        this.scannerBlockEntity = scannerBlockEntity;
    }

    @Override
    public @NonNull String getType() {
        return "scanner";
    }

    @Override
    public boolean equals(@Nullable IPeripheral other) {
        return other instanceof ScannerPeripheral o && scannerBlockEntity == o.scannerBlockEntity;
    }

//    @Override
//    public void attach(IComputerAccess computer) {
//        this.computer = computer;
//    }
//
//    @Override
//    public void detach(IComputerAccess computer) {
//        BATTLE_IDS_COMPUTER.remove(COMPUTER_BATTLE_IDS.get(computer));
//        COMPUTER_BATTLE_IDS.remove(computer);
//    }

    @LuaFunction
    public final void setScannerRange(int range)
    {
        this.range = range;
    }

    public final int getScannerRange()
    {
        return this.range;
    }

    @LuaFunction
    public final Map<Integer, Map<String, Object>> getPokemon()
    {
        AABB area = new AABB(this.scannerBlockEntity.getBlockPos());
        area = area.inflate(this.range);
        Level level = this.scannerBlockEntity.getLevel();
        assert level != null;
        List<PokemonEntity> listPokemon = level.getEntitiesOfClass(PokemonEntity.class, area);
        var size = listPokemon.size();
        Map<Integer, Map<String, Object>> result = new HashMap<>();
        for (var i = 0; i < size; i++) {
            PokemonEntity pokemonEntity = listPokemon.get(i);
            Pokemon pokemon = pokemonEntity.getPokemon();
            Map<String, Object> map = new HashMap<>();
            map.putAll(PokemonHelper.getPokemonData(pokemon));
            map.putAll(PokemonHelper.getPokemonEntityData(pokemonEntity));
            result.put(i + 1, map);
        }

        return result;
    }

//    @LuaFunction
//    public final void registerBattle(String battleIdString)
//    {
//        UUID battleId = UUID.fromString(battleIdString);
//        BATTLE_IDS_COMPUTER.put(battleId, computer);
//        COMPUTER_BATTLE_IDS.put(computer, battleId);
//        BattleRegistry.getBattle(battleId).getOnEndHandlers().add((battle) -> {
//            COMPUTER_BATTLE_IDS.remove(BATTLE_IDS_COMPUTER.get(battle.getBattleId()));
//            BATTLE_IDS_COMPUTER.remove(battle.getBattleId());
//            return null;
//        });
//    }
}
