package net.fryc.frycmobvariants.mixin;


import net.fryc.frycmobvariants.MobVariants;
import net.fryc.frycmobvariants.mobs.ModMobs;
import net.minecraft.client.render.entity.feature.SkinOverlayOwner;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(CreeperEntity.class)
abstract class CreeperConvertMixin extends HostileEntity implements SkinOverlayOwner {

    boolean canConvert = true;
    Random random = new Random();

    protected CreeperConvertMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    //converts creeper to cave creeper
    //only first mob tick (right after spawning) tries to convert it
    @Inject(at = @At("TAIL"), method = "tick()V")
    public void convertToForgotten(CallbackInfo info) {
        CreeperEntity creeper = ((CreeperEntity)(Object)this);
        if(!creeper.getWorld().isClient){
            if(creeper.hasStatusEffect(StatusEffects.NAUSEA)) canConvert = false;
            if(canConvert){
                if(creeper.getClass() == CreeperEntity.class){
                    int i = (int)creeper.getY();
                    if(i < MobVariants.config.creeperToCaveCreeperConvertLevelY){
                        boolean bl = false;
                        if(MobVariants.config.fixedChanceToConvertCreeperUnderSelectedYLevel > -1){
                            if(random.nextInt(0,100) <= MobVariants.config.fixedChanceToConvertCreeperUnderSelectedYLevel){
                                bl = true;
                            }
                        }
                        else if(random.nextInt(i, 100 + i) < MobVariants.config.creeperToCaveCreeperConvertLevelY){ // ~26% to convert on 0Y level (default)
                            bl = true;
                        }

                        if(bl){
                            creeper.convertTo(ModMobs.CAVE_CREEPER, false);
                        }
                    }
                    canConvert = false;
                }
            }
        }
    }

    //reading canConvert from Nbt
    @Inject(method = "Lnet/minecraft/entity/mob/CreeperEntity;readCustomDataFromNbt(Lnet/minecraft/nbt/NbtCompound;)V", at = @At("TAIL"))
    private void readCanConvertFromNbt(NbtCompound nbt, CallbackInfo ci) {
        if(nbt.contains("MobVariantsCanConvert")){
            NbtCompound nbtCompound = nbt.getCompound("MobVariantsCanConvert");
            canConvert = nbtCompound.getBoolean("canConvert");
        }
    }

    //writing canConvert to Nbt
    @Inject(method = "Lnet/minecraft/entity/mob/CreeperEntity;writeCustomDataToNbt(Lnet/minecraft/nbt/NbtCompound;)V", at = @At("TAIL"))
    private void writeCanConvertToNbt(NbtCompound nbt, CallbackInfo ci) {
        if(!canConvert){
            NbtCompound nbtCompound = new NbtCompound();
            nbtCompound.putBoolean("canConvert", canConvert);
            nbt.put("MobVariantsCanConvert", nbtCompound);
        }
    }

}
