/*
* Uncomment this datasource configuration if the applicaiton properties change and won;t work
* */

package server.reaptheflag.reaptheflag.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
/*
@Configuration
@Component*/
public class DataSourceConfigure {
/*
    private static String url = "jdbc:mysql://localhost:3306";
*/
  /*  private static String username = "root";
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    @Primary
    public DataSource getDataSource() {
        return DataSourceBuilder.create().url(url).username(username).driverClassName("com.mysql.cj.jdbc.Driver").build();
    }*/
}
