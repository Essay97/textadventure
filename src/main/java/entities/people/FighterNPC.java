package entities.people;

import utils.FighterUtil;

public class FighterNPC extends NPC implements Fighter {
    private static final long serialVersionUID = -1520671022154836530L;

    private int hp;
    private int maxAttack;

    private boolean isDefending;

    public FighterNPC(String name, String description, int maxAttack, int hp) {
        super(name, description);
        this.maxAttack = maxAttack;
        this.hp = hp;
    }

    @Override
    public int getHP() {
        return hp;
    }

    @Override
    public int getAttack() {
        return FighterUtil.getAttack(this);
    }

    @Override
    public void setHP(int hp) {
        this.hp = hp;
    }

    @Override
    public boolean isDefending() {
        return isDefending;
    }

    @Override
    public void setDefending(boolean def) {
        isDefending = def;
    }

    @Override
    public int getMaxAttack() {
        return maxAttack;
    }

}
