package com.example.javatgbot.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitMQConfig {
    //Stock
    @Value("${queue.stock-info}")
    private String stockQueue;
    @Value("${exchange.stock-info}")
    private String stockExchange;
    @Value("${routing-key.stock-info}")
    private String routingKey_stock;

    //Update
    @Value("${queue.update-recipe}")
    private String updateQueue;
    @Value("${exchange.update-recipe}")
    private String updateExchange;
    @Value("${routing-key.update-recipe}")
    private String routingKey_update;

    //Delete
    @Value("${queue.remove-recipe}")
    private String removeQueue;
    @Value("${exchange.remove-recipe}")
    private String removeExchange;
    @Value("${routing-key.remove-recipe}")
    private String routingKey_remove;

    //Registration
    @Value("${queue.reg-user}")
    private String regQueue;
    @Value("${exchange.reg-user}")
    private String regExchange;
    @Value("${routing-key.reg-user}")
    private String routingKey_reg;

    @Bean
    public Queue createQueue() {
        return new Queue(stockQueue, false);
    }

    @Bean
    public Queue updateQueue() {
        return new Queue(updateQueue, false);
    }

    @Bean
    public Queue removeQueue() {
        return new Queue(removeQueue, false);
    }

    @Bean
    public Queue registrationQueue() {
        return new Queue(regQueue, false);
    }

    @Bean
    public TopicExchange exchangeCreate() {
        return new TopicExchange(stockExchange);
    }

    @Bean
    public TopicExchange exchangeUpdate() {
        return new TopicExchange(updateExchange);
    }

    @Bean
    public TopicExchange exchangeDelete() {
        return new TopicExchange(removeExchange);
    }

    @Bean
    public TopicExchange exchangeRegistration() {
        return new TopicExchange(regExchange);
    }

    @Bean
    public Binding bindingStock() {
        return BindingBuilder
                .bind(createQueue())
                .to(exchangeCreate())
                .with(routingKey_stock);
    }

    @Bean
    public Binding bindingUpdate() {
        return BindingBuilder
                .bind(updateQueue())
                .to(exchangeUpdate())
                .with(routingKey_update);
    }

    @Bean
    public Binding bindingRemove() {
        return BindingBuilder
                .bind(removeQueue())
                .to(exchangeDelete())
                .with(routingKey_remove);
    }

    @Bean
    public Binding bindingRegistration() {
        return BindingBuilder
                .bind(registrationQueue())
                .to(exchangeRegistration())
                .with(routingKey_reg);
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}