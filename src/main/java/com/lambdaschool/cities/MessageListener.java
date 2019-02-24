package com.lambdaschool.cities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class MessageListener {

    public static final Logger log = LoggerFactory.getLogger(MessageListener.class);

    @RabbitListener
    public void consumeMessages(Message m) {
        log.info("Consumed message: {}", m.toString());
    }
}
