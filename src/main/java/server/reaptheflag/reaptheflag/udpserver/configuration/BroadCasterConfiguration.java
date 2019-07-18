package server.reaptheflag.reaptheflag.udpserver.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import server.reaptheflag.reaptheflag.udpserver.network.broadcast.BatchBroadcaster;
import server.reaptheflag.reaptheflag.udpserver.network.rooms.NetworkSpace;

@Configuration
@EnableScheduling
public class BroadCasterConfiguration {
    private BatchBroadcaster machine1;
    private NetworkSpace space;
    // frame synchronization
    @Scheduled(cron = "0/2 * * * * *")
    public void frameworkUpdate() {
        machine1.broadCast(space);
    }

    @Autowired
    public void setMachine1(BatchBroadcaster machine1) {
        this.machine1 = machine1;
    }

    @Autowired
    public void setSpace(NetworkSpace space) {
        this.space = space;
    }
}
