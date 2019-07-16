package server.reaptheflag.reaptheflag.renderserver.dispatcher;
/**
 * This is the dispatcher for different types of commands, it'll use differnet command to solve the request
 * TODO: add dispatcher of differenct commands
 * */
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import server.reaptheflag.reaptheflag.renderserver.Handler.PacketHandler;
import server.reaptheflag.reaptheflag.renderserver.network.NetworkUser;

public class CommandEventDispatcher implements Dispatchable{
    private Logger LOGGRE = LogManager.getLogger(CommandEventDispatcher.class);
    public void dispatch(PacketHandler handler, NetworkUser packet) {
        LOGGRE.info("the current packet command is: " + packet.commandType());

        //TODO: add different life condition
    }
}
