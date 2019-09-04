package com.algorithm;

/**
 * @Author: xue0601
 * @Date: 2019/4/9 17:35
 */
public class QuickSort {

    public static void quickSort(int[] a,int l,int r){
        if (l<r){
            int x,y,z;
            x=l;
            y=r;
            z=a[l];
            while (x<y){
                while (x<y && a[y]>z){
                    y--;
                }
                if (x<y){
                    a[x] = a[y];
                }
                while (x<y && a[x]<z){
                    x++;
                }
                if (x<y){
                    a[y] = a[x];
                }

            }
            a[y] = z;
            quickSort(a,l,x-1);
            quickSort(a,x+1,r);
        }
    }

    public static int partition(int []array,int lo,int hi){
        //固定的切分方式
        int key=array[lo];
        while(lo<hi){
            while(array[hi]>=key&&hi>lo){//从后半部分向前扫描
                hi--;
            }
            array[lo]=array[hi];
            while(array[lo]<=key&&hi>lo){//从前半部分向后扫描
                lo++;
            }
            array[hi]=array[lo];
        }
        array[hi]=key;
        return hi;
    }

    public static void sort(int[] array,int lo ,int hi){
        if(lo>=hi){
            return ;
        }
        int index=partition(array,lo,hi);
        sort(array,lo,index-1);
        sort(array,index+1,hi);
    }

    public static void main(String[] args) {
        int i;
        int a[] = {30, 40, 60, 10, 20, 70,90,80,100,140,110,130,50};

        System.out.printf("before sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        quickSort(a, 0, a.length - 1);

        System.out.printf("after  sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }

}
