package at.naturesocks.common.cccobblemon;

import net.minecraft.resources.ResourceLocation;

public class CommonCCCobblemonMod {

    public static final String MOD_ID = "cccobblemonmod";

    public static ResourceLocation resource(String name)
    {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }
}
