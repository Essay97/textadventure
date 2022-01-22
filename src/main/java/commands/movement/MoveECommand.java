package commands.movement;

import entities.GameState;
import entities.Movable;

/**
 * Move to the East
 */
public class MoveECommand extends MoveCommand {

    public MoveECommand(Movable mover, GameState state) {
        super(mover, state);
    }

    @Override
    public void move() {
        getMover().moveE();
    }

    @Override
    public void moveBack() {
        getMover().moveW();
    }

    @Override
    public boolean canMove() {
        return getMover().canMoveE();
    }

}
