package com.algorithm;


/**
 * 选择排序
 * @Author: xue0601
 * @Date: 2019/4/9 13:50
 */
public class SelectSort {

    //从数组中找一个最大/最小值,然后在剩余的数组中依次操作直到遍历结束.
    public static void selectSort(int [] a,int b){
        int x,y,z;
        for (x = 0; x <b-1 ; x++) {
            z=x;
            for (y= x+1; y < b; y++) {
                //关键点,小于号是从大到小排,大于号是从小到大排.
                if (a[z]<a[y]){
                    z=y;
                }
            }
            if (x != z){
                int tmp = a[x];
                a[x] = a[z];
                a[z] = tmp;
            }
        }

    }

    public static void main(String[] args) {
        int[]a = {10,20,5,6,99,50,30,40};
        selectSort(a,a.length);
        for (int j = 0; j <a.length ; j++) {
            System.out.println(a[j]);
        }
    }

}
