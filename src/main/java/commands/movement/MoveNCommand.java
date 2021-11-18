package commands.movement;

import entities.GameState;
import entities.Movable;

public class MoveNCommand extends MoveCommand {

    public MoveNCommand(Movable mover, GameState state) {
        super(mover, state);
    }

    @Override
    public void move() {
        getMover().moveN();
    }

    @Override
    public void moveBack() {
        getMover().moveS();
    }

    @Override
    public boolean canMove() {
        return getMover().canMoveN();
    }

}
