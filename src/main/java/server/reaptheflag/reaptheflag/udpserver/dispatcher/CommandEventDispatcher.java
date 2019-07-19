package server.reaptheflag.reaptheflag.udpserver.dispatcher;
/**
 * This is the dispatcher for different types of commands, it'll use differnet command to solve the request
 * TODO: add dispatcher of differenct commands
 * */
import org.springframework.beans.factory.annotation.Autowired;
import server.reaptheflag.reaptheflag.udpserver.handler.commands.Command;
import server.reaptheflag.reaptheflag.udpserver.network.NetworkUser;
import server.reaptheflag.reaptheflag.udpserver.network.rooms.NetworkSpace;

public class CommandEventDispatcher implements Dispatchable{

    private NetworkSpace space1;

    private CommandDispatchHelper helper;
    public void dispatch(PacketDispatcher handler, NetworkUser client) {
        Command command = helper.takeCommand(client, space1);
        command.execute(client, space1);
    }

    @Autowired
    public void setSpace1(NetworkSpace space1) {
        this.space1 = space1;
    }

    @Autowired
    public void setHelper(CommandDispatchHelper helper) {
        this.helper = helper;
    }
}
