package cr.ac.ucr.spa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication @ComponentScan({"cr.ac.ucr.controller", "cr.ac.ucr.repository", "cr.ac.ucr.service"})
@EnableJpaRepositories("cr.ac.ucr.repository")
public class SpaApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpaApplication.class, args);
    }


    @GetMapping("/greet")
    public String greet(@RequestParam(value = "myName", defaultValue = "World") String name){
        return String.format("Hello %s!", name);
    }
}
