package com.algorithm;

/**
 * 插入排序
 * @Author: xue0601
 * @Date: 2019/4/9 14:24
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] a = {23, 113, 55, 29, 173, 11, 65};
        insertSort(a, a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void insertSort(int[] a, int b) {
        int x, y, z;
        for (x = 1; x < b; x++) {
            for (y = x - 1; y >= 0; y--){
                if (a[y] < a[x]){
                    break;
                }
            }
            if (y != x - 1) {
                int tmp = a[x];
                for (z = x - 1; z > y; z--) {
                    a[z + 1] = a[z];
                }
                a[z + 1] = tmp;
            }
        }

    }
}
