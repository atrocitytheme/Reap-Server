package server.reaptheflag.reaptheflag.configurations;
/**
 * This configuration is bassically for the Udp service when starting up
 * */
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import server.reaptheflag.reaptheflag.renderserver.UdpStarter;

@Configuration
public class UdpConfiguration {
    private static int port = 9956;
    @Bean
    public TaskExecutor UdpBeanExecutor() {
        return new SimpleAsyncTaskExecutor();
    }

    @Bean
    public CommandLineRunner scheduleTheUdp(TaskExecutor UdpBeanExecutor) {
        return (String... args) -> {
            UdpBeanExecutor.execute(new UdpStarter(port));
        };
    }
}
