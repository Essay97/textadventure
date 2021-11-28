package entities;

import java.io.Serializable;

/**
 * This class gives basic information about the game. Use this to keep track of things like number of actions, running/stop
 * state and so on.
 */
public class GameState implements Serializable {
    private static final long serialVersionUID = 8934952566486733250L;
    /**
     * True if a game is in progress
     */
    private boolean isRunning = true;
    /**
     * Number of countable commands submitted by the player. Some commands, for example <code>save</code>, don't count.
     */
    private int actionsCount = 0;

    /**
     * @return the value of {@link #isRunning}
     */
    public boolean isRunning() {
        return isRunning;
    }

    /**
     * Updates the value returned by {@link #isRunning()}
     * @param isRunning the new value
     */
    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    /**
     * @return the value of {@link #actionsCount}
     */
    public int getActionsCount() {
        return actionsCount;
    }

    /**
     * Updates the value returned by {@link #getActionsCount()}
     * @param actionsCount the new value
     */
    public void setActionsCount(int actionsCount) {
        this.actionsCount = actionsCount;
    }

    /**
     * Increments by a single unit the actions count
     */
    public void incrementActionsCount() {
        actionsCount++;
    }

    /**
     * Decreases by a single unit the actions count
     */
    public void decreaseActionsCount() {
        actionsCount--;
    }

    @Override
    public String toString() {
        return "GameState [isRunning=" + isRunning + ", actionsCount=" + actionsCount + "]";
    }



}
