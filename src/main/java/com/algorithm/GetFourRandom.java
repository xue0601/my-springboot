package com.algorithm;

import java.util.Random;

/**
 * 获取四个不重复随机数
 * @Author: xue0601
 * @Date: 2019/4/9 10:17
 */
public class GetFourRandom {

    public static void main(String[] args) {
        Random random = new Random();
        int tag[] = {0,0,0,0,0,0,0,0,0,0};
        String four = "";
        int temp = 0;
        while (four.length()!=10){
            temp = random.nextInt(4);
            if (tag[temp]==0){
                four+=temp;
                tag[temp] = 2;
            }
        }
            System.out.println(four);
    }

}
