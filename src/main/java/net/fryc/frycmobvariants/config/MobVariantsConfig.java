package net.fryc.frycmobvariants.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "frycmobvariants")
public class MobVariantsConfig implements ConfigData {

    //cave
    @Comment("Zombies have a chance to convert into stronger variant when they spawn below this Y level")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("cave")
    @ConfigEntry.BoundedDiscrete(max = 300, min = -64)
    public int zombieToForgottenConvertLevelY = 26;

    @Comment("When this value is below 0, chance of converting increases by 1% with every Y level below value specified in previous option")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("cave")
    @ConfigEntry.BoundedDiscrete(max = 100, min = -1)
    public int fixedChanceToConvertZombieUnderSelectedYLevel = -1;

    @Comment("Skeletons have a chance to convert into stronger variant when they spawn below this Y level")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("cave")
    @ConfigEntry.BoundedDiscrete(max = 300, min = -64)
    public int skeletonToUndeadWarriorConvertLevelY = 26;

    @Comment("When this value is below 0, chance of converting increases by 1% with every Y level below value specified in previous option")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("cave")
    @ConfigEntry.BoundedDiscrete(max = 100, min = -1)
    public int fixedChanceToConvertSkeletonUnderSelectedYLevel = -1;

    @Comment("Spiders have a chance to convert into stronger variant when they spawn below this Y level")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("cave")
    @ConfigEntry.BoundedDiscrete(max = 300, min = -64)
    public int spiderToArmoredSpiderConvertLevelY = 26;

    @Comment("When this value is below 0, chance of converting increases by 1% with every Y level below value specified in previous option")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("cave")
    @ConfigEntry.BoundedDiscrete(max = 100, min = -1)
    public int fixedChanceToConvertSpiderUnderSelectedYLevel = -1;

    @Comment("Creepers have a chance to convert into stronger variant when they spawn below this Y level")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("cave")
    @ConfigEntry.BoundedDiscrete(max = 300, min = -64)
    public int creeperToCaveCreeperConvertLevelY = 26;

    @Comment("When this value is below 0, chance of converting increases by 1% with every Y level below value specified in previous option")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("cave")
    @ConfigEntry.BoundedDiscrete(max = 100, min = -1)
    public int fixedChanceToConvertCreeperUnderSelectedYLevel = -1;


    //nether
    @Comment("For example, when set to 10, Wither Skeleton will have 10% chance to convert to Executioner after spawning")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("nether")
    @ConfigEntry.BoundedDiscrete(max = 100, min = 0)
    public int witherSkeletonConvertChance = 11;

    @Comment("For example, when set to 10, Ghast will have 10% chance to convert to Nightmare after spawning")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("nether")
    @ConfigEntry.BoundedDiscrete(max = 100, min = 0)
    public int ghastConvertChance = 26;

    @Comment("For example, when set to 10, Piglin will have 10% chance to convert to Infected Piglin after spawning")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("nether")
    @ConfigEntry.BoundedDiscrete(max = 100, min = 0)
    public int piglinConvertChance = 29;

    @Comment("For example, when set to 10, Piglin Brute will have 10% chance to convert to Infected Piglin Brute after spawning")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("nether")
    @ConfigEntry.BoundedDiscrete(max = 100, min = 0)
    public int piglinBruteConvertChance = 39;

    @Comment("For example, when set to 30, Skeleton will have 30% chance to convert to Soul Stealer after spawning (in nether)")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("nether")
    @ConfigEntry.BoundedDiscrete(max = 100, min = 0)
    public int skeletonToSoulStealerConvertChance = 31;

    @Comment("For example, when set to 15, Magma Cube will have 15% chance to convert to Lava Slime after spawning")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("nether")
    @ConfigEntry.BoundedDiscrete(max = 100, min = 0)
    public int magmaCubeToLavaSlimeConvertChance = 19;


    //biomes
    @Comment("For example, when set to 90, Zombie will have 90% chance to convert to Explorer after spawning in jungle, swamp or lush cave")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("biome")
    @ConfigEntry.BoundedDiscrete(max = 100, min = 0)
    public int zombieToExplorerConvertChance = 75;

    @Comment("For example, when set to 90, Zombie will have 90% chance to convert to Frozen Zombie after spawning in snowy biome")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("biome")
    @ConfigEntry.BoundedDiscrete(max = 100, min = 0)
    public int zombieToFrozenZombieConvertChance = 80;

    @Comment("For example, when set to 70, Spider will have 70% chance to convert to Tropical Spider after spawning in jungle")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("biome")
    @ConfigEntry.BoundedDiscrete(max = 100, min = 0)
    public int spiderToTropicalSpiderConvertChance = 75;

    @Comment("For example, when set to 100, Slime will have 100% chance to convert to Toxic Slime after spawning in swamp biomes")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("biome")
    @ConfigEntry.BoundedDiscrete(max = 100, min = 0)
    public int slimeToToxicSlimeConvertChance = 70;


    //mob attributes
    @Comment("Skeletons with enchanted bow always convert to undead warrior with bow")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("mobattributes")
    @ConfigEntry.BoundedDiscrete(max = 100, min = 0)
    public int undeadWarriorSpawnWithBowChance = 50;

    @Comment("20 = 1 second")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("mobattributes")
    public int undeadWarriorsWeaknessDuration = 300;

    @Comment("Nightmare's chance to shoot single fireball (like normal ghast)")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("mobattributes")
    @ConfigEntry.BoundedDiscrete(max = 100, min = 0)
    public int nightmareShootSingleFireballChance = 50;

    @Comment("Additional magic damage dealt by Soul Stealer. On normal difficulty this value is increased by 1. On hard, by 3")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("mobattributes")
    public float soulStealersBaseMagicDamage = 1.0F;

    @ConfigEntry.Category("mobattributes")
    @ConfigEntry.BoundedDiscrete(max = 100, min = 0)
    public int corsairSpawnWithSwordChance = 42;

    @Comment("20 = 1s. Set it to 10 (or lower) to prevent lava from disappearing")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category("mobattributes")
    public int timeToRemoveLavaLeftByLavaSlime = 30;

}
