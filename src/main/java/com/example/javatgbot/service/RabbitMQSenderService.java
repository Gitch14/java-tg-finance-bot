package com.example.javatgbot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMQSenderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Value("${exchange.stock-info}")
    private String stockExchange;
    @Value("${routing-key.stock-info}")
    private String routingKey_stock;

    @Value("${exchange.update-recipe}")
    private String updateExchange;
    @Value("${routing-key.update-recipe}")
    private String routingKey_update;

    @Value("${exchange.remove-recipe}")
    private String removeExchange;
    @Value("${routing-key.remove-recipe}")
    private String routingKey_remove;

    //Registration
    @Value("${exchange.reg-user}")
    private String regExchange;
    @Value("${routing-key.reg-user}")
    private String routingKey_reg;

/*
    public void sendCreateMessage(RecipeDTO recipe) {
        rabbitTemplate.convertAndSend(exchangeCreate, routingKeyCreate, recipe);
        log.info(" [x] Sent to create queue: '" + recipe + "'");
    }

    public void sendUpdateMessage(String message) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("message", message);

        // Convert JSON object to string
        String jsonMessage = jsonObject.toString();
        rabbitTemplate.convertAndSend(updateExchange, routingKey_update, jsonMessage);
        log.info(" [x] Sent to create queue: '" + message + "'");
    }

    public void sendRemoveMessage(String message) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("message", message);

        // Convert JSON object to string
        String jsonMessage = jsonObject.toString();
        rabbitTemplate.convertAndSend(removeExchange, routingKey_remove, jsonMessage);
        log.info(" [x] Sent to create queue: '" + message + "'");
    }

    public void sendRegInfoMessage(User user) {
        rabbitTemplate.convertAndSend(regExchange, routingKey_reg, user);
        log.info(" [x] Sent to registration queue: '" + user + "'");
    }

 */


}
