package com.itheima.publisher;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PublisherApplicationTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    public void testSimpleQueue(){
        for (int i = 0; i < 50; i++) {
            String queueName = "hmall.direct";
            String msg = "hello,spring amqp"+String.valueOf(i);
            rabbitTemplate.convertAndSend(queueName,"yellow",msg);
        }
    }
}