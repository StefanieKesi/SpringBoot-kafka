package com.stefanie.kesi.util;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

public class KafkaListern {

    @KafkaListener(topics = {"sun"})
    public void listen(ConsumerRecord<?, ?> record) {
        System.out.println("################################### key: " + record.key());
        System.out.println("################################### value: " + record.value().toString());
    }}
