package server.reaptheflag.reaptheflag.configurations;
/**
 * This configuration is bassically for the Udp service when starting up
 * */
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.task.TaskExecutor;
import server.reaptheflag.reaptheflag.udpserver.server.TcpServer;
import server.reaptheflag.reaptheflag.udpserver.server.UdpServer;
import server.reaptheflag.reaptheflag.udpserver.Starter;

@Configuration
public class UdpConfiguration {

    private static int port = 9956;

    private Starter starter;

    private UdpServer udpServer;

    private static Logger LOGGER = LogManager.getLogger(UdpConfiguration.class);

    @Bean
    @DependsOn({"udpStarter", "udpServer"})
    public CommandLineRunner scheduleTheUdp(TaskExecutor threadPool) {
        return (String... args) -> {
            threadPool.execute(this.starter);
        };
    }

    @Bean
    @DependsOn({"udpServer"})
    public Starter udpStarter() {
        return new Starter(udpServer);
    }

    @Autowired
    @Qualifier("udpStarter")
    public void setUdpStarter(Starter udpStarter) {
        this.starter = udpStarter;
    }

    @Bean
    public UdpServer udpServer() {
        return new UdpServer(port);
    }

    @Autowired
    @Qualifier("udpServer")
    public void setUdpServer(UdpServer udpServer) {
        this.udpServer = udpServer;
    }
}
