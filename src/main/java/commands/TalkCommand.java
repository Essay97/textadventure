package commands;

import entities.GameState;
import entities.people.Talker;

/**
 * Starts a dialogue sequence with a specific target. It is triggered by the word <code>talk</code>
 */
public class TalkCommand extends BaseCommand {

    private final Talker talker;

    public TalkCommand(GameState state, Talker talker) {
        super(state);
        this.talker = talker;
    }

    @Override
    public boolean canUnexecute() {
        return false;
    }

    @Override
    public void doAction() {
        if(talker != null) {
            talker.talk();
        } else {
            System.out.println("No one called like that will talk with you.");
        }

    }

    @Override
    public void undoAction() {
        throw new UnsupportedOperationException(getClass().getSimpleName() + " cannot be unexecuted");
    }

}
