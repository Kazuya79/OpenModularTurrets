package openmodularturrets.blocks.expanders;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import openmodularturrets.ModularTurrets;
import openmodularturrets.reference.Names;
import openmodularturrets.tileentity.expander.ExpanderInvTierOneTileEntity;

public class BlockExpanderInvTierOne extends BlockExpanderInvAbstract {
    public BlockExpanderInvTierOne() {
        super(Material.rock);
        this.setCreativeTab(ModularTurrets.modularTurretsTab);
        this.setResistance(3.0F);
        this.setStepSound(Block.soundTypeStone);
        this.setUnlocalizedName(Names.Blocks.unlocalisedExpanderInvTierOne);
        this.setBlockBounds(0.1F, 0.1F, 0.1F, 0.9F, 0.9F, 0.9F);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int par2) {
        return new ExpanderInvTierOneTileEntity();
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
