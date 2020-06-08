package com.pourush.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

/**
 * Created by pourush.sinha on 11/05/19.
 */
public class ConsumerDemoWithThreads {

    public static void main(String[] args) {
        new ConsumerDemoWithThreads().run();


        }

        public ConsumerDemoWithThreads(){

    }
    private void run(){
        String bootrstrapServers = "127.0.0.1:9092";
        String groupId = "my-sixth-application";
        String topic ="utsav_topic";
        Logger logger = LoggerFactory.getLogger(ConsumerDemoWithThreads.class.getName());
        CountDownLatch latch = new CountDownLatch(1);
        Runnable myConsumerthread = new ConsumerThreads(latch,bootrstrapServers,groupId,topic);
        Thread myThread = new Thread(myConsumerthread);
        myConsumerthread.run();

        try{
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public class ConsumerThreads implements Runnable{
        private CountDownLatch latch;
        private KafkaConsumer<String ,String> consumer;


        public ConsumerThreads(CountDownLatch latch, String bootstrapServers,String groupId ,String topic){
            this.latch = latch;
            Properties properties = new Properties();
            properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
            properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
            properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
            properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
            properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG,groupId);
            consumer = new KafkaConsumer<String, String>(properties);
            consumer.subscribe(Arrays.asList(topic));
        }

        @Override
        public void run() {
            try {
                while (true) {
                    ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                    for (ConsumerRecord<String, String> record : records) {
                        System.out.println("Key :" + record.key() + " value: " + record.value());
                        System.out.println("Partition :" + record.partition() + " Offset: " + record.offset());
                    }

                }
            }catch (WakeupException e){
                System.out.println("Received shutdown signal!");
            }finally {
                consumer.close();
            }
        }
        public void shutDown(){
            consumer.wakeup();

        }
    }
}


