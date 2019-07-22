package server.reaptheflag.reaptheflag.gameserver.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import server.reaptheflag.reaptheflag.gameserver.handler.commands.Command;
import server.reaptheflag.reaptheflag.gameserver.handler.commands.PlayerMoveCommand;

@Configuration
public class CommandConfiguration {
    @Bean("moveCommand")
    public Command playerMoveCommand() {
        return new PlayerMoveCommand();
    }
}
