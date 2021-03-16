package com.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author: xue0601
 * @Date: 2020-09-18 16:19
 */
public class TestCollection {

    public static void main(String[] args) {
        filter();
    }


    /**
     * flatMap 把 input Stream 中的层级结构扁平化，
     * 就是将最底层元素抽出来放到一起，最终 output
     * 的新 Stream 里面已经没有 List 了，都是直接的数字。
     */
    public static void flatMap(){
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        Stream<Integer> outputStream = inputStream.
                flatMap((childList) -> childList.stream());
    }

    public static void filter(){
        Integer[] sixNums = {1, 2, 3, 4, 5, 6,8,11,12};
        Integer[] evens = Stream.of(sixNums).filter(n -> n%2 == 0).toArray(Integer[]::new);
        Stream.of(evens).collect(Collectors.toList()).forEach(System.out :: println);
    }

    public static void map(){
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> squareNums = nums.stream().
                map(n -> n * n).
                collect(Collectors.toList());
        for (int i = 0; i < squareNums.size(); i++) {
            System.out.println(squareNums.get(i));
        }
    }

}
