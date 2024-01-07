package org.giovanni.MicroServicesMacroGains.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {
    @RabbitListener(queues = "myQueue")
    public void processMessage(String message) {
        // Perform database operations based on the received message
        // Example:
        // YourDatabaseEntity entity = processMessageAndGetEntity(message);
        // repository.save(entity);
        System.out.println("Received message from RabbitMQ: " + message);
    }
}

