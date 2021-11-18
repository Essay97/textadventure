package entities.people;

import java.util.ArrayList;
import java.util.List;

import entities.GameMap;
import entities.GrabbableItem;
import entities.Movable;
import entities.Room;
import utils.FighterUtil;

public class Player extends Character implements Movable, Fighter {
    private static final long serialVersionUID = 4369428510876917776L;

    private Room currentRoom;
    private GameMap map;
    private List<GrabbableItem> inventory = new ArrayList<>();
    private int hp;
    private int maxAttack;
    private boolean isDefending;

    public Player(String name, String description) {
        super(name, description);
        getMatchers().add("me");
        getMatchers().add("player");
        maxAttack = 6;
        hp = 1;
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public GameMap getMap() {
        return this.map;
    }

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

    public List<GrabbableItem> getInventory() {
        return inventory;
    }

    public void addInventoryItem(GrabbableItem item) {
        inventory.add(item);
        currentRoom.getItems().remove(item);
    }

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
    public int getMaxAttack() {
        return maxAttack;
    }

}
