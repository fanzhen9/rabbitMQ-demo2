package com.gupaoedu.example.demo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "vipThirdQueue")
public class ThirdConsumer {

    @RabbitHandler
    public void handle(@Payload String msg){
        System.out.println(msg);
    }
}
