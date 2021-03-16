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

    @Test
    public void resule(){
        int n = 2;
        int a[] = new int[n];
        for (int k = 0; k < n ; k++) {
            a[k] = 0;
        }
        int i = 0,call_n = 0,out_n = 0;
        while (true){
            if (a[i] == 0){
                if (out_n == (n-1))
                    break;
                call_n++;
                call_n %= 3;
                if (call_n == 0){
                    a[i] = i;
                    out_n++;
                }
            }
            i++;
            i %= n;
        }
        System.out.println(i+1);
    }
}

