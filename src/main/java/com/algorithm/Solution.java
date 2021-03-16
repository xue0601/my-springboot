package com.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 *  无重复字符串最长子串
 *  给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 * @Author: xue0601
 * @Date: 2021-03-16 9:50
 */
public class Solution {

    public static void main(String[] args) {
//        String s = "sdfgerdasdfda";
        String s = "pwwkew";
        int max = lengthOfLongestSubstring(s);
        System.out.println(max);
    }

    public static int lengthOfLongestSubstring(String s){
        if (s == null || s.length() == 0){
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int max = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            while (right < s.length() && !set.contains(s.charAt(right))){
                set.add(s.charAt(right++));
                max = Math.max(max, set.size());
            }
            set.remove(s.charAt(i));
        }
        return max;
    }

}
