package com.collection;

import java.util.Stack;

/**
 * 一个数组任意连续数组合,获取组合中最小数乘以组合相加和的值最大
 * @Author: xue0601
 * @Date: 2021-03-02 10:34
 */
public class StackByte {

    public static void main(String[] args) {
//        int[] numbers = { 2,3,5,4,1};
//        System.out.println(getMax(numbers));

        int start = -3;
        int end = 0;
        System.out.println(start + (end - start) / 2);
        System.out.println((start + end) / 2);
    }
    public static int getMax(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int[] sum = new int[numbers.length + 1];
        //获取区间和数组
        for (int i = 1; i < numbers.length; i++) {
            sum[i] = sum[i - 1] + numbers[i - 1];
        }
        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[i] < numbers[stack.peek()]) {
                int index = stack.pop();
                int left = i;
                int right = i;
                if (stack.isEmpty()) {
                    left = 0;
                } else {
                    left = index;
                }
                //获取最大值
                max = Math.max(max, numbers[index] * (sum[right] - sum[left]));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            int left = numbers.length;
            int right = numbers.length;
            if (stack.isEmpty()) {
                left = 0;
            } else {
                left = index;
            }
            max = Math.max(max, numbers[index] * (sum[right] - sum[left]));
        }
        return max;
    }


}
