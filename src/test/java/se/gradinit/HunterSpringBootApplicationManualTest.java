package se.gradinit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class HunterSpringBootApplicationManualTest {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(HunterSpringBootApplicationManualTest.class);
        app.run(args);
    }

    @Configuration
    public static class HunterTestConfiguration implements WebMvcConfigurer {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**").allowedMethods("*");
        }
    }
}
