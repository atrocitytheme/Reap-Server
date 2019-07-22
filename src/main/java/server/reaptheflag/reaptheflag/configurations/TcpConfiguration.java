package server.reaptheflag.reaptheflag.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import org.springframework.core.task.TaskExecutor;
import server.reaptheflag.reaptheflag.udpserver.Starter;
import server.reaptheflag.reaptheflag.udpserver.server.Startable;
import server.reaptheflag.reaptheflag.udpserver.server.TcpServer;

@Configuration
public class TcpConfiguration {

    private static int port = 9956;
    @Autowired
    private ApplicationContext ctx;

    private Starter tcpStarter;

    @Bean
    @DependsOn({"tcpStarter", "tcpServer"})
    public CommandLineRunner scheduleTheTcp(TaskExecutor threadPool ) {
        Starter starter = this.tcpStarter;
        return (String... args) -> {
            threadPool.execute(starter);
        };
    }

    @Bean
    @DependsOn({"tcpServer"})
    public Starter tcpStarter() {
        return new Starter((Startable) ctx.getBean("tcpServer"));
    }

    @Autowired
    @Qualifier("tcpStarter")
    public void setStarter(Starter tcpStarter) {
        this.tcpStarter = tcpStarter;
    }

    @Bean
    public TcpServer tcpServer() {
        return new TcpServer(port);
    }
}
