package io.murad.askdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"io.murad.askdev.repository"})
@EnableAsync
public class AskDeveloperApplication {

    public static void main(String[] args) {
        SpringApplication.run(AskDeveloperApplication.class, args);
        
    }

}