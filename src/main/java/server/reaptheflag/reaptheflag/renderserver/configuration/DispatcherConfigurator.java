package server.reaptheflag.reaptheflag.renderserver.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import server.reaptheflag.reaptheflag.renderserver.dispatcher.CommandEventDispatcher;

@Configuration
public class DispatcherConfigurator {
    @Bean(name = "commandDispatcher")
    public CommandEventDispatcher dispatchEvent() {
        return new CommandEventDispatcher();
    }
}
