package at.naturesocks.common.cccobblemon.peripherals.pocket;

import at.naturesocks.common.cccobblemon.misc.PokemonHelper;
import at.naturesocks.common.cccobblemon.peripherals.ScannerBase;
import com.cobblemon.mod.common.api.pokedex.PokedexManager;
import com.cobblemon.mod.common.api.pokedex.SpeciesDexRecord;
import com.cobblemon.mod.common.api.storage.party.PlayerPartyStore;
import com.cobblemon.mod.common.util.PlayerExtensionsKt;
import dan200.computercraft.api.lua.LuaFunction;
import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.pocket.IPocketAccess;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class ScannerPocketPeripheral implements ScannerBase, IPeripheral {

    private final IPocketAccess access;
    private int range = 1;

    public ScannerPocketPeripheral(IPocketAccess access) {
        this.access = access;
    }

    // Peripheral
    @Override
    public BlockPos getBlockPos() {
        Vec3 vector = this.access.getPosition();
        return new BlockPos((int) vector.x, (int) vector.y, (int) vector.z);
    }

    @Override
    public Level getLevel() {
        return this.access.getLevel();
    }

    @Override
    public @NonNull String getType() {
        return "scanner";
    }

    @Override
    public boolean equals(@Nullable IPeripheral other) {
        return other instanceof ScannerPocketPeripheral o && access == o.access;
    }

    // Lua Functions
    @Override
    @LuaFunction
    public final void setScannerRange(int range) {
        this.range = Math.clamp(range, 1, 10);
    }

    @Override
    @LuaFunction
    public final int getScannerRange() {
        return this.range;
    }

    @LuaFunction
    public final Map<Integer, Map<String, Object>> getTeam()
    {
        if (this.access.getEntity() instanceof ServerPlayer serverPlayer)
        {
            PlayerPartyStore partyStore = PlayerExtensionsKt.party(serverPlayer);
            return PokemonHelper.getMultiplePokemonData(partyStore.iterator());
        }
        return null;
    }

    @LuaFunction
    public final Map<String, Object> getPokedexPokemonEntry(String id)
    {
        if (this.access.getEntity() instanceof ServerPlayer serverPlayer)
        {
            PokedexManager pokedexManager = PlayerExtensionsKt.pokedex(serverPlayer);
            SpeciesDexRecord speciesRecord = pokedexManager.getSpeciesRecord(ResourceLocation.parse(id));
            if (speciesRecord == null)
            {
                return null;
            }
            Map<String, Object> out = new HashMap<>();
            out.putAll(PokemonHelper.getSpeciesRecords(speciesRecord));
            out.putAll(PokemonHelper.getSpeciesInformation(speciesRecord));
            return out;
        }
        return null;
    }

    @LuaFunction
    public final Map<Integer, Object> getDiscoveredSpecies()
    {
        if (this.access.getEntity() instanceof ServerPlayer serverPlayer) {
            PokedexManager pokedexManager = PlayerExtensionsKt.pokedex(serverPlayer);
            Map<Integer, Object> out = new HashMap<>();
            int counter = 1;
            for (Map.Entry<ResourceLocation, SpeciesDexRecord> entry : pokedexManager.getSpeciesRecords().entrySet())
            {
                Map<String, Object> record = new HashMap<>();
                SpeciesDexRecord speciesDexRecord = entry.getValue();
                record.putAll(PokemonHelper.getSpeciesRecords(speciesDexRecord));
                record.putAll(PokemonHelper.getSpeciesInformation(speciesDexRecord));
                out.put(counter, record);
                counter++;
            }
            return out;
        }
        return null;
    }
}
