package commands.movement;

import entities.GameState;
import entities.Movable;

/**
 * Move to the South
 */
public class MoveSCommand extends MoveCommand {

    public MoveSCommand(Movable mover, GameState state) {
        super(mover, state);
    }

    @Override
    public void move() {
        getMover().moveS();
    }

    @Override
    public void moveBack() {
        getMover().moveN();
    }

    @Override
    public boolean canMove() {
        return getMover().canMoveS();
    }
}
