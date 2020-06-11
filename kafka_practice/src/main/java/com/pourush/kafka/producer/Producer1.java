package com.pourush.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * Created by pourush.sinha on 10/05/19.
 */
public class Producer1 {

    public static void main(String[] args) {
        String bootrstrapServers = "127.0.0.1:9092";
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootrstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        KafkaProducer<String,String> producer =new KafkaProducer<String, String>(properties);
        ProducerRecord<String,String> producerRecord = new ProducerRecord<String, String>("device_platform_rmtfabricmetadata_v2","hellow_world");
       for(int i =0;i<1000; i++) {
           producer.send(producerRecord);
           producer.flush();
       }
    }
}
