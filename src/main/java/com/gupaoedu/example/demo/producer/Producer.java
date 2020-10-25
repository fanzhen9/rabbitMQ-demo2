package com.gupaoedu.example.demo.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {



    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        amqpTemplate.convertAndSend("vipDirectExchange","gupao.best","vipDirectExchange:gupao.best");
        amqpTemplate.convertAndSend("vipTopicExchange", "apple.gupao.apple", "vipTopicExchange:apple.gupao.apple");
        amqpTemplate.convertAndSend("vipTopicExchange", "banana.gupao.banana", "vipTopicExchange:banana.gupao.banana");
        amqpTemplate.convertAndSend("vipTopicExchange", "pear.gupao.pear", "vipTopicExchange:pear.gupao.pear");
        amqpTemplate.convertAndSend("vipTopicExchange", "lemon.gupao.lemon", "vipTopicExchange:lemon.gupao.lemon");
        amqpTemplate.convertAndSend("vipFanoutExchange","","vipFanoutExchange:hello ");
    }
}
