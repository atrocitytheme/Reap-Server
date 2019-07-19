package server.reaptheflag.reaptheflag.udpserver.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import server.reaptheflag.reaptheflag.udpserver.handler.commands.Command;
import server.reaptheflag.reaptheflag.udpserver.handler.commands.PlayerMoveCommand;

@Configuration
public class CommandConfiguration {
    @Bean("moveCommand")
    public Command playerMoveCommand() {
        return new PlayerMoveCommand();
    }
}
