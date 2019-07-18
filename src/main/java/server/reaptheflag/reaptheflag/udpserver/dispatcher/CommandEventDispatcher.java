package server.reaptheflag.reaptheflag.udpserver.dispatcher;
/**
 * This is the dispatcher for different types of commands, it'll use differnet command to solve the request
 * TODO: add dispatcher of differenct commands
 * */
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import server.reaptheflag.reaptheflag.udpserver.Handler.commands.NullCommand;
import server.reaptheflag.reaptheflag.udpserver.Handler.commands.PlayerMoveCommand;
import server.reaptheflag.reaptheflag.udpserver.network.NetworkUser;
import server.reaptheflag.reaptheflag.udpserver.network.rooms.NetworkSpace;

public class CommandEventDispatcher implements Dispatchable{

    private NetworkSpace space1;
    private Logger LOGGRE = LogManager.getLogger(CommandEventDispatcher.class);
    public void dispatch(PacketHandler handler, NetworkUser client) {
        LOGGRE.info("the current packet command is: " + client.commandType());

        //TODO: add different life condition
        if (client.commandType() == 0) {
            new NullCommand().execute(client, space1.getRoom(0));
        }

        else if (client.commandType() == 1) {
            new PlayerMoveCommand().execute(client, space1.getRoom(0));
        }
    }

    @Autowired
    public void setSpace(NetworkSpace space) {
        this.space1 = space;
    }
}
