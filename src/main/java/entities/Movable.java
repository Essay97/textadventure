package entities;

public interface Movable {
    public void moveN();

    public void moveS();

    public void moveW();

    public void moveE();

    public boolean canMoveN();

    public boolean canMoveS();

    public boolean canMoveW();

    public boolean canMoveE();
}
