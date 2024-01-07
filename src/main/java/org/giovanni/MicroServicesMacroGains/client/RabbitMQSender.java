package org.giovanni.MicroServicesMacroGains.client;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class RabbitMQSender {
    @Bean
    public Queue myQueue() {
        return new Queue("myuQueue", false);
    }

    @Bean
    public ApplicationRunner sender(RabbitTemplate template) {
        return args -> {
            template.convertAndSend("myQueue", "Hello from java");
        };
    }
}
