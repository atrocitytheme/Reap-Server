package server.reaptheflag.reaptheflag.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.task.TaskExecutor;
import server.reaptheflag.reaptheflag.udpserver.Starter;
import server.reaptheflag.reaptheflag.udpserver.server.TcpServer;

@Configuration
public class TcpConfiguration {

    private static int port = 9956;

    private Starter tcpStarter;

    private TcpServer tcpServer;

    @Bean
    @DependsOn({"tcpStarter"})
    public CommandLineRunner scheduleTheTcp(TaskExecutor threadPool) {
        return (String... args) -> {
            threadPool.execute(tcpStarter);
        };
    }

    @Bean("tcpStarter")
    @DependsOn({"tcpServer"})
    public Starter tcpStarter() {
        return new Starter(tcpServer);
    }

    @Autowired
    @Qualifier("tcpStarter")
    public void setStarter(Starter tcpStarter) {
        this.tcpStarter = tcpStarter;
    }

    @Bean("tcpServer")
    public TcpServer tcpServer() {
        return new TcpServer(port);
    }

    @Autowired
    @Qualifier("tcpServer")
    public void setUdpServer(TcpServer tcpServer) {
        this.tcpServer = tcpServer;
    }
}
