package com.stefanie.kesi.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * producer配置类
 * 2018/10/20
 * StefanieKesi
 */
@EnableKafka
@Configuration
public class KafkaProducerConfig {

    @Value("${kafka.producer.servers}")
    private String servers;
    @Value("${kafka.producer.retries}")
    private int retries;
    @Value("${kafka.producer.batchSize}")
    private int batchSize;
    @Value("${kafka.producer.linger}")
    private int linger;
    @Value("${kafka.producer.bufferMemory}")
    private int bufferMemory;

    public Map<String, Object> producerConfigs() {
        Map<String, Object> proCongig = new HashMap<>();
        proCongig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        proCongig.put(ProducerConfig.RETRIES_CONFIG, retries);
        proCongig.put(ProducerConfig.BATCH_SIZE_CONFIG, batchSize);
        proCongig.put(ProducerConfig.LINGER_MS_CONFIG, linger);
        proCongig.put(ProducerConfig.BUFFER_MEMORY_CONFIG, bufferMemory);
        proCongig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        proCongig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return proCongig;
    }

    public ProducerFactory<String, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<String, String>(producerFactory());
    }
}
