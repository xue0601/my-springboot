package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@ServletComponentScan
@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@EnableCaching
@MapperScan({"com.ylyw.master.dao","com.ylyw.slaver.dao"})
//@SpringBootApplication(exclude = {
//		DataSourceAutoConfiguration.class
//})
public class MySpringbootApplication {


	public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
		ConfigurableApplicationContext context = SpringApplication.run(MySpringbootApplication.class, args);
//		KafkaSender sender = context.getBean(KafkaSender.class);
//
//		for (int i = 0; i < 3; i++) {
//			//调用消息发送类中的消息发送方法
//			sender.send();
//
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
	}
}
