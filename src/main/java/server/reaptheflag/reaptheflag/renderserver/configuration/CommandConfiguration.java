package server.reaptheflag.reaptheflag.renderserver.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import server.reaptheflag.reaptheflag.renderserver.Handler.commands.Command;
import server.reaptheflag.reaptheflag.renderserver.Handler.commands.PlayerMoveCommand;

@Configuration
public class CommandConfiguration {
    @Bean("moveCommand")
    public Command playerMoveCommand() {
        return new PlayerMoveCommand();
    }
}
