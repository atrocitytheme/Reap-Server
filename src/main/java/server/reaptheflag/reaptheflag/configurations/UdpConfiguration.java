package server.reaptheflag.reaptheflag.configurations;
/**
 * This configuration is bassically for the Udp service when starting up
 * */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import org.springframework.core.task.TaskExecutor;
import server.reaptheflag.reaptheflag.gameserver.serverboot.Startable;
import server.reaptheflag.reaptheflag.gameserver.serverboot.UdpServer;
import server.reaptheflag.reaptheflag.gameserver.Starter;

@Configuration
@Order(2)
public class UdpConfiguration {

    private static int port = 9956;
    @Autowired
    private ApplicationContext ctx;

    private Starter starter;

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
        return new Starter((Startable) ctx.getBean("udpServer"));
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
}
