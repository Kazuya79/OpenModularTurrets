package openmodularturrets.items;

import net.minecraft.item.Item;
import openmodularturrets.ModularTurrets;
import openmodularturrets.reference.Names;

class ContainmentChamberItem extends Item {
    public ContainmentChamberItem() {
        super();

        this.setUnlocalizedName(Names.Items.unlocalisedContainmentChamber);
        this.setCreativeTab(ModularTurrets.modularTurretsTab);
    }
}