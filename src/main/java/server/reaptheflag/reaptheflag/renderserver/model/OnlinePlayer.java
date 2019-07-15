package server.reaptheflag.reaptheflag.renderserver.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import server.reaptheflag.reaptheflag.util.DateToolUtil;

public abstract class OnlinePlayer extends Alive{
    protected int id;
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
}
