package server.reaptheflag.reaptheflag.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import server.reaptheflag.reaptheflag.interceptor.UdpServerInitializationInterceptor;

@Configuration
public class UdpServerInitializationInterceptorConfig implements WebMvcConfigurer {
    @Autowired
    UdpServerInitializationInterceptor interceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor);
    }
}
