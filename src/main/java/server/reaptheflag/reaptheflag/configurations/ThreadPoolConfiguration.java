package server.reaptheflag.reaptheflag.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadPoolConfiguration {
    /*@Bean
    public TaskExecutor UdpBeanExecutor() {
        return new SimpleAsyncTaskExecutor();
    }*/

    @Bean
    public TaskExecutor threadPool() {
        return new ThreadPoolTaskExecutor();
    }
}
