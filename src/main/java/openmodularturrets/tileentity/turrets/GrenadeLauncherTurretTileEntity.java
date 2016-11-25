package openmodularturrets.tileentity.turrets;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import openmodularturrets.entity.projectiles.GrenadeProjectile;
import openmodularturrets.entity.projectiles.TurretProjectile;
import openmodularturrets.handler.ConfigHandler;
import openmodularturrets.init.ModItems;
import openmodularturrets.init.ModSounds;

public class GrenadeLauncherTurretTileEntity extends TurretHead {
    public GrenadeLauncherTurretTileEntity() {
        super();
        this.turretTier = 3;
    }

    @Override
    public int getTurretRange() {
        return ConfigHandler.getGrenadeTurretSettings().getRange();
    }

    @Override
    public int getTurretPowerUsage() {
        return ConfigHandler.getGrenadeTurretSettings().getPowerUsage();
    }

    @Override
    public int getTurretFireRate() {
        return ConfigHandler.getGrenadeTurretSettings().getFireRate();
    }

    @Override
    public double getTurretAccuracy() {
        return ConfigHandler.getGrenadeTurretSettings().getAccuracy() / 10;
    }

    @Override
    public boolean requiresAmmo() {
        return true;
    }

    @Override
    public boolean requiresSpecificAmmo() {
        return true;
    }

    @Override
    public ItemStack getAmmo() {
        return new ItemStack(ModItems.ammoMetaItem,1,3);
    }

    @Override
    public TurretProjectile createProjectile(World world, Entity target, ItemStack ammo) {
        return new GrenadeProjectile(world, ammo, this.getBase());
    }

    @Override
    public SoundEvent getLaunchSoundEffect() {
        return ModSounds.grenadeLaunchSound;
    }
}
