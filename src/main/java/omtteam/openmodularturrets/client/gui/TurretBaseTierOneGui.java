package omtteam.openmodularturrets.client.gui;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import omtteam.openmodularturrets.client.gui.containers.TurretBaseTierOneContainer;
import omtteam.openmodularturrets.reference.OMTNames;
import omtteam.openmodularturrets.tileentity.TurretBase;
import org.lwjgl.opengl.GL11;

public class TurretBaseTierOneGui extends TurretBaseAbstractGui {
    public TurretBaseTierOneGui(InventoryPlayer inventoryPlayer, TurretBase tileEntity) {
        super(inventoryPlayer, tileEntity, new TurretBaseTierOneContainer(inventoryPlayer, tileEntity));
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        ResourceLocation texture = (new ResourceLocation(OMTNames.Textures.turretBaseTierOneGUI));
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(texture);
        this.drawEnergyBar();
    }
}