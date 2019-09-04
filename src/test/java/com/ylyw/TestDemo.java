package com.ylyw;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: xue0601
 * @Date: 2019/3/25 9:11
 */
public class TestDemo {

    public static void main(String[] args) {
        Map map = new LinkedHashMap();
        map.put("1", 2);
        map.put("2", 4);
        map.put("3", 6);
        map.put("4", 8);
        map.put("5", 10);
        Set keyset = map.keySet();
        Iterator it = keyset.iterator();
        while (it.hasNext()) {
            Object key = it.next();
            Object value = map.get(key);

            System.out.println(key + "=====" + value);
        }

    }

    @Test
    public void testByte() {
        int[] a = {1, 1, 1};
        int[] b = a;
        for (int i = 0; i < b.length; i++) {
            b[i]++;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }

}

