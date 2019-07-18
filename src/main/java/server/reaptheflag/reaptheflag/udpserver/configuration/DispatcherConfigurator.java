package server.reaptheflag.reaptheflag.udpserver.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import server.reaptheflag.reaptheflag.udpserver.dispatcher.CommandEventDispatcher;
import server.reaptheflag.reaptheflag.udpserver.dispatcher.Dispatchable;

@Configuration
public class DispatcherConfigurator {
    @Bean(name = "commandDispatcher")
    public CommandEventDispatcher dispatchEvent() {
        return new CommandEventDispatcher();
    }
}
