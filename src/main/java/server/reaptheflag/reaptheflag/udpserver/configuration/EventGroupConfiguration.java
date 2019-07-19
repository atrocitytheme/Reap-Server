package server.reaptheflag.reaptheflag.udpserver.configuration;

import io.netty.channel.nio.NioEventLoopGroup;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventGroupConfiguration {
    // worker group for handling the requests
    @Bean
    public NioEventLoopGroup worker1() {
        return new NioEventLoopGroup();
    }

    // boss group for the major functionality
    @Bean
    public NioEventLoopGroup boss() {
        return new NioEventLoopGroup(1);
    }
}
