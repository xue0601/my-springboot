package com.algorithm;

/**
 * 二分查找
 * @Author: xue0601
 * @Date: 2021-03-03 11:21
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arrs = {22,25,46,57,66,78};
        System.out.println(binarySearch(arrs,78));
    }

    public static int binarySearch(int[] arrs, int result){
        if (arrs == null || arrs.length ==0){
            return -1;
        }
        int start = 0;
        int end = arrs.length-1;
        int mid ;
        while (start +1 < end){
            mid = start + (end - start)/2;
            if (arrs[mid]> result){
                end = mid;
            }else if (arrs[mid] < result){
                start = mid;
            }else {
                return mid;
            }
        }
        if (arrs[start] == result){
            return start;
        }
        if (arrs[end] == result){
            return end;
        }
        return  -1;
    }

}
