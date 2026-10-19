package at.naturesocks.common.cccobblemonmod.peripherals.computer;

import at.naturesocks.common.cccobblemonmod.misc.PokemonHelper;
import com.cobblemon.mod.common.block.entity.PokemonPastureBlockEntity;
import com.cobblemon.mod.common.pokemon.Pokemon;
import dan200.computercraft.api.lua.LuaFunction;
import dan200.computercraft.api.peripheral.IPeripheral;
import net.minecraft.core.Direction;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PasturePeripheral implements IPeripheral {

    private final PokemonPastureBlockEntity entity;

    public PasturePeripheral(PokemonPastureBlockEntity entity, Direction direction) {
        this.entity = entity;
    }

    @Override
    public @NonNull String getType() {
        return "pasture";
    }

    @Override
    public boolean equals(@Nullable IPeripheral other) {
        return other instanceof PasturePeripheral o && entity == o.entity;
    }

    @LuaFunction
    public final String getOwner()
    {
        return this.entity.getOwnerName();
    }

    @LuaFunction
    public final Map<Integer, Map<String, Object>> getPokemon()
    {
        List<Pokemon> pokemons = new ArrayList<>();
        this.entity.getTetheredPokemon().forEach((tethering) -> pokemons.add(tethering.getPokemon()));
        return PokemonHelper.getMultiplePokemonData(pokemons.iterator());
    }
}
