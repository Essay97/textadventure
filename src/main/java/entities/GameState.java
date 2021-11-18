package entities;

import java.io.Serializable;

public class GameState implements Serializable {
    private static final long serialVersionUID = 8934952566486733250L;

    private boolean isRunning = true;
    private int actionsCount = 0;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public int getActionsCount() {
        return actionsCount;
    }

    public void setActionsCount(int actionsCount) {
        this.actionsCount = actionsCount;
    }

    public void incrementActionsCount() {
        actionsCount++;
    }

    public void decreaseActionsCount() {
        actionsCount--;
    }

    @Override
    public String toString() {
        return "GameState [isRunning=" + isRunning + ", actionsCount=" + actionsCount + "]";
    }



}
