package server.reaptheflag.reaptheflag.udpserver.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import server.reaptheflag.reaptheflag.util.DateToolUtil;

public class OnlinePlayer extends Alive{
    protected String ip;
    boolean disConnected;
    int id;
    float timeout; // player disconnects if the timeout consumed
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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setDisConnected(boolean disConnected) {
        this.disConnected = disConnected;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTimeout() {
        return timeout;
    }

    public void setTimeout(float timeout) {
        this.timeout = timeout;
    }
}
