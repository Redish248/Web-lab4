import config.database.DatabaseConfig;
import entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repository.UserRepository;
import service.UserService;

@SpringBootApplication
@ComponentScan(basePackages = {"service", "repository", "entity", "controller", "impl"})
@EntityScan("entity")
@EnableJpaRepositories("repository")
public class Application{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}