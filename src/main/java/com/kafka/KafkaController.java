package com.kafka;

import com.elasticSearch.Employee;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @Author: xue0601
 * @Date: 2019-09-04 10:59
 */
@RestController
public class KafkaController {
    private static Logger logger = LoggerFactory.getLogger(KafkaController.class);
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private Gson gson = new GsonBuilder().create();
    @GetMapping("/kafka")
    public String testKafka() {

        Employee employee = new Employee();
        employee.setAbout("234234");
        employee.setAge(18);
        employee.setFirstName("spring");
        kafkaTemplate.send("test",gson.toJson(employee));
        int iMax = 5;
        for (int i = 1; i < iMax; i++) {
            kafkaTemplate.send("test","key" + i, "data" + i);
        }
        return "success";
    }

    @KafkaListener(topics = "test")
    public void receive(ConsumerRecord<?, ?> consumer) {
        //        logger.info("{} - {}:{}", consumer.topic(), consumer.key(), consumer.value());
        Optional<?> kafkaMessage = Optional.ofNullable(consumer.value());

        if (kafkaMessage.isPresent()) {

            Object message = kafkaMessage.get();
            System.out.println("----------------- record =" + consumer);
            System.out.println("------------------ message =" + message);

        }
    }
}
