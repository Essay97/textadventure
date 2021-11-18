package entities.people;

import java.io.Serializable;

@FunctionalInterface
public interface Dialogue extends Serializable {
    public void doDialogue();
}
