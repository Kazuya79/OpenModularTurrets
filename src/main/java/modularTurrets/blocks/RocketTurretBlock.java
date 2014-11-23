package modularTurrets.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import modularTurrets.ModInfo;
import modularTurrets.ModularTurrets;
import modularTurrets.tileentity.turrets.RocketTurretTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class RocketTurretBlock extends BlockContainer {

    public RocketTurretBlock() {
        super(Material.rock);
        this.setBlockName(BlockNames.unlocalisedRocketTurret);
        this.setCreativeTab(ModularTurrets.modularTurretsTab);
        this.setHardness(-1F);
        this.setBlockBounds(1F, 1F, 1F, 1F, 1F, 1F);
        this.setResistance(20F);
        this.setStepSound(Block.soundTypeStone);
    }

    @Override
    public void registerBlockIcons(IIconRegister icon) {
	    blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":turretBaseTierTwo");
    }

    @Override
    public TileEntity createNewTileEntity(World world, int par2) {
	return new RocketTurretTileEntity();
    }

    @Override
    public int getRenderType() {
	return -1;
    }

    @Override
    public boolean isOpaqueCube() {
	return false;
    }
}
