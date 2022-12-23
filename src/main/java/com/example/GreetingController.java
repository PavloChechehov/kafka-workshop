package com.example;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class GreetingController {

//    private final KafkaTemplate<String, MessageDto> template;
    @Value("${kafka.topics.message-topic}")
    private String messageTopic;
    private final KafkaProducer<String, MessageDto> producer;

//    @PostMapping("/greeting")
//    public void greeting(@RequestBody String message) {
//        log.info("Message sent {}", message);
//        template.send("greeting-topic", message);
//        log.info("Message was sent {}", message);
//    }

    @PostMapping("/messages")
    public void sendMessage(@RequestBody String message) {
        MessageDto greeting = new MessageDto("Greeting", "message");
        producer.send(new ProducerRecord<>(messageTopic, UUID.randomUUID().toString(), greeting));
//        template.send(messageTopic, message);
    }


}
