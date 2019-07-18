package server.reaptheflag.reaptheflag.udpserver.model;

public class Alive extends OnlineObject {
    int life;
    boolean isDead = false;

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }
}
