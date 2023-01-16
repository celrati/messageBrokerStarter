package com.rabbitmq.rabbitmqstarter.consumer;

import com.rabbitmq.rabbitmqstarter.config.MessagingConfig;
import com.rabbitmq.rabbitmqstarter.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class User {

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus) {
        System.out.println("message is received from queue " + orderStatus);
    }

}
