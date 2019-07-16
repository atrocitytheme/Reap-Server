package server.reaptheflag.reaptheflag.renderserver.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import server.reaptheflag.reaptheflag.util.DateToolUtil;

public class OnlinePlayer extends Alive{
    protected String ip;
    protected boolean disConnected;
    protected int id;
    protected float timeout; // player disconnects if the timeout consumed
    private static final Logger LOGGER = LogManager.getLogger(OnlinePlayer.class);

    @Override
    public void setLife(int life) {
        super.setLife(life);
        if (!isDead) {
            this.life.set(life);
        }
    }

    @Override
    public void die() {
        LOGGER.info("Player with id: " + id + " died! at " + DateToolUtil.logCurrentDate());
    }

    public boolean isDisConnected() {
        return disConnected;
    }

    public void connected(boolean disconnected) {
        this.disConnected = disconnected;
    }

    protected float showTimeout() {
        return timeout;
    }
}
