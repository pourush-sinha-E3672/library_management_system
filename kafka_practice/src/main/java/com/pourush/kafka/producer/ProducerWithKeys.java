package com.pourush.kafka.producer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * Created by pourush.sinha on 11/05/19.
 */
public class ProducerWithKeys {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final Logger logger = LoggerFactory.getLogger(ProducerWithKeys.class);
        String bootrstrapServers = "127.0.0.1:9092";
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootrstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        KafkaProducer<String,String> producer =new KafkaProducer<String, String>(properties);
        for(int i =0;i<10000; i++) {
            String topic ="utsav_topic";
            String value ="hello_world "+i;
            String key = "id_"+i;
            logger.info("Key : "+key);
            ProducerRecord<String,String> producerRecord = new ProducerRecord<String, String>(topic,key,value);

            producer.send(producerRecord, new Callback() {
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if (e ==null){
                        logger.info("Recieved new metadata \n" +
                                "Topic "+ recordMetadata.topic()+ "\n" +
                                "Partition "+ recordMetadata.partition() +"\n" +
                                "Offset "+ recordMetadata.offset()+ "\n" +
                                "TimeStamp "+ recordMetadata.timestamp()+"\n"
                                );
                    }else{
                        logger.error("Error  {}",e);
                    }

                }
            }).get();
            producer.flush();

        }
    }
}
