package commands.movement;

import commands.BaseCommand;
import entities.GameState;
import entities.Movable;
import entities.people.Player;
import utils.Output;

public abstract class MoveCommand extends BaseCommand {

    private Movable mover;

    public MoveCommand(Movable mover, GameState state) {
        super(state);
        this.mover = mover;
    }

    public Movable getMover() {
        return mover;
    }

    public void setMover(Movable mover) {
        this.mover = mover;
    }

    @Override
    public void doAction() {
        if (canMove()) {
            move();
            printPosition();
        } else {
            System.out.println("I don't think you can go there.");
        }
    }

    @Override
    public void undoAction() {
        moveBack();
        printPosition();
    }

    @Override
    public boolean canUnexecute() {
        return true;
    }

    public abstract boolean canMove();

    public abstract void move();

    public abstract void moveBack();

    private void printPosition() {
        if (mover instanceof Player) {
            Output.position((Player) mover);
        }
    }

}
