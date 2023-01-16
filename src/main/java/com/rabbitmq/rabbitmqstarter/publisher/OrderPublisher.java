package com.rabbitmq.rabbitmqstarter.publisher;

import com.rabbitmq.rabbitmqstarter.config.MessagingConfig;
import com.rabbitmq.rabbitmqstarter.dto.Order;
import com.rabbitmq.rabbitmqstarter.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderPublisher {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/{restaurantName}")
    public String bookOrder(@RequestBody Order order, @PathVariable String restaurantName) {
        order.setOrderId(UUID.randomUUID().toString());
        OrderStatus orderStatus = OrderStatus.builder()
                .order(order)
                .status("PROCESS")
                .message("Order placed succesfully in " + restaurantName)
                .build();
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTINGKEY, orderStatus);
        return "SUCCES";
    }
}
