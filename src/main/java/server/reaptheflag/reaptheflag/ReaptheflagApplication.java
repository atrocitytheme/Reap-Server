package server.reaptheflag.reaptheflag;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("serverboot.reaptheflag.reaptheflag.dao")
public class ReaptheflagApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReaptheflagApplication.class, args);
    }

}
