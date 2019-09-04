package com.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: xue0601
 * @Date: 2019/7/8 15:24
 */
@RestController
@RequestMapping(value = "http")
public class HttpUtil {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @GetMapping(value = "test")
    public void http(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = "http://192.168.20.234/hello";
        ResponseEntity<String> responseEntity =  restTemplate.getForEntity(url,String.class);
        System.out.println(responseEntity.toString());
        System.out.println(responseEntity.getStatusCode());
        System.out.println(responseEntity.getBody());
    }

}
