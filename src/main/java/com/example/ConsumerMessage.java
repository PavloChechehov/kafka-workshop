package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerMessage {

//    @KafkaListener(topics = "greeting-topic", groupId = "greeting-group")
//    public void getMessage(String message) {
//      log.info("Received message = {}", message);
//    }


    @KafkaListener(topics = "message-topic", groupId = "message-group")
    public void getNewMessage(String messageDto) {
        log.info("Received new message dto = {}", messageDto);
    }

}
