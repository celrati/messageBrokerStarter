package com.rabbitmq.rabbitmqstarter.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class OrderStatus {

    private Order order;
    private String status; // progress, completed
    private String message;
}
