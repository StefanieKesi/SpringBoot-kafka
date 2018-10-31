package com.stefanie.kesi.service;

import java.util.concurrent.ExecutionException;

public interface KafkaService {
    void produceMessage(String message) throws ExecutionException, InterruptedException;
}
