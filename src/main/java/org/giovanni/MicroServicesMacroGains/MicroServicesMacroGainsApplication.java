package org.giovanni.MicroServicesMacroGains;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MicroServicesMacroGainsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServicesMacroGainsApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner(RabbitTemplate template) {
        return args -> {
            template.convertAndSend("myQueue", "Hello from java...");
        };
    }
}
