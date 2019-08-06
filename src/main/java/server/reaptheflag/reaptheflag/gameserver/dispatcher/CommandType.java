package server.reaptheflag.reaptheflag.gameserver.dispatcher;

public enum CommandType {
    DIE(6),
    SPREAD_DATA(7),
    DISCONNECT(11),
    CONNECTION_TRY(101),
    SPAWN(0),
    MOVE(1),
    OB(10),
    FORCE_EXIT(2), // server exclusive
    SYNC_TIME(3);// used exclusively by server

    private final int ord;

    CommandType(int num) {
        ord = num;
    }

    public int commandType() {
        return ord;
    }
}
