package net.fryc.frycmobvariants.tags;

import net.fryc.frycmobvariants.MobVariants;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ModBiomeTags {
    public static final TagKey<Biome> EXPLORER_SPAWN_BIOMES = ModBiomeTags.register("explorer_spawn_biomes");
    public static final TagKey<Biome> TOXIC_SLIME_SPAWN_BIOMES = ModBiomeTags.register("toxic_slime_spawn_biomes");

    public static final TagKey<Biome> SNOWY_BIOMES = ModBiomeTags.register("snowy_biomes");


    private ModBiomeTags(){
    }
    private static TagKey<Biome> register(String id) {
        return TagKey.of(RegistryKeys.BIOME, new Identifier(MobVariants.MOD_ID, id));
    }
}
