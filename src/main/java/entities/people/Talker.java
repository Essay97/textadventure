package entities.people;

import commands.actions.TalkCommand;
import entities.Matchable;

/**
 * The interface gives the ability to use te <code>talk</code> command.
 * Instances of a class that implements this interface can be passed as an argument to {@link TalkCommand}.
 * It also adds the ability to be targeted as a command argument (not only for the <code>talk</code> command but also
 * for all the other ones such as <code>examine</code>)
 *
 * @see TalkerNPC
 * @see FighterTalkerNPC
 * @see Dialogue
 * @see DialogueTemplate
 * @see DialogueChunk
 * @see TalkCommand
 */
public interface Talker extends Matchable {
    /**
     * Starts the {@link Dialogue} sequence
     */
    void talk();

    /**
     * Updates the dialogue sequence
     * @param dialogue the new dialogue sequence
     */
    void setDialogue(Dialogue dialogue);
}
