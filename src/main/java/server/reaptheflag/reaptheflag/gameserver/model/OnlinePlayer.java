package server.reaptheflag.reaptheflag.gameserver.model;

public class OnlinePlayer extends Alive {
    public boolean isShooting() {
        return isShooting;
    }

    public void setShooting(boolean shooting) {
        isShooting = shooting;
    }

    private boolean isShooting;
}
