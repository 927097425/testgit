package com.itheima.consumer.mq;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@Component
public class rabitLinsener {

    @RabbitListener(queues = "simple.queue")
    public void linsenSimpleque(String msg){
        log.info("监听到：" + msg);

    }

    @RabbitListener(queues = "work.queue")
    public void linsen1workque(String msg) throws InterruptedException {
        System.out.println("消费者1监听到：" + msg+LocalDateTime.now());
        Thread.sleep(25);

    }
    @RabbitListener(queues = "work.queue")
    public void linsen2workque(String msg) throws InterruptedException {
        log.info("消费者2监听到：" + msg+ LocalDateTime.now());
        Thread.sleep(200);
    }


    @RabbitListener(queues = "direct.queue1")
    public void linsen1fanoutque(String msg) throws InterruptedException {
        System.out.println("消费者1监听到：" + msg+LocalDateTime.now());
        Thread.sleep(25);

    }
    @RabbitListener(queues = "direct.queue2")
    public void linsen2fanoutque(String msg) throws InterruptedException {
        log.info("消费者2监听到：" + msg+ LocalDateTime.now());
        Thread.sleep(200);
    }
}
