package com.algorithm;


/**
 * 动态规划
 */
public class DynamicProgramming {

    //递归
    public int climbStairs1(int i){
        if (i <= 3){
            return i;
        }
        return climbStairs(i-1) + climbStairs( i- 2);
    }

    //爬楼梯算法
    public int climbStairs(int i){
        if (i <= 3){
            return i;
        }
        int [] steps = new int[i+1];
        steps[1] = 1;
        steps[2] = 2;
        for (int j = 3; j <= i; j++) {
            steps[j] = steps[j-1] + steps[j-2];
        }
        return steps[i];
    }

    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        System.out.println(start);
        if (new DynamicProgramming().climbStairs1(45)>0){
            Long end = System.currentTimeMillis();
            System.out.println(end);
            System.out.println(end - start);
        }
    }

}
