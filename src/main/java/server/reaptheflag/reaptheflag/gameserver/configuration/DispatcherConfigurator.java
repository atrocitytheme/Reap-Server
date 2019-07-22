package server.reaptheflag.reaptheflag.gameserver.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import server.reaptheflag.reaptheflag.gameserver.dispatcher.CommandEventDispatcher;

@Configuration
public class DispatcherConfigurator {
    @Bean(name = "commandDispatcher")
    public CommandEventDispatcher dispatchEvent() {
        return new CommandEventDispatcher();
    }
}
