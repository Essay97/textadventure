package commands.movement;

import entities.GameState;
import entities.Movable;

/**
 * Move to the West
 */
public class MoveWCommand extends MoveCommand {

    public MoveWCommand(Movable mover, GameState state) {
        super(mover, state);
    }

    @Override
    public void move() {
        getMover().moveW();
    }

    @Override
    public void moveBack() {
        getMover().moveE();
    }

    @Override
    public boolean canMove() {
        return getMover().canMoveW();
    }

}
