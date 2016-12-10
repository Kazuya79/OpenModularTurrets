package omtteam.openmodularturrets.entity.projectiles;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import omtteam.openmodularturrets.entity.projectiles.damagesources.ArmorBypassDamageSource;
import omtteam.openmodularturrets.entity.projectiles.damagesources.NormalDamageSource;
import omtteam.openmodularturrets.handler.ConfigHandler;
import omtteam.openmodularturrets.tileentity.TurretBase;

import java.util.List;

public class GrenadeProjectile extends TurretProjectile {
    private boolean isAmped;

    public GrenadeProjectile(World par1World) {
        super(par1World);
        this.gravity = 0.00F;
    }

    public GrenadeProjectile(World world, ItemStack ammo, TurretBase turretBase) {
        super(world, ammo, turretBase);
        this.gravity = 0.03F;
    }

    @Override
    public void onEntityUpdate() {
        if (ticksExisted >= 50) {
            if (!worldObj.isRemote) {
                worldObj.createExplosion(null, posX, posY, posZ, 0.1F, true);
                AxisAlignedBB axis = new AxisAlignedBB(this.posX - 3, this.posY - 3, this.posZ - 3,
                                                                  this.posX + 3, this.posY + 3, this.posZ + 3);
                List<EntityLivingBase> targets = worldObj.getEntitiesWithinAABB(EntityLivingBase.class, axis);

                for (Entity mob : targets) {

                    int damage = ConfigHandler.getGrenadeTurretSettings().getDamage();

                    if (isAmped) {
                        if (mob instanceof EntityLivingBase) {
                            EntityLivingBase elb = (EntityLivingBase) mob;
                            damage += ((int) elb.getHealth() * (0.08F * amp_level));
                        }
                    }

                    if (mob instanceof EntityPlayer) {
                        if (canDamagePlayer((EntityPlayer) mob)) {
                            mob.attackEntityFrom(new NormalDamageSource("grenade"), damage * 0.9F);
                            mob.attackEntityFrom(new ArmorBypassDamageSource("grenade"), damage * 0.1F);
                            mob.hurtResistantTime = 0;
                        }
                    } else {
                        mob.attackEntityFrom(new NormalDamageSource("grenade"), damage * 0.9F);
                        mob.attackEntityFrom(new ArmorBypassDamageSource("grenade"), damage * 0.1F);
                        mob.hurtResistantTime = 0;
                    }

                }
            }
            this.setDead();
        }

        for (int i = 0; i <= 20; i++) {
            worldObj.spawnParticle(EnumParticleTypes.REDSTONE, posX, posY, posZ, 1.0D, 1.0D, 1.0D);
        }
    }

    @Override
    protected void onImpact(RayTraceResult movingobjectposition) {
        if (this.ticksExisted >= 2) {
            this.motionX = 0.0F;
            this.motionY = 0.0F;
            this.motionZ = 0.0F;
        }
    }

    @Override
    protected float getGravityVelocity() {
        return this.gravity;
    }
}