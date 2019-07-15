package server.reaptheflag.reaptheflag.renderserver.dispatcher;
/**
 * This is the dispatcher for different types of commands, it'll use differnet command to solve the request
 * */
import io.netty.channel.socket.DatagramPacket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import server.reaptheflag.reaptheflag.renderserver.Handler.PacketHandler;

public class CommandEventDispatcher {
    private Logger LOGGRE = LogManager.getLogger(CommandEventDispatcher.class);
    public void handle(PacketHandler handler, DatagramPacket packet) {
        LOGGRE.info("the current packet command is: ");
    }
}
