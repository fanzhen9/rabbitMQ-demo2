package com.gupaoedu.example.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean("vipFirstQueue")
    public Queue initFirstQueue(){
        return new Queue("vipFirstQueue");
    }
    @Bean("vipSecondQueue")
    public Queue initSecondQueue(){
        return new Queue("vipSecondQueue");
    }
    @Bean("vipThirdQueue")
    public Queue initThirdQueue(){
        return new Queue("vipThirdQueue");
    }
    @Bean("vipFourthQueue")
    public Queue initFourthQueue(){
        return new Queue("vipFourthQueue");
    }

    @Bean("vipDirectExchange")
    public DirectExchange initDirectExchange(){
        return new DirectExchange("vipDirectExchange");
    }

    @Bean("vipTopicExchange")
    public TopicExchange initTopicExchange(){
        return new TopicExchange("vipTopicExchange");
    }

    @Bean("vipFanoutExchange")
    public FanoutExchange initFanoutExchange(){
        return new FanoutExchange("vipFanoutExchange");
    }

    @Bean
    public Binding bindFirst(@Qualifier("vipFirstQueue")Queue queue,@Qualifier("vipDirectExchange")DirectExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("gupao.best");
    }
    @Bean
    public Binding bindSecond(@Qualifier("vipSecondQueue")Queue queue,@Qualifier("vipTopicExchange")TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("*.gupao.*");
    }
    @Bean
    public Binding bindThird(@Qualifier("vipThirdQueue")Queue queue,@Qualifier("vipFanoutExchange")FanoutExchange exchange){
        return BindingBuilder.bind(queue).to(exchange);
    }
    @Bean
    public Binding bindFourth(@Qualifier("vipFourthQueue")Queue queue,@Qualifier("vipFanoutExchange")FanoutExchange exchange){
        return BindingBuilder.bind(queue).to(exchange);
    }
}
