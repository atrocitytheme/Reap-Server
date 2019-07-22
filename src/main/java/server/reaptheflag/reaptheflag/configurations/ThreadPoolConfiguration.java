package server.reaptheflag.reaptheflag.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadPoolConfiguration {
    @Bean
    public TaskExecutor simpleTask() {
        return new SimpleAsyncTaskExecutor();
    }

    @Bean
    public TaskExecutor threadPool() {
        ThreadPoolTaskExecutor exe = new ThreadPoolTaskExecutor();
        exe.setCorePoolSize(5);
        exe.setMaxPoolSize(10);
        exe.setQueueCapacity(8);
        return exe;
    }
}
