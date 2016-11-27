package omtteam.openmodularturrets.blocks.turretheads;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import omtteam.openmodularturrets.reference.Names;
import omtteam.openmodularturrets.tileentity.turrets.GunTurretTileEntity;

public class BlockGunTurret extends BlockAbstractTurretHead {
    public BlockGunTurret() {
        super();

        this.setUnlocalizedName(Names.Blocks.gunTurret);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int par2) {
        return new GunTurretTileEntity();
    }
}