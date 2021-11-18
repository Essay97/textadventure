package entities.people;

import entities.Matchable;

public interface Talker extends Matchable {
    public void talk();
    public void setDialogue(Dialogue dialogue);
}
