package com.quartz;

import com.webSocket.ServerMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * @program: my-springboot
 * @description:    定时器
 * @author: Xue0601
 * @create: 2018-12-25 16:54
 **/
@Slf4j
@Component
public class TaskServiceImpl {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    //TODO 使用websocket 订阅并定时推送使用下面代码
//    @Scheduled(cron="0/10 * *  * * ? ")
//    public void selectCurDayDepotOrderInfo() {
//        log.info("=====================AAA频道每10秒执行一次刷新=====================");
//        simpMessagingTemplate.convertAndSend("/topic/subscribeTest", new ServerMessage("AAA频道十秒执行一次"));
//    }
//
//    @Scheduled(cron="0/13 * *  * * ? ")
//    public void selectCustomerOrderInfo() {
//        log.info("=====================BBB频道每13秒执行一次刷新=====================");
//        simpMessagingTemplate.convertAndSend("/topic/subscribeTest", new ServerMessage("BBB频道十三秒执行一次"));
//    }


}