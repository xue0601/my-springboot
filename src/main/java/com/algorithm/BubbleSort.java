package com.algorithm;

/**
 * @Author: xue0601
 * @Date: 2019/3/22 10:42
 */
public class BubbleSort {

    public static void main(String[] args) {
        int [] a = {3,43,55,56,1,34,53};
        int b = a.length;
        for (int i = 0; i < b ; i++) {
            for (int j = 0; j <b-1 ; j++) {
                if (a[i]<a[j]){
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }

    }

}
