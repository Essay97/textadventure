package entities.items;

import entities.people.Player;
import utils.EquipParts;

public class EquipItem extends GrabbableItem {

    private final EquipParts suitableFor;

    public EquipItem(String name, String description, ItemEffect effect, EquipParts suitableFor) {
        super(name, description, effect);
        this.suitableFor = suitableFor;
    }

    @Override
    public void useOn(Player p) {
        EquipItem current = p.getEquip().get(suitableFor);
        if(current != null) {
            p.addInventoryItem(current);
            current.getEffect().unapplyModifiers(p);
        }
        p.getEquip().put(suitableFor, this);
        getEffect().applyModifiers(p);
    }
}
