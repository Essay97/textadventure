package entities;

import entities.people.Fighter;

public abstract class ItemEffect {
    private int HPModifier;
    private int attackModifier;
    private int burnModifier;
    private int poisonModifier;
    private int stunModifier;
    private boolean oneShot;

    public int getHPModifier() {
        return HPModifier;
    }

    public int getAttackModifier() {
        return attackModifier;
    }

    public int getBurnModifier() {
        return burnModifier;
    }

    public int getPoisonModifier() {
        return poisonModifier;
    }

    public int getStunModifier() {
        return stunModifier;
    }

    public boolean isOneShot() {
        return oneShot;
    }

    /**
     * This function applies all the modifiers expressed by the ItemEffect.
     * @param fighter the fighter to whom the modifiers must be applied
     * @return true if the ItemEffect must be destroyed after the use, false otherwise
     */
    public boolean applyModifiers(Fighter fighter) {
        if(oneShot) {
            fighter.setHP(fighter.getHP() + HPModifier);
            fighter.setMaxAttack(fighter.getHP() + HPModifier);
            fighter.setPoisoned(fighter.getPoisoned() + poisonModifier);
            fighter.setStunned(fighter.getStunned() + stunModifier);
            fighter.setBurned(fighter.getBurned() + burnModifier);
            return true;
        } else {
            fighter.getEquip().add(this);
        }
        return false;
    }
}
