package com.algorithm;

/**
 * 分木块(给定一个数组,要求切不少于n份,每份最长多少)
 * @Author: xue0601
 * @Date: 2021-03-03 13:55
 */
public class WoodCut {

    public static void main(String[] args) {
        int[] l = {232,124,240,36};
        System.out.println(new WoodCut().woodCut(l,7));
//        System.out.println(new WoodCut().getMax(l));
    }

    public int woodCut(int[] L,int k){
        if (L == null || L.length ==0){
            return 0;
        }
        int start = 1;
        int end = getMax(L);
        int mid;
        while (start + 1 < end){
            mid = start + (end - start) / 2;
            int pieces = getPieces(L,mid);
            if (pieces >= k){
                start = mid;
            } else {
                end = mid;
            }
        }
        if (getPieces(L,end) >= k){
            return end;
        }
        if (getPieces(L,start) >= k){
            return start;
        }
        return 0;
    }

    private int getPieces(int[] l, int mid) {
        int pieces = 0;
        for (int wood : l){
            pieces += wood/mid;
        }
        return pieces;
    }

    private int getMax(int[] l) {
        int max = l[0];
        for (int i = 1; i < l.length; i++) {
            if (max < l[i]){
                max = l[i];
            }
        }
        return max;
    }

}
