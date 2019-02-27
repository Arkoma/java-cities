package com.lambdaschool.cities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    public static final Logger log = LoggerFactory.getLogger(MessageListener.class);

    @RabbitListener(queues = CitiesApplication.QUEUE_NAME_SECRET)
    public void consumeSecretMessages(Message m) {
        log.info("Consumed secret message: {}", m.toString());
    }

    @RabbitListener(queues = CitiesApplication.QUEUE_NAME_CITIES1)
    public void consumeCities1Messages(Message m) {
        log.info("Consumed Cities 1 Message: {}" + m.toString());
    }

    @RabbitListener(queues = CitiesApplication.QUEUE_NAME_CITIES2)
    public void consumeCities2Messages(Message m) {
        log.info("Consumed Cities 2 Message: {}" + m.toString());
    }
}
