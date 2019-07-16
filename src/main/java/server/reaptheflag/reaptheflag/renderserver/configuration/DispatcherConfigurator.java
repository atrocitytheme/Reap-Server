package server.reaptheflag.reaptheflag.renderserver.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import server.reaptheflag.reaptheflag.renderserver.dispatcher.CommandEventDispatcher;
import server.reaptheflag.reaptheflag.renderserver.dispatcher.Dispatchable;

@Configuration
public class DispatcherConfigurator {
    @Bean(name = "commandDispatcher")
    public Dispatchable dispatchEvent() {
        return new CommandEventDispatcher();
    }
}
