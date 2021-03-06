package com.wxgzh;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @Author: xue0601
 * @Date: 2019/4/25 10:47
 */
@RestController
@RequestMapping(value = "wxpublic")
public class Signature {

    private final static String TOKEN = "663654148";

    @GetMapping(value = "verify_wx_token")
    public String signature(@RequestParam String signature, @RequestParam String timestamp,
                            @RequestParam String nonce, @RequestParam String echostr){

        System.out.println("wx-token校验接口："+signature+"，"+timestamp+","+nonce+","+echostr);
        String[] strings = new String[]{TOKEN,timestamp,nonce};
        StringBuilder builder = new StringBuilder();
        Arrays.sort(strings);
        for (int i=0;i<strings.length;i++){
            builder.append(strings[i]);
        }
        String res = sha1(builder.toString());
        System.out.println("加密后："+res);
        if(signature.equalsIgnoreCase(res)){
            System.out.println("成功!");
            return echostr;
        }
        System.out.println("失败!");
        return "";
    }
    private String sha1(String str){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            byte[] bytes = digest.digest(str.getBytes());
            return toHex(bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
    private String toHex(byte[] bytes){
        String str = "";
        for(byte b : bytes){
            char[] chars = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
            char[] temp = new char[2];
            temp[0] = chars[(b>>>4)&0x0F];
            temp[1] = chars[b&0x0F];

            str += new String(temp);
        }
        return str;
    }

}
