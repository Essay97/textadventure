package entities.people;

import java.util.ArrayList;
import java.util.List;

import entities.*;
import utils.FighterUtil;

/**
 * This is the only entity that can be controlled by the player. This is actually the main actor of the whole thing.
 * The player controls an instance of this class and submits commands mostly to it.
 * <p><code>Player</code> has the ability to move from a room to another and to fight enemies.</p>
 *
 * @see Character
 * @see Movable
 * @see Fighter
 */
public class Player extends Character implements Movable, Fighter {
    private static final long serialVersionUID = 4369428510876917776L;

    /**
     * The room where the player actually is
     */
    private Room currentRoom;
    /**
     * The map of the other reachable rooms
     */
    private GameMap map;
    /**
     * The items that the player has collected along the game
     */
    private List<GrabbableItem> inventory = new ArrayList<>();
    /**
     * The amount of damage that must be taken by the NPC in order to die
     */
    private int hp;
    /**
     * The max damage that can be delivered with a single attack
     */
    private int maxAttack;
    /**
     * When true, the character cannot suffer damage
     */
    private boolean isDefending;
    /**
     * The number of turns the player is burned
     */
    private int burned;
    /**
     * The number of turns the player is stunned
     */
    private int stunned;
    /**
     * The number of turns the player is poisoned
     */
    private int poisoned;
    /**
     * The equipment of the fighter
     */
    private List<ItemEffect> equip = new ArrayList<>();

    public Player(String name, String description) {
        super(name, description);
        getMatchers().add("me");
        getMatchers().add("player");
        maxAttack = 6;
        hp = 1;
    }

    /**
     * @return the room where the player is
     */
    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    /**
     * @param map the object that stores the connections between rooms and maps where the player can go
     */
    public void setMap(GameMap map) {
        this.map = map;
        this.currentRoom = map.getEntry();
    }

    @Override
    public void moveN() {
        currentRoom = map.getN(currentRoom);
    }

    @Override
    public void moveS() {
        currentRoom = map.getS(currentRoom);
    }

    @Override
    public void moveW() {
        currentRoom = map.getW(currentRoom);
    }

    @Override
    public void moveE() {
        currentRoom = map.getE(currentRoom);
    }

    @Override
    public boolean canMoveN() {
        return map.getN(currentRoom) != null;
    }

    @Override
    public boolean canMoveS() {
        return map.getS(currentRoom) != null;
    }

    @Override
    public boolean canMoveW() {
        return map.getW(currentRoom) != null;
    }

    @Override
    public boolean canMoveE() {
        return map.getE(currentRoom) != null;
    }

    @Override
    public String toString() {
        return "Player " + getName() + " [currentRoom=" + currentRoom + "]";
    }

    /**
     * @return the list of all the items collected
     */
    public List<GrabbableItem> getInventory() {
        return inventory;
    }

    /**
     * Adds an item to the inventory
     * @param item the item to be added to {@link #inventory}
     */
    public void addInventoryItem(GrabbableItem item) {
        inventory.add(item);
        currentRoom.getItems().remove(item);
    }

    /**
     * Removes an item from the inventory. This is the opposite of {@link #addInventoryItem(GrabbableItem)}
     * @param item the item to be deleted from {@link #inventory}
     */
    public void removeInventoryItem(GrabbableItem item) {
        inventory.remove(item);
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
        if(def) {
            System.out.println("You are defending!");
        }
        isDefending = def;
    }

    @Override
    public int getStunned() {
        return stunned;
    }

    @Override
    public int getPoisoned() {
        return poisoned;
    }

    @Override
    public int getBurned() {
        return burned;
    }

    @Override
    public void setStunned(int stun) {
        this.stunned = stun;
    }

    @Override
    public void setPoisoned(int poison) {
        this.poisoned = poison;
    }

    @Override
    public void setBurned(int burn) {
        this.burned = burn;
    }


    @Override
    public int getMaxAttack() {
        return maxAttack;
    }

    @Override
    public void setMaxAttack(int newMax) {
        maxAttack = newMax;
    }

    @Override
    public List<ItemEffect> getEquip() {
        return equip;
    }

}
