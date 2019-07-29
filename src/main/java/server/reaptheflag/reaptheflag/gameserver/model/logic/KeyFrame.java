package server.reaptheflag.reaptheflag.gameserver.model.logic;

import java.util.List;

public class KeyFrame {
    private int commandType;

    private int amount;

    private String target;

    public int getCommandType() {
        return commandType;
    }

    public void setCommandType(int commandType) {
        this.commandType = commandType;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
