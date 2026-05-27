package centrocomunitario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "centrocomunitario")
@EnableMongoRepositories(basePackages = "centrocomunitario.Repository")
public class CentroComunitarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(CentroComunitarioApplication.class, args);
    }
}