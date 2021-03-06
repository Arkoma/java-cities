package com.lambdaschool.cities;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CitiesApplication {

    public static final String EXCHANGE_NAME = "CityServer";
    public static final String QUEUE_NAME_SECRET = "SecretQueue";
    public static final String QUEUE_NAME_CITIES1 = "Cities1Queue";
    public static final String QUEUE_NAME_CITIES2 = "Cities2Queue";

    public static void main(String[] args) {
        SpringApplication.run(CitiesApplication.class, args);
    }

    @Bean
    public TopicExchange appExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding declareBindingSecret() {
        return BindingBuilder.bind(appQueueSecret()).to(appExchange()).with(QUEUE_NAME_SECRET);
    }

    @Bean
    public Queue appQueueSecret() {
        return new Queue(QUEUE_NAME_SECRET);
    }

    @Bean
    public Binding declareBindingCities1() {
        return BindingBuilder.bind(appQueueCities1()).to(appExchange()).with(QUEUE_NAME_CITIES1);
    }

    @Bean
    public Queue appQueueCities1() {
        return new Queue(QUEUE_NAME_CITIES1);
    }

    @Bean
    public Binding declareBindingCities2() {
        return BindingBuilder.bind(appQueueCities2()).to(appExchange()).with(QUEUE_NAME_CITIES2);
    }

    @Bean
    public Queue appQueueCities2() {
        return new Queue(QUEUE_NAME_CITIES2);
    }
}
