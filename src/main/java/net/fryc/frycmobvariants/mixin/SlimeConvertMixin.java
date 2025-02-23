package net.fryc.frycmobvariants.mixin;

import net.fryc.frycmobvariants.MobVariants;
import net.fryc.frycmobvariants.mobs.ModMobs;
import net.fryc.frycmobvariants.mobs.biome.ToxicSlimeEntity;
import net.fryc.frycmobvariants.mobs.nether.LavaSlimeEntity;
import net.fryc.frycmobvariants.tags.ModBiomeTags;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MagmaCubeEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(SlimeEntity.class)
abstract class SlimeConvertMixin extends MobEntity implements Monster {

    boolean canConvert = true;
    Random random = new Random();

    protected SlimeConvertMixin(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "tick()V", at = @At("TAIL"))
    private void convertSlimeVariant(CallbackInfo ci) {
        SlimeEntity slime = ((SlimeEntity)(Object)this);
        if(!slime.getWorld().isClient){
            if(slime.hasStatusEffect(StatusEffects.NAUSEA)) canConvert = false;
            if(canConvert){
                int size = slime.getSize();
                if(slime.getClass() == SlimeEntity.class){
                    int i = (int)slime.getY();
                    if(slime.getWorld().getBiome(slime.getBlockPos()).isIn(ModBiomeTags.TOXIC_SLIME_SPAWN_BIOMES) && i > 48){
                        if(random.nextInt(0, 100) <= MobVariants.config.slimeToToxicSlimeConvertChance){
                            ToxicSlimeEntity toxicSlime = slime.convertTo(ModMobs.TOXIC_SLIME, false);
                            if(toxicSlime != null){
                                toxicSlime.setSize(size, true);
                            }
                        }
                    }
                }
                else if(slime.getClass() == MagmaCubeEntity.class){
                    if(random.nextInt(0, 100) <= MobVariants.config.magmaCubeToLavaSlimeConvertChance){
                        LavaSlimeEntity lavaSlime = slime.convertTo(ModMobs.LAVA_SLIME, false);
                        if(lavaSlime != null){
                            lavaSlime.setSize(size, true);
                        }
                    }
                }
                canConvert = false;
            }
        }
    }

    // giving nausea to slimes spawned after killing larger slime (nausea prevents from converting)
    @ModifyVariable(method = "remove(Lnet/minecraft/entity/Entity$RemovalReason;)V", at = @At("STORE"))
    private SlimeEntity preventBabiesFromConverting(SlimeEntity slime) {
        slime.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 10, 0, false, false, false));
        return slime;
    }



    //reading canConvert from Nbt
    @Inject(method = "Lnet/minecraft/entity/mob/SlimeEntity;readCustomDataFromNbt(Lnet/minecraft/nbt/NbtCompound;)V", at = @At("TAIL"))
    private void readCanConvertFromNbt(NbtCompound nbt, CallbackInfo ci) {
        if(nbt.contains("MobVariantsCanConvert")){
            NbtCompound nbtCompound = nbt.getCompound("MobVariantsCanConvert");
            canConvert = nbtCompound.getBoolean("canConvert");
        }
    }

    //writing canConvert to Nbt
    @Inject(method = "Lnet/minecraft/entity/mob/SlimeEntity;writeCustomDataToNbt(Lnet/minecraft/nbt/NbtCompound;)V", at = @At("TAIL"))
    private void writeCanConvertToNbt(NbtCompound nbt, CallbackInfo ci) {
        if(!canConvert){
            NbtCompound nbtCompound = new NbtCompound();
            nbtCompound.putBoolean("canConvert", canConvert);
            nbt.put("MobVariantsCanConvert", nbtCompound);
        }
    }


}
