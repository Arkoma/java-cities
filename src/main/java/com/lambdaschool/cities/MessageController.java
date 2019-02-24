package com.lambdaschool.cities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Random;

@RestController
@RequestMapping("/cities")
public class MessageController {

    public static final Logger log = LoggerFactory.getLogger(MessageController.class);

    private final RabbitTemplate rt;
    private final CityRepository repository;

    public MessageController(RabbitTemplate rt, CityRepository repository) {
        this.rt = rt;
        this.repository = repository;
    }

    @GetMapping("/afford")
    public void getAffordableCities() {
        ArrayList<City> cities = new ArrayList<>();

        cities.addAll(repository.findAll());

        for (City c: cities) {
            boolean secret = new Random().nextBoolean();
            final Message message = new Message(c.toString(), c.getAffordabilityIndex(), secret);
            if (message.isSecret()) {
                rt.convertAndSend(CitiesApplication.QUEUE_NAME_SECRET);
            } else  {
                if(message.getPriority() < 6) {
                    rt.convertAndSend(CitiesApplication.QUEUE_NAME_CITIES1);
                } else {
                    rt.convertAndSend(CitiesApplication.QUEUE_NAME_CITIES2);
                }
            }
        }
    }
}
