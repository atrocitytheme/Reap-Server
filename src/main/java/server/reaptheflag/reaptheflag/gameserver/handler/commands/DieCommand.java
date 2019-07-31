package server.reaptheflag.reaptheflag.gameserver.handler.commands;

import server.reaptheflag.reaptheflag.gameserver.game.NetworkRoom;
import server.reaptheflag.reaptheflag.gameserver.game.NetworkSpace;
import server.reaptheflag.reaptheflag.gameserver.model.logic.KeyFrame;
import server.reaptheflag.reaptheflag.gameserver.network.NetworkUser;

public class DieCommand implements Command{

    @Override
    public void execute(NetworkUser client, NetworkSpace space) {
        NetworkRoom room = space.getRoom(client.getRoom());
        KeyFrame frame = new KeyFrame();
        frame.setCommandType(6);
        frame.setTarget(client.getId());
        room.writeFrameToAllExcept(client, frame);
    }
}
