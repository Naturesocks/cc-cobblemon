package at.naturesocks.common.cccobblemon.misc;

import com.cobblemon.mod.common.api.storage.PokemonStore;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.pokemon.Pokemon;
import dan200.computercraft.api.detail.VanillaDetailRegistries;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PokemonHelper {

    public static Map<Integer, Map<String, Object>> getMultiplePokemonData(PokemonStore store)
    {
        Map<Integer, Map<String, Object>> out = new HashMap<>();

        int counter = 1;
        for (Iterator it = store.iterator(); it.hasNext(); ) {
            Pokemon pokemon = (Pokemon) it.next();
            out.put(counter, getPokemonData(pokemon));
            counter++;
        }

        return out;
    }

    public static Map<String, Object> getPokemonData(Pokemon pokemon)
    {
        Map<String, Object> out = new HashMap<>();
        out.put("name", pokemon.getDisplayName(false).getString());
        out.put("species", pokemon.getSpecies().getName());
        out.put("level", pokemon.getLevel());
        out.put("gender", pokemon.getGender().getSerializedName());
        out.put("primary_type", pokemon.getPrimaryType().getDisplayName().getString());
        if (pokemon.getSecondaryType() != null)
        {
            out.put("secondary_type", pokemon.getSecondaryType().getDisplayName().getString());
        }
        out.put("size", pokemon.getSizeCategory().name());

        out.put("cosmetic_item", VanillaDetailRegistries.ITEM_STACK.getDetails(pokemon.cosmeticItem()));
        out.put("held_item", VanillaDetailRegistries.ITEM_STACK.getDetails(pokemon.heldItem()));
        out.put("ability", pokemon.getAbility().getDisplayName());
        out.put("friendship", pokemon.getFriendship());
        if (pokemon.getActiveMark() != null){
            out.put("mark", pokemon.getActiveMark().getTitle());
        }
        Map<String, Object> stats = new HashMap<>();
        stats.put("hp", pokemon.getMaxHealth());
        stats.put("current_hp", pokemon.getCurrentHealth());
        stats.put("atk", pokemon.getAttack());
        stats.put("sp_atk", pokemon.getSpecialAttack());
        stats.put("def", pokemon.getDefence());
        stats.put("sp_def", pokemon.getSpecialDefence());
        stats.put("speed", pokemon.getSpecialDefence());
        out.put("stats", stats);
        return out;
    }

    public static Map<String, Object> getPokemonEntityData(PokemonEntity pokemonEntity)
    {
        Map<String, Object> out = new HashMap<>();
        out.put("isBattling", pokemonEntity.isBattling());
        out.put("battle_id", pokemonEntity.getBattleId());
        out.put("aspects", pokemonEntity.getAspects());
        return out;
    }
}
