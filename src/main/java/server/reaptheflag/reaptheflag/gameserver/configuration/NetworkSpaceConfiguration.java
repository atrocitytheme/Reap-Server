package server.reaptheflag.reaptheflag.gameserver.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import server.reaptheflag.reaptheflag.gameserver.context.rooms.NetworkSpace;

@Configuration
public class NetworkSpaceConfiguration {
    @Bean("space1")
    public NetworkSpace space1() {
        return new NetworkSpace();
    }
}
