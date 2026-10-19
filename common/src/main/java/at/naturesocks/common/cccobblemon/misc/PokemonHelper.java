package at.naturesocks.common.cccobblemon.misc;

import com.cobblemon.mod.common.api.pokedex.SpeciesDexRecord;
import com.cobblemon.mod.common.api.riding.RidingProperties;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.pokemon.Pokemon;
import dan200.computercraft.api.detail.VanillaDetailRegistries;
import net.minecraft.network.chat.Component;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

public class PokemonHelper {

    public static Map<Integer, Map<String, Object>> getMultiplePokemonData(Iterator<Pokemon> store)
    {
        Map<Integer, Map<String, Object>> out = new HashMap<>();

        int counter = 1;
        while (store.hasNext()) {
            Pokemon pokemon = store.next();
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

        // it works but is that smart?
        {
            Map<String, Object> stats = new HashMap<>();
            stats.put("hp", pokemon.getMaxHealth());
            stats.put("current_hp", pokemon.getCurrentHealth());
            stats.put("atk", pokemon.getAttack());
            stats.put("sp_atk", pokemon.getSpecialAttack());
            stats.put("def", pokemon.getDefence());
            stats.put("sp_def", pokemon.getSpecialDefence());
            stats.put("speed", pokemon.getSpecialDefence());
            out.put("stats", stats);
        }

        RidingProperties properties = pokemon.getRiding();
        if (properties.getBehaviours() != null)
        {
            Map<String, Object> ridingProperties = new HashMap<>();
            properties.getBehaviours().forEach((key1, value1) -> {
                var stats = value1.getStats();
                Map<String, String> converted = stats.entrySet().stream().collect(Collectors.toMap(
                        (key) -> key.getKey().getDisplayName().getString(),
                        (value) -> value.getValue().toString()
                ));
                ridingProperties.put(key1.name(), converted);
            });

            out.put("riding_properties", ridingProperties);
        }

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

    public static Map<String, Object> getSpeciesRecords(SpeciesDexRecord speciesRecord) {
        Map<String, Object> out = new HashMap<>();
        out.put("id", speciesRecord.getId());
        out.put("knowledge", speciesRecord.getKnowledge().getSerializedName());
        out.put("aspects", speciesRecord.getAspects());

        return out;
    }

    public static Map<String, Object> getSpeciesInformation(SpeciesDexRecord speciesRecord)
    {
        Map<String, Object> out = new HashMap<>();
        String name = speciesRecord.getId().getPath();
        out.put("name", Component.translatable("cobblemon.species." + name + ".name").getString());
        out.put("desc", Component.translatable("cobblemon.species." + name + ".desc").getString());
        return out;
    }
}
