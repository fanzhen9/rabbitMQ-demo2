package com.gupaoedu.example.demo;

import com.gupaoedu.example.demo.producer.Producer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class DemoApplicationTests {

    @Autowired
    private Producer producer;

    @Test
    void contextLoads() {
        producer.send();
    }

}
