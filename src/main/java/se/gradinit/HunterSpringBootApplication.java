package se.gradinit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HunterSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(HunterSpringBootApplication.class);
        app.run(args);
    }
}
