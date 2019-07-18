package server.reaptheflag.reaptheflag.udpserver.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import server.reaptheflag.reaptheflag.udpserver.network.rooms.NetworkSpace;

@Configuration
public class NetworkSpaceConfiguration {
    @Bean("space1")
    public NetworkSpace space1() {
        return new NetworkSpace();
    }
}
