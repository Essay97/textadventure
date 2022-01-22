package commands;

import entities.Examinable;
import entities.GameState;

/**
 * Gain information about a specific target. It is triggered by the word <code>examine</code>
 */
public class ExamineCommand extends BaseCommand {

    /**
     * The item you want to gain information about
     */
    private Examinable item;

    public ExamineCommand(Examinable item, GameState state) {
        super(state);
        this.item = item;
    }

    @Override
    public void doAction() {
        if (item != null) {
            System.out.println(item.examine());
        } else {
            System.out.println("Sorry, can you repeat?");
        }

    }

    @Override
    public void undoAction() {
        throw new UnsupportedOperationException(getClass().getSimpleName() + " cannot be unexecuted");
    }

    @Override
    public boolean canUnexecute() {
        return false;
    }

}
