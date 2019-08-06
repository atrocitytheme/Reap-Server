package server.reaptheflag.reaptheflag.gameserver.model.logic;

public class TimeoutFrame extends KeyFrame{
    public int getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }

    private int timeLeft;
}
