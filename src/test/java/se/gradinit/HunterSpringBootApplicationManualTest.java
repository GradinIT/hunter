package se.gradinit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HunterSpringBootApplicationManualTest {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(HunterSpringBootApplicationManualTest.class);
        app.run(args);
    }
}
