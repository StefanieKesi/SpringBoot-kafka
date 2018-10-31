package com.stefanie.kesi.service.impl;

import com.stefanie.kesi.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class KafkaServiceImpl implements KafkaService {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Override
    public void produceMessage(String message) throws ExecutionException, InterruptedException {
        Future future = kafkaTemplate.send("sun", message);
        future.get();
    }
}
